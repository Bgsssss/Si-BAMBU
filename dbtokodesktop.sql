-- phpMyAdmin SQL Dump
-- version 5.2.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jul 01, 2026 at 12:02 PM
-- Server version: 8.0.30
-- PHP Version: 8.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbtokodesktop`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `idBarang` int NOT NULL,
  `namaBarang` varchar(50) DEFAULT NULL,
  `kategori` varchar(50) DEFAULT NULL,
  `modal` varchar(100) DEFAULT NULL,
  `hargaJual` varchar(100) DEFAULT NULL,
  `stok` int DEFAULT NULL,
  `idPemasok` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`idBarang`, `namaBarang`, `kategori`, `modal`, `hargaJual`, `stok`, `idPemasok`) VALUES
(204, 'Lada hitam halus', 'Halus', '55000', '70000', 63, 2),
(205, 'Lada putih halus', 'Halus', '58000', '75000', 39, 3),
(206, 'Ketumbar halus', 'Halus', '25000', '35000', 66, 4),
(207, 'Jintan putih halus', 'Halus', '30000', '40000', 28, 5),
(208, 'Jintan hitam halus', 'Halus', '35000', '48000', 90, 6),
(209, 'Pala halus', 'Halus', '60000', '75000', 35, 2),
(210, 'Kayu manis halus', 'Halus', '38000', '50000', 57, 3),
(211, 'Cengkeh halus', 'Halus', '78000', '98000', 20, 4),
(212, 'Kapulaga halus', 'Halus', '68000', '88000', 48, 5),
(213, 'Bunga lawang halus', 'Halus', '52000', '68000', 58, 6),
(214, 'Adas manis halus', 'Halus', '30000', '40000', 76, 2),
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
(242, 'Lengkuas kering', 'Bulat', '20000', '28000', 28, 5),
(243, 'Serai kering', 'Bulat', '15000', '22000', 59, 6);

-- --------------------------------------------------------

--
-- Table structure for table `pemasok`
--

CREATE TABLE `pemasok` (
  `idPemasok` int NOT NULL,
  `namaPemasok` varchar(50) DEFAULT NULL,
  `alamat` varchar(50) DEFAULT NULL,
  `kontak` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `pemasok`
--

INSERT INTO `pemasok` (`idPemasok`, `namaPemasok`, `alamat`, `kontak`) VALUES
(2, 'Budi ', 'Jakarta Timur', '081234567890'),
(3, 'Siti Aminah', 'Bandung', '082345678901'),
(4, 'Agus Setiawan', 'Surabaya', '083456789012'),
(5, 'Dewi Lestari', 'Yogyakarta', '084567890123'),
(6, 'Rudi Hartono', 'Semarang', '085678901234');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `idTransaksi` int NOT NULL,
  `namaPembeli` varchar(100) DEFAULT NULL,
  `jmlBarang` varchar(100) DEFAULT NULL,
  `total` varchar(100) DEFAULT NULL,
  `tglTransaksi` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `transaksi`
--

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
(24, 'heru', '1', '70000.0', '2026-05-02'),
(30, 'dery', '1', '28000.0', '2026-06-26'),
(31, 'test', '2', '140000.0', '2026-06-26');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `idUser` int NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `level` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`idUser`, `username`, `password`, `level`) VALUES
(5, 'superadmin', 'super123', 'Super Admin'),
(6, 'admin', 'admin123', 'Kasir'),
(7, 'kasir', 'kasir123', 'Kasir');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`idBarang`),
  ADD KEY `fk_barang_pemasok` (`idPemasok`);

--
-- Indexes for table `pemasok`
--
ALTER TABLE `pemasok`
  ADD PRIMARY KEY (`idPemasok`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`idTransaksi`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `barang`
--
ALTER TABLE `barang`
  MODIFY `idBarang` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=253;

--
-- AUTO_INCREMENT for table `pemasok`
--
ALTER TABLE `pemasok`
  MODIFY `idPemasok` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `idTransaksi` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `fk_barang_pemasok` FOREIGN KEY (`idPemasok`) REFERENCES `pemasok` (`idPemasok`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
