package project.entity;

import java.util.*;

public class Plateau {

    private final int nbCases = 30;
    private final int nbMalus = 2;
    private final int nbBonus = 2;
    private Random random = new Random();
    private Case[] cases = new Case[nbCases];

    public Plateau() {
        initialiserPlateau();
        placerCasesSpeciales();
    }

    public int getNbCases() {
        return nbCases;
    }

    private void initialiserPlateau() {
        for (int i = 0; i < nbCases; i++) {
            cases[i] = new Case();
        }
    }

    private void placerCases(int nb, boolean bonus) {
        //bonus=true=>CASE BONUS sinon Case MALUS
        int placee = 0;
        while (placee < nb) {
            int indice = random.nextInt(nbCases);
            if (cases[indice] instanceof Case) {
                if (bonus) {
                    cases[indice] = new CaseBonus(Equipement.BOUCLIER_RESSORT);
                } else {
                    cases[indice] = new CaseMalus(Piege.RESSORT);
                }
                placee++;
            }
        }
    }

    private void placerCasesSpeciales() {
        placerCases(nbBonus, true);
        placerCases(nbMalus, false);
    }

    public Case getCase(int indice) {
        return cases[indice];
    }
}
