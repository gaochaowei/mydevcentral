/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package desktop.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author sweet99
 */
@Entity
@Table(name = "SYSTEM_CODE")
@NamedQueries({@NamedQuery(name = "SystemCode.findAll", query = "SELECT s FROM SystemCode s"), @NamedQuery(name = "SystemCode.findByCodeId", query = "SELECT s FROM SystemCode s WHERE s.systemCodePK.codeId = :codeId"), @NamedQuery(name = "SystemCode.findByCodeType", query = "SELECT s FROM SystemCode s WHERE s.systemCodePK.codeType = :codeType"), @NamedQuery(name = "SystemCode.findByText", query = "SELECT s FROM SystemCode s WHERE s.text = :text")})
public class SystemCode implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SystemCodePK systemCodePK;
    @Column(name = "TEXT")
    private String text;
    @JoinColumn(name = "CODE_TYPE", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CodeType codeType;
   

    public SystemCode() {
    }

    public SystemCode(SystemCodePK systemCodePK) {
        this.systemCodePK = systemCodePK;
    }

    public SystemCode(int codeId, int codeType) {
        this.systemCodePK = new SystemCodePK(codeId, codeType);
    }

    public SystemCodePK getSystemCodePK() {
        return systemCodePK;
    }

    public void setSystemCodePK(SystemCodePK systemCodePK) {
        this.systemCodePK = systemCodePK;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public CodeType getCodeType() {
        return codeType;
    }

    public void setCodeType(CodeType codeType) {
        this.codeType = codeType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (systemCodePK != null ? systemCodePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SystemCode)) {
            return false;
        }
        SystemCode other = (SystemCode) object;
        if ((this.systemCodePK == null && other.systemCodePK != null) || (this.systemCodePK != null && !this.systemCodePK.equals(other.systemCodePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "desktop.bean.SystemCode[systemCodePK=" + systemCodePK + "]";
    }

}
