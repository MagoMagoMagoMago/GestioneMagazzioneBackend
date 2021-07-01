package its.kennedy.gestione.magazzino.Dto;

import java.time.Instant;
import java.util.Objects;

public class PurchaseItemDto {

    private Integer id;

    private Integer purchase_id;

    private String item;

    private Integer quantity;

    private Double unit_price;

    private Instant created_at;

    private Instant updated_at;

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

    public String getItem() {
        return item;
    }

    public void setItem(String item_id) {
        this.item = item_id;
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
        return "PurchaseItemDto{" +
                "id=" + id +
                ", purchase_id=" + purchase_id +
                ", item_id=" + item +
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
        PurchaseItemDto that = (PurchaseItemDto) o;
        return Objects.equals(getId(), that.getId())
                && Objects.equals(getPurchase_id(), that.getPurchase_id())
                && Objects.equals(getItem(), that.getItem())
                && Objects.equals(getQuantity(), that.getQuantity())
                && Objects.equals(getUnit_price(), that.getUnit_price())
                && Objects.equals(getCreated_at(), that.getCreated_at())
                && Objects.equals(getUpdated_at(), that.getUpdated_at())
                && Objects.equals(getDeleted_at(), that.getDeleted_at());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPurchase_id(), getItem(), getQuantity(), getUnit_price(), getCreated_at(),
                getUpdated_at(), getDeleted_at());
    }
}
