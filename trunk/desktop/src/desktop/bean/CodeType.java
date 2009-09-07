/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop.bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;

/**
 *
 * @author sweet99
 */
@Entity
@Table(name = "CODE_TYPE")
@NamedQueries({@NamedQuery(name = "CodeType.findAll", query = "SELECT c FROM CodeType c"), @NamedQuery(name = "CodeType.findById", query = "SELECT c FROM CodeType c WHERE c.id = :id"), @NamedQuery(name = "CodeType.findByText", query = "SELECT c FROM CodeType c WHERE c.text = :text")})
public class CodeType implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
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
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        String oldText = this.text;
        this.text = text;
        changeSupport.firePropertyChange("text", oldText, text);
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

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}
