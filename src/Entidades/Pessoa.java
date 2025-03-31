package Entidades;

import Services.IPessoa;

public abstract class Pessoa implements IPessoa {
    private String nome;
    private String data;
    private String CPF;
    private String endereco;
    private String genero;

    public Pessoa(String nome, String data, String CPF, String endereco, String genero) {
        this.nome = nome;
        this.data = data;
        this.CPF = CPF;
        this.endereco = endereco;
        this.genero = genero;
    }

    public Pessoa() {
    }

    public Pessoa(String nome, String data, String CPF) {
        this.nome = nome;
        this.data = data;
        this.CPF = CPF;
    }

    public void setNome(String N) {
        this.nome = N;
    }

    public String getNome() {
        return this.nome;
    }

    public void setData(String novodata) {
        this.data = novodata;
    }

    public String getData() {
        return this.data;
    }

    public void setCPF(String novoCPF) {
        this.CPF = novoCPF;
    }

    public String getCPF() {
        return this.CPF;
    }

    public void setEndereco(String novoendereco) {
        this.endereco = novoendereco;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setGenero(String novogenero) {
        this.genero = novogenero;
    }

    public String getGenero() {
        return this.genero;
    }
    // Método abstrato
    public abstract void apresentar();

    public abstract void exibirIdentificacao();
}