-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema gerenciando_chaves
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gerenciando_chaves
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gerenciando_chaves` DEFAULT CHARACTER SET utf8mb4 ;
USE `gerenciando_chaves` ;

-- -----------------------------------------------------
-- Table `gerenciando_chaves`.`responsavel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gerenciando_chaves`.`responsavel` (
  `id_responsavel` INT NOT NULL,
  `nome_responsavel` VARCHAR(45) NOT NULL,
  `status_responsavel` INT NULL,
  PRIMARY KEY (`id_responsavel`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gerenciando_chaves`.`evento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gerenciando_chaves`.`evento` (
  `id_evento` INT NOT NULL,
  `descricao_evento` VARCHAR(100) NOT NULL,
  `status_evento` INT NULL,
  PRIMARY KEY (`id_evento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gerenciando_chaves`.`sala`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gerenciando_chaves`.`sala` (
  `id_sala` INT NOT NULL,
  `numero_sala` VARCHAR(45) NOT NULL,
  `status_sala` INT NULL,
  PRIMARY KEY (`id_sala`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gerenciando_chaves`.`horario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gerenciando_chaves`.`horario` (
  `id_horario` INT NOT NULL,
  `data_horario` DATETIME NULL,
  `status_horario` INT NULL,
  PRIMARY KEY (`id_horario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gerenciando_chaves`.`reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gerenciando_chaves`.`reserva` (
  `id_reserva` INT NOT NULL,
  `responsavel_id_responsavel` INT NOT NULL,
  `evento_id_evento` INT NOT NULL,
  `sala_id_sala` INT NOT NULL,
  `horario_id_horario` INT NOT NULL,
  `status_reserva` INT NULL,
  PRIMARY KEY (`id_reserva`, `responsavel_id_responsavel`, `evento_id_evento`, `sala_id_sala`, `horario_id_horario`),
  INDEX `fk_reserva_responsavel_idx` (`responsavel_id_responsavel` ) ,
  INDEX `fk_reserva_evento1_idx` (`evento_id_evento` ) ,
  INDEX `fk_reserva_sala1_idx` (`sala_id_sala` ) ,
  INDEX `fk_reserva_hoario1_idx` (`horario_id_horario` ),
  CONSTRAINT `fk_reserva_responsavel`
    FOREIGN KEY (`responsavel_id_responsavel`)
    REFERENCES `gerenciando_chaves`.`responsavel` (`id_responsavel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_evento1`
    FOREIGN KEY (`evento_id_evento`)
    REFERENCES `gerenciando_chaves`.`evento` (`id_evento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_sala1`
    FOREIGN KEY (`sala_id_sala`)
    REFERENCES `gerenciando_chaves`.`sala` (`id_sala`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_hoario1`
    FOREIGN KEY (`horario_id_horario`)
    REFERENCES `gerenciando_chaves`.`horario` (`id_horario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;