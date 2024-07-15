CREATE DATABASE Fideautos;

USE Fideautos;

/*Se crea un usuario para la base de datos llamado "usuario_prueba" y tiene la contraseña "Usuario_Clave."*/
create user 'tu_usuario'@'%' identified by 'tu_contraseña';

/*Se asignan los prvilegios sobr ela base de datos TechShop al usuario creado */
grant all privileges on Fideautos.* to 'tu_usuario'@'%';
flush privileges;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombreusuario VARCHAR(255) NOT NULL,
    contraseña VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL
);

CREATE TABLE carros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(255),
    modelo VARCHAR(255),
    año INT,
    precio DECIMAL(10, 2),
    disponibilidad BOOLEAN,
    usuario_id INT,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

CREATE TABLE favoritos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT,
    carro_id INT,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (carro_id) REFERENCES carros(id)
);

CREATE TABLE repuestos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    descripcion TEXT,
    precio DECIMAL(10, 2),
    carro_id INT,
    FOREIGN KEY (carro_id) REFERENCES carros(id)
);
