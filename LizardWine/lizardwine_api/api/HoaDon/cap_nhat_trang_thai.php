<?php
header("Content-Type: application/json");
require_once("../../config/db.php");
require_once("../../model/hoa_don.php");

$db = new Database();
$conn = $db->connect();

$hoa_don = new HoaDon($conn);

$data = json_decode(file_get_contents("php://input"));

// Kiểm tra dữ liệu đầu vào
if (!isset($data->maHD) || !is_numeric($data->maHD)) {
    echo json_encode(array("message" => "Dữ liệu không hợp lệ"));
    http_response_code(400);
    exit();
}

print_r($data);
$hoa_don->maHD = $data->maHD;

$result = $hoa_don->capNhatTrangThaiHoaDon();
if ($result == true) {
    echo json_encode(array("message", "Cập nhật trạng thái đơn hàng tthành công"));
} else {
    echo json_encode(array("message", "Cập nhật trạng thái đơn hàng thất bại"));
}
