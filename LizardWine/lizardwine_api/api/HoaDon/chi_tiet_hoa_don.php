<?php
header("Content-Type: application/json");
require_once("../../config/db.php");
require_once("../../model/hoa_don.php");
require_once("../../model/ruou.php");

$db = new Database();
$conn = $db->connect();
$hoa_don = new HoaDon($conn);
$ruou = new Ruou($conn);

// Lấy tham số từ query string
$maHD = isset($_GET['MaHD']) ? intval($_GET['MaHD']) : 0;

if ($maHD > 0) {
    // Lấy thông tin rượu theo mã
    $result = $hoa_don->xemChiTietHoaDon($maHD);

    if ($result && $result->num_rows > 0) {
        $data = $result->fetch_assoc();
        $maha = null;

        $response = [
            "MaHD" => $data["MaHD"],
            "TenDangNhap" => $data["TenDangNhap"],
            "SoDienThoai" => $data["SoDienThoai"],
            "DiaChi" => $data["DiaChi"],
            "ChiTietHoaDon" => [],
            "LoaiThanhToan" => $data["LoaiThanhToan"],
            "LoaitrangThai" => $data["LoaitrangThai"],
            "LoaiKhuyenMai" => $data["LoaiKhuyenMai"],
            "GiaTriKM" => $data["GiaTriKM"],
            "NgayLapHD" => $data["NgayLapHD"],
            "TongTien" => $data["TongTien"],
            "TongThanhToan" => $data["TongThanhToan"],
        ];

        $result_cthd= $hoa_don->layCTHDtheoMaHD($maHD);
        while ($row = mysqli_fetch_assoc($result_cthd)) 
        {

            $maha = $row["MaR"];
            $anhruou = [];
            $result_dsar= $ruou->layDSAnhRuouBangMa($maha);
            while ($row_anh = mysqli_fetch_assoc($result_dsar)) 
            {
                array_push(
                    $anhruou, 
                    [
                    "MaHA" => $row_anh["MaHA"],
                    "AnhRuou" => $row_anh["AnhRuou"],
                ]);
            }

            
            array_push(
                $response["ChiTietHoaDon"], 
                [
                "MaR" => $row["MaR"],
                "DS_AnhRuou" => $anhruou,
                "TenRuou" => $row["TenRuou"],
                "SoLuoong" => $row["SoLuoong"],
                "DonGia" => $row["DonGia"],
                "ThanhTien" => $row["ThanhTien"],
            ]);

            
        }
        
        echo json_encode($response);
    } else {
        echo json_encode(["message" => "Không tìm thấy hóa đơn với mã này."]);
    }
} else {
    echo json_encode(["message" => "Mã hóa đơn không hợp lệ."]);
}
?>
