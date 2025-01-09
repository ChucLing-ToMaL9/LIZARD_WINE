<?php
    class NguoiDung {
        private $conn;
        

        public function __construct($conn)
        {
            $this->conn = $conn;
        }

        public function layThongTinNguoiDungBangMa($maND){
            $sql = " 
                SELECT * FROM nguoidung WHERE MaND = ?
                ";
            $stmt = $this->conn->prepare($sql);
            $stmt->bind_param("i", $maND); 
            $stmt->execute();
            $result = $stmt->get_result();
            return $result;
        }
    }