package br.com.bd.trab.persistencia;
import java.util.List;
import br.com.bd.trab.model.Cuidador;

public interface CuidadorDAO {
    public String inserir (Cuidador cui);
    public String alterar (Cuidador cui);
    public String excluir (Cuidador cui);
    public List<Cuidador> listarTodos();
    public Cuidador pesquisarPorId(String id);
}
