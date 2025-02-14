create database conciertos;
use conciertos;


create table cliente(
	id int auto_increment primary key,
	Nombre varchar(50) not null,
	Apellido1 varchar(50) not null,
	Apellido2 varchar(50) not null,
	Correo varchar(50) not null,
	Telefono int(10) not null
);
create table concierto(
	id int auto_increment primary key,
	Nombre varchar(50) not null,
	Artista varchar(50) not null,
	Fecha varchar(20) not null,
	Lugar varchar(50) not null,
	Preciobase double not null
);

create table ticket(
	id int auto_increment primary key,
    ID_Cliente int,
    foreign key (ID_Cliente) references cliente(id),
    ID_Concierto int ,
	foreign key (ID_Concierto) references concierto(id),
    zona varchar(50) not null,
    precioFinal double not null,
    FechaCompra varchar(20) not null
);
create table zona(
	id int auto_increment primary key,
	NombreZona varchar(50) not null,
	Capacidad int not null,
	PrecioAdicional double not null
);


select*from cliente ;
select*from concierto ;
select*from ticket ;
select*from zona ;

