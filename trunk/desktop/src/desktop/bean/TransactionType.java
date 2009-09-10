/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package desktop.bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Gao.chao.wei
 */
@Entity
@Table(name = "TRANSACTION_TYPE", catalog = "", schema = "ROOT")
@NamedQueries({@NamedQuery(name = "TransactionType.findAll", query = "SELECT t FROM TransactionType t"), @NamedQuery(name = "TransactionType.findById", query = "SELECT t FROM TransactionType t WHERE t.id = :id"), @NamedQuery(name = "TransactionType.findByText", query = "SELECT t FROM TransactionType t WHERE t.text = :text")})
public class TransactionType implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "TEXT")
    private String text;

    public TransactionType() {
    }

    public TransactionType(Integer id) {
        this.id = id;
    }

    public TransactionType(Integer id, String text) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionType)) {
            return false;
        }
        TransactionType other = (TransactionType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "desktop.bean.TransactionType[id=" + id + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
