/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package desktop.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Gao.chao.wei
 */
@Entity
@Table(name = "PRICE")
@NamedQueries({@NamedQuery(name = "Price.findAll", query = "SELECT p FROM Price p"), @NamedQuery(name = "Price.findByStock", query = "SELECT p FROM Price p WHERE p.pricePK.stock = :stock"), @NamedQuery(name = "Price.findByPriceDate", query = "SELECT p FROM Price p WHERE p.pricePK.priceDate = :priceDate"), @NamedQuery(name = "Price.findByPriceOpen", query = "SELECT p FROM Price p WHERE p.priceOpen = :priceOpen"), @NamedQuery(name = "Price.findByPriceLow", query = "SELECT p FROM Price p WHERE p.priceLow = :priceLow"), @NamedQuery(name = "Price.findByPriceHigh", query = "SELECT p FROM Price p WHERE p.priceHigh = :priceHigh"), @NamedQuery(name = "Price.findByPriceClose", query = "SELECT p FROM Price p WHERE p.priceClose = :priceClose"), @NamedQuery(name = "Price.findByPriceAdj", query = "SELECT p FROM Price p WHERE p.priceAdj = :priceAdj"), @NamedQuery(name = "Price.findByTradeVolumn", query = "SELECT p FROM Price p WHERE p.tradeVolumn = :tradeVolumn"), @NamedQuery(name = "Price.findByCreateDate", query = "SELECT p FROM Price p WHERE p.createDate = :createDate"), @NamedQuery(name = "Price.findByUpdateDate", query = "SELECT p FROM Price p WHERE p.updateDate = :updateDate")})
public class Price implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PricePK pricePK;
    @Column(name = "PRICE_OPEN")
    private Double priceOpen;
    @Column(name = "PRICE_LOW")
    private Double priceLow;
    @Column(name = "PRICE_HIGH")
    private Double priceHigh;
    @Column(name = "PRICE_CLOSE")
    private Double priceClose;
    @Column(name = "PRICE_ADJ")
    private Double priceAdj;
    @Column(name = "TRADE_VOLUMN")
    private Integer tradeVolumn;
    @Basic(optional = false)
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Basic(optional = false)
    @Column(name = "UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @JoinColumn(name = "STOCK", referencedColumnName = "SYMBOL", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Stock stock;

    public Price() {
    }

    public Price(PricePK pricePK) {
        this.pricePK = pricePK;
    }

    public Price(PricePK pricePK, Date createDate, Date updateDate) {
        this.pricePK = pricePK;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Price(String stock, Date priceDate) {
        this.pricePK = new PricePK(stock, priceDate);
    }

    public PricePK getPricePK() {
        return pricePK;
    }

    public void setPricePK(PricePK pricePK) {
        this.pricePK = pricePK;
    }

    public Double getPriceOpen() {
        return priceOpen;
    }

    public void setPriceOpen(Double priceOpen) {
        this.priceOpen = priceOpen;
    }

    public Double getPriceLow() {
        return priceLow;
    }

    public void setPriceLow(Double priceLow) {
        this.priceLow = priceLow;
    }

    public Double getPriceHigh() {
        return priceHigh;
    }

    public void setPriceHigh(Double priceHigh) {
        this.priceHigh = priceHigh;
    }

    public Double getPriceClose() {
        return priceClose;
    }

    public void setPriceClose(Double priceClose) {
        this.priceClose = priceClose;
    }

    public Double getPriceAdj() {
        return priceAdj;
    }

    public void setPriceAdj(Double priceAdj) {
        this.priceAdj = priceAdj;
    }

    public Integer getTradeVolumn() {
        return tradeVolumn;
    }

    public void setTradeVolumn(Integer tradeVolumn) {
        this.tradeVolumn = tradeVolumn;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pricePK != null ? pricePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Price)) {
            return false;
        }
        Price other = (Price) object;
        if ((this.pricePK == null && other.pricePK != null) || (this.pricePK != null && !this.pricePK.equals(other.pricePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "desktop.bean.Price[pricePK=" + pricePK + "]";
    }

}
