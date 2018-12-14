package tp2.operateurs.croisements;

import tp2.configurations.Config;
import tp2.variables.Individu;

import java.util.BitSet;

public class Croisement1Point extends Croisement {

    private Individu offspring1;
    private Individu offspring2;

    public Croisement1Point(Individu parent1, Individu parent2, double _xProbability) {
        super(parent1, parent2, _xProbability);

        offspring1 = new Individu(parent1.getChromosome().getGenotype());
        offspring2 = new Individu(parent2.getChromosome().getGenotype());
        double alea = Config.getRandom();
        if (alea <= super.getXProbability()) {
            doCross(parent1, parent2);
        }
    }

    @Override
    public void doCross(Individu parent1, Individu parent2) {

        int nbGenes = parent1.getChromosome().length();
        int numGene = (int) (getRandomValue() * nbGenes);

        int tailleDuGene = parent1.getChromosome().getGenotype().getGene(numGene).getNbBits();
        int numBit = (int) (getRandomValue() * tailleDuGene);

        for (int i = 0; i < numGene; i++) {
            offspring1.setBitAllele(i, parent1.getAllele(i).getBitValue());
            offspring2.setBitAllele(i, parent2.getAllele(i).getBitValue());
        }

        BitSet allele1 = new BitSet(tailleDuGene);
        BitSet allele2 = new BitSet(tailleDuGene);
        for (int i = 0; i < tailleDuGene; i++) {
            if (i < numBit) {
                allele1.set(i, parent1.getAllele(numGene).getBitValue().get(i));
                allele2.set(i, parent2.getAllele(numGene).getBitValue().get(i));
            } else {
                allele1.set(i, parent2.getAllele(numGene).getBitValue().get(i));
                allele2.set(i, parent1.getAllele(numGene).getBitValue().get(i));
            }
        }

        offspring1.setBitAllele(numGene, allele1);
        offspring2.setBitAllele(numGene, allele2);

        for (int i = numGene + 1; i < nbGenes; i++) {
            offspring1.setBitAllele(i, parent2.getAllele(i).getBitValue());
            offspring2.setBitAllele(i, parent1.getAllele(i).getBitValue());
        }
    }

    public Individu getChild(int i) {
        if (i == 1) return offspring1;
        else return offspring2;
    }

    private double getRandomValue() {
        return Config.getRandom();
    }
}
