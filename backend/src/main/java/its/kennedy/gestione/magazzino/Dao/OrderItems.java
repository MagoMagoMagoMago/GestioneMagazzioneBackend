package its.kennedy.gestione.magazzino.Dao;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "OrderItems")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class OrderItems implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderItemId")
    private Integer orderItemId;

    @Column(name = "AmazonOrderId", length = 19)
    private String amazonOrderId;

    @NotNull
    @Column(name = "ASIN", length = 10, nullable = false)
    private String asin;

    @Column(name = "Title", length = 100)
    private String title;

    @Column(name = "QuantityOrdered")
    private Integer quantityOrdered;

    @Column(name = "QuantityShipped")
    private Integer QuantityShipped;

    @Column(name = "PointsGrantedPointsNumber")
    private Integer pointsGrantedPointsNumber;

    @Column(name = "PointsGrantedPointsMonetaryValueCurrencyCode", length = 100)
    private String pointsGrantedPointsMonetaryValueCurrencyCode;

    @Column(name = "PointsGrantedPointsMonetaryValueAmount")
    private Integer pointsGrantedPointsMonetaryValueAmount;

    @Column(name = "ItemPriceCurrencyCode", length = 100)
    private String itemPriceCurrencyCode;

    @Column(name = "ItemPriceAmount", length = 19)
    private Double itemPriceAmount;

    @Column(name = "ShippingPriceCurrencyCode", length = 100)
    private String shippingPriceCurrencyCode;

    @Column(name = "ShippingPriceAmount")
    private Integer ShippingPriceAmount;

    @Column(name = "PromotionIds", length = 100)
    private String promotionIds;

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public void setAmazonOrderId(String amazonOrderId) {
        this.amazonOrderId = amazonOrderId;
    }

    public void setPointsGrantedPointsMonetaryValueAmount(Integer pointsGrantedPointsMonetaryValueAmount) {
        this.pointsGrantedPointsMonetaryValueAmount = pointsGrantedPointsMonetaryValueAmount;
    }

    public void setItemPriceCurrencyCode(String itemPriceCurrencyCode) {
        this.itemPriceCurrencyCode = itemPriceCurrencyCode;
    }

    public void setItemPriceAmount(Double itemPriceAmount) {
        this.itemPriceAmount = itemPriceAmount;
    }

    public void setShippingPriceCurrencyCode(String shippingPriceCurrencyCode) {
        this.shippingPriceCurrencyCode = shippingPriceCurrencyCode;
    }

    public void setShippingPriceAmount(Integer shippingPriceAmount) {
        ShippingPriceAmount = shippingPriceAmount;
    }

    public void setPromotionIds(String promotionIds) {
        this.promotionIds = promotionIds;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuantityOrdered(Integer quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public void setQuantityShipped(Integer quantityShipped) {
        QuantityShipped = quantityShipped;
    }

    public void setPointsGrantedPointsNumber(Integer pointsGrantedPointsNumber) {
        this.pointsGrantedPointsNumber = pointsGrantedPointsNumber;
    }

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public String getAmazonOrderId() {
        return amazonOrderId;
    }

    public Integer getPointsGrantedPointsMonetaryValueAmount() {
        return pointsGrantedPointsMonetaryValueAmount;
    }

    public String getItemPriceCurrencyCode() {
        return itemPriceCurrencyCode;
    }

    public Double getItemPriceAmount() {
        return itemPriceAmount;
    }

    public String getShippingPriceCurrencyCode() {
        return shippingPriceCurrencyCode;
    }

    public Integer getShippingPriceAmount() {
        return ShippingPriceAmount;
    }

    public String getPromotionIds() {
        return promotionIds;
    }

    public String getAsin() {
        return asin;
    }

    public String getTitle() {
        return title;
    }

    public Integer getQuantityOrdered() {
        return quantityOrdered;
    }

    public Integer getQuantityShipped() {
        return QuantityShipped;
    }

    public Integer getPointsGrantedPointsNumber() {
        return pointsGrantedPointsNumber;
    }

    @Override
    public String toString() {
        return "OrderItemsDao{" +
                "orderItemId=" + orderItemId +
                ", amazonOrderId='" + amazonOrderId + '\'' +
                ", asin='" + asin + '\'' +
                ", title='" + title + '\'' +
                ", quantityOrdered=" + quantityOrdered +
                ", QuantityShipped=" + QuantityShipped +
                ", pointsGrantedPointsNumber=" + pointsGrantedPointsNumber +
                ", AmazonOrderId='" + pointsGrantedPointsMonetaryValueCurrencyCode + '\'' +
                ", pointsGrantedPointsMonetaryValueAmount=" + pointsGrantedPointsMonetaryValueAmount +
                ", itemPriceCurrencyCode='" + itemPriceCurrencyCode + '\'' +
                ", itemPriceAmount=" + itemPriceAmount +
                ", shippingPriceCurrencyCode='" + shippingPriceCurrencyCode + '\'' +
                ", ShippingPriceAmount=" + ShippingPriceAmount +
                ", promotionIds='" + promotionIds + '\'' +
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
        OrderItems that = (OrderItems) o;
        return getOrderItemId().equals(that.getOrderItemId())
                && Objects.equals(getAmazonOrderId(), that.getAmazonOrderId())
                && getAsin().equals(that.getAsin())
                && Objects.equals(getTitle(), that.getTitle())
                && Objects.equals(getQuantityOrdered(), that.getQuantityOrdered())
                && Objects.equals(getQuantityShipped(), that.getQuantityShipped())
                && Objects.equals(getPointsGrantedPointsNumber(), that.getPointsGrantedPointsNumber())
                && Objects.equals(getAmazonOrderId(), that.getAmazonOrderId())
                && Objects.equals(getPointsGrantedPointsMonetaryValueAmount(), that.getPointsGrantedPointsMonetaryValueAmount())
                && Objects.equals(getItemPriceCurrencyCode(), that.getItemPriceCurrencyCode())
                && Objects.equals(getItemPriceAmount(), that.getItemPriceAmount())
                && Objects.equals(getShippingPriceCurrencyCode(), that.getShippingPriceCurrencyCode())
                && Objects.equals(getShippingPriceAmount(), that.getShippingPriceAmount())
                && Objects.equals(getPromotionIds(), that.getPromotionIds());
    }
}
