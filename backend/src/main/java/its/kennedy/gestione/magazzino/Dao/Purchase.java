package its.kennedy.gestione.magazzino.Dao;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "purchases")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class Purchase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "supplier_id", nullable = false)
    private Integer supplier_id;

    @NotNull
    @Column(name = "number_invoice", nullable = false)
    private Integer number_invoice;

    @Column(name = "note", length = 400)
    private String note;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;
    @NotNull
    @Column(name = "date_invoice", nullable = false)
    private Instant date_invoice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(Integer supplier_id) {
        this.supplier_id = supplier_id;
    }

    public Integer getNumber_invoice() {
        return number_invoice;
    }

    public void setNumber_invoice(Integer number_invoice) {
        this.number_invoice = number_invoice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Instant deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Instant getDate_invoice() {
        return date_invoice;
    }

    public void setDate_invoice(Instant date_invoice) {
        this.date_invoice = date_invoice;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", supplier_id=" + supplier_id +
                ", number_invoice=" + number_invoice +
                ", note='" + note + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                ", date_invoice=" + date_invoice +
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
        Purchase purchase = (Purchase) o;
        return getId().equals(purchase.getId())
                && getSupplier_id().equals(purchase.getSupplier_id())
                && getNumber_invoice().equals(purchase.getNumber_invoice())
                && Objects.equals(getNote(), purchase.getNote())
                && getCreatedAt().equals(purchase.getCreatedAt())
                && Objects.equals(getUpdatedAt(), purchase.getUpdatedAt())
                && Objects.equals(getDeletedAt(), purchase.getDeletedAt())
                && getDate_invoice().equals(purchase.getDate_invoice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSupplier_id(), getNumber_invoice(), getNote(), getCreatedAt(), getUpdatedAt(),
                getDeletedAt(), getDate_invoice());
    }
}
