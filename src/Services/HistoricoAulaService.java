package Services;

import java.util.Scanner;
import Entidades.Aula;
import Entidades.HistoricoAula;

public class HistoricoAulaService {
    public static void menuHistorico(Scanner scanner, HistoricoAula historico) {
        int opcao;
        do {
            System.out.println("=== Histórico de Aulas ===");
            System.out.println("1. Adicionar Aula ao Histórico");
            System.out.println("2. Remover Aula do Histórico");
            System.out.println("3. Atualizar Aula do Histórico");
            System.out.println("4. Listar Histórico");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarAula(scanner, historico);
                    break;
                case 2:
                    removerAula(scanner, historico);
                    break;
                case 3:
                    atualizarAula(scanner, historico);
                    break;
                case 4:
                    historico.listarAulas();
                    break;
                case 5:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);
    }

    private static void adicionarAula(Scanner scanner, HistoricoAula historico) {
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
        historico.adicionarAula(aula);
        System.out.println("Aula adicionada ao histórico!");
    }

    private static void removerAula(Scanner scanner, HistoricoAula historico) {
        System.out.print("ID da aula a remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (historico.removerAulaPorId(id)) {
            System.out.println("Aula removida do histórico!");
        } else {
            System.out.println("Aula não encontrada no histórico.");
        }
    }

    private static void atualizarAula(Scanner scanner, HistoricoAula historico) {
        System.out.print("ID da aula a atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
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

        Aula novaAula = new Aula(id, horarioEntrada, horarioSaida, professor, dia, modalidade);
        if (historico.atualizarAula(id, novaAula)) {
            System.out.println("Aula atualizada no histórico!");
        } else {
            System.out.println("Aula não encontrada no histórico.");
        }
    }
}
