-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 17, 2024 lúc 12:31 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `farmmanagement`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `fullName` varchar(50) DEFAULT NULL,
  `userName` varchar(50) NOT NULL,
  `password` varchar(60) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`fullName`, `userName`, `password`, `role`, `status`, `email`) VALUES
('12', '123', '$2a$12$TMNRVTKQfUpl3BdZaGMD2eqx..Iux7gnE5E1EmItCk3LZNPZFPCAG', 'Quản lý kho', 0, 'di@gmail.com'),
('Admin', 'admin', '$2a$06$Xy33o2NBQ2X3l.S.dRxGnOnenFxTNuGk3BDnSPpe4cVKF4/ZJXNl6', 'Admin', 1, 'sinhbaoreact2003@gmail.com'),
('12312', 'aedas', '$2a$12$ufwUvRVA/8v0oAIrpESvYeKffV37aPOwGjYtt1cDtCRN2WMfU5pO2', 'Quản lý kho', 0, '2@gmail.com'),
('Hoàng Gia Bảo', 'bobo', '$2a$12$PhiTGBbHjHoB3dbS6BmCC.rzdMCBqDrdK9Y8Ae8GPcKe1RpHiWARO', 'Nhân viên xuất', 1, 'hgiabao2k3@gmail.com'),
('Trần Nhật Sinh', 'sinhsinh1122', '$2a$12$89As1J0AB0yrqGjnQUHtpevc6voGyvzAd8OvzkS1vGDo3YPO2P.Ia', 'Nhân viên nhập', 1, 'transinh342@gmail.com'),
('Nguyễn Thiên Ân', 'thienan', '$2a$12$myOaq0kATMzNkbxgzQEkPu8ht2K0pXOGzZMZo6nSBowq6EyoLo7tS', 'Quản lý kho', 1, 'a11611112003@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `maPhieu` varchar(50) NOT NULL,
  `maSP` varchar(50) NOT NULL,
  `soLuong` int(11) DEFAULT NULL,
  `donGia` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietphieunhap`
--

INSERT INTO `chitietphieunhap` (`maPhieu`, `maSP`, `soLuong`, `donGia`) VALUES
('PN1', 'SP10', 1, 23490000),
('PN1', 'SP9', 1, 19490000),
('PN10', 'SP2', 1, 23490000),
('PN10', 'SP6', 1, 22990000),
('SP6', 'SP3', 1, 340000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieuxuat`
--

CREATE TABLE `chitietphieuxuat` (
  `maPhieu` varchar(50) NOT NULL,
  `maSP` varchar(50) NOT NULL,
  `soLuong` int(11) DEFAULT NULL,
  `donGia` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietphieuxuat`
--

INSERT INTO `chitietphieuxuat` (`maPhieu`, `maSP`, `soLuong`, `donGia`) VALUES
('PX1', 'SP1', 1, 23490000),
('PX1', 'SP10', 13, 19490000),
('PX1', 'SP3', 1, 15000000),
('PX10', 'SP2', 1, 20790000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `commune`
--

CREATE TABLE `commune` (
  `commune_id` int(11) NOT NULL,
  `commune_name` varchar(100) NOT NULL,
  `district_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `commune`
--

INSERT INTO `commune` (`commune_id`, `commune_name`, `district_id`) VALUES
(1, 'Xã 1', 1),
(2, 'Xã 2', 1),
(3, 'Xã 3', 2),
(4, 'Xã 4', 2),
(5, 'Xã 5', 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `district`
--

CREATE TABLE `district` (
  `district_id` int(11) NOT NULL,
  `district_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `district`
--

INSERT INTO `district` (`district_id`, `district_name`) VALUES
(1, 'Huyện A'),
(2, 'Huyện B'),
(3, 'Huyện C');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `farm`
--

CREATE TABLE `farm` (
  `farm_id` int(11) NOT NULL,
  `farm_name` varchar(100) NOT NULL,
  `address` varchar(255) NOT NULL,
  `district_id` int(11) NOT NULL,
  `commune_id` int(11) NOT NULL,
  `owner` varchar(100) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `organization_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `farm`
--

INSERT INTO `farm` (`farm_id`, `farm_name`, `address`, `district_id`, `commune_id`, `owner`, `latitude`, `longitude`, `organization_id`) VALUES
(1, 'Farm 1', 'Địa chỉ 1', 1, 1, 'Chủ 1', NULL, NULL, 1),
(2, 'Farm 2', 'Địa chỉ 2', 1, 2, 'Chủ 2', NULL, NULL, 2),
(3, 'Farm 3', 'Địa chỉ 3', 2, 3, 'Chủ 3', NULL, NULL, 3),
(4, 'Farm 4', 'Địa chỉ 4', 2, 4, 'Chủ 4', NULL, NULL, 1),
(5, 'Farm 5', 'Địa chỉ 5', 3, 5, 'Chủ 5', NULL, NULL, 2),
(7, '123123', '123', 1, 1, '12323', NULL, NULL, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `farm_certificates`
--

CREATE TABLE `farm_certificates` (
  `certificate_id` int(11) NOT NULL,
  `farm_id` int(11) NOT NULL,
  `certificate_type` varchar(100) NOT NULL COMMENT 'Loại chứng nhận: Hợp chuẩn, VSATTP, ISO...',
  `issue_date` date DEFAULT NULL,
  `expiry_date` date DEFAULT NULL,
  `issuer` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT 1 COMMENT '1: Valid, 0: Expired'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `farm_certificates`
--

INSERT INTO `farm_certificates` (`certificate_id`, `farm_id`, `certificate_type`, `issue_date`, `expiry_date`, `issuer`, `status`) VALUES
(1, 1, 'Chứng nhận vệ sinh an toàn thực phẩm', '2023-01-10', '2025-01-10', 'Bộ Y Tế', 1),
(2, 2, 'Chứng nhận ISO 22000', '2022-03-15', '2024-03-15', 'Bộ Nông Nghiệp', 1),
(3, 3, 'Giấy phép chăn nuôi hợp chuẩn', '2021-11-20', '2023-11-20', 'Sở Nông Nghiệp Hà Nội', 0),
(4, 4, 'Chứng nhận kiểm dịch động vật', '2023-05-01', '2026-05-01', 'Cục Thú Y', 1),
(5, 5, 'Chứng nhận nông trại an toàn', '2022-07-12', '2025-07-12', 'Sở Nông Nghiệp', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `livestock_health`
--

CREATE TABLE `livestock_health` (
  `health_id` int(11) NOT NULL,
  `farm_id` int(11) NOT NULL,
  `disease_name` varchar(100) NOT NULL,
  `reported_date` date NOT NULL,
  `resolved_date` date DEFAULT NULL,
  `status` enum('Ongoing','Resolved') DEFAULT 'Ongoing',
  `comments` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `livestock_health`
--

INSERT INTO `livestock_health` (`health_id`, `farm_id`, `disease_name`, `reported_date`, `resolved_date`, `status`, `comments`) VALUES
(1, 1, 'Lở mồm long móng', '2023-08-10', '2023-08-20', '', 'Dịch bệnh đã được khống chế sau 10 ngày.'),
(2, 2, 'Dịch tả lợn Châu Phi', '2023-09-15', NULL, '', 'Hiện đang tiến hành cách ly và tiêu độc khử trùng.'),
(3, 3, 'Cúm gia cầm H5N1', '2023-07-05', '2023-07-15', '', 'Đã tiêm phòng cho toàn bộ đàn gia cầm.'),
(4, 4, 'Bệnh tai xanh', '2023-10-01', NULL, '', 'Đã báo cáo cơ quan thú y để có hướng xử lý.'),
(5, 5, 'Bệnh tiêu chảy cấp ở lợn', '2023-11-01', '2023-11-05', '', 'Bệnh lây lan nhanh nhưng đã được khống chế kịp thời.');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `maNhaCungCap` varchar(50) NOT NULL,
  `tenNhaCungCap` varchar(50) DEFAULT NULL,
  `Sdt` varchar(50) DEFAULT NULL,
  `diaChi` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`maNhaCungCap`, `tenNhaCungCap`, `Sdt`, `diaChi`) VALUES
('BINHMINH', 'Công ty CP Nhựa Bình Minh', '02839690973', '240 Hậu Giang, Phường 9, Quận 6, TP. Hồ Chí Minh'),
('BYZAN', 'Công ty Nội thất Byzan', '0932262123', 'Lô 12 BT3, KĐT VINACONEX 3, Nam Từ Liêm, Hà Nội'),
('CTCP', 'Tổng công ty Viglacera - CTCP', '02435536660', 'Tòa nhà Viglacera, Số 1 Đại lộ Thăng Long, Hà Nội'),
('DHB', 'Công ty TNHH Nhà Đẹp DHB Việt Nam', '0918800480', 'Số 70 Ng. 34 P. Hoàng Cầu, Chợ Dừa, Đống Đa, Hà Nội'),
('HALO', 'Halo Group', ' 02839257666', '01 Sương Nguyệt Ánh, P. Bến Thành, Quận 1, TP. Hồ Chí Minh'),
('HOAPHAT', 'Công ty cổ phần thép Hòa Phát', '02462848666', '66 Nguyễn Du, P. Nguyễn Du, Q. Hai Bà Trưng, Hà Nội'),
('HOASEN', 'Công ty CP Tập đoàn Hoa Sen', '18001515', '183 Nguyễn Văn Trỗi, Phường 10, Quận Phú Nhuận, TP. Hồ Chí Minh'),
('TINVIET', 'Công ty Nội thất Tín Việt', ' 02862625060', '31 Trần Văn Khánh, P. Tân Thuận Đông, Quận 7, TP. Hồ Chí Minh');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `organization`
--

CREATE TABLE `organization` (
  `organization_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `contact_person` varchar(100) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `organization_type` enum('Cá nhân','Tổ chức') NOT NULL,
  `status` int(11) DEFAULT 1 COMMENT '1: Active, 0: Inactive'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `organization`
--

INSERT INTO `organization` (`organization_id`, `name`, `contact_person`, `phone`, `email`, `address`, `organization_type`, `status`) VALUES
(1, 'Công ty CP Chăn Nuôi Việt', 'Nguyễn Văn A', '0123456789', 'nguyenvana@example.com', NULL, 'Tổ chức', 0),
(2, 'Hộ chăn nuôi Trần Gia', 'Trần Văn B', '0987654321', 'tranvanb@example.com', NULL, 'Cá nhân', 0),
(3, 'Công ty CP Nông Nghiệp Xanh', 'Phạm Thị C', '0912233445', 'phamthic@example.com', NULL, 'Tổ chức', 0),
(4, 'Hộ nuôi heo Minh Phát', 'Lê Văn D', '0909988776', 'levand@example.com', NULL, 'Cá nhân', 0),
(5, 'Công ty TNHH Nông Trại Xanh', 'Hoàng Thị E', '0933112233', 'hoangthie@example.com', NULL, 'Tổ chức', 0),
(6, 'Công ty CP Chăn Nuôi Việt', 'Nguyễn Văn A', '0123456789', 'nguyenvana@example.com', NULL, 'Tổ chức', 0),
(7, 'Hộ chăn nuôi Trần Gia', 'Trần Văn B', '0987654321', 'tranvanb@example.com', NULL, 'Cá nhân', 0),
(8, 'Công ty CP Nông Nghiệp Xanh', 'Phạm Thị C', '0912233445', 'phamthic@example.com', NULL, 'Tổ chức', 0),
(9, 'Hộ nuôi heo Minh Phát', 'Lê Văn D', '0909988776', 'levand@example.com', NULL, 'Cá nhân', 0),
(10, 'Công ty TNHH Nông Trại Xanh', 'Hoàng Thị E', '0933112233', 'hoangthie@example.com', NULL, 'Tổ chức', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE `phieunhap` (
  `maPhieu` varchar(50) NOT NULL,
  `thoiGianTao` timestamp NULL DEFAULT NULL,
  `nguoiTao` varchar(50) DEFAULT NULL,
  `maNhaCungCap` varchar(50) DEFAULT NULL,
  `tongTien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phieunhap`
--

INSERT INTO `phieunhap` (`maPhieu`, `thoiGianTao`, `nguoiTao`, `maNhaCungCap`, `tongTien`) VALUES
('PN1', '2022-12-01 13:59:09', 'admin', 'CTCP', 42980000),
('PN10', '2022-12-07 18:04:19', 'admin', 'HOAPHAT', 112440000),
('PN11', '2022-12-07 18:48:21', 'admin', 'CTCP', 98300000),
('PN12', '2022-12-16 02:19:48', 'admin', 'DHB', 39880000),
('PN13', '2022-12-16 02:19:36', 'admin', 'BYZAN', 38980000),
('SP6', '2024-11-28 19:39:52', 'admin', 'BINHMINH', 340000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieuxuat`
--

CREATE TABLE `phieuxuat` (
  `maPhieu` varchar(50) NOT NULL,
  `thoiGianTao` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `nguoiTao` varchar(50) NOT NULL,
  `tongTien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phieuxuat`
--

INSERT INTO `phieuxuat` (`maPhieu`, `thoiGianTao`, `nguoiTao`, `tongTien`) VALUES
('PX1', '2022-12-01 14:10:44', 'admin', 291860000),
('PX10', '2022-12-07 18:41:08', 'admin', 57160000),
('PX12', '2022-12-07 19:06:56', 'admin', 45370000),
('PX13', '2022-12-08 12:31:48', 'admin', 109420000),
('PX14', '2022-12-08 16:30:10', 'admin', 78650000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `production_facility`
--

CREATE TABLE `production_facility` (
  `facility_id` int(11) NOT NULL,
  `facility_name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `district_id` int(11) DEFAULT NULL,
  `commune_id` int(11) DEFAULT NULL,
  `contact_person` varchar(100) DEFAULT NULL,
  `contact_phone` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `production_facility`
--

INSERT INTO `production_facility` (`facility_id`, `facility_name`, `address`, `district_id`, `commune_id`, `contact_person`, `contact_phone`) VALUES
(1, 'Cơ sở sản xuất 1', 'Địa chỉ 1', 1, 1, 'Người A', '0123456789'),
(2, 'Cơ sở sản xuất 2', 'Địa chỉ 2', 2, 3, 'Người B', '0987654321'),
(3, 'test', 'test', 2, 4, 'Tran Tran Tran', '0833453456');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `maSP` varchar(50) NOT NULL,
  `tenSP` varchar(100) DEFAULT NULL,
  `soLuong` int(11) NOT NULL DEFAULT 0,
  `donGia` double NOT NULL DEFAULT 0,
  `xuatXu` varchar(50) DEFAULT NULL,
  `trangThai` int(11) DEFAULT NULL,
  `processing_status` enum('Chưa chế biến','Đang chế biến','Đã chế biến') DEFAULT 'Chưa chế biến'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`maSP`, `tenSP`, `soLuong`, `donGia`, `xuatXu`, `trangThai`, `processing_status`) VALUES
('SP1', 'GẠCH ỐP', 36, 250000, 'Việt Nam', 1, 'Chưa chế biến'),
('SP10', 'GẠCH LÓT', 106, 350000, 'Việt Nam', 1, 'Chưa chế biến'),
('SP11', '123213', 0, 123123, 'ádasd', 1, 'Chưa chế biến'),
('SP12', '123123', 0, 131231, '', 1, 'Chưa chế biến'),
('SP2', 'GẠCH LÁT ĐƯỜNG', 78, 226000, 'Việt Nam', 1, 'Chưa chế biến'),
('SP3', 'XỐP CÁCH ÂM', 54, 340000, 'Nhật', 1, 'Chưa chế biến'),
('SP4', 'VÒI HOA SEN', 43, 203000, 'Trung Quốc', 1, 'Chưa chế biến'),
('SP5', 'TỦ BẾP', 55, 5230000, 'Trung Quốc', 1, 'Chưa chế biến'),
('SP6', 'TỦ QUẦN ÁO', 73, 12450000, 'Hàn', 1, 'Chưa chế biến'),
('SP7', 'ĐIỀU HÒA', 43, 15499000, 'Hàn', 1, 'Chưa chế biến'),
('SP8', 'ĐÈN', 64, 534000, 'Hàn', 1, 'Chưa chế biến'),
('SP9', 'GHẾ', 13, 2500000, 'Nhật', 1, 'Chưa chế biến');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `system_action_history`
--

CREATE TABLE `system_action_history` (
  `action_id` int(11) NOT NULL,
  `action_time` timestamp NOT NULL DEFAULT current_timestamp(),
  `action_type` varchar(100) NOT NULL,
  `description` text DEFAULT NULL,
  `performed_by` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `system_action_history`
--

INSERT INTO `system_action_history` (`action_id`, `action_time`, `action_type`, `description`, `performed_by`) VALUES
(1, '2024-12-03 23:07:09', 'Thêm sản phẩm', 'Thêm sản phẩm mới: SP12 - 123123', 'admin');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `system_guides`
--

CREATE TABLE `system_guides` (
  `guide_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `testing_facility`
--

CREATE TABLE `testing_facility` (
  `facility_id` int(11) NOT NULL,
  `facility_name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `district_id` int(11) DEFAULT NULL,
  `commune_id` int(11) DEFAULT NULL,
  `contact_person` varchar(100) DEFAULT NULL,
  `contact_phone` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `testing_facility`
--

INSERT INTO `testing_facility` (`facility_id`, `facility_name`, `address`, `district_id`, `commune_id`, `contact_person`, `contact_phone`) VALUES
(1, 'Cơ sở khảo nghiệm 1', 'Địa chỉ 3', 3, 5, 'Người C', '0123456789'),
(2, 'Cơ sở khảo nghiệm 2', 'Địa chỉ 4', 2, 4, 'Người D', '0987654321');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_access_history`
--

CREATE TABLE `user_access_history` (
  `access_id` int(11) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `access_time` timestamp NOT NULL DEFAULT current_timestamp(),
  `farm_id` int(11) DEFAULT NULL,
  `ip_address` varchar(50) DEFAULT NULL,
  `device` varchar(100) DEFAULT NULL,
  `action` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `user_access_history`
--

INSERT INTO `user_access_history` (`access_id`, `user_name`, `access_time`, `farm_id`, `ip_address`, `device`, `action`) VALUES
(1, 'admin', '2024-12-03 21:28:31', 1, '127.0.0.1', 'Windows PC', 'Login'),
(2, 'admin', '2024-12-03 22:05:37', 1, '127.0.0.1', 'Windows PC', 'Login'),
(3, 'admin', '2024-12-03 22:10:18', 1, '127.0.0.1', 'Windows PC', 'Login'),
(4, 'admin', '2024-12-03 22:12:39', 1, '127.0.0.1', 'Windows PC', 'Login'),
(5, 'admin', '2024-12-03 22:13:55', 1, '127.0.0.1', 'Windows PC', 'Login'),
(6, 'admin', '2024-12-03 22:21:14', 1, '127.0.0.1', 'Windows PC', 'Login'),
(7, 'admin', '2024-12-03 22:28:53', 1, '127.0.0.1', 'Windows PC', 'Login'),
(8, 'admin', '2024-12-03 23:07:01', 1, '127.0.0.1', 'Windows PC', 'Login'),
(9, 'admin', '2024-12-03 23:14:46', 1, '127.0.0.1', 'Windows PC', 'Login'),
(10, 'admin', '2024-12-03 23:15:56', 1, '127.0.0.1', 'Windows PC', 'Login'),
(11, 'admin', '2024-12-03 23:20:39', 1, '127.0.0.1', 'Windows PC', 'Login'),
(12, 'admin', '2024-12-03 23:35:42', 1, '127.0.0.1', 'Windows PC', 'Login'),
(13, 'admin', '2024-12-03 23:40:30', 1, '127.0.0.1', 'Windows PC', 'Login'),
(14, 'admin', '2024-12-03 23:42:41', 1, '127.0.0.1', 'Windows PC', 'Login'),
(15, 'admin', '2024-12-03 23:43:29', 1, '127.0.0.1', 'Windows PC', 'Login'),
(16, 'admin', '2024-12-03 23:47:43', 1, '127.0.0.1', 'Windows PC', 'Login'),
(17, 'admin', '2024-12-03 23:51:06', 1, '127.0.0.1', 'Windows PC', 'Login'),
(18, 'admin', '2024-12-15 19:15:35', 1, '127.0.0.1', 'Windows PC', 'Login'),
(19, 'admin', '2024-12-15 19:26:11', 1, '127.0.0.1', 'Windows PC', 'Login'),
(20, 'admin', '2024-12-15 19:29:06', 1, '127.0.0.1', 'Windows PC', 'Login'),
(21, 'admin', '2024-12-15 20:19:33', 1, '127.0.0.1', 'Windows PC', 'Login'),
(22, 'admin', '2024-12-15 20:35:19', 1, '127.0.0.1', 'Windows PC', 'Login'),
(23, 'admin', '2024-12-15 20:54:49', 1, '127.0.0.1', 'Windows PC', 'Login');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`userName`) USING BTREE;

--
-- Chỉ mục cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD PRIMARY KEY (`maPhieu`,`maSP`),
  ADD KEY `FK_ChiTietPhieuNhap_SanPham` (`maSP`);

--
-- Chỉ mục cho bảng `chitietphieuxuat`
--
ALTER TABLE `chitietphieuxuat`
  ADD PRIMARY KEY (`maPhieu`,`maSP`),
  ADD KEY `FK_ChiTietPhieuXuat_SanPham` (`maSP`);

--
-- Chỉ mục cho bảng `commune`
--
ALTER TABLE `commune`
  ADD PRIMARY KEY (`commune_id`),
  ADD KEY `district_id` (`district_id`);

--
-- Chỉ mục cho bảng `district`
--
ALTER TABLE `district`
  ADD PRIMARY KEY (`district_id`);

--
-- Chỉ mục cho bảng `farm`
--
ALTER TABLE `farm`
  ADD PRIMARY KEY (`farm_id`),
  ADD KEY `district_id` (`district_id`),
  ADD KEY `commune_id` (`commune_id`),
  ADD KEY `fk_organization_id` (`organization_id`);

--
-- Chỉ mục cho bảng `farm_certificates`
--
ALTER TABLE `farm_certificates`
  ADD PRIMARY KEY (`certificate_id`),
  ADD KEY `farm_id` (`farm_id`);

--
-- Chỉ mục cho bảng `livestock_health`
--
ALTER TABLE `livestock_health`
  ADD PRIMARY KEY (`health_id`),
  ADD KEY `farm_id` (`farm_id`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`maNhaCungCap`);

--
-- Chỉ mục cho bảng `organization`
--
ALTER TABLE `organization`
  ADD PRIMARY KEY (`organization_id`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`maPhieu`),
  ADD KEY `FK_PhieuNhap_NhaCungCap` (`maNhaCungCap`),
  ADD KEY `FK_PhieuNhap_Account` (`nguoiTao`);

--
-- Chỉ mục cho bảng `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD PRIMARY KEY (`maPhieu`),
  ADD KEY `FK_PhieuXuat_Account` (`nguoiTao`);

--
-- Chỉ mục cho bảng `production_facility`
--
ALTER TABLE `production_facility`
  ADD PRIMARY KEY (`facility_id`),
  ADD KEY `district_id` (`district_id`),
  ADD KEY `commune_id` (`commune_id`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`maSP`);

--
-- Chỉ mục cho bảng `system_action_history`
--
ALTER TABLE `system_action_history`
  ADD PRIMARY KEY (`action_id`),
  ADD KEY `performed_by` (`performed_by`);

--
-- Chỉ mục cho bảng `system_guides`
--
ALTER TABLE `system_guides`
  ADD PRIMARY KEY (`guide_id`);

--
-- Chỉ mục cho bảng `testing_facility`
--
ALTER TABLE `testing_facility`
  ADD PRIMARY KEY (`facility_id`),
  ADD KEY `district_id` (`district_id`),
  ADD KEY `commune_id` (`commune_id`);

--
-- Chỉ mục cho bảng `user_access_history`
--
ALTER TABLE `user_access_history`
  ADD PRIMARY KEY (`access_id`),
  ADD KEY `farm_id` (`farm_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `commune`
--
ALTER TABLE `commune`
  MODIFY `commune_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `district`
--
ALTER TABLE `district`
  MODIFY `district_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `farm`
--
ALTER TABLE `farm`
  MODIFY `farm_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `farm_certificates`
--
ALTER TABLE `farm_certificates`
  MODIFY `certificate_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `livestock_health`
--
ALTER TABLE `livestock_health`
  MODIFY `health_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `organization`
--
ALTER TABLE `organization`
  MODIFY `organization_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `production_facility`
--
ALTER TABLE `production_facility`
  MODIFY `facility_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `system_action_history`
--
ALTER TABLE `system_action_history`
  MODIFY `action_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `system_guides`
--
ALTER TABLE `system_guides`
  MODIFY `guide_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `testing_facility`
--
ALTER TABLE `testing_facility`
  MODIFY `facility_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `user_access_history`
--
ALTER TABLE `user_access_history`
  MODIFY `access_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD CONSTRAINT `FK_ChiTietPhieuNhap_PhieuNhap` FOREIGN KEY (`maPhieu`) REFERENCES `phieunhap` (`maPhieu`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_ChiTietPhieuNhap_SanPham` FOREIGN KEY (`maSP`) REFERENCES `sanpham` (`maSP`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Các ràng buộc cho bảng `chitietphieuxuat`
--
ALTER TABLE `chitietphieuxuat`
  ADD CONSTRAINT `FK_ChiTietPhieuXuat_PhieuXuat` FOREIGN KEY (`maPhieu`) REFERENCES `phieuxuat` (`maPhieu`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_ChiTietPhieuXuat_SanPham` FOREIGN KEY (`maSP`) REFERENCES `sanpham` (`maSP`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Các ràng buộc cho bảng `commune`
--
ALTER TABLE `commune`
  ADD CONSTRAINT `commune_ibfk_1` FOREIGN KEY (`district_id`) REFERENCES `district` (`district_id`);

--
-- Các ràng buộc cho bảng `farm`
--
ALTER TABLE `farm`
  ADD CONSTRAINT `farm_ibfk_1` FOREIGN KEY (`district_id`) REFERENCES `district` (`district_id`),
  ADD CONSTRAINT `farm_ibfk_2` FOREIGN KEY (`commune_id`) REFERENCES `commune` (`commune_id`),
  ADD CONSTRAINT `fk_organization_id` FOREIGN KEY (`organization_id`) REFERENCES `organization` (`organization_id`);

--
-- Các ràng buộc cho bảng `farm_certificates`
--
ALTER TABLE `farm_certificates`
  ADD CONSTRAINT `farm_certificates_ibfk_1` FOREIGN KEY (`farm_id`) REFERENCES `farm` (`farm_id`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `livestock_health`
--
ALTER TABLE `livestock_health`
  ADD CONSTRAINT `livestock_health_ibfk_1` FOREIGN KEY (`farm_id`) REFERENCES `farm` (`farm_id`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `FK_PhieuNhap_Account` FOREIGN KEY (`nguoiTao`) REFERENCES `account` (`userName`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_PhieuNhap_NhaCungCap` FOREIGN KEY (`maNhaCungCap`) REFERENCES `nhacungcap` (`maNhaCungCap`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Các ràng buộc cho bảng `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD CONSTRAINT `FK_PhieuXuat_Account` FOREIGN KEY (`nguoiTao`) REFERENCES `account` (`userName`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Các ràng buộc cho bảng `production_facility`
--
ALTER TABLE `production_facility`
  ADD CONSTRAINT `production_facility_ibfk_1` FOREIGN KEY (`district_id`) REFERENCES `district` (`district_id`),
  ADD CONSTRAINT `production_facility_ibfk_2` FOREIGN KEY (`commune_id`) REFERENCES `commune` (`commune_id`);

--
-- Các ràng buộc cho bảng `system_action_history`
--
ALTER TABLE `system_action_history`
  ADD CONSTRAINT `system_action_history_ibfk_1` FOREIGN KEY (`performed_by`) REFERENCES `account` (`userName`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `testing_facility`
--
ALTER TABLE `testing_facility`
  ADD CONSTRAINT `testing_facility_ibfk_1` FOREIGN KEY (`district_id`) REFERENCES `district` (`district_id`),
  ADD CONSTRAINT `testing_facility_ibfk_2` FOREIGN KEY (`commune_id`) REFERENCES `commune` (`commune_id`);

--
-- Các ràng buộc cho bảng `user_access_history`
--
ALTER TABLE `user_access_history`
  ADD CONSTRAINT `user_access_history_ibfk_1` FOREIGN KEY (`farm_id`) REFERENCES `farm` (`farm_id`) ON DELETE SET NULL;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
