DROP TABLE IF EXISTS tecnologias;
CREATE TABLE tecnologias(
    id_tecnologia INT not null,
    nombre_tecnologia VARCHAR(50),
    PRIMARY KEY(id_tecnologia)
);

DROP TABLE IF EXISTS cursos;
CREATE TABLE cursos(
    id_curso INT not null,
    nombre_curso VARCHAR(50),
    id_tecnologia INT,
    PRIMARY KEY(id_curso),
    FOREIGN KEY(id_tecnologia) REFERENCES tecnologias(id_tecnologia)
);

DROP TABLE IF EXISTS profesores;
CREATE TABLE profesores(
    id_profesor INT not null,
    nombre_profesor VARCHAR(50),
    PRIMARY KEY(id_profesor)
);

DROP TABLE IF EXISTS cursos_profesores;
CREATE TABLE cursos_profesores(
    id_cursos_profesores INT auto_increment,
    id_curso INT,
    id_profesor INT,
    PRIMARY KEY(id_cursos_profesores),
    FOREIGN KEY(id_curso) REFERENCES cursos(id_curso),
    FOREIGN KEY(id_profesor) REFERENCES profesores(id_profesor)
);

DROP TABLE IF EXISTS alumnos;
CREATE TABLE alumnos(
    id_alumno INT not null,
    nombre_alumno VARCHAR(50),
    PRIMARY KEY(id_alumno)
);

DROP TABLE IF EXISTS cursos_alumnos;
CREATE TABLE cursos_alumnos(
    id_cursos_alumnos INT auto_increment,
    id_curso INT,
    id_alumno INT,
    PRIMARY KEY(id_cursos_alumnos),
    FOREIGN KEY(id_curso) REFERENCES cursos(id_curso),
    FOREIGN KEY(id_alumno) REFERENCES alumnos(id_alumno)
);