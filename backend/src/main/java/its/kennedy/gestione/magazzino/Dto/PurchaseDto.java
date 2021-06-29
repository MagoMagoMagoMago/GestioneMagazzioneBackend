package its.kennedy.gestione.magazzino.Dto;

import java.time.Instant;
import java.util.Objects;

public class PurchaseDto {

    private Integer id;

    private Integer number_invoice;

    private String note;

    private Instant createdAt;

    private Instant updatedAt;

    private Instant deletedAt;

    private Instant date_invoice;

    private String supplier;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
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
        return getId().equals(that.getId())
                && getNumber_invoice().equals(that.getNumber_invoice())
                && Objects.equals(getNote(), that.getNote())
                && getCreatedAt().equals(that.getCreatedAt())
                && Objects.equals(getUpdatedAt(), that.getUpdatedAt())
                && Objects.equals(getDeletedAt(), that.getDeletedAt())
                && getDate_invoice().equals(that.getDate_invoice())
                && getSupplier().equals(that.getSupplier());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNumber_invoice(), getNote(), getCreatedAt(), getUpdatedAt(), getDeletedAt(),
                getDate_invoice(), getSupplier());
    }

    @Override
    public String toString() {
        return "PurchaseDto{" +
                "id=" + id +
                ", number_invoice=" + number_invoice +
                ", note='" + note + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                ", date_invoice=" + date_invoice +
                ", supplier='" + supplier + '\'' +
                '}';
    }

}
