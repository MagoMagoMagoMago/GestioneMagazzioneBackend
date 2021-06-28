package its.kennedy.gestione.magazzino.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class OrderDto {

    @JsonProperty("AmazonOrderId")
    private String amazonOrderId;

    @JsonProperty("PurchaseDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SS", timezone = "UTC")
    private Instant purchaseDate;

    @JsonProperty("LastUpdateDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SS", timezone = "UTC")
    private Instant lastUpdateDate;

    @JsonProperty("OrderStatus")
    private String orderStatus;

    @JsonProperty("FulfillmentChannel")
    private String fulfillmentChannel;

    @JsonProperty("NumberOfItemsShipped")
    private int numberOfItemsShipped;

    @JsonProperty("NumberOfItemsUnshipped")
    private int numberOfItemsUnshipped;

    @JsonProperty("PaymentMethod")
    private String paymentMethod;

    @JsonProperty("PaymentMethodDetails")
    private String paymentMethodDetails;

    @JsonProperty("MarketplaceId")
    private String marketplaceId;

    @JsonProperty("ShipmentServiceLevelCategory")
    private String shipmentServiceLevelCategory;

    @JsonProperty("OrderType")
    private String orderType;

    @JsonProperty("EarliestShipDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SS", timezone = "UTC")
    private Instant earliestShipDate;

    @JsonProperty("LatestShipDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SS", timezone = "UTC")
    private Instant latestShipDate;

    @JsonProperty("IsBusinessOrder")
    private boolean isBusinessOrder;

    @JsonProperty("IsPrime")
    private boolean isPrime;

    @JsonProperty("IsGlobalExpressEnabled")
    private boolean isGlobalExpressEnabled;

    @JsonProperty("IsPremiumOrder")
    private boolean isPremiumOrder;

    @JsonProperty("IsSoldByAB")
    private boolean isSoldByAB;

    @JsonProperty("CompanyLegalName")
    private String companyLegalName;

    @JsonProperty("BuyerEmail")
    private String buyerEmail;

    @JsonProperty("BuyerName")
    private String buyerName;

    @JsonProperty("PurchaseOrderNumber")
    private String purchaseOrderNumber;

    @JsonProperty("ShippingAddressName")
    private String shippingAddressName;

    @JsonProperty("ShippingAddressLine1")
    private String shippingAddressLine1;

    @JsonProperty("ShippingAddressCity")
    private String shippingAddressCity;

    @JsonProperty("ShippingCityStateOrRegion")
    private String shippingCityStateOrRegion;

    @JsonProperty("ShippingStateOrRegionPostalCode")
    private String shippingStateOrRegionPostalCode;

    private Boolean orderSuccess;

    public String getAmazonOrderId() {
        return amazonOrderId;
    }

    public void setAmazonOrderId(String amazonOrderId) {
        this.amazonOrderId = amazonOrderId;
    }

    public Instant getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Instant purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Instant getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Instant lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getFulfillmentChannel() {
        return fulfillmentChannel;
    }

    public void setFulfillmentChannel(String fulfillmentChannel) {
        this.fulfillmentChannel = fulfillmentChannel;
    }

    public int getNumberOfItemsShipped() {
        return numberOfItemsShipped;
    }

    public void setNumberOfItemsShipped(int numberOfItemsShipped) {
        this.numberOfItemsShipped = numberOfItemsShipped;
    }

    public int getNumberOfItemsUnshipped() {
        return numberOfItemsUnshipped;
    }

    public void setNumberOfItemsUnshipped(int numberOfItemsUnshipped) {
        this.numberOfItemsUnshipped = numberOfItemsUnshipped;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethodDetails() {
        return paymentMethodDetails;
    }

    public void setPaymentMethodDetails(String paymentMethodDetails) {
        this.paymentMethodDetails = paymentMethodDetails;
    }

    public String getMarketplaceId() {
        return marketplaceId;
    }

    public void setMarketplaceId(String marketplaceId) {
        this.marketplaceId = marketplaceId;
    }

    public String getShipmentServiceLevelCategory() {
        return shipmentServiceLevelCategory;
    }

    public void setShipmentServiceLevelCategory(String shipmentServiceLevelCategory) {
        this.shipmentServiceLevelCategory = shipmentServiceLevelCategory;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Instant getEarliestShipDate() {
        return earliestShipDate;
    }

    public void setEarliestShipDate(Instant earliestShipDate) {
        this.earliestShipDate = earliestShipDate;
    }

    public Instant getLatestShipDate() {
        return latestShipDate;
    }

    public void setLatestShipDate(Instant latestShipDate) {
        this.latestShipDate = latestShipDate;
    }

    public boolean isBusinessOrder() {
        return isBusinessOrder;
    }

    public void setBusinessOrder(boolean businessOrder) {
        isBusinessOrder = businessOrder;
    }

    public boolean isPrime() {
        return isPrime;
    }

    public void setPrime(boolean prime) {
        isPrime = prime;
    }

    public boolean isGlobalExpressEnabled() {
        return isGlobalExpressEnabled;
    }

    public void setGlobalExpressEnabled(boolean globalExpressEnabled) {
        isGlobalExpressEnabled = globalExpressEnabled;
    }

    public boolean isPremiumOrder() {
        return isPremiumOrder;
    }

    public void setPremiumOrder(boolean premiumOrder) {
        isPremiumOrder = premiumOrder;
    }

    public boolean isSoldByAB() {
        return isSoldByAB;
    }

    public void setSoldByAB(boolean soldByAB) {
        isSoldByAB = soldByAB;
    }

    public String getCompanyLegalName() {
        return companyLegalName;
    }

    public void setCompanyLegalName(String companyLegalName) {
        this.companyLegalName = companyLegalName;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public String getShippingAddressName() {
        return shippingAddressName;
    }

    public void setShippingAddressName(String shippingAddressName) {
        this.shippingAddressName = shippingAddressName;
    }

    public String getShippingAddressLine1() {
        return shippingAddressLine1;
    }

    public void setShippingAddressLine1(String shippingAddressLine1) {
        this.shippingAddressLine1 = shippingAddressLine1;
    }

    public String getShippingAddressCity() {
        return shippingAddressCity;
    }

    public void setShippingAddressCity(String shippingAddressCity) {
        this.shippingAddressCity = shippingAddressCity;
    }

    public String getShippingCityStateOrRegion() {
        return shippingCityStateOrRegion;
    }

    public void setShippingCityStateOrRegion(String shippingCityStateOrRegion) {
        this.shippingCityStateOrRegion = shippingCityStateOrRegion;
    }

    public String getShippingStateOrRegionPostalCode() {
        return shippingStateOrRegionPostalCode;
    }

    public void setShippingStateOrRegionPostalCode(String shippingStateOrRegionPostalCode) {
        this.shippingStateOrRegionPostalCode = shippingStateOrRegionPostalCode;
    }

    public Boolean getOrderSuccess() {
        return orderSuccess;
    }

    public void setOrderSuccess(Boolean orderSuccess) {
        this.orderSuccess = orderSuccess;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderDto orderDto = (OrderDto) o;
        return getNumberOfItemsShipped() == orderDto.getNumberOfItemsShipped()
                && getNumberOfItemsUnshipped() == orderDto.getNumberOfItemsUnshipped()
                && isBusinessOrder() == orderDto.isBusinessOrder()
                && isPrime() == orderDto.isPrime()
                && isGlobalExpressEnabled() == orderDto.isGlobalExpressEnabled()
                && isPremiumOrder() == orderDto.isPremiumOrder()
                && isSoldByAB() == orderDto.isSoldByAB()
                && getAmazonOrderId().equals(orderDto.getAmazonOrderId())
                && Objects.equals(getPurchaseDate(), orderDto.getPurchaseDate())
                && Objects.equals(getLastUpdateDate(), orderDto.getLastUpdateDate())
                && Objects.equals(getOrderStatus(), orderDto.getOrderStatus())
                && Objects.equals(getFulfillmentChannel(), orderDto.getFulfillmentChannel())
                && Objects.equals(getPaymentMethod(), orderDto.getPaymentMethod())
                && Objects.equals(getPaymentMethodDetails(), orderDto.getPaymentMethodDetails())
                && Objects.equals(getMarketplaceId(), orderDto.getMarketplaceId())
                && Objects.equals(getShipmentServiceLevelCategory(), orderDto.getShipmentServiceLevelCategory())
                && Objects.equals(getOrderType(), orderDto.getOrderType())
                && Objects.equals(getEarliestShipDate(), orderDto.getEarliestShipDate())
                && Objects.equals(getLatestShipDate(), orderDto.getLatestShipDate())
                && Objects.equals(getCompanyLegalName(), orderDto.getCompanyLegalName())
                && Objects.equals(getBuyerEmail(), orderDto.getBuyerEmail())
                && Objects.equals(getBuyerName(), orderDto.getBuyerName())
                && Objects.equals(getPurchaseOrderNumber(), orderDto.getPurchaseOrderNumber())
                && Objects.equals(getShippingAddressName(), orderDto.getShippingAddressName())
                && Objects.equals(getShippingAddressLine1(), orderDto.getShippingAddressLine1())
                && Objects.equals(getShippingAddressCity(), orderDto.getShippingAddressCity())
                && Objects.equals(getShippingCityStateOrRegion(), orderDto.getShippingCityStateOrRegion())
                && Objects.equals(getShippingStateOrRegionPostalCode(), orderDto.getShippingStateOrRegionPostalCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAmazonOrderId(), getPurchaseDate(), getLastUpdateDate(), getOrderStatus(),
                getFulfillmentChannel(), getNumberOfItemsShipped(), getNumberOfItemsUnshipped(), getPaymentMethod(),
                getPaymentMethodDetails(), getMarketplaceId(), getShipmentServiceLevelCategory(), getOrderType(),
                getEarliestShipDate(), getLatestShipDate(), isBusinessOrder(), isPrime(), isGlobalExpressEnabled(),
                isPremiumOrder(), isSoldByAB(), getCompanyLegalName(), getBuyerEmail(), getBuyerName(),
                getPurchaseOrderNumber(), getShippingAddressName(), getShippingAddressLine1(), getShippingAddressCity(),
                getShippingCityStateOrRegion(), getShippingStateOrRegionPostalCode());
    }

    public static class OrdersDtoList {

        @JsonProperty("Orders")
        private List<OrderDto> orders;

        public List<OrderDto> getOrders() {
            return orders;
        }

        public void setOrders(List<OrderDto> orders) {
            this.orders = orders;
        }
    }
}
