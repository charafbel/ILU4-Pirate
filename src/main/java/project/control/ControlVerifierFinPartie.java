package project.control;

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
        if (J1.getPosition() == nb_cases) {
            return true;
        } else if (J2.getPosition() == nb_cases) {
            return true;
        } else if (J1.getPv() <= 0) {
            return true;
        } else if (J2.getPv() <= 0) {
            return true;
        }
 
        return false;
    }
}
