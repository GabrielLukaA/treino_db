import java.sql.ResultSet;
import java.sql.SQLException;

public class Titulo {
    private int id;
    private int ano;
    private String nome;

    public Titulo(int id, String nome, int ano) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
    }

    public Titulo(int id_titulo) {
        this.id = id_titulo;
    }

    public Titulo(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.nome = resultSet.getString("nome");
        this.ano = resultSet.getInt("ano");
    }

    public int getId() {
        return id;
    }

    public int getAno() {
        return ano;
    }

    public String getNome() {
        return nome;
    }
}