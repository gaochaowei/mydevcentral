/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop.business;

import desktop.bean.Portfolio;
import desktop.bean.StockPosition;
import desktop.bean.TradeTransaction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gao.chao.wei
 */
public class PortfolioHelper {

    Portfolio portfolio;

    public PortfolioHelper(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public List<StockPosition> computePosition() {
        List<StockPosition> positionList = new ArrayList<StockPosition>();
        List<TradeTransaction> transactionList = sortTransactionList();
        for (TradeTransaction t : transactionList) {
            StockPosition p = new StockPosition();
            p.setQuantity(t.getQuantity());
            p.setStock(t.getStock());
            p.setStartPrice(t.getPrice());
            p.setStartDate(t.getTransactionDate());
            positionList.add(p);
        }
        return positionList;
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
