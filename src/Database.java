import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String URL_BANCO = "jdbc:mysql://localhost:3306/db_treino";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL_BANCO, USER, PASSWORD);
    }
}
