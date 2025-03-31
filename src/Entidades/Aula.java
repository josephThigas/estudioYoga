package Entidades;

public class Aula {
    private int id;
    private String horarioEntrada;
    private String horarioSaida;
    private String professor;
    private String dia;
    private String modalidade;

    public Aula() {
    }

    public Aula(int id, String horarioEntrada, String horarioSaida, String professor, String dia, String modalidade) {
        this.id = id;
        this.horarioEntrada = horarioEntrada;
        this.horarioSaida = horarioSaida;
        this.professor = professor;
        this.dia = dia;
        this.modalidade = modalidade;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHorarioEntrada() {
        return this.horarioEntrada;
    }

    public void setHorarioEntrada(String horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public String getHorarioSaida() {
        return this.horarioSaida;
    }

    public void setHorarioSaida(String horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public String getProfessor() {
        return this.professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getDia() {
        return this.dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getModalidade() {
        return this.modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }



}
