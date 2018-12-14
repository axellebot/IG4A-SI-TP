package tp2.operateurs.mutations;

import tp2.configurations.Config;
import tp2.variables.Allele;
import tp2.variables.Individu;

import java.util.BitSet;


public class Uniforme {

    private Individu individu;
    private double probability;

    public Uniforme(Individu individu, double probability) {
        this.individu = individu;
        this.probability = probability;
    }

    /**
     * Do mutation with allele bit toggling
     * @return
     */
    public Individu doMutate() {

        // TODO : [x]
        int randomChromosomeIndex = (int) getRandomValue(0, this.individu.getChromosome().length());
        int randomBitIndex = (int) getRandomValue(0, this.individu.getChromosome().length());
        Allele allele = this.individu.getChromosome().getAllele(randomChromosomeIndex);
        BitSet bitSet = allele.getBitValue();
        bitSet.set(randomBitIndex, !bitSet.get(randomBitIndex));

        return individu;
    }

    private double getRandomValue(int min, int max) {
        return Config.getRandom(min, max);
    }

    private double getRandomValue() {
        return Config.getRandom();
    }
}
