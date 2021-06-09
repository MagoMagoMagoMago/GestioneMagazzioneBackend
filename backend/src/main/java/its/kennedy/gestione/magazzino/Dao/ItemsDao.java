package its.kennedy.gestione.magazzino.Dao;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "items")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class ItemsDao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	@NotNull
	@Column(name = "asin", length = 100, nullable = false)
	private String asin;
	@NotNull
	@Column(name = "title", length = 100, nullable = false)
	private String title;

	@Column(name = "description", length = 400)
	private String description;
	@NotNull
	@Column(name = "price", nullable = false)
	private Double price;
	@NotNull
	@Column(name = "storage", length = 100, nullable = false)
	private int storage;
	@NotNull
	@Column(name = "min_availability", nullable = false)
	private int min_availability;
	@NotNull
	@Column(name = "image", length = 400, nullable = false)
	private String image;
	@NotNull
	@Column(name = "created_at", nullable = false)
	private Instant createdAt;

	
	@Column(name = "updated_at")
	private Instant updatedAt;

	
	@Column(name = "deleted_at")
	private Instant deletedAt;
	@NotNull
	@Column(name = "category_id", length = 100, nullable = false)
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

	public int getMin_availability() {
		return min_availability;
	}

	public void setMin_availability(int min_availability) {
		this.min_availability = min_availability;
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
		return "ItemsDao [id=" + id + ", asin=" + asin + ", title=" + title + ", description=" + description
				+ ", price=" + price + ", storage=" + storage + ", min_availability=" + min_availability + ", image="
				+ image + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt
				+ ", category_id=" + category_id + "]";
	}
    
}
