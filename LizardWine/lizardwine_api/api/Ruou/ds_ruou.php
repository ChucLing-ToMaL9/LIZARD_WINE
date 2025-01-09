<?php
    header("Content-Type: application/json");
    require_once("../../config/db.php");
    require_once("../../model/ruou.php");
    $db = new Database();
    $conn = $db->connect();
    
    $ruou = new Ruou($conn);
    $result = $ruou->layDanhSachRuou();
    if (mysqli_num_rows($result) > 0) {
        $dsr = [];
        $dsr["ds_ruou"] = [];

        $currentMaR = null;
        $currentProduct = null;

        while ($row = mysqli_fetch_assoc($result)) {

            if ($row["MaR"] !== $currentMaR) {
                // Lưu sản phẩm hiện tại nếu đã có sản phẩm
                if ($currentProduct !== null) {
                    array_push($dsr["ds_ruou"], $currentProduct);
                }

                // Tạo sản phẩm mới
                $currentMaR = $row["MaR"];

                $currentProduct = array(
                    "MaR" => $row["MaR"],
                    "MaLoaiR" => $row["MaLoaiR"],
                    "TenLoaiRuou" => $row["TenLoaiRuou"],
                    "MaHA" => $row["MaHA"],
                    "AnhRuou" => [],
                    "TenRuou" => $row["TenRuou"],
                    "XuatXu" => $row["XuatXu"],
                    "NongDoCon" => $row["NongDoCon"],
                    "DungTich" => $row["DungTich"],
                    "NamSanXuat" => $row["NamSanXuat"],
                    "ThanhPhan" => $row["ThanhPhan"],
                    "HuongVi" => $row["HuongVi"],
                    "GiaBan" => $row["GiaBan"],
                    "SoLuongTon" => $row["SoLuongTon"],
                    "MoTa" => $row["MoTa"],
                    "TrangThai" => $row["TrangThai"],
                );
            }
          
            if (!empty($row["MaHA"])) {
                array_push(
                    $currentProduct["AnhRuou"], 
                    [
                    "MaHA" => $row["MaHA"],
                    "LinkAnh" => $row["AnhRuou"],
                ]);
            }
        }
        // Thêm sản phẩm cuối cùng vào danh sách
        if ($currentProduct !== null) {
            array_push($dsr["ds_ruou"], $currentProduct);
        }
        echo json_encode($dsr);
    } else {
        echo json_encode(["message" => "Không tìm thấy dữ liệu."]);
    }