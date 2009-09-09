/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package desktop.bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Gao.chao.wei
 */
@Entity
@Table(name = "STOCK_POSITION")
@NamedQueries({@NamedQuery(name = "StockPosition.findAll", query = "SELECT s FROM StockPosition s"), @NamedQuery(name = "StockPosition.findById", query = "SELECT s FROM StockPosition s WHERE s.id = :id"), @NamedQuery(name = "StockPosition.findByQuantity", query = "SELECT s FROM StockPosition s WHERE s.quantity = :quantity"), @NamedQuery(name = "StockPosition.findByPricePaid", query = "SELECT s FROM StockPosition s WHERE s.pricePaid = :pricePaid"), @NamedQuery(name = "StockPosition.findByBuyDate", query = "SELECT s FROM StockPosition s WHERE s.buyDate = :buyDate"), @NamedQuery(name = "StockPosition.findByComission", query = "SELECT s FROM StockPosition s WHERE s.comission = :comission")})
public class StockPosition implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Column(name = "PRICE_PAID")
    private Double pricePaid;
    @Column(name = "BUY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date buyDate;
    @Column(name = "COMISSION")
    private Double comission;
    @JoinColumn(name = "PORTFOLIO", referencedColumnName = "ID")
    @ManyToOne
    private Portfolio portfolio;
    @ManyToOne
    @JoinColumn(name = "STOCK", referencedColumnName = "SYMBOL")
    private Stock stock;

    public StockPosition() {
    }

    public StockPosition(Integer id) {
        this.id = id;
    }

    public StockPosition(Integer id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        Integer oldQuantity = this.quantity;
        this.quantity = quantity;
        changeSupport.firePropertyChange("quantity", oldQuantity, quantity);
    }

    public Double getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(Double pricePaid) {
        Double oldPricePaid = this.pricePaid;
        this.pricePaid = pricePaid;
        changeSupport.firePropertyChange("pricePaid", oldPricePaid, pricePaid);
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        System.out.println("setBuyDate "+buyDate+" "+buyDate.getClass());
        Date oldBuyDate = this.buyDate;
        this.buyDate = buyDate;
        changeSupport.firePropertyChange("buyDate", oldBuyDate, buyDate);
    }

    public Double getComission() {
        return comission;
    }

    public void setComission(Double comission) {
        Double oldComission = this.comission;
        this.comission = comission;
        changeSupport.firePropertyChange("comission", oldComission, comission);
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        Portfolio oldPortfolio = this.portfolio;
        this.portfolio = portfolio;
        changeSupport.firePropertyChange("portfolio", oldPortfolio, portfolio);
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        Stock oldStock = this.stock;
        this.stock = stock;
        changeSupport.firePropertyChange("stock", oldStock, stock);
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
        if (!(object instanceof StockPosition)) {
            return false;
        }
        StockPosition other = (StockPosition) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "desktop.bean.StockPosition[id=" + id + "]";
        return "[id=" + id + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
