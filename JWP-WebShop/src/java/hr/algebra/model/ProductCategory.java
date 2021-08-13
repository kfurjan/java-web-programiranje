package hr.algebra.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "ProductCategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductCategory.findAll", query = "SELECT p FROM ProductCategory p")
    , @NamedQuery(name = "ProductCategory.findById", query = "SELECT p FROM ProductCategory p WHERE p.id = :id")
    , @NamedQuery(name = "ProductCategory.findByName", query = "SELECT p FROM ProductCategory p WHERE p.name = :name")
    , @NamedQuery(name = "ProductCategory.findByDescription", query = "SELECT p FROM ProductCategory p WHERE p.description = :description")})
public class ProductCategory implements Serializable {
    
    public static final String FIND_ALL_QUERY = "ProductCategory.findAll";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @OneToMany(mappedBy = "categoryID")
    private List<Product> productList;

    public ProductCategory() {
    }

    public ProductCategory(Integer id) {
        this.id = id;
    }

    public ProductCategory(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public ProductCategory(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
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
        if (!(object instanceof ProductCategory)) {
            return false;
        }
        ProductCategory other = (ProductCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hr.algebra.model.ProductCategory[ id=" + id + " ]";
    }
}
