create table funcionarios (
    id              UUID                primary key,
    nome            varchar(100)        not null,
    cpf             char(11)            not null,
    matricula       varchar(8)          not null,
    dataAdmissao    date                not null,
    salario         decimal(10,2)       not null
);

create table endereco (
    id              UUID                primary key,
    logradouro      varchar(150)        not null,
    numero          varchar(15)         not null,
    comlemento      varchar(50)         not null,
    bairro          varchar(50)         not null,
    cidade          varchar(50)         not null,
    estado          char(20)            not null,
    cep             char(8)             not null,
    funcionario_id  UUID                not null unique,
    foreign key(funcionario_id) references funcionarios(id)
);