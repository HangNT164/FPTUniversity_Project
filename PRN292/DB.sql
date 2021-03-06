USE [Napoli_Centrale]
GO
/****** Object:  Table [dbo].[account]    Script Date: 2/10/2020 11:43:59 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[account](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[account_detail_id] [int] NULL,
	[email] [nvarchar](200) NULL,
	[password] [nvarchar](50) NULL,
	[role_id] [int] NULL,
	[status] [int] NULL,
	[deleted] [bit] NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[account_detail]    Script Date: 2/10/2020 11:44:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[account_detail](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
	[mobile] [nvarchar](50) NULL,
	[gender] [bit] NULL,
	[address] [nvarchar](100) NULL,
	[create_date] [date] NULL,
	[deleted] [bit] NULL,
 CONSTRAINT [PK_account_detail] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[bill]    Script Date: 2/10/2020 11:44:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[bill](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[table_id] [int] NULL,
	[price] [int] NULL,
	[customer_name] [nvarchar](50) NULL,
	[create_date] [date] NULL,
	[deleted] [bit] NULL,
 CONSTRAINT [PK_bill] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[category]    Script Date: 2/10/2020 11:44:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[category](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[category_name] [nvarchar](50) NULL,
	[category_code] [nvarchar](50) NULL,
	[deleted] [bit] NULL,
 CONSTRAINT [PK_category] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[customer_info]    Script Date: 2/10/2020 11:44:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[customer_info](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
	[mobile] [nvarchar](50) NULL,
	[address] [nvarchar](100) NULL,
	[deleted] [bit] NULL,
 CONSTRAINT [PK_customer_info] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[food]    Script Date: 2/10/2020 11:44:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[food](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[sub_cate_id] [nvarchar](100) NULL,
	[food_name] [nvarchar](500) NULL,
	[quantity] [int] NULL,
	[sell_price] [int] NULL,
	[orgin_price] [int] NULL,
	[create_date] [date] NULL,
	[deleted] [bit] NULL,
 CONSTRAINT [PK_Food] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[image_avata]    Script Date: 2/10/2020 11:44:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[image_avata](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[account_detail_id] [int] NULL,
	[image_link] [nvarchar](300) NULL,
	[deleted] [bit] NULL,
 CONSTRAINT [PK_image_avata] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[image_food]    Script Date: 2/10/2020 11:44:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[image_food](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[food_id] [int] NULL,
	[image_link] [nvarchar](50) NULL,
	[cover] [bit] NULL,
	[deleted] [bit] NULL,
 CONSTRAINT [PK_image_food] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[order_detail]    Script Date: 2/10/2020 11:44:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[order_detail](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[order_id] [int] NULL,
	[food_id] [int] NULL,
	[food_name] [nvarchar](50) NULL,
	[sell_price] [int] NULL,
	[orign_price] [int] NULL,
	[quantity] [int] NULL,
	[deleted] [bit] NULL,
 CONSTRAINT [PK_order_detail] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[orders]    Script Date: 2/10/2020 11:44:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[orders](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[account_detail_id] [int] NULL,
	[customer_info_id] [int] NULL,
	[status_order_id] [int] NULL,
	[total_price] [int] NULL,
	[note] [nvarchar](300) NULL,
	[create_date] [date] NULL,
	[deleted] [bit] NULL,
 CONSTRAINT [PK_order] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[role]    Script Date: 2/10/2020 11:44:00 PM ******/
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
/****** Object:  Table [dbo].[status]    Script Date: 2/10/2020 11:44:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[status](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[food_id] [int] NULL,
	[status_name] [nvarchar](50) NULL,
	[description] [nvarchar](200) NULL,
	[deleted] [bit] NULL,
 CONSTRAINT [PK_status] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[status_order]    Script Date: 2/10/2020 11:44:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[status_order](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[status_order_name] [nvarchar](50) NULL,
	[deleted] [bit] NULL,
 CONSTRAINT [PK_status_orders] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[sub_cate]    Script Date: 2/10/2020 11:44:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sub_cate](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[cate_id] [int] NULL,
	[sub_code] [nvarchar](50) NULL,
	[sub_cate_name] [nvarchar](50) NULL,
	[deleted] [bit] NULL,
 CONSTRAINT [PK_Sub_Cate] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tables]    Script Date: 2/10/2020 11:44:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tables](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[food_id] [int] NULL,
	[deleted] [bit] NULL,
 CONSTRAINT [PK_tables] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[category] ON 

INSERT [dbo].[category] ([id], [category_name], [category_code], [deleted]) VALUES (1, N'Đồ Ăn Nhanh', N'C01', 0)
INSERT [dbo].[category] ([id], [category_name], [category_code], [deleted]) VALUES (2, N'Món Chính', N'C02', 0)
INSERT [dbo].[category] ([id], [category_name], [category_code], [deleted]) VALUES (3, N'Món Tráng Miệng', N'C03', 0)
SET IDENTITY_INSERT [dbo].[category] OFF
SET IDENTITY_INSERT [dbo].[food] ON 

INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (1, N'1', N'Phở bò', 10000, 35000, 28000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (2, N'1', N'Phở gà', 10000, 35000, 26000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (3, N'1', N'Phở bò gà', 10000, 40000, 29000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (4, N'2', N'Bún Riêu', 6000, 35000, 27000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (5, N'2', N'Bún Bò', 6000, 35000, 26000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (6, N'2', N'Bún Cá', 6000, 35000, 29000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (7, N'2', N'Bún Đặc Biệt', 10000, 40000, 32000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (8, N'4', N'Bò Đồng Quê', 300, 99000, 61000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (9, N'4', N'Súp tuyết nhĩ thịt gà xé', 200, 99000, 56000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (10, N'4', N'Súp Tôm Cua Cốm Xanh', 230, 139000, 97200, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (11, N'4', N'Bò Úc Hầm Tiêu Xanh – Bánh Mì', 300, 129000, 89000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (12, N'4', N'Cơm Chiên Sò Điệp', 10, 119000, 78000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (13, N'4', N'Nấm Bào Ngư Xào Dầu Hào', 300, 169000, 122000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (14, N'4', N'Gỏi vịt Phương Đông', 300, 129000, 86000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (15, N'4', N'Lẩu gà sa tế', 1000, 519000, 365000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (16, N'5', N'Hoành Thánh', 100, 59000, 35000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (17, N'5', N'Súp Yan Du Xian', 200, 119000, 78000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (18, N'5', N'Thịt gà chặt', 300, 169000, 120000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (19, N'5', N'Đậu hũ sốt Tứ Xuyên', 1500, 63000, 45000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (20, N'5', N'Vịt quay Bắc Kinh', 300, 449000, 350000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (21, N'5', N'Bánh bao Kim Sa', 600, 99000, 64000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (22, N'7', N'Degustation', 600, 99000, 64000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (23, N'7', N'Tiramisu', 600, 99000, 59000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (24, N'7', N'Raspberry Cheese cake', 400, 129000, 88000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (25, N'7', N'Mousse Chocolate', 500, 129000, 78000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (26, N'8', N'Rượu Vang Đỏ', 20000, 319000, 260000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (27, N'8', N'Rượu Vang Trắng', 15000, 319000, 256000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (28, N'8', N'Rượu Vang Hồng', 20000, 319000, 270000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (29, N'8', N'Champagne', 10000, 559000, 340000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (30, N'8', N'Vang sủi tăm', 20000, 319000, 260000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (31, N'8', N'Matcha trà xanh', 20000, 49000, 32000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (32, N'8', N'Matcha Việt quất', 20000, 49000, 34000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (33, N'8', N'Matcha đá xay', 20000, 49000, 28000, CAST(N'2020-02-09' AS Date), 0)
INSERT [dbo].[food] ([id], [sub_cate_id], [food_name], [quantity], [sell_price], [orgin_price], [create_date], [deleted]) VALUES (34, N'8', N'Hồng trà sữa', 20000, 44000, 26000, CAST(N'2020-02-09' AS Date), 0)
SET IDENTITY_INSERT [dbo].[food] OFF
SET IDENTITY_INSERT [dbo].[image_food] ON 

INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (1, 1, N'img/phobo1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (2, 1, N'img/phobo2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (3, 1, N'img/phobo3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (4, 2, N'img/phoga1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (5, 2, N'img/phoga2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (6, 2, N'img/phoga3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (7, 3, N'img/phoboga1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (8, 3, N'img/phoboga2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (9, 3, N'img/phoboga3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (10, 4, N'img/bunrieucua1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (11, 4, N'img/bunrieucua2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (12, 4, N'img/bunrieucua3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (13, 5, N'img/bunbo1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (14, 5, N'img/bunbo2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (15, 5, N'img/bunbo3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (16, 6, N'img/bunca1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (17, 6, N'img/bunca2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (18, 6, N'img/bunca3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (19, 7, N'img/bundacbiet1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (20, 7, N'img/bundacbiet2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (21, 7, N'img/bundacbiet3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (22, 8, N'img/bodongque1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (23, 8, N'img/bodongque2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (24, 8, N'img/bodongque3.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (25, 9, N'img/suptuyetnhithitgaxe1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (26, 9, N'img/suptuyetnhithitgaxe2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (27, 9, N'img/suptuyetnhithitgaxe3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (28, 10, N'img/suptomcuacomxanh1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (29, 10, N'img/suptomcuacomxanh2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (30, 10, N'img/suptomcuacomxanh3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (31, 11, N'img/bohamtieuxanh1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (32, 11, N'img/bohamtieuxanh2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (33, 11, N'img/bohamtieuxanh3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (34, 12, N'img/comchienxodiep1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (35, 12, N'img/comchienxodiep2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (36, 12, N'img/comchienxodiep3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (37, 13, N'img/baongu1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (38, 13, N'img/baongu3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (39, 13, N'img/baongu2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (40, 14, N'img/goivit1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (41, 14, N'img/goivit2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (42, 14, N'img/goivit3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (43, 15, N'img/lauga1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (44, 15, N'img/lauga3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (45, 15, N'img/lauga2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (46, 16, N'img/hoanhthanh1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (47, 16, N'img/hoanhthanh2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (48, 16, N'img/hoanhthanh3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (49, 17, N'img/yanduxian1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (50, 17, N'img/yanduxian2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (51, 17, N'img/yanduxian3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (52, 18, N'img/thitga1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (53, 18, N'img/thitga2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (54, 18, N'img/thitga3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (55, 19, N'img/dauhu1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (56, 19, N'img/dauhu2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (57, 19, N'img/dauhu3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (58, 20, N'img/vitquay1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (59, 20, N'img/vitquay2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (60, 20, N'img/vitquay3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (61, 21, N'img/banhkimsa1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (62, 21, N'img/banhkimsa2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (63, 21, N'img/banhkimsa3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (64, 22, N'img/degustation1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (65, 22, N'img/degustation2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (66, 22, N'img/degustation3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (67, 23, N'img/tiramisu1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (68, 23, N'img/tiramisu2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (69, 23, N'img/tiramisu3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (70, 24, N'img/raspberrycake1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (71, 24, N'img/raspberrycake2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (72, 24, N'img/raspberrycake3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (73, 25, N'img/moussechocolate2.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (74, 25, N'img/moussechocolate1.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (75, 25, N'img/moussechocolate3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (76, 26, N'img/redwine1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (77, 26, N'img/redwine2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (78, 26, N'img/redwine3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (79, 27, N'img/whitewine1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (80, 27, N'img/whitewine2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (81, 27, N'img/whitewine3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (82, 28, N'img/rosewine1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (83, 28, N'img/rosewine2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (84, 28, N'img/rosewine3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (85, 29, N'img/champagne1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (86, 29, N'img/champagne2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (87, 29, N'img/champagne3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (88, 30, N'img/vangsuitrang1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (89, 30, N'img/vangsuitrang2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (90, 30, N'img/vangsuitrang3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (91, 31, N'img/matchatraxanh1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (92, 31, N'img/matchatraxanh2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (93, 31, N'img/matchatraxanh3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (94, 32, N'img/matchavietquat1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (95, 32, N'img/matchavietquat2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (96, 32, N'img/matchavietquat3.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (97, 33, N'img/matchadaxay1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (98, 33, N'img/matchadaxay2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (99, 33, N'img/matchadaxay3.jpg', 0, 0)
GO
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (100, 34, N'img/hongtra1.jpg', 1, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (101, 34, N'img/hongtra2.jpg', 0, 0)
INSERT [dbo].[image_food] ([id], [food_id], [image_link], [cover], [deleted]) VALUES (102, 34, N'img/hongtra3.jpg', 0, 0)
SET IDENTITY_INSERT [dbo].[image_food] OFF
SET IDENTITY_INSERT [dbo].[role] ON 

INSERT [dbo].[role] ([id], [role_name], [deleted]) VALUES (1, N'admin', 0)
INSERT [dbo].[role] ([id], [role_name], [deleted]) VALUES (2, N'user ', 0)
SET IDENTITY_INSERT [dbo].[role] OFF
SET IDENTITY_INSERT [dbo].[status] ON 

INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (1, 1, N'sell', N'0', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (2, 2, N'sale', N'3', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (3, 3, N'sale', N'3', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (4, 4, N'sale', N'3', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (5, 5, N'sell', N'0', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (6, 6, N'sell', N'0', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (7, 7, N'sell', N'0', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (8, 8, N'sell', N'0', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (9, 9, N'sell', N'0', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (10, 10, N'sell', N'0', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (11, 11, N'sell', N'0', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (12, 12, N'sell', N'0', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (13, 13, N'sell', N'0', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (14, 14, N'sell', N'0', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (15, 15, N'sell', N'0', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (16, 16, N'sell', N'0', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (17, 17, N'sell', N'0', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (18, 18, N'sell', N'0', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (19, 19, N'sell', N'0', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (20, 20, N'sale', N'1', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (21, 21, N'sell', N'0', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (22, 22, N'sell', N'0', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (23, 23, N'sell', N'0', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (24, 24, N'sell', N'0', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (25, 25, N'sale', N'1', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (26, 26, N'sell', N'0', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (27, 27, N'sell', N'0', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (28, 28, N'sell', N'0', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (29, 29, N'sale', N'2', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (30, 30, N'sell', N'0', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (31, 31, N'sell', N'0', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (32, 32, N'sell', N'0', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (33, 33, N'sell', N'0', 0)
INSERT [dbo].[status] ([id], [food_id], [status_name], [description], [deleted]) VALUES (34, 34, N'sell', N'0', 0)
SET IDENTITY_INSERT [dbo].[status] OFF
SET IDENTITY_INSERT [dbo].[status_order] ON 

INSERT [dbo].[status_order] ([id], [status_order_name], [deleted]) VALUES (1, N'Đang Xử Lý', 0)
INSERT [dbo].[status_order] ([id], [status_order_name], [deleted]) VALUES (2, N'Đang Vận Chuyển', 0)
INSERT [dbo].[status_order] ([id], [status_order_name], [deleted]) VALUES (3, N'Thành Công', 0)
SET IDENTITY_INSERT [dbo].[status_order] OFF
SET IDENTITY_INSERT [dbo].[sub_cate] ON 

INSERT [dbo].[sub_cate] ([id], [cate_id], [sub_code], [sub_cate_name], [deleted]) VALUES (1, 1, N'SC01', N'Phở', 0)
INSERT [dbo].[sub_cate] ([id], [cate_id], [sub_code], [sub_cate_name], [deleted]) VALUES (2, 1, N'SC02', N'Bún', 0)
INSERT [dbo].[sub_cate] ([id], [cate_id], [sub_code], [sub_cate_name], [deleted]) VALUES (3, 1, N'SC03', N'Hambuger', 0)
INSERT [dbo].[sub_cate] ([id], [cate_id], [sub_code], [sub_cate_name], [deleted]) VALUES (4, 2, N'SC04', N'Món ăn Việt Nam', 0)
INSERT [dbo].[sub_cate] ([id], [cate_id], [sub_code], [sub_cate_name], [deleted]) VALUES (5, 2, N'SC05', N'Món ăn Trung Quốc', 0)
INSERT [dbo].[sub_cate] ([id], [cate_id], [sub_code], [sub_cate_name], [deleted]) VALUES (6, 2, N'SC03', N'Lẩu Hải Sản', 0)
INSERT [dbo].[sub_cate] ([id], [cate_id], [sub_code], [sub_cate_name], [deleted]) VALUES (7, 3, N'SC03', N'Đồ Ngọt', 0)
INSERT [dbo].[sub_cate] ([id], [cate_id], [sub_code], [sub_cate_name], [deleted]) VALUES (8, 3, N'SC03', N'Đồ Uống', 0)
SET IDENTITY_INSERT [dbo].[sub_cate] OFF
ALTER TABLE [dbo].[account] ADD  CONSTRAINT [DF_account_deleted]  DEFAULT ((0)) FOR [deleted]
GO
ALTER TABLE [dbo].[account_detail] ADD  CONSTRAINT [DF_account_detail_create_date]  DEFAULT (getdate()) FOR [create_date]
GO
ALTER TABLE [dbo].[account_detail] ADD  CONSTRAINT [DF_account_detail_deleted]  DEFAULT ((0)) FOR [deleted]
GO
ALTER TABLE [dbo].[bill] ADD  CONSTRAINT [DF_bill_create_date]  DEFAULT (getdate()) FOR [create_date]
GO
ALTER TABLE [dbo].[bill] ADD  CONSTRAINT [DF_bill_deleted]  DEFAULT ((0)) FOR [deleted]
GO
ALTER TABLE [dbo].[category] ADD  CONSTRAINT [DF_category_deleted]  DEFAULT ((0)) FOR [deleted]
GO
ALTER TABLE [dbo].[customer_info] ADD  CONSTRAINT [DF_customer_info_deleted]  DEFAULT ((0)) FOR [deleted]
GO
ALTER TABLE [dbo].[food] ADD  CONSTRAINT [DF_Food_create_date]  DEFAULT (getdate()) FOR [create_date]
GO
ALTER TABLE [dbo].[food] ADD  CONSTRAINT [DF_food_deleted]  DEFAULT ((0)) FOR [deleted]
GO
ALTER TABLE [dbo].[image_avata] ADD  CONSTRAINT [DF_image_avata_deleted]  DEFAULT ((0)) FOR [deleted]
GO
ALTER TABLE [dbo].[image_food] ADD  CONSTRAINT [DF_image_food_deleted]  DEFAULT ((0)) FOR [deleted]
GO
ALTER TABLE [dbo].[order_detail] ADD  CONSTRAINT [DF_order_detail_deleted]  DEFAULT ((0)) FOR [deleted]
GO
ALTER TABLE [dbo].[orders] ADD  CONSTRAINT [DF_order_create_date]  DEFAULT (getdate()) FOR [create_date]
GO
ALTER TABLE [dbo].[orders] ADD  CONSTRAINT [DF_orders_deleted]  DEFAULT ((0)) FOR [deleted]
GO
ALTER TABLE [dbo].[role] ADD  CONSTRAINT [DF_role_deleted]  DEFAULT ((0)) FOR [deleted]
GO
ALTER TABLE [dbo].[status] ADD  CONSTRAINT [DF_status_deleted]  DEFAULT ((0)) FOR [deleted]
GO
ALTER TABLE [dbo].[status_order] ADD  CONSTRAINT [DF_status_orders_deleted]  DEFAULT ((0)) FOR [deleted]
GO
ALTER TABLE [dbo].[sub_cate] ADD  CONSTRAINT [DF_sub_cate_deleted]  DEFAULT ((0)) FOR [deleted]
GO
ALTER TABLE [dbo].[tables] ADD  CONSTRAINT [DF_tables_deleted]  DEFAULT ((0)) FOR [deleted]
GO
ALTER TABLE [dbo].[food]  WITH CHECK ADD  CONSTRAINT [CHECK_orgin_price] CHECK  (([orgin_price]>(0)))
GO
ALTER TABLE [dbo].[food] CHECK CONSTRAINT [CHECK_orgin_price]
GO
ALTER TABLE [dbo].[food]  WITH CHECK ADD  CONSTRAINT [CHECK_orgin_price1] CHECK  (([orgin_price]<[sell_price]))
GO
ALTER TABLE [dbo].[food] CHECK CONSTRAINT [CHECK_orgin_price1]
GO
ALTER TABLE [dbo].[food]  WITH CHECK ADD  CONSTRAINT [CHECK_QUANTITY] CHECK  (([quantity]>(0)))
GO
ALTER TABLE [dbo].[food] CHECK CONSTRAINT [CHECK_QUANTITY]
GO
ALTER TABLE [dbo].[food]  WITH CHECK ADD  CONSTRAINT [CHECK_sell_price] CHECK  (([sell_price]>(0)))
GO
ALTER TABLE [dbo].[food] CHECK CONSTRAINT [CHECK_sell_price]
GO
ALTER TABLE [dbo].[order_detail]  WITH CHECK ADD  CONSTRAINT [CHECK_orign_price2] CHECK  (([orign_price]>(0)))
GO
ALTER TABLE [dbo].[order_detail] CHECK CONSTRAINT [CHECK_orign_price2]
GO
ALTER TABLE [dbo].[order_detail]  WITH CHECK ADD  CONSTRAINT [CHECK_quantity1] CHECK  (([quantity]>(0)))
GO
ALTER TABLE [dbo].[order_detail] CHECK CONSTRAINT [CHECK_quantity1]
GO
ALTER TABLE [dbo].[order_detail]  WITH CHECK ADD  CONSTRAINT [CHECK_sell_prices] CHECK  (([sell_price]>(0)))
GO
ALTER TABLE [dbo].[order_detail] CHECK CONSTRAINT [CHECK_sell_prices]
GO
ALTER TABLE [dbo].[order_detail]  WITH CHECK ADD  CONSTRAINT [CHECK_sell_prices1] CHECK  (([sell_price]>[orign_price]))
GO
ALTER TABLE [dbo].[order_detail] CHECK CONSTRAINT [CHECK_sell_prices1]
GO
ALTER TABLE [dbo].[orders]  WITH CHECK ADD  CONSTRAINT [CHECK_total_price] CHECK  (([total_price]>(0)))
GO
ALTER TABLE [dbo].[orders] CHECK CONSTRAINT [CHECK_total_price]
GO
/****** Object:  StoredProcedure [dbo].[LoginAccount]    Script Date: 2/10/2020 11:44:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create proc [dbo].[LoginAccount] @Email nvarchar(200),@Password nvarchar(50)
as 
begin
	declare @count int
	declare @res bit
	select @count=count(*)from account WHERE email=@Email and password=@Password
	if(@count>0)
		set @res=1
	else
		set @res=0
	select @res
end
GO
