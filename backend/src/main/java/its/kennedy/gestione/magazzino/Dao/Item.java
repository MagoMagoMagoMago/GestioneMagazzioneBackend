package its.kennedy.gestione.magazzino.Dao;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "items")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class Item implements Serializable {

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

    @JoinColumn(name = "category_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return getStorage() == item.getStorage()
                && getMin_availability() == item.getMin_availability()
                && getId().equals(item.getId())
                && getAsin().equals(item.getAsin())
                && getTitle().equals(item.getTitle())
                && Objects.equals(getDescription(), item.getDescription())
                && getPrice().equals(item.getPrice())
                && getImage().equals(item.getImage())
                && getCreatedAt().equals(item.getCreatedAt())
                && Objects.equals(getUpdatedAt(), item.getUpdatedAt())
                && Objects.equals(getDeletedAt(), item.getDeletedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAsin(), getTitle(), getDescription(), getPrice(), getStorage(),
                getMin_availability(), getImage(), getCreatedAt(), getUpdatedAt(), getDeletedAt());
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", asin='" + asin + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", storage=" + storage +
                ", min_availability=" + min_availability +
                ", image='" + image + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
