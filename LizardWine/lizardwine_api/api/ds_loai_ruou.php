
<?php
    header("Content-Type: application/json");
    require_once("../config/db.php");
    require_once("../model/loai_ruou.php");
    $db = new Database();
    $conn = $db->connect();
    
    $loairuou = new LoaiRuou($conn);
    $result = $loairuou->layDanhSachLoaiRuou();
    if (mysqli_num_rows($result) > 0) {
        $dslr = [];
        $dslr["ds_loai_ruou"] = [];
        while ($row = mysqli_fetch_assoc($result)) {
            $lr = array(
                "MaLoaiR" => $row["MaLoaiR"],
                "TenLoaiRuou" => $row["TenLoaiRuou"],
                "CapRuou" => $row["CapRuou"],
                "MaLoaiCha" => $row["MaLoaiCha"],
                "MoTa" => $row["MoTa"],
                "TrangThai" => $row["TrangThai"],
            );
            array_push($dslr["ds_loai_ruou"], $lr);
        }
        echo json_encode($dslr);
    }