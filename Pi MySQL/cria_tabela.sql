CREATE TABLE registros (
    id int not null AUTO_INCREMENT,
    nome varchar(255),
    email varchar(255),
    senha varchar(255),
    telefone varchar(255),
    estado varchar(255),
    cpf varchar(255),
    PRIMARY KEY (id)
    ) DEFAULT charset = utf8;