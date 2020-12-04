CREATE DATABASE db_projeto;

use db_projeto;

CREATE TABLE tb_usuario(
	idUsuario bigint NOT NULL AUTO_INCREMENT,
	nome_completo varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	senha varchar(12) NOT NULL,
	
    PRIMARY KEY (idUsuario)
);

CREATE TABLE tb_categoria (
	idCategoria bigint NOT NULL AUTO_INCREMENT,
	tipoProduto varchar(50) NOT NULL,
	descricaoCategoria varchar(200) NOT NULL,
	
    PRIMARY KEY (idCategoria)
);

CREATE TABLE tb_produto (
	idProduto bigint NOT NULL AUTO_INCREMENT,
	descricaoProduto varchar(140) NOT NULL,
	tamanho char(5) NOT NULL,
	valor DECIMAL(5,2) NOT NULL,
	estoque int NOT NULL,
	urlProduto text NOT NULL,
	categoria_id bigint NOT NULL,
	
    PRIMARY KEY (idProduto),
    FOREIGN KEY(categoria_id) REFERENCES tb_categoria(idCategoria)
);

