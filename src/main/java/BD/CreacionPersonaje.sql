create database creacionPersonaje;
use creacionPersonaje;

create table usuarios (
	id_usuario INT PRIMARY KEY, -- ID como clave primaria
    nombre VARCHAR(16) NOT NULL UNIQUE, -- Nombre del usuario
    password VARCHAR(16) NOT NULL -- Contraseña del usuario
);

create table personajes (
	id_usuario INT NOT NULL, -- ID como clave foránea
	id_personaje INT NOT NULL, -- ID del personaje
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL, -- Fecha de guardado
    nombre VARCHAR(16), -- Nombre del personaje
    id_casco INT NOT NULL, -- Id imagen casco
    id_pecho INT NOT NULL, -- Id imagen pecho
    id_piernas INT NOT NULL, -- Id imagen piernas
    FOREIGN KEY (id_usuario) REFERENCES USUARIOS(id_usuario) ON DELETE CASCADE, -- Clave foránea de la tabla usuarios
    PRIMARY KEY (id_usuario, id_personaje) -- Clave primaria compuesta por usuario y personaje
);