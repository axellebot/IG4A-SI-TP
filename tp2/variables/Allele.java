package tp2.variables;

import tp2.configurations.Config;

import java.util.BitSet;

/**
 * Un allele est une des differentes valeurs que peut prendre un gene
 */

public class Allele {

    private Gene gene;

    private int intValue;
    private BitSet bitValue;
    private int nbBits;

    /**
     * Instantiation d'un nouvel allele avec des valeurs respectant les dommaines
     * de variation definis dans la classe "Gene"
     *
     * @param gene
     */
    public Allele(Gene gene) {
        super();
        this.gene = gene;
        nbBits = gene.getNbBits();
        bitValue = new BitSet(nbBits);
        for (int i = 0; i < nbBits; i++) {
            double alea = getRandomValue();
            if (alea < 0.5) {
                bitValue.clear(i);
            } else {
                bitValue.set(i);
            }
        }
        intValue = Integer.parseInt(toString(bitValue), 2);
    }

    /**
     * Fixer une valeur entiere A l'allele
     *
     * @param newValue
     */
    public void setIntValue(int newValue) {
        intValue = newValue;
        bitValue = toBitSet(intValue);
    }

    /**
     * Fixer une valeur binaire (sous forme d'ensemble de booleens) A l'allele
     *
     * @param newValue
     */
    public void setBitValue(BitSet newValue) {
        bitValue = newValue;
        intValue = Integer.parseInt(toString(bitValue), 2);
    }

    /**
     * Fixer une valeur binaire (sous forme de chaine de caracteres) A l'allele
     *
     * @param newValue
     */
    public void setStringValue(String newValue) {
        intValue = Integer.parseInt(newValue, 2);
        bitValue = toBitSet(intValue);
    }


    /**
     * Retourne la valeur de l'allele (sous forme d'ensemble de booleens, BitSet).
     *
     * @return Returns the bitValue.
     */
    public BitSet getBitValue() {
        return bitValue;
    }

    /**
     * Retourne la valeur de l'allele (sous forme d'entier, int).
     *
     * @return Returns the value.
     */
    public int getIntValue() {
        return intValue;
    }

    /**
     * Retourne la valeur de l'allele (sous forme de chaine de caracteres binaires, String).
     */
    public String getStringValue() {
        return toString(bitValue);
    }

    /**
     * Retourne la valeur reelle de l'allele.
     *
     * @return Returns the doubleValue.
     */
    public double getDoubleValue() {
        double doubleValue = (intValue * (gene.getMax() - gene.getMin()) /
                Math.pow(2, nbBits)) + gene.getMin();
        // Les deux lignes suivantes permettent de tronquer les valeurs à 1 chiffre après la virgule.
        int i = (int) (doubleValue * 10);
        doubleValue = i / 10.0;
        return doubleValue;
    }

    /**
     * Retourne le "gene" auquel est associE cet allele
     *
     * @return Returns the gene.
     */
    public Gene getGene() {
        return gene;
    }

    /**
     * Convertit un entier en une chaine binaire. Les bits de poids fort (de gauche) sont
     * completEs par des "0" si necessaire.
     *
     * @return binaryValue
     */
    public String intToBinary(int intValue) {
        String binaryValue = Integer.toBinaryString(intValue);
        int len = binaryValue.length();
        for (int i = 0; i < nbBits - len; i++) {
            binaryValue = 0 + binaryValue;
        }
        return binaryValue;
    }

    /**
     * Convertit un ensemble de booleens en une chaine binaire.
     */
    public String toString(BitSet bs) {
        String s = "";
        for (int i = 0; i < nbBits; i++) {
            s += bs.get(i) == true ? "1" : "0";
        }
        return s;
    }

    /**
     * Convertit un entier en un ensemble de booleen.
     */
    public BitSet toBitSet(int n) {
        BitSet bs = new BitSet(nbBits);
        String s = intToBinary(n);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(1) == '0') {
                bs.clear(i);
            } else {
                bs.set(i);
            }
        }
        return bs;
    }

    private double getRandomValue() {
        return Config.getRandom();
    }
}
