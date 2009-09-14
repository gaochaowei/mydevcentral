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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gao.chao.wei
 */
public class PortfolioHelper {

    private Portfolio portfolio;
    private List<StockPosition> openPositionList = new ArrayList<StockPosition>();
    private List<StockPosition> closePositionList = new ArrayList<StockPosition>();

    public PortfolioHelper(Portfolio portfolio) {
        setPortfolio(portfolio);
        compute();
    }

    private void compute() {
        List<TradeTransaction> transactionList = getPortfolio().getTradeTransactionList();
        Map<TradeTransaction, Integer> closeQuantityMap = new HashMap<TradeTransaction, Integer>();
        //compute closed amount for each transaction and generate close transaction list
        for (TradeTransaction t : transactionList) {
            int closeQuantity = 0;
            for (TradeTransactionRelation c : t.getCloseTradeTransactionList()) {
                int subCloseQuantity = c.getQuantity();
                TradeTransaction tc = c.getOpenTransaction();
                StockPosition p = openPosition(t);
                closePosition(p, tc, subCloseQuantity);
                getClosePositionList().add(p);
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
                getOpenPositionList().add(p);
            }
        }
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

    /**
     * @return the portfolio
     */
    public Portfolio getPortfolio() {
        return portfolio;
    }

    /**
     * @param portfolio the portfolio to set
     */
    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    /**
     * @return the openPositionList
     */
    public List<StockPosition> getOpenPositionList() {
        return openPositionList;
    }

    /**
     * @param openPositionList the openPositionList to set
     */
    public void setOpenPositionList(List<StockPosition> openPositionList) {
        this.openPositionList = openPositionList;
    }

    /**
     * @return the closePositionList
     */
    public List<StockPosition> getClosePositionList() {
        return closePositionList;
    }

    /**
     * @param closePositionList the closePositionList to set
     */
    public void setClosePositionList(List<StockPosition> closePositionList) {
        this.closePositionList = closePositionList;
    }
}
