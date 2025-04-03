package Repositorio;

import java.util.ArrayList;

import Entidades.Instrutor;
import Repositorio.interfaces.IInstrutorRepository;

public class InstrutorRepository implements IInstrutorRepository {
    private ArrayList<Instrutor> instrutores = new ArrayList<>();

    public void addInstrutor(Instrutor instrutor) {
        instrutores.add(instrutor);
    }

    public Instrutor getInstrutorById(String id) {
        for (Instrutor instrutor : instrutores) {
            if (instrutor.getCPF().equals(String.valueOf(id))) {
                return instrutor;
            }
        }
        return null;
    }

    public ArrayList<Instrutor> getAllInstrutores() {
        return new ArrayList<>(instrutores);
    }

    public boolean updateInstrutor(String id, Instrutor updatedInstrutor) {
        for (int i = 0; i < instrutores.size(); i++) {
            if (instrutores.get(i).getCPF().equals(String.valueOf(id))) {
                instrutores.set(i, updatedInstrutor);
                return true;
            }
        }
        return false;
    }

    public boolean deleteInstrutor(String id) {
        return instrutores.removeIf(instrutor -> instrutor.getCPF().equals(String.valueOf(id)));
    }

    public String getInstrutoresCount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInstrutoresCount'");
    }
}
