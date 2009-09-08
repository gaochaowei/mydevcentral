/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package desktop.bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Gao.chao.wei
 */
@Entity
@Table(name = "PORTFOLIO")
@NamedQueries({@NamedQuery(name = "Portfolio.findAll", query = "SELECT p FROM Portfolio p"), @NamedQuery(name = "Portfolio.findById", query = "SELECT p FROM Portfolio p WHERE p.id = :id"), @NamedQuery(name = "Portfolio.findByName", query = "SELECT p FROM Portfolio p WHERE p.name = :name"), @NamedQuery(name = "Portfolio.findByRemark", query = "SELECT p FROM Portfolio p WHERE p.remark = :remark")})
public class Portfolio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "REMARK")
    private String remark;
    @OneToMany(mappedBy = "portfolio")
    private List<StockPosition> stockPositionList;

    public Portfolio() {
        stockPositionList = new java.util.ArrayList<StockPosition>();
    }

    public Portfolio(Integer id) {
        this.id = id;
    }

    public Portfolio(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<StockPosition> getStockPositionList() {
        return stockPositionList;
    }

    public void setStockPositionList(List<StockPosition> stockPositionList) {
        this.stockPositionList = stockPositionList;
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
        if (!(object instanceof Portfolio)) {
            return false;
        }
        Portfolio other = (Portfolio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "desktop.bean.Portfolio[id=" + id + "]";
    }

}
