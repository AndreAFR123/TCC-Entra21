CREATE TABLE bansys.banco (
idBanco INT NOT NULL AUTO_INCREMENT,
nm_banco VARCHAR(45) NOT NULL UNIQUE,
PRIMARY KEY (idBanco));

CREATE TABLE bansys.agencia (
id_agencia INT NOT NULL AUTO_INCREMENT UNIQUE,
nm_agencia VARCHAR(45) NOT NULL,
num_agencia INT NOT NULL,
tel_agencia INT NOT NULL,
end_agencia VARCHAR(100) NOT NULL,
PRIMARY KEY (id_agencia));

CREATE TABLE bansys.funcionario (
id_funcionario INT NOT NULL AUTO_INCREMENT UNIQUE,
cpf_funcionario VARCHAR(25) NOT NULL,
nm_funcionario VARCHAR(50) NOT NULL,
sobre_funcionario VARCHAR(50) NOT NULL,
pis_funcionario INT NOT NULL,
end_funcionario VARCHAR(100) NULL,
tel_funcionario INT NULL,
funcao_funcionario VARCHAR(50) NOT NULL,
sal_funcionario DOUBLE NOT NULL,
cargah_funcionario DOUBLE NOT NULL,
login_funcionario VARCHAR(50) NOT NULL UNIQUE,
senha_funcionario VARCHAR(50) NOT NULL,
email_funcionario INT NULL,
PRIMARY KEY (id_funcionario));

CREATE TABLE bansys.conta (
idConta INT NOT NULL AUTO_INCREMENT UNIQUE,
num_conta INT NOT NULL UNIQUE,
saldo_conta DOUBLE NULL,
limite_conta DOUBLE NULL,
tp_conta VARCHAR(50) NOT NULL,
emprestimo_conta DOUBLE NULL,
PRIMARY KEY (idConta));

CREATE TABLE bansys.cliente (
idcliente INT NOT NULL AUTO_INCREMENT UNIQUE,
cpf_cliente VARCHAR(25) NOT NULL UNIQUE,
nm_cliente VARCHAR(50) NOT NULL,
sobre_cliente VARCHAR(50) NOT NULL,
end_cliente VARCHAR(150) NULL,
tel_cliente INT NULL,
login_cliente VARCHAR(50) NOT NULL UNIQUE,
senha_cliente VARCHAR(50) NOT NULL,
email_cliente VARCHAR(150) NULL,
PRIMARY KEY (idcliente));

ALTER TABLE bansys.agencia
ADD COLUMN fk_agencia_banco INT NOT NULL AFTER end_agencia,
CHANGE COLUMN id_agencia id_agencia INT(11) NOT NULL  UNIQUE;

ALTER TABLE bansys.agencia
ADD INDEX fk_agencia_banco_idx (fk_agencia_banco ASC) ;
;
ALTER TABLE bansys.agencia
ADD CONSTRAINT fk_agencia_banco
FOREIGN KEY (fk_agencia_banco)
REFERENCES bansys.banco (idBanco)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE bansys.funcionario
ADD COLUMN fk_funcionario_agencia INT NOT NULL AFTER email_funcionario,
ADD UNIQUE INDEX fk_funcionario_agencia_UNIQUE (fk_funcionario_agencia ASC) ;
;

ALTER TABLE bansys.funcionario
ADD CONSTRAINT fk_funcionario_agencia
FOREIGN KEY (fk_funcionario_agencia)
REFERENCES bansys.agencia (id_agencia)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE bansys.cliente
ADD COLUMN fk_cliente_conta INT NOT NULL AFTER email_cliente,
ADD UNIQUE INDEX fk_cliente_conta_UNIQUE (fk_cliente_conta ASC);
;

ALTER TABLE bansys.cliente
ADD CONSTRAINT fk_cliente_conta
FOREIGN KEY (fk_cliente_conta)
REFERENCES bansys.conta (idConta)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

CREATE TABLE bansys.agencia_cliente (
fk_agencia INT NOT NULL,
fk_cliente INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY (fk_agencia, fk_cliente),
UNIQUE INDEX fk_agencia_UNIQUE (fk_agencia ASC) ,
UNIQUE INDEX fk_cliente_UNIQUE (fk_cliente ASC) );

ALTER TABLE bansys.agencia_cliente
ADD CONSTRAINT fk_agencia
FOREIGN KEY (fk_agencia)
REFERENCES bansys.agencia (id_agencia)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE bansys.agencia_cliente
ADD CONSTRAINT fk_cliente
FOREIGN KEY (fk_cliente)
REFERENCES bansys.cliente (idcliente)
ON DELETE NO ACTION
ON UPDATE NO ACTION;