import java.sql.ResultSet;
import java.sql.SQLException;

public class Jogador {
    private int id;
    private String nome;
    private int idade;
    private Titulo titulo;

    public Jogador(int id, String nome, int idade, Titulo titulo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.titulo = titulo;
    }

    public Jogador(int id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public Jogador(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.nome = resultSet.getString("nome");
        this.idade = resultSet.getInt("idade");
        int idTitulo = resultSet.getInt("id_titulo");
        if (idTitulo!=0){
            this.titulo = new Titulo(idTitulo);
        }
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Titulo getTitulo() {
        return titulo;
    }
}
