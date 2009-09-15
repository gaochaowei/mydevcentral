/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop.bean;

import java.io.Serializable;

public class StockPosition implements Serializable {

    private TradeTransaction openTransaction;
    private TradeTransaction closeTransaction;
    private Integer quantity;

    /**
     * @return the openTransaction
     */
    public TradeTransaction getOpenTransaction() {
        return openTransaction;
    }

    /**
     * @param openTransaction the openTransaction to set
     */
    public void setOpenTransaction(TradeTransaction openTransaction) {
        this.openTransaction = openTransaction;
    }

    /**
     * @return the closeTransaction
     */
    public TradeTransaction getCloseTransaction() {
        return closeTransaction;
    }

    /**
     * @param closeTransaction the closeTransaction to set
     */
    public void setCloseTransaction(TradeTransaction closeTransaction) {
        this.closeTransaction = closeTransaction;
    }

    /**
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
