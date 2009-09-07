/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package desktop.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author sweet99
 */
@Entity
@Table(name = "STOCK_ORDER")
@NamedQueries({@NamedQuery(name = "StockOrder.findAll", query = "SELECT s FROM StockOrder s"), @NamedQuery(name = "StockOrder.findById", query = "SELECT s FROM StockOrder s WHERE s.id = :id"), @NamedQuery(name = "StockOrder.findByName", query = "SELECT s FROM StockOrder s WHERE s.name = :name"), @NamedQuery(name = "StockOrder.findByOrderType", query = "SELECT s FROM StockOrder s WHERE s.orderType = :orderType"), @NamedQuery(name = "StockOrder.findByStockSymbol", query = "SELECT s FROM StockOrder s WHERE s.stockSymbol = :stockSymbol"), @NamedQuery(name = "StockOrder.findByQuantity", query = "SELECT s FROM StockOrder s WHERE s.quantity = :quantity"), @NamedQuery(name = "StockOrder.findByPrice", query = "SELECT s FROM StockOrder s WHERE s.price = :price"), @NamedQuery(name = "StockOrder.findByOrderTime", query = "SELECT s FROM StockOrder s WHERE s.orderTime = :orderTime"), @NamedQuery(name = "StockOrder.findByRemark", query = "SELECT s FROM StockOrder s WHERE s.remark = :remark")})
public class StockOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "ORDER_TYPE")
    private int orderType;
    @Column(name = "STOCK_SYMBOL")
    private String stockSymbol;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "ORDER_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderTime;
    @Column(name = "REMARK")
    private String remark;

    public StockOrder() {
    }

    public StockOrder(Integer id) {
        this.id = id;
    }

    public StockOrder(Integer id, int orderType) {
        this.id = id;
        this.orderType = orderType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StockOrder)) {
            return false;
        }
        StockOrder other = (StockOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "desktop.bean.StockOrder[id=" + id + "]";
    }

}
