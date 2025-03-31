package Entidades;

public class Aluno extends Pessoa {
    private Pessoa pessoa;
    private String horarioEntrada;
    private String horarioSaida;
    private String numeroMatricula;
    private String email;
    private Boolean statusPagamento;

    @Override
    public String toString() {
        return "Nome:" + this.getNome() + " Matrícula: " + this.numeroMatricula + " Email: " + this.email;
    }

    public Aluno(String nome, String data, String CPF) {
        super(nome, data, CPF);
    }
    public Aluno(String horarioEntrada, String horarioSaida, String numeroMatricula, String email, Boolean statusPagamento) {
        this.horarioEntrada = horarioEntrada;
        this.horarioSaida = horarioSaida;
        this.numeroMatricula = numeroMatricula;
        this.email = email;
        this.statusPagamento = statusPagamento;
    }

    public Aluno() {
    }

    @Override
    public void apresentar() {
        System.out.println("Nome: " + getNome());
        System.out.println("Data de nascimento: " + getData());
        System.out.println("CPF: " + getCPF());
        System.out.println("Endereço: " + getEndereco());
        System.out.println("Gênero: " + getGenero());
        System.out.println("Horário de entrada: " + this.horarioEntrada);
        System.out.println("Horário de saída: " + this.horarioSaida);
        System.out.println("Número de matrícula: " + this.numeroMatricula);
        System.out.println("Email: " + this.email);
        System.out.println("Status de pagamento: " + this.statusPagamento);
    }

    @Override
    public void exibirIdentificacao() {
        System.out.println("Aluno: " + getNome() + ", Matrícula: " + getNumeroMatricula());
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

    public String getNumeroMatricula() {
        return this.numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean isStatusPagamento() {
        return this.statusPagamento;
    }

    public Boolean getStatusPagamento() {
        return this.statusPagamento;
    }

    public void setStatusPagamento(Boolean statusPagamento) {

        this.statusPagamento = statusPagamento;
    }

    public Pessoa getPessoa() {
        return this.pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
