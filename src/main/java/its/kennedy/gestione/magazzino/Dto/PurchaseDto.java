package its.kennedy.gestione.magazzino.Dto;

import java.time.Instant;
import java.util.Objects;

public class PurchaseDto {

    private Integer id;

    private Integer numberInvoice;

    private String note;

    private Instant createdAt;

    private Instant updatedAt;

    private Instant deletedAt;

    private Instant dateInvoice;

    private String supplier;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                && getNumberInvoice().equals(that.getNumberInvoice())
                && Objects.equals(getNote(), that.getNote())
                && getCreatedAt().equals(that.getCreatedAt())
                && Objects.equals(getUpdatedAt(), that.getUpdatedAt())
                && Objects.equals(getDeletedAt(), that.getDeletedAt())
                && getDateInvoice().equals(that.getDateInvoice())
                && getSupplier().equals(that.getSupplier());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNumberInvoice(), getNote(), getCreatedAt(), getUpdatedAt(), getDeletedAt(),
                getDateInvoice(), getSupplier());
    }

    @Override
    public String toString() {
        return "PurchaseDto{" +
                "id=" + id +
                ", number_invoice=" + numberInvoice +
                ", note='" + note + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                ", date_invoice=" + dateInvoice +
                ", supplier='" + supplier + '\'' +
                '}';
    }

}
