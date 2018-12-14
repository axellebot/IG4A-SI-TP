package tp2.variables;

import java.util.BitSet;

/**
 * Un individu peut etre considerE comme une solution au probleme A optimiser
 */

public class Individu {

    private Chromosome chromosome;

    private double fitness;

    /**
     * Creation d'une nouvelle solution (ou individu) a partir des informations contenues
     * le "genotype". Par defaut, la valeur de fitness (note indiquant la qualitE de la solution)
     * est fixee à 0.0
     *
     * @param genotype
     */
    public Individu(Genotype genotype) {
        chromosome = new Chromosome(genotype);
        fitness = .0;
    }

    /**
     * Il s'agit de cloner un individu (une solution)
     *
     * @param indiv
     */
    public Individu(Individu indiv) {
        this(indiv.getChromosome().getGenotype());
        for (int i = 0; i < indiv.getChromosome().length(); i++) {
            this.getAllele(i).setBitValue(indiv.getAllele(i).getBitValue());
        }

        this.setFitness(indiv.getFitness());
    }


    /**
     * Retourne la note (de qualité) associée à la solution
     *
     * @return fitness
     */
    public double getFitness() {
        return this.fitness;
    }

    /**
     * Associe une note (de qualité) A la solution
     *
     * @param value
     */
    public void setFitness(double value) {
        this.fitness = value;
    }

    public Chromosome getChromosome() {
        return chromosome;
    }

    /**
     * Retourne le i^eme allele de l'individu (autrement dit, le i^eme parametre de la solution)
     *
     * @return Le i^eme allele
     */
    public Allele getAllele(int i) {
        return chromosome.getAllele(i);
    }

    /**
     * Fixe la valeur du i^eme allele (valeur entiere)
     *
     * @param i     (rang de l'allele)
     * @param newValue (valeur A enregistrer)
     */
    public void setIntAllele(int i, int newValue) {
        chromosome.setIntAllele(i, newValue);
    }

    /**
     * Fixe la valeur du i^eme allele (valeur : ensemble de booleens)
     *
     * @param i     (rang de l'allele)
     * @param newValue (valeur A enregistrer)
     */
    public void setBitAllele(int i, BitSet newValue) {
        chromosome.setBitAllele(i, newValue);
    }

    /**
     * Fixe la valeur du i^eme allele (valeur : chaine de carateres binaires)
     *
     * @param i     (rang de l'allele)
     * @param newValue (valeur à enregistrer)
     */
    public void setStringAllele(int i, String newValue) {
        chromosome.setStringAllele(i, newValue);
    }


    /**
     *
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < chromosome.length(); i++) {
            s += this.getAllele(i).getStringValue() + "\t";
        }
        return s;
    }
}
