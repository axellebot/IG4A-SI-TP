package tp2.problemes;

import tp2.configurations.Config;
import tp2.operateurs.croisements.Croisement;
import tp2.operateurs.croisements.Croisement1Point;
import tp2.operateurs.croisements.Croisement2Points;
import tp2.operateurs.selections.Tournoi;
import tp2.variables.Genotype;
import tp2.variables.Individu;
import tp2.variables.Population;

import java.util.ArrayList;
import java.util.List;


public class Parallelepipede extends Problem {

    private List<Individu> popList = new ArrayList<>();
    private List<Individu> popFilleList = new ArrayList<>();
    private int popSize;
    private int nbObj = 0;
    private int generationNumber = 0;

    private Individu bestIndiv;

    private boolean objToMaximise = true;

    public Parallelepipede() {
        super();
    }

    @Override
    public void exec() {
        Genotype genotype = new Genotype();
        popSize = Config.getPopSize();
        int nbGenerations = Config.getNbGeneration();

        Population pop = new Population(popSize, genotype);
        popList = pop.getAllIndividuals();

        // Evaluation de la population initiale
        for (int i = 0; i < popList.size(); i++) {
            double f = evaluer(popList.get(i));
            popList.get(i).setFitness(f);
            if (i == 0) {
                bestIndiv = new Individu(popList.get(i));
            } else {
                if (objToMaximise) {
                    if (popList.get(i).getFitness() > bestIndiv.getFitness()) {
                        bestIndiv = new Individu((popList.get(i)));
                    }
                } else {
                    if (popList.get(i).getFitness() < bestIndiv.getFitness()) {
                        bestIndiv = new Individu((popList.get(i)));
                    }
                }

            }
        }

        System.out.println("Gen 1 ");
        System.out.println("Best indiv : " + bestIndiv.getAllele(0).getDoubleValue() + " "
                + bestIndiv.getAllele(1).getDoubleValue() + " "
                + bestIndiv.getAllele(2).getDoubleValue() + " "
                + " fitness : " + bestIndiv.getFitness());

        for (int n = 1; n < nbGenerations; n++) {
            System.out.println("Gen : " + (n + 1));
            popFilleList = regenerer();
            for (int i = 0; i < popFilleList.size(); i++) {
                double f = evaluer(popFilleList.get(i));
                popFilleList.get(i).setFitness(f);
                if (i == 0 && n == 0) {
                    bestIndiv = new Individu(popFilleList.get(i));
                } else {
                    if (objToMaximise) {
                        if (popFilleList.get(i).getFitness() > bestIndiv.getFitness()) {
                            bestIndiv = new Individu((popFilleList.get(i)));
                        }
                    } else {
                        if (popFilleList.get(i).getFitness() < bestIndiv.getFitness()) {
                            bestIndiv = new Individu((popFilleList.get(i)));
                        }
                    }

                }
            }
            triListe(popList);
            triListe(popFilleList);

            remplacer();

            System.out.println("Best indiv : " + bestIndiv.getAllele(0).getDoubleValue() + " "
                    + bestIndiv.getAllele(1).getDoubleValue() + " "
                    + bestIndiv.getAllele(2).getDoubleValue() + " "
                    + " fitness : " + bestIndiv.getFitness());
        }

    }


    private List<Individu> regenerer() {
        Tournoi selection = new Tournoi(popList);

        List<Individu> newPopList = new ArrayList<>();

        for (int i = 0; i < (int) popSize / 2; i++) {

            //Selection des parents pour le croisement
            Individu parent1 = new Individu(selection.doSelect());
            Individu parent2 = new Individu(selection.doSelect());

            Croisement crossover = null;
            if (Config.getCrossoverType().equalsIgnoreCase("1PX")) {
                crossover = new Croisement1Point(parent1, parent2, Config.getCrossoverRate());
            }else if(Config.getCrossoverType().equalsIgnoreCase("2PX")) {
                crossover = new Croisement2Points(parent1, parent2, Config.getCrossoverRate());
            }

            Individu child1 = new Individu(crossover.getChild(1));
            Individu child2 = new Individu(crossover.getChild(2));

            // A decommenter pour effectuer la mutation
            //child1 = new Uniforme(child1, mutationRate, config).doMutate();
            //child2 = new Uniforme(child2, mutationRate, config).doMutate();

            newPopList.add(child1);
            newPopList.add(child2);
        }

        return newPopList;
    }

    private double evaluer(Individu indiv) {
        double a = indiv.getAllele(0).getDoubleValue();
        double b = indiv.getAllele(1).getDoubleValue();
        double c = indiv.getAllele(2).getDoubleValue();

        return (a * b * c) / (4 * (a + b + c));
    }

    private void remplacer() {
        int limite = (int) (popList.size() * (1 - Config.getReplacementRate()));
        for (int i = limite; i < popSize; i++) {
            popList.remove(popList.size() - 1);
        }
        for (int i = 0; i < popFilleList.size() - limite; i++) {
            popList.add(popFilleList.get(limite + i));
        }
    }

}
