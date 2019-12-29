Create database Assignment
/*4.Tao bang cho CSDL*/

/*Table 1.Suppliers*/
create table Suppliers 
(
	SupplierID  nvarchar(50) primary key,
	SupplierName nvarchar(50) ,
	Phone nvarchar(20),
	Address nvarchar(50),
	HomePage nvarchar(30)
)

/* Table 2.Categories*/
create table Categories
(
	CategoryID nvarchar(50) primary key,
	CategoryName nvarchar(200) NOT NULL,
	Description nvarchar(500)
)

/*Table 3.Products*/
create table Products
(
	ProductID nvarchar(50) primary key,
	ProductName nvarchar(30) NOT NULL,
	SupplierID nvarchar(50) NOT NULL references Suppliers(SupplierID),
	CategoryID nvarchar(50) NOT NULL references Categories(CategoryID),
	Quantity int NOT NULL,
	PricePer float NOT NULL
)

/* Table 4.Customers*/
create table Customers 
(
	CustomerID nvarchar(50) primary key,
	CustomerName nvarchar(20) NOT NULL,
	Gender nvarchar(6) NOT NULL,
	Phone nvarchar(20)  ,
	Address nvarchar(50),
	Email nvarchar(30)
)

/*Table 5.Shippers*/
create table Shippers
(
	ShipperID nvarchar(50) primary key,
	ShipperName nvarchar(20) NOT NULL
)

/* Table 6.Orders*/
create table Orders
(
	OrderID nvarchar(50) primary key,
	CustomerID nvarchar(50) NOT NULL ,
	ShipperID nvarchar(50) NOT NULL,
	Payment nvarchar(20) NOT NULL,
	Date date NOT NULL,
	ShipDate date NOT NULL,
	constraint FK_Orders_Customers foreign key (CustomerID)
	references Customers(CustomerID),
	constraint FK_Orders_Shippers foreign key (ShipperID)
	references Shippers(ShipperID),
	constraint CK_Orders_Date check (ShipDate >= Date)
)

/*Table 7.OrderDetail*/
create table OrderDetail
(
	OrderID nvarchar(50) NOT NULL,
	ProductID nvarchar(50) NOT NULL,
	Discount int NOT NULL,
	constraint FK_OrderDetail_Orders foreign key (OrderID)
	references Orders(OrderID),
	constraint FK_OrderDetail_Products foreign key (ProductID)
	references Products(ProductID),
	constraint PK_OrderDetail primary key (OrderID, ProductID)
)
