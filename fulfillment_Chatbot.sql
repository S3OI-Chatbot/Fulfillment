-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 16, 2020 at 12:03 PM
-- Server version: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fulfillment`
--

-- --------------------------------------------------------

--
-- Table structure for table `film`
--

DROP TABLE IF EXISTS `film`;
CREATE TABLE IF NOT EXISTS `film` (
  `idFilm` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `age_limit` int(11) NOT NULL,
  `price` double NOT NULL,
  `realistic` tinyint(4) NOT NULL,
  `duration` time NOT NULL,
  `breaks` int(11) NOT NULL,
  PRIMARY KEY (`idFilm`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `film`
--

INSERT INTO `film` (`idFilm`, `name`, `age_limit`, `price`, `realistic`, `duration`, `breaks`) VALUES
(1, 'Star wars', 16, 15, 0, '02:22:00', 0),
(2, 'Joker', 15, 11, 0, '02:02:00', 0),
(3, 'Spiderman', 12, 4.99, 0, '02:05:00', 0),
(4, 'Frozen', 6, 11, 0, '01:43:00', 0),
(5, 'Batman', 16, 10.99, 0, '02:33:00', 0),
(6, 'Jumanji', 12, 8.5, 0, '02:03:00', 0),
(7, 'Zombieland', 16, 11, 0, '01:39:00', 0),
(8, 'Apollo', 3, 4.99, 1, '01:30:00', 1),
(9, 'Terminator', 12, 2.99, 0, '02:01:00', 0),
(10, 'Gemini', 12, 11, 0, '01:57:00', 0);

-- --------------------------------------------------------

--
-- Table structure for table `film_has_genre`
--

DROP TABLE IF EXISTS `film_has_genre`;
CREATE TABLE IF NOT EXISTS `film_has_genre` (
  `Film_idFilm` int(11) NOT NULL,
  `Genre_idGenre` int(11) NOT NULL,
  PRIMARY KEY (`Film_idFilm`,`Genre_idGenre`),
  KEY `fk_Film_has_Genre_Genre1_idx` (`Genre_idGenre`),
  KEY `fk_Film_has_Genre_Film_idx` (`Film_idFilm`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `film_has_genre`
--

INSERT INTO `film_has_genre` (`Film_idFilm`, `Genre_idGenre`) VALUES
(1, 1),
(3, 1),
(5, 1),
(6, 1),
(7, 1),
(9, 1),
(10, 1),
(1, 2),
(3, 2),
(4, 2),
(5, 2),
(6, 2),
(9, 2),
(1, 3),
(2, 4),
(10, 4),
(3, 5),
(5, 5),
(9, 5),
(10, 5),
(8, 6),
(8, 7),
(4, 8),
(4, 9),
(6, 9),
(7, 9),
(2, 10),
(2, 11),
(7, 12);

-- --------------------------------------------------------

--
-- Table structure for table `genre`
--

DROP TABLE IF EXISTS `genre`;
CREATE TABLE IF NOT EXISTS `genre` (
  `idGenre` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`idGenre`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `genre`
--

INSERT INTO `genre` (`idGenre`, `name`) VALUES
(1, 'Action'),
(2, 'Adventure'),
(8, 'Animation'),
(9, 'Comedy'),
(10, 'Crime'),
(6, 'Documentation'),
(4, 'Drama'),
(3, 'Fantasy'),
(7, 'History'),
(12, 'Horror'),
(5, 'Sci-Fi'),
(11, 'Thriller');

-- --------------------------------------------------------

--
-- Table structure for table `play_times`
--

DROP TABLE IF EXISTS `play_times`;
CREATE TABLE IF NOT EXISTS `play_times` (
  `idPlay_times` int(11) NOT NULL AUTO_INCREMENT,
  `idFilm` int(11) NOT NULL,
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`idPlay_times`,`idFilm`),
  KEY `fk_Play_times_Film1_idx` (`idFilm`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
CREATE TABLE IF NOT EXISTS `reviews` (
  `idReviews` int(11) NOT NULL AUTO_INCREMENT,
  `rating` double NOT NULL,
  `description` varchar(999) NOT NULL,
  `Film_idFilm` int(11) NOT NULL,
  PRIMARY KEY (`idReviews`,`Film_idFilm`),
  KEY `fk_Reviews_Film1_idx` (`Film_idFilm`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `view_type`
--

DROP TABLE IF EXISTS `view_type`;
CREATE TABLE IF NOT EXISTS `view_type` (
  `idView_type` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `Film_idFilm` int(11) NOT NULL,
  PRIMARY KEY (`idView_type`,`Film_idFilm`),
  KEY `fk_View_type_Film1_idx` (`Film_idFilm`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `film_has_genre`
--
ALTER TABLE `film_has_genre`
  ADD CONSTRAINT `fk_Film_has_Genre_Film` FOREIGN KEY (`Film_idFilm`) REFERENCES `film` (`idFilm`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Film_has_Genre_Genre1` FOREIGN KEY (`Genre_idGenre`) REFERENCES `genre` (`idGenre`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `play_times`
--
ALTER TABLE `play_times`
  ADD CONSTRAINT `fk_Play_times_Film1` FOREIGN KEY (`idFilm`) REFERENCES `film` (`idFilm`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `reviews`
--
ALTER TABLE `reviews`
  ADD CONSTRAINT `fk_Reviews_Film1` FOREIGN KEY (`Film_idFilm`) REFERENCES `film` (`idFilm`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `view_type`
--
ALTER TABLE `view_type`
  ADD CONSTRAINT `fk_View_type_Film1` FOREIGN KEY (`Film_idFilm`) REFERENCES `film` (`idFilm`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
