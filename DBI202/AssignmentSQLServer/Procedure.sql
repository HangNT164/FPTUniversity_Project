/*1.Nhận được tất cả các sản phẩm từ một OrderID như đầu vào*/
create proc SP_GetTotalProduct @orderid nvarchar(50),@total int output
as
begin
	set @total =
	(select count(ProductID) 
	from OrderDetail 
	where OrderID = @orderid)
end

declare @c int
exec SP_GetTotalProduct 'Or001', @c output
print @c


/*2.Viết thủ tục nhận tham số customerID
=> hiển thị toàn bộ thông tin của 1 khách hàng
*/
create proc pro1 @customerID nvarchar(50)
as 
begin
		select * from Customers 
		where CustomerID=@customerID
end

exec pro1 'KH005'
