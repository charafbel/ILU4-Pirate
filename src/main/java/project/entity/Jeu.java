package project.entity;

public class Jeu {

  private Plateau plateau;
  private Pirate pirate1;
  private Pirate pirate2;
  private int joueurActuel = 1;
  private De de;

  public Jeu(String nom1, String nom2) {
    plateau = new Plateau();
    pirate1 = new Pirate(nom1);
    pirate2 = new Pirate(nom2);
    de = new De();
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
    return joueurActuel;
  }

  public De getDe() {
    return de;
  }
}
