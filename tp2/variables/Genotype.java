package tp2.variables;

import tp2.configurations.Config;

import java.util.ArrayList;
import java.util.List;


/**
 * Le genotype est l'ensemble des genes d'un individu
 */

public class Genotype {

    private Gene[] genesVector;

    public Genotype() {
        List<String[]> genesList = new ArrayList();
        int nbGenes = Config.getNbVariables();
        genesVector = new Gene[nbGenes];

        for (int i = 0; i < nbGenes; i++) {
            genesVector[i] = new Gene(Config.getMin(i),
                    Config.getMax(i),
                    Config.getPrecision(i));
        }
    }

    /**
     * Retourne le nombre de genes (la taille du chromosome)
     *
     * @return Nombre de genes
     */
    public int length() {
        return genesVector.length;
    }

    /**
     * Retourne le i^eme gene du genotype
     *
     * @param i
     * @return Le i^eme gene
     */
    public Gene getGene(int i) {
        return genesVector[i];
    }


    /**
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < length(); i++) {
            s += genesVector[i].toString() + "\n";
        }
        return s;
    }


}
