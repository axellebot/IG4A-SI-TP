package tp2.operateurs.croisements;

import tp2.variables.Individu;


public abstract class Croisement {

    private double xProbability = 1.0;

    /**
     * The genotype of the chromosomes to be mutated.
     */

    private Individu parent1;
    private Individu parent2;

    protected Individu child1;
    protected Individu child2;

    /**
     * Constructs a crosser from the given sga.
     * <p>
     * The genotype and crossover probability are retrieved from the sga.
     */

    public Croisement(Individu parent1, Individu parent2, double xProbability) {
        this.parent1 = parent1;
        this.parent2 = parent2;
        this.xProbability = xProbability;
    }

    /*public abstract void doCross(Individu parent1, Individu parent2,
            Individu child1, Individu child2);*/
    public abstract void doCross(Individu parent1, Individu parent2);

    /**
     * Returns the crossover probability.
     *
     * @return Returns the Crossover Probability.
     */
    public double getXProbability() {
        return xProbability;
    }

    /**
     * Sets the crossover probability.
     *
     * @param crossProbability The Crossover Probability to set.
     */
    public void setCrossProbability(double crossProbability) {
        this.xProbability = (float) crossProbability;
    }

    public abstract Individu getChild(int i);
}
