package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 

import java.util.List;
import modelo.Autor;

public class AutorDAO {
private String jdbcURL = "jdbc:mysql://localhost:3306/parcial3?useSSL=false";
private String jdbcUsername = "sistemadebiblioteca";
private String jdbcPassword = "clave123";
private static final String INSERT_Autor_SQL = "INSERT INTO autor" + " (name, email, country, libro) VALUES "
+ " (?, ?, ?, ?);";
private static final String SELECT_Autor_BY_ID = "select id,name,email,country,libro from autor where id =?";
private static final String SELECT_ALL_Autor = "select * from autor";
private static final String DELETE_Autor_SQL = "delete from autor where id = ?;";
private static final String UPDATE_Autor_SQL = "update autor set name = ?,email= ?, country =?, libro= ?  where id = ?";
PreparedStatement ps=null;
public AutorDAO() {
}
protected Connection getConnection() {
Connection connection = null;
try {

Class.forName("com.mysql.cj.jdbc.Driver");
connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
} catch (SQLException e) {
e.printStackTrace();
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
return connection;
}



public void insertAutor(Autor autor) throws SQLException {
System.out.println(INSERT_Autor_SQL);

try (Connection connection = getConnection();

PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Autor_SQL)) {
preparedStatement.setString(1, autor.getName());
preparedStatement.setString(2, autor.getEmail());
preparedStatement.setString(3, autor.getCountry());
preparedStatement.setString(4, autor.getLibro());

preparedStatement.executeUpdate();
} catch (SQLException e) {
printSQLException(e);
}
}

public Autor selectAutor(int id) {
	Autor autor = null;

try (Connection connection = getConnection();

PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Autor_BY_ID);) {
preparedStatement.setInt(1, id);

ResultSet rs = preparedStatement.executeQuery();

while (rs.next()) {
String name = rs.getString("name");
String email = rs.getString("email");
String country = rs.getString("country");

String libro = rs.getString("libro");
autor = new Autor(id, name, email, country,libro);
}
} catch (SQLException e) {
printSQLException(e);
}
return autor;
}

public List<Autor> selectAllAutor() {
	//crea el array para mostrar los resultados
	List<Autor> autor = new ArrayList<>();
	//Conecta con la bd
	try (Connection connection = getConnection();
	//Prepara la consulta sql
	PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Autor);) {
	//System.out.println(preparedStatement);
	//Ejecuta la consulta y la almacena en un objeto ResultSet
	ResultSet rs = preparedStatement.executeQuery();
	//Recorre el resultado y lo almacena en el objeto users
	while (rs.next()) {
	int id = rs.getInt("id");
	String name = rs.getString("name");
	String email = rs.getString("email");
	String country = rs.getString("country");
	String libro = rs.getString("libro");
	autor.add(new Autor(id, name, email, country,libro));
	}
	} catch (SQLException e) {
	printSQLException(e);
	}
	return autor;
	}

public boolean deleteAutor(int id) throws SQLException {
boolean rowDeleted;
try (Connection connection = getConnection();
PreparedStatement statement = connection.prepareStatement(DELETE_Autor_SQL);) {
	statement.setInt(1, id);
	rowDeleted = statement.executeUpdate() > 0;
	}
	return rowDeleted;
	}

	public boolean updateAutor(Autor autor) throws SQLException {
	boolean rowUpdated;
	try (Connection connection = getConnection();
	PreparedStatement statement = connection.prepareStatement(UPDATE_Autor_SQL);) {
	statement.setString(1, autor.getName());
	statement.setString(2, autor.getEmail());
	statement.setString(3, autor.getCountry());
	statement.setString(4, autor.getLibro());
	statement.setInt(5, autor.getId());
	
	rowUpdated = statement.executeUpdate() > 0;
	}
	return rowUpdated;
	}
	private void printSQLException(SQLException ex) {
	for (Throwable e : ex) {
	if (e instanceof SQLException) {
	e.printStackTrace(System.err);
	System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	System.err.println("Message: " + e.getMessage());
	Throwable t = ex.getCause();
	while (t != null) {
	System.out.println("Cause: " + t);
	t = t.getCause();
	}
	}
	}
	}
	}	
