package project.control;

import project.entity.Jeu;
import project.entity.Pirate;

public class ControlJeu implements IControlJeu {

    Jeu jeu;

    public ControlJeu(Jeu jeu) {
        this.jeu = jeu;
    }

    @Override
    public int JoueurActuel() {
        return jeu.getJoueurActuel();
    }

    @Override
    public Pirate Pirate1() {
        return jeu.getPirate1();
    }

    @Override
    public Pirate Pirate2() {
        return jeu.getPirate2();
    }
}
