/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kevin
 */
@Entity
@Table(name = "UserHistory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserHistory.findAll", query = "SELECT u FROM UserHistory u")
    , @NamedQuery(name = "UserHistory.findById", query = "SELECT u FROM UserHistory u WHERE u.id = :id")})
public class UserHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "LogInAt")
    private byte[] logInAt;
    @JoinColumn(name = "UserID", referencedColumnName = "ID")
    @ManyToOne
    private User userID;

    public UserHistory() {
    }

    public UserHistory(Integer id) {
        this.id = id;
    }

    public UserHistory(Integer id, byte[] logInAt) {
        this.id = id;
        this.logInAt = logInAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getLogInAt() {
        return logInAt;
    }

    public void setLogInAt(byte[] logInAt) {
        this.logInAt = logInAt;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
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
        if (!(object instanceof UserHistory)) {
            return false;
        }
        UserHistory other = (UserHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hr.algebra.model.UserHistory[ id=" + id + " ]";
    }
    
}
