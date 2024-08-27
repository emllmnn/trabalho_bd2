package br.com.bd.trab.model;
import java.time.LocalDate;

public class Animal {
    private String id_animal;
    private String id_adocao;
    private String especie;
    private String raca;
    private String sx_animal;
    private String status;
    private Integer idade_animal;
    private String dt_resgate;
    private String dt_adocao;

    public Animal(){

    }
    public String getId() {
        return id_animal;
    }

    public void setId(String id_animal) {
        this.id_animal = id_animal;
    }

    public String getIdAdoc() {
        return id_adocao;
    }

    public void setIdAdoc(String id_adocao) {
        this.id_adocao = id_adocao;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getSexo() {
        return sx_animal;
    }

    public void setSexo(String sx_animal) {
        this.sx_animal = sx_animal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getIdade() {
        return idade_animal;
    }

    public void setIdade(Integer idade_animal) {
        this.idade_animal = idade_animal;
    }

    public String getDtResgate() {

        return dt_resgate;
    }

    public void setDtResgate(String dt_resgate) {
        this.dt_resgate = dt_resgate;
    }

    public String getDtAdocao() {
        return dt_adocao;
    }

    public void setDtAdocao(String dt_adocao) {
        this.dt_adocao = dt_adocao;
    }
}
