CREATE SCHEMA IF NOT EXISTS `pooBD` DEFAULT CHARACTER SET utf8 ;
use `pooBD` ;
-- drop schema `pooBD`; 

-- -----------------------------------------------------
-- Table `pooBD`.`Liga`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pooBD`.`Liga` (
  `anoLiga` INT NOT NULL,
  PRIMARY KEY (`anoLiga`) 
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pooBD`.`Luta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pooBD`.`Luta` (
  `idLuta` INT NOT NULL,
  `Liga_anoLiga` INT NOT NULL,
  PRIMARY KEY (`idLuta`,`Liga_anoLiga`),
    FOREIGN KEY (`Liga_anoLiga`)
    REFERENCES `pooBD`.`Liga` (`anoLiga`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pooBD`.`Round`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pooBD`.`Round` (
  `idRound` INT NOT NULL,
  `Luta_idLuta` INT NOT NULL,
  `Luta_anoLiga` INT NOT NULL,
  PRIMARY KEY (`idRound`, `Luta_idLuta`,  `Luta_anoLiga`),
    FOREIGN KEY (`Luta_idLuta`)
    REFERENCES `pooBD`.`Luta` (`idLuta`),
    FOREIGN KEY (`Luta_anoLiga`)
    REFERENCES `pooBD`.`Luta` (`Liga_anoLiga`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pooBD`.`Lutador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pooBD`.`Lutador` (
  `nome` VARCHAR(45) NOT NULL,
  `categoria` VARCHAR(45) NULL,
  `pais` VARCHAR(45) NULL,
  `sexo` VARCHAR(45) NULL,
  PRIMARY KEY(nome)
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pooBD`.`Acoes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pooBD`.`Acoes` (
  `idAcao` INT NOT NULL AUTO_INCREMENT,
  `defesa` INT NOT NULL,
  `ataque` INT NOT NULL,
  `soco` INT NOT NULL,
  `chute` INT NOT NULL,
  `poder` INT NOT NULL,
  `Round_idRound` INT NOT NULL,
  `Round_anoLiga` INT NOT NULL,
  `Round_idLuta` INT NOT NULL,
  `Lutador_nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAcao`),
    FOREIGN KEY (`Round_idRound`) REFERENCES `pooBD`.`Round` (`idRound`),
    FOREIGN KEY (`Round_anoLiga`) REFERENCES `pooBD`.`Round` (`Luta_anoLiga`),
    FOREIGN KEY (`Round_idLuta`) REFERENCES `pooBD`.`Round` (`Luta_idLuta`),
    FOREIGN KEY (`Lutador_nome`) REFERENCES `pooBD`.`Lutador` (`nome`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pooBD`.`Modalidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pooBD`.`Modalidade` (
  `forca` INT NOT NULL,
  `idModalidade` INT NOT NULL AUTO_INCREMENT,
  `Round_idRound` INT NOT NULL,
  `Round_anoLiga` INT NOT NULL,
  `Round_idLuta` INT NOT NULL,
  `Lutador_nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idModalidade`),
    FOREIGN KEY (`Round_idRound`) REFERENCES `pooBD`.`Round` (`idRound`),
    FOREIGN KEY (`Round_anoLiga`) REFERENCES `pooBD`.`Round` (`Luta_anoLiga`),
    FOREIGN KEY (`Round_idLuta`) REFERENCES `pooBD`.`Round` (`Luta_idLuta`),
    FOREIGN KEY (`Lutador_nome`) REFERENCES `pooBD`.`Lutador` (`nome`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `pooBD`.`Resultado_Luta` (
  `Luta_anoLiga` INT NOT NULL,
  `Luta_idLuta` INT NOT NULL,
  `Lutador_nomeVencedor` VARCHAR(45),
  PRIMARY KEY (`Luta_anoLiga`,`Luta_idLuta`,`Lutador_nomeVencedor`),
    FOREIGN KEY (`Luta_anoLiga`) REFERENCES `pooBD`.`Luta` (`Liga_anoLiga`),
    FOREIGN KEY (`Luta_idLuta`) REFERENCES `pooBD`.`Luta` (`idLuta`),
    FOREIGN KEY (`Lutador_nomeVencedor`) REFERENCES `pooBD`.`Lutador` (`nome`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `pooBD`.`Pontos_Round` (
  `idPontos` INT NOT NULL auto_increment,
  `pontos` INT NOT NULL,
  `Round_idRound` INT NOT NULL,
  `Round_anoLiga` INT NOT NULL,
  `Round_idLuta` INT NOT NULL,
  `Lutador_nome` VARCHAR(45),
  PRIMARY KEY (`idPontos`),
    FOREIGN KEY (`Round_idRound`) REFERENCES `pooBD`.`Round` (`idRound`),
    FOREIGN KEY (`Round_anoLiga`) REFERENCES `pooBD`.`Round` (`Luta_anoLiga`),
    FOREIGN KEY (`Round_idLuta`) REFERENCES `pooBD`.`Round` (`Luta_idLuta`),
    FOREIGN KEY (`Lutador_nome`) REFERENCES `pooBD`.`Lutador` (`nome`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
ENGINE = InnoDB;


CREATE VIEW ViewResumoRounds AS 
SELECT Lutador_nome,sum(pontos),Round_idLuta,Round_anoLiga from Pontos_Round 
group by Lutador_nome, Round_idLuta,Round_anoLiga;

CREATE VIEW ViewVencedoresLutas AS select * from Resultado_Luta;

CREATE VIEW ViewNumVitoriaPais AS select count(nome),pais from ViewVencedoresLutas
JOIN Lutador on Lutador.nome = Lutador_nomeVencedor
group by pais;

CREATE VIEW ViewVitoriasJogador AS select Lutador_nomeVencedor,count(Lutador_nomeVencedor) from ViewVencedoresLutas
group by Lutador_nomeVencedor;

create view ViewVencedorCategoria as select Lutador_nomeVencedor,categoria,count(Lutador_nomeVencedor) from Resultado_Luta
join Lutador on Lutador_nomeVencedor = nome
group by categoria;

create view ViewTotalLutas as select count(*) from Luta;

select * from ViewResumoRounds;

select * from ViewNumVitoriaPais;

select * from ViewVencedoresLutas;

select * from ViewVitoriasJogador;

select * from ViewVencedorCategoria;

select * from ViewTotalLutas;

select distinct nome,Acoes.Round_idLuta from Lutador
	join Acoes on Acoes.Lutador_nome = Lutador.nome
    where Acoes.Round_anoLiga = '2010'
    order by Acoes.Round_idLuta;
    