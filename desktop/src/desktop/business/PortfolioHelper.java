/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop.business;

import desktop.bean.Portfolio;
import desktop.bean.StockPosition;
import desktop.bean.TradeTransaction;
import desktop.bean.TradeTransactionClose;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gao.chao.wei
 */
public class PortfolioHelper {

    private Portfolio portfolio;

    public PortfolioHelper(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public List<StockPosition> computePosition() {
        List<StockPosition> openList = new ArrayList<StockPosition>();
        List<StockPosition> closeList = new ArrayList<StockPosition>();
        List<TradeTransaction> transactionList = portfolio.getTradeTransactionList();
        Map<TradeTransaction, Integer> closeQuantityMap = new HashMap<TradeTransaction, Integer>();

        //compute closed amount for each transaction and generate close transaction list
        for (TradeTransaction t : transactionList) {
            int closeQuantity = 0;
            for (TradeTransactionClose c : t.getTradeTransactionCloseByList()) {
                int subCloseQuantity = c.getQuantity();
                TradeTransaction tc = c.getCloseTransaction();
                System.out.println(t.getId() + " -> " + tc.getId() + " -> " + subCloseQuantity);
                StockPosition p = openPosition(t);
                closePosition(p, tc, subCloseQuantity);
                closeList.add(p);
                closeQuantity += subCloseQuantity;
                if (closeQuantityMap.containsKey(tc)) {
                    closeQuantityMap.put(tc, closeQuantityMap.get(tc) + subCloseQuantity);
                } else {
                    closeQuantityMap.put(tc, subCloseQuantity);
                }
            }
            if (closeQuantityMap.containsKey(t)) {
                closeQuantityMap.put(t, closeQuantityMap.get(t) + closeQuantity);
            } else {
                closeQuantityMap.put(t, closeQuantity);
            }
        }
        //generate the open position after transaction close
        for (TradeTransaction t : transactionList) {
            int closeQuantity = closeQuantityMap.containsKey(t) ? closeQuantityMap.get(t) : 0;
            int openQuantity = t.getQuantity() - closeQuantity;
            if (openQuantity != 0) {
                StockPosition p = openPosition(t);
                p.setQuantity(openQuantity);
                openList.add(p);
            }
        }
        return openList;
    }

    private void closePosition(StockPosition p, TradeTransaction t, int quantity) {
        p.setCloseDate(t.getTransactionDate());
        p.setClosePrice(t.getPrice());
        p.setQuantity(quantity);
    }

    private StockPosition openPosition(TradeTransaction t) {
        StockPosition p = new StockPosition();
        p.setStock(t.getStock());
        p.setQuantity(t.getQuantity());
        p.setStartPrice(t.getPrice());
        p.setStartDate(t.getTransactionDate());
        return p;
    }

    private List<TradeTransaction> sortTransactionList() {
        List<TradeTransaction> transactionList = new ArrayList<TradeTransaction>();
        for (TradeTransaction t : portfolio.getTradeTransactionList()) {
            transactionList.add(t);
        }
        for (int i = 0; i < transactionList.size(); i++) {
            TradeTransaction ti = transactionList.get(i);
            for (int j = 0; j < i; j++) {
                TradeTransaction tj = transactionList.get(j);
                if (compare(ti, tj) < 0) {
                    transactionList.remove(ti);
                    transactionList.add(j, ti);
                }
            }

        }
        return transactionList;
    }

    private int compare(TradeTransaction t1, TradeTransaction t2) {
        if (t1.getTransactionDate().before(t2.getTransactionDate())) {
            return 1;
        }
        if (t1.getTransactionDate().after(t2.getTransactionDate())) {
            return -1;
        }
        if (t1.getTradeTransactionCloseList().contains(t2)) {
            return 1;
        }
        if (t2.getTradeTransactionCloseList().contains(t1)) {
            return -1;
        }
        return t1.getStock().getSymbol().compareTo(t2.getStock().getSymbol());
    }
}
