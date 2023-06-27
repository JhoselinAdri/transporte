-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-06-2023 a las 08:25:18
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_trasporte`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `accidentes`
--

CREATE TABLE `accidentes` (
  `ci` int(10) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `app` varchar(50) DEFAULT NULL,
  `apm` varchar(50) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `direccion` varchar(60) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `estado` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `accidentes`
--

INSERT INTO `accidentes` (`ci`, `nombre`, `app`, `apm`, `telefono`, `direccion`, `username`, `password`, `estado`) VALUES
(1, 'Llenado vacio', 'null', 'null', 'null', 'null', 'vacio', 'null', 'inactivo'),
(8842536, 'Joel', 'Chura', 'Vilca', '75432560', 'Z/Villa adela', 'Joel_8842536', '*C3E772A35B844AFCFB1D01F9CFDFC4C534E3C4E9', 'activo'),
(87654321, 'Jhoselin Adriana', 'Choque', 'Mamani', '76543211', 'Viacha', 'Jhoselin_87654321', '*5D24C4D94238E65A6407DFAB95AA4EA97CA2B199', 'activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `admin`
--

CREATE TABLE `admin` (
  `ci` int(11) NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `app` varchar(30) DEFAULT NULL,
  `celular` varchar(10) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `apm` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `admin`
--

INSERT INTO `admin` (`ci`, `nombre`, `app`, `celular`, `username`, `password`, `direccion`, `apm`) VALUES
(10013618, 'Juan Aberto', 'Silva', '63215576', 'Juan_10013618', '*60256ABAC48216F14690C332B50742DE8F0D8D32', 'juan pablo II', 'Cayo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aportes`
--

CREATE TABLE `aportes` (
  `n_aporte` int(11) NOT NULL,
  `monto` double(7,2) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `ci_chofer` int(11) DEFAULT NULL,
  `ci_aportes` int(11) DEFAULT NULL,
  `concepto` text DEFAULT NULL,
  `sector` varchar(30) DEFAULT NULL,
  `grupo` varchar(15) DEFAULT NULL,
  `placa` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `aportes`
--

INSERT INTO `aportes` (`n_aporte`, `monto`, `fecha`, `ci_chofer`, `ci_aportes`, `concepto`, `sector`, `grupo`, `placa`) VALUES
(1, 70.00, '2023-06-10', 10013618, 9965845, 'Pago mensual para el grupo', 'Masivo', '3', '1018-RAD'),
(2, 50.00, '2023-06-11', 9965820, 9965845, 'Pago Mensual', 'Masivo', '3', '5542-SDV'),
(5, 60.00, '2023-06-11', 9965820, 9965845, 'Pago Mensual', 'Masivo', '3', '5542-SDV'),
(17, 100.00, '2023-06-25', 10013618, 9965845, 'Pago Mensual', 'Masivo', '3', '1018-RAD');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aviso`
--

CREATE TABLE `aviso` (
  `n_aviso` int(11) NOT NULL,
  `tipo` int(11) DEFAULT NULL,
  `descipcion` text CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ci_emisor` int(30) DEFAULT NULL,
  `nombre` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `datos` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `detino` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `estado` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `aviso`
--

INSERT INTO `aviso` (`n_aviso`, `tipo`, `descipcion`, `ci_emisor`, `nombre`, `datos`, `detino`, `estado`) VALUES
(28, 2, 'Aviso', 10013618, 'WhatsApp Image 2023-06-19 at 17.54.24.jpeg', 'C:\\Users\\juans\\OneDrive\\Documentos\\NetBeansProjects\\transporte\\src\\main\\webapp\\comunicados\\WhatsApp Image 2023-06-19 at 17.54.24.jpeg', 'todos', 'inactivo'),
(29, 1, 'Comunicado', 10013618, 'WhatsApp Image 2023-06-15 at 17.16.07.jpeg', 'C:\\Users\\juans\\OneDrive\\Documentos\\NetBeansProjects\\transporte\\src\\main\\webapp\\comunicados\\WhatsApp Image 2023-06-15 at 17.16.07.jpeg', 'chofer', 'inactivo'),
(30, 2, 'Invitacion anual', 10013618, 'WhatsApp Image 2023-06-19 at 17.54.24.jpeg', 'C:\\Users\\juans\\OneDrive\\Documentos\\NetBeansProjects\\transporte\\src\\main\\webapp\\comunicados\\WhatsApp Image 2023-06-19 at 17.54.24.jpeg', 'todos', 'activo'),
(31, 1, 'Aviso importante', 10013618, 'WhatsApp Image 2023-06-20 at 09.55.12.jpeg', 'C:\\Users\\juans\\OneDrive\\Documentos\\NetBeansProjects\\transporte\\src\\main\\webapp\\comunicados\\WhatsApp Image 2023-06-20 at 09.55.12.jpeg', 'todos', 'activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `chofer`
--

CREATE TABLE `chofer` (
  `ci` int(11) NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `app` varchar(30) DEFAULT NULL,
  `apm` varchar(30) DEFAULT NULL,
  `n_celular` varchar(15) DEFAULT NULL,
  `licencia_id` int(11) DEFAULT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `estado` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `chofer`
--

INSERT INTO `chofer` (`ci`, `nombre`, `app`, `apm`, `n_celular`, `licencia_id`, `username`, `password`, `estado`) VALUES
(9542663, 'Percy', 'Mita', 'Catari', '65425503', 9542663, 'Percy_9542663', '*03809384C6DC0BBBDF48EBE7A06B2B92395FFD55', 'inactivo'),
(9965820, 'Roberto Carlos', 'Quispe', 'Usnayo', '71228732', 9965820, 'Roberto_9965820', '*B954862352C69FF47D617DB096C86B1F9C4EFF2F', 'activo'),
(10013618, 'Juan Aberto', 'Silva', 'Cayo', '63215576', 10013618, 'Juan_10013618', '*60256ABAC48216F14690C332B50742DE8F0D8D32', 'activo'),
(12345678, 'Jhoselin Adriana', 'Choque', 'Mamani', '76543210', 12345678, 'Jhoselin_12345678', '*84AAC12F54AB666ECFC2A83C676908C8BBC381B1', 'activo');

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `contar_llegada`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `contar_llegada` (
`llegada` int(2)
,`salida` int(2)
,`total_registros` bigint(21)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `contar_salida`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `contar_salida` (
`llegada` int(2)
,`salida` int(2)
,`total_registros` bigint(21)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `control_accidentes`
--

CREATE TABLE `control_accidentes` (
  `n_accidente` int(11) NOT NULL,
  `placa` varchar(15) DEFAULT NULL,
  `ci_chofer` int(11) DEFAULT NULL,
  `observaciones` text DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `ci_reg` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `control_accidentes`
--

INSERT INTO `control_accidentes` (`n_accidente`, `placa`, `ci_chofer`, `observaciones`, `fecha`, `direccion`, `ci_reg`) VALUES
(29, '1018-RAD', 10013618, 'Simple', '2023-06-18', 'Villa adela', 10013618),
(30, '5542-SDV', 10013618, 'Otros', '2023-06-18', 'Villa  Adela', 10013618),
(31, '5542-SDV', 9965820, 'Multiple', '2023-06-18', 'Cruz papal', 10013618),
(33, '1018-RAD', 10013618, 'Arrollar, Multiple', '2023-06-22', 'cerca de villa adela', 8842536),
(34, '1018-RAD', 10013618, 'Arrollar, Multiple', '2023-06-22', 'cerca de villa adela', 8842536),
(35, '1018-RAD', 10013618, 'Multiple', '2023-06-22', 'cerca de villa adela', 8842536),
(47, '5542-SDV', 9965820, 'Arrollar', '2023-06-25', 'villa Adela', 8842536),
(49, '1018-RAD', 10013618, 'Coalicion, Arrollar, Multiple, Simple, Otros', '2023-06-25', 'Col', 10013618),
(50, '1018-RAD', 10013618, 'Coalicion, Arrollar', '2023-06-25', 'Z/Satelite', 10013618);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `control_aportes`
--

CREATE TABLE `control_aportes` (
  `ci` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `app` varchar(50) DEFAULT NULL,
  `apm` varchar(50) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(50) NOT NULL,
  `estado` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `control_aportes`
--

INSERT INTO `control_aportes` (`ci`, `nombre`, `app`, `apm`, `telefono`, `direccion`, `username`, `password`, `estado`) VALUES
(9965845, 'Jose ', 'Alvarez', 'Quispe', '68547222', 'Z/Senkata C/Alejandria', 'Jose_9965845', '*E9773D7F99419A252C42C9CE46C61E62CEEEC378', 'activo'),
(14725836, 'Sergio Luis', 'Guarallo', 'Bautista', '76543210', 'El Alto', 'Sergio_14725836', '*179550181E5801E57098FA2B4524E3B2DA6745C6', 'activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `control_ruta`
--

CREATE TABLE `control_ruta` (
  `ci` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `app` varchar(50) DEFAULT NULL,
  `apm` varchar(50) DEFAULT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(50) NOT NULL,
  `estado` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `control_ruta`
--

INSERT INTO `control_ruta` (`ci`, `nombre`, `app`, `apm`, `telefono`, `username`, `password`, `estado`) VALUES
(9963215, 'Agustin ', 'Yampa', 'Chura', '71503777', 'Agustin_9963215', '*1D5E6BBAFD3265B9E7F0063E5431693728F93115', 'activo'),
(14523687, 'Eddys', 'Triguero', 'Callisaya', '76543210', 'Eddys_14523687', '*7AA328C728322A73AF29F3820D4D837A11E832EF', 'activo');

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `datos_chofer_vehiculo`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `datos_chofer_vehiculo` (
`ci` int(11)
,`nombre` varchar(30)
,`app` varchar(30)
,`apm` varchar(30)
,`n_celular` varchar(15)
,`licencia_id` int(11)
,`username` varchar(30)
,`password` varchar(100)
,`placa` varchar(15)
,`modelo` varchar(30)
,`marca` varchar(30)
,`estado` varchar(30)
,`tipo` varchar(15)
,`capacidad` int(11)
,`ci_conductor` int(11)
,`id_licencia` int(11)
,`categoria` varchar(2)
,`fecha_exp` date
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_accidente`
--

CREATE TABLE `detalle_accidente` (
  `n` int(11) NOT NULL,
  `n_accidente` int(11) DEFAULT NULL,
  `detalles` text DEFAULT NULL,
  `costo` double(8,2) DEFAULT NULL,
  `ci_control` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detalle_accidente`
--

INSERT INTO `detalle_accidente` (`n`, `n_accidente`, `detalles`, `costo`, `ci_control`) VALUES
(17, 29, 'Accidente normal', 5.00, 8842536),
(18, 30, 'Choque', 0.00, 1),
(19, 31, 'Accidente', 50.00, 8842536),
(20, 29, 'Accidente Simple', 45.00, 8842536),
(21, 29, 'Accidente fuerte', 100.00, 8842536),
(22, 33, 'frenos', 0.00, 8842536),
(23, 34, 'frenos', 0.00, 8842536),
(24, 35, 'freno', 20.00, 8842536),
(25, 35, 'Choque ', 25.00, 8842536),
(26, 47, 'Accidente Simple', 0.00, 8842536),
(27, 47, 'choque pequeÃ±o', 20.00, 8842536),
(28, 49, 'Masivo', 60.00, 8842536),
(29, 50, 'HAY MUERTO', 0.00, 1);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `dias_accidentes`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `dias_accidentes` (
`dia_semana` varchar(9)
,`total_registros` bigint(21)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `licencia`
--

CREATE TABLE `licencia` (
  `id_licencia` int(11) NOT NULL,
  `categoria` varchar(2) DEFAULT NULL,
  `fecha_exp` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `licencia`
--

INSERT INTO `licencia` (`id_licencia`, `categoria`, `fecha_exp`) VALUES
(9521235, 'C', '2025-02-21'),
(9542663, 'C', '2025-06-21'),
(9965820, 'B', '2025-06-26'),
(10013618, 'C', '2025-06-10'),
(12345678, 'C', '2025-12-12');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `linea`
--

CREATE TABLE `linea` (
  `n_linea` int(11) NOT NULL,
  `salida` varchar(50) DEFAULT NULL,
  `parada` varchar(50) DEFAULT NULL,
  `tiempo_estimado` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `nombre_vista`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `nombre_vista` (
`vueltas` bigint(21)
,`ci_chofer` int(11)
,`total_vueltas` bigint(21)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ruta`
--

CREATE TABLE `ruta` (
  `n_ruta` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `linea` varchar(5) DEFAULT NULL,
  `ci_chofer` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ruta`
--

INSERT INTO `ruta` (`n_ruta`, `fecha`, `linea`, `ci_chofer`) VALUES
(16, '2023-06-22', '91', 10013618),
(18, '2023-06-23', '91', 10013618),
(20, '2023-06-25', '92', 10013618),
(21, '2023-06-25', '99', 10013618),
(22, '2023-06-25', '91', 10013618),
(25, '2023-06-26', '91', 10013618),
(26, '2023-06-26', '92', 10013618);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_aviso`
--

CREATE TABLE `tipo_aviso` (
  `n` int(11) NOT NULL,
  `descipcion` text DEFAULT NULL,
  `roles` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipo_aviso`
--

INSERT INTO `tipo_aviso` (`n`, `descipcion`, `roles`) VALUES
(1, 'aviso', NULL),
(2, 'comunicado', NULL),
(3, 'invitacion', NULL),
(4, 'otros', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculo`
--

CREATE TABLE `vehiculo` (
  `placa` varchar(15) NOT NULL,
  `modelo` varchar(30) DEFAULT NULL,
  `marca` varchar(30) DEFAULT NULL,
  `estado` varchar(30) DEFAULT NULL,
  `tipo` varchar(15) DEFAULT NULL,
  `capacidad` int(11) DEFAULT NULL,
  `ci_conductor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vehiculo`
--

INSERT INTO `vehiculo` (`placa`, `modelo`, `marca`, `estado`, `tipo`, `capacidad`, `ci_conductor`) VALUES
('1018-RAD', '1998', 'Mercedes Benz', 'activo', 'Masivo', 27, 10013618),
('1234-ABC', '2000', 'Nissan', 'Activo', 'Masivo', 32, 12345678),
('5234-SPC', '2000', 'Nissan', 'activo', 'Masivo', 30, 9542663),
('5542-SDV', '1999', 'Nissan', 'Activo', 'Masivo', 30, 9965820);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vistaaccidentes`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vistaaccidentes` (
`numero` int(11)
,`placa` varchar(15)
,`ci` int(11)
,`concepto` text
,`detalle` text
,`ubicacion` varchar(50)
,`fecha` date
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vistaaportes`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vistaaportes` (
`ci` int(11)
,`nombre` varchar(30)
,`app` varchar(30)
,`apm` varchar(30)
,`n_celular` varchar(15)
,`licencia_id` int(11)
,`username` varchar(30)
,`password` varchar(100)
,`n_aporte` int(11)
,`monto` double(7,2)
,`fecha` date
,`ci_chofer` int(11)
,`ci_aportes` int(11)
,`concepto` text
,`sector` varchar(30)
,`grupo` varchar(15)
,`placa` varchar(15)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_chofer_aportes`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_chofer_aportes` (
`ci` int(11)
,`nombre` varchar(30)
,`app` varchar(30)
,`apm` varchar(30)
,`n_celular` varchar(15)
,`ci_a` int(11)
,`nombre_aportes` varchar(50)
,`app_aportes` varchar(50)
,`apm_aportes` varchar(50)
,`n_aporte` int(11)
,`monto` double(7,2)
,`fecha` date
,`ci_chofer` int(11)
,`ci_aportes` int(11)
,`concepto` text
,`sector` varchar(30)
,`grupo` varchar(15)
,`placa` varchar(15)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_contador_vueltas`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_contador_vueltas` (
`vueltas` bigint(21)
,`total_vueltas` bigint(21)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_registro_vueltas`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_registro_vueltas` (
`n` bigint(21)
,`nombre` varchar(30)
,`app` varchar(30)
,`apm` varchar(30)
,`ci_chofer` int(11)
,`fecha` date
,`linea` varchar(5)
,`ci_control` int(11)
,`nombre_control` varchar(50)
,`app_control` varchar(50)
,`apm_control` varchar(50)
,`vueltas` bigint(21)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_ruta_chofer`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_ruta_chofer` (
`n_ruta` int(11)
,`fecha` date
,`linea` varchar(5)
,`ci_chofer` int(11)
,`ci` int(11)
,`nombre` varchar(30)
,`app` varchar(30)
,`apm` varchar(30)
,`n_celular` varchar(15)
,`licencia_id` int(11)
,`username` varchar(30)
,`password` varchar(100)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vuelta`
--

CREATE TABLE `vuelta` (
  `n_vuelta` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `hora_salida` time DEFAULT NULL,
  `hora_llegada` time DEFAULT NULL,
  `control_vuelta` int(11) DEFAULT NULL,
  `observaciones` text DEFAULT NULL,
  `n_ruta` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vuelta`
--

INSERT INTO `vuelta` (`n_vuelta`, `numero`, `hora_salida`, `hora_llegada`, `control_vuelta`, `observaciones`, `n_ruta`) VALUES
(24, 1, '11:18:44', '11:08:42', 9963215, 'Ninguna', 16),
(25, 1, '14:26:52', '14:26:34', 9963215, 'Ninguna', 18),
(26, 1, '22:03:36', '22:02:47', 9963215, 'Atraso', 20),
(27, 1, NULL, '00:08:15', 9963215, 'Ninguna', 25),
(28, 2, '01:42:32', '01:42:10', 9963215, 'puntual', 25),
(29, 1, NULL, '01:43:11', 9963215, 'Ninguna', 26);

-- --------------------------------------------------------

--
-- Estructura para la vista `contar_llegada`
--
DROP TABLE IF EXISTS `contar_llegada`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `contar_llegada`  AS SELECT hour(`v`.`hora_llegada`) AS `llegada`, hour(`v`.`hora_salida`) AS `salida`, count(0) AS `total_registros` FROM `vuelta` AS `v` GROUP BY hour(`v`.`hora_llegada`) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `contar_salida`
--
DROP TABLE IF EXISTS `contar_salida`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `contar_salida`  AS SELECT hour(`v`.`hora_llegada`) AS `llegada`, hour(`v`.`hora_salida`) AS `salida`, count(0) AS `total_registros` FROM `vuelta` AS `v` GROUP BY hour(`v`.`hora_salida`) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `datos_chofer_vehiculo`
--
DROP TABLE IF EXISTS `datos_chofer_vehiculo`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `datos_chofer_vehiculo`  AS SELECT `chofer`.`ci` AS `ci`, `chofer`.`nombre` AS `nombre`, `chofer`.`app` AS `app`, `chofer`.`apm` AS `apm`, `chofer`.`n_celular` AS `n_celular`, `chofer`.`licencia_id` AS `licencia_id`, `chofer`.`username` AS `username`, `chofer`.`password` AS `password`, `vehiculo`.`placa` AS `placa`, `vehiculo`.`modelo` AS `modelo`, `vehiculo`.`marca` AS `marca`, `vehiculo`.`estado` AS `estado`, `vehiculo`.`tipo` AS `tipo`, `vehiculo`.`capacidad` AS `capacidad`, `vehiculo`.`ci_conductor` AS `ci_conductor`, `licencia`.`id_licencia` AS `id_licencia`, `licencia`.`categoria` AS `categoria`, `licencia`.`fecha_exp` AS `fecha_exp` FROM ((`chofer` join `vehiculo` on(`chofer`.`ci` = `vehiculo`.`ci_conductor`)) join `licencia` on(`chofer`.`licencia_id` = `licencia`.`id_licencia`)) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `dias_accidentes`
--
DROP TABLE IF EXISTS `dias_accidentes`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `dias_accidentes`  AS SELECT CASE END FROM `aportes` GROUP BY CASE ENDdayofweek(`aportes`.`fecha`) END ORDER BY field(`dia_semana`,'Lunes','Martes','Miércoles','Jueves','Viernes','Sábado','Domingo') ASC ;

-- --------------------------------------------------------

--
-- Estructura para la vista `nombre_vista`
--
DROP TABLE IF EXISTS `nombre_vista`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `nombre_vista`  AS SELECT `v`.`vueltas` AS `vueltas`, `v`.`ci_chofer` AS `ci_chofer`, count(0) AS `total_vueltas` FROM `vista_registro_vueltas` AS `v` GROUP BY `v`.`vueltas`, `v`.`ci_chofer` ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vistaaccidentes`
--
DROP TABLE IF EXISTS `vistaaccidentes`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vistaaccidentes`  AS SELECT `co`.`n_accidente` AS `numero`, `co`.`placa` AS `placa`, `c`.`ci` AS `ci`, `co`.`observaciones` AS `concepto`, `d`.`detalles` AS `detalle`, `co`.`direccion` AS `ubicacion`, `co`.`fecha` AS `fecha` FROM ((`chofer` `c` join `control_accidentes` `co` on(`c`.`ci` = `co`.`ci_chofer`)) join `detalle_accidente` `d` on(`co`.`n_accidente` = `d`.`n_accidente`)) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vistaaportes`
--
DROP TABLE IF EXISTS `vistaaportes`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vistaaportes`  AS SELECT `c`.`ci` AS `ci`, `c`.`nombre` AS `nombre`, `c`.`app` AS `app`, `c`.`apm` AS `apm`, `c`.`n_celular` AS `n_celular`, `c`.`licencia_id` AS `licencia_id`, `c`.`username` AS `username`, `c`.`password` AS `password`, `a`.`n_aporte` AS `n_aporte`, `a`.`monto` AS `monto`, `a`.`fecha` AS `fecha`, `a`.`ci_chofer` AS `ci_chofer`, `a`.`ci_aportes` AS `ci_aportes`, `a`.`concepto` AS `concepto`, `a`.`sector` AS `sector`, `a`.`grupo` AS `grupo`, `a`.`placa` AS `placa` FROM (`chofer` `c` join `aportes` `a` on(`c`.`ci` = `a`.`ci_chofer`)) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_chofer_aportes`
--
DROP TABLE IF EXISTS `vista_chofer_aportes`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_chofer_aportes`  AS SELECT `c`.`ci` AS `ci`, `c`.`nombre` AS `nombre`, `c`.`app` AS `app`, `c`.`apm` AS `apm`, `c`.`n_celular` AS `n_celular`, `ca`.`ci` AS `ci_a`, `ca`.`nombre` AS `nombre_aportes`, `ca`.`app` AS `app_aportes`, `ca`.`apm` AS `apm_aportes`, `a`.`n_aporte` AS `n_aporte`, `a`.`monto` AS `monto`, `a`.`fecha` AS `fecha`, `a`.`ci_chofer` AS `ci_chofer`, `a`.`ci_aportes` AS `ci_aportes`, `a`.`concepto` AS `concepto`, `a`.`sector` AS `sector`, `a`.`grupo` AS `grupo`, `a`.`placa` AS `placa` FROM ((`chofer` `c` join `aportes` `a` on(`c`.`ci` = `a`.`ci_chofer`)) join `control_aportes` `ca` on(`a`.`ci_aportes` = `ca`.`ci`)) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_contador_vueltas`
--
DROP TABLE IF EXISTS `vista_contador_vueltas`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_contador_vueltas`  AS SELECT `v`.`vueltas` AS `vueltas`, count(0) AS `total_vueltas` FROM `vista_registro_vueltas` AS `v` GROUP BY `v`.`vueltas` ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_registro_vueltas`
--
DROP TABLE IF EXISTS `vista_registro_vueltas`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_registro_vueltas`  AS SELECT row_number() over ( order by `r`.`fecha`,`c`.`ci`,`r`.`linea`) AS `n`, `c`.`nombre` AS `nombre`, `c`.`app` AS `app`, `c`.`apm` AS `apm`, `c`.`ci` AS `ci_chofer`, `r`.`fecha` AS `fecha`, `r`.`linea` AS `linea`, `co`.`ci` AS `ci_control`, `co`.`nombre` AS `nombre_control`, `co`.`app` AS `app_control`, `co`.`apm` AS `apm_control`, count(0) AS `vueltas` FROM (((`vuelta` `v` join `ruta` `r` on(`v`.`n_ruta` = `r`.`n_ruta`)) join `chofer` `c` on(`c`.`ci` = `r`.`ci_chofer`)) join `control_ruta` `co` on(`co`.`ci` = `v`.`control_vuelta`)) GROUP BY `r`.`fecha`, `c`.`ci`, `r`.`linea` ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_ruta_chofer`
--
DROP TABLE IF EXISTS `vista_ruta_chofer`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_ruta_chofer`  AS SELECT `r`.`n_ruta` AS `n_ruta`, `r`.`fecha` AS `fecha`, `r`.`linea` AS `linea`, `r`.`ci_chofer` AS `ci_chofer`, `c`.`ci` AS `ci`, `c`.`nombre` AS `nombre`, `c`.`app` AS `app`, `c`.`apm` AS `apm`, `c`.`n_celular` AS `n_celular`, `c`.`licencia_id` AS `licencia_id`, `c`.`username` AS `username`, `c`.`password` AS `password` FROM (`ruta` `r` join `chofer` `c` on(`r`.`ci_chofer` = `c`.`ci`)) ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `accidentes`
--
ALTER TABLE `accidentes`
  ADD PRIMARY KEY (`ci`);

--
-- Indices de la tabla `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`ci`);

--
-- Indices de la tabla `aportes`
--
ALTER TABLE `aportes`
  ADD PRIMARY KEY (`n_aporte`),
  ADD KEY `ci_chofer` (`ci_chofer`),
  ADD KEY `ci_aportes` (`ci_aportes`),
  ADD KEY `placa` (`placa`);

--
-- Indices de la tabla `aviso`
--
ALTER TABLE `aviso`
  ADD PRIMARY KEY (`n_aviso`),
  ADD KEY `tipo` (`tipo`),
  ADD KEY `aviso_fk_ci` (`ci_emisor`);

--
-- Indices de la tabla `chofer`
--
ALTER TABLE `chofer`
  ADD PRIMARY KEY (`ci`),
  ADD KEY `fk_chofer_licencia` (`licencia_id`);

--
-- Indices de la tabla `control_accidentes`
--
ALTER TABLE `control_accidentes`
  ADD PRIMARY KEY (`n_accidente`),
  ADD KEY `placa` (`placa`),
  ADD KEY `ci_chofer` (`ci_chofer`);

--
-- Indices de la tabla `control_aportes`
--
ALTER TABLE `control_aportes`
  ADD PRIMARY KEY (`ci`);

--
-- Indices de la tabla `control_ruta`
--
ALTER TABLE `control_ruta`
  ADD PRIMARY KEY (`ci`);

--
-- Indices de la tabla `detalle_accidente`
--
ALTER TABLE `detalle_accidente`
  ADD PRIMARY KEY (`n`),
  ADD KEY `n_accidente` (`n_accidente`),
  ADD KEY `fk_detalle` (`ci_control`);

--
-- Indices de la tabla `licencia`
--
ALTER TABLE `licencia`
  ADD PRIMARY KEY (`id_licencia`);

--
-- Indices de la tabla `linea`
--
ALTER TABLE `linea`
  ADD PRIMARY KEY (`n_linea`);

--
-- Indices de la tabla `ruta`
--
ALTER TABLE `ruta`
  ADD PRIMARY KEY (`n_ruta`),
  ADD KEY `ci_chofer` (`ci_chofer`);

--
-- Indices de la tabla `tipo_aviso`
--
ALTER TABLE `tipo_aviso`
  ADD PRIMARY KEY (`n`);

--
-- Indices de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD PRIMARY KEY (`placa`),
  ADD KEY `ci_conductor` (`ci_conductor`);

--
-- Indices de la tabla `vuelta`
--
ALTER TABLE `vuelta`
  ADD PRIMARY KEY (`n_vuelta`),
  ADD KEY `control_vuelta` (`control_vuelta`),
  ADD KEY `n_ruta` (`n_ruta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `aportes`
--
ALTER TABLE `aportes`
  MODIFY `n_aporte` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `aviso`
--
ALTER TABLE `aviso`
  MODIFY `n_aviso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT de la tabla `control_accidentes`
--
ALTER TABLE `control_accidentes`
  MODIFY `n_accidente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT de la tabla `detalle_accidente`
--
ALTER TABLE `detalle_accidente`
  MODIFY `n` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT de la tabla `licencia`
--
ALTER TABLE `licencia`
  MODIFY `id_licencia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12345679;

--
-- AUTO_INCREMENT de la tabla `linea`
--
ALTER TABLE `linea`
  MODIFY `n_linea` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ruta`
--
ALTER TABLE `ruta`
  MODIFY `n_ruta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `tipo_aviso`
--
ALTER TABLE `tipo_aviso`
  MODIFY `n` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `vuelta`
--
ALTER TABLE `vuelta`
  MODIFY `n_vuelta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `aportes`
--
ALTER TABLE `aportes`
  ADD CONSTRAINT `aportes_ibfk_1` FOREIGN KEY (`ci_chofer`) REFERENCES `chofer` (`ci`),
  ADD CONSTRAINT `aportes_ibfk_2` FOREIGN KEY (`ci_aportes`) REFERENCES `control_aportes` (`ci`),
  ADD CONSTRAINT `aportes_ibfk_3` FOREIGN KEY (`placa`) REFERENCES `vehiculo` (`placa`);

--
-- Filtros para la tabla `aviso`
--
ALTER TABLE `aviso`
  ADD CONSTRAINT `aviso_fk_ci` FOREIGN KEY (`ci_emisor`) REFERENCES `admin` (`ci`),
  ADD CONSTRAINT `aviso_ibfk_1` FOREIGN KEY (`tipo`) REFERENCES `tipo_aviso` (`n`);

--
-- Filtros para la tabla `chofer`
--
ALTER TABLE `chofer`
  ADD CONSTRAINT `fk_chofer_licencia` FOREIGN KEY (`licencia_id`) REFERENCES `licencia` (`id_licencia`);

--
-- Filtros para la tabla `control_accidentes`
--
ALTER TABLE `control_accidentes`
  ADD CONSTRAINT `control_accidentes_ibfk_1` FOREIGN KEY (`placa`) REFERENCES `vehiculo` (`placa`),
  ADD CONSTRAINT `control_accidentes_ibfk_2` FOREIGN KEY (`ci_chofer`) REFERENCES `chofer` (`ci`);

--
-- Filtros para la tabla `detalle_accidente`
--
ALTER TABLE `detalle_accidente`
  ADD CONSTRAINT `detalle_accidente_ibfk_1` FOREIGN KEY (`n_accidente`) REFERENCES `control_accidentes` (`n_accidente`),
  ADD CONSTRAINT `fk_detalle` FOREIGN KEY (`ci_control`) REFERENCES `accidentes` (`ci`);

--
-- Filtros para la tabla `ruta`
--
ALTER TABLE `ruta`
  ADD CONSTRAINT `ruta_ibfk_1` FOREIGN KEY (`ci_chofer`) REFERENCES `chofer` (`ci`);

--
-- Filtros para la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD CONSTRAINT `vehiculo_ibfk_1` FOREIGN KEY (`ci_conductor`) REFERENCES `chofer` (`ci`);

--
-- Filtros para la tabla `vuelta`
--
ALTER TABLE `vuelta`
  ADD CONSTRAINT `vuelta_ibfk_1` FOREIGN KEY (`control_vuelta`) REFERENCES `control_ruta` (`ci`),
  ADD CONSTRAINT `vuelta_ibfk_2` FOREIGN KEY (`n_ruta`) REFERENCES `ruta` (`n_ruta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
