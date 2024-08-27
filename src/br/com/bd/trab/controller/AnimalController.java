package br.com.bd.trab.controller;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import br.com.bd.trab.model.Animal;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.com.bd.trab.persistencia.ConnectionFactory;
import br.com.bd.trab.model.Animal;

public class AnimalController {
    public String inserir(Animal ani){
        String sql = "insert into animal(id_animal,id_adocao,especie,raca,sx_animal,status,idade_animal,dt_resgate,dt_adocao) values (?,?,?,?,?,?,?,?,?)";
        Connection con = ConnectionFactory.getConnection();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, ani.getId());
            pst.setString(2, ani.getIdAdoc());
            pst.setString(3, ani.getEspecie());
            pst.setString(4, ani.getRaca());
            pst.setString(5, ani.getSexo());
            pst.setString(6, ani.getStatus());
            pst.setInt(7, ani.getIdade());
            pst.setString(8, ani.getDtResgate());
            pst.setString(9, ani.getDtAdocao());
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
    public String alterar(Animal ani){
        String sql = "update animal set id_adocao=?,especie=?,raca=?,sx_animal=?,status=?,idade_animal=?,dt_resgate=?,dt_adocao=? where id_animal=?";
        Connection con = ConnectionFactory.getConnection();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, ani.getId());
            pst.setString(2, ani.getIdAdoc());
            pst.setString(3, ani.getEspecie());
            pst.setString(4, ani.getRaca());
            pst.setString(5, ani.getSexo());
            pst.setString(6, ani.getStatus());
            pst.setInt(7, ani.getIdade());
            pst.setString(8, ani.getDtResgate());
            pst.setString(9, ani.getDtAdocao());
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
    public String excluir(Animal ani){
        String sql = "delete from animal where id_animal=?";
        Connection con = ConnectionFactory.getConnection();
        try{
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, ani.getId());
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
    public List<Animal> listarTodos(){
        String sql = "select * from animal";
        Connection con = ConnectionFactory.getConnection();
        List<Animal> lista = new ArrayList<>();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs != null){
                while(rs.next()){
                    Animal ani = new Animal();
                    ani.setId(rs.getString("id_animal"));
                    ani.setIdAdoc(rs.getString("id_adocao"));
                    ani.setEspecie(rs.getString("especie"));
                    ani.setRaca(rs.getString("raca"));
                    ani.setSexo(rs.getString("sx_animal"));
                    ani.setStatus(rs.getString("status"));
                    ani.setIdade(rs.getInt("idade_animal"));
                    ani.setDtResgate(rs.getString("dt_resgate"));
                    ani.setDtAdocao(rs.getString("dt_adocao"));
                    lista.add(ani);
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
    public Animal pesquisarPorId(String id_animal){
        String sql = "select * from animal where id_animal=?";
        Connection con = ConnectionFactory.getConnection();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, id_animal);
            ResultSet rs = pst.executeQuery();
            if (rs != null){
                while(rs.next()) {
                    Animal ani = new Animal();
                    ani.setId(rs.getString("id_animal"));
                    ani.setIdAdoc(rs.getString("id_adocao"));
                    ani.setEspecie(rs.getString("especie"));
                    ani.setRaca(rs.getString("raca"));
                    ani.setSexo(rs.getString("sx_animal"));
                    ani.setStatus(rs.getString("status"));
                    ani.setIdade(rs.getInt("idade_animal"));
                    ani.setDtResgate(rs.getString("dt_resgate"));
                    ani.setDtAdocao(rs.getString("dt_adocao"));
                    return ani;
                }
            }else{
                return null;
            }
        }catch(SQLException e){
            return null;
        }finally {
            ConnectionFactory.close(con);
        }
        return null;
    }

}
