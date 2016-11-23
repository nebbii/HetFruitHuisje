-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Host: localhost:8889
-- Gegenereerd op: 24 nov 2016 om 00:21
-- Serverversie: 5.5.42
-- PHP-versie: 7.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `hetfruithuisje`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `klant`
--

CREATE TABLE `klant` (
  `naam` varchar(33) NOT NULL,
  `woonplaats` varchar(33) NOT NULL,
  `straat` varchar(33) NOT NULL,
  `huisnummer` varchar(11) NOT NULL,
  `postcode` varchar(33) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `klant_order`
--

CREATE TABLE `klant_order` (
  `ordernr` int(33) NOT NULL,
  `klantnr` int(33) NOT NULL,
  `datum_betaling` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `btw_percentage` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `klant_order_factuur`
--

CREATE TABLE `klant_order_factuur` (
  `factuurnr` int(33) NOT NULL,
  `ordernr` int(33) NOT NULL,
  `datum` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `klant_order_item`
--

CREATE TABLE `klant_order_item` (
  `productnr` int(33) NOT NULL,
  `ordernr` int(33) NOT NULL,
  `aantal` int(33) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `product`
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
-- Tabelstructuur voor tabel `product_soort`
--

CREATE TABLE `product_soort` (
  `product_soort_id` int(11) NOT NULL,
  `soortnaam` varchar(33) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(10) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `Users`
--

INSERT INTO `users` (`id`, `username`, `password`, `role`) VALUES
(1, 'admin', 'test123', 'Admin');

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `klant_order`
--
ALTER TABLE `klant_order`
  ADD PRIMARY KEY (`ordernr`);

--
-- Indexen voor tabel `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`productnr`);

--
-- Indexen voor tabel `Users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `Users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;