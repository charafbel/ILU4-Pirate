package entity;

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
}
