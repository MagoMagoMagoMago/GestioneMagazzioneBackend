package its.kennedy.gestione.magazzino.Dao;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "purchase_items")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class PurchaseItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "purchase_id", nullable = false)
    private Integer purchase_id;
    
    @JoinColumn(name = "item_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Item item;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @NotNull
    @Column(name = "unit_price", nullable = false)
    private Double unit_price;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant created_at;

    @Column(name = "updated_at")
    private Instant updated_at;

    @Column(name = "deleted_at")
    private Instant deleted_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id(Integer purchase_id) {
        this.purchase_id = purchase_id;
    }


    public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }

    public Instant getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Instant created_at) {
        this.created_at = created_at;
    }

    public Instant getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Instant updated_at) {
        this.updated_at = updated_at;
    }

    public Instant getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Instant deleted_at) {
        this.deleted_at = deleted_at;
    }

    @Override
    public String toString() {
        return "PurchaseItemsDao{" +
                "id=" + id +
                ", purchase_id=" + purchase_id +
                ", item_id=" + item.getTitle() +
                ", quantity=" + quantity +
                ", unit_price=" + unit_price +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", deleted_at=" + deleted_at +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PurchaseItem that = (PurchaseItem) o;
        return getId().equals(that.getId())
                && getPurchase_id().equals(that.getPurchase_id())
                && getItem().getTitle().equals(that.getItem().getTitle())
                && getQuantity().equals(that.getQuantity())
                && getUnit_price().equals(that.getUnit_price())
                && getCreated_at().equals(that.getCreated_at())
                && Objects.equals(getUpdated_at(), that.getUpdated_at())
                && Objects.equals(getDeleted_at(), that.getDeleted_at());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPurchase_id(), getItem().getTitle(), getQuantity(), getUnit_price(), getCreated_at(),
                getUpdated_at(), getDeleted_at());
    }
}
