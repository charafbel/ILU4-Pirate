package entity;
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
    	    for(int i=0;i<nbCases;i++) {
    	    	    cases[i] = new CaseSansEffet(i);
    	    }
    }
    private void placerCases(int nb,boolean bonus) {
    	    //bonus=true=>CASE BONUS sinon Case MALUS
    	    int placee = 0;
    	    while(placee<nb) {
    	    	    int indice = random.nextInt(nbCases);
    	    	    if(cases[indice] instanceof CaseSansEffet) {
    	    	    	    if(bonus) {
    	    	    	    	    cases[indice] = new CaseBonus(indice,Equipement.BOUCLIER_RESSORT);
    	    	    	    }else {
    	    	    	       	cases[indice] = new CaseMalus(indice,Piege.RESSORT);
    	    	    	    }
    	    	    	    placee++;
    	    	    }
    	    }
    }
    private void placerCasesSpeciales() {
    	    placerCases(nbBonus,true);
    	    placerCases(nbMalus,false);
    }
    public Case getCase(int indice) {
    	    return cases[indice];
    }
}
