/*1.Dùng trigger Ngày ship phải lớn hơn hoặc bằng ngày order*/
create trigger checkdate 
ON Orders
after  insert, update
as
begin
	if exists (select * from Orders where ShipDate < Date)
	begin
		raiserror('The ShipDate must be greater or equal order Date',1,1)
		rollback
	end
end

	/*Test trigger*/
insert into Orders
values ('Or016','KH015','SH007','Cash','1 Jan 2016','1 Jan 2017')

insert into Orders
values ('Or017','KH015','SH009','Cash','1 Jan 2018','1 Jan 2017')

/*2.Dùng trigger vs bang products .nếu nhập quantity <0 
=> ko cho người dùng nhập
*/
create trigger checkQuantity
on products
after  insert 
as
begin
	if exists (select * from products where QuantityPerUnit < 0)
	begin
		raiserror('You must enter a quantityPerUnit >=0',1,1)
		rollback transaction
	end
end

/*Test trigger*/
insert into products
values
('P020','ProductA','SU002','CA002',-5,0);

insert into products
values
('P020','ProductA','SU002','CA002',1005,25101159);
/*3.Dùng trigger vs bảng products và orderDetail 
Nếu sum discount của các sản phẩm <= sum quantityPerUnit=>cho insert.
*/
select * from OrderDetail
create trigger q3
on orderDetail
instead of insert
as 
begin
	declare @discount int
	select @discount=discount from inserted
	declare @sum int 
	select @sum=(select sum(discount)from OrderDetail)
	declare @sum1 int
	select @sum1=(select sum(quantityPerUnit)from Products)
	if(@sum<=@sum1)
		begin
			insert into OrderDetail
			select * from inserted
		end
end

/*Test trigger*/
insert into OrderDetail
values
('Or002','P016',10,20);
select * from OrderDetail

/*4.Hiển thị số dòng vừa insert vào customers*/

create  trigger q4
on customers
for insert  
as 
begin 
	declare @insertedRow int
	select @insertedRow =count(*)
	from inserted
	print cast(@insertedRow as nvarchar(5))+'rows are inserted'
end

/*test trigger*/
insert into Customers
values
('C11',N'Nguyễn Thu Thủy','female',null,null,null),
('C12',N'Nguyễn Văn C','male',null,null,null),
('C13',N'Ngô  Văn A','male',null,null,null),
('C14',N'Ngô Văn B','male',null,null,null);
select * from Customers