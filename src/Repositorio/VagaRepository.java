package Repositorio;

import java.util.Stack;
import Entidades.Vaga;

public class VagaRepository {
    private Stack<Vaga> vagas = new Stack<>();

    public VagaRepository() {
        for (int i = 1; i <= 3; i++) {
            vagas.push(new Vaga(i));
        }
    }

    public Vaga ocuparVaga() {
        if (!vagas.isEmpty()) {
            Vaga vaga = vagas.pop();
            vaga.ocupar();
            return vaga;
        }
        System.out.println("Todas as vagas estão ocupadas!");
        return null;
    }

    public void liberarVaga(Vaga vaga) {
        vaga.liberar();
        vagas.push(vaga);
    }

    public void listarVagas() {
        if (vagas.isEmpty()) {
            System.out.println("Nenhuma vaga disponível.");
        } else {
            System.out.println("Vagas disponíveis:");
            vagas.forEach(System.out::println);
        }
    }

    public int getAvailableVagasCount() {
        return vagas.size();
    }
}
