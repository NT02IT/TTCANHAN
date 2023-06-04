--
-- Tạo Database
--

CREATE DATABASE TTCANHAN
GO
USE TTCANHAN

--
-- Cấu trúc bảng THONGTIN
--

CREATE TABLE THONGTIN (
	ID varchar(5) primary key,
	HoLot nvarchar(50) not null,
	Ten nvarchar(20) not null,
	NgaySinh date not null,
	GioiTinh char(1) not null,
	--- 0 = Not known
	--- 1 = Male
	--- 2 = Female
	--- 9 = Not applicable
)