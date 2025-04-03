package Repositorio;

import java.util.ArrayList;
import java.util.List;

import Entidades.Aluno;
import Repositorio.interfaces.IAlunoRep;

public class AlunoRepository implements IAlunoRep {
    private static List<Aluno> alunos = new ArrayList<>();

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public Aluno buscarAlunoPorId(String id) {
        for (Aluno aluno : alunos) {
            if (aluno.getCPF().equals(id)) {
                return aluno;
            }
        }
        return null;
    }

    public static List<Aluno> listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Lista de alunos vazia!");
            return new ArrayList<>();
        }
        System.out.println("Lista de alunos: ");
        return alunos;
    }

    public static void atualizarAluno(String id, Aluno novoAluno) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getCPF().equals(id)) {
                alunos.set(i, novoAluno);
                System.out.println("Aluno atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Aluno não encontrado!");
    }

    public static void removerAluno(String id) {
        if (alunos.isEmpty()) {
            System.out.println("Lista de alunos vazia!");
            return;
        }
        if (alunos.removeIf(aluno -> aluno.getCPF().equals(id))) {
            System.out.println("Aluno removido com sucesso!");
        } else {
            System.out.println("Aluno não encontrado!");
        }
    }

    public int getAlunosCount() {
        return alunos.size();
    }
}
