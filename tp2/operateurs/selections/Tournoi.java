package tp2.operateurs.selections;

import tp2.configurations.Config;
import tp2.variables.Individu;

import java.util.ArrayList;
import java.util.List;

/**
 * Tournament Selection based on the C-language implementation of SGA by R.
 * Smith, D. Goldberg and J. Earickson.
 */
public class Tournoi {

    private int[] tourneylist;

    private int tourneypos;

    private int tourneysize;

    /**
     * @param sga
     */

    private List<Individu> pop = new ArrayList();

    public Tournoi(List<Individu> _pop) {
        this.pop = _pop;
        tourneylist = new int[pop.size()];
        tourneysize = 2;
        preselect();

    }

    /*
     * (non-Javadoc)
     *
     * @see operators.Selector#preselect()
     */
    public void preselect() {
        shuffleList();
        tourneypos = 0;
    }

    /*
     * (non-Javadoc)
     *
     * @see operators.Selector#select()
     */
    public Individu doSelect() {
        int choice, winner;

        if ((pop.size() - tourneypos) < tourneysize) {
            shuffleList();
            tourneypos = 0;
        }

        winner = tourneylist[tourneypos];
        for (int i = 1; i < tourneysize; i++) {
            choice = tourneylist[tourneypos + i];
            if (pop.get(choice).getFitness() > pop.get(winner).getFitness())
                winner = choice;
        }

        // on deplace le tournoi pour le prochain appel
        tourneypos = tourneypos + tourneysize;

        return pop.get(winner);
    }

    /*
     * (non-Javadoc)
     *
     * @see operators.Selector#reset()
     */
    public void reset() {

    }

    /*
     *
     */
    private void shuffleList() {

        for (int i = 0; i < pop.size(); i++) {
            tourneylist[i] = i;
        }

        for (int lastPlace = tourneylist.length - 1; lastPlace > 0; lastPlace--) {

            // on choisit une position au hasard
            int randLoc = (int) (getRandomValue() * (lastPlace + 1));

            // on echange l'element aleatoire avec le dernier
            int temp = tourneylist[randLoc];
            tourneylist[randLoc] = tourneylist[lastPlace];
            tourneylist[lastPlace] = temp;
        }
    }

    private double getRandomValue() {
        return Config.getRandom();
    }
}