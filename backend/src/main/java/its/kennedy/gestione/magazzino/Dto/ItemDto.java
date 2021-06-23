package its.kennedy.gestione.magazzino.Dto;

import java.time.Instant;
import java.util.Objects;

public class ItemDto {
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

    private String category;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
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
        ItemDto itemDto = (ItemDto) o;
        return getStorage() == itemDto.getStorage()
                && getMinAvailability() == itemDto.getMinAvailability()
                && getId().equals(itemDto.getId())
                && getAsin().equals(itemDto.getAsin())
                && getTitle().equals(itemDto.getTitle())
                && Objects.equals(getDescription(), itemDto.getDescription())
                && getPrice().equals(itemDto.getPrice())
                && getImage().equals(itemDto.getImage())
                && getCreatedAt().equals(itemDto.getCreatedAt())
                && Objects.equals(getUpdatedAt(), itemDto.getUpdatedAt())
                && Objects.equals(getDeletedAt(), itemDto.getDeletedAt())
                && getCategory().equals(itemDto.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAsin(), getTitle(), getDescription(), getPrice(), getStorage(),
                getMinAvailability(), getImage(), getCreatedAt(), getUpdatedAt(), getDeletedAt(), getCategory());
    }

    @Override
    public String toString() {
        return "ItemDto{" +
                "id=" + id +
                ", asin='" + asin + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", storage=" + storage +
                ", min_availability=" + minAvailability +
                ", image='" + image + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                ", category=" + category +
                '}';
    }

}
