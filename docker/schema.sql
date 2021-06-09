CREATE DATABASE IF NOT EXISTS GestioneMagazzino;
USE GestioneMagazzino;

CREATE TABLE categories (
	id int auto_increment,
	name varchar(100),
	description varchar(400),
	created_at timestamp not null,
	updated_at timestamp,
	deleted_at timestamp,
	PRIMARY KEY (id)
);

INSERT INTO categories (name,description,created_at,updated_at,deleted_at) VALUES 
('Orologi','Orologio meccanici, al quarzo, e hibridi','2021-06-08 16:09:52',NULL,NULL)
,('Sport','Abbigliamento e attrezzatura sportiva','2021-06-08 18:09:52',NULL,NULL)
,('Giochi','Giochi fisici e software','2021-06-08 20:09:52',NULL,NULL)
,('Alimentari','Cibi e bevande','2021-06-08 22:09:52',NULL,NULL)
,('Altro','Altro...','2021-06-08 23:04:52',NULL,NULL);

CREATE TABLE items (
	id int auto_increment,
	asin char(10) not null unique,
	title varchar(100) not null,
	description varchar (400),
	category_id int not null,
	price double not null,
	storage int not null,
	image varchar(400) not null,
	min_availability int not null,
	created_at timestamp not null,
	updated_at timestamp,
	deleted_at timestamp,
	PRIMARY KEY (id),
	FOREIGN KEY (category_id) REFERENCES categories(id)
);

CREATE TABLE suppliers (
	id int auto_increment,
	name varchar(100) not null,
	indirizzo varchar(100) not null,
	rmail varchar(100) not null,
	telefono varchar(100) not null,
	nazione varchar(100) not null,
	note varchar(400),
	created_at timestamp not null,
	updated_at timestamp,
	deleted_at timestamp,
	PRIMARY KEY (id)
);

CREATE TABLE purchases (
	id int auto_increment,
	supplier_id int not null,
	number_invoice int not null,
	date_invoice timestamp not null,
	note varchar(400),
	created_at timestamp not null,
	updated_at timestamp,
	deleted_at timestamp,
	PRIMARY KEY (id),
	FOREIGN KEY (supplier_id) REFERENCES suppliers(id)
);

CREATE TABLE purchase_items (
	id int auto_increment,
	purchase_id int not null,
	item_id int not null,
	quantity int not null,
	unit_price double not null,
	created_at timestamp not null,
	updated_at timestamp,
	deleted_at timestamp,
	PRIMARY KEY (id),
	FOREIGN KEY (purchase_id) REFERENCES purchases(id),
	FOREIGN KEY (item_id) REFERENCES items(id)
);

CREATE TABLE users (
	id int auto_increment,
	name varchar(100) not null,
	surname varchar(100) not null,
	born_at varchar(100) not null,
	birthdate Date not null,
	email varchar(100) not null,
	username varchar(100) not null,
	password varchar(100) not null,
	created_at timestamp not null,
	updated_at timestamp,
	deleted_at timestamp,
	PRIMARY KEY (id)
);

INSERT INTO users (name,surname,born_at,birthdate,email,username,password,created_at,updated_at,deleted_at) VALUES 
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
	FOREIGN KEY (ASIN) REFERENCES items(asin)
);





