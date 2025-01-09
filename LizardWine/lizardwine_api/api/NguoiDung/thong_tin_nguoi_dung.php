<?php
header("Content-Type: application/json");
require_once("../../config/db.php");
require_once("../../model/nguoi_dung.php");

$db = new Database();
$conn = $db->connect();
$nd = new NguoiDung($conn);

// Lấy tham số từ query string
$maND = isset($_GET['MaND']) ? intval($_GET['MaND']) : 0;

if ($maND > 0) {
    // Lấy thông tin rượu theo mã
    $result = $nd->layThongTinNguoiDungBangMa($maND);

    if ($result && $result->num_rows > 0) {
        $data = $result->fetch_assoc();
        
        $response = [
            "MaND" => $data["MaND"],
            "TenDangNhap" => $data["TenDangNhap"],
            "AnhDaiDien" => $data["AnhDaiDien"],
            "MatKhau" => $data["MatKhau"],
            "HoTen" => $data["HoTen"],
            "SoDienThoai" => $data["SoDienThoai"],
            "Email" => $data["Email"],
            "NgaySinh" => $data["NgaySinh"],
            "TrangThai" => $data["TrangThai"],
            "IsAdmin" => $data["IsAdmin"],
        ];
        echo json_encode($response);
    } else {
        echo json_encode(["message" => "Không tìm thấy người dùngdùng với mã này."]);
    }
} else {
    echo json_encode(["message" => "Mã người dùng không hợp lệ."]);
}
?>