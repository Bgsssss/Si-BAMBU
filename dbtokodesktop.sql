-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.30 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for dbtokodesktop
DROP DATABASE IF EXISTS `dbtokodesktop`;
CREATE DATABASE IF NOT EXISTS `dbtokodesktop` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `dbtokodesktop`;

-- Dumping structure for table dbtokodesktop.barang
DROP TABLE IF EXISTS `barang`;
CREATE TABLE IF NOT EXISTS `barang` (
  `idBarang` int NOT NULL AUTO_INCREMENT,
  `namaBarang` varchar(50) DEFAULT NULL,
  `kategori` varchar(50) DEFAULT NULL,
  `modal` varchar(100) DEFAULT NULL,
  `hargaJual` varchar(100) DEFAULT NULL,
  `stok` int DEFAULT NULL,
  `idPemasok` int DEFAULT NULL,
  PRIMARY KEY (`idBarang`),
  KEY `fk_barang_pemasok` (`idPemasok`),
  CONSTRAINT `fk_barang_pemasok` FOREIGN KEY (`idPemasok`) REFERENCES `pemasok` (`idPemasok`)
) ENGINE=InnoDB AUTO_INCREMENT=248 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table dbtokodesktop.barang: ~41 rows (approximately)
INSERT INTO `barang` (`idBarang`, `namaBarang`, `kategori`, `modal`, `hargaJual`, `stok`, `idPemasok`) VALUES
	(204, 'Lada hitam halus', 'Halus', '55000', '70000', 70, 2),
	(205, 'Lada putih halus', 'Halus', '58000', '75000', 39, 3),
	(206, 'Ketumbar halus', 'Halus', '25000', '35000', 66, 4),
	(207, 'Jintan putih halus', 'Halus', '30000', '40000', 28, 5),
	(208, 'Jintan hitam halus', 'Halus', '35000', '48000', 90, 6),
	(209, 'Pala halus', 'Halus', '60000', '75000', 35, 2),
	(210, 'Kayu manis halus', 'Halus', '38000', '50000', 57, 3),
	(211, 'Cengkeh halus', 'Halus', '78000', '98000', 22, 4),
	(212, 'Kapulaga halus', 'Halus', '68000', '88000', 49, 5),
	(213, 'Bunga lawang halus', 'Halus', '52000', '68000', 61, 6),
	(214, 'Adas manis halus', 'Halus', '30000', '40000', 77, 2),
	(215, 'Wijen halus', 'Halus', '27000', '37000', 17, 3),
	(216, 'Mustard halus', 'Halus', '32000', '42000', 84, 4),
	(217, 'Paprika halus', 'Halus', '35000', '48000', 25, 5),
	(218, 'Cabai halus', 'Halus', '48000', '60000', 53, 6),
	(219, 'Bawang putih bubuk', 'Halus', '38000', '50000', 39, 2),
	(220, 'Jahe halus', 'Halus', '24000', '32000', 70, 3),
	(221, 'Kunyit halus', 'Halus', '20000', '28000', 92, 4),
	(222, 'Lengkuas halus', 'Halus', '22000', '30000', 31, 5),
	(223, 'Serai halus', 'Halus', '18000', '25000', 65, 6),
	(224, 'Lada hitam biji', 'Bulat', '48000', '60000', 69, 2),
	(225, 'Lada putih biji', 'Bulat', '52000', '68000', 27, 3),
	(226, 'Ketumbar biji', 'Bulat', '22000', '30000', 74, 4),
	(227, 'Jintan putih biji', 'Bulat', '28000', '38000', 33, 5),
	(228, 'Jintan hitam biji', 'Bulat', '32000', '45000', 88, 6),
	(229, 'Pala biji', 'Bulat', '65000', '80000', 21, 2),
	(230, 'Kayu manis batang', 'Bulat', '35000', '45000', 55, 3),
	(231, 'Cengkeh utuh', 'Bulat', '75000', '95000', 47, 4),
	(232, 'Kapulaga utuh', 'Bulat', '65000', '85000', 62, 5),
	(233, 'Bunga lawang utuh', 'Bulat', '50000', '65000', 30, 6),
	(234, 'Adas manis biji', 'Bulat', '28000', '38000', 79, 2),
	(235, 'Wijen biji', 'Bulat', '25000', '35000', 16, 3),
	(236, 'Mustard biji', 'Bulat', '30000', '40000', 83, 4),
	(237, 'Paprika kering', 'Bulat', '30000', '42000', 24, 5),
	(238, 'Cabai kering utuh', 'Bulat', '42000', '55000', 51, 6),
	(239, 'Bawang putih kering', 'Bulat', '35000', '45000', 37, 2),
	(240, 'Jahe kering', 'Bulat', '22000', '30000', 68, 3),
	(241, 'Kunyit kering', 'Bulat', '18000', '25000', 94, 4),
	(242, 'Lengkuas kering', 'Bulat', '20000', '28000', 29, 5),
	(243, 'Serai kering', 'Bulat', '15000', '22000', 60, 6);

-- Dumping structure for table dbtokodesktop.pemasok
DROP TABLE IF EXISTS `pemasok`;
CREATE TABLE IF NOT EXISTS `pemasok` (
  `idPemasok` int NOT NULL AUTO_INCREMENT,
  `namaPemasok` varchar(50) DEFAULT NULL,
  `alamat` varchar(50) DEFAULT NULL,
  `kontak` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idPemasok`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table dbtokodesktop.pemasok: ~5 rows (approximately)
INSERT INTO `pemasok` (`idPemasok`, `namaPemasok`, `alamat`, `kontak`) VALUES
	(2, 'Budi Santoso', 'Jakarta Selatan', '081234567890'),
	(3, 'Siti Aminah', 'Bandung', '082345678901'),
	(4, 'Agus Setiawan', 'Surabaya', '083456789012'),
	(5, 'Dewi Lestari', 'Yogyakarta', '084567890123'),
	(6, 'Rudi Hartono', 'Semarang', '085678901234');

-- Dumping structure for table dbtokodesktop.transaksi
DROP TABLE IF EXISTS `transaksi`;
CREATE TABLE IF NOT EXISTS `transaksi` (
  `idTransaksi` int NOT NULL AUTO_INCREMENT,
  `namaPembeli` varchar(100) DEFAULT NULL,
  `jmlBarang` varchar(100) DEFAULT NULL,
  `total` varchar(100) DEFAULT NULL,
  `tglTransaksi` date DEFAULT NULL,
  PRIMARY KEY (`idTransaksi`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table dbtokodesktop.transaksi: ~9 rows (approximately)
INSERT INTO `transaksi` (`idTransaksi`, `namaPembeli`, `jmlBarang`, `total`, `tglTransaksi`) VALUES
	(9, 'nana', '1', '10000.0', '2026-04-19'),
	(10, 'ario', '1', '10000.0', '2026-04-19'),
	(11, 'Paw', '1', '10000.0', '2026-04-19'),
	(12, 'Naufal', '1', '10000.0', '2026-04-19'),
	(13, 'hagas', '2', '40000.0', '2026-04-19'),
	(14, 'teguh', '2', '60000.0', '2026-04-24'),
	(15, 'agus', '2', '40000.0', '2026-04-25'),
	(16, 'Farhan', '4', '252000.0', '2026-04-27'),
	(17, 'Yanto', '3', '120000.0', '2026-04-27'),
	(18, 'hari', '2', '60000.0', '2026-04-28'),
	(19, 'faa', '1', '75000.0', '2026-04-29'),
	(20, 'Bagas', '1', '70000.0', '2026-04-29'),
	(21, 'jaya', '2', '150000.0', '2026-05-02'),
	(22, 'raya', '1', '70000.0', '2026-05-02'),
	(23, 'Ben', '2', '85000.0', '2026-05-02'),
	(24, 'heru', '1', '70000.0', '2026-05-02');

-- Dumping structure for table dbtokodesktop.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `idUser` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `level` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table dbtokodesktop.user: ~2 rows (approximately)
INSERT INTO `user` (`idUser`, `username`, `password`, `level`) VALUES
	(1, 'kasir', '12345', 'Kasir'),
	(2, 'admin', 'admin123', 'Admin'),
	(3, 'admin2', 'admin2', 'Admin'),
	(4, 'kasir2', '12345', 'Kasir');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
