package its.kennedy.gestione.magazzino.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class OrdersDto {

    @JsonProperty("AmazonOrderId")
    public String amazonOrderId;

    @JsonProperty("PurchaseDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SS", timezone = "UTC")
    public Instant purchaseDate;

    @JsonProperty("LastUpdateDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SS", timezone = "UTC")
    public Instant lastUpdateDate;

    @JsonProperty("OrderStatus")
    public String orderStatus;

    @JsonProperty("FulfillmentChannel")
    public String fulfillmentChannel;

    @JsonProperty("NumberOfItemsShipped")
    public int numberOfItemsShipped;

    @JsonProperty("NumberOfItemsUnshipped")
    public int numberOfItemsUnshipped;

    @JsonProperty("PaymentMethod")
    public String paymentMethod;

    @JsonProperty("PaymentMethodDetails")
    public String paymentMethodDetails;

    @JsonProperty("MarketplaceId")
    public String marketplaceId;

    @JsonProperty("ShipmentServiceLevelCategory")
    public String shipmentServiceLevelCategory;

    @JsonProperty("OrderType")
    public String orderType;

    @JsonProperty("EarliestShipDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SS", timezone = "UTC")
    public Instant earliestShipDate;

    @JsonProperty("LatestShipDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SS", timezone = "UTC")
    public Instant latestShipDate;

    @JsonProperty("IsBusinessOrder")
    public boolean isBusinessOrder;

    @JsonProperty("IsPrime")
    public boolean isPrime;

    @JsonProperty("IsGlobalExpressEnabled")
    public boolean isGlobalExpressEnabled;

    @JsonProperty("IsPremiumOrder")
    public boolean isPremiumOrder;

    @JsonProperty("IsSoldByAB")
    public boolean isSoldByAB;

    @JsonProperty("CompanyLegalName")
    public String companyLegalName;

    @JsonProperty("BuyerEmail")
    public String buyerEmail;

    @JsonProperty("BuyerName")
    public String buyerName;

    @JsonProperty("PurchaseOrderNumber")
    public String purchaseOrderNumber;

    @JsonProperty("ShippingAddressName")
    public String shippingAddressName;

    @JsonProperty("ShippingAddressLine1")
    public String shippingAddressLine1;

    @JsonProperty("ShippingAddressCity")
    public String shippingAddressCity;

    @JsonProperty("ShippingCityStateOrRegion")
    public String shippingCityStateOrRegion;

    @JsonProperty("ShippingStateOrRegionPostalCode")
    public String shippingStateOrRegionPostalCode;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrdersDto ordersDto = (OrdersDto) o;
        return getNumberOfItemsShipped() == ordersDto.getNumberOfItemsShipped()
                && getNumberOfItemsUnshipped() == ordersDto.getNumberOfItemsUnshipped()
                && isBusinessOrder() == ordersDto.isBusinessOrder()
                && isPrime() == ordersDto.isPrime()
                && isGlobalExpressEnabled() == ordersDto.isGlobalExpressEnabled()
                && isPremiumOrder() == ordersDto.isPremiumOrder()
                && isSoldByAB() == ordersDto.isSoldByAB()
                && getAmazonOrderId().equals(ordersDto.getAmazonOrderId())
                && Objects.equals(getPurchaseDate(), ordersDto.getPurchaseDate())
                && Objects.equals(getLastUpdateDate(), ordersDto.getLastUpdateDate())
                && Objects.equals(getOrderStatus(), ordersDto.getOrderStatus())
                && Objects.equals(getFulfillmentChannel(), ordersDto.getFulfillmentChannel())
                && Objects.equals(getPaymentMethod(), ordersDto.getPaymentMethod())
                && Objects.equals(getPaymentMethodDetails(), ordersDto.getPaymentMethodDetails())
                && Objects.equals(getMarketplaceId(), ordersDto.getMarketplaceId())
                && Objects.equals(getShipmentServiceLevelCategory(), ordersDto.getShipmentServiceLevelCategory())
                && Objects.equals(getOrderType(), ordersDto.getOrderType())
                && Objects.equals(getEarliestShipDate(), ordersDto.getEarliestShipDate())
                && Objects.equals(getLatestShipDate(), ordersDto.getLatestShipDate())
                && Objects.equals(getCompanyLegalName(), ordersDto.getCompanyLegalName())
                && Objects.equals(getBuyerEmail(), ordersDto.getBuyerEmail())
                && Objects.equals(getBuyerName(), ordersDto.getBuyerName())
                && Objects.equals(getPurchaseOrderNumber(), ordersDto.getPurchaseOrderNumber())
                && Objects.equals(getShippingAddressName(), ordersDto.getShippingAddressName())
                && Objects.equals(getShippingAddressLine1(), ordersDto.getShippingAddressLine1())
                && Objects.equals(getShippingAddressCity(), ordersDto.getShippingAddressCity())
                && Objects.equals(getShippingCityStateOrRegion(), ordersDto.getShippingCityStateOrRegion())
                && Objects.equals(getShippingStateOrRegionPostalCode(), ordersDto.getShippingStateOrRegionPostalCode());
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
        List<OrdersDto> orders;

        public List<OrdersDto> getOrders() {
            return orders;
        }

        public void setOrders(List<OrdersDto> orders) {
            this.orders = orders;
        }
    }
}
