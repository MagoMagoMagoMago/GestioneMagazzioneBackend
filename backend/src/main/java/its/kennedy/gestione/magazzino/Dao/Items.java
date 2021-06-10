package its.kennedy.gestione.magazzino.Dao;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "items")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class Items implements Serializable {
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
    @Column(name = "category_id", nullable = false)
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
        Items other = (Items) obj;
        if (asin == null) {
            if (other.asin != null) {
				return false;
			}
        } else if (!asin.equals(other.asin)) {
			return false;
		}
        if (category_id != other.category_id) {
			return false;
		}
        if (createdAt == null) {
            if (other.createdAt != null) {
				return false;
			}
        } else if (!createdAt.equals(other.createdAt)) {
			return false;
		}
        if (deletedAt == null) {
            if (other.deletedAt != null) {
				return false;
			}
        } else if (!deletedAt.equals(other.deletedAt)) {
			return false;
		}
        if (description == null) {
            if (other.description != null) {
				return false;
			}
        } else if (!description.equals(other.description)) {
			return false;
		}
        if (id == null) {
            if (other.id != null) {
				return false;
			}
        } else if (!id.equals(other.id)) {
			return false;
		}
        if (image == null) {
            if (other.image != null) {
				return false;
			}
        } else if (!image.equals(other.image)) {
			return false;
		}
        if (min_availability != other.min_availability) {
			return false;
		}
        if (price == null) {
            if (other.price != null) {
				return false;
			}
        } else if (!price.equals(other.price)) {
			return false;
		}
        if (storage != other.storage) {
			return false;
		}
        if (title == null) {
            if (other.title != null) {
				return false;
			}
        } else if (!title.equals(other.title)) {
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

    @Override
    public String toString() {
        return "ItemsDao [id=" + id + ", asin=" + asin + ", title=" + title + ", description=" + description
                + ", price=" + price + ", storage=" + storage + ", min_availability=" + min_availability + ", image="
                + image + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt
                + ", category_id=" + category_id + "]";
    }

}
