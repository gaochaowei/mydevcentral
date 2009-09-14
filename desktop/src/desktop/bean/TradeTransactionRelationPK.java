/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop.bean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Gao.chao.wei
 */
@Embeddable
public class TradeTransactionRelationPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "OPEN_TRANSACTION")
    private int openTransaction;
    @Basic(optional = false)
    @Column(name = "CLOSE_TRANSACTION")
    private int closeTransaction;

    public TradeTransactionRelationPK() {
    }

    public TradeTransactionRelationPK(int openTransaction, int closeTransaction) {
        this.openTransaction = openTransaction;
        this.closeTransaction = closeTransaction;
    }

    public int getOpenTransaction() {
        return openTransaction;
    }

    public void setOpenTransaction(int openTransaction) {
        this.openTransaction = openTransaction;
    }

    public int getCloseTransaction() {
        return closeTransaction;
    }

    public void setCloseTransaction(int closeTransaction) {
        this.closeTransaction = closeTransaction;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) openTransaction;
        hash += (int) closeTransaction;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TradeTransactionRelationPK)) {
            return false;
        }
        TradeTransactionRelationPK other = (TradeTransactionRelationPK) object;
        if (this.openTransaction != other.openTransaction) {
            return false;
        }
        if (this.closeTransaction != other.closeTransaction) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "desktop.TradeTransactionRelationPK[openTransaction=" + openTransaction + ", closeTransaction=" + closeTransaction + "]";
    }
}
