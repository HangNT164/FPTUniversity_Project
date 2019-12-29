/*6.Insert data in your database*/
/*a) Insert suppliers*/
insert into suppliers
values
('SU001',N'LG','0154236514',null,null),
('SU002',N'Sony','094274151',null,null),
('SU003',N'Sharp','0123569125',null,null),
('SU004',N'Toshiba','0125194444',null,null),
('SU005',N'SamSung','0147852364',null,null),
('SU006',N'Assus','0125974862',null,null),
('SU007',N'Dell','015975326',null,null),
('SU008',N'Kingtons','023659125',null,null),
('SU009',N'Kangaroo','0942578855',null,null);

select * from Suppliers
/*b) insert Categories */
insert into Categories
values
('CA001',N'Điện tử',N'TiVi,Truyền Hình Số,SmartBox'),
('CA002',N'Điện lạnh',N'Điều hòa,Tủ lạnh, Máy giặt'),
('CA003',N'Đồ gia dụng',N'Lò vi sóng,Quạt sưởi'),
('CA004',N'Âm thanh',N'Karaoke,Dàn âm thanh'),
('CA005',N'Thiết bị tin học',N'Laptop,Desktop,Màn hình máy tính'),
('CA006',N'Điện thoại và máy tính bảng ',N'Di động, máy tính bảng, điện thoại bàn'),
('CA007',N'Kĩ thuật số',N'Máy quay,Máy ảnh thường'),
('CA008',N'Thế giới phụ kiện số',N'Loa máy tính,USB,IP Camera,Bao da'),
('CA009',N'Thế giới phụ kiện điện máy',N'Kệ kính ti vi , Phụ kiện bếp , giá treo tivi');
select * from Categories

/*c)Insert Products*/
insert into Products
values
('P001',N'TiVi Led SamSung','SU005','CA001',20500,10990000),
('P002',N'Tivi Oled LG','SU005','CA001',1850,43900000),
('P003',N'Dàn Âm Thanh SONY','SU002','CA004',10000,7990000),
('P004',N'Máy Giặt Sấy','SU001','CA002',25000,15490000),
('P005',N'Laptop Dell','SU007','CA005',108000,9499000),
('P007',N'Laptop Sony','SU002','CA005',40000,15990000),
('P008',N'Điều Hòa 1 Chiều','SU001','CA002',100500,11990000),
('P009',N'Điều Hòa Tủ Đứng LG','SU001','CA002',255075,20890000),
('P010',N'iPad Air 2 Wifi','SU005','CA006',23000,48990000),
('P011',N'Samsung Galaxy','SU005','CA006',47000,5990000),
('P012',N'Giá treo tivi','SU003','CA009',11101,450000),
('P013',N'Bộ phát sóng','SU005','CA008',5300,269000),
('P014',N'Thiết bị định tuyến','SU001','CA008',55200,1260000),
('P015',N'Nồi cơm điện tử','SU009','CA003',68000,11580000),
('P016',N'Màn Hình Vi Tính HP','SU005','CA008',42000,3898000);
select * from Products

/*d)Insert customer */
insert into Customers
values
('KH001',N'Nguyễn Văn A','male',null,null,null),
('KH002',N'Nguyễn Thu Minh','female',null,null,null),
('KH003',N'Nguyễn Thúy Hà','female',null,null,null),
('KH004',N'Nguyễn Thúy Hằng','female',null,null,null),
('KH005',N'Nguyễn Văn B','male',null,null,null),
('KH006',N'Nguyễn Văn C','male',null,null,null),
('KH007',N'Ngô Văn Long','male',null,null,null),
('KH008',N'Nguyễn Chí Tài','male',null,null,null),
('KH009',N'Trần Trung Hiếu','male',null,null,null),
('KH010',N'Bùi Văn Tài','male',null,null,null),
('KH011',N'Ngô Tiến Dũng','male',null,null,null),
('KH012',N'Nguyễn Thị Huệ','female',null,null,null),
('KH013',N'Ngô Chí Thiện','male',null,null,null),
('KH014',N'Nguyễn Chí Văn','male',null,null,null),
('KH015',N'Nguyễn Văn D','male',null,null,null),
('KH016',N'Nguyễn Văn Lập','male',null,null,null),
('KH017',N'Trần Thị Quyền','male',null,null,null),
('KH018',N'Trần Thu Thủy','female',null,null,null),
('KH019',N'Nguyễn Minh Quyên','female',null,null,null),
('KH020',N'Nguyễn Thị Lệ Quyên','female',null,null,null);
select * from customers 

/*e)Insert Shippers*/
insert into Shippers
values
('SH001',N'Nguyễn Văn Sơn',null,null),
('SH002',N'Nguyễn Văn Hùng',null,null),
('SH003',N'Nguyễn Duy Hùng',null,null),
('SH004',N'Trần Văn Sơn',null,null),
('SH005',N'Lê Đại Sơn',null,null),
('SH006',N'Ngô Thị Minh',null,null),
('SH007',N'Ngô Trịnh Sơn',null,null),
('SH008',N'Ngô Trịnh Đông',null,null);
select * from Shippers 

/*f)Insert Orders*/
insert into Orders
values
('Or001','KH005','SH001','Credit','05-12-2017','05-31-2017'),
('Or002','KH008','SH002','cash','05-01-2017','09-30-2017'),
('Or003','KH008','SH008','Credit','08-07-2017','09-25-2017'),
('Or004','KH001','SH007','cash','05-15-2017','05-20-2017'),
('Or005','KH020','SH001','Credit','04-10-2017','09-07-2017'),
('Or006','KH010','SH004','cash','11-20-2017','12-31-2017'),
('Or007','KH005','SH004','Credit','02-27-2017','03-12-2017'),
('Or008','KH015','SH008','cash','12-12-2017','02-17-2018'),
('Or009','KH008','SH002','cash','01-12-2017','04-30-2017'),
('Or010','KH011','SH001','Credit','03-19-2017','05-28-2017'),
('Or011','KH020','SH003','Credit','03-11-2017','04-20-2017'),
('Or012','KH014','SH006','Credit','05-05-2017','07-31-2017'),
('Or013','KH004','SH008','cash','06-04-2017','07-15-2017'),
('Or014','KH007','SH001','cash','09-16-2017','10-28-2017'),
('Or015','KH005','SH001','Credit','10-19-2017','05-31-2018');
select * from Orders

/*g)Insert OrderDetail*/
insert into OrderDetail
values
('Or001','P001',10),
('Or002','P005',50),
('Or002','P001',60),
('Or001','P003',20),
('Or001','P008',50),
('Or003','P002',4),
('Or004','P002',5),
('Or004','P001',20),
('Or003','P016',20),
('Or013','P015',90),
('Or013','P009',80),
('Or015','P010',44),
('Or010','P002',52),
('Or001','P011',150),
('Or011','P013',120),
('Or011','P014',10),
('Or014','P001',8);
select * from OrderDetail

