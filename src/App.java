import java.util.Scanner;

import Services.AlunoService;
import Services.InstrutorService;
import Services.AulaService;

public class App {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int mainOption;

		do {
			System.out.println("=== Menu Principal ===");
			System.out.println("1. Gerenciar Alunos");
			System.out.println("2. Gerenciar Instrutores");
			System.out.println("3. Gerenciar Aulas");
			System.out.println("0. Sair");
			System.out.print("Escolha uma opção: ");
			mainOption = scanner.nextInt();
			scanner.nextLine();

			switch (mainOption) {
				case 1:
					AlunoService.manageAlunos(scanner);
					break;
				case 2:
					InstrutorService.manageInstrutores(scanner);
					break;
				case 3:
					AulaService.manageAulas(scanner);
					break;
				case 0:
					System.out.println("Encerrando o programa...");
					break;
				default:
					System.out.println("Opção inválida. Tente novamente.");
			}
		} while (mainOption != 0);

		scanner.close();
	}
}
