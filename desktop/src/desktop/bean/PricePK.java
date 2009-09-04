/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package desktop.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Gao.chao.wei
 */
@Embeddable
public class PricePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "STOCK")
    private String stock;
    @Basic(optional = false)
    @Column(name = "PRICE_DATE")
    @Temporal(TemporalType.DATE)
    private Date priceDate;

    public PricePK(String stock, Date priceDate) {
        this.stock = stock;
        this.priceDate = priceDate;
    }

    public PricePK() {
//        throw new UnsupportedOperationException("Not yet implemented");
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Date getPriceDate() {
        return priceDate;
    }

    public void setPriceDate(Date priceDate) {
        this.priceDate = priceDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stock != null ? stock.hashCode() : 0);
        hash += (priceDate != null ? priceDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PricePK)) {
            return false;
        }
        PricePK other = (PricePK) object;
        if ((this.stock == null && other.stock != null) || (this.stock != null && !this.stock.equals(other.stock))) {
            return false;
        }
        if ((this.priceDate == null && other.priceDate != null) || (this.priceDate != null && !this.priceDate.equals(other.priceDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "desktop.bean.PricePK[stock=" + stock + ", priceDate=" + priceDate + "]";
    }

}
