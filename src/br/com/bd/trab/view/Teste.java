package br.com.bd.trab.view;
import java.sql.Connection;
import java.util.List;
import java.math.BigDecimal;
import br.com.bd.trab.persistencia.ConnectionFactory;
import br.com.bd.trab.model.Animal;
import br.com.bd.trab.model.Instituto;
import br.com.bd.trab.model.Cuidador;
import br.com.bd.trab.model.Pessoa;
import br.com.bd.trab.controller.AnimalController;
import br.com.bd.trab.controller.PessoaController;
import br.com.bd.trab.controller.InstitutoController;
import br.com.bd.trab.controller.CuidadorController;
import br.com.bd.trab.persistencia.AnimalDAO;
import br.com.bd.trab.persistencia.AnimalDAOImp;
import br.com.bd.trab.persistencia.InstitutoDAO;

public class Teste {
    public static void main(String[] args) {
        Connection con = ConnectionFactory.getConnection();
        if (con != null) {
            System.out.println("ok");
            ConnectionFactory.close(con);
        }

        Animal ani = new Animal();
        //AnimalController controller = new AnimalController();

        Cuidador cui = new Cuidador();
        //CuidadorController controller = new CuidadorController();

        Instituto ins = new Instituto();
        //InstitutoController controller = new InstitutoController();

        Pessoa pe = new Pessoa();
        PessoaController controller = new PessoaController();


        System.out.println(controller.inserir(pe));

    }
}
