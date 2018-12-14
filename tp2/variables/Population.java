package tp2.variables;

import java.util.ArrayList;
import java.util.List;

/**
 * Une population represente un ensemble de solutions du probleme A optimiser
 */

public class Population {

    protected List<Individu> individuals;

    public Population(int popsize, Genotype genotype) {
        individuals = new ArrayList<Individu>();
        for (int i = 0; i < popsize; i++) {
            individuals.add(new Individu(genotype));
        }

    }

    /**
     * Retourne le i^eme individu de la population.
     *
     * @param index
     * @return
     */
    public Individu getIndividual(int index) {

        return individuals.get(index);

    }

    /**
     * Retourne la liste complète des individus de la population
     *
     * @return
     */
    public List<Individu> getAllIndividuals() {
        return individuals;
    }

    /**
     * Retourne la taille de la population (nombre de solutions)
     *
     * @return La taille de la population
     */
    public int size() {
        return individuals.size();
    }

    public String toString() {
        String s = "";
        for (Individu indiv : individuals) {
            s += indiv.toString() + "\n";
        }
        return s;
    }
}
