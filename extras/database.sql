SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `satya_backlog` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `satya_backlog` ;

-- -----------------------------------------------------
-- Table `satya_backlog`.`product_backlog`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `satya_backlog`.`product_backlog` (
  `id` INT NOT NULL,
  `importancia` VARCHAR(255) NULL,
  `estimativa` VARCHAR(255) NULL,
  `demonstracao` TEXT NULL,
  `notas` TEXT NULL,
  `solicitante` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `satya_backlog`.`sprint`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `satya_backlog`.`sprint` (
  `id` INT NOT NULL,
  `meta` VARCHAR(45) NULL,
  `inicio` DATE NULL,
  `termino` DATE NULL,
  `tamanho` INT NULL,
  `tamanho_realizado` INT NULL,
  `definicao_pronto` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `satya_backlog`.`item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `satya_backlog`.`item` (
  `id` INT NOT NULL,
  `nome` VARCHAR(255) NULL,
  `situacao` VARCHAR(45) NULL,
  `responsavel` VARCHAR(45) NULL,
  `horas_planejadas` INT NULL,
  `horas_realizadas` INT NULL,
  `prioridade` INT NULL,
  `observacoes` TEXT NULL,
  `fk_sprint` INT NOT NULL,
  `dependente` TINYINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_item_sprint_idx` (`fk_sprint` ASC),
  CONSTRAINT `fk_item_sprint`
    FOREIGN KEY (`fk_sprint`)
    REFERENCES `satya_backlog`.`sprint` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `satya_backlog`.`revisao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `satya_backlog`.`revisao` (
  `id` INT NOT NULL,
  `tipo` VARCHAR(45) NULL,
  `descricao` TEXT NULL,
  `fk_sprint` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_revisao_sprint1_idx` (`fk_sprint` ASC),
  CONSTRAINT `fk_revisao_sprint1`
    FOREIGN KEY (`fk_sprint`)
    REFERENCES `satya_backlog`.`sprint` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `satya_backlog`.`impedimentos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `satya_backlog`.`impedimentos` (
  `id` INT NOT NULL,
  `impedimentos` VARCHAR(45) NULL,
  `responsavel_por` VARCHAR(45) NULL,
  `responsavel` VARCHAR(45) NULL,
  `data_criacao` DATE NULL,
  `data_final` DATE NULL,
  `observacao` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
