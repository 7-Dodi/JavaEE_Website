package br.com.JavaWeb.entities;

public class Vaccination {
    private int id;
    private int idPaciente;
    private String nomeVaccine;
    private String data;
    private String lote;
    private String medico;

    public int getIdPaciente() {
        return idPaciente;
    }
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    public String getNomeVaccine() {
        return nomeVaccine;
    }
    public void setNomeVaccine(String nomeVaccine) {
        this.nomeVaccine = nomeVaccine;
    }
    
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    
    public String getLote() {
        return lote;
    }
    public void setLote(String lote) {
        this.lote = lote;
    }
    public String getMedico() {
        return medico;
    }
    public void setMedico(String medico) {
        this.medico = medico;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
