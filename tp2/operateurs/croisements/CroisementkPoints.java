package tp2.operateurs.croisements;

import tp2.variables.Individu;

// TODO : [ ]
public class CroisementkPoints extends Croisement {

    private Individu offspring1;
    private Individu offspring2;

    /**
     * Constructs a crosser from the given sga.
     * <p>
     * The genotype and crossover probability are retrieved from the sga.
     *
     * @param parent1
     * @param parent2
     * @param xProbability
     */
    public CroisementkPoints(Individu parent1, Individu parent2, double xProbability) {
        super(parent1, parent2, xProbability);

    }

    @Override
    public void doCross(Individu parent1, Individu parent2) {

    }

    @Override
    public Individu getChild(int i) {
        if (i == 1) return offspring1;
        else return offspring2;
    }
}
