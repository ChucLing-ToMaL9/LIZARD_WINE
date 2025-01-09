<?php

    class Ruou
    {
        private $conn;
        

        public function __construct($conn)
        {
            $this->conn = $conn;
        }

        public function layDanhSachRuou(){
            $sql = " 
                SELECT MaR, loairuou.MaLoaiR, loairuou.TenLoaiRuou, ds_anhruou.MaHA, ds_anhruou.AnhRuou, TenRuou, XuatXu, NongDoCon, DungTich, NamSanXuat, ThanhPhan, HuongVi, GiaBan, SoLuongTon, ruou.MoTa, ruou.TrangThai 
                FROM ruou
                INNER JOIN loairuou ON ruou.MaLoaiR = loairuou.MaLoaiR
                LEFT JOIN ds_anhruou ON ruou.MaHA = ds_anhruou.MaHA
                ORDER BY ruou.MaR
            ";
            $result = mysqli_query($this->conn, $sql);

            return $result;
        }

        public function layThongTinRuouBangMa($maruou){
            $sql = " 
                SELECT ruou.MaR, loairuou.MaLoaiR, loairuou.TenLoaiRuou, ds_anhruou.MaHA, ds_anhruou.AnhRuou, TenRuou, XuatXu, NongDoCon, DungTich, NamSanXuat, ThanhPhan, HuongVi, GiaBan, SoLuongTon, ruou.MoTa, ruou.TrangThai 
                FROM ruou
                INNER JOIN loairuou ON ruou.MaLoaiR = loairuou.MaLoaiR
                LEFT JOIN ds_anhruou ON ruou.MaHA = ds_anhruou.MaHA
                WHERE ruou.MaR = ?
                ORDER BY ruou.MaR
                ";
            $stmt = $this->conn->prepare($sql);
            $stmt->bind_param("i", $maruou); 
            $stmt->execute();
            $result = $stmt->get_result();
            return $result;
        }

        public function layDSAnhRuouBangMa($maruou){
            $sql = " 
                SELECT ar.MaHA, ar.AnhRuou
                FROM ruou r
                LEFT JOIN ds_anhruou ar ON r.MaR = ar.MaR
                WHERE r.MaR = ?
                ORDER BY r.MaR
                ";
            $stmt = $this->conn->prepare($sql);
            $stmt->bind_param("i", $maruou); 
            $stmt->execute();
            $result = $stmt->get_result();
            return $result;
        }
    }