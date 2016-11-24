-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 24, 2016 at 12:01 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hetfruithuisje`
--

-- --------------------------------------------------------

--
-- Table structure for table `klant`
--

CREATE TABLE `klant` (
  `klantnr` int(11) NOT NULL,
  `email` varchar(33) DEFAULT NULL,
  `pass` varchar(33) DEFAULT NULL,
  `naam` varchar(33) NOT NULL,
  `woonplaats` varchar(33) NOT NULL,
  `straat` varchar(33) NOT NULL,
  `huisnummer` varchar(11) NOT NULL,
  `postcode` varchar(33) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `klant_order`
--

CREATE TABLE `klant_order` (
  `ordernr` int(33) NOT NULL,
  `klantnr` int(33) NOT NULL,
  `datum_betaling` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `btw_percentage` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `klant_order_factuur`
--

CREATE TABLE `klant_order_factuur` (
  `factuurnr` int(33) NOT NULL,
  `ordernr` int(33) NOT NULL,
  `datum` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `klant_order_item`
--

CREATE TABLE `klant_order_item` (
  `productnr` int(33) NOT NULL,
  `ordernr` int(33) NOT NULL,
  `aantal` int(33) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `productnr` int(11) NOT NULL,
  `product_soort` int(11) NOT NULL,
  `product_naam` varchar(33) NOT NULL,
  `prijs` float NOT NULL,
  `hoeveelheid` int(33) NOT NULL,
  `eenheid` varchar(33) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `product_soort`
--

CREATE TABLE `product_soort` (
  `product_soort_id` int(11) NOT NULL,
  `soortnaam` varchar(33) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `role`) VALUES
(1, 'admin', 'test123', 'Admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `klant`
--
ALTER TABLE `klant`
  ADD PRIMARY KEY (`klantnr`);

--
-- Indexes for table `klant_order`
--
ALTER TABLE `klant_order`
  ADD PRIMARY KEY (`ordernr`);

--
-- Indexes for table `klant_order_factuur`
--
ALTER TABLE `klant_order_factuur`
  ADD PRIMARY KEY (`factuurnr`);

--
-- Indexes for table `klant_order_item`
--
ALTER TABLE `klant_order_item`
  ADD PRIMARY KEY (`productnr`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`productnr`);

--
-- Indexes for table `product_soort`
--
ALTER TABLE `product_soort`
  ADD PRIMARY KEY (`product_soort_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `klant`
--
ALTER TABLE `klant`
  MODIFY `klantnr` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `klant_order`
--
ALTER TABLE `klant_order`
  MODIFY `ordernr` int(33) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `klant_order_factuur`
--
ALTER TABLE `klant_order_factuur`
  MODIFY `factuurnr` int(33) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `klant_order_item`
--
ALTER TABLE `klant_order_item`
  MODIFY `productnr` int(33) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `productnr` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `product_soort`
--
ALTER TABLE `product_soort`
  MODIFY `product_soort_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
