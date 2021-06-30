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


INSERT INTO GestioneMagazzino.suppliers (name,indirizzo,telefono,nazione,note,created_at,updated_at,deleted_at,email) VALUES 
('Bailocom','via Roma 43','3278468482','Italia','Produttore insacchi per i salumi','2021-12-14 00:00:00',NULL,NULL,'bailocom@gmail.com')
,('Pitarello','via degli Alpini','3425485444','Italia','Produttore di scarpe in pelle di asino','2021-09-21 00:00:00',NULL,NULL,'pitarello@gmail.com')
,('Benzo','via Verdi 21','3254541215','Italia','','2021-09-21 00:00:00',NULL,NULL,'benzo@gmail.com')
,('Gango','Street wall 31','4234564418','Stati Uniti','Azienda di consulenze','2021-09-21 00:00:00',NULL,NULL,'gango@gmail.com')
,('Corvallis','via Savelli 12','313121412','Italia','Servizi informatici','2021-09-21 00:00:00',NULL,NULL,'corvallis@gmail.com')
,('Forema','via d''orata 12','3211545644','Italai','Azienda informatica','2021-09-21 00:00:00',NULL,NULL,'forema@gmail.com')
;

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


INSERT INTO GestioneMagazzino.purchases
(supplier_id, number_invoice, date_invoice, note, created_at, updated_at, deleted_at)
VALUES
(2, 3, '2021-12-14 12:04:01', 'Scarpe di Pelle', '2021-12-14 12:04:01', NULL, NULL),
(3, 4, '2021-12-14 12:04:01', 'Sacco a Pelo', '2021-12-14 12:04:01', NULL, NULL),
(4, 4, '2021-12-14 12:04:01', 'Consulenza filosofica', '2021-12-14 12:04:01', NULL, NULL),
(5, 5, '2021-12-14 12:04:01', 'App e-commerce', '2021-12-14 12:04:01', NULL, NULL),
(5, 6, '2021-12-14 12:04:01', 'Blog acquisti vestiti', '2021-12-14 12:04:01', NULL, NULL),
(5, 7, '2021-12-14 12:04:01', 'Consulenza IT', '2021-12-14 12:04:01', NULL, NULL),
(2, 8, '2021-12-14 12:04:01', 'Scarpe Corsa', '2021-12-14 12:04:01', NULL, NULL),
(2, 9, '2021-12-14 12:04:01', 'Scarponi Snowboard', '2021-12-14 12:04:01', NULL, NULL),
(2, 10, '2021-12-14 12:04:01', 'Scarpe Skate', '2021-12-14 12:04:01', NULL, NULL),
(1, 11, '2021-12-14 12:04:01', 'Torta alle Mele', '2021-12-14 12:04:01', NULL, NULL);

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

INSERT INTO GestioneMagazzino.purchase_items
(purchase_id, item_id, quantity, unit_price, created_at, updated_at, deleted_at)
VALUES
(2, 109, 50, 32.85, '2021-02-14 12:04:01', null, null),
(3, 110, 30, 33.85, '2021-02-14 12:04:01', null, null),
(4, 110, 1, 5.85, '2021-10-14 12:04:01', null, null),
(5, 111, 2, 2.85, '2021-12-14 12:04:01', null, null),
(6, 112, 5, 6.85, '2021-12-14 12:04:01', null, null),
(7, 113, 5, 20.85, '2021-12-14 12:04:01', null, null),
(8, 114, 6, 21.85, '2021-12-14 12:04:01', null, null),
(9, 115, 1, 42.85, '2021-12-14 12:04:01', null, null),
(8, 116, 30, 2.85, '2021-12-14 12:04:01', null, null),
(9, 117, 6, 65.75, '2021-12-14 12:04:01', null, null),
(9, 118, 67, 27.5, '2021-12-14 12:04:01', null, null),
(5, 119, 9, 2.0, '2021-12-14 12:04:01', null, null),
(6, 120, 90, 22.77, '2021-12-14 12:04:01', null, null),
(7, 121, 21, 8.70, '2021-12-14 12:04:01', null, null),
(8, 107, 45, 7.83, '2021-12-14 12:04:01', null, null),
(10, 107, 6, 12.85, '2021-12-14 12:04:01', null, null),
(11, 111, 70, 27.5, '2021-12-14 12:04:01', null, null),
(12, 112, 13, 2.0, '2021-12-14 12:04:01', null, null),
(12, 113, 11, 22.77, '2021-12-14 12:04:01', null, null),
(11, 114, 12, 8.70, '2021-12-14 12:04:01', null, null),
(10, 115, 15, 7.83, '2021-12-14 12:04:01', null, null),
(12, 116, 4, 12.85, '2021-12-14 12:04:01', null, null);

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
  orderSuccess tinyint(1),
  PRIMARY KEY (AmazonOrderId)
);

CREATE TABLE OrderItems(
	OrderItemId int auto_increment,
	AmazonOrderId varchar(19),
	ASIN char(10) NOT NULL,
	Title varchar(500),
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
	orderSuccess tinyint(1),
	PRIMARY KEY (OrderItemId),
	FOREIGN KEY (AmazonOrderId) REFERENCES Orders(AmazonOrderId),
	FOREIGN KEY (ASIN) REFERENCES items(asin)
);





