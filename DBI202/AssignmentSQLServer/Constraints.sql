/*5.Create at least 3 constraints*/
/*a) them  supplerName not null*/
alter table suppliers
alter column SupplierName nvarchar(50) not null

/*b) them thuoc tinh  cho bang shippers*/
alter table shippers 
add 
	Phone nvarchar(20),
	Address nvarchar(50);
/*c) them dieu kien check cho thuoc tinh trong bang customer*/
alter table Customers
add 
	constraint check_gender check (Gender IN ('Male','Female'));
/*d)Them dieu kien check cho thuoc tinh trong bang order*/
alter table orders
add 
	constraint CK_Orders_Payment check (Payment IN ('Cash', 'Credit'));
/*e)them thuoc tinh neu xoa khoa ngoai thi cac bang chua khoa ngoai vs class khac ko bi anh huong*/
/*alter table products
add constraint fk_supplier foreign key (supplierID) references Suppliers(SupplierID)
	on delete set NULL 
	on update cascade;

alter table products
add constraint fk_categories foreign key (productCode) references Categories(CategoryID)
	on delete set NULL 
	on update cascade;*/