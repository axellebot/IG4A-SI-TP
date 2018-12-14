package tp2.variables;

import java.util.BitSet;

/**
 * Un chromosome est un ensemble de parametres definissant une solution.
 */

public class Chromosome {

    private Genotype genotype;

    private Allele[] alleles;


    public Chromosome(Genotype genotype) {
        //super();
        this.genotype = genotype;
        alleles = new Allele[genotype.length()];
        for (int i = 0; i < alleles.length; i++) {
            alleles[i] = new Allele(genotype.getGene(i));
        }

    }

    /**
     * Retourne le i^eme allele du chromosome.
     *
     * @param i l'indice de l'allele dans le chromosome
     * @return l'allele
     */
    public Allele getAllele(int i) {
        return alleles[i];
    }

    /**
     * Modifie la valueur d'un gene
     */
    public void setIntAllele(int i, int value) {
        alleles[i].setIntValue(value);
    }

    /**
     * Modifie la valueur d'un gene
     */
    public void setBitAllele(int i, BitSet value) {
        alleles[i].setBitValue(value);
    }

    /**
     * Modifie la valueur d'un gene
     */
    public void setStringAllele(int i, String value) {
        alleles[i].setStringValue(value);
    }

    /**
     * Retourne le nombre d'allele du chromosome (la taille du chromosome).
     *
     * @return La taille du chromosome
     */
    public int length() {

        return alleles.length;

    }

    /**
     * Retourne le genotype du chromosome.
     *
     * @return Retourne le genotype.
     */
    public Genotype getGenotype() {
        return genotype;
    }

}
