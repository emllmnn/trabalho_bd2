package br.com.bd.trab.model;

public class Pessoa {
    private String cpf_pessoa;
    private String nm_adotante;
    private String dt_nasc;
    private String end_adotante;
    private String id_ani;
    private String dt_adocao;

    public Pessoa(){

    }
    public String getCpf() {
        return cpf_pessoa;
    }

    public void setCpf(String cpf_pessoa) {
        this.cpf_pessoa = cpf_pessoa;
    }


    public String getNome() {

        return nm_adotante;
    }

    public void setNome(String nm_adotante) {

        this.nm_adotante = nm_adotante;
    }


    public String getDtNasc() {

        return dt_nasc;
    }

    public void setDtNasc(String dt_nasc) {

        this.dt_nasc = dt_nasc;
    }


    public String getEnd() {

        return end_adotante;
    }

    public void setEnd(String end_adotante) {

        this.end_adotante = end_adotante;
    }


    public String getIdAnimal() {

        return id_ani;
    }

    public void setIdAnimal(String id_ani) {

        this.id_ani = id_ani;
    }

    public String getDtAdocao() {

        return dt_adocao;
    }

    public void setDtAdocao(String dt_adocao) {

        this.dt_adocao = dt_adocao;
    }
}
