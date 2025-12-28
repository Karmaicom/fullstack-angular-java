create table produtos (
	id				serial			primary key,
	nome			varchar(100)	not null,
	preco			decimal(10,2)	not null,
	quantidade		int				not null
);

insert into produtos(nome, preco, quantidade)
values ();

select id, nome, preco, quantidade
from produtos p
order by p.id;