<?php
header("Content-Type: application/json");
require_once("../../config/db.php");
require_once("../../model/hoa_don.php");

require_once("../../model/ruou.php");

$db = new Database();
$conn = $db->connect();

$ruou = new Ruou($conn);
$hoa_don = new HoaDon($conn);

// Lấy tham số từ query string
$maTT = isset($_GET['MaTrangThai']) ? intval($_GET['MaTrangThai']) : 0;

if ($maTT > 0) {
    // Lấy thông tin rượu theo mã
    $result = $hoa_don->layThongTinHoaDonTheoTTHD($maTT);

    if (mysqli_num_rows($result) > 0) {
        $dshd = [];
        $mahd = null;

        $response = null;

        while ($data = mysqli_fetch_assoc($result)) {

            
                $response = [
                    "MaHD" => $data["MaHD"],
                    "ChiTietHoaDon" => [],
                    "LoaitrangThai" => $data["LoaitrangThai"],
                    "NgayLapHD" => $data["NgayLapHD"],
                    "TongThanhToan" => $data["TongThanhToan"],
                ];
                $mahd = $data["MaHD"];
            
            $result_cthd= $hoa_don->layCTHDtheoMaHD($mahd);
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


            if ($response !== null) {
                array_push( $dshd, $response);
            }
            
        }//loi

        echo json_encode($dshd);
        
        
    } else {
        echo json_encode(["message" => "Không tìm thấy hóa đơn với mã này."]);
    }
} else {
    echo json_encode(["message" => "Mã người dùngdùng không hợp lệ."]);
}
?>
