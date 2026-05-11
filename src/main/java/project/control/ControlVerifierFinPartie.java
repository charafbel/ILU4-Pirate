package project.control;

import java.util.function.Predicate;
import project.entity.Jeu;
import project.entity.Pirate;

public class ControlVerifierFinPartie implements IControlVerifierFinPartie {
    Jeu jeu;

    public ControlVerifierFinPartie(Jeu jeu) {
        super();
        this.jeu = jeu;
    }
    
    @Override
    public boolean estFinPartie(){
        Pirate J1 = jeu.getPirate1();
        Pirate J2 = jeu.getPirate2();
        int nb_cases = jeu.getPlateau().getNbCases();
        
        return estFinPartie(J1, J2, nb_cases);
    }

    public boolean estFinPartie(Pirate J1, Pirate J2, int nb_cases) {
        Predicate<Pirate> estHorsJeu = pirate -> pirate.getPosition() == nb_cases || pirate.getPv() <= 0;
 
        return estHorsJeu.test(J1) || estHorsJeu.test(J2);
    }
}
