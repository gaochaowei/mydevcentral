/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop.bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Gao.chao.wei
 */
@Entity
@Table(name = "TRADE_TRANSACTION_RELATION", catalog = "", schema = "ROOT")
@NamedQueries({@NamedQuery(name = "TradeTransactionRelation.findAll", query = "SELECT t FROM TradeTransactionRelation t"), @NamedQuery(name = "TradeTransactionRelation.findByOpenTransaction", query = "SELECT t FROM TradeTransactionRelation t WHERE t.tradeTransactionRelationPK.openTransaction = :openTransaction"), @NamedQuery(name = "TradeTransactionRelation.findByCloseTransaction", query = "SELECT t FROM TradeTransactionRelation t WHERE t.tradeTransactionRelationPK.closeTransaction = :closeTransaction"), @NamedQuery(name = "TradeTransactionRelation.findByQuantity", query = "SELECT t FROM TradeTransactionRelation t WHERE t.quantity = :quantity")})
public class TradeTransactionRelation implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TradeTransactionRelationPK tradeTransactionRelationPK;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @JoinColumn(name = "CLOSE_TRANSACTION", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TradeTransaction openTransaction;
    @JoinColumn(name = "OPEN_TRANSACTION", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TradeTransaction closeTransaction;

    public TradeTransactionRelation() {
    }

    public TradeTransactionRelation(TradeTransactionRelationPK tradeTransactionRelationPK) {
        this.tradeTransactionRelationPK = tradeTransactionRelationPK;
    }

    public TradeTransactionRelation(int openTransaction, int closeTransaction) {
        this.tradeTransactionRelationPK = new TradeTransactionRelationPK(openTransaction, closeTransaction);
    }

    public TradeTransactionRelationPK getTradeTransactionRelationPK() {
        return tradeTransactionRelationPK;
    }

    public void setTradeTransactionRelationPK(TradeTransactionRelationPK tradeTransactionRelationPK) {
        this.tradeTransactionRelationPK = tradeTransactionRelationPK;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        Integer oldQuantity = this.quantity;
        this.quantity = quantity;
        changeSupport.firePropertyChange("quantity", oldQuantity, quantity);
    }

    public TradeTransaction getCloseTransaction() {
        return closeTransaction;
    }

    public void setCloseTransaction(TradeTransaction closeTransaction) {
        TradeTransaction oldTradeTransaction = this.closeTransaction;
        this.closeTransaction = closeTransaction;
        changeSupport.firePropertyChange("closeTransaction", oldTradeTransaction, closeTransaction);
    }

    public TradeTransaction getOpenTransaction() {
        return openTransaction;
    }

    public void setOpenTransaction(TradeTransaction openTransaction) {
        TradeTransaction oldTradeTransaction1 = this.openTransaction;
        this.openTransaction = openTransaction;
        changeSupport.firePropertyChange("openTransaction", oldTradeTransaction1, openTransaction);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tradeTransactionRelationPK != null ? tradeTransactionRelationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TradeTransactionRelation)) {
            return false;
        }
        TradeTransactionRelation other = (TradeTransactionRelation) object;
        if ((this.tradeTransactionRelationPK == null && other.tradeTransactionRelationPK != null) || (this.tradeTransactionRelationPK != null && !this.tradeTransactionRelationPK.equals(other.tradeTransactionRelationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "desktop.TradeTransactionRelation[tradeTransactionRelationPK=" + tradeTransactionRelationPK + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}
