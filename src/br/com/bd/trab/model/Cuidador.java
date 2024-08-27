package br.com.bd.trab.model;

public class Cuidador {
    private String id_cuidador;
    private String nm_cuidador;
    private String cpf_cuidador;
    private String tp_sanguineo;
    private String end_cuidador;

    public Cuidador(){

    }
    public String getId() {
        return id_cuidador;
    }

    public void setId(String id_cuidador) {
        this.id_cuidador = id_cuidador;
    }

    // Métodos get e set para nome
    public String getNome() {
        return nm_cuidador;
    }

    public void setNome(String nm_cuidador) {
        this.nm_cuidador = nm_cuidador;
    }

    // Métodos get e set para cpf
    public String getCpf() {
        return cpf_cuidador;
    }

    public void setCpf(String cpf_cuidador) {
        this.cpf_cuidador = cpf_cuidador;
    }

    // Métodos get e set para tp
    public String getTp() {
        return tp_sanguineo;
    }

    public void setTp(String tp_sanguineo) {
        this.tp_sanguineo = tp_sanguineo;
    }

    // Métodos get e set para end
    public String getEnd() {
        return end_cuidador;
    }

    public void setEnd(String end_cuidador) {
        this.end_cuidador = end_cuidador;
    }
}
