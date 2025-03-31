package Repositorio.interfaces;

import java.util.ArrayList;

import Entidades.Aula;

public interface IAulaRepository {
    void addAula(Aula aula);

    Aula getAulaById(int id);

    ArrayList<Aula> getAllAulas();

    boolean updateAula(int id, Aula updatedAula);

    boolean deleteAula(int id);
}
