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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TRXN", catalog = "", schema = "ROOT")
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
    @Column(name = "TRXN_DATE")
    @Temporal(TemporalType.DATE)
    private Date transactionDate;
    @Column(name = "TRXN_TYPE_ID")
    private Integer transactionType;
    @ManyToOne
    @JoinColumn(name = "STOCK_SYMBOL", referencedColumnName = "SYMBOL")
    private Stock stock;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "COMISSION")
    private Double comission;
    @Column(name = "REMARK")
    private String remark;
    @ManyToOne
    @JoinColumn(name = "PORTFOLIO_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private Portfolio portfolio;
    @OneToMany(mappedBy = "closeTransaction")
    private List<TradeTransactionRelation> openTradeTransactionRelationList;
    @OneToMany(mappedBy = "openTransaction")
    private List<TradeTransactionRelation> closeTradeTransactionRelationList;

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

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        Stock oldStock = this.stock;
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

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        Portfolio oldPortfolio = this.portfolio;
        this.portfolio = portfolio;
        changeSupport.firePropertyChange("portfolio", oldPortfolio, portfolio);
    }

    public List<TradeTransactionRelation> getOpenTradeTransactionRelationList() {
        return openTradeTransactionRelationList;
    }

    public void setOpenTradeTransactionRelationList(List<TradeTransactionRelation> openTradeTransactionRelationList) {
        this.openTradeTransactionRelationList = openTradeTransactionRelationList;
    }

    public List<TradeTransactionRelation> getCloseTradeTransactionRelationList() {
        return closeTradeTransactionRelationList;
    }

    public void setCloseTradeTransactionRelationList(List<TradeTransactionRelation> closeTradeTransactionRelationList) {
        this.closeTradeTransactionRelationList = closeTradeTransactionRelationList;
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
