package Repositorio.interfaces;

import java.util.ArrayList;

import Entidades.Instrutor;

public interface IInstrutorRepository {
    void addInstrutor(Instrutor instrutor);

    Instrutor getInstrutorById(String id);

    ArrayList<Instrutor> getAllInstrutores();

    boolean updateInstrutor(String id, Instrutor updatedInstrutor);

    boolean deleteInstrutor(String id);
}
