import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class DefaultDAO<T> implements ICRD<T> {
    private String comandoSQL;
    private Connection connection;
    private String tabela;

    public DefaultDAO(String tabela) throws SQLException {
        this.connection = Database.conectar();
        this.tabela = tabela;
    }


    @Override
    public void criar(T obj) {

    }

    public T buscarUm(Integer id) {
        comandoSQL = "SELECT * FROM " + tabela + " where id=?";
        try (PreparedStatement statement = connection.prepareStatement(comandoSQL)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return converter(resultSet);
            }
            throw new NoSuchElementException();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletar(Integer id) {
        comandoSQL = "DELETE FROM " + tabela + " where id=?";
        try (PreparedStatement statement = connection.prepareStatement(comandoSQL)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<T> buscarTodos() {
        comandoSQL = "SELECT * FROM " + tabela + ";";
        try (PreparedStatement statement = connection.prepareStatement(comandoSQL)) {
            ResultSet resultSet = statement.executeQuery();
            Set<T> lista = new HashSet<>();
            while (resultSet.next()) {
                lista.add(converter(resultSet));
            }

            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract T converter(ResultSet resultSet) throws SQLException;

    @Override
    public void close() throws Exception {
        this.connection.close();
    }

    public String getComandoSQL() {
        return comandoSQL;
    }

    public void setComandoSQL(String comandoSQL) {
        this.comandoSQL = comandoSQL;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }


}
