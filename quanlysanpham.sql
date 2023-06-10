Create database quanlysanpham
go
use quanlysanpham
go
create table DanhMuc
(
	MaDM nvarchar(10) ,
	TenDM nvarchar(50),
	isDelete int,
	constraint pk_dm primary key(MaDM) 
)
go
create table SanPham
(
	MaSP nvarchar(10),
	TenSP nvarchar(50),
	SoLuong int,
	DonGia int,
	MaDM nvarchar(10),
	isDelete int,
	constraint pk_sp primary key(MaSP)
)
go
alter table SanPham
add constraint fk_sp foreign key (MaDM) references DanhMuc(MaDM) on delete cascade 
go
insert into DanhMuc
values
('1',N'Hàng điện tử',0),
('2',N'Hàng hóa chất',0),
('3',N'Hàng gia dụng',0)
go
insert into SanPham
values
('sp3',N'Chảo không dính',500,100,3,0),
('sp4',N'Nồi nấu lẩu',200,14,3,0),
('sp5',N'Bếp điện từ',200,15,3,0)
go
select * from DanhMuc where isDelete = 0
go	
select * from SanPham where isDelete =0
go 
delete from DanhMuc where MaDM = '3'