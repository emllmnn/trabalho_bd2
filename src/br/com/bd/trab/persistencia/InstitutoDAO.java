package br.com.bd.trab.persistencia;
import java.util.List;
import br.com.bd.trab.model.Instituto;

public interface InstitutoDAO {
    public String inserir (Instituto ins);
    public String alterar (Instituto ins);
    public String excluir (Instituto ins);
    public List<Instituto> listarTodos();
    public Instituto pesquisarPorId(String id);
}
