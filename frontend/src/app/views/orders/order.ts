export class Order {

    AmazonOrderId!: string;
    BuyerEmail!: string;
    BuyerName!: string;
    CompanyLegalName!:string;
    EarliestShipDate!:Date;
    FulfillmentChannel!: string;
    IsBusinessOrder!: number;
    IsGlobalExpressEnabled!: number;
    IsPremiumOrder!: number;
    IsPrime!: number;
    IsSoldByAB!: number;
    LastUpdateDate!: Date;
    LatestShipDate!: Date;
    MarketplaceId!: string;
    NumberOfItemsShipped!: number;
    NumberOfItemsUnshipped!: number;
    OrderStatus!: string;
    OrderType!: string;
    PaymentMethod!: string;
    PaymentMethodDetails!: string;
    PurchaseDate!: Date;
    PurchaseOrderNumber!: string;
    ShipmentServiceLevelCategory!: string;
    ShippingAddressCity!: string;
    ShippingAddressLine1!: string;
    ShippingAddressName!: string;
    ShippingCityStateOrRegion!:string;
    ShippingStateOrRegionPostalCode!:string;
    
}