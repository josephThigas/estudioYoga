package Services;

import java.util.Scanner;
import Entidades.Instrutor;
import Entidades.Vaga;
import Repositorio.InstrutorRepository;
import Repositorio.VagaRepository;
import Repositorio.AlunoRepository;

public class InstrutorService {
	private static InstrutorRepository instrutorRepository = new InstrutorRepository();
	private static VagaRepository vagaRepository = new VagaRepository();
	private static AlunoRepository alunoRepository = new AlunoRepository();

	public static void manageInstrutores(Scanner scanner) {
		int option;
		do {
			System.out.println("=== Menu Instrutores ===");
			System.out.println("1. Cadastrar Instrutor");
			System.out.println("2. Remover Instrutor");
			System.out.println("3. Alterar Instrutor");
			System.out.println("4. Listar Instrutores");
			System.out.println("5. Voltar");
			System.out.print("Escolha uma opção: ");
			option = scanner.nextInt();
			scanner.nextLine();

			switch (option) {
				case 1:
					createInstrutor(scanner);
					break;
				case 2:
					removeInstrutor(scanner);
					break;
				case 3:
					updateInstrutor(scanner);
					break;
				case 4:
					listInstrutores();
					break;
				case 5:
					System.out.println("Voltando ao menu principal...");
					break;
				default:
					System.out.println("Opção inválida. Tente novamente.");
			}
		} while (option != 5);
	}

	private static void createInstrutor(Scanner scanner) {
		if (vagaRepository.getAvailableVagasCount() == 0) {
			System.out.println("Não é possível cadastrar o instrutor. Todas as vagas estão ocupadas.");
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
		System.out.print("Salário: ");
		double salario = scanner.nextDouble();
		scanner.nextLine();
		System.out.print("CRM: ");
		String crm = scanner.nextLine();
		System.out.print("Cargo e horário: ");
		String cargoHorario = scanner.nextLine();
		System.out.print("Matrícula do professor: ");
		String matriculaProfessor = scanner.nextLine();
		System.out.print("Especialização: ");
		String especializacao = scanner.nextLine();

		Instrutor instrutor = new Instrutor(nome, data, cpf, endereco, genero);
		instrutor.setSalario(salario);
		instrutor.setCRM(crm);
		instrutor.setCargoHorario(cargoHorario);
		instrutor.setMatriculaProfessor(matriculaProfessor);
		instrutor.setEspecializacao(especializacao);

		Vaga vaga = vagaRepository.ocuparVaga();
		if (vaga != null) {
			System.out.println("Vaga ocupada: " + vaga);
			instrutorRepository.addInstrutor(instrutor);
			System.out.println("Instrutor cadastrado com sucesso!");
		} else {
			System.out.println("Não foi possível cadastrar o instrutor. Todas as vagas estão ocupadas.");
		}
	}

	private static void removeInstrutor(Scanner scanner) {
		System.out.print("CPF do instrutor a ser removido: ");
		String cpf = scanner.nextLine();
		Instrutor instrutor = instrutorRepository.getInstrutorById(cpf);
		if (instrutor != null) {
			instrutorRepository.deleteInstrutor(cpf);
			System.out.println("Instrutor removido: Nome: " + instrutor.getNome() + ", Especialização: " + instrutor.getEspecializacao());
			Vaga vaga = new Vaga(0);
			vagaRepository.liberarVaga(vaga);
			System.out.println("Vaga liberada.");
		} else {
			System.out.println("Instrutor não encontrado!");
		}
	}

	private static void updateInstrutor(Scanner scanner) {
		System.out.print("CPF do instrutor a ser atualizado: ");
		String cpf = scanner.nextLine();
		Instrutor instrutorExistente = instrutorRepository.getInstrutorById(cpf);

		if (instrutorExistente != null) {
			System.out.print("Novo salário: ");
			double salario = scanner.nextDouble();
			scanner.nextLine();
			System.out.print("Novo CRM: ");
			String crm = scanner.nextLine();
			System.out.print("Novo cargo e horário: ");
			String cargoHorario = scanner.nextLine();
			System.out.print("Nova matrícula do professor: ");
			String matriculaProfessor = scanner.nextLine();
			System.out.print("Nova especialização: ");
			String especializacao = scanner.nextLine();

			instrutorExistente.setSalario(salario);
			instrutorExistente.setCRM(crm);
			instrutorExistente.setCargoHorario(cargoHorario);
			instrutorExistente.setMatriculaProfessor(matriculaProfessor);
			instrutorExistente.setEspecializacao(especializacao);

			instrutorRepository.updateInstrutor(cpf, instrutorExistente);
		} else {
			System.out.println("Instrutor não encontrado!");
		}
	}

	private static void listInstrutores() {
		if (instrutorRepository.getAllInstrutores().isEmpty()) {
			System.out.println("Lista de instrutores vazia!");
		} else {
			instrutorRepository.getAllInstrutores().forEach(instrutor -> {
				System.out.println("Nome: " + instrutor.getNome() + 
								   ", CRM: " + instrutor.getCRM() + 
								   ", Especialização: " + instrutor.getEspecializacao() + 
								   ", Matrícula: " + instrutor.getMatriculaProfessor());
			});
		}
	}
}
