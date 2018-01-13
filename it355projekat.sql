-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 14, 2018 at 12:40 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `it355projekat`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL,
  `customer_address` varchar(255) NOT NULL,
  `customer_city` varchar(255) NOT NULL,
  `customer_email` varchar(255) NOT NULL,
  `customer_name` varchar(255) NOT NULL,
  `customer_phone` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customer_id`, `customer_address`, `customer_city`, `customer_email`, `customer_name`, `customer_phone`, `enabled`, `password`, `username`) VALUES
(1, 'adresa', 'Beograd', 'nekimail@gmail.com', 'darko stojanovic', '05623', b'1111111111111111111111111111111', 'darko', 'darko'),
(2, 'Adresa 2', 'Beograd', 'ddsadasd@gmail.com', 'sadsada', '45646446', b'1111111111111111111111111111111', 'sdasa', 'dsadas'),
(3, 'Mirijevo', 'beograd', 'mail@gmailcom', 'darko stojanovic', '45646446', b'1111111111111111111111111111111', 'student', 'student'),
(5, 'Mirijevo', 'beograd', 'mail@gmailcom', 'darko stojanovic', '45646446', b'1111111111111111111111111111111', 'student', 'student1');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `porudzbina_id` int(11) NOT NULL,
  `datum` datetime DEFAULT NULL,
  `naziv` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`porudzbina_id`, `datum`, `naziv`, `username`) VALUES
(3, '2018-01-14 00:34:45', 'New Order 01', 'student');

-- --------------------------------------------------------

--
-- Table structure for table `order_details`
--

CREATE TABLE `order_details` (
  `detalji_id` int(11) NOT NULL,
  `cena` double NOT NULL,
  `kolicina` int(11) NOT NULL,
  `porudzbina_id` int(11) NOT NULL,
  `proizvod_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_details`
--

INSERT INTO `order_details` (`detalji_id`, `cena`, `kolicina`, `porudzbina_id`, `proizvod_id`) VALUES
(4, 120002, 1, 3, 16);

-- --------------------------------------------------------

--
-- Table structure for table `permissions`
--

CREATE TABLE `permissions` (
  `permissions_id` int(11) NOT NULL,
  `permission_name` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `permissions`
--

INSERT INTO `permissions` (`permissions_id`, `permission_name`, `username`) VALUES
(1, 'ROLE_ADMIN', 'darko'),
(2, 'ROLE_USER', 'dsadas'),
(3, 'ROLE_USER', 'student'),
(4, 'ROLE_USER', 'student'),
(5, 'ROLE_USER', 'student1');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `proizvod_id` int(11) NOT NULL,
  `cena` double DEFAULT NULL,
  `dostupna_kolicina` int(11) DEFAULT NULL,
  `kategorija` varchar(255) DEFAULT NULL,
  `naziv_proizvoda` varchar(255) NOT NULL,
  `opis` varchar(255) DEFAULT NULL,
  `proizvodjac` varchar(255) DEFAULT NULL,
  `slika` varchar(255) DEFAULT NULL,
  `stanje` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`proizvod_id`, `cena`, `dostupna_kolicina`, `kategorija`, `naziv_proizvoda`, `opis`, `proizvodjac`, `slika`, `stanje`) VALUES
(16, 120002, 5, 'Mobilni telefon', 'IPhone X', 'Iphone najnovije generacije.', 'Apple', '/images/iphoneX.png', 'Dostupno'),
(17, 57000, 4, 'Mobilni telefon', 'OnePlus 5T', 'OnePlus telefon', 'OnePlus', '/images/onePlus5t.jpeg', 'Dostupno'),
(18, 78000, 2, 'Mobilni telefon', 'Galaxy Note 8', 'Samsung smartphone, najnovija gen.', 'Samsung', '/images/note8.png', 'Dostupno'),
(19, 1450, 40, 'Oprema', 'IPhone kabl', 'Lightning USB cable.', 'Apple', '/images/iphoneCable.jpg', 'Dostupno');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `users_id` int(11) NOT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`users_id`, `enabled`, `password`, `username`) VALUES
(1, b'1111111111111111111111111111111', 'darko', 'darko'),
(2, b'1111111111111111111111111111111', 'sdasa', 'dsadas'),
(3, b'1111111111111111111111111111111', 'student', 'student'),
(4, b'1111111111111111111111111111111', 'student', 'student'),
(5, b'1111111111111111111111111111111', 'student', 'student1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_id`),
  ADD UNIQUE KEY `uni_username_email` (`customer_email`,`username`),
  ADD KEY `fk_username_idx` (`username`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`porudzbina_id`),
  ADD KEY `FK_ord_cust` (`username`);

--
-- Indexes for table `order_details`
--
ALTER TABLE `order_details`
  ADD PRIMARY KEY (`detalji_id`),
  ADD KEY `proizvodId` (`proizvod_id`),
  ADD KEY `porudzbinaId` (`porudzbina_id`);

--
-- Indexes for table `permissions`
--
ALTER TABLE `permissions`
  ADD PRIMARY KEY (`permissions_id`),
  ADD KEY `fk_username` (`username`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`proizvod_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`users_id`),
  ADD KEY `Index key2` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `porudzbina_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `order_details`
--
ALTER TABLE `order_details`
  MODIFY `detalji_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `permissions`
--
ALTER TABLE `permissions`
  MODIFY `permissions_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `proizvod_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `users_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `FK_customer_username_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FK_ord_cust` FOREIGN KEY (`username`) REFERENCES `customer` (`username`);

--
-- Constraints for table `order_details`
--
ALTER TABLE `order_details`
  ADD CONSTRAINT `FK_ordersdetails_orders` FOREIGN KEY (`porudzbina_id`) REFERENCES `orders` (`porudzbina_id`),
  ADD CONSTRAINT `FK_ordersdetails_product` FOREIGN KEY (`proizvod_id`) REFERENCES `product` (`proizvod_id`);

--
-- Constraints for table `permissions`
--
ALTER TABLE `permissions`
  ADD CONSTRAINT `fk_username` FOREIGN KEY (`username`) REFERENCES `users` (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
