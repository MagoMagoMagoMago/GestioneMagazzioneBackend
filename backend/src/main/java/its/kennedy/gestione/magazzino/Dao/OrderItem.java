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
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderItemId")
    private Integer orderItemId;

    @JoinColumn(name = "AmazonOrderId", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Order order;

    @NotNull
    @Column(name = "ASIN", length = 10, nullable = false)
    private String asin;

    @Column(name = "Title", length = 500)
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

    @Column(name = "orderSuccess")
    private Boolean orderSuccess;

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
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

    public String getPointsGrantedPointsMonetaryValueCurrencyCode() {
        return pointsGrantedPointsMonetaryValueCurrencyCode;
    }

    public void setPointsGrantedPointsMonetaryValueCurrencyCode(String pointsGrantedPointsMonetaryValueCurrencyCode) {
        this.pointsGrantedPointsMonetaryValueCurrencyCode = pointsGrantedPointsMonetaryValueCurrencyCode;
    }

    public Boolean getOrderSuccess() {
        return orderSuccess;
    }

    public void setOrderSuccess(Boolean orderSuccess) {
        this.orderSuccess = orderSuccess;
    }

   
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderItem orderItem = (OrderItem) o;
        return getOrderItemId().equals(orderItem.getOrderItemId())
                && Objects.equals(getOrder(), orderItem.getOrder())
                && getAsin().equals(orderItem.getAsin())
                && Objects.equals(getTitle(), orderItem.getTitle())
                && Objects.equals(getQuantityOrdered(), orderItem.getQuantityOrdered())
                && Objects.equals(getQuantityShipped(), orderItem.getQuantityShipped())
                && Objects.equals(getPointsGrantedPointsNumber(), orderItem.getPointsGrantedPointsNumber())
                && Objects.equals(getPointsGrantedPointsMonetaryValueCurrencyCode(), orderItem.getPointsGrantedPointsMonetaryValueCurrencyCode())
                && Objects.equals(getPointsGrantedPointsMonetaryValueAmount(), orderItem.getPointsGrantedPointsMonetaryValueAmount())
                && Objects.equals(getItemPriceCurrencyCode(), orderItem.getItemPriceCurrencyCode())
                && Objects.equals(getItemPriceAmount(), orderItem.getItemPriceAmount())
                && Objects.equals(getShippingPriceCurrencyCode(), orderItem.getShippingPriceCurrencyCode())
                && Objects.equals(getShippingPriceAmount(), orderItem.getShippingPriceAmount())
                && Objects.equals(getPromotionIds(), orderItem.getPromotionIds())
                && Objects.equals(getOrderSuccess(), orderItem.getOrderSuccess());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderItemId(), getOrder(), getAsin(), getTitle(), getQuantityOrdered(),
                getQuantityShipped(), getPointsGrantedPointsNumber(), getPointsGrantedPointsMonetaryValueCurrencyCode(),
                getPointsGrantedPointsMonetaryValueAmount(), getItemPriceCurrencyCode(), getItemPriceAmount(),
                getShippingPriceCurrencyCode(), getShippingPriceAmount(), getPromotionIds(), getOrderSuccess());
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemId=" + orderItemId +
                ", order=" + order +
                ", asin='" + asin + '\'' +
                ", title='" + title + '\'' +
                ", quantityOrdered=" + quantityOrdered +
                ", QuantityShipped=" + QuantityShipped +
                ", pointsGrantedPointsNumber=" + pointsGrantedPointsNumber +
                ", pointsGrantedPointsMonetaryValueCurrencyCode='" + pointsGrantedPointsMonetaryValueCurrencyCode + '\'' +
                ", pointsGrantedPointsMonetaryValueAmount=" + pointsGrantedPointsMonetaryValueAmount +
                ", itemPriceCurrencyCode='" + itemPriceCurrencyCode + '\'' +
                ", itemPriceAmount=" + itemPriceAmount +
                ", shippingPriceCurrencyCode='" + shippingPriceCurrencyCode + '\'' +
                ", ShippingPriceAmount=" + ShippingPriceAmount +
                ", promotionIds='" + promotionIds + '\'' +
                ", orderSuccess=" + orderSuccess +
                '}';
    }
}
