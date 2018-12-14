package tp2.configurations;

import java.util.Random;

public class Config {
    static public int taillePopulation = 100;  // Nombre de solutions evaluees A chaque generation.
    static public int nbGeneration = 300;     // Nombre de generations

    static public double tauxCroisement = 0.8;
    static public String typeCroisement = "1PX";
    static public double tauxMutation = 0.001;
    static public double tauxRemplacement = 0.8; // Pourcentage de parents qui seront remplacEs par des solutions filles

    static public int nbVariables = 3;  // Nombre de parametres d'entree (taille du chromosome)
    static public double[][] domaineDefinition = new double[nbVariables][3];

    static long graine = 11;
    static Random random = new Random(graine);

    static public int getPopSize() {
        return taillePopulation;
    }

    static public int getNbGeneration() {
        return nbGeneration;
    }

    static public double getCrossoverRate() {
        return tauxCroisement;
    }

    static public String getCrossoverType() {
        return typeCroisement;
    }

    static public double getMutationRate() {
        return tauxMutation;
    }

    static public double getReplacementRate() {
        return tauxRemplacement;
    }

    static public int getNbVariables() { // Retourne le nombre de parametres du probleme
        return nbVariables;
    }

    static public double getMin(int i) { // Retourne la borne inferieure de l'intervalle de variation du i^eme parametetre
        return domaineDefinition[i][0];
    }

    static public double getMax(int i) { // Retourne la borne superieure de l'intervalle de variation du i^eme parametetre
        return domaineDefinition[i][1];
    }

    static public double getPrecision(int i) { // Retourne la precision souhaitee pour le i^eme parametetre
        return domaineDefinition[i][2];
    }

    static public double getRandom() { // Genere un nombre pseudo-aleatoire
        return random.nextDouble();
    }

    /**
     *
     * @param min min of the value
     * @param max max of the value
     * @return
     */
    static public double getRandom(int min, int max) {
        return getRandom() * (max - min) + min;
    }

    static public void setGraine(long g) {
        graine = g;
        random = new Random(graine);
    }
}
