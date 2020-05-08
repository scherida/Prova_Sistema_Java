create schema prova;

use prova;

CREATE TABLE `prova`.`pessoa` (
  `idPessoa` INT NOT NULL AUTO_INCREMENT,
  `CPF` VARCHAR(15) NULL,
  `Nome` VARCHAR(150) NULL,
  `usuario` VARCHAR(150) NULL,
  `senha` VARCHAR(150) NULL,
  `endereco` VARCHAR(100) NULL,
  
  PRIMARY KEY (`idPessoa`));

select * from pessoa;

insert into pessoa (CPF, Nome, Usuario, senha, Endereco) values ("78749971581","Martin Nathan da Mata","MMATA","1234","Rua Teixeira Soares, 55");
insert into pessoa (CPF, Nome, Usuario, senha, Endereco) values ("75370705631","Gustavo Alexandre Oliveira","GOLIVEIRA","2345","Rua Laranjeiras, 01");
insert into pessoa (CPF, Nome, Usuario, senha, Endereco) values ("13910088040","Maria Catarina Ribeiro","MRIBEIRO","3456","Rua abacaxi, 895");
insert into pessoa (CPF, Nome, Usuario, senha, Endereco) values ("69615843903","Maya Elisa Barbosa","MBARBOSA","4567","Rua maça, 8955");

-- select dentro do java
select idPessoa, CPF, Nome, Usuario, senha, Endereco from pessoa where usuario = "MMATA" and senha = "1234";

CREATE TABLE `prova`.`produto` (
  `IdProduto` INT NOT NULL AUTO_INCREMENT,
  `Preco` FLOAT,
  `Desc` VARCHAR(150) NULL,
  PRIMARY KEY (`IdProduto`));

select * from produto;
-- select dentro do java
select idProduto, preco, `desc` from produto;

CREATE TABLE `prova`.`cartao` (
  `IdCartao` INT NOT NULL AUTO_INCREMENT,
  `NumCartao` varchar(50),
  `Bandeira` VARCHAR(150) NULL,
  `CCV` VARCHAR(150) NULL,
  `DataValidade` VARCHAR(150) NULL,
  `TipoCartao` VARCHAR(150) NULL,
  `nomeTitular` VARCHAR(150) NULL,
  PRIMARY KEY (`IdCartao`));

select * from cartao;

CREATE TABLE `prova`.`carteira` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `saldo` FLOAT,
  `email` VARCHAR(150) NULL,
  PRIMARY KEY (`id`));

select * from carteira;

CREATE TABLE `prova`.`carrinho` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idUsuario` INT NOT NULL,
  `valorCarrinho` FLOAT NOT NULL,
  PRIMARY KEY (`id`));

select * from carrinho;

CREATE TABLE `produtocarrinho` (
  `idProduto` int(11) NOT NULL,
  `idCarrinho` int(11) NOT NULL,
  `quantidade` float DEFAULT NULL,
  PRIMARY KEY (`idProduto`,`idCarrinho`),
  KEY `idCarrinho_idx` (`idCarrinho`),
  CONSTRAINT `idCarrinho` FOREIGN KEY (`idCarrinho`) REFERENCES `carrinho` (`id`),
  CONSTRAINT `idProduto` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`IdProduto`)
);


CREATE TABLE `prova`.`compra` (
  `numCompra` INT NOT NULL AUTO_INCREMENT,
  `valorTotal` FLOAT,
  `CPF` VARCHAR(30) NULL,
  `dataVenda` date NULL,
  `formaPagamento` VARCHAR(50) NULL,
  PRIMARY KEY (`numCompra`));

select * from compra;

select * from produto;
  
insert into produto (`Preco`, `Desc`) value (17.99, "Rolin");
insert into produto (`Preco`, `Desc`) value (39.23, "Produto de Beleza");
insert into produto (`Preco`, `Desc`) value (190.00, "Kit festa");
insert into produto (`Preco`, `Desc`) value (19.90, "Caneca");
insert into produto (`Preco`, `Desc`) value (1.25, "Caneta");
insert into produto (`Preco`, `Desc`) value (25.66, "Livro");

CREATE TABLE `produtocompra` (
  `idProduto` int(11) NOT NULL,
  `idCompra` int(11) NOT NULL,
  `quantidade` float DEFAULT NULL,
  PRIMARY KEY (`idProduto`,`idCompra`),
  KEY `idCompra_idx` (`idCompra`),
  CONSTRAINT `idCompra` FOREIGN KEY (`idCompra`) REFERENCES `compra` (`numCompra`),
  CONSTRAINT `idProdutoCompra` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`IdProduto`)
);

insert into compra (valorTotal, CPF, dataVenda, formaPagamento) values (43.50, "75370705631", "2020-04-10", "Credito");

insert into ProdutoCompra (idCompra, quantidade) values (2, 7.0);

select * from produto;

select * from compra;

select * from ProdutoCompra;

select distinct c.cpf, c.numCompra, p.preco, p.desc, pc.quantidade from produto p, compra c, ProdutoCompra pc 
where pc.idProduto = p.idProduto
and pc.idCompra = c.numCompra
and c.numcompra = 2;


select * from compra;
select * from pessoa;

insert into compra (valorTotal, CPF, dataVenda, formaPagamento) values (?,?,?,?);


select sysdate() dataVenda from dual;

select * from produto;

select * from produtoCarrinho;

select * from pessoa;

insert into carrinho (idUsuario, valorCarrinho) values (?,?);
insert into produtoCarrinho (idProduto, idCarrinho, quantidade) values (?,?,?);


select c.id from carrinho c, pessoa p where c.idUsuario = p.idPessoa and p.cpf = "78749971581";
select * from carrinho;

update carrinho set valorCarrinho = 12 where id = 3;

select * from pessoa;

update carrinho set valorCarrinho = (select (p.preco*pc.quantidade) from produto p, produtocarrinho pc where p.idProduto = pc.idProduto and pc.idCarrinho = 3) where id = 3;

select * from produto;

select * from produtocarrinho ;

update produtoCarrinho set quantidade = ? where idProduto = ? and idCarrinho = ?;

select * from carrinho;
select * from pessoa;
select c.valorCarrinho from carrinho c, pessoa p where c.idUsuario = p.idPessoa and p.cpf = '78749971581';
select c.id id from carrinho c, pessoa p where c.idUsuario = p.idPessoa and p.cpf = '78749971581';
-- delete from carrinho where id = 1;




select * from pessoa;

select * from compra where cpf = "78749971581";

select quantidade from produtocarrinho where idProduto = ? and idCarrinho = ?;

update carrinho set valorCarrinho = (select sum(p.preco*pc.quantidade) from produto p, produtocarrinho pc where p.idProduto = pc.idProduto and pc.idCarrinho = 3) where id = 3;
