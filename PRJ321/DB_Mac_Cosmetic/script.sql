USE [MAC_COSMETIC]
GO
/****** Object:  Table [dbo].[account]    Script Date: 14/11/2019 8:45:17 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[account](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[account_detail_id] [int] NULL,
	[role_id] [int] NULL,
	[email] [nvarchar](200) NULL,
	[password] [nvarchar](65) NULL,
	[status] [int] NULL,
	[deleted] [bit] NULL,
 CONSTRAINT [PK_account] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[account_detail]    Script Date: 14/11/2019 8:45:17 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[account_detail](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NULL,
	[mobile] [nvarchar](50) NULL,
	[gender] [int] NULL,
	[address] [nvarchar](max) NULL,
	[create_date] [date] NULL,
	[deleted] [bit] NULL,
 CONSTRAINT [PK_account_detail] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[categories]    Script Date: 14/11/2019 8:45:17 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[categories](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[category_code] [nvarchar](50) NULL,
	[category_name] [nvarchar](200) NULL,
	[deleted] [bit] NULL,
 CONSTRAINT [PK_categories] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[customer_infor]    Script Date: 14/11/2019 8:45:17 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[customer_infor](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NULL,
	[mobile] [nvarchar](15) NULL,
	[address] [nvarchar](2000) NULL,
	[deleted] [bit] NULL,
 CONSTRAINT [PK_customer_infor] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[image_avata]    Script Date: 14/11/2019 8:45:17 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[image_avata](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[account_detail_id] [int] NULL,
	[image_link] [nvarchar](100) NULL,
	[deleted] [bit] NULL,
 CONSTRAINT [PK_image_avata] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[images]    Script Date: 14/11/2019 8:45:17 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[images](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[product_id] [int] NULL,
	[image_link] [nvarchar](1000) NULL,
	[cover] [bit] NULL,
	[deleted] [bit] NULL,
 CONSTRAINT [PK_images] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[order_detail]    Script Date: 14/11/2019 8:45:17 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[order_detail](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[order_id] [int] NULL,
	[product_id] [int] NULL,
	[product_name] [nvarchar](200) NULL,
	[sell_price] [int] NULL,
	[orgin_price] [int] NULL,
	[quantity] [int] NULL,
	[deleted] [bit] NULL,
 CONSTRAINT [PK_order_detail] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[orders]    Script Date: 14/11/2019 8:45:17 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[orders](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[account_detail_id] [int] NULL,
	[customer_infor_id] [int] NULL,
	[status_order_id] [int] NULL,
	[total_price] [int] NULL,
	[note] [nvarchar](1000) NULL,
	[create_date] [date] NULL,
	[ship_date] [date] NULL,
	[payment] [nvarchar](50) NULL,
	[deleted] [bit] NULL,
 CONSTRAINT [PK__orders__3213E83F74891EAB] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[product]    Script Date: 14/11/2019 8:45:17 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[product](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[subcate_id] [int] NULL,
	[product_name] [nvarchar](500) NULL,
	[color] [nvarchar](500) NULL,
	[quantity] [int] NULL,
	[sell_price] [int] NULL,
	[orgin_price] [int] NULL,
	[description] [nvarchar](4000) NULL,
	[product_code] [nvarchar](9) NULL,
	[create_date] [date] NULL,
	[deleted] [bit] NULL,
 CONSTRAINT [PK_product] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[role]    Script Date: 14/11/2019 8:45:17 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[role](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[role_name] [nvarchar](50) NULL,
	[deleted] [bit] NULL,
 CONSTRAINT [PK_role] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[status]    Script Date: 14/11/2019 8:45:17 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[status](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[product_id] [int] NULL,
	[status_name] [nvarchar](50) NULL,
	[description_status] [int] NULL,
	[deleted] [bit] NULL,
 CONSTRAINT [PK_status] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[status_order_detail]    Script Date: 14/11/2019 8:45:17 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[status_order_detail](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[status_order_name] [nvarchar](50) NULL,
	[deleted] [bit] NULL,
 CONSTRAINT [PK_status_order] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[sub_category]    Script Date: 14/11/2019 8:45:17 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sub_category](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[sub_category_code] [nvarchar](50) NULL,
	[category_id] [int] NULL,
	[sub_category_name] [nvarchar](200) NULL,
	[deleted] [bit] NULL,
 CONSTRAINT [PK_sub_category] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[account] ON 

INSERT [dbo].[account] ([id], [account_detail_id], [role_id], [email], [password], [status], [deleted]) VALUES (1, 1, 1, N'thaitnfx01652@funix.edu.vn', N'$2a$10$N5/49KjqEovhRnLF8je.zen5FBxKOmm81ACbpPCYMyXFXzfNytE8q', 2, 0)
INSERT [dbo].[account] ([id], [account_detail_id], [role_id], [email], [password], [status], [deleted]) VALUES (2, 2, 2, N'hangnthe130461@fpt.edu.vn', N'$2a$10$ngkMq2vB6hPse0Cwv5/MvOfcU4vbTVkpCqGwlpRaxGy8/g0re22em', 2, 0)
INSERT [dbo].[account] ([id], [account_detail_id], [role_id], [email], [password], [status], [deleted]) VALUES (3, 3, 1, N'hanhnthhe130040@fpt.edu.vn', N'$2a$10$uFIadZt2mEDLrwf.HMvm.eKmvXlMrE44WVpmUFeZqJCLRcnlUe3zy', 2, 0)
INSERT [dbo].[account] ([id], [account_detail_id], [role_id], [email], [password], [status], [deleted]) VALUES (4, 4, 1, N'hanhtrang301999@gmail.com', N'$2a$10$OGsaJYeHBeOfvP6sHdXN1.aw48bNMo6fMl13KC.U5IOtE6TCtfqju', 2, 0)
INSERT [dbo].[account] ([id], [account_detail_id], [role_id], [email], [password], [status], [deleted]) VALUES (5, 5, 1, N'thuyhangnknd@gmail.com', N'$2a$10$qIxFpJZUIeGhO02OwTmceeOR6Q9VsABlKBV1F995pfxtp2K5CEbZ2', 2, 0)
INSERT [dbo].[account] ([id], [account_detail_id], [role_id], [email], [password], [status], [deleted]) VALUES (6, 6, 1, N'ngoanhtuan26899@gmail.com', N'$2a$10$x.hT63wXlwc8zMwblU1cCuG9n..T8bzY5k2nN129z6I5HLJFSUZsu', 2, 0)
SET IDENTITY_INSERT [dbo].[account] OFF
SET IDENTITY_INSERT [dbo].[account_detail] ON 

INSERT [dbo].[account_detail] ([id], [name], [mobile], [gender], [address], [create_date], [deleted]) VALUES (1, N'tuanthao', N'0941569853', 1, N'Nam Định', CAST(N'2019-11-12' AS Date), 0)
INSERT [dbo].[account_detail] ([id], [name], [mobile], [gender], [address], [create_date], [deleted]) VALUES (2, N'hangnt', N'0942578685', 0, N'Nam Định', CAST(N'2019-11-13' AS Date), 0)
INSERT [dbo].[account_detail] ([id], [name], [mobile], [gender], [address], [create_date], [deleted]) VALUES (3, N'HanhNTH', N'0941478563', 0, N'Hưng Yên', CAST(N'2019-11-13' AS Date), 0)
INSERT [dbo].[account_detail] ([id], [name], [mobile], [gender], [address], [create_date], [deleted]) VALUES (4, N'hanhtrang', N'0947892136', 0, N'Hưng Yên', CAST(N'2019-11-13' AS Date), 0)
INSERT [dbo].[account_detail] ([id], [name], [mobile], [gender], [address], [create_date], [deleted]) VALUES (5, N'HaNT', N'0942578685', 0, N'Nam Định', CAST(N'2019-11-13' AS Date), 0)
INSERT [dbo].[account_detail] ([id], [name], [mobile], [gender], [address], [create_date], [deleted]) VALUES (6, N'Tuan', N'0977356351', 1, N'Ha Noi', CAST(N'2019-11-14' AS Date), 0)
SET IDENTITY_INSERT [dbo].[account_detail] OFF
SET IDENTITY_INSERT [dbo].[categories] ON 

INSERT [dbo].[categories] ([id], [category_code], [category_name], [deleted]) VALUES (1, N'CC1', N'Đồ trang điểm ', 0)
INSERT [dbo].[categories] ([id], [category_code], [category_name], [deleted]) VALUES (2, N'CC2', N'Đồ dưỡng da ', 0)
INSERT [dbo].[categories] ([id], [category_code], [category_name], [deleted]) VALUES (3, N'CC3', N'Chăm sóc cơ thể', 0)
INSERT [dbo].[categories] ([id], [category_code], [category_name], [deleted]) VALUES (4, N'CCC100', N'Tuan Thao 269', 0)
INSERT [dbo].[categories] ([id], [category_code], [category_name], [deleted]) VALUES (5, N'CC90', N'blabla', 0)
SET IDENTITY_INSERT [dbo].[categories] OFF
SET IDENTITY_INSERT [dbo].[customer_infor] ON 

INSERT [dbo].[customer_infor] ([id], [name], [mobile], [address], [deleted]) VALUES (1, N'tuanthao', N'0941569853', N'Nam Định', 0)
INSERT [dbo].[customer_infor] ([id], [name], [mobile], [address], [deleted]) VALUES (2, N'tuanthao', N'0941569853', N'Nam Định', 0)
INSERT [dbo].[customer_infor] ([id], [name], [mobile], [address], [deleted]) VALUES (3, N'tuanthao', N'0941569853', N'Nam Định', 0)
INSERT [dbo].[customer_infor] ([id], [name], [mobile], [address], [deleted]) VALUES (4, N'tuanthao', N'0941569853', N'Nam Định', 0)
INSERT [dbo].[customer_infor] ([id], [name], [mobile], [address], [deleted]) VALUES (5, N'HanhNTH', N'0941478563', N'Hưng Yên', 0)
INSERT [dbo].[customer_infor] ([id], [name], [mobile], [address], [deleted]) VALUES (6, N'HanhNTH', N'0941478563', N'Hưng Yên', 0)
INSERT [dbo].[customer_infor] ([id], [name], [mobile], [address], [deleted]) VALUES (7, N'hanhtrang', N'0947892136', N'Hưng Yên', 0)
INSERT [dbo].[customer_infor] ([id], [name], [mobile], [address], [deleted]) VALUES (8, N'hanhtrang', N'0947892136', N'Hưng Yên', 0)
INSERT [dbo].[customer_infor] ([id], [name], [mobile], [address], [deleted]) VALUES (9, N'HaNT', N'0942578685', N'Nam Định', 0)
INSERT [dbo].[customer_infor] ([id], [name], [mobile], [address], [deleted]) VALUES (10, N'HaNT', N'0942578685', N'Nam Định', 0)
INSERT [dbo].[customer_infor] ([id], [name], [mobile], [address], [deleted]) VALUES (11, N'HaNT', N'0942578685', N'Nam Định', 0)
INSERT [dbo].[customer_infor] ([id], [name], [mobile], [address], [deleted]) VALUES (12, N'tuanthao', N'0941569853', N'Nam Định', 0)
INSERT [dbo].[customer_infor] ([id], [name], [mobile], [address], [deleted]) VALUES (13, N'tuanthao', N'0941569853', N'Nam Định', 0)
INSERT [dbo].[customer_infor] ([id], [name], [mobile], [address], [deleted]) VALUES (14, N'tuanthao', N'0941569853', N'Nam Định', 0)
INSERT [dbo].[customer_infor] ([id], [name], [mobile], [address], [deleted]) VALUES (15, N'tuanthao', N'0941569853', N'Nam Định', 0)
INSERT [dbo].[customer_infor] ([id], [name], [mobile], [address], [deleted]) VALUES (16, N'tuanthao', N'0941569853', N'Nam Định', 0)
INSERT [dbo].[customer_infor] ([id], [name], [mobile], [address], [deleted]) VALUES (17, N'tuanthao', N'0941569853', N'Nam Định', 0)
INSERT [dbo].[customer_infor] ([id], [name], [mobile], [address], [deleted]) VALUES (18, N'tuanthao', N'0941569853', N'Nam Định', 0)
INSERT [dbo].[customer_infor] ([id], [name], [mobile], [address], [deleted]) VALUES (19, N'tuanthao', N'0941569853', N'Nam Định', 0)
INSERT [dbo].[customer_infor] ([id], [name], [mobile], [address], [deleted]) VALUES (20, N'tuanthao', N'0941569853', N'Nam Định', 0)
INSERT [dbo].[customer_infor] ([id], [name], [mobile], [address], [deleted]) VALUES (21, N'tuanthao', N'0941569853', N'Nam Định', 0)
INSERT [dbo].[customer_infor] ([id], [name], [mobile], [address], [deleted]) VALUES (22, N'tuanthao', N'0941569853', N'Nam Định', 0)
INSERT [dbo].[customer_infor] ([id], [name], [mobile], [address], [deleted]) VALUES (23, N'Ngoc Trinh', N'0989999999', N'Ha Noi', 0)
INSERT [dbo].[customer_infor] ([id], [name], [mobile], [address], [deleted]) VALUES (24, N'hangnt', N'0942578685', N'Nam Định', 0)
SET IDENTITY_INSERT [dbo].[customer_infor] OFF
SET IDENTITY_INSERT [dbo].[image_avata] ON 

INSERT [dbo].[image_avata] ([id], [account_detail_id], [image_link], [deleted]) VALUES (1, 1, N'img/img_avata/67976088_867132853685961_5785357854365974528_n (1).png', 0)
INSERT [dbo].[image_avata] ([id], [account_detail_id], [image_link], [deleted]) VALUES (2, 2, N'img/img_avata/51545821_317881532407946_1817281837819494400_o.jpg', 0)
INSERT [dbo].[image_avata] ([id], [account_detail_id], [image_link], [deleted]) VALUES (3, 3, N'img/img_avata/female.jpg', 0)
INSERT [dbo].[image_avata] ([id], [account_detail_id], [image_link], [deleted]) VALUES (4, 4, N'img/img_avata/female.jpg', 0)
INSERT [dbo].[image_avata] ([id], [account_detail_id], [image_link], [deleted]) VALUES (5, 5, N'img/img_avata/female.jpg', 0)
INSERT [dbo].[image_avata] ([id], [account_detail_id], [image_link], [deleted]) VALUES (6, 6, N'img/img_avata/51545821_317881532407946_1817281837819494400_o.jpg', 0)
SET IDENTITY_INSERT [dbo].[image_avata] OFF
SET IDENTITY_INSERT [dbo].[images] ON 

INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (1, 1, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham1/1.jpg', 1, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (2, 1, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham1/2.jpg', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (3, 1, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham1/3.png', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (4, 2, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham2/1.jpg', 1, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (5, 2, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham1/2.jpg', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (6, 3, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_ma_hong/sanpham1/1.jpg', 1, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (7, 4, N'img/img_chi_tiet_san_pham/img_do_duong_da/img_sua_rua_mat/1.jpg', 1, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (8, 5, N'img/img_chi_tiet_san_pham/img_do_duong_da/img_sua_rua_mat/3.jpg', 1, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (9, 1, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham1/4.png', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (10, 2, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham2/2.jpg', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (11, 2, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham2/3.png', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (12, 3, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_ma_hong/sanpham1/2.jpg', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (13, 3, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_ma_hong/sanpham1/1.jpg', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (14, 3, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_ma_hong/sanpham1/2.jpg', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (15, 4, N'img/img_chi_tiet_san_pham/img_do_duong_da/img_sua_rua_mat/2.jpg', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (16, 5, N'img/img_chi_tiet_san_pham/img_do_duong_da/img_sua_rua_mat/4.jpg', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (17, 10, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham3/1.jpg', 1, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (18, 10, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham3/2.jpg', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (19, 10, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham3/3.png', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (20, 11, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham4/1.png', 1, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (21, 11, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham4/2.png', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (22, 11, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham4/3.png', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (23, 12, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham5/1.jpg', 1, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (24, 12, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham5/2.jpg', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (25, 12, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham5/3.jpg', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (26, 12, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham5/4.jpg', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (27, 13, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham5/1.jpg', 1, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (28, 13, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham5/2.jpg', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (29, 13, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham1/4.png', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (30, 13, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham2/3.png', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (31, 14, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham2/2.jpg', 1, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (32, 14, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham2/1.jpg', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (33, 14, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham2/3.png', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (34, 15, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_co_tan/sanpham1/1.png', 1, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (35, 15, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_co_tan/sanpham1/2.png', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (36, 16, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_co_tan/sanpham2/1.jpg', 1, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (37, 16, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_co_tan/sanpham2/2.jpg', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (38, 17, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_phan_ma/sanpham1/1.jpg', 1, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (39, 17, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_phan_ma/sanpham1/2.jpg', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (40, 18, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_phan_ma/sanpham2/1.jpg', 1, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (41, 18, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_phan_ma/sanpham2/2.jpg', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (42, 19, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_phan_ma/sanpham3/1.jpg', 1, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (43, 19, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_phan_ma/sanpham3/2.jpg', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (44, 20, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_phan_ma/sanpham4/1.jpg', 1, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (45, 20, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_phan_ma/sanpham4/2.jpg', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (46, 21, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_phan_ma/sanpham5/1.jpg', 1, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (47, 21, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_phan_ma/sanpham5/2.png', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (48, 22, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_phan_ma/sanpham6/1.png', 0, 1)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (49, 22, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_phan_ma/sanpham6/2.png', 0, 1)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (75, 22, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham1/2 (1).jpg', 0, 1)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (76, 22, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham1/2 (2).jpg', 0, 1)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (77, 22, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham1/2 (2).jpg', 0, 1)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (78, 22, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham1/67976088_867132853685961_5785357854365974528_n.png', 0, 1)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (79, 22, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham1/2 (2).jpg', 0, 1)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (80, 22, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham1/67976088_867132853685961_5785357854365974528_n.png', 0, 1)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (81, 22, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham1/2 (1).jpg', 1, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (82, 22, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham1/2 (2).jpg', 0, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (83, 31, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham1/2 (1).jpg', 1, 0)
INSERT [dbo].[images] ([id], [product_id], [image_link], [cover], [deleted]) VALUES (84, 31, N'img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham1/aaa.png', 0, 0)
SET IDENTITY_INSERT [dbo].[images] OFF
SET IDENTITY_INSERT [dbo].[order_detail] ON 

INSERT [dbo].[order_detail] ([id], [order_id], [product_id], [product_name], [sell_price], [orgin_price], [quantity], [deleted]) VALUES (1, 3, 1, N'Mac Whirl & Whirl Lip Duo', 750000, 500000, 1, 0)
INSERT [dbo].[order_detail] ([id], [order_id], [product_id], [product_name], [sell_price], [orgin_price], [quantity], [deleted]) VALUES (2, 4, 1, N'Mac Whirl & Whirl Lip Duo', 750000, 500000, 3, 0)
INSERT [dbo].[order_detail] ([id], [order_id], [product_id], [product_name], [sell_price], [orgin_price], [quantity], [deleted]) VALUES (3, 5, 1, N'Mac Whirl & Whirl Lip Duo', 750000, 500000, 2, 0)
INSERT [dbo].[order_detail] ([id], [order_id], [product_id], [product_name], [sell_price], [orgin_price], [quantity], [deleted]) VALUES (4, 6, 19, N'Mineralize Eye Shadow- Blue Flame', 446500, 300000, 2, 0)
INSERT [dbo].[order_detail] ([id], [order_id], [product_id], [product_name], [sell_price], [orgin_price], [quantity], [deleted]) VALUES (5, 6, 22, N'Pro Longwear Paint Pot', 470000, 300000, 1, 0)
INSERT [dbo].[order_detail] ([id], [order_id], [product_id], [product_name], [sell_price], [orgin_price], [quantity], [deleted]) VALUES (6, 6, 20, N'Mineralize Eye Shadow- Ever Amethyst', 432400, 300000, 1, 0)
INSERT [dbo].[order_detail] ([id], [order_id], [product_id], [product_name], [sell_price], [orgin_price], [quantity], [deleted]) VALUES (7, 7, 1, N'Mac Whirl & Whirl Lip Duo', 750000, 500000, 1, 0)
INSERT [dbo].[order_detail] ([id], [order_id], [product_id], [product_name], [sell_price], [orgin_price], [quantity], [deleted]) VALUES (8, 7, 3, N'Má Hồng Dạng Nén MAC ', 980000, 500000, 2, 0)
INSERT [dbo].[order_detail] ([id], [order_id], [product_id], [product_name], [sell_price], [orgin_price], [quantity], [deleted]) VALUES (9, 7, 10, N'Mac Retro Matte Liquid', 675000, 500000, 1, 0)
INSERT [dbo].[order_detail] ([id], [order_id], [product_id], [product_name], [sell_price], [orgin_price], [quantity], [deleted]) VALUES (10, 8, 5, N'Sữa rửa mặt M.A.C black C Cleanser', 950000, 500000, 1, 0)
INSERT [dbo].[order_detail] ([id], [order_id], [product_id], [product_name], [sell_price], [orgin_price], [quantity], [deleted]) VALUES (11, 9, 1, N'Mac Whirl & Whirl Lip Duo', 750000, 500000, 1, 0)
INSERT [dbo].[order_detail] ([id], [order_id], [product_id], [product_name], [sell_price], [orgin_price], [quantity], [deleted]) VALUES (12, 10, 2, N'Mac Retro Matte Liquid', 799000, 500000, 1, 0)
INSERT [dbo].[order_detail] ([id], [order_id], [product_id], [product_name], [sell_price], [orgin_price], [quantity], [deleted]) VALUES (13, 11, 3, N'Má Hồng Dạng Nén MAC ', 980000, 500000, 1, 0)
INSERT [dbo].[order_detail] ([id], [order_id], [product_id], [product_name], [sell_price], [orgin_price], [quantity], [deleted]) VALUES (14, 12, 1, N'Mac Whirl & Whirl Lip Duo', 750000, 500000, 1, 0)
INSERT [dbo].[order_detail] ([id], [order_id], [product_id], [product_name], [sell_price], [orgin_price], [quantity], [deleted]) VALUES (15, 13, 2, N'Mac Retro Matte Liquid', 799000, 500000, 1, 0)
INSERT [dbo].[order_detail] ([id], [order_id], [product_id], [product_name], [sell_price], [orgin_price], [quantity], [deleted]) VALUES (16, 14, 3, N'Má Hồng Dạng Nén MAC ', 980000, 500000, 1, 0)
INSERT [dbo].[order_detail] ([id], [order_id], [product_id], [product_name], [sell_price], [orgin_price], [quantity], [deleted]) VALUES (17, 15, 22, N'Pro Longwear Paint Pot', 470000, 300000, 1, 0)
INSERT [dbo].[order_detail] ([id], [order_id], [product_id], [product_name], [sell_price], [orgin_price], [quantity], [deleted]) VALUES (18, 15, 20, N'Mineralize Eye Shadow- Ever Amethyst', 432400, 300000, 2, 0)
INSERT [dbo].[order_detail] ([id], [order_id], [product_id], [product_name], [sell_price], [orgin_price], [quantity], [deleted]) VALUES (19, 15, 19, N'Mineralize Eye Shadow- Blue Flame', 446500, 300000, 1, 0)
INSERT [dbo].[order_detail] ([id], [order_id], [product_id], [product_name], [sell_price], [orgin_price], [quantity], [deleted]) VALUES (20, 15, 17, N'MacEyeShadow', 330000, 200000, 1, 0)
INSERT [dbo].[order_detail] ([id], [order_id], [product_id], [product_name], [sell_price], [orgin_price], [quantity], [deleted]) VALUES (21, 16, 3, N'Má Hồng Dạng Nén MAC ', 980000, 500000, 1, 0)
INSERT [dbo].[order_detail] ([id], [order_id], [product_id], [product_name], [sell_price], [orgin_price], [quantity], [deleted]) VALUES (22, 17, 10, N'Mac Retro Matte Liquid', 675000, 500000, 1, 0)
INSERT [dbo].[order_detail] ([id], [order_id], [product_id], [product_name], [sell_price], [orgin_price], [quantity], [deleted]) VALUES (23, 18, 3, N'Má Hồng Dạng Nén MAC ', 980000, 500000, 1, 0)
INSERT [dbo].[order_detail] ([id], [order_id], [product_id], [product_name], [sell_price], [orgin_price], [quantity], [deleted]) VALUES (24, 19, 10, N'Mac Retro Matte Liquid', 675000, 500000, 1, 0)
INSERT [dbo].[order_detail] ([id], [order_id], [product_id], [product_name], [sell_price], [orgin_price], [quantity], [deleted]) VALUES (25, 20, 2, N'Mac Retro Matte Liquid', 799000, 500000, 1, 0)
INSERT [dbo].[order_detail] ([id], [order_id], [product_id], [product_name], [sell_price], [orgin_price], [quantity], [deleted]) VALUES (26, 21, 1, N'Mac Whirl & Whirl Lip Duo', 750000, 500000, 2, 0)
INSERT [dbo].[order_detail] ([id], [order_id], [product_id], [product_name], [sell_price], [orgin_price], [quantity], [deleted]) VALUES (27, 22, 20, N'Mineralize Eye Shadow- Ever Amethyst', 432400, 300000, 2, 0)
INSERT [dbo].[order_detail] ([id], [order_id], [product_id], [product_name], [sell_price], [orgin_price], [quantity], [deleted]) VALUES (28, 23, 1, N'Mac Whirl & Whirl Lip Duo', 750000, 500000, 2, 0)
INSERT [dbo].[order_detail] ([id], [order_id], [product_id], [product_name], [sell_price], [orgin_price], [quantity], [deleted]) VALUES (29, 24, 1, N'Mac Whirl & Whirl Lip Duo', 750000, 500000, 3, 0)
INSERT [dbo].[order_detail] ([id], [order_id], [product_id], [product_name], [sell_price], [orgin_price], [quantity], [deleted]) VALUES (30, 24, 2, N'Mac Retro Matte Liquid', 799000, 500000, 2, 0)
SET IDENTITY_INSERT [dbo].[order_detail] OFF
SET IDENTITY_INSERT [dbo].[orders] ON 

INSERT [dbo].[orders] ([id], [account_detail_id], [customer_infor_id], [status_order_id], [total_price], [note], [create_date], [ship_date], [payment], [deleted]) VALUES (3, 1, 3, 3, 750000, N'', CAST(N'2019-11-13' AS Date), NULL, N'Cash', 0)
INSERT [dbo].[orders] ([id], [account_detail_id], [customer_infor_id], [status_order_id], [total_price], [note], [create_date], [ship_date], [payment], [deleted]) VALUES (4, 1, 4, 3, 2250000, N'', CAST(N'2019-11-13' AS Date), NULL, N'Cash', 0)
INSERT [dbo].[orders] ([id], [account_detail_id], [customer_infor_id], [status_order_id], [total_price], [note], [create_date], [ship_date], [payment], [deleted]) VALUES (5, 3, 5, 3, 1500000, N'', CAST(N'2019-11-13' AS Date), NULL, N'Cash', 0)
INSERT [dbo].[orders] ([id], [account_detail_id], [customer_infor_id], [status_order_id], [total_price], [note], [create_date], [ship_date], [payment], [deleted]) VALUES (6, 3, 6, 3, 1795400, N'', CAST(N'2019-10-13' AS Date), NULL, N'Cash', 0)
INSERT [dbo].[orders] ([id], [account_detail_id], [customer_infor_id], [status_order_id], [total_price], [note], [create_date], [ship_date], [payment], [deleted]) VALUES (7, 4, 7, 3, 3385000, N'', CAST(N'2019-10-13' AS Date), NULL, N'Cash', 0)
INSERT [dbo].[orders] ([id], [account_detail_id], [customer_infor_id], [status_order_id], [total_price], [note], [create_date], [ship_date], [payment], [deleted]) VALUES (8, 4, 8, 3, 950000, N'', CAST(N'2019-10-13' AS Date), NULL, N'Cash', 0)
INSERT [dbo].[orders] ([id], [account_detail_id], [customer_infor_id], [status_order_id], [total_price], [note], [create_date], [ship_date], [payment], [deleted]) VALUES (9, 5, 9, 3, 750000, N'', CAST(N'2019-09-13' AS Date), NULL, N'Cash', 0)
INSERT [dbo].[orders] ([id], [account_detail_id], [customer_infor_id], [status_order_id], [total_price], [note], [create_date], [ship_date], [payment], [deleted]) VALUES (10, 5, 10, 3, 799000, N'', CAST(N'2019-09-13' AS Date), NULL, N'Cash', 0)
INSERT [dbo].[orders] ([id], [account_detail_id], [customer_infor_id], [status_order_id], [total_price], [note], [create_date], [ship_date], [payment], [deleted]) VALUES (11, 5, 11, 3, 980000, N'', CAST(N'2019-08-13' AS Date), NULL, N'Cash', 0)
INSERT [dbo].[orders] ([id], [account_detail_id], [customer_infor_id], [status_order_id], [total_price], [note], [create_date], [ship_date], [payment], [deleted]) VALUES (12, 1, 12, 3, 750000, N'', CAST(N'2019-08-13' AS Date), NULL, N'Cash', 0)
INSERT [dbo].[orders] ([id], [account_detail_id], [customer_infor_id], [status_order_id], [total_price], [note], [create_date], [ship_date], [payment], [deleted]) VALUES (13, 1, 13, 1, 799000, N'', CAST(N'2019-07-13' AS Date), NULL, N'Cash', 0)
INSERT [dbo].[orders] ([id], [account_detail_id], [customer_infor_id], [status_order_id], [total_price], [note], [create_date], [ship_date], [payment], [deleted]) VALUES (14, 1, 14, 1, 980000, N'', CAST(N'2019-06-13' AS Date), NULL, N'Cash', 0)
INSERT [dbo].[orders] ([id], [account_detail_id], [customer_infor_id], [status_order_id], [total_price], [note], [create_date], [ship_date], [payment], [deleted]) VALUES (15, 1, 15, 1, 2111300, N'', CAST(N'2019-05-13' AS Date), NULL, N'Cash', 0)
INSERT [dbo].[orders] ([id], [account_detail_id], [customer_infor_id], [status_order_id], [total_price], [note], [create_date], [ship_date], [payment], [deleted]) VALUES (16, 1, 16, 1, 980000, N'', CAST(N'2019-04-13' AS Date), NULL, N'Cash', 0)
INSERT [dbo].[orders] ([id], [account_detail_id], [customer_infor_id], [status_order_id], [total_price], [note], [create_date], [ship_date], [payment], [deleted]) VALUES (17, 1, 17, 2, 675000, N'', CAST(N'2019-03-13' AS Date), NULL, N'Cash', 0)
INSERT [dbo].[orders] ([id], [account_detail_id], [customer_infor_id], [status_order_id], [total_price], [note], [create_date], [ship_date], [payment], [deleted]) VALUES (18, 1, 18, 1, 980000, N'', CAST(N'2019-03-13' AS Date), NULL, N'Cash', 0)
INSERT [dbo].[orders] ([id], [account_detail_id], [customer_infor_id], [status_order_id], [total_price], [note], [create_date], [ship_date], [payment], [deleted]) VALUES (19, 1, 19, 1, 675000, N'', CAST(N'2019-02-13' AS Date), NULL, N'Cash', 0)
INSERT [dbo].[orders] ([id], [account_detail_id], [customer_infor_id], [status_order_id], [total_price], [note], [create_date], [ship_date], [payment], [deleted]) VALUES (20, 1, 20, 1, 799000, N'', CAST(N'2019-01-13' AS Date), NULL, N'Cash', 0)
INSERT [dbo].[orders] ([id], [account_detail_id], [customer_infor_id], [status_order_id], [total_price], [note], [create_date], [ship_date], [payment], [deleted]) VALUES (21, 1, 21, 1, 1500000, N'', CAST(N'2019-02-13' AS Date), NULL, N'Cash', 0)
INSERT [dbo].[orders] ([id], [account_detail_id], [customer_infor_id], [status_order_id], [total_price], [note], [create_date], [ship_date], [payment], [deleted]) VALUES (22, 1, 22, 1, 864800, N'', CAST(N'2019-03-13' AS Date), NULL, N'Cash', 0)
INSERT [dbo].[orders] ([id], [account_detail_id], [customer_infor_id], [status_order_id], [total_price], [note], [create_date], [ship_date], [payment], [deleted]) VALUES (23, 6, 23, 3, 1500000, N'Hang nhay carm xin nhe tay', CAST(N'2019-11-14' AS Date), NULL, N'Cash', 0)
INSERT [dbo].[orders] ([id], [account_detail_id], [customer_infor_id], [status_order_id], [total_price], [note], [create_date], [ship_date], [payment], [deleted]) VALUES (24, 2, 24, 3, 3848000, N'g', CAST(N'2019-11-14' AS Date), NULL, N'Cash', 0)
SET IDENTITY_INSERT [dbo].[orders] OFF
SET IDENTITY_INSERT [dbo].[product] ON 

INSERT [dbo].[product] ([id], [subcate_id], [product_name], [color], [quantity], [sell_price], [orgin_price], [description], [product_code], [create_date], [deleted]) VALUES (1, 2, N'Mac Whirl & Whirl Lip Duo', N'chili', 4967, 750000, 500000, N'Matte là dòng son có độ lì thứ 2 sau dòng Retro Matte, độ lì vừa phải, không gây khô môi, cũng không lộ vân môi. Chất son khá mướt và mịn, không bị bột như những dòn son lì khác. Độ bám màu của MAC Matte cũng không phải bàn cãi thêm nữa, lên đếm 6-8 tiếng nếu các nàng không ăn gì. Sau khi ăn đồ dầu mỡ, em ý vẫn còn vương chút son ở lòng môi rất xinh chứ không trôi hết sạch. Tuy nhiên, so với các dòng son bình thường thì MAC Matte có độ lì và khô xếp và loại “khủng” nhưng dẫu sao thì đây cũng lựa chọn hàng đầu của nhiều cô gái. Tóm lại, dòng Matte có những đặc điểm:', N'MAC123456', CAST(N'2019-10-25' AS Date), 0)
INSERT [dbo].[product] ([id], [subcate_id], [product_name], [color], [quantity], [sell_price], [orgin_price], [description], [product_code], [create_date], [deleted]) VALUES (2, 2, N'Mac Retro Matte Liquid', N'Fashion Legacy', 2999, 850000, 500000, N'Dòng son kem lì từ MAC có chất son lên màu cực chuẩn và khả năng giữ màu tốt. Tuy nhiên nếu bạn ăn uống, phần lòng môi son sẽ nhạt đi. Điểm nổi bật nhất của son kem lì từ MAC là khả năng chồng màu tốt, có thể apply lên môi nhiều mà không lo sợ bị bột.
Mac Retro Matte Liquid là loại son có tính lì, khi đánh lên môi có màu màu cực chuẩn, son dòng Retro Matte Liquid có khả năng giữ màu tốt, tuy nhiên cần chú ý khi ăn uống có thể làm son có bị nhạt đi ở phần lòng môi. Dòng son này có đặc điểm nổi bật chính là khả năng chồng màu rất tốt, bạn có thể yên tâm apply lên môi nhiều lần mà không sợ màu son bị bờ hay bị bột. Bạn có thể tưởng tượng, chất son của em ý không mượt như nhung như Bonjour mà sẽ khô hơn một chút, vì vậy bạn cũng nên dưỡng môi cẩn thận trước khi dùng em này để không bị lộ vân môi.
', N'MAC123789', CAST(N'2019-10-25' AS Date), 0)
INSERT [dbo].[product] ([id], [subcate_id], [product_name], [color], [quantity], [sell_price], [orgin_price], [description], [product_code], [create_date], [deleted]) VALUES (3, 4, N'Má Hồng Dạng Nén MAC ', N'blushpe', 1484, 980000, 500000, N'sản phẩm hot năm 2019', N'MAC147896', CAST(N'2019-10-25' AS Date), 0)
INSERT [dbo].[product] ([id], [subcate_id], [product_name], [color], [quantity], [sell_price], [orgin_price], [description], [product_code], [create_date], [deleted]) VALUES (4, 10, N'Sữa rửa mặt M.A.C Lightful C Cleanser', N'', 0, 750000, 500000, N'dành cho da dầu', N'MAC123698', CAST(N'2019-10-25' AS Date), 0)
INSERT [dbo].[product] ([id], [subcate_id], [product_name], [color], [quantity], [sell_price], [orgin_price], [description], [product_code], [create_date], [deleted]) VALUES (5, 10, N'Sữa rửa mặt M.A.C black C Cleanser', N'', 498, 950000, 500000, N'Matte là dòng son có độ lì thứ 2 sau dòng Retro Matte, độ lì vừa phải, không gây khô môi, cũng không lộ vân môi. Chất son khá mướt và mịn, không bị bột như những dòn son lì khác. Độ bám màu của MAC Matte cũng không phải bàn cãi thêm nữa, lên đếm 6-8 tiếng nếu các nàng không ăn gì. Sau khi ăn đồ dầu mỡ, em ý vẫn còn vương chút son ở lòng môi rất xinh chứ không trôi hết sạch. Tuy nhiên, so với các dòng son bình thường thì MAC Matte có độ lì và khô xếp và loại “khủng” nhưng dẫu sao thì đây cũng lựa chọn hàng đầu của nhiều cô gái. Tóm lại, dòng Matte có những đặc điểm:
Lên đúng màu
Lâu trôi
Chất son khô, lì
Dòng này gồm 18 màu, trong đó có màu son đỏ huyền thoại Ruby Woo: So Chaud, Lady Danger, Chili, Russian Red, Ruby Woo, Red Pepper, Diva, Sin, Charred Red, Smoked Purple, Please Me, Pink Plaid, Honeylove, Velvet Teddy, Kinda Sexy, Taupe, Full Chocolate, Deep Love.
', N'MAC159357', CAST(N'2019-10-25' AS Date), 0)
INSERT [dbo].[product] ([id], [subcate_id], [product_name], [color], [quantity], [sell_price], [orgin_price], [description], [product_code], [create_date], [deleted]) VALUES (10, 2, N'Mac Retro Matte Liquid', N'Chill', 992, 750000, 500000, N'Dòng son kem lì từ MAC có chất son lên màu cực chuẩn và khả năng giữ màu tốt. Tuy nhiên nếu bạn ăn uống, phần lòng môi son sẽ nhạt đi. Điểm nổi bật nhất của son kem lì từ MAC là khả năng chồng màu tốt, có thể apply lên môi nhiều mà không lo sợ bị bột.', N'MAC258963', CAST(N'2019-10-25' AS Date), 0)
INSERT [dbo].[product] ([id], [subcate_id], [product_name], [color], [quantity], [sell_price], [orgin_price], [description], [product_code], [create_date], [deleted]) VALUES (11, 2, N'Son Mac Retro Matte Liquid', N'Fashion Legacy', 1000, 850000, 200000, N'Dòng son kem lì từ MAC có chất son lên màu cực chuẩn và khả năng giữ màu tốt. Tuy nhiên nếu bạn ăn uống, phần lòng môi son sẽ nhạt đi. Điểm nổi bật nhất của son kem lì từ MAC là khả năng chồng màu tốt, có thể apply lên môi nhiều mà không lo sợ bị bột.
Mac Retro Matte Liquid là loại son có tính lì, khi đánh lên môi có màu màu cực chuẩn, son dòng Retro Matte Liquid có khả năng giữ màu tốt, tuy nhiên cần chú ý khi ăn uống có thể làm son có bị nhạt đi ở phần lòng môi. Dòng son này có đặc điểm nổi bật chính là khả năng chồng màu rất tốt, bạn có thể yên tâm apply lên môi nhiều lần mà không sợ màu son bị bờ hay bị bột. Bạn có thể tưởng tượng, chất son của em ý không mượt như nhung như Bonjour mà sẽ khô hơn một chút, vì vậy bạn cũng nên dưỡng môi cẩn thận trước khi dùng em này để không bị lộ vân môi.
', N'MAC145632', CAST(N'2019-10-25' AS Date), 0)
INSERT [dbo].[product] ([id], [subcate_id], [product_name], [color], [quantity], [sell_price], [orgin_price], [description], [product_code], [create_date], [deleted]) VALUES (12, 2, N'Son Mac dòng Mineralize Rich Lipstick', N'naturalty', 2000, 540000, 100000, N'Hoàn toàn ngược lại với 3 dòng son siêu lì trên, đây là dòng son hoàn hảo cho cho những nàng sở hữu làn môi khô nhé. Bởi Mineralize Rich Lipstick có tích hợp thêm những thành phẩm dưỡng ẩm cho môi, khiến đôi môi bạn mềm mại và tự nhiên. Vì chứa dưỡng chất nên việc son không quá bền màu là điều đưỡng nhiên, son sẽ giữ được màu 3-4 tiếng nếu không ăn uống dầu mỡ. 
', N'MAC789142', CAST(N'2019-10-25' AS Date), 0)
INSERT [dbo].[product] ([id], [subcate_id], [product_name], [color], [quantity], [sell_price], [orgin_price], [description], [product_code], [create_date], [deleted]) VALUES (13, 2, N'Son Mac dòng Sheen Supreme', N'whirl', 0, 750000, 500000, N'Có đôi chút giống với dòng son trên, Sheen Supreme có chứa dưỡng chất để khiến môi không bị khô. Điểm khác biệt là son có thiết kế đầu vuông chứ không phải dạng son truyền thống nên việc viền môi không được hoàn hảo như các dòng son MAC khác
', N'MAC123698', CAST(N'2019-10-25' AS Date), 0)
INSERT [dbo].[product] ([id], [subcate_id], [product_name], [color], [quantity], [sell_price], [orgin_price], [description], [product_code], [create_date], [deleted]) VALUES (14, 2, N'Son Mac dòng Satin', N'snob', 0, 750000, 400000, N'Son Mac dòng Satin là thỏi son lì nhưng lại khá mềm , son có độ dưỡng vừa phải giúp môi không bị khô nhưng cũng không bóng nhẫy khó chịu, khả năng giữ màu của son tốt
Bảng màu son có tới 31 màu, tuy nhiên lại có nhiều tone màu khá kén chọn da.
', N'MAC123965', CAST(N'2019-10-25' AS Date), 0)
INSERT [dbo].[product] ([id], [subcate_id], [product_name], [color], [quantity], [sell_price], [orgin_price], [description], [product_code], [create_date], [deleted]) VALUES (15, 5, N'CỌ ĐÁNH NỀN MAC', N'', 0, 1100000, 400000, N'Thích hợp đánh nền
Dùng với nhiều loại kết cấu
Dáng cọ hình quạt nhỏ, dày dặn
Lông cọ mềm mại làm từ 100% sợi tổng hợp
', N'MAC456125', CAST(N'2019-10-25' AS Date), 0)
INSERT [dbo].[product] ([id], [subcate_id], [product_name], [color], [quantity], [sell_price], [orgin_price], [description], [product_code], [create_date], [deleted]) VALUES (16, 5, N'Cọ Chải Chân Mày M.A.C', N'', 0, 570000, 440000, N'Dùng chải phấn chân mày
Thiết kế đầu cọ chéo mềm mại
Thiết kế đầu cọ chéo mềm mại, không kích ứng da, cho cảm giác thoải mái khi sử dụng

', N'MAC789522', CAST(N'2019-10-25' AS Date), 0)
INSERT [dbo].[product] ([id], [subcate_id], [product_name], [color], [quantity], [sell_price], [orgin_price], [description], [product_code], [create_date], [deleted]) VALUES (17, 8, N'MacEyeShadow', N'', 2000, 330000, 200000, N'MAC là dòng thương hiệu mỹ phẩm  
 luôn đem lại các sản phẩm chất lượng, uy tín 
 cùng giá thành khá phù hợp túi tiền của giới làm đẹp. 
 Mọi dòng phấn mắt của MAC ngay từ khi ra mắt thị trường 
 đã nhận được nhiều cảm tình và được đánh giá rất cao về 
 khả năng làm đẹp đôi mắt, giúp mọi cô nàng trở nên hoàn
 hảo,sắc sảo và sống động hơn rất nhiều
 Với hàng trăm màu sắc cùng chủng loại đa dạng của 
 các loại phấn mắt thì bạn nên chọn thương hiệu nổi 
 tiếng và chất lượng. Hãy sở hữu ngay MAC Eye Shadow-  
 Vanilla Velvet ngay. Nói đến loại phấn mắt của MAC này 
 thì khá phổ biến và hầu như cô nàng nào yêu trang điểm 
 nào cũng biết. Vanilla Eye Shadow rất dễ sử dụng với 
 thao tác khá đơn giản. Thoa phấn mắt lên ngón tay,
 lướt nhẹ trên vùng bầu mắt, dặm phấn thật đều tay để 
 màu được trải đều. Vậy là đôi mắt của bạn đã có màu 
 thật đẹp và ấn tượng. Tông màu hồ ng của Vanilla vô 
 cùng dễ thương sẽ khiến bạn trở nên nữ tính hơn rất 
 nhiều.', N'MAC156988', CAST(N'2019-10-25' AS Date), 0)
INSERT [dbo].[product] ([id], [subcate_id], [product_name], [color], [quantity], [sell_price], [orgin_price], [description], [product_code], [create_date], [deleted]) VALUES (18, 8, N'Nude Eye Shadow X4', N'', 1000, 930000, 500000, N'Sự giản đơn, nhẹ nhàng luôn đem lại cho người phụ nữ vẻ dịu dàng nhưng cũng không kém phần lịch thiệp, sang trọng. Có thể hiểu cách trang điểm cũng giống như vậy. Nếu bạn là cô nàng quá quen với việc makeup trang điểm hằng ngày thì chỉ cần với các tông màu nude, đôi mắt của bạn sẽ trở nên thật cuốn hút, quyến rũ và thu hút ánh nhìn. Tiêu biểu nhất là bảng màu mắt Nude Eye Shadow X4 của MAC.
  Nude Eye Shadow X4 được thiết kế với 4 tông màu thiên nude nên rất nhẹ nhàng, đậm chất tự nhiên. Khi bạn biết cách kết hợp các màu với nhau sẽ tạo nên được các tông vô cùng thời thượng. Cô nàng cá tính có thể biến hóa đôi mắt mình mỗi ngày theo một phong cách khác nhau. Nhưng có lẽ bảng mắt này của MAC phù hợp với cả những cô gái yêu nét tự nhiên và trang điểm nhẹ.
', N'MAC156928', CAST(N'2019-10-25' AS Date), 0)
INSERT [dbo].[product] ([id], [subcate_id], [product_name], [color], [quantity], [sell_price], [orgin_price], [description], [product_code], [create_date], [deleted]) VALUES (19, 8, N'Mineralize Eye Shadow- Blue Flame', N'', 1998, 470000, 300000, N'Bạn là một cô nàng cá tính yêu thích những màu sắc đậm và nổi bật. Bạn là cô nàng bánh bèo muốn thay đổi phong cách của mình mạnh mẽ hơn thì chắc chắn màu phấn mắt đậm là dụng cụ không thể thiếu. Nếu đang gặp tình trạng đắn đo không biết mua phấn mắt loại nào, hãng nào thì hãy chọn những thương hiệu uy tín. JAMJA’s BLOG gợi ý cho bạn phấn mắt màu xanh huyền ảo của MAC Mineralize Eye Shadow- Blue Flame.
   Mineralize Eye Shadow- Blue Flame sẽ không bao giờ làm bạn thất vọng bởi màu sắc xanh vô cùng cuốn hút và độc lạ. Cô nàng khi được trang điểm cùng Blue Flame trở nên nổi bật, cá tính với vẻ bề ngoài vô cùng ấn tượng. Bạn lo lắng khi sử dụng màu mắt đậm sẽ ảnh hưởng đến vùng da nhạy cảm ở mắt nhưng hãy yên tâm vì trong thành phần chứa dưỡng khí, đảm bảo đôi mắt của bạn được chăm sóc đúng cách.
 ', N'MAC136988', CAST(N'2019-10-25' AS Date), 0)
INSERT [dbo].[product] ([id], [subcate_id], [product_name], [color], [quantity], [sell_price], [orgin_price], [description], [product_code], [create_date], [deleted]) VALUES (20, 8, N'Mineralize Eye Shadow- Ever Amethyst', N'', 2000, 470000, 300000, N'Sự giản đơn, nhẹ nhàng luôn đem lại cho người phụ nữ vẻ dịu dàng nhưng cũng không kém phần lịch thiệp, sang trọng. Có thể hiểu cách trang điểm cũng giống như vậy. Nếu bạn là cô nàng quá quen với việc makeup trang điểm hằng ngày thì chỉ cần với các tông màu nude, đôi mắt của bạn sẽ trở nên thật cuốn hút, quyến rũ và thu hút ánh nhìn. Tiêu biểu nhất là bảng màu mắt Nude Eye Shadow X4 của MAC.', N'MAC146988', CAST(N'2019-10-25' AS Date), 0)
INSERT [dbo].[product] ([id], [subcate_id], [product_name], [color], [quantity], [sell_price], [orgin_price], [description], [product_code], [create_date], [deleted]) VALUES (21, 8, N'Studio Sculpt Shade And Line', N'', 0, 490000, 300000, N'Mọi cô nàng đều mua cho mình bảng mắt chỉ có 1 màu vì gặp khó khăn trong việc pha trộn, kết hợp các sắc màu với nhau. Hiểu được vấn đề này, MAC đã giúp cô gái sử dụng phấn mắt một cách dễ dàng và hiệu quả hơn rất nhiều. Sản phẩm Mineraliza Eye Shadow- Ever Amethyst tung ra thị trường và ngay lập tức dẫn đầu xu hướng làm đẹp.
.Mineraliza Eye Shadow- Ever Amethyst được thiết kế với 2 tông màu tuyệt đẹp, hoàn hảo hơn khi hòa quyện với nhau. Mineraliza Eye Shadow- Ever Amethyst là sự kết hợp của cặp bài trùng sắc mận trầm quyến rũ cùng màu nâu đơn giản nhưng sang trọng. Bộ đôi tím và nâu quyện vào nhau tạo nên sắc gợi cảm, giúp mọi cô nàng trở nên nổi bật.
', N'MAC154988', CAST(N'2019-10-25' AS Date), 0)
INSERT [dbo].[product] ([id], [subcate_id], [product_name], [color], [quantity], [sell_price], [orgin_price], [description], [product_code], [create_date], [deleted]) VALUES (22, 3, N'Kieu ANh', N'aaa', 2222, 43, 12, N'blabla', N'Tuan Thao', NULL, 0)
INSERT [dbo].[product] ([id], [subcate_id], [product_name], [color], [quantity], [sell_price], [orgin_price], [description], [product_code], [create_date], [deleted]) VALUES (31, 24, N'Test', N'xanh', 200, 430000, 120000, N'dsfkafkfdsf', N'Test', CAST(N'2019-11-14' AS Date), 0)
SET IDENTITY_INSERT [dbo].[product] OFF
SET IDENTITY_INSERT [dbo].[role] ON 

INSERT [dbo].[role] ([id], [role_name], [deleted]) VALUES (1, N'user', 0)
INSERT [dbo].[role] ([id], [role_name], [deleted]) VALUES (2, N'admin', 0)
SET IDENTITY_INSERT [dbo].[role] OFF
SET IDENTITY_INSERT [dbo].[status] ON 

INSERT [dbo].[status] ([id], [product_id], [status_name], [description_status], [deleted]) VALUES (1, 1, N'Sale', 0, 0)
INSERT [dbo].[status] ([id], [product_id], [status_name], [description_status], [deleted]) VALUES (2, 2, N'Sell', 6, 0)
INSERT [dbo].[status] ([id], [product_id], [status_name], [description_status], [deleted]) VALUES (3, 3, N'Sale', 0, 0)
INSERT [dbo].[status] ([id], [product_id], [status_name], [description_status], [deleted]) VALUES (4, 4, N'Sold off', 0, 0)
INSERT [dbo].[status] ([id], [product_id], [status_name], [description_status], [deleted]) VALUES (5, 5, N'Sale', 0, 0)
INSERT [dbo].[status] ([id], [product_id], [status_name], [description_status], [deleted]) VALUES (6, 10, N'Sell', 10, 0)
INSERT [dbo].[status] ([id], [product_id], [status_name], [description_status], [deleted]) VALUES (7, 11, N'Sell', 8, 0)
INSERT [dbo].[status] ([id], [product_id], [status_name], [description_status], [deleted]) VALUES (8, 12, N'Sell', 12, 0)
INSERT [dbo].[status] ([id], [product_id], [status_name], [description_status], [deleted]) VALUES (9, 13, N'Solf off', 0, 0)
INSERT [dbo].[status] ([id], [product_id], [status_name], [description_status], [deleted]) VALUES (10, 14, N'Solf off', 0, 0)
INSERT [dbo].[status] ([id], [product_id], [status_name], [description_status], [deleted]) VALUES (11, 15, N'Solf off', 0, 0)
INSERT [dbo].[status] ([id], [product_id], [status_name], [description_status], [deleted]) VALUES (12, 16, N'Solf off', 0, 0)
INSERT [dbo].[status] ([id], [product_id], [status_name], [description_status], [deleted]) VALUES (13, 17, N'Sale', 0, 0)
INSERT [dbo].[status] ([id], [product_id], [status_name], [description_status], [deleted]) VALUES (14, 18, N'Sale', 0, 0)
INSERT [dbo].[status] ([id], [product_id], [status_name], [description_status], [deleted]) VALUES (15, 19, N'Sell', 5, 0)
INSERT [dbo].[status] ([id], [product_id], [status_name], [description_status], [deleted]) VALUES (16, 20, N'Sell', 8, 0)
INSERT [dbo].[status] ([id], [product_id], [status_name], [description_status], [deleted]) VALUES (17, 21, N'Solf off', 0, 0)
INSERT [dbo].[status] ([id], [product_id], [status_name], [description_status], [deleted]) VALUES (18, 22, N'Sale', 0, 0)
INSERT [dbo].[status] ([id], [product_id], [status_name], [description_status], [deleted]) VALUES (27, 31, N'Sale', 0, 0)
SET IDENTITY_INSERT [dbo].[status] OFF
SET IDENTITY_INSERT [dbo].[status_order_detail] ON 

INSERT [dbo].[status_order_detail] ([id], [status_order_name], [deleted]) VALUES (1, N'Đang xử lí', 0)
INSERT [dbo].[status_order_detail] ([id], [status_order_name], [deleted]) VALUES (2, N'Đang vận chuyển', 0)
INSERT [dbo].[status_order_detail] ([id], [status_order_name], [deleted]) VALUES (3, N'Thành công', 0)
SET IDENTITY_INSERT [dbo].[status_order_detail] OFF
SET IDENTITY_INSERT [dbo].[sub_category] ON 

INSERT [dbo].[sub_category] ([id], [sub_category_code], [category_id], [sub_category_name], [deleted]) VALUES (2, N'SU1', 1, N'Son môi', 0)
INSERT [dbo].[sub_category] ([id], [sub_category_code], [category_id], [sub_category_name], [deleted]) VALUES (3, N'SU2', 1, N'Kem nền, Kem lót', 0)
INSERT [dbo].[sub_category] ([id], [sub_category_code], [category_id], [sub_category_name], [deleted]) VALUES (4, N'SU3', 1, N'Má hồng', 0)
INSERT [dbo].[sub_category] ([id], [sub_category_code], [category_id], [sub_category_name], [deleted]) VALUES (5, N'SU4', 1, N'Cọ tán', 0)
INSERT [dbo].[sub_category] ([id], [sub_category_code], [category_id], [sub_category_name], [deleted]) VALUES (6, N'SU5', 1, N'Tạo khối', 0)
INSERT [dbo].[sub_category] ([id], [sub_category_code], [category_id], [sub_category_name], [deleted]) VALUES (7, N'SU6', 1, N'Bấm Mi-Mascara ', 0)
INSERT [dbo].[sub_category] ([id], [sub_category_code], [category_id], [sub_category_name], [deleted]) VALUES (8, N'SU7', 1, N'Phấn mắt,má', 0)
INSERT [dbo].[sub_category] ([id], [sub_category_code], [category_id], [sub_category_name], [deleted]) VALUES (9, N'SU8', 1, N'Kẻ mắt', 0)
INSERT [dbo].[sub_category] ([id], [sub_category_code], [category_id], [sub_category_name], [deleted]) VALUES (10, N'SU9', 2, N'Sữa rửa mặt', 0)
INSERT [dbo].[sub_category] ([id], [sub_category_code], [category_id], [sub_category_name], [deleted]) VALUES (11, N'SU10', 2, N'Tẩy trang', 0)
INSERT [dbo].[sub_category] ([id], [sub_category_code], [category_id], [sub_category_name], [deleted]) VALUES (12, N'SU11', 2, N'Serum ', 0)
INSERT [dbo].[sub_category] ([id], [sub_category_code], [category_id], [sub_category_name], [deleted]) VALUES (13, N'SU12', 2, N'Kem dưỡng da', 0)
INSERT [dbo].[sub_category] ([id], [sub_category_code], [category_id], [sub_category_name], [deleted]) VALUES (14, N'SU13', 2, N'Nước hoa hồng', 0)
INSERT [dbo].[sub_category] ([id], [sub_category_code], [category_id], [sub_category_name], [deleted]) VALUES (15, N'SU14', 2, N'Tẩy da chết mặt', 0)
INSERT [dbo].[sub_category] ([id], [sub_category_code], [category_id], [sub_category_name], [deleted]) VALUES (16, N'SU15', 2, N'Tẩy da chết môi', 0)
INSERT [dbo].[sub_category] ([id], [sub_category_code], [category_id], [sub_category_name], [deleted]) VALUES (17, N'SU16', 2, N'Dưỡng da', 0)
INSERT [dbo].[sub_category] ([id], [sub_category_code], [category_id], [sub_category_name], [deleted]) VALUES (18, N'SU17', 2, N'Mặt nạ', 0)
INSERT [dbo].[sub_category] ([id], [sub_category_code], [category_id], [sub_category_name], [deleted]) VALUES (19, N'SU18', 3, N'Nước hoa', 0)
INSERT [dbo].[sub_category] ([id], [sub_category_code], [category_id], [sub_category_name], [deleted]) VALUES (20, N'SU19', 3, N'Sơn móng tay', 0)
INSERT [dbo].[sub_category] ([id], [sub_category_code], [category_id], [sub_category_name], [deleted]) VALUES (21, N'SU20', 3, N'Sữa dưỡng thể', 0)
INSERT [dbo].[sub_category] ([id], [sub_category_code], [category_id], [sub_category_name], [deleted]) VALUES (22, N'SU21', 3, N'Sữa tắm', 0)
INSERT [dbo].[sub_category] ([id], [sub_category_code], [category_id], [sub_category_name], [deleted]) VALUES (23, N'Su123', 4, N'Thay Duy', 0)
INSERT [dbo].[sub_category] ([id], [sub_category_code], [category_id], [sub_category_name], [deleted]) VALUES (24, N'SU8888', 5, N'aaaa', 0)
SET IDENTITY_INSERT [dbo].[sub_category] OFF
ALTER TABLE [dbo].[account] ADD  CONSTRAINT [DF_account_role_id]  DEFAULT ((1)) FOR [role_id]
GO
ALTER TABLE [dbo].[account] ADD  CONSTRAINT [DF_account_status]  DEFAULT ((2)) FOR [status]
GO
ALTER TABLE [dbo].[account] ADD  CONSTRAINT [DF_account_deleted]  DEFAULT ((0)) FOR [deleted]
GO
ALTER TABLE [dbo].[account_detail] ADD  CONSTRAINT [DF_account_detail_create_date]  DEFAULT (getdate()) FOR [create_date]
GO
ALTER TABLE [dbo].[account_detail] ADD  CONSTRAINT [DF_account_detail_deleted]  DEFAULT ((0)) FOR [deleted]
GO
ALTER TABLE [dbo].[categories] ADD  CONSTRAINT [DF__categorie__delet__5070F446]  DEFAULT ((0)) FOR [deleted]
GO
ALTER TABLE [dbo].[customer_infor] ADD  DEFAULT ((0)) FOR [deleted]
GO
ALTER TABLE [dbo].[image_avata] ADD  CONSTRAINT [DF_image_avata_deleted]  DEFAULT ((0)) FOR [deleted]
GO
ALTER TABLE [dbo].[images] ADD  CONSTRAINT [DF__images__deleted__5629CD9C]  DEFAULT ((0)) FOR [deleted]
GO
ALTER TABLE [dbo].[order_detail] ADD  CONSTRAINT [DF__order_det__delet__45F365D3]  DEFAULT ((0)) FOR [deleted]
GO
ALTER TABLE [dbo].[orders] ADD  CONSTRAINT [DF_orders_status_order_id]  DEFAULT ((1)) FOR [status_order_id]
GO
ALTER TABLE [dbo].[orders] ADD  CONSTRAINT [DF_orders_create_date]  DEFAULT (getdate()) FOR [create_date]
GO
ALTER TABLE [dbo].[orders] ADD  CONSTRAINT [DF__orders__deleted__5AEE82B9]  DEFAULT ((0)) FOR [deleted]
GO
ALTER TABLE [dbo].[product] ADD  CONSTRAINT [DF_product_create_date]  DEFAULT (getdate()) FOR [create_date]
GO
ALTER TABLE [dbo].[product] ADD  CONSTRAINT [DF__product__deleted__4AB81AF0]  DEFAULT ((0)) FOR [deleted]
GO
ALTER TABLE [dbo].[role] ADD  CONSTRAINT [DF_role_deleted]  DEFAULT ((0)) FOR [deleted]
GO
ALTER TABLE [dbo].[status] ADD  CONSTRAINT [DF_status_deleted]  DEFAULT ((0)) FOR [deleted]
GO
ALTER TABLE [dbo].[status_order_detail] ADD  CONSTRAINT [DF_status_order_deleted]  DEFAULT ((0)) FOR [deleted]
GO
ALTER TABLE [dbo].[sub_category] ADD  CONSTRAINT [DF__sub_categ__delet__5BE2A6F2]  DEFAULT ((0)) FOR [deleted]
GO
ALTER TABLE [dbo].[account]  WITH CHECK ADD  CONSTRAINT [FK_account_account_detail] FOREIGN KEY([account_detail_id])
REFERENCES [dbo].[account_detail] ([id])
GO
ALTER TABLE [dbo].[account] CHECK CONSTRAINT [FK_account_account_detail]
GO
ALTER TABLE [dbo].[account]  WITH CHECK ADD  CONSTRAINT [FK_account_role] FOREIGN KEY([role_id])
REFERENCES [dbo].[role] ([id])
GO
ALTER TABLE [dbo].[account] CHECK CONSTRAINT [FK_account_role]
GO
ALTER TABLE [dbo].[image_avata]  WITH CHECK ADD  CONSTRAINT [FK_image_avata_account_detail] FOREIGN KEY([account_detail_id])
REFERENCES [dbo].[account_detail] ([id])
GO
ALTER TABLE [dbo].[image_avata] CHECK CONSTRAINT [FK_image_avata_account_detail]
GO
ALTER TABLE [dbo].[images]  WITH CHECK ADD  CONSTRAINT [FK_images_product] FOREIGN KEY([product_id])
REFERENCES [dbo].[product] ([id])
GO
ALTER TABLE [dbo].[images] CHECK CONSTRAINT [FK_images_product]
GO
ALTER TABLE [dbo].[order_detail]  WITH CHECK ADD  CONSTRAINT [FK_order_detail_orders] FOREIGN KEY([order_id])
REFERENCES [dbo].[orders] ([id])
GO
ALTER TABLE [dbo].[order_detail] CHECK CONSTRAINT [FK_order_detail_orders]
GO
ALTER TABLE [dbo].[order_detail]  WITH CHECK ADD  CONSTRAINT [FK_order_detail_product] FOREIGN KEY([product_id])
REFERENCES [dbo].[product] ([id])
GO
ALTER TABLE [dbo].[order_detail] CHECK CONSTRAINT [FK_order_detail_product]
GO
ALTER TABLE [dbo].[orders]  WITH CHECK ADD  CONSTRAINT [FK_orders_account_detail] FOREIGN KEY([account_detail_id])
REFERENCES [dbo].[account_detail] ([id])
GO
ALTER TABLE [dbo].[orders] CHECK CONSTRAINT [FK_orders_account_detail]
GO
ALTER TABLE [dbo].[orders]  WITH CHECK ADD  CONSTRAINT [FK_orders_customer_infor] FOREIGN KEY([customer_infor_id])
REFERENCES [dbo].[customer_infor] ([id])
GO
ALTER TABLE [dbo].[orders] CHECK CONSTRAINT [FK_orders_customer_infor]
GO
ALTER TABLE [dbo].[orders]  WITH CHECK ADD  CONSTRAINT [FK_orders_status_order_detail] FOREIGN KEY([status_order_id])
REFERENCES [dbo].[status_order_detail] ([id])
GO
ALTER TABLE [dbo].[orders] CHECK CONSTRAINT [FK_orders_status_order_detail]
GO
ALTER TABLE [dbo].[product]  WITH CHECK ADD  CONSTRAINT [FK_product_sub_category] FOREIGN KEY([subcate_id])
REFERENCES [dbo].[sub_category] ([id])
GO
ALTER TABLE [dbo].[product] CHECK CONSTRAINT [FK_product_sub_category]
GO
ALTER TABLE [dbo].[status]  WITH CHECK ADD  CONSTRAINT [FK_status_product] FOREIGN KEY([product_id])
REFERENCES [dbo].[product] ([id])
GO
ALTER TABLE [dbo].[status] CHECK CONSTRAINT [FK_status_product]
GO
ALTER TABLE [dbo].[sub_category]  WITH CHECK ADD  CONSTRAINT [FK_sub_category_categories] FOREIGN KEY([category_id])
REFERENCES [dbo].[categories] ([id])
GO
ALTER TABLE [dbo].[sub_category] CHECK CONSTRAINT [FK_sub_category_categories]
GO
ALTER TABLE [dbo].[categories]  WITH CHECK ADD CHECK  (([category_code] like '%[CC0-9]%'))
GO
ALTER TABLE [dbo].[categories]  WITH CHECK ADD CHECK  (([category_code] like '[CC0-9]%'))
GO
ALTER TABLE [dbo].[orders]  WITH CHECK ADD  CONSTRAINT [CK__orders__1EA48E88] CHECK  (([ship_date]>[create_date]))
GO
ALTER TABLE [dbo].[orders] CHECK CONSTRAINT [CK__orders__1EA48E88]
GO
ALTER TABLE [dbo].[orders]  WITH CHECK ADD  CONSTRAINT [CK__orders__payment__1F98B2C1] CHECK  (([payment]='cash' OR [payment]='ATM card' OR [payment]='momo'))
GO
ALTER TABLE [dbo].[orders] CHECK CONSTRAINT [CK__orders__payment__1F98B2C1]
GO
ALTER TABLE [dbo].[product]  WITH CHECK ADD CHECK  (([orgin_price]<[sell_price]))
GO
ALTER TABLE [dbo].[product]  WITH CHECK ADD CHECK  (([orgin_price]>=(0)))
GO
ALTER TABLE [dbo].[product]  WITH CHECK ADD CHECK  (([quantity]>=(0)))
GO
ALTER TABLE [dbo].[product]  WITH CHECK ADD CHECK  (([sell_price]>=(0)))
GO
/****** Object:  StoredProcedure [dbo].[pagination]    Script Date: 14/11/2019 8:45:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
/**Phan trang vs list all**/
CREATE PROC [dbo].[pagination]
@Page INT,
@Size INT
AS
BEGIN
	select *
	from product
	WHERE deleted=0
	order by id 
	OFFSET (@Page -1) * @Size ROWS
	FETCH NEXT @Size ROWS ONLY
END
GO
/****** Object:  StoredProcedure [dbo].[paginationBuyProductMax]    Script Date: 14/11/2019 8:45:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[paginationBuyProductMax]
@Page INT,
@Size INT
AS
BEGIN
	SELECT * FROM
		(SELECT distinct product.*
		FROM product,order_detail
		WHERE product.id=order_detail.product_id
		and product.deleted=0
		and order_detail.deleted=0
		and order_detail.quantity>=3) as table1
		order by id desc
	OFFSET (@Page -1) * @Size ROWS
	FETCH NEXT @Size ROWS ONLY 
END
GO
/****** Object:  StoredProcedure [dbo].[paginationCategory]    Script Date: 14/11/2019 8:45:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[paginationCategory]
@Page INT,
@Size INT,
@subCategoryID INT
AS
BEGIN
	SELECT product.* 
	FROM product,sub_category
	WHERE product.subcate_id=sub_category.id
	and product.deleted=0
	and sub_category.deleted=0
	and sub_category.id=@subCategoryID
	ORDER BY id
	OFFSET (@Page -1) * @Size ROWS
	FETCH NEXT @Size ROWS ONLY
END
GO
/****** Object:  StoredProcedure [dbo].[paginationCategoryPrice]    Script Date: 14/11/2019 8:45:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[paginationCategoryPrice]
@Page INT,
@Size INT,
@SubID INT
AS
BEGIN
	select product.*
	from product,sub_category_price
	where product.subcate_id_price=sub_category_price.id
	and sub_category_price.id=@SubID
	and product.deleted=0
	and sub_category_price.deleted=0
	order by id desc
	OFFSET (@Page -1) * @Size ROWS
	FETCH NEXT @Size ROWS ONLY
END
GO
/****** Object:  StoredProcedure [dbo].[paginationNew]    Script Date: 14/11/2019 8:45:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[paginationNew]
@Page INT,
@Size INT
AS
BEGIN
	SELECT * FROM
	(SELECT TOP 15* FROM product
	where deleted=0
	ORDER BY id desc) as table1
	ORDER BY id desc
	OFFSET (@Page -1) * @Size ROWS
	FETCH NEXT @Size ROWS ONLY
END
GO
/****** Object:  StoredProcedure [dbo].[paginationSearch]    Script Date: 14/11/2019 8:45:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[paginationSearch]
@Page INT,
@Size INT,
@ProductName nvarchar(100)
AS
BEGIN
	SELECT *
	FROM product
	WHERE product_name LIKE '%'+@ProductName+'%'
	and deleted=0
	ORDER BY id 
	OFFSET (@Page -1) * @Size ROWS
	FETCH NEXT @Size ROWS ONLY
END
GO
