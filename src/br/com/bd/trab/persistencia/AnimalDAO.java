package br.com.bd.trab.persistencia;
import java.util.List;
import br.com.bd.trab.model.Animal;

public interface AnimalDAO {
    public String inserir (Animal ani);
    public String alterar (Animal ani);
    public String excluir (Animal ani);
    public List<Animal> listarTodos();
    public Animal pesquisarPorId(String id);
}
