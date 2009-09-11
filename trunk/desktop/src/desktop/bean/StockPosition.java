/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop.bean;

import java.io.Serializable;
import java.util.Date;

public class StockPosition implements Serializable {
    private Integer quantity;
    private Double startPrice;
    private Date startDate;
    private Stock stock;

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

    /**
     * @return the startPrice
     */
    public Double getStartPrice() {
        return startPrice;
    }

    /**
     * @param startPrice the startPrice to set
     */
    public void setStartPrice(Double startPrice) {
        this.startPrice = startPrice;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the stock
     */
    public Stock getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(Stock stock) {
        this.stock = stock;
    }
    
}
