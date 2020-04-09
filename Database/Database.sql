-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema pokedex
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pokedex
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pokedex` DEFAULT CHARACTER SET utf8 ;
USE `pokedex` ;

-- -----------------------------------------------------
-- Table `pokedex`.`pokemons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokedex`.`pokemons` (
  `pokemonId` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `evolvesFromId` INT NULL,
  `evolveLvl` INT NULL,
  PRIMARY KEY (`pokemonId`),
  INDEX `fk_pokemon_pokemon_idx` (`evolvesFromId` ASC) VISIBLE,
  CONSTRAINT `fk_pokemon_pokemon`
    FOREIGN KEY (`evolvesFromId`)
    REFERENCES `pokedex`.`pokemons` (`pokemonId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pokedex`.`types`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokedex`.`types` (
  `typeId` INT NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`typeId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pokedex`.`abilities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokedex`.`abilities` (
  `abilityId` INT NOT NULL,
  `ability` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`abilityId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pokedex`.`trainers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokedex`.`trainers` (
  `trainerId` INT NOT NULL AUTO_INCREMENT,
  `trainerName` VARCHAR(45) NOT NULL,
  `trainerPass` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`trainerId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pokedex`.`trainersPokemons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokedex`.`trainersPokemons` (
  `trainerId` INT NOT NULL,
  `pokemonId` INT NOT NULL,
  `foundedLvl` INT NOT NULL,
  INDEX `fk_users_has_pokemons_pokemons1_idx` (`pokemonId` ASC) VISIBLE,
  INDEX `fk_pokedex_trainer1_idx` (`trainerId` ASC) VISIBLE,
  PRIMARY KEY (`trainerId`, `pokemonId`),
  CONSTRAINT `fk_users_has_pokemons_pokemons1`
    FOREIGN KEY (`pokemonId`)
    REFERENCES `pokedex`.`pokemons` (`pokemonId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pokedex_trainer1`
    FOREIGN KEY (`trainerId`)
    REFERENCES `pokedex`.`trainers` (`trainerId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pokedex`.`pokemonsTypes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokedex`.`pokemonsTypes` (
  `pokemonId` INT NOT NULL,
  `typeId` INT NOT NULL,
  PRIMARY KEY (`pokemonId`, `typeId`),
  INDEX `fk_pokemons_has_types_types1_idx` (`typeId` ASC) VISIBLE,
  INDEX `fk_pokemons_has_types_pokemons1_idx` (`pokemonId` ASC) VISIBLE,
  CONSTRAINT `fk_pokemons_has_types_pokemons1`
    FOREIGN KEY (`pokemonId`)
    REFERENCES `pokedex`.`pokemons` (`pokemonId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pokemons_has_types_types1`
    FOREIGN KEY (`typeId`)
    REFERENCES `pokedex`.`types` (`typeId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pokedex`.`pokemonsAbilities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokedex`.`pokemonsAbilities` (
  `pokemonId` INT NOT NULL,
  `abilityId` INT NOT NULL,
  PRIMARY KEY (`pokemonId`, `abilityId`),
  INDEX `fk_abilities_has_pokemons_pokemons1_idx` (`pokemonId` ASC) VISIBLE,
  INDEX `fk_abilities_has_pokemons_abilities1_idx` (`abilityId` ASC) VISIBLE,
  CONSTRAINT `fk_abilities_has_pokemons_abilities1`
    FOREIGN KEY (`abilityId`)
    REFERENCES `pokedex`.`abilities` (`abilityId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_abilities_has_pokemons_pokemons1`
    FOREIGN KEY (`pokemonId`)
    REFERENCES `pokedex`.`pokemons` (`pokemonId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
