<?php

    class LoaiRuou
    {
        private $conn;
        
        public $ma_loai_ruou;
        public $ten_loai_ruou;
        public $cap_ruou;
        public $ma_loai_cha;
        public $mo_ta;
        public $trang_thai;

        public function __construct($conn)
        {
            $this->conn = $conn;
        }

        public function layDanhSachLoaiRuou(){
            $sql = " SELECT * FROM loairuou";
            $result = mysqli_query($this->conn, $sql);

            return $result;
        }

    }