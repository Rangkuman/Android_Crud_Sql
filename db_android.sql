-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 16, 2018 at 07:39 PM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_android`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_barang`
--

CREATE TABLE `tb_barang` (
  `id` int(11) NOT NULL,
  `KodeBr` varchar(30) NOT NULL,
  `NamaBr` varchar(100) NOT NULL,
  `HargaSatuan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_barang`
--

INSERT INTO `tb_barang` (`id`, `KodeBr`, `NamaBr`, `HargaSatuan`) VALUES
(1, 'S001', 'Susu Enak', 'Rp 1500'),
(2, 'T001', 'Tepung Sgitiga', 'Rp 11500'),
(8, 'B001', 'Bumbu', '1000'),
(9, 'T002', 'Kunci Biru', '14000');

-- --------------------------------------------------------

--
-- Table structure for table `tb_kantor`
--

CREATE TABLE `tb_kantor` (
  `id` int(11) NOT NULL,
  `NamaK` varchar(50) NOT NULL,
  `AlamatK` varchar(100) NOT NULL,
  `Cabang` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_kantor`
--

INSERT INTO `tb_kantor` (`id`, `NamaK`, `AlamatK`, `Cabang`) VALUES
(2, 'Sembako jaya', 'jl.jakarta', 'cabang buahbatu'),
(3, 'Sembako NRG', 'Jl.NRG', 'cianjur'),
(4, 'Makur Selalu', 'Jl. Ramayana', 'Surakarta'),
(6, 'Sukses Jaya', 'Kp sariasih', 'Bandung');

-- --------------------------------------------------------

--
-- Table structure for table `tb_pegawai`
--

CREATE TABLE `tb_pegawai` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `posisi` varchar(100) NOT NULL,
  `gajih` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pegawai`
--

INSERT INTO `tb_pegawai` (`id`, `nama`, `posisi`, `gajih`) VALUES
(1, 'Edi sudirman', 'Manager', '7000000'),
(2, 'Cokro Edi Prawiro', 'PM', '4500000'),
(4, 'aip suprapto', 'haha', '1234567'),
(5, 'andri fajarsunandhar1', 'programming', '10'),
(6, 'imron sumadireja', 'PM', '2000000'),
(8, 'Ali Abdul Ghani', 'Ketua', 'â‚¬ 10,000'),
(9, 'Fathi rabbani', 'Admin', 'Â¥ 5,000,000'),
(10, 'Kaka madrid', 'Kapten', 'Â£ 500,000'),
(11, 'Siti Nur Aprilliani', 'Manager Akutansi', '$ 50000'),
(12, 'irvan', 'manager', '$ 5000'),
(13, 'Laily', 'Sekertaris', '$ 2000');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_barang`
--
ALTER TABLE `tb_barang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_kantor`
--
ALTER TABLE `tb_kantor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_pegawai`
--
ALTER TABLE `tb_pegawai`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_barang`
--
ALTER TABLE `tb_barang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `tb_kantor`
--
ALTER TABLE `tb_kantor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tb_pegawai`
--
ALTER TABLE `tb_pegawai`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
