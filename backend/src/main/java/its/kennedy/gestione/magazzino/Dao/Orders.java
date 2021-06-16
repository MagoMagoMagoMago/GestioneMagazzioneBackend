package its.kennedy.gestione.magazzino.Dao;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "Orders")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AmazonOrderId")
    private Integer amazonOrderId;

    @Column(name = "BuyerEmail", length = 100)
    private String buyerEmail;

    @Column(name = "BuyerName", length = 100)
    private String buyerName;

    @Column(name = "CompanyLegalName", length = 100)
    private String companyLegalName;

    @Column(name = "EarliestShipDate")
    private Instant earliestShipDate;

    @Column(name = "FulfillmentChannel", length = 100)
    private String fulfillmentChannel;

    @Column(name = "IsBusinessOrder")
    private Boolean isBusinessOrder;

    @Column(name = "IsGlobalExpressEnabled")
    private Boolean isGlobalExpressEnabled;

    @Column(name = "IsPremiumOrder")
    private Boolean isPremiumOrder;

    @Column(name = "IsPrime")
    private Boolean isPrime;

    @Column(name = "IsSoldByAB")
    private Boolean isSoldByAB;

    @Column(name = "LastUpdateDate")
    private Instant lastUpdateDate;

    @Column(name = "LatestShipDate")
    private Instant latestShipDate;

    @Column(name = "MarketplaceId", length = 100)
    private String marketplaceId;

    @Column(name = "NumberOfItemsShipped")
    private Integer numberOfItemsShipped;

    @Column(name = "NumberOfItemsUnshipped")
    private Integer numberOfItemsUnshipped;

    @Column(name = "OrderStatus", length = 100)
    private String orderStatus;

    @Column(name = "OrderType", length = 100)
    private String orderType;

    @Column(name = "PaymentMethod", length = 100)
    private String paymentMethod;

    @Column(name = "PaymentMethodDetails", length = 100)
    private String paymentMethodDetails;

    @Column(name = "PurchaseDate")
    private Instant PurchaseDate;

    @Column(name = "PurchaseOrderNumber", length = 100)
    private String purchaseOrderNumber;

    @Column(name = "ShipmentServiceLevelCategory", length = 100)
    private String shipmentServiceLevelCategory;

    @Column(name = "ShippingAddressCity", length = 100)
    private String shippingAddressCity;

    @Column(name = "ShippingAddressLine1", length = 100)
    private String shippingAddressLine1;

    @Column(name = "ShippingAddressName", length = 100)
    private String shippingAddressName;

    @Column(name = "ShippingCityStateOrRegion", length = 100)
    private String shippingCityStateOrRegion;

    @Column(name = "ShippingStateOrRegionPostalCode", length = 100)
    private String shippingStateOrRegionPostalCode;

    public Integer getAmazonOrderId() {
        return amazonOrderId;
    }

    public void setAmazonOrderId(Integer amazonOrderId) {
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
        return PurchaseDate;
    }

    public void setPurchaseDate(Instant purchaseDate) {
        PurchaseDate = purchaseDate;
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

    @Override
    public String toString() {
        return "Orders{" +
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
                ", PurchaseDate=" + PurchaseDate +
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
        Orders orders = (Orders) o;
        return getAmazonOrderId().equals(orders.getAmazonOrderId())
                && Objects.equals(getBuyerEmail(), orders.getBuyerEmail())
                && Objects.equals(getBuyerName(), orders.getBuyerName())
                && Objects.equals(getCompanyLegalName(), orders.getCompanyLegalName())
                && Objects.equals(getEarliestShipDate(), orders.getEarliestShipDate())
                && Objects.equals(getFulfillmentChannel(), orders.getFulfillmentChannel())
                && Objects.equals(isBusinessOrder, orders.isBusinessOrder)
                && Objects.equals(isGlobalExpressEnabled, orders.isGlobalExpressEnabled)
                && Objects.equals(isPremiumOrder, orders.isPremiumOrder)
                && Objects.equals(isPrime, orders.isPrime)
                && Objects.equals(isSoldByAB, orders.isSoldByAB)
                && Objects.equals(getLastUpdateDate(), orders.getLastUpdateDate())
                && Objects.equals(getLatestShipDate(), orders.getLatestShipDate())
                && Objects.equals(getMarketplaceId(), orders.getMarketplaceId())
                && Objects.equals(getNumberOfItemsShipped(), orders.getNumberOfItemsShipped())
                && Objects.equals(getNumberOfItemsUnshipped(), orders.getNumberOfItemsUnshipped())
                && Objects.equals(getOrderStatus(), orders.getOrderStatus())
                && Objects.equals(getOrderType(), orders.getOrderType())
                && Objects.equals(getPaymentMethod(), orders.getPaymentMethod())
                && Objects.equals(getPaymentMethodDetails(), orders.getPaymentMethodDetails())
                && Objects.equals(getPurchaseDate(), orders.getPurchaseDate())
                && Objects.equals(getPurchaseOrderNumber(), orders.getPurchaseOrderNumber())
                && Objects.equals(getShipmentServiceLevelCategory(), orders.getShipmentServiceLevelCategory())
                && Objects.equals(getShippingAddressCity(), orders.getShippingAddressCity())
                && Objects.equals(getShippingAddressLine1(), orders.getShippingAddressLine1())
                && Objects.equals(getShippingAddressName(), orders.getShippingAddressName())
                && Objects.equals(getShippingCityStateOrRegion(), orders.getShippingCityStateOrRegion())
                && Objects.equals(getShippingStateOrRegionPostalCode(), orders.getShippingStateOrRegionPostalCode());
    }
}
