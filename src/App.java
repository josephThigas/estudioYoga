import java.util.Scanner;

import Entidades.Aluno;
// import Entidades.Aula;
// import Entidades.Instrutor;
import Repositorio.AlunoRepository;

public class App {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int option;

		do {
			System.out.println("=== Menu Interativo ===");
			System.out.println("1. Cadastrar Aluno");
			System.out.println("2. Remover Aluno");
			System.out.println("3. Alterar Aluno");
			System.out.println("4. Listar Alunos");
			System.out.println("0. Sair");
			System.out.print("Escolha uma opção: ");
			option = scanner.nextInt();
			scanner.nextLine();

			switch (option) {
				case 1:
					createAluno();
					break;
				case 2:
					// remover aluno
					break;
				case 3:
					updateAluno();
					break;
				case 4:
					AlunoRepository.listarAlunos();
					break;
				case 0:
					System.out.println("Encerrando o programa...");
					break;
				default:
					System.out.println("Opção inválida. Tente novamente.");
			}
		} while (option != 5);

		scanner.close();
	}

	public static void createAluno() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Opção de cadastro de aluno selecionada.");
		System.out.print("Digite o nome do aluno: ");
		String nome = scanner.nextLine();
		System.out.print("Digite o CPF do aluno: ");
		String cpf = scanner.nextLine();
		System.out.print("Digite a Data de Nascimento do aluno: ");
		String data = scanner.nextLine();
		System.out.print("Digite o horário de entrada do aluno: ");
		String horarioEntrada = scanner.nextLine();
		System.out.print("Digite o horário de saída do aluno: ");
		String horarioSaida = scanner.nextLine();
		System.out.print("Digite o número de matrícula do aluno: ");
		String numeroMatricula = scanner.nextLine();
		System.out.print("Digite o email do aluno: ");
		String email = scanner.nextLine();
		Aluno aluno = new Aluno(nome, data, cpf);
		aluno.setHorarioEntrada(horarioEntrada);
		aluno.setHorarioSaida(horarioSaida);
		aluno.setNumeroMatricula(numeroMatricula);
		aluno.setEmail(email);
		aluno.setStatusPagamento(true);
		System.out.println("Aluno cadastrado com sucesso: " + aluno);
	}

	public static void updateAluno() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Opção de atualização de aluno selecionada.");
		System.out.print("Digite o CPF do aluno a ser atualizado: ");
		String cpf = scanner.nextLine();
		if (cpf.isEmpty()) {
			System.out.println("CPF não pode ser vazio.");
			return;
		}
		for (Aluno aluno : AlunoRepository.listarAlunos()) {
			if (aluno.getCPF().equals(cpf)) {
				System.out.print("Digite o novo nome do aluno: ");
				String nome = scanner.nextLine();
				System.out.print("Digite a nova Data de Nascimento do aluno: ");
				String data = scanner.nextLine();
				System.out.print("Digite o novo horário de entrada do aluno: ");
				String horarioEntrada = scanner.nextLine();
				System.out.print("Digite o novo horário de saída do aluno: ");
				String horarioSaida = scanner.nextLine();
				System.out.print("Digite o novo número de matrícula do aluno: ");
				String numeroMatricula = scanner.nextLine();
				System.out.print("Digite o novo email do aluno: ");
				String email = scanner.nextLine();
				aluno.setNome(nome);
				aluno.setData(data);
				aluno.setHorarioEntrada(horarioEntrada);
				aluno.setHorarioSaida(horarioSaida);
				aluno.setNumeroMatricula(numeroMatricula);
				aluno.setEmail(email);
			}
		}
		System.out.println("Aluno atualizado com sucesso.");
	}
}
