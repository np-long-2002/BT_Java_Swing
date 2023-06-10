Create database quanlykhachhang
GO
USE [quanlykhachhang]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 24/03/2023 10:53:33 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [nvarchar](50) NOT NULL,
	[TenKH] [nvarchar](50) NULL,
	[NamSinh] [int] NULL,
	[MaNhom] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NhomKhachHang]    Script Date: 24/03/2023 10:53:33 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhomKhachHang](
	[MaNhom] [nvarchar](50) NOT NULL,
	[TenNhom] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNhom] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[KhachHang]  WITH CHECK ADD  CONSTRAINT [fk] FOREIGN KEY([MaNhom])
REFERENCES [dbo].[NhomKhachHang] ([MaNhom])
GO
ALTER TABLE [dbo].[KhachHang] CHECK CONSTRAINT [fk]
GO
Insert into NhomKhachHang
values('KQ',N'Khách Thân Quen'),
('KM',N'Khách Mới')
GO
Insert into KhachHang
values
('KH01',N'Nguyễn Phước Long',2002,'KQ'),
('KH02',N'Phan Chí Toàn',2002,'KM')