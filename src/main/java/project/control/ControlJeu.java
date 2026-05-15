package project.control;

import project.entity.Jeu;
import project.entity.Pirate;
import project.entity.Plateau;

public class ControlJeu implements IControlJeu {

    Jeu jeu;

    public ControlJeu(Jeu jeu) {
        this.jeu = jeu;
    }

    @Override
    public int joueurActuel() {
        return jeu.getJoueurActuel();
    }

    @Override
    public Pirate pirate1() {
        return jeu.getPirate1();
    }

    @Override
    public Pirate pirate2() {
        return jeu.getPirate2();
    }

    @Override
    public Plateau plateau() {
        return jeu.getPlateau();
    }

    @Override
    public void changerJoueur() {
        jeu.changementJoueur();
    }
}
