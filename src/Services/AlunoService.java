package Services;

import java.util.Scanner;
import Entidades.Aluno;
import Entidades.Vaga;
import Repositorio.AlunoRepository;
import Repositorio.VagaRepository;
import Repositorio.InstrutorRepository;

public class AlunoService {
	private static AlunoRepository alunoRepository = new AlunoRepository();
	private static VagaRepository vagaRepository = new VagaRepository();
	private static InstrutorRepository instrutorRepository = new InstrutorRepository();

	public static void manageAlunos(Scanner scanner) {
		int option;
		do {
			System.out.println("=== Menu Alunos ===");
			System.out.println("1. Cadastrar Aluno");
			System.out.println("2. Remover Aluno");
			System.out.println("3. Alterar Aluno");
			System.out.println("4. Listar Alunos");
			System.out.println("5. Voltar");
			System.out.print("Escolha uma opção: ");
			option = scanner.nextInt();
			scanner.nextLine();

			switch (option) {
				case 1:
					createAluno(scanner);
					break;
				case 2:
					removeAluno(scanner);
					break;
				case 3:
					updateAluno(scanner);
					break;
				case 4:
					listAlunos();
					break;
				case 5:
					System.out.println("Voltando ao menu principal...");
					break;
				default:
					System.out.println("Opção inválida. Tente novamente.");
			}
		} while (option != 5);
	}

	private static void createAluno(Scanner scanner) {
		if (vagaRepository.getAvailableVagasCount() == 0) {
			System.out.println("Não é possível cadastrar o aluno. Todas as vagas estão ocupadas.");
			System.out.println("Vagas ocupadas por " + alunoRepository.getAlunosCount() + " alunos e " 
				+ instrutorRepository.getAllInstrutores().size() + " instrutores.");
			return;
		}

		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		System.out.print("Data de nascimento: ");
		String data = scanner.nextLine();
		System.out.print("CPF: ");
		String cpf = scanner.nextLine();
		System.out.print("Endereço: ");
		String endereco = scanner.nextLine();
		System.out.print("Gênero: ");
		String genero = scanner.nextLine();
		System.out.print("Horário de entrada: ");
		String horarioEntrada = scanner.nextLine();
		System.out.print("Horário de saída: ");
		String horarioSaida = scanner.nextLine();
		System.out.print("Número de matrícula: ");
		String numeroMatricula = scanner.nextLine();
		System.out.print("Email: ");
		String email = scanner.nextLine();
		System.out.print("Status de pagamento (true/false): ");
		boolean statusPagamento = scanner.nextBoolean();
		scanner.nextLine();

		Aluno aluno = new Aluno(nome, data, cpf);
		aluno.setEndereco(endereco);
		aluno.setGenero(genero);
		aluno.setHorarioEntrada(horarioEntrada);
		aluno.setHorarioSaida(horarioSaida);
		aluno.setNumeroMatricula(numeroMatricula);
		aluno.setEmail(email);
		aluno.setStatusPagamento(statusPagamento);

		Vaga vaga = vagaRepository.ocuparVaga();
		if (vaga != null) {
			System.out.println("Vaga ocupada: " + vaga);
			alunoRepository.adicionarAluno(aluno);
			System.out.println("Aluno cadastrado com sucesso!");
		} else {
			System.out.println("Não foi possível cadastrar o aluno. Todas as vagas estão ocupadas.");
		}
	}

	private static void removeAluno(Scanner scanner) {
		System.out.print("CPF do aluno a ser removido: ");
		String cpf = scanner.nextLine();
		Aluno aluno = alunoRepository.buscarAlunoPorId(cpf);
		if (aluno != null) {
			AlunoRepository.removerAluno(cpf);
			System.out.println("Aluno " + aluno.getNome() + " foi removido com sucesso!");
			Vaga vaga = new Vaga(0);
			vagaRepository.liberarVaga(vaga);
			System.out.println("Vaga liberada.");
		} else {
			System.out.println("Aluno não encontrado!");
		}
	}

	private static void updateAluno(Scanner scanner) {
		System.out.print("CPF do aluno a ser atualizado: ");
		String cpf = scanner.nextLine();
		Aluno alunoExistente = alunoRepository.buscarAlunoPorId(cpf);

		if (alunoExistente != null) {
			System.out.println("""
            Deseja atualizar:
            1. Pagamento
            2. Informações do aluno
                    """);
			int escolha = scanner.nextInt();
			scanner.nextLine();

			if (escolha == 1) {
				System.out.print("Novo status de pagamento (true/false): ");
				boolean statusPagamento = scanner.nextBoolean();
				scanner.nextLine();
				alunoExistente.setStatusPagamento(statusPagamento);
			} else if (escolha == 2) {
				System.out.print("Novo nome: ");
				String nome = scanner.nextLine();
				System.out.print("Novo endereço: ");
				String endereco = scanner.nextLine();
				System.out.print("Novo gênero: ");
				String genero = scanner.nextLine();
				System.out.print("Novo horário de entrada: ");
				String horarioEntrada = scanner.nextLine();
				System.out.print("Novo horário de saída: ");
				String horarioSaida = scanner.nextLine();
				System.out.print("Novo número de matrícula: ");
				String numeroMatricula = scanner.nextLine();
				System.out.print("Novo email: ");
				String email = scanner.nextLine();

				alunoExistente.setNome(nome);
				alunoExistente.setEndereco(endereco);
				alunoExistente.setGenero(genero);
				alunoExistente.setHorarioEntrada(horarioEntrada);
				alunoExistente.setHorarioSaida(horarioSaida);
				alunoExistente.setNumeroMatricula(numeroMatricula);
				alunoExistente.setEmail(email);
			} else {
				System.out.println("Opção inválida!");
			}

			AlunoRepository.atualizarAluno(cpf, alunoExistente);
		} else {
			System.out.println("Aluno não encontrado!");
		}
	}

	private static void listAlunos() {
		AlunoRepository.listarAlunos().forEach(System.out::println);
	}
}
