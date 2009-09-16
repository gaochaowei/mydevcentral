/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop.business;

import desktop.bean.Portfolio;
import desktop.bean.StockPosition;
import desktop.bean.TradeTransaction;
import desktop.bean.TradeTransactionRelation;
import desktop.util.CommonUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gao.chao.wei
 */
public class PortfolioTracker {

    private Map<Date, List<StockPosition>> positionHistory = new HashMap<Date, List<StockPosition>>();
    private PortfolioTracker openPortfolioTrack;
    private PortfolioTracker closePortfolioTrack;

    private PortfolioTracker() {
    }

    public PortfolioTracker(Portfolio portfolio) {
        for (TradeTransaction tx : portfolio.getTradeTransactionList()) {
            addTradeTransaction(tx);
        }
        this.openPortfolioTrack = computeOpenPositionTrack();
        this.closePortfolioTrack = computeClosePositionTrack();
    }

    public PortfolioTracker getOpenPositionTrack() {
        return openPortfolioTrack;
    }

    public List<StockPosition> getClosePositionList() {
        return closePortfolioTrack.getPositionList();
    }

    public List<StockPosition> getClosePositionList(Date date) {
        return closePortfolioTrack.getPositionList(date);
    }

    public List<StockPosition> getOpenPositionList() {
        return openPortfolioTrack.getPositionList();
    }

    public List<StockPosition> getOpenPositionList(Date date) {
        return openPortfolioTrack.getPositionList(date);
    }

    public List<StockPosition> getPositionList() {
        return getPositionList(CommonUtils.today());
    }

    public List<StockPosition> getPositionList(Date date) {
        List<Date> dateList = getDateList();
        for (int i = dateList.size() - 1; i >= 0; i--) {
            if (!dateList.get(i).after(date)) {
                return positionHistory.get(dateList.get(i));
            }
        }
        return new ArrayList<StockPosition>();
    }

    private void addTradeTransaction(TradeTransaction tx) {
        //Add change of closing position
        int closeQuantity = 0;
        for (TradeTransactionRelation otr : tx.getOpenTradeTransactionRelationList()) {
            StockPosition p = new StockPosition();
            p.setOpenTransaction(otr.getOpenTransaction());
            p.setCloseTransaction(otr.getCloseTransaction());
            p.setQuantity(otr.getQuantity());
            addPosition(p);
            closeQuantity += otr.getQuantity();
        }
        //Add change of opening position
        int openQuantity = tx.getQuantity() - closeQuantity;
        if (openQuantity != 0) {
            StockPosition p = new StockPosition();
            p.setOpenTransaction(tx);
            p.setQuantity(openQuantity);
            addPosition(p);
        }
    }

    private void addPosition(Date date, StockPosition p) {
        if (!positionHistory.containsKey(date)) {
            positionHistory.put(date, new ArrayList<StockPosition>());
        }
        positionHistory.get(date).add(p);
    }

    private void addPosition(StockPosition p) {
        if (p.getCloseTransaction() == null) {
            addPosition(p.getOpenTransaction().getTransactionDate(), p);
        } else {
            addPosition(p.getCloseTransaction().getTransactionDate(), p);
        }
    }

    public List<Date> getDateList() {
        List<Date> dateList = new ArrayList();
        dateList.addAll(positionHistory.keySet());
        Collections.sort(dateList);
        return dateList;
    }

    @Override
    public String toString() {
        return positionHistory.toString();
    }

    public PortfolioTracker getPositionTracker(TradeTransaction t) {
        PortfolioTracker tracker = new PortfolioTracker();
        for (List<StockPosition> ps : tracker.positionHistory.values()) {
            for (StockPosition p : ps) {
                if (p.getOpenTransaction().equals(t)) {
                    tracker.addPosition(p);
                }
            }
        }
        return tracker;
    }

    private PortfolioTracker computeClosePositionTrack() {
        PortfolioTracker tracker = new PortfolioTracker();
        for (Date date : getDateList()) {
            List<StockPosition> ps = positionHistory.get(date);
            for (StockPosition p : ps) {
                if (p.getCloseTransaction() != null) {
                    tracker.addPosition(p);
                }
            }
        }
        List<Date> dateList = tracker.getDateList();
        for (int i = 1; i < dateList.size(); i++) {
            tracker.getPositionList(dateList.get(i)).addAll(tracker.getPositionList(dateList.get(i - 1)));
        }
        return tracker;
    }

    private PortfolioTracker computeOpenPositionTrack() {
        PortfolioTracker tracker = new PortfolioTracker();
        Map<TradeTransaction, Integer> txPosition = new HashMap<TradeTransaction, Integer>();
        for (Date date : getDateList()) {
            List<StockPosition> ps = this.positionHistory.get(date);
            for (StockPosition p : ps) {
                int increaseBalance = 0;
                if (p.getCloseTransaction() == null) {
                    //increase position
                    increaseBalance = p.getQuantity();
                } else {
                    //reduce position
                    increaseBalance = -p.getQuantity();
                }
                TradeTransaction t = p.getOpenTransaction();
                if (txPosition.containsKey(t)) {
                    int balance = txPosition.get(t) + increaseBalance;
                    if (balance == 0) {
                        txPosition.remove(t);
                    } else {
                        txPosition.put(t, balance);
                    }
                } else {
                    txPosition.put(t, increaseBalance);
                }
            }
            List<StockPosition> ops = new ArrayList<StockPosition>();
            for (TradeTransaction t : txPosition.keySet()) {
                StockPosition p = new StockPosition();
                p.setOpenTransaction(t);
                p.setQuantity(txPosition.get(t));
                ops.add(p);
            }
            tracker.positionHistory.put(date, ops);
        }
        return tracker;
    }
}

