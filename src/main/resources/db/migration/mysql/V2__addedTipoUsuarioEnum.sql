ALTER TABLE `usuario` 
ADD COLUMN `tipo_usuario` ENUM('ROLE_ADMIN', 'ROLE_USUARIO') NOT NULL AFTER `loja_id`;

ALTER TABLE `loja` 
ADD COLUMN `data_cadastro` DATE NOT NULL AFTER `contato`,
ADD COLUMN `data_atualizacao` DATE NULL AFTER `data_cadastro`;

ALTER TABLE `usuario` 
CHANGE COLUMN `loja_id` `loja_id` INT(11) NOT NULL AFTER `id`,
CHANGE COLUMN `tipo_usuario` `tipo_usuario` ENUM('ROLE_ADMIN', 'ROLE_USUARIO') NOT NULL AFTER `loja_id`;
