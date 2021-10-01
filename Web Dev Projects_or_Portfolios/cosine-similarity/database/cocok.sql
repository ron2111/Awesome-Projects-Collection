-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 26, 2021 at 02:35 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cocok`
--

-- --------------------------------------------------------

--
-- Table structure for table `attribute`
--

CREATE TABLE `attribute` (
  `id` int(11) NOT NULL,
  `name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `attribute`
--

INSERT INTO `attribute` (`id`, `name`) VALUES
(1, 'hobi'),
(2, 'sifat'),
(3, 'makanan'),
(4, 'minuman'),
(5, 'genre film'),
(6, 'film'),
(7, 'musik');

-- --------------------------------------------------------

--
-- Table structure for table `human`
--

CREATE TABLE `human` (
  `id` int(11) NOT NULL,
  `name` varchar(150) NOT NULL,
  `jenis_kelamin` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `human`
--

INSERT INTO `human` (`id`, `name`, `jenis_kelamin`) VALUES
(1, 'A', 'pria'),
(2, 'B', 'wanita'),
(978, 'C', 'wanita');

-- --------------------------------------------------------

--
-- Table structure for table `score`
--

CREATE TABLE `score` (
  `id` int(11) NOT NULL,
  `human_id` int(11) NOT NULL,
  `sub_attribute_id` int(11) NOT NULL,
  `value` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `score`
--

INSERT INTO `score` (`id`, `human_id`, `sub_attribute_id`, `value`) VALUES
(1, 1, 1, 3),
(2, 1, 2, 1),
(3, 1, 3, 5),
(4, 1, 4, 2),
(5, 1, 5, 5),
(6, 1, 6, 5),
(7, 1, 7, 3),
(8, 1, 8, 1),
(9, 1, 9, 5),
(10, 1, 10, 5),
(11, 1, 11, 3),
(12, 1, 12, 1),
(13, 1, 13, 5),
(14, 1, 14, 3),
(15, 1, 15, 5),
(16, 1, 16, 2),
(17, 1, 17, 3),
(18, 1, 18, 3),
(19, 1, 19, 5),
(20, 1, 20, 1),
(21, 2, 1, 4),
(22, 2, 2, 1),
(23, 2, 3, 1),
(24, 2, 4, 1),
(25, 2, 5, 4),
(26, 2, 6, 1),
(27, 2, 7, 1),
(28, 2, 8, 1),
(29, 2, 9, 5),
(30, 2, 10, 1),
(31, 2, 11, 3),
(32, 2, 12, 2),
(33, 2, 13, 1),
(34, 2, 14, 1),
(35, 2, 15, 1),
(36, 2, 16, 1),
(37, 2, 17, 2),
(38, 2, 18, 3),
(39, 2, 19, 1),
(40, 2, 20, 1),
(101, 978, 1, 3),
(102, 978, 2, 3),
(103, 978, 3, 3),
(104, 978, 4, 4),
(105, 978, 5, 4),
(106, 978, 6, 5),
(107, 978, 7, 4),
(108, 978, 8, 2),
(109, 978, 9, 4),
(110, 978, 10, 3),
(111, 978, 11, 3),
(112, 978, 12, 5),
(113, 978, 13, 4),
(114, 978, 14, 2),
(115, 978, 15, 2),
(116, 978, 16, 4),
(117, 978, 17, 4),
(118, 978, 18, 4),
(119, 978, 19, 2),
(120, 978, 20, 4);

-- --------------------------------------------------------

--
-- Table structure for table `sub_attribute`
--

CREATE TABLE `sub_attribute` (
  `id` int(11) NOT NULL,
  `attribute_id` int(11) NOT NULL,
  `name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sub_attribute`
--

INSERT INTO `sub_attribute` (`id`, `attribute_id`, `name`) VALUES
(1, 1, 'membaca'),
(2, 1, 'menulis'),
(3, 1, 'ngegame'),
(4, 2, 'romantis'),
(5, 2, 'humoris'),
(6, 3, 'sate'),
(7, 3, 'martabak'),
(8, 4, 'kopi'),
(9, 4, 'teh'),
(10, 5, 'action'),
(11, 5, 'comedy'),
(12, 5, 'romance'),
(13, 6, 'hollywood'),
(14, 6, 'bollywood'),
(15, 6, 'anime'),
(16, 6, 'k-drama'),
(17, 7, 'inggris'),
(18, 7, 'indonesia'),
(19, 7, 'jepang'),
(20, 7, 'korea');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attribute`
--
ALTER TABLE `attribute`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `human`
--
ALTER TABLE `human`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `score`
--
ALTER TABLE `score`
  ADD PRIMARY KEY (`id`),
  ADD KEY `human` (`human_id`),
  ADD KEY `sub_attribute` (`sub_attribute_id`);

--
-- Indexes for table `sub_attribute`
--
ALTER TABLE `sub_attribute`
  ADD PRIMARY KEY (`id`),
  ADD KEY `attribute` (`attribute_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attribute`
--
ALTER TABLE `attribute`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `score`
--
ALTER TABLE `score`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=121;

--
-- AUTO_INCREMENT for table `sub_attribute`
--
ALTER TABLE `sub_attribute`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `score`
--
ALTER TABLE `score`
  ADD CONSTRAINT `sub_attribute` FOREIGN KEY (`sub_attribute_id`) REFERENCES `sub_attribute` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `sub_attribute`
--
ALTER TABLE `sub_attribute`
  ADD CONSTRAINT `attribute` FOREIGN KEY (`attribute_id`) REFERENCES `attribute` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
