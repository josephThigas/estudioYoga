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
            if (aluno.getCPF() == id) {
                return aluno;
            }
        }
        return null;
    }

    public static List<Aluno> listarAlunos() {
        return alunos;
    }

    public static void atualizarAluno(String id, Aluno novoAluno) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getCPF() == id) {
                alunos.set(i, novoAluno);
                System.out.println("Aluno atualizado com sucesso!");
            }
        }
        System.out.println("Aluno não encontrado!");
    }

    public static void removerAluno(String id) {
        if (alunos.isEmpty()) {
            System.out.println("Lista de alunos vazia!");
            return;
        }
        if (alunos.removeIf(aluno -> aluno.getCPF() == id)) {
            System.out.println("Aluno removido com sucesso!");
        } else {
            System.out.println("Aluno não encontrado!");
        }
    }
}
