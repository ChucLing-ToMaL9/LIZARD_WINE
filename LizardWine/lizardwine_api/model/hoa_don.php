<?php
    class HoaDon {
        private $conn;
        
        public $maHD;

        public function __construct($conn)
        {
            $this->conn = $conn;
        }

        public function layThongTinHoaDonTheoTTHD($maTT){
            $sql = " 
                SELECT hoadon.MaHD, trangthaihoadon.LoaitrangThai, hoadon.NgayLapHD, hoadon.TongThanhToan 
                FROM hoadon 
                INNER JOIN trangthaihoadon ON hoadon.MaTrangThai = trangthaihoadon.MaTrangThai 
                WHERE hoadon.MaTrangThai = ? 
                ORDER BY hoadon.MaHD;
            ";

            $stmt = $this->conn->prepare($sql);
            $stmt->bind_param("i", $maTT); 
            $stmt->execute();
            $result = $stmt->get_result();
            return $result;
        }

        public function xemChiTietHoaDon($maHD){
            $sql = " 
                SELECT hoadon.MaHD, nguoidung.TenDangNhap, nguoidung.SoDienThoai, 
                    CONCAT( diachi.SoNha , ' ', diachi.TenDuong , ' ', diachi.TenXa , ' ', diachi.TenHuyen , ' ', diachi.TenTinh) AS DiaChi,
                    thanhtoan.LoaiThanhToan, trangthaihoadon.LoaitrangThai, 
                    khuyenmai.LoaiKhuyenMai, khuyenmai.GiaTriKM, hoadon.NgayLapHD, hoadon.TongTien, hoadon.TongThanhToan 
                FROM hoadon 
                INNER JOIN nguoidung ON hoadon.MaND = nguoidung.MaND 
                INNER JOIN diachi ON hoadon.MaDC = diachi.MaDC 
                INNER JOIN thanhtoan ON hoadon.MaTT = thanhtoan.MaTT 
                INNER JOIN trangthaihoadon ON hoadon.MaTrangThai = trangthaihoadon.MaTrangThai 
                INNER JOIN khuyenmai ON hoadon.MaKM = khuyenmai.MaKM 
                WHERE hoadon.MaHD = ? 
                ORDER BY hoadon.MaHD;
            ";

            $stmt = $this->conn->prepare($sql);
            $stmt->bind_param("i", $maHD); 
            $stmt->execute();
            $result = $stmt->get_result();
            return $result;
        }
        public function layCTHDtheoMaHD($maHD){
            $sql = " 
                SELECT  r.MaR, r.TenRuou, SoLuoong, DonGia, ThanhTien
                FROM chitiethoadon 
                INNER JOIN ruou r ON r.MaR = chitiethoadon.MaR 
                WHERE chitiethoadon.MaHD = ? 
                
            ";

            $stmt = $this->conn->prepare($sql);
            $stmt->bind_param("i", $maHD); 
            $stmt->execute();
            $result = $stmt->get_result();
            return $result;
        }

     
        public function capNhatTrangThaiHoaDon(){
            $sql = "UPDATE hoadon SET MaTrangThai = MaTrangThai + 1 Where MaHD ='". $this->maHD ."' AND MaTrangThai < 4";
            if (mysqli_query($this->conn, $sql)) {
                return true;
            } else {
                return mysqli_error($this->conn);
            }
        }

    }