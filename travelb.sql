-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 01, 2018 at 05:33 PM
-- Server version: 5.7.17-log
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `travelb`
--
CREATE DATABASE IF NOT EXISTS `travelb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `travelb`;

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `id` int(11) NOT NULL,
  `nohp` varchar(20) NOT NULL,
  `pass` varchar(30) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `alamat` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id`, `nohp`, `pass`, `nama`, `alamat`) VALUES
(1, '2147483647', 'fandytic', 'Muaro Sijunjung', ''),
(2, '2147483647', '123456', 'Bandung', ''),
(3, '05050', 'afafa', 'qwdaqw', ''),
(4, '1231231', 'asdasda', 'asdawd', ''),
(5, '08512512', 'basdas', 'muarp', ''),
(7, '1111', 'sfss', 'sfsf', 'sfasa'),
(8, '52441351351315135', 'cdhgdcfg', 'xxxc', 'vcvc'),
(9, '12121212', 'fafasda', 'fafafafafa', 'zxczxca');

-- --------------------------------------------------------

--
-- Table structure for table `pesanan`
--

CREATE TABLE `pesanan` (
  `id` int(11) NOT NULL,
  `nohp` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `jumlah` varchar(50) NOT NULL,
  `duduk` varchar(50) NOT NULL,
  `jam` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pesanan`
--

INSERT INTO `pesanan` (`id`, `nohp`, `nama`, `alamat`, `jumlah`, `duduk`, `jam`) VALUES
(1, 'Nama : 1111', 'alex', 'Jam 7 Pagi', '2', '', ''),
(2, '1111', 'ciko', 'com.fancik.travelb.Pesan@a0f2cef', '2', '', ''),
(3, '1111', 'ccas', 'Jam 5 Sore', '1', '', ''),
(4, '1111', 'vsdf', 'asd', '1', 'Tengah', 'Jam 5 Sore'),
(5, '1111', 'vfgsadf', 'asda', '1', 'Depan', 'Jam 12 Siang');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pesanan`
--
ALTER TABLE `pesanan`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `pesanan`
--
ALTER TABLE `pesanan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
