-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-12-2021 a las 13:47:19
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `motos`
--
CREATE DATABASE IF NOT EXISTS `motos` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `motos`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `motos`
--

CREATE TABLE `motos` (
  `id` int(11) NOT NULL,
  `marca` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `modelo` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `cilindrada` int(11) NOT NULL,
  `foto` varchar(200) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `motos`
--

INSERT INTO `motos` (`id`, `marca`, `modelo`, `cilindrada`, `foto`) VALUES
(1, 'Honda', 'Civic', 125, ''),
(2, 'Honda', 'Tucson', 250, ''),
(3, 'Aprilia', 'Tucson', 250, ''),
(4, 'Electrica', 'Tucson', 250, ''),
(5, 'Honda2', 'Tucson', 2500, ''),
(6, 'Honda', 'Ninja', 500, 'foto');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int(11) NOT NULL,
  `marca` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `modelo` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `cilindrada` int(11) NOT NULL,
  `foto` varchar(250) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `marca`, `modelo`, `cilindrada`, `foto`) VALUES
(1, 'Honda', 'Civic', 125, ''),
(2, 'Honda', 'Tucson', 250, ''),
(3, 'Aprilia', 'Tucson', 250, ''),
(4, 'Electrica', 'Tucson', 250, ''),
(5, 'Honda2', 'Tucson', 250, '');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `motos`
--
ALTER TABLE `motos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `motos`
--
ALTER TABLE `motos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
