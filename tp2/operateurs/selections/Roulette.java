package tp2.operateurs.selections;

import tp2.configurations.Config;
import tp2.variables.Individu;

import java.util.ArrayList;
import java.util.List;


public class Roulette {

    private List<Individu> pop = new ArrayList();

    public Roulette(List<Individu> _pop) {
        this.pop = _pop;
    }

    public Individu doSelect() {
        // TODO : [x]
        double n = Math.random() * (sumFitness(pop));
        double cumul = 0;
        for(Individu  i :pop){
            cumul+=i.getFitness();
            if(cumul>=n){
                return i;
            }
        }
        return pop.get(Config.getPopSize() - 1);
    }


    public double sumFitness(List<Individu> pop) {
        // TODO : [x]
        double sum = .0;

        for (Individu i : pop) {
            sum += i.getFitness();
        }
        return sum;
    }
}
