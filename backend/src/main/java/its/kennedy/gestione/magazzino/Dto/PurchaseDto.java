package its.kennedy.gestione.magazzino.Dto;

import java.time.Instant;
import java.util.Objects;

public class PurchaseDto {

    private Integer id;

    private int supplier_id;

    private int number_invoice;

    private String note;

    private Instant createdAt;

    private Instant updatedAt;

    private Instant deletedAt;

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
        return "PurchaseDto{" +
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
        PurchaseDto that = (PurchaseDto) o;
        return getSupplier_id() == that.getSupplier_id()
                && getNumber_invoice() == that.getNumber_invoice()
                && getId().equals(that.getId())
                && Objects.equals(getNote(), that.getNote())
                && getCreatedAt().equals(that.getCreatedAt())
                && Objects.equals(getUpdatedAt(), that.getUpdatedAt())
                && Objects.equals(getDeletedAt(), that.getDeletedAt())
                && getDate_invoice().equals(that.getDate_invoice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSupplier_id(), getNumber_invoice(), getNote(), getCreatedAt(), getUpdatedAt(),
                getDeletedAt(), getDate_invoice());
    }
}
