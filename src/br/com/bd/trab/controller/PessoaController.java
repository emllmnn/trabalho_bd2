package br.com.bd.trab.controller;
import java.util.List;
import br.com.bd.trab.model.Cuidador;
import br.com.bd.trab.persistencia.CuidadorDAOImp;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import br.com.bd.trab.model.Pessoa;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.com.bd.trab.persistencia.ConnectionFactory;

public class PessoaController {
    public String inserir(Pessoa pe){
        String sql = "insert into pessoa(cpf_pessoa,nm_adotante,dt_nasc,end_adotante,id_ani,dt_adocao) values (?,?,?,?,?,?)";
        Connection con = ConnectionFactory.getConnection();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, pe.getCpf());
            pst.setString(2, pe.getNome());
            pst.setObject(3, pe.getDtNasc());
            pst.setString(4, pe.getEnd());
            pst.setString(5, pe.getIdAnimal());
            pst.setObject(6, pe.getDtAdocao());
            int res = pst.executeUpdate();

            if(res > 0){
                return "Inserido com sucesso!";
            }else{
                return "Erro ao inserir.";
            }
        }catch(SQLException e){
            return e.getMessage();
        }finally{
            ConnectionFactory.close(con);
        }
    }
    public String alterar(Pessoa pe){
        String sql = "update pessoa set nm_adotante=?,dt_nasc=?,end_adotante=?,id_ani=?,dt_adocao=? where cpf_pessoa=?";
        Connection con = ConnectionFactory.getConnection();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, pe.getCpf());
            pst.setString(2, pe.getNome());
            pst.setObject(3, pe.getDtNasc());
            pst.setString(4, pe.getEnd());
            pst.setString(5, pe.getIdAnimal());
            pst.setObject(6, pe.getDtAdocao());
            int res = pst.executeUpdate();

            if(res > 0){
                return "Alterado com sucesso!";
            }else{
                return "Erro ao alterar.";
            }
        }catch(SQLException e){
            return e.getMessage();
        }finally{
            ConnectionFactory.close(con);
        }
    }
    public String excluir(Pessoa pe){
        String sql = "delete from pessoa where cpf_pessoa=?";
        Connection con = ConnectionFactory.getConnection();
        try{
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, pe.getCpf());
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
    public List<Pessoa> listarTodos(){
        String sql = "select * from pessoa";
        Connection con = ConnectionFactory.getConnection();
        List<Pessoa> lista = new ArrayList<>();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs != null){
                while(rs.next()){
                    Pessoa pe = new Pessoa();
                    pe.setCpf(rs.getString(1));
                    pe.setNome(rs.getString(2));
                    pe.setDtNasc(rs.getString(3));
                    pe.setEnd(rs.getString(4));
                    pe.setIdAnimal(rs.getString(5));
                    pe.setDtAdocao(rs.getString(6));

                    lista.add(pe);
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
    public Pessoa pesquisarPorCpf(String cpf_pessoa){
        String sql = "select * from pessoa where cpf_pessoa=?";
        Connection con = ConnectionFactory.getConnection();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cpf_pessoa);
            ResultSet rs = pst.executeQuery();
            if (rs != null){
                while(rs.next()){
                    Pessoa pe = new Pessoa();
                    pe.setCpf(rs.getString(1));
                    pe.setNome(rs.getString(2));
                    pe.setDtNasc(rs.getString(3));
                    pe.setEnd(rs.getString(4));
                    pe.setIdAnimal(rs.getString(5));
                    pe.setDtAdocao(rs.getString(6));
                    return pe;
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
