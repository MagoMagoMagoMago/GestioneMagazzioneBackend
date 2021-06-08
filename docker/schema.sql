CREATE DATABASE IF NOT EXISTS GestioneMagazzino;
USE GestioneMagazzino;

CREATE TABLE Categories (
	Id int auto_increment,
	Name varchar(100),
	Description varchar(400),
	CreatedAt timestamp,
	UpdatedAt timestamp,
	DeletedAt timestamp,
	PRIMARY KEY (Id)
);

INSERT INTO Categories (Name,Description,CreatedAt,UpdatedAt,DeletedAt) VALUES 
('Orologi','Orologio meccanici, al quarzo, e hibridi','2021-06-08 16:09:52',NULL,NULL)
,('Sport','Abbigliamento e attrezzatura sportiva','2021-06-08 18:09:52',NULL,NULL)
,('Giochi','Giochi fisici e software','2021-06-08 20:09:52',NULL,NULL)
,('Alimentari','Cibi e bevande','2021-06-08 22:09:52',NULL,NULL)
,('Altro','Altro...','2021-06-08 23:04:52',NULL,NULL);

CREATE TABLE Items (
	Id int auto_increment,
	Asin char(10) not null unique,
	Title varchar(100) not null,
	Description varchar (400),
	CategoryId int not null,
	Price double not null,
	Storage int not null,
	CreateAt timestamp not null,
	UpdatedAt timestamp,
	DeletedAt timestamp,
	PRIMARY KEY (Id),
	FOREIGN KEY (CategoryId) REFERENCES Categories(Id)
);

CREATE TABLE Suppliers (
	Id int auto_increment,
	Name varchar(100) not null,
	Indirizzo varchar(100) not null,
	Email varchar(100) not null,
	Telefono varchar(100) not null,
	Nazione varchar(100) not null,
	Note varchar(400),
	CreateAt timestamp not null,
	UpdatedAt timestamp,
	DeletedAt timestamp,
	PRIMARY KEY (Id)
);

CREATE TABLE Purchases (
	Id int auto_increment,
	SupplierId int not null,
	NumberInvoice int not null,
	DateInvoice timestamp not null,
	Note varchar(400),
	CreateAt timestamp not null,
	UpdatedAt timestamp,
	DeletedAt timestamp,
	PRIMARY KEY (Id),
	FOREIGN KEY (SupplierId) REFERENCES Suppliers(Id)
);

CREATE TABLE PurchaseItems (
	Id int auto_increment,
	PurchaseId int not null,
	ItemId int not null,
	Quantity int not null,
	UnitPrice double not null,
	CreateAt timestamp,
	UpdatedAt timestamp,
	DeletedAt timestamp,
	PRIMARY KEY (Id),
	FOREIGN KEY (PurchaseId) REFERENCES Purchases(Id),
	FOREIGN KEY (ItemId) REFERENCES Items(Id)
);

CREATE TABLE Users (
	Id int auto_increment,
	Name varchar(100) not null,
	Surname varchar(100) not null,
	BornAt varchar(100) not null,
	BirthDate Date not null,
	Email varchar(100) not null,
	UserName varchar(100) not null,
	Password varchar(100) not null,
	CreateAt timestamp not null,
	UpdatedAt timestamp,
	DeletedAt timestamp,
	PRIMARY KEY (Id)
);

INSERT INTO Users (Name,Surname,BornAt,BirthDate,Email,UserName,Password,CreateAt,UpdatedAt,DeletedAt) VALUES 
('Admin','Admin','Padova','2000-04-16','admin@gmail.com','admin','admin','2021-06-08 16:09:52',NULL,NULL);

CREATE TABLE Orders(
  AmazonOrderId varchar(19),
  BuyerEmail varchar(100),
  BuyerName varchar(100),
  CompanyLegalName varchar(100),
  EarliestShipDate date,
  FulfillmentChannel varchar(100),
  IsBusinessOrder boolean,
  IsGlobalExpressEnabled boolean,
  IsPremiumOrder boolean,
  IsPrime boolean,
  IsSoldByAB boolean,
  LastUpdateDate timestamp,
  LatestShipDate timestamp,
  MarketplaceId varchar(100),
  NumberOfItemsShipped int,
  NumberOfItemsUnshipped int,
  OrderStatus varchar(100),
  OrderType varchar(100),
  PaymentMethod varchar(100),
  PaymentMethodDetails varchar(100),
  PurchaseDate timestamp,
  PurchaseOrderNumber varchar(100),
  ShipmentServiceLevelCategory varchar(100),
  ShippingAddressCity varchar(100),
  ShippingAddressLine1 varchar(100),
  ShippingAddressName varchar(100),
  ShippingCityStateOrRegion varchar(100),
  ShippingStateOrRegionPostalCode varchar(100),
  PRIMARY KEY (AmazonOrderId)
);

CREATE TABLE OrderItems(
	OrderItemId int auto_increment,
	AmazonOrderId varchar(19),
	ASIN char(10) NOT NULL,
	Title varchar(100),
	QuantityOrdered int,
	QuantityShipped int,
	PointsGrantedPointsNumber int,
	PointsGrantedPointsMonetaryValueCurrencyCode varchar(100),
	PointsGrantedPointsMonetaryValueAmount int,
	ItemPriceCurrencyCode varchar(100),
	ItemPriceAmount float,
	ShippingPriceCurrencyCode varchar(100),
	ShippingPriceAmount int,
	PromotionIds varchar(100),
	PRIMARY KEY (OrderItemId),
	FOREIGN KEY (AmazonOrderId) REFERENCES Orders(AmazonOrderId),
	FOREIGN KEY (ASIN) REFERENCES Items(Asin)
);





