/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Gao.chao.wei
 */
@Entity
@Table(name = "STOCK")
@NamedQueries({@NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s"), @NamedQuery(name = "Stock.findBySymbol", query = "SELECT s FROM Stock s WHERE s.symbol = :symbol"), @NamedQuery(name = "Stock.findByName", query = "SELECT s FROM Stock s WHERE s.name = :name"), @NamedQuery(name = "Stock.findByCreateDate", query = "SELECT s FROM Stock s WHERE s.createDate = :createDate"), @NamedQuery(name = "Stock.findByUpdateDate", query = "SELECT s FROM Stock s WHERE s.updateDate = :updateDate")})
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SYMBOL")
    private String symbol;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @OneToMany(mappedBy = "stock")
    private List<Price> priceList;

    public Stock() {
    }

    public Stock(String symbol) {
        this.symbol = symbol;
    }

    public Stock(String symbol, Date createDate, Date updateDate) {
        this.symbol = symbol;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Price> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<Price> priceList) {
        this.priceList = priceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (symbol != null ? symbol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.symbol == null && other.symbol != null) || (this.symbol != null && !this.symbol.equals(other.symbol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "desktop.bean.Stock[symbol=" + symbol + "]";
    }
}
