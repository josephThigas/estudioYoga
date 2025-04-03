package Entidades;

public class Vaga {
    private int id;
    private boolean ocupada;

    public Vaga(int id) {
        this.id = id;
        this.ocupada = false;
    }

    public int getId() {
        return id;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void ocupar() {
        this.ocupada = true;
    }

    public void liberar() {
        this.ocupada = false;
    }

    @Override
    public String toString() {
        return "Vaga ID: " + id + ", Ocupada: " + ocupada;
    }
}
