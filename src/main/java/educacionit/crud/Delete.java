package educacionit.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import educacionit.source.MyDataSource;

public class Delete {
	
	public void deleteTecnologiaById(int id) throws SQLException {
		Connection con = MyDataSource.getConnection();
		String SQL_QUERY = "DELETE FROM tecnologias WHERE id_tecnologia = " + id;

		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		pst.execute();
		con.close();
	}
	
	public void deleteCursoById(int id) throws SQLException {
		Connection con = MyDataSource.getConnection();
		String SQL_QUERY = "DELETE FROM cursos WHERE id_curso = " + id;

		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		pst.execute();
		con.close();
	}
	
	public void deleteProfesorById(int id) throws SQLException {
		Connection con = MyDataSource.getConnection();
		String SQL_QUERY = "DELETE FROM profesores WHERE id_profesor = " + id;

		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		pst.execute();
		con.close();
	}
	
	public void deleteAlumnoById(int id) throws SQLException {
		Connection con = MyDataSource.getConnection();
		String SQL_QUERY = "DELETE FROM alumnos WHERE id_alumno = " + id;

		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		pst.execute();
		con.close();
	}
	
	public void desasignarProfesorACurso(int id_curso, int id_profesor) throws SQLException {
		Connection con = MyDataSource.getConnection();
		String SQL_QUERY = "DELETE FROM cursos_profesores WHERE id_curso = " + id_curso
				+ " and id_profesor = " + id_profesor;

		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		pst.execute();
		con.close();
	}
	
	public void desinscribirAlumnoEnCurso(int id_curso, int id_alumno) throws SQLException {
		Connection con = MyDataSource.getConnection();
		String SQL_QUERY = "DELETE FROM cursos_alumnos WHERE id_curso = " + id_curso
				+ " and id_alumno = " + id_alumno;

		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		pst.execute();
		con.close();
	}

}
