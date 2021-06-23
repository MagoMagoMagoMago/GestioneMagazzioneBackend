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

INSERT INTO items
(asin, title, description, category_id, price, storage, image, min_availability, created_at, updated_at, deleted_at) VALUES
('B07D9SB7XW', 'Minecraft', 'Giochi', 3, 25.99, 300, '', 10, '2021-12-15', null, null),
('B07VK4QKBP', 'Set Bilanciere e Dischi', '7Kg, 8 Dischi rivestiti in PVC', 2, 199.95, 20, '', 30, '2021-12-15', null, null),
('B00DBVGF4L', 'Tavolo Ping Pong', 'Sport super competitivi', 2, 10.50, 2000, '', 10, '2021-12-15', '2021-12-01', null),
('B08GPCZ4CL', 'Huawei GT', 'Orologio sportivo GPS', 1, 200.50, 500, '', 50, '2021-12-15', '2021-12-01', null),
('B00J7V47DL', 'Succo alla pesca', 'Bbbono', 4, 30.50, 205, '', 10, '2021-12-15', '2021-12-01', null),
('B07K495TYT', 'Carne cotta', 'Grigliata', 4, 10.00, 10000, '', 50, '2020-12-10', '2021-01-12', null),
('B00DBVGF4T', 'Palla da Volleyball', 'Sport', 2, 1.50, 2000, '', 10, '2021-12-15', '2021-12-01', null),
('B08GPCZ4CT', 'Google Pixel', 'Android', 5, 300.50, 500, '', 50, '2021-12-15', '2021-12-01', null),
('B00J7V47DT', 'Finestra', 'Vetro', 5, 12.50, 205, '', 10, '2021-12-15', '2021-12-01', null),
('B07K495TYN', 'Lucina Unicorno', 'Luci Notturne', 5, 20.00, 10000, '', 50, '2020-12-10', '2021-01-12', '2021-02-13'),
('B00DBVGF4K', 'Moschettone', 'Moschettoni Sport', 2, 10.50, 2000, '', 10, '2021-12-15', '2021-12-01', null),
('B08GPCZ4C9', 'Coros Pace 2', 'Orologio sportivo GPS', 1, 199.50, 500, '', 50, '2021-12-15', '2021-12-01', null),
('B00J7V47DE', 'Rinvio Nylon', 'Rinvii per arrampicata', 4, 20.50, 205, '', 10, '2021-12-15', '2021-12-01', null),
('B08KSS6CLT', 'Tè Nero alla Pesca', '20 filtri, 30 g', 4, 1.85, 170, '', 10, '2020-12-10', '2021-01-12', '2021-02-13'),
('B08123PCJH', 'Aria Fritta Spray', 'Bomboletta Spray Antisfiga', 5, 12, 100, '', 30, '2021-12-15', null, null);

CREATE TABLE suppliers (
	id int auto_increment,
	name varchar(100) not null,
	indirizzo varchar(100) not null,
	email varchar(100) not null,
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
	email varchar(100) not null unique,
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
  EarliestShipDate timestamp,
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





