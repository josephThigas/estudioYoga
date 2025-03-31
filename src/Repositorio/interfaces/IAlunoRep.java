package Repositorio.interfaces;

import Entidades.Aluno;

public interface IAlunoRep {
    static void adicionarAluno(Aluno aluno){};

    static Aluno buscarAlunoPorId(String id){
        return null;
    };

    static void listarAlunos(){};

    static void atualizarAluno(String id, Aluno novoAluno){};

    static void removerAluno(String id){};
}
