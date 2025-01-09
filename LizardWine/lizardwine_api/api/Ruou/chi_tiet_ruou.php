<?php
header("Content-Type: application/json");
require_once("../../config/db.php");
require_once("../../model/ruou.php");

$db = new Database();
$conn = $db->connect();
$ruou = new Ruou($conn);

// Lấy tham số từ query string
$maR = isset($_GET['MaR']) ? intval($_GET['MaR']) : 0;

if ($maR > 0) {
    // Lấy thông tin rượu theo mã
    $result = $ruou->layThongTinRuouBangMa($maR);

    if ($result && $result->num_rows > 0) {
        $data = $result->fetch_assoc();
        
        $response = [
            "MaR" => $data["MaR"],
            "MaLoaiR" => $data["MaLoaiR"],
            "TenLoaiRuou" => $data["TenLoaiRuou"],
            "MaHA" => $data["MaHA"],
            "AnhRuou" => [],
            "TenRuou" => $data["TenRuou"],
            "XuatXu" => $data["XuatXu"],
            "NongDoCon" => $data["NongDoCon"],
            "DungTich" => $data["DungTich"],
            "NamSanXuat" => $data["NamSanXuat"],
            "ThanhPhan" => $data["ThanhPhan"],
            "HuongVi" => $data["HuongVi"],
            "GiaBan" => $data["GiaBan"],
            "SoLuongTon" => $data["SoLuongTon"],
            "MoTa" => $data["MoTa"],
            "TrangThai" => $data["TrangThai"],
        ];

        if (!empty($data["AnhRuou"])) {
            array_push(
                $response["AnhRuou"], 
                [
                "MaHA" => $data["MaHA"],
                "LinkAnh" => $data["AnhRuou"],
            ]);
        }
        
        echo json_encode($response);
    } else {
        echo json_encode(["message" => "Không tìm thấy sản phẩm rượu với mã này."]);
    }
} else {
    echo json_encode(["message" => "Mã sản phẩm không hợp lệ."]);
}
?>
