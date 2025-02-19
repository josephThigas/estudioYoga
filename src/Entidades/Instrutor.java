package Entidades;

public class Instrutor extends Pessoa {
    private Pessoa pessoa;
    private double salario;
    private String CRM;
    private String cargoHorario;
    private String matriculaProfessor;
    private String especializacao;

    public Instrutor() {
    }

    public Instrutor(String nome, String data, String CPF, String endereco, String genero) {
        super(nome, data, CPF, endereco, genero);
    }
    
    public Instrutor(double salario, String CRM, String cargoHorario, String matriculaProfessor,
            String especializacao) {
        this.salario = salario;
        this.CRM = CRM;
        this.cargoHorario = cargoHorario;
        this.matriculaProfessor = matriculaProfessor;
        this.especializacao = especializacao;
    }

    @Override
    public void apresentar() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("Data de nascimento: " + this.getData());
        System.out.println("CPF: " + this.getCPF());
        System.out.println("Endereço: " + this.getEndereco());
        System.out.println("Gênero: " + this.getGenero());
        System.out.println("Salário: " + this.salario);
        System.out.println("CRM: " + this.CRM);
        System.out.println("Cargo e horário: " + this.cargoHorario);
        System.out.println("Matrícula do professor: " + this.matriculaProfessor);
        System.out.println("Especialização: " + this.especializacao);
    }

    @Override
    public void exibirIdentificacao() {
        System.out.println("Instrutor: " + getNome() + ", Especialização: " + getEspecializacao());
    }

    public Pessoa getPessoa() {
        return this.pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCRM() {
        return this.CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getCargoHorario() {
        return this.cargoHorario;
    }

    public void setCargoHorario(String cargoHorario) {
        this.cargoHorario = cargoHorario;
    }

    public String getMatriculaProfessor() {
        return this.matriculaProfessor;
    }

    public void setMatriculaProfessor(String matriculaProfessor) {
        this.matriculaProfessor = matriculaProfessor;
    }

    public String getEspecializacao() {
        return this.especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }


}
