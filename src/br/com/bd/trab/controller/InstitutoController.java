package br.com.bd.trab.controller;
import java.util.List;
import br.com.bd.trab.model.Instituto;
import br.com.bd.trab.persistencia.InstitutoDAOImp;
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

public class InstitutoController{
    public String inserir(Instituto ins){
        String sql = "insert into instituto(cnpj,nm_Inst,tp_instituicao,end_Inst,v_doado,dt_doacao, cont_inst) values (?,?,?,?,?,?,?)";
        Connection con = ConnectionFactory.getConnection();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, ins.getCnpj());
            pst.setString(2, ins.getNome());
            pst.setString(3, ins.getTpIns());
            pst.setString(4, ins.getEndInst());
            pst.setBigDecimal(5, ins.getValor());
            pst.setString(6, ins.getDtDoacao());
            pst.setInt(7, ins.getContato());
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
    public String alterar(Instituto ins){
        String sql = "update instituto set nm_Inst=?,tp_instituicao=?,end_Inst=?,v_doado=?,dt_doacao=?,cont_inst=? where cnpj=?";
        Connection con = ConnectionFactory.getConnection();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, ins.getCnpj());
            pst.setString(2, ins.getNome());
            pst.setString(3, ins.getTpIns());
            pst.setString(4, ins.getEndInst());
            pst.setBigDecimal(5, ins.getValor());
            pst.setString(6, ins.getDtDoacao());
            pst.setInt(7, ins.getContato());
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
    public String excluir(Instituto ins){
        String sql = "delete from instituto where cnpj=?";
        Connection con = ConnectionFactory.getConnection();
        try{
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, ins.getCnpj());
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
    public List<Instituto> listarTodos(){
        String sql = "select * from instituto";
        Connection con = ConnectionFactory.getConnection();
        List<Instituto> lista = new ArrayList<>();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs != null){
                while(rs.next()){
                    Instituto ins = new Instituto();
                    ins.setCnpj(rs.getString(1));
                    ins.setNome(rs.getString(2));
                    ins.setTpIns(rs.getString(3));
                    ins.setEndInst(rs.getString(4));
                    ins.setValor(rs.getBigDecimal(5));
                    ins.setDtDoacao(rs.getString(6));
                    ins.setContato(rs.getInt(7));
                    lista.add(ins);
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
    public Instituto pesquisarPorCnpj(String cnpj){
        String sql = "select * from instituto where cnpj=?";
        Connection con = ConnectionFactory.getConnection();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cnpj);
            ResultSet rs = pst.executeQuery();
            if (rs != null){
                while(rs.next()){
                    Instituto ins = new Instituto();
                    ins.setCnpj(rs.getString(1));
                    ins.setNome(rs.getString(2));
                    ins.setTpIns(rs.getString(3));
                    ins.setEndInst(rs.getString(4));
                    ins.setValor(rs.getBigDecimal(5));
                    ins.setDtDoacao(rs.getString(6));
                    ins.setContato(rs.getInt(7));
                    return ins;
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
