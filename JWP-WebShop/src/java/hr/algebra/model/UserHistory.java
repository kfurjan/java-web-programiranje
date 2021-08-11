package hr.algebra.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    
    public static final String FIND_ALL_QUERY = "UserHistory.findAll";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "LoginAt")
    private String logInAt;
    @Basic(optional = false)
    @Column(name = "IpAddress")
    private String ipAddress;
    @JoinColumn(name = "UserID", referencedColumnName = "ID")
    @ManyToOne
    private User user;

    public UserHistory() {
    }

    public UserHistory(Integer id) {
        this.id = id;
    }

    public UserHistory(Integer id, String logInAt) {
        this.id = id;
        this.logInAt = logInAt;
    }

    public UserHistory(User user, String logInAt, String ipAddress) {
        this.user = user;
        this.logInAt = logInAt;
        this.ipAddress = ipAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogInAt() {
        return logInAt;
    }

    public void setLogInAt(String logInAt) {
        this.logInAt = logInAt;
    }
    
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
