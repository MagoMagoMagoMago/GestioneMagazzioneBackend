package its.kennedy.gestione.magazzino.Dto;

public class OrderItemsDto {

    private Integer orderItemId;

    private String amazonOrderId;

    private String asin;

    private String title;

    private Integer quantityOrdered;

    private Integer QuantityShipped;

    private Integer pointsGrantedPointsNumber;

    private String pointsGrantedPointsMonetaryValueCurrencyCode;

    private Integer pointsGrantedPointsMonetaryValueAmount;

    private String itemPriceCurrencyCode;

    private Double itemPriceAmount;

    private String shippingPriceCurrencyCode;

    private Integer ShippingPriceAmount;

    private String promotionIds;

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

    @Override
    public String toString() {
        return "OrderItemsDto{" +
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
}
