package its.kennedy.gestione.magazzino.Dto;

import java.time.Instant;
import java.util.Objects;

public class ItemsDto {

    private Integer id;

    private String asin;

    private String title;

    private String description;

    private Double price;

    private int storage;

    private int min_availability;

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
        ItemsDto itemsDto = (ItemsDto) o;
        return getStorage() == itemsDto.getStorage()
                && getMin_availability() == itemsDto.getMin_availability()
                && getId().equals(itemsDto.getId())
                && getAsin().equals(itemsDto.getAsin())
                && getTitle().equals(itemsDto.getTitle())
                && Objects.equals(getDescription(), itemsDto.getDescription())
                && getPrice().equals(itemsDto.getPrice())
                && getImage().equals(itemsDto.getImage())
                && getCreatedAt().equals(itemsDto.getCreatedAt())
                && Objects.equals(getUpdatedAt(), itemsDto.getUpdatedAt())
                && Objects.equals(getDeletedAt(), itemsDto.getDeletedAt())
                && getCategory().equals(itemsDto.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAsin(), getTitle(), getDescription(), getPrice(), getStorage(),
                getMin_availability(), getImage(), getCreatedAt(), getUpdatedAt(), getDeletedAt(), getCategory());
    }

    @Override
    public String toString() {
        return "ItemsDto{" +
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
                ", category=" + category +
                '}';
    }
}
