package project.control;

import project.entity.Jeu;
import project.entity.Pirate;

public class AdaptateurNoyauFonctionnel implements INoyauFonctionnel {

    Jeu jeu;

    public AdaptateurNoyauFonctionnel(Jeu jeu) {
        this.jeu = jeu;
    }

    public int getPvJ1() {
        return getPv(jeu.getPirate1());
    }

    public int getPvJ2() {
        return getPv(jeu.getPirate2());
    }

    public int getPositionJ1() {
        return getPosition(jeu.getPirate1());
    }

    public int getPositionJ2() {
        return getPosition(jeu.getPirate2());
    }

    public String getNomJ1() {
        return getNom(jeu.getPirate1());
    }

    public String getNomJ2() {
        return getNom(jeu.getPirate2());
    }

    public String getJoueurActuel() {
        int joueur = jeu.getJoueurActuel();
        if (joueur == 1) {
            return getNomJ1();
        }
        return getNomJ2();
    }

    private int getPv(Pirate pirate) {
        return pirate.getPv();
    }

    private int getPosition(Pirate pirate) {
        return pirate.getPosition();
    }

    private String getNom(Pirate pirate) {
        return pirate.getNom();
    }
}
