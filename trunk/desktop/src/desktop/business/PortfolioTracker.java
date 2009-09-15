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
                addPosition(positionHistory, p);
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
            addPosition(positionChangeHistory, p);
            closeQuantity += otr.getQuantity();
        }
        int openQuantity = tx.getQuantity() - closeQuantity;
        if (openQuantity != 0) {
            StockPosition p = new StockPosition();
            p.setOpenTransaction(tx);
            p.setQuantity(openQuantity);
            addPosition(positionChangeHistory, p);
        }
    }

    private void addPosition(Map<Date, List<StockPosition>> map, StockPosition p) {
        if (p.getCloseTransaction() == null) {
            addPosition(map, p.getOpenTransaction().getTransactionDate(), p);
        } else {
            addPosition(map, p.getCloseTransaction().getTransactionDate(), p);
        }
    }

    private void addPosition(Map<Date, List<StockPosition>> map, Date date, StockPosition p) {
        if (!map.containsKey(date)) {
            map.put(date, new ArrayList<StockPosition>());
        }
        map.get(date).add(p);
    }
}
