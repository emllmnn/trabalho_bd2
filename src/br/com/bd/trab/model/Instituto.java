package br.com.bd.trab.model;
import java.time.LocalDate;
import java.math.BigDecimal;

public class Instituto {
    private String cnpj;
    private String nm_Inst;
    private String tp_instituicao;
    private String end_Inst;
    private BigDecimal v_doado;
    private String dt_doacao;
    private Integer cont_inst;
    public Instituto(){

    }
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    public String getNome() {
        return nm_Inst;
    }

    public void setNome(String nm_Inst) {
        this.nm_Inst = nm_Inst;
    }


    public String getTpIns() {
        return tp_instituicao;
    }

    public void setTpIns(String tp_instituicao) {
        this.tp_instituicao = tp_instituicao;
    }


    public String getEndInst() {
        return end_Inst;
    }

    public void setEndInst(String end_Inst) {
        this.end_Inst = end_Inst;
    }


    public BigDecimal getValor() {
        return v_doado;
    }

    public void setValor(BigDecimal v_doado) {
        this.v_doado = v_doado;
    }


    public String getDtDoacao() {
        return dt_doacao;
    }

    public void setDtDoacao(String dt_doacao) {
        this.dt_doacao = dt_doacao;
    }


    public Integer getContato() {
        return cont_inst;
    }

    public void setContato(Integer cont_inst) {
        this.cont_inst = cont_inst;
    }
}
