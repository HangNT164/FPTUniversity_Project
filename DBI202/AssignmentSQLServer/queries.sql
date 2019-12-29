/*a.Query using inner join.*/

	/*1.Hiện thị ra ProductID, ProductName và SupplierID, SupplierName của nó*/

select ProductID,ProductName,Suppliers.SupplierID,SupplierName
from Products inner join Suppliers
on Products.SupplierID=Suppliers.SupplierID

	/*2.Hiển thị ra customerID,customerName,orderID cuả 2 bảng customers,orders */

select Customers.CustomerID,CustomerName,OrderID
from Customers inner join Orders
on Customers.CustomerID=Orders.CustomerID

/*b.Query using outer join.*/

	/*1.Hiển thị customerName,customerID,orderID  của tất cả các khách hàng
(Kể cả nhưng người không mua sản phẩm)*/

select  Customers.CustomerID,CustomerName,OrderID
from Customers left  outer join Orders
on Customers.CustomerID=Orders.CustomerID

	/*2.Hiển thị tất cả thông tin của nhà cung cấp(suppliers) 
không có trong bảng products theo thứ tự tăng dần của supplierID*/

select  SupplierID,SupplierName
from Suppliers
where SupplierID not in (select  Suppliers.SupplierID
from Suppliers right outer join Products
on Suppliers.SupplierID=Products.SupplierID)
order by SupplierID 

	/*3.Hiển thị tất cả thông tin của nhà cung cấp(suppliers)
có trong bảng products theo thứ tự giảm dầncủa supplierID */

select distinct suppliers.SupplierID,SupplierName
from Suppliers right outer join Products
on Suppliers.SupplierID=Products.SupplierID
order by Suppliers.SupplierID desc

/*c.Using subquery in where.*/

	/*1.Hiển thị tất cả các sản phẩm được sắp xếp theo giá giảm dần (sử dụng in where )*/

select ProductID, ProductName,price
from Products 
where ProductID IN 
	(select ProductID from OrderDetail)
order by price desc

	/*2.Hiện thị supplierName,supplierID không có trong bảng suppliers
và sắp xếp theo supplierName 
*/

select supplierName,supplierID
from Suppliers
where SupplierID  in 
	(select SupplierID from Shippers)
order by SupplierName
	
	/*3.Hiển thị tất cả các giá trong bảng products 
có giá lớn hơn hoặc bằng giá trung bình */

select *
from products
where price >
(select avg(price) from Products)

	/*4. Liệt kê tất cả các sản phẩm có Giá lớn hơn 
tất cả giá của ‘TiVi Led SamSung' và‘ Điều Hòa Tủ Đứng LG*/

select *
from products
where price > all 
(select price from products
where ProductName=N'TiVi Led SamSung' or ProductName=N'Điều Hòa Tủ Đứng LG')

/*d.Using subquery in from.*/

	/*1.Hiển thị CustomerName, OrderID và Total Product – cái mà họ đã đặt hàng.*/

select CustomerName, OrderID, [Total Product]
from Customers Cu,
	(select CustomerID, O.OrderID, COUNT (ProductID) as [Total Product] 
from Orders O, OrderDetail Ord
where O.OrderID = Ord.OrderID
group by CustomerID, O.OrderID)as R
where R.CustomerID = Cu.CustomerID

	/*2.Hiển thị những khách hàng mua đơn hàng,discount,price có discount >=50 && discount<=500
và sắp xếp discount theo thứ tự tăng dần
*/

select  Customers.*,Discount,price
from Orders,Products,Customers,
(select * from OrderDetail
where discount in 
	(select discount
	from OrderDetail
	where discount>=5 and discount<=50
	)
) as orderDetailNew
where Orders.OrderID=orderDetailNew.OrderID
and  Customers.CustomerID=Orders.CustomerID
and Products.ProductID=orderDetailNew.ProductID
order by discount 

/*e.Query using group by and aggregate functions.*/

	/*1.Hiển thị tất cả các sản phẩm và tất cả các đơn đặt hàng của nó 
	có chứa nó và lớn hơn hoặc bằng 3.*/

select O.ProductID, ProductName, count(OrderID) as [Total Order] 
from OrderDetail O, Products P
where O.ProductID = P.ProductID
group by O.ProductID, ProductName
having count(OrderID) >= 3

	/*2.Hiển thị CustomerName, OrderID và Total Product – cái mà họ đã đặt hàng
total Product >=2*/

select CustomerName, OrderID, [Total Product]
from Customers Cu,
	(select CustomerID, O.OrderID, COUNT (ProductID) as [Total Product] 
from Orders O, OrderDetail Ord
where O.OrderID = Ord.OrderID
group by CustomerID, O.OrderID
having COUNT (ProductID)>=2) as R
where R.CustomerID = Cu.CustomerID

/*f.users self-join*/
	/*1.Hiển thị tất cả sản phẩm có cùng Suppliers */

select P1.ProductID, P1.ProductName, P2.ProductID, P2.ProductName
from Products P1, Products P2
where P1.ProductID < P2.ProductID
AND P1.SupplierID = P2.SupplierID
	/*2.Hiển thị tất cả orderID  có cùng ProductID */

select distinct O1.*
from OrderDetail O1, OrderDetail O2
where O1.OrderID < O2.OrderID
AND O1.ProductID = O2.ProductID

