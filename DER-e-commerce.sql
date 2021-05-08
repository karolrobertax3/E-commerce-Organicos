-- MySQL Script generated by MySQL Workbench
-- Sun Mar 21 11:45:49 2021
-- Model: New Model    Version: 1.0
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
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Usuarios` (
  `idUsuarios` INT NULL AUTO_INCREMENT,
  `nome` VARCHAR(80) NULL,
  `razao_social` VARCHAR(80) NULL,
  `cnpj` VARCHAR(20) NULL,
  `cpf` VARCHAR(20) NULL,
  `email` VARCHAR(30) NOT NULL,
  `telefone` VARCHAR(20) NOT NULL,
  `endereco` VARCHAR(100) NULL,
  `senha` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`idUsuarios`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `Categoria` ENUM("ORGÂNICO", "NÃO ORGÂNICO") NOT NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Produtos` (
  `idProdutos` INT NULL AUTO_INCREMENT,
  `SubCategoria` ENUM("Hortaliças", "Legumes", "Frutas", "Outros") NOT NULL,
  `Data da Safra` DATE NOT NULL,
  `nome` VARCHAR(50) NOT NULL,
  `descricao` VARCHAR(250) NULL,
  `preco` DECIMAL(5,2) NOT NULL,
  `Usuarios_idUsuarios` INT NOT NULL,
  `Categoria_idCategoria` INT NOT NULL,
  PRIMARY KEY (`idProdutos`),
  INDEX `fk_Produtos_Usuarios_idx` (`Usuarios_idUsuarios` ASC) VISIBLE,
  INDEX `fk_Produtos_Categoria1_idx` (`Categoria_idCategoria` ASC) VISIBLE,
  CONSTRAINT `fk_Produtos_Usuarios`
    FOREIGN KEY (`Usuarios_idUsuarios`)
    REFERENCES `mydb`.`Usuarios` (`idUsuarios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produtos_Categoria1`
    FOREIGN KEY (`Categoria_idCategoria`)
    REFERENCES `mydb`.`Categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Compras/Vendas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Compras/Vendas` (
  `Usuarios_idUsuarios` INT NOT NULL,
  `Produtos_idProdutos` INT NOT NULL,
  PRIMARY KEY (`Usuarios_idUsuarios`, `Produtos_idProdutos`),
  INDEX `fk_Usuarios_has_Produtos_Produtos1_idx` (`Produtos_idProdutos` ASC) VISIBLE,
  INDEX `fk_Usuarios_has_Produtos_Usuarios1_idx` (`Usuarios_idUsuarios` ASC) VISIBLE,
  CONSTRAINT `fk_Usuarios_has_Produtos_Usuarios1`
    FOREIGN KEY (`Usuarios_idUsuarios`)
    REFERENCES `mydb`.`Usuarios` (`idUsuarios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuarios_has_Produtos_Produtos1`
    FOREIGN KEY (`Produtos_idProdutos`)
    REFERENCES `mydb`.`Produtos` (`idProdutos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
