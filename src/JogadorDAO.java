import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JogadorDAO extends DefaultDAO<Jogador> {

    @Override
    public void criar(Jogador jogador) {
        setComandoSQL("INSERT INTO jogador values(?,?,?,?);");
        try (PreparedStatement statement = getConnection().prepareStatement(getComandoSQL())) {
            statement.setInt(1, jogador.getId());
            statement.setString(2, jogador.getNome());
            statement.setInt(3, jogador.getIdade());
            try {
                statement.setInt(4, jogador.getTitulo().getId());
            } catch (NullPointerException e) {
                statement.setNull(4, 0);
            }
            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Jogador converter(ResultSet resultSet) throws SQLException {
        return new Jogador(resultSet);
    }

    public JogadorDAO() throws SQLException {
        super("jogador");
    }


}
