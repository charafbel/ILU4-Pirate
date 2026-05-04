package project.control;

import project.entity.Jeu;
import project.entity.Pirate;

public class ControlVerifierFinPartie {
    Jeu jeu;

    public ControlVerifierFinPartie(Jeu jeu) {
        super();
        this.jeu = jeu;
    }
    
    public boolean estFinPartie(){
        Pirate J1 = jeu.getPirate1();
        Pirate J2 = jeu.getPirate2();
        
        return estFinPartie(J1, J2);
    }

    public boolean estFinPartie(Pirate J1, Pirate J2) {
        if (J1.getPosition() == 30) {
            return true;
        } else if (J2.getPosition() == 30) {
            return true;
        } else if (J1.getPv() <= 0) {
            return true;
        } else if (J2.getPv() <= 0) {
            return true;
        }
 
        return false;
    }
}
