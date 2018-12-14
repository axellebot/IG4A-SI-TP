package tp2.problemes;

import tp2.variables.Individu;

import java.util.List;

public abstract class Problem {

    abstract void exec();

    // Tri les listes par ordre croissant de valeur de fitness.
    protected void triListe(List<Individu> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (list.get(j).getFitness() < list.get(j + 1).getFitness()) {
                    list.add(j, list.get(j + 1));
                    list.remove(j + 2);
                }
            }
        }
    }
}
