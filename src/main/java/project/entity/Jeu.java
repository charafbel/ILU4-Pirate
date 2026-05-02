package project.entity;

public class Jeu {

    private Plateau plateau;
    private Pirate pirate1;
    private Pirate pirate2;
    private int JoueurActuel = 1;

    public Jeu() {
        plateau = new Plateau();
        pirate1 = new Pirate();
        pirate2 = new Pirate();
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public Pirate getPirate1() {
        return pirate1;
    }

    public Pirate getPirate2() {
        return pirate2;
    }

    public int getJoueurActuel() {
        return JoueurActuel;
    }
}
