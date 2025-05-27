package Entidades;

public class HistoricoAula {
    private Node head;

    private static class Node {
        Aula aula;
        Node next;

        Node(Aula aula) {
            this.aula = aula;
            this.next = null;
        }
    }

    public void adicionarAula(Aula aula) {
        Node novo = new Node(aula);
        if (head == null) {
            head = novo;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = novo;
        }
    }

    public void listarAulas() {
        Node atual = head;
        if (atual == null) {
            System.out.println("Histórico vazio!");
            return;
        }
        while (atual != null) {
            Aula aula = atual.aula;
            System.out.println("ID: " + aula.getId() + ", Professor: " + aula.getProfessor() +
                ", Dia: " + aula.getDia() + ", Modalidade: " + aula.getModalidade() +
                ", Horário: " + aula.getHorarioEntrada() + " - " + aula.getHorarioSaida());
            atual = atual.next;
        }
    }

    public boolean removerAulaPorId(int id) {
        if (head == null) return false;
        if (head.aula.getId() == id) {
            head = head.next;
            return true;
        }
        Node atual = head;
        while (atual.next != null && atual.next.aula.getId() != id) {
            atual = atual.next;
        }
        if (atual.next != null) {
            atual.next = atual.next.next;
            return true;
        }
        return false;
    }

    public boolean atualizarAula(int id, Aula novaAula) {
        Node atual = head;
        while (atual != null) {
            if (atual.aula.getId() == id) {
                atual.aula = novaAula;
                return true;
            }
            atual = atual.next;
        }
        return false;
    }
}
