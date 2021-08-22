package hr.algebra.model;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kevin
 */
@Entity
@Table(name = "PaymentDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaymentDetail.findAll", query = "SELECT p FROM PaymentDetail p")
    , @NamedQuery(name = "PaymentDetail.findById", query = "SELECT p FROM PaymentDetail p WHERE p.id = :id")
    , @NamedQuery(name = "PaymentDetail.findByCreatedAt", query = "SELECT p FROM PaymentDetail p WHERE p.createdAt = :createdAt")})
public class PaymentDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CreatedAt")
    private String createdAt;
    @OneToMany(mappedBy = "paymentDetail")
    private List<OrderDetail> orderDetailList;
    @JoinColumn(name = "PaymentMethodID", referencedColumnName = "ID")
    @ManyToOne
    private PaymentMethod paymentMethod;
    @JoinColumn(name = "PaymentStatusID", referencedColumnName = "ID")
    @ManyToOne
    private PaymentStatus paymentStatus;

    public PaymentDetail() {
    }

    public PaymentDetail(Integer id) {
        this.id = id;
    }

    public PaymentDetail(String createdAt, PaymentMethod paymentMethod, PaymentStatus paymentStatus) {
        this.createdAt = createdAt;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @XmlTransient
    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
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
        if (!(object instanceof PaymentDetail)) {
            return false;
        }
        PaymentDetail other = (PaymentDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hr.algebra.model.PaymentDetail[ id=" + id + " ]";
    }
    
}
