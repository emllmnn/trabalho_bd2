package br.com.bd.trab.persistencia;
import java.util.List;
import br.com.bd.trab.model.Pessoa;

public interface PessoaDAO {
    public String inserir (Pessoa pe);
    public String alterar (Pessoa pe);
    public String excluir (Pessoa pe);
    public List<Pessoa> listarTodos();
    public Pessoa pesquisarPorId(String id);
}
