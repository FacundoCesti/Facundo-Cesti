package educacionit.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import educacionit.entities.Alumno;
import educacionit.entities.Curso;
import educacionit.entities.Profesor;
import educacionit.entities.Tecnologia;
import educacionit.source.MyDataSource;

public class Update {
	
	public void updateTecnologiaById(int id, Tecnologia tecnologia) throws SQLException {
		Connection con = MyDataSource.getConnection();
		String SQL_QUERY = "UPDATE tecnologias SET nombre_tecnologia = '"
							+ tecnologia.getNombre() +
							"' WHERE id_tecnologia = " + id;

		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		pst.executeUpdate();
		con.close();
	}
	
	public void updateCursoById(int id, Curso curso) throws SQLException {
		Connection con = MyDataSource.getConnection();
		String SQL_QUERY = "UPDATE tecnologias SET nombre_curso = '"
							+ curso.getNombre() + "', id_tecnologia = " + curso.getTecnologia() +
							" WHERE id_tecnologia = " + id;

		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		pst.executeUpdate();
		con.close();
	}
	
	public void updateProfesorById(int id, Profesor profesor) throws SQLException {
		Connection con = MyDataSource.getConnection();
		String SQL_QUERY = "UPDATE profesores SET nombre_profesor = '"
							+ profesor.getNombre() +
							"' WHERE id_profesor = " + id;

		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		pst.executeUpdate();
		con.close();
	}
	
	public void updateAlumnoById(int id, Alumno alumno) throws SQLException {
		Connection con = MyDataSource.getConnection();
		String SQL_QUERY = "UPDATE alumnos SET nombre_alumno = '"
							+ alumno.getNombre() +
							"' WHERE id_alumno = " + id;

		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		pst.executeUpdate();
		con.close();
	}

}
