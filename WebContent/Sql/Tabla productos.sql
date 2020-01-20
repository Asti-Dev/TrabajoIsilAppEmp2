CREATE DATABASE proyecto01;
USE proyecto01;

create table productos (
	id  int(3) NOT NULL AUTO_INCREMENT,
	nombre varchar(120) NOT NULL,
	categoria varchar(220) NOT NULL,
	cantidad int,
	precio_uni double,
	precio_total double,
	PRIMARY KEY (id)
);