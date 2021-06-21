package its.kennedy.gestione.magazzino.Dto;

import java.time.Instant;

public class ItemsDto {
	private Integer id;
	private String asin;
	private String title;
	private String description;
	private Double price;
	private int storage;
	private int minAvailability;
	private String image;
	private Instant createdAt;
	private Instant updatedAt;
	private Instant deletedAt;
	private int category_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAsin() {
		return asin;
	}
	public void setAsin(String asin) {
		this.asin = asin;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	public int getMinAvailability() {
		return minAvailability;
	}
	public void setMinAvailability(int minAvailability) {
		this.minAvailability = minAvailability;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	@Override
	public String toString() {
		return "ItemsDto [id=" + id + ", asin=" + asin + ", title=" + title + ", description=" + description
				+ ", price=" + price + ", storage=" + storage + ", minAvailability=" + minAvailability + ", image="
				+ image + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt
				+ ", category_id=" + category_id + "]";
	}
	
}
