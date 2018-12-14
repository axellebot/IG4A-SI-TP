package tp2.variables;


import tp2.configurations.Config;

/**
 * Un gene est une unitE de base de l'information qui caracterise un individu (une solution)
 */

public class Gene {

    private double gene[] = new double[3];

    public Gene(double minValue, double maxValue, double precision) {
        gene[0] = minValue;
        gene[1] = maxValue;
        gene[2] = precision;
    }

    /**
     * @return Returns the lower bound of the gene.
     */
    public double getMin() {
        return gene[0];
    }

    /**
     * @return Returns the upper bound of the gene.
     */
    public double getMax() {
        return gene[1];
    }

    /**
     * @return Returns the precision of the gene.
     */
    public int getPrecision() {
        return (int) gene[2];
    }

    public int getNbBits() {
        double taille = Math.log((gene[1] - gene[0]) / gene[2]) / Math.log(2);
        int nbBits = (int) Math.ceil(taille);
        return nbBits;
    }

    /**
     * @return Returns the different information relative to the gene (type, lower and upper bounds)
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < gene.length; i++) {
            s += gene[i] + " ";
        }
        return s;
    }
}
