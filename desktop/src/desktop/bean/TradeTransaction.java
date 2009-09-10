/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop.bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Gao.chao.wei
 */
@Entity
@Table(name = "TRADE_TRANSACTION", catalog = "", schema = "ROOT")
@NamedQueries({@NamedQuery(name = "TradeTransaction.findAll", query = "SELECT t FROM TradeTransaction t"), @NamedQuery(name = "TradeTransaction.findById", query = "SELECT t FROM TradeTransaction t WHERE t.id = :id"), @NamedQuery(name = "TradeTransaction.findByTransactionDate", query = "SELECT t FROM TradeTransaction t WHERE t.transactionDate = :transactionDate"), @NamedQuery(name = "TradeTransaction.findByTransactionType", query = "SELECT t FROM TradeTransaction t WHERE t.transactionType = :transactionType"), @NamedQuery(name = "TradeTransaction.findByStock", query = "SELECT t FROM TradeTransaction t WHERE t.stock = :stock"), @NamedQuery(name = "TradeTransaction.findByQuantity", query = "SELECT t FROM TradeTransaction t WHERE t.quantity = :quantity"), @NamedQuery(name = "TradeTransaction.findByPrice", query = "SELECT t FROM TradeTransaction t WHERE t.price = :price"), @NamedQuery(name = "TradeTransaction.findByComission", query = "SELECT t FROM TradeTransaction t WHERE t.comission = :comission"), @NamedQuery(name = "TradeTransaction.findByRemark", query = "SELECT t FROM TradeTransaction t WHERE t.remark = :remark")})
public class TradeTransaction implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "TRANSACTION_DATE")
    @Temporal(TemporalType.DATE)
    private Date transactionDate;
    @Column(name = "TRANSACTION_TYPE")
    private Integer transactionType;
    @Column(name = "STOCK")
    private String stock;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "COMISSION")
    private Double comission;
    @Column(name = "REMARK")
    private String remark;
    @OneToMany(mappedBy = "closeTransaction")
    private List<TradeTransactionClose> tradeTransactionCloseList;
    @OneToMany(mappedBy = "mainTransaction")
    private List<TradeTransactionClose> tradeTransactionCloseByList;

    public TradeTransaction() {
    }

    public TradeTransaction(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        Date oldTransactionDate = this.transactionDate;
        this.transactionDate = transactionDate;
        changeSupport.firePropertyChange("transactionDate", oldTransactionDate, transactionDate);
    }

    public Integer getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Integer transactionType) {
        Integer oldTransactionType = this.transactionType;
        this.transactionType = transactionType;
        changeSupport.firePropertyChange("transactionType", oldTransactionType, transactionType);
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        String oldStock = this.stock;
        this.stock = stock;
        changeSupport.firePropertyChange("stock", oldStock, stock);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        Integer oldQuantity = this.quantity;
        this.quantity = quantity;
        changeSupport.firePropertyChange("quantity", oldQuantity, quantity);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        Double oldPrice = this.price;
        this.price = price;
        changeSupport.firePropertyChange("price", oldPrice, price);
    }

    public Double getComission() {
        return comission;
    }

    public void setComission(Double comission) {
        Double oldComission = this.comission;
        this.comission = comission;
        changeSupport.firePropertyChange("comission", oldComission, comission);
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        String oldRemark = this.remark;
        this.remark = remark;
        changeSupport.firePropertyChange("remark", oldRemark, remark);
    }

    public List<TradeTransactionClose> getTradeTransactionCloseList() {
        return tradeTransactionCloseList;
    }

    public void setTradeTransactionCloseList(List<TradeTransactionClose> tradeTransactionCloseList) {
        this.tradeTransactionCloseList = tradeTransactionCloseList;
    }

    public List<TradeTransactionClose> getTradeTransactionCloseByList() {
        return tradeTransactionCloseByList;
    }

    public void setTradeTransactionCloseByList(List<TradeTransactionClose> tradeTransactionCloseByList) {
        this.tradeTransactionCloseByList = tradeTransactionCloseByList;
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
        if (!(object instanceof TradeTransaction)) {
            return false;
        }
        TradeTransaction other = (TradeTransaction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "desktop.TradeTransaction[id=" + id + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}
