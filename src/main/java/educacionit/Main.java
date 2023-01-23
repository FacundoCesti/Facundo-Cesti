package educacionit;

import java.sql.Connection;
import java.sql.SQLException;


import educacionit.crud.Delete;
import educacionit.crud.Fetch;
import educacionit.crud.Insert;
import educacionit.crud.Update;
import educacionit.entities.Alumno;
import educacionit.entities.Curso;
import educacionit.entities.Profesor;
import educacionit.entities.Tecnologia;



public class Main {
	
	//private static Connection conn;

	public static void main(String[] args) {
		
		Fetch fetch = new Fetch();
		Insert insert = new Insert();
		Update update = new Update();
		Delete delete = new Delete();
		
		Tecnologia tecnologia = new Tecnologia(1,"Java");
		Curso curso = new Curso(1,"Bootcamp Java Developer",1);
		Profesor profesor = new Profesor(1,"Mario");
		Alumno alumno1 = new Alumno(1,"Ariadna");
		Alumno alumno2 = new Alumno(2,"Diego");
		Alumno alumno3 = new Alumno(3,"Facundo");
		Alumno alumno4 = new Alumno(4,"Sebastian");
		
		try {
			//Test de inserts
			System.out.println("Insert:\n" + tecnologia + "\n" + curso
					+ "\n" + profesor + "\n" + alumno1 + "\n" + alumno2
					+ "\n" + alumno3 + "\n" + alumno4);
			insert.insertTecnologia(tecnologia);
			insert.insertCurso(curso);
			insert.insertProfesor(profesor);
			insert.insertAlumno(alumno1);
			insert.insertAlumno(alumno2);
			insert.insertAlumno(alumno3);
			insert.insertAlumno(alumno4);
			System.out.println("Insert profesor en la Join Table cursos_profesores\n");
			insert.asignarProfesorACurso(1, 1);
			System.out.println("Insert alumnos en la Join Table cursos_alumnos\n");
			insert.inscribirAlumnoEnCurso(1, 1);
			insert.inscribirAlumnoEnCurso(1, 2);
			insert.inscribirAlumnoEnCurso(1, 3);
			insert.inscribirAlumnoEnCurso(1, 4);
			
			//Test de fetches
			System.out.println("Fetch tecnologia con id = 1");
			fetch.fetchTecnologiaById(1);
			System.out.println("Fetch curso con id = 1");
			fetch.fetchCursoById(1);
			System.out.println("Fetch profesor con id = 1");
			fetch.fetchProfesorById(1);
			System.out.println("Fetch alumno con id = 1");
			fetch.fetchAlumnoById(1);
			System.out.println("Fetch todos los alumnos");
			fetch.fetchAlumnos();
			System.out.println("Fetch profesor del curso con id = 1 (aka Bootcamp Java Developer)");
			fetch.fetchProfesorByCursoId(1);
			System.out.println("Fetch alumnos del curso con id = 1 (aka Bootcamp Java Developer)");
			fetch.fetchAlumnosByCursoId(1);
			
			//Test de updates
			System.out.println("Editando al profesor");
			profesor.setNombre("MARIO");
			update.updateProfesorById(1, profesor);
			fetch.fetchProfesorById(1);
			
			//Test de delete
			System.out.println("Desasignando al profesor");
			delete.desasignarProfesorACurso(1, 1);
			System.out.println("Fetch profesor del curso con id 1...\nNo hay nada");
			fetch.fetchProfesorByCursoId(1);
			System.out.println("Reasignando al profesor");
			insert.asignarProfesorACurso(1, 1);
			System.out.println("Fetch profesor del curso con id = 1 (aka Bootcamp Java Developer)");
			fetch.fetchProfesorByCursoId(1);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}


}
