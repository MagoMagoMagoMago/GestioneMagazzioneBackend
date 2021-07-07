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

    @JoinColumn(name = "supplier_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Supplier supplier;


    @Column(name = "number_invoice", nullable = false, unique = true)
    private Integer numberInvoice;

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
    private Instant dateInvoice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Integer getNumberInvoice() {
        return numberInvoice;
    }

    public void setNumberInvoice(Integer numberInvoice) {
        this.numberInvoice = numberInvoice;
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

    public Instant getDateInvoice() {
        return dateInvoice;
    }

    public void setDateInvoice(Instant dateInvoice) {
        this.dateInvoice = dateInvoice;
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
                && getSupplier().equals(purchase.getSupplier())
                && getNumberInvoice().equals(purchase.getNumberInvoice())
                && Objects.equals(getNote(), purchase.getNote())
                && getCreatedAt().equals(purchase.getCreatedAt())
                && Objects.equals(getUpdatedAt(), purchase.getUpdatedAt())
                && Objects.equals(getDeletedAt(), purchase.getDeletedAt())
                && getDateInvoice().equals(purchase.getDateInvoice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSupplier(), getNumberInvoice(), getNote(), getCreatedAt(), getUpdatedAt(),
                getDeletedAt(), getDateInvoice());
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", supplier=" + supplier +
                ", number_invoice=" + numberInvoice +
                ", note='" + note + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                ", date_invoice=" + dateInvoice +
                '}';
    }

}
