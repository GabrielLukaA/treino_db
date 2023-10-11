import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TituloDAO extends DefaultDAO<Titulo> {
    @Override
    public void criar(Titulo titulo) {
        setComandoSQL("INSERT INTO titulo values(?,?,?);");
        try (PreparedStatement statement = getConnection().prepareStatement(getComandoSQL())) {
            statement.setInt(1, titulo.getId());
            statement.setInt(2, titulo.getAno());
            statement.setString(3, titulo.getNome());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Titulo converter(ResultSet resultSet) throws SQLException {
        return new Titulo(resultSet);
    }

    public TituloDAO() throws SQLException {
        super("titulo");
    }


}
