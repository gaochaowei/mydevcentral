/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop.business;

import desktop.bean.Portfolio;
import desktop.bean.StockPosition;
import desktop.bean.TradeTransaction;
import desktop.bean.TradeTransactionRelation;
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

    private List<Date> changeDateList = new ArrayList<Date>();
    private Map<Date, List<StockPosition>> positionChangeHistory = new HashMap<Date, List<StockPosition>>();
    private Map<Date, List<StockPosition>> positionHistory = new HashMap<Date, List<StockPosition>>();

    public PortfolioTracker(Portfolio portfolio) {
        for (TradeTransaction tx : portfolio.getTradeTransactionList()) {
            addTradeTransaction(tx);
        }
        changeDateList.addAll(positionChangeHistory.keySet());
        Collections.sort(changeDateList);
        for (Date date : changeDateList) {
            List<StockPosition> ps = positionChangeHistory.get(date);
            for (StockPosition p : ps) {
                if (p.getCloseTransaction() == null) {
                    if (!positionHistory.containsKey(date)) {
                        positionHistory.put(date, new ArrayList<StockPosition>());
                    }
                    positionHistory.get(date).add(p);
                }
            }
        }
    }

    public void addTradeTransaction(TradeTransaction tx) {
        int closeQuantity = 0;
        for (TradeTransactionRelation otr : tx.getOpenTradeTransactionRelationList()) {
            StockPosition p = new StockPosition();
            p.setOpenTransaction(otr.getOpenTransaction());
            p.setCloseTransaction(otr.getCloseTransaction());
            p.setQuantity(otr.getQuantity());
            addPosition(p);
            closeQuantity += otr.getQuantity();
        }
        int openQuantity = tx.getQuantity() - closeQuantity;
        if (openQuantity != 0) {
            StockPosition p = new StockPosition();
            p.setOpenTransaction(tx);
            p.setQuantity(openQuantity);
        }
    }

    private void addPosition(StockPosition p) {
        if (p.getCloseTransaction() == null) {
            addPosition(p.getOpenTransaction().getTransactionDate(), p);
        } else {
            addPosition(p.getCloseTransaction().getTransactionDate(), p);
        }
    }

    private void addPosition(Date date, StockPosition p) {
        if (!positionChangeHistory.containsKey(date)) {
            positionChangeHistory.put(date, new ArrayList<StockPosition>());
        }
        positionChangeHistory.get(date).add(p);
    }
}
