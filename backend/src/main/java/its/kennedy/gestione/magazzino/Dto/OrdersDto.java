package its.kennedy.gestione.magazzino.Dto;

import java.time.Instant;

public class OrdersDto {
    private Integer amazonOrderId;

    private String buyerEmail;

    private String buyerName;

    private String companyLegalName;

    private Instant earliestShipDate;

    private String fulfillmentChannel;

    private Boolean isBusinessOrder;

    private Boolean isGlobalExpressEnabled;

    private Boolean isPremiumOrder;

    private Boolean isPrime;

    private Boolean isSoldByAB;

    private Instant lastUpdateDate;

    private Instant latestShipDate;

    private String marketplaceId;

    private Integer numberOfItemsShipped;

    private Integer numberOfItemsUnshipped;

    private String orderStatus;

    private String orderType;

    private String paymentMethod;

    private String paymentMethodDetails;

    private Instant PurchaseDate;

    private String purchaseOrderNumber;

    private String shipmentServiceLevelCategory;

    private String shippingAddressCity;

    private String shippingAddressLine1;

    private String shippingAddressName;

    private String shippingCityStateOrRegion;

    private String shippingStateOrRegionPostalCode;

    @Override
    public String toString() {
        return "OrdersDto{" +
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
}
