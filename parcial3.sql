-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-06-2022 a las 04:12:55
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `parcial3`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autor`
--

CREATE TABLE `autor` (
  `id` int(3) NOT NULL,
  `name` varchar(120) COLLATE utf8_spanish_ci NOT NULL,
  `email` varchar(220) COLLATE utf8_spanish_ci NOT NULL,
  `country` varchar(120) COLLATE utf8_spanish_ci DEFAULT NULL,
  `libro` varchar(120) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `autor`
--

INSERT INTO `autor` (`id`, `name`, `email`, `country`, `libro`) VALUES
(1, 'Sebastian Sanabria', 'jhoan-sebas-03@hotmail.com', 'colombia', 'la maravillas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajador`
--

CREATE TABLE `trabajador` (
  `CODTRABAJADOR` int(11) NOT NULL,
  `NOMBRE` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `APELLIDO` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `EDAD` int(11) DEFAULT NULL,
  `DIRECCION` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `TELEFONO` char(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DNI` char(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `FECHA_NAC` date DEFAULT NULL,
  `USUARIO` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ClAVE` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `TIPO_USUARIO` varchar(120) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ESTADO` varchar(120) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `trabajador`
--

INSERT INTO `trabajador` (`CODTRABAJADOR`, `NOMBRE`, `APELLIDO`, `EDAD`, `DIRECCION`, `TELEFONO`, `DNI`, `FECHA_NAC`, `USUARIO`, `ClAVE`, `TIPO_USUARIO`, `ESTADO`) VALUES
(1, 'Manuel antonia', 'benitez gamarra', 25, 'no 35 cr 5', '2651561651', '5434534', '1993-06-10', 'manuel', '123', 'admin', 'activo');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `autor`
--
ALTER TABLE `autor`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `trabajador`
--
ALTER TABLE `trabajador`
  ADD PRIMARY KEY (`CODTRABAJADOR`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `autor`
--
ALTER TABLE `autor`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `trabajador`
--
ALTER TABLE `trabajador`
  MODIFY `CODTRABAJADOR` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
