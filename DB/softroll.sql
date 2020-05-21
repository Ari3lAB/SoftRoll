-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema softrolldb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema softrolldb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `softrolldb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`eventos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`eventos` (
  `IDEvento` INT(11) NOT NULL AUTO_INCREMENT,
  `Hora` VARCHAR(8) NULL DEFAULT NULL,
  `Temperatura` VARCHAR(2) NULL DEFAULT NULL,
  `Humedad` VARCHAR(2) NULL DEFAULT NULL,
  PRIMARY KEY (`IDEvento`))
ENGINE = InnoDB
AUTO_INCREMENT = 58
DEFAULT CHARACTER SET = utf8;

USE `softrolldb` ;

-- -----------------------------------------------------
-- Table `softrolldb`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `softrolldb`.`usuarios` (
  `idUsuarios` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(50) NOT NULL,
  `Password` CHAR(4) NULL DEFAULT NULL,
  `Admin` TINYINT(4) NULL DEFAULT '0',
  PRIMARY KEY (`idUsuarios`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `softrolldb`.`caja`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `softrolldb`.`caja` (
  `idCaja` INT(11) NOT NULL AUTO_INCREMENT,
  `SaldoInicial` FLOAT NULL DEFAULT NULL,
  `SaldoCierre` FLOAT NULL DEFAULT NULL,
  `HoraCierre` DATETIME NULL DEFAULT NULL,
  `idUsuarios` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idCaja`),
  INDEX `fk_usuarios` (`idUsuarios` ASC) VISIBLE,
  CONSTRAINT `fk_usuarios`
    FOREIGN KEY (`idUsuarios`)
    REFERENCES `softrolldb`.`usuarios` (`idUsuarios`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `softrolldb`.`categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `softrolldb`.`categorias` (
  `idCategorias` INT(11) NOT NULL AUTO_INCREMENT,
  `NombreCategoria` VARCHAR(45) NOT NULL,
  `Descripcion` VARCHAR(80) NULL DEFAULT NULL,
  PRIMARY KEY (`idCategorias`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `softrolldb`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `softrolldb`.`clientes` (
  `idClientes` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(50) NOT NULL,
  `Numero` VARCHAR(12) NULL DEFAULT NULL,
  `Direccion` VARCHAR(60) NULL DEFAULT NULL,
  PRIMARY KEY (`idClientes`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `softrolldb`.`orden`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `softrolldb`.`orden` (
  `idOrden` INT(11) NOT NULL AUTO_INCREMENT,
  `Clientes_idClientes` INT(11) NOT NULL,
  `Usuarios_idUsuarios` INT(11) NOT NULL,
  `FechaOrden` DATETIME NOT NULL,
  `Estado` VARCHAR(15) NULL DEFAULT NULL,
  `PagoFinal` DECIMAL(13,2) NULL DEFAULT '0.00',
  `Descuento` INT(10) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`idOrden`, `Clientes_idClientes`, `Usuarios_idUsuarios`),
  INDEX `fk_Orden_Clientes1_idx` (`Clientes_idClientes` ASC) VISIBLE,
  INDEX `fk_Orden_Usuarios1_idx` (`Usuarios_idUsuarios` ASC) VISIBLE,
  CONSTRAINT `fk_Orden_Clientes1`
    FOREIGN KEY (`Clientes_idClientes`)
    REFERENCES `softrolldb`.`clientes` (`idClientes`),
  CONSTRAINT `fk_Orden_Usuarios1`
    FOREIGN KEY (`Usuarios_idUsuarios`)
    REFERENCES `softrolldb`.`usuarios` (`idUsuarios`))
ENGINE = InnoDB
AUTO_INCREMENT = 22
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `softrolldb`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `softrolldb`.`productos` (
  `idProductos` INT(11) NOT NULL AUTO_INCREMENT,
  `NombreProducto` VARCHAR(45) NOT NULL,
  `Precio` DECIMAL(13,2) UNSIGNED NOT NULL,
  `Categorías_idCategorias` INT(11) NOT NULL,
  `Promocion` TINYINT(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idProductos`, `Categorías_idCategorias`),
  INDEX `fk_Productos_Categorías_idx` (`Categorías_idCategorias` ASC) VISIBLE,
  CONSTRAINT `fk_Productos_Categorías`
    FOREIGN KEY (`Categorías_idCategorias`)
    REFERENCES `softrolldb`.`categorias` (`idCategorias`))
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `softrolldb`.`detalleorden`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `softrolldb`.`detalleorden` (
  `idDetalleOrden` INT(11) NOT NULL AUTO_INCREMENT,
  `Orden_idOrden` INT(11) NOT NULL,
  `Productos_idProductos` INT(11) NOT NULL,
  `Cantidad` TINYINT(3) UNSIGNED NULL DEFAULT '1',
  `Notas` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`idDetalleOrden`, `Orden_idOrden`, `Productos_idProductos`),
  INDEX `fk_DetalleOrden_Orden1_idx` (`Orden_idOrden` ASC) VISIBLE,
  INDEX `fk_DetalleOrden_Productos1_idx` (`Productos_idProductos` ASC) VISIBLE,
  CONSTRAINT `fk_DetalleOrden_Orden1`
    FOREIGN KEY (`Orden_idOrden`)
    REFERENCES `softrolldb`.`orden` (`idOrden`),
  CONSTRAINT `fk_DetalleOrden_Productos1`
    FOREIGN KEY (`Productos_idProductos`)
    REFERENCES `softrolldb`.`productos` (`idProductos`))
ENGINE = InnoDB
AUTO_INCREMENT = 37
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `softrolldb`.`movimientos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `softrolldb`.`movimientos` (
  `idMovimiento` INT(11) NOT NULL AUTO_INCREMENT,
  `Tipo` VARCHAR(15) NOT NULL,
  `Cantidad` FLOAT NOT NULL,
  `Fecha` DATETIME NOT NULL,
  PRIMARY KEY (`idMovimiento`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
