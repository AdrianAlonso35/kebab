DROP DATABASE IF EXISTS Kebab;
CREATE DATABASE Kebab;
Use Kebab;

CREATE TABLE clientes (
  id_cliente int PRIMARY KEY AUTO_INCREMENT,
  email varchar(100) NOT NULL,
  contrasena varchar(200) NOT NULL
) ;

CREATE TABLE productos (
  id_producto int PRIMARY KEY AUTO_INCREMENT,
  nombrePlato varchar(100) NOT NULL,
  precioPlato decimal(10,2) NOT NULL,
  nombreBebida varchar(100) NOT NULL,
  precioBebida decimal(10,2) NOT NULL,
  patatas boolean 
) ;
 INSERT INTO productos (nombrePlato,precioPlato,nombreBebida,precioBebida,patatas) VALUES
 ('kebab' ,5.5 ,'sprite', 2.5, true),
 ('durum', 6.5,'coca cola', 2.5,false),
 ('patatas con carne',3.5,'agua',1.5,true),
 ('lahmacun',8.5,'sprite', 2.5,false);
 

CREATE TABLE pedidos (
  id_pedido int PRIMARY KEY AUTO_INCREMENT,
  id_cliente int NOT NULL,
  id_producto int NOT NULL,
  cantidad int NOT NULL,
  fecha datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  total decimal(10,2) NOT NULL,
  KEY `id_cliente` (`id_cliente`),
  KEY `id_producto` (`id_producto`),
  CONSTRAINT `pedidos_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`),
  CONSTRAINT `pedidos_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`)
);

