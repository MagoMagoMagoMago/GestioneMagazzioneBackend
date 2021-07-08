package its.kennedy.gestione.magazzino.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class OrderItemDto {

    @JsonProperty("OrderItemId")
    private Integer orderItemId;

    @JsonProperty("AmazonOrderId")
    private String amazonOrderId;

    @JsonProperty("ASIN")
    private String asin;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("QuantityOrdered")
    private Integer quantityOrdered;

    @JsonProperty("QuantityShipped")
    private Integer QuantityShipped;

    @JsonProperty("PointsGrantedPointsNumber")
    private Integer pointsGrantedPointsNumber;

    @JsonProperty("PointsGrantedPointsMonetaryValueCurrencyCode")
    private String pointsGrantedPointsMonetaryValueCurrencyCode;

    @JsonProperty("PointsGrantedPointsMonetaryValueAmount")
    private Integer pointsGrantedPointsMonetaryValueAmount;

    @JsonProperty("ItemPriceCurrencyCode")
    private String itemPriceCurrencyCode;

    @JsonProperty("ItemPriceAmount")
    private Double itemPriceAmount;

    @JsonProperty("ShippingPriceCurrencyCode")
    private String shippingPriceCurrencyCode;

    @JsonProperty("ShippingPriceAmount")
    private Integer ShippingPriceAmount;

    @JsonProperty("PromotionIds")
    private String promotionIds;

    private Boolean orderSuccess;

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getAmazonOrderId() {
        return amazonOrderId;
    }

    public void setAmazonOrderId(String amazonOrderId) {
        this.amazonOrderId = amazonOrderId;
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

    public Integer getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(Integer quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public Integer getQuantityShipped() {
        return QuantityShipped;
    }

    public void setQuantityShipped(Integer quantityShipped) {
        QuantityShipped = quantityShipped;
    }

    public Integer getPointsGrantedPointsNumber() {
        return pointsGrantedPointsNumber;
    }

    public void setPointsGrantedPointsNumber(Integer pointsGrantedPointsNumber) {
        this.pointsGrantedPointsNumber = pointsGrantedPointsNumber;
    }

    public String getPointsGrantedPointsMonetaryValueCurrencyCode() {
        return pointsGrantedPointsMonetaryValueCurrencyCode;
    }

    public void setPointsGrantedPointsMonetaryValueCurrencyCode(String pointsGrantedPointsMonetaryValueCurrencyCode) {
        this.pointsGrantedPointsMonetaryValueCurrencyCode = pointsGrantedPointsMonetaryValueCurrencyCode;
    }

    public Integer getPointsGrantedPointsMonetaryValueAmount() {
        return pointsGrantedPointsMonetaryValueAmount;
    }

    public void setPointsGrantedPointsMonetaryValueAmount(Integer pointsGrantedPointsMonetaryValueAmount) {
        this.pointsGrantedPointsMonetaryValueAmount = pointsGrantedPointsMonetaryValueAmount;
    }

    public String getItemPriceCurrencyCode() {
        return itemPriceCurrencyCode;
    }

    public void setItemPriceCurrencyCode(String itemPriceCurrencyCode) {
        this.itemPriceCurrencyCode = itemPriceCurrencyCode;
    }

    public Double getItemPriceAmount() {
        return itemPriceAmount;
    }

    public void setItemPriceAmount(Double itemPriceAmount) {
        this.itemPriceAmount = itemPriceAmount;
    }

    public String getShippingPriceCurrencyCode() {
        return shippingPriceCurrencyCode;
    }

    public void setShippingPriceCurrencyCode(String shippingPriceCurrencyCode) {
        this.shippingPriceCurrencyCode = shippingPriceCurrencyCode;
    }

    public Integer getShippingPriceAmount() {
        return ShippingPriceAmount;
    }

    public void setShippingPriceAmount(Integer shippingPriceAmount) {
        ShippingPriceAmount = shippingPriceAmount;
    }

    public String getPromotionIds() {
        return promotionIds;
    }

    public void setPromotionIds(String promotionIds) {
        this.promotionIds = promotionIds;
    }

    public Boolean getOrderSuccess() {
        return orderSuccess;
    }

    public void setOrderSuccess(Boolean orderSuccess) {
        this.orderSuccess = orderSuccess;
    }

    @Override
    public String toString() {
        return "OrderItemDto{" +
                "orderItemId=" + orderItemId +
                ", amazonOrderId='" + amazonOrderId + '\'' +
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
        OrderItemDto that = (OrderItemDto) o;
        return Objects.equals(getOrderItemId(), that.getOrderItemId())
                && Objects.equals(getAmazonOrderId(), that.getAmazonOrderId())
                && Objects.equals(getAsin(), that.getAsin())
                && Objects.equals(getTitle(), that.getTitle())
                && Objects.equals(getQuantityOrdered(), that.getQuantityOrdered())
                && Objects.equals(getQuantityShipped(), that.getQuantityShipped())
                && Objects.equals(getPointsGrantedPointsNumber(), that.getPointsGrantedPointsNumber())
                && Objects.equals(getPointsGrantedPointsMonetaryValueCurrencyCode(), that.getPointsGrantedPointsMonetaryValueCurrencyCode())
                && Objects.equals(getPointsGrantedPointsMonetaryValueAmount(), that.getPointsGrantedPointsMonetaryValueAmount())
                && Objects.equals(getItemPriceCurrencyCode(), that.getItemPriceCurrencyCode())
                && Objects.equals(getItemPriceAmount(), that.getItemPriceAmount())
                && Objects.equals(getShippingPriceCurrencyCode(), that.getShippingPriceCurrencyCode())
                && Objects.equals(getShippingPriceAmount(), that.getShippingPriceAmount())
                && Objects.equals(getPromotionIds(), that.getPromotionIds());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderItemId(), getAmazonOrderId(), getAsin(), getTitle(), getQuantityOrdered(),
                getQuantityShipped(), getPointsGrantedPointsNumber(), getPointsGrantedPointsMonetaryValueCurrencyCode(),
                getPointsGrantedPointsMonetaryValueAmount(), getItemPriceCurrencyCode(), getItemPriceAmount(),
                getShippingPriceCurrencyCode(), getShippingPriceAmount(), getPromotionIds());
    }

    public static class OrderItemDtoList {

        @JsonProperty("OrderItems")
        private List<OrderItemDto> orderItems;

        public List<OrderItemDto> getOrderItems() {
            return orderItems;
        }

        public void setOrderItems(List<OrderItemDto> orderItems) {
            this.orderItems = orderItems;
        }
    }
}
