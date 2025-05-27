package Services;

import java.util.Scanner;
import Entidades.Aula;
import Repositorio.AulaRepository;
import Entidades.HistoricoAula;

public class AulaService {
	private static AulaRepository aulaRepository = new AulaRepository();

	public static void manageAulas(Scanner scanner, HistoricoAula historicoAula) {
		int option;
		do {
			System.out.println("=== Menu Aulas ===");
			System.out.println("1. Cadastrar Aula");
			System.out.println("2. Remover Aula");
			System.out.println("3. Alterar Aula");
			System.out.println("4. Listar Aulas");
			System.out.println("5. Voltar");
			System.out.print("Escolha uma opção: ");
			option = scanner.nextInt();
			scanner.nextLine();

			switch (option) {
				case 1:
					createAula(scanner, historicoAula);
					break;
				case 2:
					removeAula(scanner);
					break;
				case 3:
					updateAula(scanner, historicoAula);
					break;
				case 4:
					listAulas();
					break;
				case 5:
					System.out.println("Voltando ao menu principal...");
					break;
				default:
					System.out.println("Opção inválida. Tente novamente.");
			}
		} while (option != 5);
	}

	private static void createAula(Scanner scanner, HistoricoAula historicoAula) {
		System.out.print("ID da aula: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Horário de entrada: ");
		String horarioEntrada = scanner.nextLine();
		System.out.print("Horário de saída: ");
		String horarioSaida = scanner.nextLine();
		System.out.print("Professor: ");
		String professor = scanner.nextLine();
		System.out.print("Dia: ");
		String dia = scanner.nextLine();
		System.out.print("Modalidade: ");
		String modalidade = scanner.nextLine();

		Aula aula = new Aula(id, horarioEntrada, horarioSaida, professor, dia, modalidade);
		aulaRepository.addAula(aula);
		historicoAula.adicionarAula(aula);
		System.out.println("Aula cadastrada com sucesso!");
	}

	private static void removeAula(Scanner scanner) {
		System.out.print("ID da aula a ser removida: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		Aula aula = aulaRepository.getAulaById(id);
		if (aula != null) {
			aulaRepository.deleteAula(id);
			System.out.println("Aula do professor " + aula.getProfessor() + " foi removida com sucesso!");
		} else {
			System.out.println("Aula não encontrada!");
		}
	}

	private static void updateAula(Scanner scanner, HistoricoAula historicoAula) {
		System.out.print("ID da aula a ser atualizada: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		Aula aulaExistente = aulaRepository.getAulaById(id);

		if (aulaExistente != null) {
			System.out.print("Novo horário de entrada: ");
			String horarioEntrada = scanner.nextLine();
			System.out.print("Novo horário de saída: ");
			String horarioSaida = scanner.nextLine();
			System.out.print("Novo professor: ");
			String professor = scanner.nextLine();
			System.out.print("Novo dia: ");
			String dia = scanner.nextLine();
			System.out.print("Nova modalidade: ");
			String modalidade = scanner.nextLine();

			aulaExistente.setHorarioEntrada(horarioEntrada);
			aulaExistente.setHorarioSaida(horarioSaida);
			aulaExistente.setProfessor(professor);
			aulaExistente.setDia(dia);
			aulaExistente.setModalidade(modalidade);

			aulaRepository.updateAula(id, aulaExistente);
			historicoAula.adicionarAula(
				new Aula(id, horarioEntrada, horarioSaida, professor, dia, modalidade)
			);
		} else {
			System.out.println("Aula não encontrada!");
		}
	}

	private static void listAulas() {
		aulaRepository.getAllAulas().forEach(aula -> {
			System.out.println("Professor: " + aula.getProfessor() +
							   ", Dia: " + aula.getDia() +
							   ", Modalidade: " + aula.getModalidade() +
							   ", Horário: " + aula.getHorarioEntrada() + " - " + aula.getHorarioSaida());
		});
	}
}
