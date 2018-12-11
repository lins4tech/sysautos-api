CREATE TABLE IF NOT EXISTS `loja` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `razao_social` VARCHAR(155) NOT NULL,
  `cnpj` VARCHAR(155) NOT NULL,
  `endereco` VARCHAR(255) NOT NULL,
  `estado` VARCHAR(15) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `contato` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome_completo` VARCHAR(155) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `data_cadastro` DATE NOT NULL,
  `data_atualizacao` DATE NULL,
  `loja_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_USUARIO_LOJA_ID_idx` (`loja_id` ASC),
  CONSTRAINT `FK_USUARIO_LOJA_ID`
    FOREIGN KEY (`loja_id`)
    REFERENCES `loja` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `loja_id` INT NOT NULL,
  `nome_completo` VARCHAR(155) NOT NULL,
  `tipo_cliente` ENUM('PF', 'PJ') NOT NULL,
  `data_nascimento` DATE NULL,
  `email` VARCHAR(155) NOT NULL,
  `rg` VARCHAR(25) NULL,
  `cpf_cnpj` VARCHAR(15) NOT NULL,
  `contato` VARCHAR(155) NULL,
  `telefone` VARCHAR(45) NULL,
  `celular` VARCHAR(45) NULL,
  `endereco` VARCHAR(255) NULL,
  `cidade` VARCHAR(45) NULL,
  `estado` VARCHAR(45) NULL,
  `cep` VARCHAR(10) NULL,
  `data_cadastro` DATE NOT NULL,
  `data_atualizacao` DATE NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_CLIENTE_LOJAID_idx` (`loja_id` ASC),
  CONSTRAINT `FK_CLIENTE_LOJAID`
    FOREIGN KEY (`loja_id`)
    REFERENCES `loja` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `veiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `veiculo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `loja_id` INT NOT NULL,
  `marca` VARCHAR(100) NOT NULL,
  `modelo` VARCHAR(100) NOT NULL,
  `ano_fabricacao` INT NOT NULL,
  `ano_modelo` INT NOT NULL,
  `placa` VARCHAR(8) NOT NULL,
  `chassis` VARCHAR(45) NULL,
  `renavam` VARCHAR(45) NULL,
  `combustivel` VARCHAR(25) NULL,
  `motor` VARCHAR(45) NULL,
  `data_cadastro` DATE NOT NULL,
  `data_atualizacao` DATE NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_VEICULO_LOJAID_idx` (`loja_id` ASC),
  CONSTRAINT `FK_VEICULO_LOJAID`
    FOREIGN KEY (`loja_id`)
    REFERENCES `loja` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `entrada_veiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `entrada_veiculo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `loja_id` INT NOT NULL,
  `veiculo_id` INT NOT NULL,
  `cliente_id` INT NOT NULL,
  `data_entrada` DATE NOT NULL,
  `valor_compra` DECIMAL(10,2) NOT NULL,
  `observacao` VARCHAR(1000) NULL,
  `dut_em_nome` VARCHAR(155) NULL,
  `kilometragem` DECIMAL(10,0) NULL,
  `valor_venda` DECIMAL(10,2) NULL,
  `observacao_veiculo` VARCHAR(255) NULL,
  `observacao_entrada` VARCHAR(255) NULL,
  `data_cadastro` DATE NOT NULL,
  `data_atualizacao` DATE NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_ENTRADA_VEICULO_CLIENTEID_idx` (`cliente_id` ASC),
  INDEX `FK_ENTRADA_VEICULO_LOJAID_idx` (`loja_id` ASC),
  INDEX `FK_ENTRADA_VEICULO_VEICULOID_idx` (`veiculo_id` ASC),
  CONSTRAINT `FK_ENTRADA_VEICULO_CLIENTEID`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `cliente` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_ENTRADA_VEICULO_LOJAID`
    FOREIGN KEY (`loja_id`)
    REFERENCES `loja` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_ENTRADA_VEICULO_VEICULOID`
    FOREIGN KEY (`veiculo_id`)
    REFERENCES `veiculo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `venda_veiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `venda_veiculo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `entrada_veiculo_id` INT NOT NULL,
  `cliente_id` INT NOT NULL,
  `valor_total` DECIMAL(10,2) NOT NULL,
  `data_venda` DATE NOT NULL,
  `observacao` VARCHAR(255) NULL,
  `data_cadastro` DATE NOT NULL,
  `data_atualizacao` DATE NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_VENDA_VEICULO_ENTRADA_VEICULOID_idx` (`entrada_veiculo_id` ASC),
  INDEX `FK_VENDA_VEICULO_CLIENTEID_idx` (`cliente_id` ASC),
  CONSTRAINT `FK_VENDA_VEICULO_ENTRADA_VEICULOID`
    FOREIGN KEY (`entrada_veiculo_id`)
    REFERENCES `entrada_veiculo` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_VENDA_VEICULO_CLIENTEID`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `cliente` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `venda_veiculo_financiamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `venda_veiculo_financiamento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `venda_veiculo_id` INT NOT NULL,
  `qtd_parcela` INT NULL,
  `valor_parcela` DECIMAL(10,2) NULL,
  `valor_financiamento` DECIMAL(10,2) NOT NULL,
  `banco` VARCHAR(45) NOT NULL,
  `tipo` ENUM('F', 'C') NOT NULL,
  `detalhe_consorcio` VARCHAR(255) NULL,
  `observacao` VARCHAR(255) NULL,
  `data_cadastro` DATE NOT NULL,
  `data_atualizacao` DATE NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_VENDA_VEI_DETALHE_VENDA_VEICULOID_idx` (`venda_veiculo_id` ASC),
  CONSTRAINT `FK_VENDA_VEI_DETALHE_VENDA_VEICULOID`
    FOREIGN KEY (`venda_veiculo_id`)
    REFERENCES `venda_veiculo` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `venda_veiculo_cheque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `venda_veiculo_cheque` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `venda_veiculo_id` INT NOT NULL,
  `numero_cheque` VARCHAR(45) NOT NULL,
  `valor_cheque` DECIMAL(10,2) NOT NULL,
  `agencia_cheque` VARCHAR(45) NULL,
  `conta_cheque` VARCHAR(45) NULL,
  `banco_cheque` VARCHAR(45) NULL,
  `data_cheque` DATE NOT NULL,
  `data_cadastro` DATE NOT NULL,
  `data_atualizacao` DATE NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_CHEQUE_VENDA_VEICULOID_idx` (`venda_veiculo_id` ASC),
  CONSTRAINT `FK_CHEQUE_VENDA_VEICULOID`
    FOREIGN KEY (`venda_veiculo_id`)
    REFERENCES `venda_veiculo` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table venda_veiculo_deposito
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `venda_veiculo_deposito` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `venda_veiculo_id` INT NOT NULL,
  `valor_deposito` DECIMAL(10,2) NOT NULL,
  `data_deposito` DATE NOT NULL,
  `numero_conta` VARCHAR(45) NULL,
  `agencia_conta` VARCHAR(45) NULL,
  `banco_conta` VARCHAR(45) NULL,
  `data_cadastro` DATE NOT NULL,
  `data_atualizacao` DATE NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_DEPOSITO_VENDA_VEICULOID_idx` (`venda_veiculo_id` ASC),
  CONSTRAINT `FK_DEPOSITO_VENDA_VEICULOID`
    FOREIGN KEY (`venda_veiculo_id`)
    REFERENCES `venda_veiculo` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `venda_veiculo_troca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `venda_veiculo_troca` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `venda_veiculo_id` INT NOT NULL,
  `marca` VARCHAR(100) NOT NULL,
  `modelo` VARCHAR(100) NOT NULL,
  `placa` VARCHAR(45) NOT NULL,
  `ano_modelo` INT NULL,
  `ano_fabricacao` VARCHAR(45) NULL,
  `valor` DECIMAL(10,2) NOT NULL,
  `data_cadastro` DATE NOT NULL,
  `data_atualizacao` DATE NULL,
  `vinculo_entrada_veiculo_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_TROCA_VENDA_VEICULOID_idx` (`venda_veiculo_id` ASC),
  INDEX `fk_venda_veiculo_troca_entrada_veiculo1_idx` (`vinculo_entrada_veiculo_id` ASC),
  CONSTRAINT `FK_TROCA_VENDA_VEICULOID`
    FOREIGN KEY (`venda_veiculo_id`)
    REFERENCES `venda_veiculo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_TROCA_ENTRADA_VEICULOID`
    FOREIGN KEY (`vinculo_entrada_veiculo_id`)
    REFERENCES `entrada_veiculo` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
