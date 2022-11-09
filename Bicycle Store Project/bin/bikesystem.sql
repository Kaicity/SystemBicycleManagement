-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 09, 2022 at 02:33 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bikesystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `hdid` varchar(20) NOT NULL,
  `bikeid` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `chitiettraxe`
--

CREATE TABLE `chitiettraxe` (
  `returnid` varchar(20) NOT NULL,
  `bikeid` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `cuahang`
--

CREATE TABLE `cuahang` (
  `storeid` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `address` varchar(200) NOT NULL,
  `fax` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cuahang`
--

INSERT INTO `cuahang` (`storeid`, `name`, `phone`, `address`, `fax`) VALUES
('store1', 'BikeQ1', '113', 'Q1', '113'),
('store2', 'BikeQ5', '115', 'hospital', '115');

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `hdid` varchar(20) NOT NULL,
  `cccd` varchar(20) NOT NULL,
  `date` date NOT NULL,
  `storeid` varchar(20) NOT NULL,
  `bikeid` varchar(20) NOT NULL,
  `ordercash` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `cccd` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `traxe`
--

CREATE TABLE `traxe` (
  `returnid` varchar(20) NOT NULL,
  `storeid` varchar(20) NOT NULL,
  `cccd` varchar(20) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `xedap`
--

CREATE TABLE `xedap` (
  `bikeid` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL,
  `storeid` varchar(20) NOT NULL,
  `priceh` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `xedap`
--

INSERT INTO `xedap` (`bikeid`, `name`, `type`, `status`, `storeid`, `priceh`) VALUES
('bike1', 'bikeTT', 'leo nui', 'chua', 'store1', 10),
('bike2', 'bikeTT', 'leo nui', 'chua', 'store1', 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD KEY `fk_bike_cthd` (`bikeid`),
  ADD KEY `fk_hd_cthd` (`hdid`);

--
-- Indexes for table `chitiettraxe`
--
ALTER TABLE `chitiettraxe`
  ADD KEY `fk_tra_chitiettra` (`returnid`),
  ADD KEY `fk_xe_chitiettra` (`bikeid`);

--
-- Indexes for table `cuahang`
--
ALTER TABLE `cuahang`
  ADD PRIMARY KEY (`storeid`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`hdid`),
  ADD KEY `fk_hoadon_khachhang` (`cccd`),
  ADD KEY `fk_hoadon_cuahang` (`storeid`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`cccd`);

--
-- Indexes for table `traxe`
--
ALTER TABLE `traxe`
  ADD PRIMARY KEY (`returnid`),
  ADD KEY `fk_khach_tra` (`cccd`),
  ADD KEY `fk_tra_cuahang` (`storeid`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `xedap`
--
ALTER TABLE `xedap`
  ADD PRIMARY KEY (`bikeid`),
  ADD KEY `fk_xe_cuahang` (`storeid`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD CONSTRAINT `fk_bike_cthd` FOREIGN KEY (`bikeid`) REFERENCES `xedap` (`bikeid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_hd_cthd` FOREIGN KEY (`hdid`) REFERENCES `hoadon` (`hdid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `chitiettraxe`
--
ALTER TABLE `chitiettraxe`
  ADD CONSTRAINT `fk_tra_chitiettra` FOREIGN KEY (`returnid`) REFERENCES `traxe` (`returnid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_xe_chitiettra` FOREIGN KEY (`bikeid`) REFERENCES `xedap` (`bikeid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `fk_hoadon_cuahang` FOREIGN KEY (`storeid`) REFERENCES `cuahang` (`storeid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_hoadon_khachhang` FOREIGN KEY (`cccd`) REFERENCES `khachhang` (`cccd`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `traxe`
--
ALTER TABLE `traxe`
  ADD CONSTRAINT `fk_khach_tra` FOREIGN KEY (`cccd`) REFERENCES `khachhang` (`cccd`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_tra_cuahang` FOREIGN KEY (`storeid`) REFERENCES `cuahang` (`storeid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `xedap`
--
ALTER TABLE `xedap`
  ADD CONSTRAINT `fk_xe_cuahang` FOREIGN KEY (`storeid`) REFERENCES `cuahang` (`storeid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
