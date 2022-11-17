create database biblioteca;
use biblioteca;

create table libros (
    id int auto_increment primary key ,
    titulo varchar(250) not null,
    id_autor int,
        foreign key (id_autor) references autores(id)

);

create table autores(
    id int auto_increment primary key ,
    nombre varchar(100) not null

);

create table abonados(
                        id int auto_increment primary key ,
                        nombre varchar(100) not null

);
drop table alquiler;

create table alquiler(
                        id int auto_increment primary key ,
                        id_libro int null ,
                        id_abonado int null,
                        nombre varchar(100) not null,
                        fecha date not null,
                        foreign key (id_libro)references libros(id) on delete cascade on update cascade ,
                        foreign key (id_abonado)references abonados(id) on delete set null on update cascade

);
