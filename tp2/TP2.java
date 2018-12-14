package tp2;

import tp2.configurations.Config;
import tp2.problemes.Cercle;
import tp2.problemes.Parallelepipede;

public class TP2 {
    public static void main(String[] args) {
        double tDeb;
        double tFin;

        //////////////////////////////////////////////////
        ////////////////// Parallelepiped ////////////////
        //////////////////////////////////////////////////
        Config.taillePopulation = 100;
        Config.nbGeneration = 300;
        Config.tauxCroisement = 0.8;
        Config.typeCroisement = "1PX";
        Config.tauxMutation = 0.001;
        Config.tauxRemplacement = 0.8;
        Config.nbVariables = 3;

        Config.nbVariables = 3;

        Config.domaineDefinition[0][0] = 10; // minimum pour a (le 1er parametre)
        Config.domaineDefinition[0][1] = 80; // maximum pour a (le 1er parametre)
        Config.domaineDefinition[0][2] = 0.1; // precision pour a (le 1er parametre)

        Config.domaineDefinition[1][0] = 0.0; // minimum pour b (le 2e parametre)
        Config.domaineDefinition[1][1] = 100.0; // maximum pour b (le 2e parametre)
        Config.domaineDefinition[1][2] = 0.1; // precision pour b (le 2e parametre)

        Config.domaineDefinition[2][0] = 0.0; // minimum pour c (le 3e parametre)
        Config.domaineDefinition[2][1] = 50.0; // maximum pour c (le 3e parametre)
        Config.domaineDefinition[2][2] = 0.1; // precision pour c (le

        System.out.println("Parallelepiped Problem");
        Parallelepipede par = new Parallelepipede();
        tDeb = System.currentTimeMillis();
        par.exec();
        tFin = System.currentTimeMillis();
        System.out.println("\nDuree execution : " + (tFin - tDeb) / 1000 + "s");

        //////////////////////////////////////////////////
        ////////////////////// Cercle ////////////////////
        //////////////////////////////////////////////////

        Config.nbVariables = 2;

        Config.domaineDefinition[0][0] = 10; // minimum pour a (le 1er parametre)
        Config.domaineDefinition[0][1] = 80; // maximum pour a (le 1er parametre)
        Config.domaineDefinition[0][2] = 0.1; // precision pour a (le 1er parametre)

        Config.domaineDefinition[1][0] = 0.0; // minimum pour b (le 2e parametre)
        Config.domaineDefinition[1][1] = 100.0; // maximum pour b (le 2e parametre)
        Config.domaineDefinition[1][2] = 0.1; // precision pour b (le 2e parametre)

        System.out.println("Cercle Problem");
        Cercle cer = new Cercle();
        tDeb = System.currentTimeMillis();
        cer.exec();
        tFin = System.currentTimeMillis();
        System.out.println("\nDuree execution : " + (tFin - tDeb) / 1000 + "s");
    }
}
