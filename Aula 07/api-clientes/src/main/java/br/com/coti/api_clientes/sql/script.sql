
-- Script para criar uma tabela de clientes no Postgresql
create table clientes (
    id          UUID                primary key,
    nome        varchar(100)        not null,
    email       varchar(50)         not null,
    cpf         char(11)            not null
);


-- Cadastrando alguns clientes na tabela
insert into clientes(id, nome, email, cpf)
values
    (gen_random_uuid(), 'Ana Maria', 'anamaria@gmail.com', '12345678900'),
    (gen_random_uuid(), 'Joao Pedro', 'joapedro@gmail.com', '23423423411'),
    (gen_random_uuid(), 'Marcos Paulo', 'marcospaulo@gmail.com', '23423412341');

-- Consultando os clientes cadastrados
select id, nome, email, cpf from clientes;