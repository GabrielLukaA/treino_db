import java.sql.SQLException;
import java.util.NoSuchElementException;

public class Executavel {



    public static void main(String[] args)  {

        Jogador jogador = new Jogador(2,"Luka",17);

        try (ICRD<Jogador> crdJogador =
                     new JogadorDAO();
             ICRD<Titulo> crdTitulo =
                     new TituloDAO())  {

            try {
                crdTitulo.buscarUm(jogador.getTitulo().getId());
            } catch (NoSuchElementException e) {
                crdTitulo.criar(jogador.getTitulo());
            } catch (NullPointerException ignore){

            }
            crdJogador.criar(jogador);

        } catch (SQLException e){
            throw new RuntimeException(e);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }


}
