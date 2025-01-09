-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 05, 2025 at 05:08 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lizardwine`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `MaHD` int(11) NOT NULL,
  `MaR` int(11) NOT NULL,
  `SoLuoong` int(11) DEFAULT NULL,
  `DonGia` int(11) DEFAULT NULL,
  `ThanhTien` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chitiethoadon`
--

INSERT INTO `chitiethoadon` (`MaHD`, `MaR`, `SoLuoong`, `DonGia`, `ThanhTien`) VALUES
(1, 1, 2, 50000, 100000),
(1, 2, 1, 20000, 20000),
(2, 3, 3, 70000, 210000),
(2, 4, 1, 40000, 40000),
(3, 5, 4, 30000, 120000),
(4, 3, 5, 40000, 200000),
(5, 1, 2, 25000, 50000),
(5, 5, 1, 70000, 70000);

-- --------------------------------------------------------

--
-- Table structure for table `danhgia`
--

CREATE TABLE `danhgia` (
  `MaDG` int(11) NOT NULL,
  `MaHD` int(11) DEFAULT NULL,
  `MaR` int(11) DEFAULT NULL,
  `MaND` int(11) DEFAULT NULL,
  `NoiDungDG` varchar(500) DEFAULT NULL,
  `DiemDG` int(11) DEFAULT NULL,
  `NgayDG` date DEFAULT NULL,
  `TrangThai` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `danhgia`
--

INSERT INTO `danhgia` (`MaDG`, `MaHD`, `MaR`, `MaND`, `NoiDungDG`, `DiemDG`, `NgayDG`, `TrangThai`) VALUES
(1, 1, 1, 1, 'Rượu vang rất tuyệt, hương vị nhẹ nhàng, dễ uống.', 5, '2025-01-05', b'1'),
(2, 2, 2, 2, 'Rượu vodka có hương vị mạnh, thích hợp cho những ai ưa thích vị mạnh.', 4, '2025-01-06', b'1'),
(3, 3, 3, 3, 'Whisky có mùi gỗ sồi đặc trưng, hương vị rất ngon.', 5, '2025-01-07', b'1'),
(4, 4, 4, 4, 'Rượu vang trắng có hương hoa quả nhẹ, khá hợp với các món ăn nhẹ.', 3, '2025-01-08', b'1'),
(5, 5, 5, 5, 'Tequila ngon, nhưng mạnh, không thích hợp với mọi người.', 2, '2025-01-09', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `diachi`
--

CREATE TABLE `diachi` (
  `MaDC` int(11) NOT NULL,
  `MaND` int(11) DEFAULT NULL,
  `SoNha` varchar(10) DEFAULT NULL,
  `TenDuong` varchar(10) DEFAULT NULL,
  `TenXa` varchar(10) DEFAULT NULL,
  `TenHuyen` varchar(10) DEFAULT NULL,
  `TenTinh` varchar(10) DEFAULT NULL,
  `TrangThai` bit(1) DEFAULT NULL,
  `IsDefault` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `diachi`
--

INSERT INTO `diachi` (`MaDC`, `MaND`, `SoNha`, `TenDuong`, `TenXa`, `TenHuyen`, `TenTinh`, `TrangThai`, `IsDefault`) VALUES
(1, 1, '123', 'Nguyen Du', 'Quan 1', 'Hoan Kiem', 'Hanoi', b'1', b'1'),
(2, 1, '456', 'Le Loi', 'Quan 2', 'Ba Dinh', 'Hanoi', b'1', b'0'),
(3, 2, '789', 'Pham Hung', 'Quan 3', 'Cau Giay', 'Hanoi', b'1', b'0'),
(4, 3, '101', 'Hoang Hoa ', 'Quan 4', 'Dong Da', 'Hanoi', b'1', b'0'),
(5, 4, '202', 'Trieu Khuc', 'Quan 5', 'Thanh Xuan', 'Hanoi', b'1', b'0');

-- --------------------------------------------------------

--
-- Table structure for table `ds_anhruou`
--

CREATE TABLE `ds_anhruou` (
  `MaHA` int(11) NOT NULL,
  `AnhRuou` varchar(500) DEFAULT NULL,
  `TrangThai` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ds_anhruou`
--

INSERT INTO `ds_anhruou` (`MaHA`, `AnhRuou`, `TrangThai`) VALUES
(1, 'image1_url.jpg', b'1'),
(2, 'image2_url.jpg', b'1'),
(3, 'image3_url.jpg', b'1'),
(4, 'image4_url.jpg', b'0'),
(5, 'image5_url.jpg', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHD` int(11) NOT NULL,
  `MaND` int(11) DEFAULT NULL,
  `MaDC` int(11) DEFAULT NULL,
  `MaTT` int(11) DEFAULT NULL,
  `MaTrangThai` int(11) DEFAULT NULL,
  `MaKM` int(11) DEFAULT NULL,
  `NgayLapHD` date DEFAULT NULL,
  `TongTien` int(11) DEFAULT NULL,
  `TongThanhToan` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`MaHD`, `MaND`, `MaDC`, `MaTT`, `MaTrangThai`, `MaKM`, `NgayLapHD`, `TongTien`, `TongThanhToan`) VALUES
(1, 1, 1, 1, 1, 1, '2025-01-05', 100000, 90000),
(2, 1, 2, 2, 2, 1, '2025-01-06', 200000, 180000),
(3, 1, 1, 1, 3, 1, '2025-01-07', 150000, 145000),
(4, 1, 1, 2, 1, 1, '2025-01-08', 250000, 230000),
(5, 1, 1, 2, 2, 1, '2025-01-09', 120000, 115000);

-- --------------------------------------------------------

--
-- Table structure for table `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `MaKM` int(11) NOT NULL,
  `LoaiKhuyenMai` varchar(50) DEFAULT NULL,
  `GiaTriKM` int(11) DEFAULT NULL,
  `TrangThai` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `khuyenmai`
--

INSERT INTO `khuyenmai` (`MaKM`, `LoaiKhuyenMai`, `GiaTriKM`, `TrangThai`) VALUES
(1, 'Giảm giá theo hóa đơn', 1, b'1');

-- --------------------------------------------------------

--
-- Table structure for table `loairuou`
--

CREATE TABLE `loairuou` (
  `MaLoaiR` int(11) NOT NULL,
  `TenLoaiRuou` varchar(50) DEFAULT NULL,
  `CapRuou` varchar(50) DEFAULT NULL,
  `MaLoaiCha` int(11) DEFAULT NULL,
  `MoTa` varchar(500) DEFAULT NULL,
  `TrangThai` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `loairuou`
--

INSERT INTO `loairuou` (`MaLoaiR`, `TenLoaiRuou`, `CapRuou`, `MaLoaiCha`, `MoTa`, `TrangThai`) VALUES
(1, 'Rượu Vang', 'Cao cấp', NULL, 'Nhóm rượu được làm từ nho, chia thành các loại rượu vang đỏ, trắng, và champagne.', b'1'),
(2, 'Rượu Mạnh', 'Cao cấp', NULL, 'Nhóm rượu có độ cồn cao, bao gồm whisky, brandy, rum, vodka, tequila.', b'1'),
(3, 'Rượu Việt', 'Thấp', NULL, 'Nhóm rượu truyền thống của Việt Nam, bao gồm rượu nếp, rượu gạo, rượu cần.', b'1'),
(4, 'Rượu Vang Đỏ', 'Cao cấp', 1, 'Rượu vang đỏ được làm từ nho đỏ, có vị đậm đà, thích hợp cho các bữa tiệc sang trọng.', b'1'),
(5, 'Rượu Vang Trắng', 'Trung bình', 1, 'Rượu vang trắng nhẹ nhàng, dễ uống, thích hợp cho các bữa tiệc ngoài trời.', b'1'),
(6, 'Rượu Champagne', 'Cao cấp', 1, 'Rượu sủi bọt nổi tiếng, thích hợp cho các dịp lễ kỷ niệm.', b'1'),
(7, 'Rượu Brandy', 'Cao cấp', 2, 'Rượu mạnh được sản xuất từ nho, thường uống sau bữa ăn.', b'1'),
(8, 'Rượu Whisky', 'Cao cấp', 2, 'Rượu mạnh, được sản xuất chủ yếu từ ngũ cốc, có vị cay nồng.', b'1'),
(9, 'Rượu Vodka', 'Trung bình', 2, 'Rượu mạnh có xuất xứ từ Nga, có thể uống trực tiếp hoặc pha chế.', b'1'),
(10, 'Rượu Rum', 'Trung bình', 2, 'Rượu mạnh được làm từ mía hoặc củ cải đường, có vị ngọt đặc trưng.', b'1'),
(11, 'Rượu Tequila', 'Cao cấp', 2, 'Rượu mạnh được sản xuất từ cây agave, phổ biến trong các món cocktail.', b'1'),
(12, 'Rượu Nếp', 'Thấp', 3, 'Rượu truyền thống của Việt Nam, được làm từ gạo nếp, uống trong các dịp lễ hội.', b'1'),
(13, 'Rượu Gạo', 'Trung bình', 3, 'Rượu được làm từ gạo, phổ biến trong các bữa ăn hàng ngày của người Việt.', b'1'),
(14, 'Rượu Cần', 'Thấp', 3, 'Rượu được làm từ cây cần, thường được dùng trong các lễ hội của đồng bào dân tộc.', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `nguoidung`
--

CREATE TABLE `nguoidung` (
  `MaND` int(11) NOT NULL,
  `TenDangNhap` varchar(50) DEFAULT NULL,
  `AnhDaiDien` varchar(500) DEFAULT NULL,
  `MatKhau` varchar(100) DEFAULT NULL,
  `HoTen` varchar(50) DEFAULT NULL,
  `SoDienThoai` char(11) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `NgaySinh` date DEFAULT NULL,
  `TrangThai` bit(1) DEFAULT NULL,
  `IsAdmin` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nguoidung`
--

INSERT INTO `nguoidung` (`MaND`, `TenDangNhap`, `AnhDaiDien`, `MatKhau`, `HoTen`, `SoDienThoai`, `Email`, `NgaySinh`, `TrangThai`, `IsAdmin`) VALUES
(1, 'user1', 'url_image_1', 'password1', 'Nguyen Van A', '0912345678', 'nguyen.a@example.com', '1990-01-01', b'1', b'0'),
(2, 'user2', 'url_image_2', 'password2', 'Le Thi B', '0987654321', 'le.b@example.com', '1985-05-15', b'1', b'0'),
(3, 'admin1', 'url_image_3', 'adminpass', 'Tran Minh C', '0901122334', 'tran.c@example.com', '1980-11-11', b'1', b'1'),
(4, 'user3', 'url_image_4', 'password3', 'Pham Quang D', '0976543210', 'pham.d@example.com', '1992-03-20', b'1', b'0'),
(5, 'admin2', 'url_image_5', 'adminpassword', 'Nguyen Thi E', '0901234567', 'nguyen.e@example.com', '1988-07-25', b'1', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `phanhoi`
--

CREATE TABLE `phanhoi` (
  `MaPH` int(11) NOT NULL,
  `MaND` int(11) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `NoiDung` varchar(500) DEFAULT NULL,
  `TrangThai` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phanhoi`
--

INSERT INTO `phanhoi` (`MaPH`, `MaND`, `Email`, `NoiDung`, `TrangThai`) VALUES
(1, 1, 'user101@email.com', 'Rượu rất ngon, giao hàng nhanh, cảm ơn!', b'1'),
(2, 2, 'user102@email.com', 'Mong các bạn xem xét lại chất lượng bao bì, bị rách.', b'0'),
(3, 3, 'user103@email.com', 'Chất lượng rượu tốt, tuy nhiên giá hơi cao.', b'1'),
(4, 4, 'user104@email.com', 'Rượu rất thơm, hy vọng sẽ có nhiều chương trình khuyến mãi.', b'1'),
(5, 5, 'user105@email.com', 'Cảm ơn dịch vụ hỗ trợ, mọi thứ đều ổn.', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `ruou`
--

CREATE TABLE `ruou` (
  `MaR` int(11) NOT NULL,
  `MaLoaiR` int(11) DEFAULT NULL,
  `MaHA` int(11) DEFAULT NULL,
  `TenRuou` varchar(50) DEFAULT NULL,
  `XuatXu` varchar(50) DEFAULT NULL,
  `NongDoCon` int(11) DEFAULT NULL,
  `DungTich` int(11) DEFAULT NULL,
  `NamSanXuat` int(11) DEFAULT NULL,
  `ThanhPhan` varchar(500) DEFAULT NULL,
  `HuongVi` varchar(500) DEFAULT NULL,
  `GiaBan` int(11) DEFAULT NULL,
  `SoLuongTon` int(11) DEFAULT NULL,
  `MoTa` varchar(500) DEFAULT NULL,
  `TrangThai` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ruou`
--

INSERT INTO `ruou` (`MaR`, `MaLoaiR`, `MaHA`, `TenRuou`, `XuatXu`, `NongDoCon`, `DungTich`, `NamSanXuat`, `ThanhPhan`, `HuongVi`, `GiaBan`, `SoLuongTon`, `MoTa`, `TrangThai`) VALUES
(1, 1, 1, 'Rượu Vang Đỏ', 'Pháp', 13, 750, 2022, 'Nho, nước, men', 'Hương nho chín, ngọt nhẹ', 500000, 100, 'Rượu vang đỏ nhập khẩu từ Pháp', b'1'),
(2, 2, 2, 'Rượu Vodka', 'Nga', 40, 500, 2021, 'Nước, cồn', 'Mạnh, nặng', 300000, 50, 'Rượu Vodka nổi tiếng từ Nga', b'1'),
(3, 3, 3, 'Rượu Whisky', 'Scotland', 40, 700, 2020, 'Lúa mạch, nước', 'Hương thơm của gỗ sồi', 700000, 30, 'Whisky 12 năm tuổi', b'1'),
(4, 1, 4, 'Rượu Vang Trắng', 'Chile', 12, 750, 2023, 'Nho trắng, nước', 'Hương hoa quả nhẹ nhàng', 450000, 120, 'Rượu vang trắng nhập khẩu', b'0'),
(5, 2, 5, 'Rượu Tequila', 'Mexico', 35, 700, 2022, 'Nước, agave', 'Hương trái cây tươi mới', 600000, 60, 'Rượu Tequila cao cấp', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `thanhtoan`
--

CREATE TABLE `thanhtoan` (
  `MaTT` int(11) NOT NULL,
  `LoaiThanhToan` varchar(50) DEFAULT NULL,
  `TrangThai` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `thanhtoan`
--

INSERT INTO `thanhtoan` (`MaTT`, `LoaiThanhToan`, `TrangThai`) VALUES
(1, 'Thanh toán khi nhận hàng', b'1'),
(2, 'Thanh toán qua ví điện tử', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `trangthaihoadon`
--

CREATE TABLE `trangthaihoadon` (
  `MaTrangThai` int(11) NOT NULL,
  `LoaiTrangThai` varchar(50) DEFAULT NULL,
  `TrangThai` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `trangthaihoadon`
--

INSERT INTO `trangthaihoadon` (`MaTrangThai`, `LoaiTrangThai`, `TrangThai`) VALUES
(1, 'Chờ xác nhận', b'1'),
(2, 'Chờ giao hàng', b'1'),
(3, 'Đã nhận', b'1'),
(4, 'Đã hủy', b'1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD PRIMARY KEY (`MaHD`,`MaR`),
  ADD KEY `FK_CHITIETHOADON_RUOU` (`MaR`);

--
-- Indexes for table `danhgia`
--
ALTER TABLE `danhgia`
  ADD PRIMARY KEY (`MaDG`),
  ADD KEY `FK_DANHGIA_HOADON` (`MaHD`),
  ADD KEY `FK_DANHGIA_RUOU` (`MaR`),
  ADD KEY `FK_DANHGIA_NGUOIDUNG` (`MaND`);

--
-- Indexes for table `diachi`
--
ALTER TABLE `diachi`
  ADD PRIMARY KEY (`MaDC`),
  ADD KEY `FK_DIACHI_NGUOIDUNG` (`MaND`);

--
-- Indexes for table `ds_anhruou`
--
ALTER TABLE `ds_anhruou`
  ADD PRIMARY KEY (`MaHA`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHD`),
  ADD KEY `FK_HOADON_NGUOIDUNG` (`MaND`),
  ADD KEY `FK_HOADON_DIACHI` (`MaDC`),
  ADD KEY `FK_HOADON_THANHTOAN` (`MaTT`),
  ADD KEY `FK_HOADON_TRANGTHAIHOADON` (`MaTrangThai`),
  ADD KEY `FK_HOADON_KHUYENMAI` (`MaKM`);

--
-- Indexes for table `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`MaKM`);

--
-- Indexes for table `loairuou`
--
ALTER TABLE `loairuou`
  ADD PRIMARY KEY (`MaLoaiR`);

--
-- Indexes for table `nguoidung`
--
ALTER TABLE `nguoidung`
  ADD PRIMARY KEY (`MaND`);

--
-- Indexes for table `phanhoi`
--
ALTER TABLE `phanhoi`
  ADD PRIMARY KEY (`MaPH`),
  ADD KEY `FK_PHANHOI_NGUOIDUNG` (`MaND`);

--
-- Indexes for table `ruou`
--
ALTER TABLE `ruou`
  ADD PRIMARY KEY (`MaR`);

--
-- Indexes for table `thanhtoan`
--
ALTER TABLE `thanhtoan`
  ADD PRIMARY KEY (`MaTT`);

--
-- Indexes for table `trangthaihoadon`
--
ALTER TABLE `trangthaihoadon`
  ADD PRIMARY KEY (`MaTrangThai`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD CONSTRAINT `FK_CHITIETHOADON_HOADON` FOREIGN KEY (`MaHD`) REFERENCES `hoadon` (`MaHD`),
  ADD CONSTRAINT `FK_CHITIETHOADON_RUOU` FOREIGN KEY (`MaR`) REFERENCES `ruou` (`MaR`);

--
-- Constraints for table `danhgia`
--
ALTER TABLE `danhgia`
  ADD CONSTRAINT `FK_DANHGIA_HOADON` FOREIGN KEY (`MaHD`) REFERENCES `hoadon` (`MaHD`),
  ADD CONSTRAINT `FK_DANHGIA_NGUOIDUNG` FOREIGN KEY (`MaND`) REFERENCES `nguoidung` (`MaND`),
  ADD CONSTRAINT `FK_DANHGIA_RUOU` FOREIGN KEY (`MaR`) REFERENCES `ruou` (`MaR`);

--
-- Constraints for table `diachi`
--
ALTER TABLE `diachi`
  ADD CONSTRAINT `FK_DIACHI_NGUOIDUNG` FOREIGN KEY (`MaND`) REFERENCES `nguoidung` (`MaND`);

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `FK_HOADON_DIACHI` FOREIGN KEY (`MaDC`) REFERENCES `diachi` (`MaDC`),
  ADD CONSTRAINT `FK_HOADON_KHUYENMAI` FOREIGN KEY (`MaKM`) REFERENCES `khuyenmai` (`MaKM`),
  ADD CONSTRAINT `FK_HOADON_NGUOIDUNG` FOREIGN KEY (`MaND`) REFERENCES `nguoidung` (`MaND`),
  ADD CONSTRAINT `FK_HOADON_THANHTOAN` FOREIGN KEY (`MaTT`) REFERENCES `thanhtoan` (`MaTT`),
  ADD CONSTRAINT `FK_HOADON_TRANGTHAIHOADON` FOREIGN KEY (`MaTrangThai`) REFERENCES `trangthaihoadon` (`MaTrangThai`);

--
-- Constraints for table `phanhoi`
--
ALTER TABLE `phanhoi`
  ADD CONSTRAINT `FK_PHANHOI_NGUOIDUNG` FOREIGN KEY (`MaND`) REFERENCES `nguoidung` (`MaND`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
