create database quanlynhasach
go
use quanlynhasach 
go
create table NguoiDung
(
	ND_ID int,
	TenDN nvarchar(50),
	MatKhau nvarchar(20),
	HoTen  nvarchar(100),
	Email nvarchar(50),
	DiaChi nvarchar(100),
	NgaySinh date,
	GioiTinh nvarchar(10),
	Constraint pk_nd primary key(ND_ID)
)
create table LoaiSach
(
	LS_ID int ,
	Ten nvarchar(100),
	MoTa nvarchar(200),
	Constraint pk_ls primary key(LS_ID)
)
create table Sach
(
	S_ID int ,
	TieuDe nvarchar(100),
	TacGia nvarchar(100),
	NamSX int,
	TheLoai int,
	MoTa  nvarchar(200),
	Constraint pk_s primary key(S_ID)
)
create table HoaDon
(
	HD_ID int ,
	Ngay date,
	NhanVien nvarchar(200),
	TenKH nvarchar(200),
	GhiChu nvarchar(200),
	Constraint pk_hd primary key(HD_ID)
)
create table CTHoaDon
(
	CTHD_ID int,
	IDHoaDon int,
	IDSach int,
	SoLuong int,
	GiaBan float,
	Constraint pk_cthd primary key(CTHD_ID)
)
create table PhieuNhapSach
(
	PNS_ID int ,
	GhiChu nvarchar(200),
	Ngay date,
	NhanVien nvarchar(200),
	Constraint pk_pns primary key(PNS_ID)
)
create table CTPhieuNhapSach
(
	CTPNS_ID int ,
	IDPhieuNhapSach int,
	IDSach int,
	SoLuong int,
	DonGia float,
	Constraint pk_ctpns primary key(CTPNS_ID)
)

ALTER TABLE Sach ADD CONSTRAINT FK_SACH FOREIGN KEY(TheLoai) REFERENCES LoaiSach(LS_ID) on delete cascade
alter table CTHoaDon add constraint fk_ct foreign key(IDHoaDon) references HoaDon(HD_ID) on delete cascade
alter table CTHoaDon add constraint fk_ct2 foreign key(IDSach) references Sach(S_ID) on delete cascade
alter table CTPhieuNhapSach add constraint fk_ph foreign key(IDPhieuNhapSach) references PhieuNhapSach(PNS_ID) on delete cascade
alter table CTPhieuNhapSach add constraint fk_ph2 foreign key(IDSach) references Sach(S_ID) on delete cascade

insert into NguoiDung values (01,'thao','123',N'Thảo',N'nguyen123@gmail.com',N'Tp Hồ Chí Minh','03/04/1988','Nam')
insert into NguoiDung values (002,'thaodangyeu','123',N'Thảo Thảo',N'thanh@gmail.com',N'Tp Hồ Chí Minh','01/10/1978',N'Nữ')

insert into LoaiSach values (1,N'Sách giáo khoa',N'sách giáo khoa từ 1 đến 12')
insert into LoaiSach values (2,N'Sách tiếng diệt ',N'dành cho trẻ em' )
insert into LoaiSach values (3,N'10 Vạn Câu Hỏi Vì Seo',N'Những câu hỏi mà bé hong bik')

insert into Sach values (987,N'Bé Tập Tô Màu Các Loài Hoa',N'Thiên Thiên',2012,1,N'dành cho trẻ em')
insert into Sach values (654,N'Bé Tập Tô Màu Các Loài Chim Rừng',N'Thiên Nhiên',2007,2,N'dành cho trẻ em')
insert into Sach values (321,N'10 Vạn Câu Hỏi Vì Seo',N'Tố Hưũ',2001,3,N'dành cho trẻ em và mẹ')

set dateformat dmy
insert into HoaDon values (1010,'13/04/2022',N'Nguyễn Nguyên Nguyẽn',N'Thảo','No')
insert into HoaDon values (1212,'25/12/2022',N'Lê Thanh Thanh',N'Thảo',N'chuyển khỏan')
insert into HoaDon values (1313,'13/04/2022',N'Trần Thị Thu',N'Thảo',N'Mua trả góp')

insert into CTHoaDon values (111,'1010','987','10',1000000)
insert into CTHoaDon values (222,'1212','654','1',250000)
insert into CTHoaDon values (333,'1313','321','2',450000)

insert into PhieuNhapSach values (2021,'No','21/12/2022',N'Nguyễn Nguyên Nguyẽn')
insert into PhieuNhapSach values (2022,N'Nhập ít','11/11/2019',N'Nguyễn Nguyên Nguyẽn')
insert into PhieuNhapSach values (2023,'No','10/01/2023',N'Trần Thị Thu')

insert into CTPhieuNhapSach values (1122,'2021','987',100,50000000)
insert into CTPhieuNhapSach values (1133,'2022','654',99,49000000)
insert into CTPhieuNhapSach values (1144,'2023','321',100,50000000)
