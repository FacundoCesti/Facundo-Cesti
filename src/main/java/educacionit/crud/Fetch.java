package educacionit.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import educacionit.entities.Alumno;
import educacionit.entities.Curso;
import educacionit.entities.Profesor;
import educacionit.entities.Tecnologia;
import educacionit.source.MyDataSource;

public class Fetch {
	
	//Todos los metodos para consultar en la base de datos
	
	//Metodos para Tecnologia
	
	public void fetchTecnologiaById(int id) throws SQLException {
		Connection con = MyDataSource.getConnection();
		String SQL_QUERY = "select * from tecnologias where id_tecnologia = " + id;
		
		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		ResultSet rs = pst.executeQuery();
		
		Tecnologia tecnologia = new Tecnologia();
		
		while (rs.next()) {
			tecnologia.setId(rs.getInt("id_tecnologia"));
			tecnologia.setNombre(rs.getString("nombre_tecnologia"));
		}
		System.out.println(tecnologia);
		System.out.println("");
		con.close();
	}
	
	public void fetchTecnologias() throws SQLException {
		Connection con = MyDataSource.getConnection();
		String SQL_QUERY = "select * from tecnologias";

		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(new Tecnologia(
					rs.getInt("id_tecnologia"), 
					rs.getString("nombre_tecnologia")));
		}
		System.out.println("");
		con.close();
	}
	
	
	//Metodos para Curso
	
	public void fetchCursoById(int id) throws SQLException {
		Connection con = MyDataSource.getConnection();
		String SQL_QUERY = "select * from cursos where id_curso = " + id;
		
		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		ResultSet rs = pst.executeQuery();
		
		Curso curso = new Curso();
		
		while (rs.next()) {
			curso.setId(rs.getInt("id_curso"));
			curso.setNombre(rs.getString("nombre_curso"));
			curso.setTecnologia(id);
		}
		System.out.println(curso);
		System.out.println("");
		con.close();
	}
	
	public void fetchCursos() throws SQLException {
		Connection con = MyDataSource.getConnection();
		String SQL_QUERY = "select * from cursos";

		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(new Curso(
					rs.getInt("id_curso"), 
					rs.getString("nombre_curso"),
					rs.getInt("id_tecnologia")));
		}
		System.out.println("");
		con.close();
	}
	
	//Metodos para Profesor
	
	public void fetchProfesorById(int id) throws SQLException {
		Connection con = MyDataSource.getConnection();
		String SQL_QUERY = "select * from profesores where id_profesor = " + id;
		
		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		ResultSet rs = pst.executeQuery();
		
		Profesor profesor = new Profesor();
		
		while (rs.next()) {
			profesor.setId(rs.getInt("id_profesor"));
			profesor.setNombre(rs.getString("nombre_profesor"));
		}
		System.out.println(profesor);
		System.out.println("");
		con.close();
	}
	
	public void fetchProfesores() throws SQLException {
		Connection con = MyDataSource.getConnection();
		String SQL_QUERY = "select * from profesores";

		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(new Profesor(
					rs.getInt("id_profesor"), 
					rs.getString("nombre_profesor")));
		}
		System.out.println("");
		con.close();
	}
	
	public void fetchProfesorByCursoId(int id) throws SQLException {
		Connection con = MyDataSource.getConnection();
		String SQL_QUERY = "select p.id_profesor, p.nombre_profesor "
				+ "from cursos_profesores as j "
				+ "left join profesores as p "
				+ "where j.id_curso = " + id
				+ " and j.id_profesor = p.id_profesor";

		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(new Profesor(
					rs.getInt("id_profesor"), 
					rs.getString("nombre_profesor")));
		}
		System.out.println("");
		con.close();
	}
	
	//Metodos para Alumno
	
	public void fetchAlumnoById(int id) throws SQLException {
		Connection con = MyDataSource.getConnection();
		String SQL_QUERY = "select * from alumnos where id_alumno = " + id;
		
		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		ResultSet rs = pst.executeQuery();
		
		Alumno alumno = new Alumno();
		
		while (rs.next()) {
			alumno.setId(rs.getInt("id_alumno"));
			alumno.setNombre(rs.getString("nombre_alumno"));
		}
		System.out.println(alumno);
		System.out.println("");
		con.close();
	}
	
	public void fetchAlumnos() throws SQLException {
		Connection con = MyDataSource.getConnection();
		String SQL_QUERY = "select * from alumnos";

		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(new Alumno(
					rs.getInt("id_alumno"), 
					rs.getString("nombre_alumno")));
		}
		System.out.println("");
		con.close();
	}
	
	public void fetchAlumnosByCursoId(int id) throws SQLException {
		Connection con = MyDataSource.getConnection();
		String SQL_QUERY = "select a.id_alumno, a.nombre_alumno "
				+ "from cursos_alumnos as j "
				+ "left join alumnos as a "
				+ "where j.id_curso = " + id
				+ " and j.id_alumno = a.id_alumno";

		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(new Alumno(
					rs.getInt("id_alumno"), 
					rs.getString("nombre_alumno")));
		}
		System.out.println("");
		con.close();
	}

}
