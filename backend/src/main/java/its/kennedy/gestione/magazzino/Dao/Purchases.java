package its.kennedy.gestione.magazzino.Dao;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

public class Purchases implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @NotNull
    @Column(name = "supplier_id", nullable = false)
    private int supplier_id;
    @NotNull
    @Column(name = "number_invoice", nullable = false)
    private int number_invoice;
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

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public int getNumber_invoice() {
        return number_invoice;
    }

    public void setNumber_invoice(int number_invoice) {
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
        return "PurchasesDao [id=" + id + ", supplier_id=" + supplier_id + ", number_invoice=" + number_invoice
                + ", note=" + note + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt="
                + deletedAt + ", date_invoice=" + date_invoice + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
			return true;
		}
        if (obj == null) {
			return false;
		}
        if (getClass() != obj.getClass()) {
			return false;
		}
        Purchases other = (Purchases) obj;
        if (createdAt == null) {
            if (other.createdAt != null) {
				return false;
			}
        } else if (!createdAt.equals(other.createdAt)) {
			return false;
		}
        if (date_invoice == null) {
            if (other.date_invoice != null) {
				return false;
			}
        } else if (!date_invoice.equals(other.date_invoice)) {
			return false;
		}
        if (deletedAt == null) {
            if (other.deletedAt != null) {
				return false;
			}
        } else if (!deletedAt.equals(other.deletedAt)) {
			return false;
		}
        if (id == null) {
            if (other.id != null) {
				return false;
			}
        } else if (!id.equals(other.id)) {
			return false;
		}
        if (note == null) {
            if (other.note != null) {
				return false;
			}
        } else if (!note.equals(other.note)) {
			return false;
		}
        if (number_invoice != other.number_invoice) {
			return false;
		}
        if (supplier_id != other.supplier_id) {
			return false;
		}
        if (updatedAt == null) {
            if (other.updatedAt != null) {
				return false;
			}
        } else if (!updatedAt.equals(other.updatedAt)) {
			return false;
		}
        return true;
    }

}
