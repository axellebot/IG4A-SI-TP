package tp2.operateurs.croisements;

import tp2.configurations.Config;
import tp2.variables.Individu;

import java.util.BitSet;

public class Croisement2Points extends Croisement {

    private Individu offspring1;
    private Individu offspring2;

    public Croisement2Points(Individu parent1, Individu parent2, double _xProbability) {
        super(parent1, parent2, _xProbability);

        // TODO : [x]
        offspring1 = new Individu(parent1.getChromosome().getGenotype());
        offspring2 = new Individu(parent2.getChromosome().getGenotype());

        // Check probability
        double random = Config.getRandom();
        if (random <= super.getXProbability()) {
            doCross(parent1, parent2);
        }
    }

    @Override
    public void doCross(Individu parent1, Individu parent2) {
        // TODO : [x]
        int nbGenes = parent1.getChromosome().length();

        int alea1 = (int) (getRandomValue() * nbGenes);
        int alea2 = (int) (getRandomValue() * nbGenes);

        int numGene1 = (alea1 < alea2) ? alea1 : alea2;
        int numGene2 = (alea1 < alea2) ? alea1 : alea2;

        int tailleDuGene = parent1.getChromosome().getGenotype().getGene(numGene1).getNbBits();
        int numBit = (int) (getRandomValue() * tailleDuGene);

        // first part
        for (int i = 0; i < numGene1; i++) {
            offspring1.setBitAllele(i, parent1.getAllele(i).getBitValue());
            offspring2.setBitAllele(i, parent2.getAllele(i).getBitValue());
        }

        ///first cross

        BitSet allele1 = new BitSet(tailleDuGene);
        BitSet allele2 = new BitSet(tailleDuGene);

        for (int i = 0; i < tailleDuGene; i++) {
            if (i < numBit) {
                allele1.set(i, parent1.getAllele(numGene1).getBitValue().get(i));
                allele2.set(i, parent2.getAllele(numGene1).getBitValue().get(i));
            } else {
                allele1.set(i, parent2.getAllele(numGene1).getBitValue().get(i));
                allele2.set(i, parent1.getAllele(numGene1).getBitValue().get(i));
            }
        }

        // second part
        for (int i = numGene1 + 1; i < numGene2; i++) {
            offspring1.setBitAllele(i, parent2.getAllele(i).getBitValue());
            offspring2.setBitAllele(i, parent1.getAllele(i).getBitValue());
        }

        /// second cross

        BitSet allele3 = new BitSet(tailleDuGene);
        BitSet allele4 = new BitSet(tailleDuGene);

        for (int i = 0; i < tailleDuGene; i++) {
            if (i < numBit) {
                allele3.set(i, parent2.getAllele(numGene2).getBitValue().get(i));
                allele4.set(i, parent1.getAllele(numGene2).getBitValue().get(i));
            } else {
                allele3.set(i, parent1.getAllele(numGene2).getBitValue().get(i));
                allele4.set(i, parent2.getAllele(numGene2).getBitValue().get(i));
            }
        }

        offspring1.setBitAllele(numGene2, allele1);
        offspring2.setBitAllele(numGene2, allele2);

        // third part
        for (int i = numGene2 + 1; i < nbGenes; i++) {
            offspring1.setBitAllele(i, parent1.getAllele(i).getBitValue());
            offspring2.setBitAllele(i, parent2.getAllele(i).getBitValue());
        }
    }

    public Individu getChild(int i) {
        // TODO : [x]
        if (i == 1) return offspring1;
        else return offspring2;
    }

    private double getRandomValue() {
        return Config.getRandom();
    }
}
