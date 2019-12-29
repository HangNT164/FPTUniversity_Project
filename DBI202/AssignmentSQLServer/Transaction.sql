/*1.Xóa toàn bộ thông tin của đơn hàng với orderID='Or001'*/
set xact_abort on 

begin tran
	delete from OrderDetail
	where OrderID='Or055'
commit;

/*2. Sử dụng trigger kết hợp vs rollback để tính.vs bang products.
Nếu nhập quantity <0 => ko cho người dùng nhập */

create trigger trig
on products
after  insert 
as
begin
	if exists (select * from products where Quantity < 0)
	begin
		raiserror('You must enter a quantityPerUnit >=0',1,1)
		rollback transaction
	end
end
/*Test */
insert into products
values
('P021','ProductA','SU002','CA002',-5,0);

insert into products
values
('P021','ProductF','SU002','CA002',1005,25101159);

/*3.Insert a customers in database*/
begin transaction
	insert into customers
	values
	('C200',N'Nguyễn Văn A','female',null,null,null)

	insert into Customers
	values
	('C200',N'Nguyễn Văn B','female',null,null,null)
commit transaction

/*test*/
select * from Customers
