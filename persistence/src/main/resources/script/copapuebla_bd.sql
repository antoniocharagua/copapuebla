
CREATE TABLE torneo (
    id int NOT NULL PRIMARY KEY 
    GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE categoria(
    id int NOT NULL PRIMARY KEY 
    GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    clave VARCHAR(50) NOT NULL
);

CREATE TABLE categoria_descripcion(
    id INT PRIMARY KEY REFERENCES categoria (id) ON DELETE CASCADE,
    descripcion VARCHAR(2000) NOT NULL
);

CREATE TABLE genero(
    id int NOT NULL PRIMARY KEY 
    GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    descripcion VARCHAR(15) NOT NULL
);

CREATE TABLE equipo(
    id int NOT NULL PRIMARY KEY 
    GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    nombre VARCHAR(50) NOT NULL
);

CREATE TABLE jugador(
    id int NOT NULL PRIMARY KEY 
    GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    curp CHAR(18) UNIQUE,
    nombre VARCHAR(60) NOT NULL,
    apellido_materno VARCHAR(40) NOT NULL,
    apellido_paterno VARCHAR(40) NOT NULL,
    id_generon INT NOT NULL REFERENCES genero (id) ON DELETE CASCADE
);

CREATE TABLE jugador_equipo_torneo(
    id_jugador INT NOT NULL REFERENCES jugador (id) ON DELETE CASCADE,
    id_torneo INT NOT NULL REFERENCES torneo (id) ON DELETE CASCADE,
    id_equipo INT NOT NULL REFERENCES equipo (id) ON DELETE CASCADE,
    PRIMARY KEY (id_jugador, id_torneo, id_equipo)
);

CREATE TABLE partida(
    id INT NOT NULL PRIMARY KEY 
    GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    id_torneo INT NOT NULL REFERENCES torneo (id) ON DELETE CASCADE,
    id_equipo_primero INT NOT NULL REFERENCES equipo (id) ON DELETE CASCADE,
    id_equipo_segundo INT NOT NULL REFERENCES equipo (id) ON DELETE CASCADE,
    CONSTRAINT equipo_iguales CHECK (id_equipo_primero > id_equipo_segundo),
    CONSTRAINT partida_unica UNIQUE (id_torneo, id_equipo_primero, id_equipo_segundo)
);

CREATE TABLE marcador(
    id_partida INT NOT NULL REFERENCES partida (id) ON DELETE CASCADE,
    id_jugador INT NOT NULL REFERENCES jugador (id) ON DELETE CASCADE,
    gol INT NOT NULL,
    PRIMARY KEY (id_partida, id_jugador)
);

CREATE TABLE equipo_categoria_torneo(
    id_equipo INT NOT NULL REFERENCES equipo (id) ON DELETE CASCADE,
    id_jugador INT NOT NULL REFERENCES jugador (id) ON DELETE CASCADE,
    id_torneo INT NOT NULL REFERENCES torneo (id) ON DELETE CASCADE,
    PRIMARY KEY (id_equipo, id_jugador, id_torneo)
);

--informacion basica
insert into genero (descripcion) values ('Masculino'), ('Femenino'), ('Mixto');

commit;