import java.util.*;

public interface ICRD<T> extends AutoCloseable {
    void criar(T obj);
    void deletar(Integer id);
    Set<T> buscarTodos();
    T buscarUm(Integer id);
}
