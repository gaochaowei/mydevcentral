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
 * @author sweet99
 */
@Embeddable
public class SystemCodePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "CODE_ID")
    private int codeId;
    @Basic(optional = false)
    @Column(name = "CODE_TYPE")
    private int codeType;

    public SystemCodePK(int codeId, int codeType) {
        this.codeId = codeId;
        this.codeType = codeType;
    }

    public int getCodeId() {
        return codeId;
    }

    public void setCodeId(int codeId) {
        this.codeId = codeId;
    }

    public int getCodeType() {
        return codeType;
    }

    public void setCodeType(int codeType) {
        this.codeType = codeType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codeId;
        hash += (int) codeType;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SystemCodePK)) {
            return false;
        }
        SystemCodePK other = (SystemCodePK) object;
        if (this.codeId != other.codeId) {
            return false;
        }
        if (this.codeType != other.codeType) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "desktop.bean.SystemCodePK[codeId=" + codeId + ", codeType=" + codeType + "]";
    }

}
