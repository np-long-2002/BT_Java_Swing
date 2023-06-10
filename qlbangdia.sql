create database quanlybangdia
go
use quanlybangdia
go
create table CDDVD
(
	Ma nvarchar(50),
	TieuDe nvarchar(50),
	LoaiDia nvarchar(50),
	NamXB int,
	constraint pk_cddvd primary key (ma)
)
go
insert into CDDVD
values
('dia1',N'Phim Hài','DVD',2002),
('dia2',N'Phim Hành Động','CD',2004)