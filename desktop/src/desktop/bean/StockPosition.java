/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop.bean;

import java.io.Serializable;
import java.util.Date;

public class StockPosition implements Serializable {

    private Stock stock;
    private Integer quantity;
    private Double startPrice;
    private Date startDate;
    private Date closeDate;
    private Double closePrice;

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

    /**
     * @return the closeDate
     */
    public Date getCloseDate() {
        return closeDate;
    }

    /**
     * @param closeDate the closeDate to set
     */
    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    /**
     * @return the closePrice
     */
    public Double getClosePrice() {
        return closePrice;
    }

    /**
     * @param closePrice the closePrice to set
     */
    public void setClosePrice(Double closePrice) {
        this.closePrice = closePrice;
    }
}
