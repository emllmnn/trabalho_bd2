package br.com.bd.trab.controller;
import java.util.List;
import br.com.bd.trab.model.Cuidador;
import br.com.bd.trab.persistencia.CuidadorDAOImp;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import br.com.bd.trab.model.Animal;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.com.bd.trab.persistencia.ConnectionFactory;

public class CuidadorController {
    public String inserir(Cuidador cui){
        String sql = "insert into cuidador(id_cuidador,nm_cuidador,cpf_cuidador,tp_sanguineo,end_cuidador) values (?,?,?,?,?)";
        Connection con = ConnectionFactory.getConnection();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cui.getId());
            pst.setString(2, cui.getNome());
            pst.setString(3, cui.getCpf());
            pst.setString(4, cui.getTp());
            pst.setString(5, cui.getEnd());
            int res = pst.executeUpdate();

            if(res > 0){
                return "Inserido com sucesso!!!";
            }else{
                return "Erro ao inserir.";
            }
        }catch(SQLException e){
            return e.getMessage();
        }finally{
            ConnectionFactory.close(con);
        }
    }
    public String alterar(Cuidador cui){
        String sql = "update cuidador set id_cuidador=?,nm_cuidador=?,cpf_cuidador=?,tp_sanguineo=?,end_cuidador=? where id_cuidador=?";
        Connection con = ConnectionFactory.getConnection();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cui.getId());
            pst.setString(2, cui.getNome());
            pst.setString(3, cui.getCpf());
            pst.setString(4, cui.getTp());
            pst.setString(5, cui.getEnd());
            int res = pst.executeUpdate();

            if(res > 0){
                return "Alterado com sucesso!!!";
            }else{
                return "Erro ao alterar!";
            }
        }catch(SQLException e){
            return e.getMessage();
        }finally{
            ConnectionFactory.close(con);
        }
    }
    public String excluir(Cuidador cui){
        String sql = "delete from cuidador where id_cuidador=?";
        Connection con = ConnectionFactory.getConnection();
        try{
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, cui.getId());
            int res = pst.executeUpdate();

            if(res>0){
                return "Excluído com sucesso.";
            }else{
                return "Erro ao excluir.";
            }
        }catch(SQLException e){
            return e.getMessage();
        }finally{
            ConnectionFactory.close(con);
        }
    }
    public List<Cuidador> listarTodos(){
        String sql = "select * from cuidador";
        Connection con = ConnectionFactory.getConnection();
        List<Cuidador> lista = new ArrayList<>();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs != null){
                while(rs.next()){
                    Cuidador cui = new Cuidador();
                    cui.setId(rs.getString("id_cuidador"));
                    cui.setNome(rs.getString("nm_cuidador"));
                    cui.setCpf(rs.getString("cpf_cuidador"));
                    cui.setTp(rs.getString("tp"));
                    cui.setEnd(rs.getString("end_cuidador"));
                    lista.add(cui);
                }
                return lista;
            }else{
                return null;
            }
        }catch(SQLException e){
            return null;
        }finally{
            ConnectionFactory.close(con);
        }
    }
    public Cuidador pesquisarPorId(String id_cuidador){
        String sql = "select * from cuidador where id_cuidador=?";
        Connection con = ConnectionFactory.getConnection();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, id_cuidador);
            ResultSet rs = pst.executeQuery();
            if (rs != null){
                while(rs.next()){
                    Cuidador cui = new Cuidador();
                    cui.setId(rs.getString("id_cuidador"));
                    cui.setNome(rs.getString("nm_cuidador"));
                    cui.setCpf(rs.getString("cpf_cuidador"));
                    cui.setTp(rs.getString("tp"));
                    cui.setEnd(rs.getString("end_cuidador"));
                    return cui;
                }
                //return lista;
            }else{
                return null;
            }
        }catch(SQLException e){
            return null;
        }finally{
            ConnectionFactory.close(con);
        }
        return null;
    }
}
