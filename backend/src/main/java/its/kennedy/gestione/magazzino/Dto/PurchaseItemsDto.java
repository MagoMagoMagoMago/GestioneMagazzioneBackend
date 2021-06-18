package its.kennedy.gestione.magazzino.Dto;

import java.time.Instant;

public class PurchaseItemsDto {

    private Integer id;

    private Integer purchase_id;

    private Integer item_id;

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

	public Integer getItem_id() {
		return item_id;
	}

	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
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
    
}
