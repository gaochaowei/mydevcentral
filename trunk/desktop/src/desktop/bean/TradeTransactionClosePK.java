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
public class TradeTransactionClosePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "MAIN_TRANSACTION")
    private int mainTransaction;
    @Basic(optional = false)
    @Column(name = "CLOSE_TRANSACTION")
    private int closeTransaction;

    public TradeTransactionClosePK() {
    }

    public TradeTransactionClosePK(int mainTransaction, int closeTransaction) {
        this.mainTransaction = mainTransaction;
        this.closeTransaction = closeTransaction;
    }

    public int getMainTransaction() {
        return mainTransaction;
    }

    public void setMainTransaction(int mainTransaction) {
        this.mainTransaction = mainTransaction;
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
        hash += (int) mainTransaction;
        hash += (int) closeTransaction;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TradeTransactionClosePK)) {
            return false;
        }
        TradeTransactionClosePK other = (TradeTransactionClosePK) object;
        if (this.mainTransaction != other.mainTransaction) {
            return false;
        }
        if (this.closeTransaction != other.closeTransaction) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "desktop.TradeTransactionClosePK[mainTransaction=" + mainTransaction + ", closeTransaction=" + closeTransaction + "]";
    }

}
