/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package desktop.bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author sweet99
 */
@Entity
@Table(name = "CODE_TYPE")
@NamedQueries({@NamedQuery(name = "CodeType.findAll", query = "SELECT c FROM CodeType c"), @NamedQuery(name = "CodeType.findById", query = "SELECT c FROM CodeType c WHERE c.id = :id"), @NamedQuery(name = "CodeType.findByText", query = "SELECT c FROM CodeType c WHERE c.text = :text")})
public class CodeType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "TEXT")
    private String text;
        @OneToMany(mappedBy = "codeType")
    private List<SystemCode> systemCodeList;

    public CodeType() {
    }

    public CodeType(Integer id) {
        this.id = id;
    }

    public CodeType(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<SystemCode> getSystemCodeList() {
        return systemCodeList;
    }

    public void setSystemCodeList(List<SystemCode> systemCodeList) {
        this.systemCodeList = systemCodeList;
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
        if (!(object instanceof CodeType)) {
            return false;
        }
        CodeType other = (CodeType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "desktop.bean.CodeType[id=" + id + "]";
    }

}
