package its.kennedy.gestione.magazzino.Dao;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "Orders")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "AmazonOrderId")
    private String amazonOrderId;

    @Column(name = "PurchaseDate")
    private Instant purchaseDate;

    @Column(name = "LastUpdateDate")
    private Instant lastUpdateDate;

    @Column(name = "OrderStatus", length = 100)
    private String orderStatus;

    @Column(name = "FulfillmentChannel", length = 100)
    private String fulfillmentChannel;

    @Column(name = "NumberOfItemsShipped")
    private Integer numberOfItemsShipped;

    @Column(name = "NumberOfItemsUnshipped")
    private Integer numberOfItemsUnshipped;

    @Column(name = "PaymentMethod", length = 100)
    private String paymentMethod;

    @Column(name = "PaymentMethodDetails", length = 100)
    private String paymentMethodDetails;

    @Column(name = "MarketplaceId", length = 100)
    private String marketplaceId;

    @Column(name = "ShipmentServiceLevelCategory", length = 100)
    private String shipmentServiceLevelCategory;

    @Column(name = "OrderType", length = 100)
    private String orderType;

    @Column(name = "EarliestShipDate")
    private Instant earliestShipDate;

    @Column(name = "LatestShipDate")
    private Instant latestShipDate;

    @Column(name = "IsBusinessOrder")
    private Boolean isBusinessOrder;

    @Column(name = "IsPrime")
    private Boolean isPrime;

    @Column(name = "IsGlobalExpressEnabled")
    private Boolean isGlobalExpressEnabled;

    @Column(name = "IsPremiumOrder")
    private Boolean isPremiumOrder;

    @Column(name = "IsSoldByAB")
    private Boolean isSoldByAB;

    @Column(name = "CompanyLegalName", length = 100)
    private String companyLegalName;

    @Column(name = "BuyerEmail", length = 100)
    private String buyerEmail;

    @Column(name = "BuyerName", length = 100)
    private String buyerName;

    @Column(name = "PurchaseOrderNumber", length = 100)
    private String purchaseOrderNumber;

    @Column(name = "ShippingAddressName", length = 100)
    private String shippingAddressName;

    @Column(name = "ShippingAddressLine1", length = 100)
    private String shippingAddressLine1;

    @Column(name = "ShippingAddressCity", length = 100)
    private String shippingAddressCity;

    @Column(name = "ShippingCityStateOrRegion", length = 100)
    private String shippingCityStateOrRegion;

    @Column(name = "ShippingStateOrRegionPostalCode", length = 100)
    private String shippingStateOrRegionPostalCode;

    @Column(name = "orderSuccess")
    private Boolean orderSuccess;

    public String getAmazonOrderId() {
        return amazonOrderId;
    }

    public void setAmazonOrderId(String amazonOrderId) {
        this.amazonOrderId = amazonOrderId;
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

    public String getCompanyLegalName() {
        return companyLegalName;
    }

    public void setCompanyLegalName(String companyLegalName) {
        this.companyLegalName = companyLegalName;
    }

    public Instant getEarliestShipDate() {
        return earliestShipDate;
    }

    public void setEarliestShipDate(Instant earliestShipDate) {
        this.earliestShipDate = earliestShipDate;
    }

    public String getFulfillmentChannel() {
        return fulfillmentChannel;
    }

    public void setFulfillmentChannel(String fulfillmentChannel) {
        this.fulfillmentChannel = fulfillmentChannel;
    }

    public Boolean getBusinessOrder() {
        return isBusinessOrder;
    }

    public void setBusinessOrder(Boolean businessOrder) {
        isBusinessOrder = businessOrder;
    }

    public Boolean getGlobalExpressEnabled() {
        return isGlobalExpressEnabled;
    }

    public void setGlobalExpressEnabled(Boolean globalExpressEnabled) {
        isGlobalExpressEnabled = globalExpressEnabled;
    }

    public Boolean getPremiumOrder() {
        return isPremiumOrder;
    }

    public void setPremiumOrder(Boolean premiumOrder) {
        isPremiumOrder = premiumOrder;
    }

    public Boolean getPrime() {
        return isPrime;
    }

    public void setPrime(Boolean prime) {
        isPrime = prime;
    }

    public Boolean getSoldByAB() {
        return isSoldByAB;
    }

    public void setSoldByAB(Boolean soldByAB) {
        isSoldByAB = soldByAB;
    }

    public Instant getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Instant lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Instant getLatestShipDate() {
        return latestShipDate;
    }

    public void setLatestShipDate(Instant latestShipDate) {
        this.latestShipDate = latestShipDate;
    }

    public String getMarketplaceId() {
        return marketplaceId;
    }

    public void setMarketplaceId(String marketplaceId) {
        this.marketplaceId = marketplaceId;
    }

    public Integer getNumberOfItemsShipped() {
        return numberOfItemsShipped;
    }

    public void setNumberOfItemsShipped(Integer numberOfItemsShipped) {
        this.numberOfItemsShipped = numberOfItemsShipped;
    }

    public Integer getNumberOfItemsUnshipped() {
        return numberOfItemsUnshipped;
    }

    public void setNumberOfItemsUnshipped(Integer numberOfItemsUnshipped) {
        this.numberOfItemsUnshipped = numberOfItemsUnshipped;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
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

    public Instant getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Instant purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public String getShipmentServiceLevelCategory() {
        return shipmentServiceLevelCategory;
    }

    public void setShipmentServiceLevelCategory(String shipmentServiceLevelCategory) {
        this.shipmentServiceLevelCategory = shipmentServiceLevelCategory;
    }

    public String getShippingAddressCity() {
        return shippingAddressCity;
    }

    public void setShippingAddressCity(String shippingAddressCity) {
        this.shippingAddressCity = shippingAddressCity;
    }

    public String getShippingAddressLine1() {
        return shippingAddressLine1;
    }

    public void setShippingAddressLine1(String shippingAddressLine1) {
        this.shippingAddressLine1 = shippingAddressLine1;
    }

    public String getShippingAddressName() {
        return shippingAddressName;
    }

    public void setShippingAddressName(String shippingAddressName) {
        this.shippingAddressName = shippingAddressName;
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
    public String toString() {
        return "Order{" +
                "amazonOrderId=" + amazonOrderId +
                ", buyerEmail='" + buyerEmail + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", companyLegalName='" + companyLegalName + '\'' +
                ", earliestShipDate=" + earliestShipDate +
                ", fulfillmentChannel='" + fulfillmentChannel + '\'' +
                ", isBusinessOrder=" + isBusinessOrder +
                ", isGlobalExpressEnabled=" + isGlobalExpressEnabled +
                ", isPremiumOrder=" + isPremiumOrder +
                ", isPrime=" + isPrime +
                ", isSoldByAB=" + isSoldByAB +
                ", lastUpdateDate=" + lastUpdateDate +
                ", latestShipDate=" + latestShipDate +
                ", marketplaceId='" + marketplaceId + '\'' +
                ", numberOfItemsShipped=" + numberOfItemsShipped +
                ", numberOfItemsUnshipped=" + numberOfItemsUnshipped +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderType='" + orderType + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentMethodDetails='" + paymentMethodDetails + '\'' +
                ", PurchaseDate=" + purchaseDate + '\'' +
                ", purchaseOrderNumber='" + purchaseOrderNumber + '\'' +
                ", shipmentServiceLevelCategory='" + shipmentServiceLevelCategory + '\'' +
                ", shippingAddressCity='" + shippingAddressCity + '\'' +
                ", shippingAddressLine1='" + shippingAddressLine1 + '\'' +
                ", shippingAddressName='" + shippingAddressName + '\'' +
                ", shippingCityStateOrRegion='" + shippingCityStateOrRegion + '\'' +
                ", shippingStateOrRegionPostalCode='" + shippingStateOrRegionPostalCode + '\'' +
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
        Order order = (Order) o;
        return getAmazonOrderId().equals(order.getAmazonOrderId())
                && Objects.equals(getPurchaseDate(), order.getPurchaseDate())
                && Objects.equals(getLastUpdateDate(), order.getLastUpdateDate())
                && Objects.equals(getOrderStatus(), order.getOrderStatus())
                && Objects.equals(getFulfillmentChannel(), order.getFulfillmentChannel())
                && Objects.equals(getNumberOfItemsShipped(), order.getNumberOfItemsShipped())
                && Objects.equals(getNumberOfItemsUnshipped(), order.getNumberOfItemsUnshipped())
                && Objects.equals(getPaymentMethod(), order.getPaymentMethod())
                && Objects.equals(getPaymentMethodDetails(), order.getPaymentMethodDetails())
                && Objects.equals(getMarketplaceId(), order.getMarketplaceId())
                && Objects.equals(getShipmentServiceLevelCategory(), order.getShipmentServiceLevelCategory())
                && Objects.equals(getOrderType(), order.getOrderType())
                && Objects.equals(getEarliestShipDate(), order.getEarliestShipDate())
                && Objects.equals(getLatestShipDate(), order.getLatestShipDate())
                && Objects.equals(isBusinessOrder, order.isBusinessOrder)
                && Objects.equals(isPrime, order.isPrime)
                && Objects.equals(isGlobalExpressEnabled, order.isGlobalExpressEnabled)
                && Objects.equals(isPremiumOrder, order.isPremiumOrder)
                && Objects.equals(isSoldByAB, order.isSoldByAB)
                && Objects.equals(getCompanyLegalName(), order.getCompanyLegalName())
                && Objects.equals(getBuyerEmail(), order.getBuyerEmail())
                && Objects.equals(getBuyerName(), order.getBuyerName())
                && Objects.equals(getPurchaseOrderNumber(), order.getPurchaseOrderNumber())
                && Objects.equals(getShippingAddressName(), order.getShippingAddressName())
                && Objects.equals(getShippingAddressLine1(), order.getShippingAddressLine1())
                && Objects.equals(getShippingAddressCity(), order.getShippingAddressCity())
                && Objects.equals(getShippingCityStateOrRegion(), order.getShippingCityStateOrRegion())
                && Objects.equals(getShippingStateOrRegionPostalCode(), order.getShippingStateOrRegionPostalCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAmazonOrderId(), getPurchaseDate(), getLastUpdateDate(), getOrderStatus(),
                getFulfillmentChannel(), getNumberOfItemsShipped(), getNumberOfItemsUnshipped(), getPaymentMethod(),
                getPaymentMethodDetails(), getMarketplaceId(), getShipmentServiceLevelCategory(), getOrderType(),
                getEarliestShipDate(), getLatestShipDate(), isBusinessOrder, isPrime, isGlobalExpressEnabled,
                isPremiumOrder, isSoldByAB, getCompanyLegalName(), getBuyerEmail(), getBuyerName(),
                getPurchaseOrderNumber(), getShippingAddressName(), getShippingAddressLine1(), getShippingAddressCity(),
                getShippingCityStateOrRegion(), getShippingStateOrRegionPostalCode());
    }
}
