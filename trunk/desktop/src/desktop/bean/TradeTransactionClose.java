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
@Table(name = "TRADE_TRANSACTION_CLOSE", catalog = "", schema = "ROOT")
@NamedQueries({@NamedQuery(name = "TradeTransactionClose.findAll", query = "SELECT t FROM TradeTransactionClose t"), @NamedQuery(name = "TradeTransactionClose.findByMainTransaction", query = "SELECT t FROM TradeTransactionClose t WHERE t.tradeTransactionClosePK.mainTransaction = :mainTransaction"), @NamedQuery(name = "TradeTransactionClose.findByCloseTransaction", query = "SELECT t FROM TradeTransactionClose t WHERE t.tradeTransactionClosePK.closeTransaction = :closeTransaction"), @NamedQuery(name = "TradeTransactionClose.findByQuantity", query = "SELECT t FROM TradeTransactionClose t WHERE t.quantity = :quantity")})
public class TradeTransactionClose implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TradeTransactionClosePK tradeTransactionClosePK;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @JoinColumn(name = "CLOSE_TRANSACTION", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TradeTransaction mainTransaction;
    @JoinColumn(name = "MAIN_TRANSACTION", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TradeTransaction closeTransaction;

    public TradeTransactionClose() {
    }

    public TradeTransactionClose(TradeTransactionClosePK tradeTransactionClosePK) {
        this.tradeTransactionClosePK = tradeTransactionClosePK;
    }

    public TradeTransactionClose(int mainTransaction, int closeTransaction) {
        this.tradeTransactionClosePK = new TradeTransactionClosePK(mainTransaction, closeTransaction);
    }

    public TradeTransactionClosePK getTradeTransactionClosePK() {
        return tradeTransactionClosePK;
    }

    public void setTradeTransactionClosePK(TradeTransactionClosePK tradeTransactionClosePK) {
        this.tradeTransactionClosePK = tradeTransactionClosePK;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        Integer oldQuantity = this.quantity;
        this.quantity = quantity;
        changeSupport.firePropertyChange("quantity", oldQuantity, quantity);
    }

    public TradeTransaction getMainTransaction() {
        return mainTransaction;
    }

    public void setMainTransaction(TradeTransaction mainTransaction) {
        TradeTransaction oldTradeTransaction = this.mainTransaction;
        this.mainTransaction = mainTransaction;
        changeSupport.firePropertyChange("mainTransaction", oldTradeTransaction, mainTransaction);
    }

    public TradeTransaction getCloseTransaction() {
        return closeTransaction;
    }

    public void setCloseTransaction(TradeTransaction closeTransaction) {
        TradeTransaction oldTradeTransaction1 = this.closeTransaction;
        this.closeTransaction = closeTransaction;
        changeSupport.firePropertyChange("closeTransaction", oldTradeTransaction1, closeTransaction);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tradeTransactionClosePK != null ? tradeTransactionClosePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TradeTransactionClose)) {
            return false;
        }
        TradeTransactionClose other = (TradeTransactionClose) object;
        if ((this.tradeTransactionClosePK == null && other.tradeTransactionClosePK != null) || (this.tradeTransactionClosePK != null && !this.tradeTransactionClosePK.equals(other.tradeTransactionClosePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "desktop.TradeTransactionClose[tradeTransactionClosePK=" + tradeTransactionClosePK + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
