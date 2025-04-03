package Repositorio;
import java.util.ArrayList;

import Entidades.Aula;
import Repositorio.interfaces.IAulaRepository;

public class AulaRepository implements IAulaRepository {
    private static ArrayList<Aula> aulas = new ArrayList<>();

    public void addAula(Aula aula) {
        aulas.add(aula);
    }

    public Aula getAulaById(int id) {
        return aulas.stream()
                    .filter(aula -> aula.getId() == id)
                    .findFirst()
                    .orElse(null);
    }

    public ArrayList<Aula> getAllAulas() {
        return new ArrayList<>(aulas);
    }

    public boolean updateAula(int id, Aula updatedAula) {
        for (int i = 0; i < aulas.size(); i++) {
            if (aulas.get(i).getId() == id) {
                aulas.set(i, updatedAula);
                return true;
            }
        }
        return false;
    }

    public boolean deleteAula(int id) {
        return aulas.removeIf(aula -> aula.getId() == id);
    }
}
