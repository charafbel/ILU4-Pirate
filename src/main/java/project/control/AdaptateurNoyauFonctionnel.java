package project.control;

import project.entity.Pirate;

public class AdaptateurNoyauFonctionnel implements INoyauFonctionnel {

  IControlPirate controlPirate;
  IControlJeu controlJeu;

  // IControlJeuPirate controlJeuPirate;

  public AdaptateurNoyauFonctionnel(
    IControlPirate controlPirate,
    IControlJeu controlJeu
    // IControlJeuPirate controlJeuPirate
  ) {
    this.controlPirate = controlPirate;
    this.controlJeu = controlJeu;
    // this.contolJeuPirate = controlJeuPirate;
  }

  @Override
  public int getPvJ1() {
    return controlJeu.Pirate1().getPv();
  }

  @Override
  public int getPvJ2() {
    return controlJeu.Pirate2().getPv();
  }

  @Override
  public int getPositionJ1() {
    return controlJeu.Pirate1().getPosition();
  }

  @Override
  public int getPositionJ2() {
    return controlJeu.Pirate2().getPosition();
  }

  @Override
  public String getNomJ1() {
    return controlJeu.Pirate1().getNom();
  }

  @Override
  public String getNomJ2() {
    return controlJeu.Pirate2().getNom();
  }

  @Override
  public String getJoueurActuel() {
    int joueur = controlJeu.JoueurActuel();
    if (joueur == 1) {
      return getNomJ1();
    }
    return getNomJ2();
  }

  @Override
  public void fermerNotification() {
    // TODO Auto-generated method stub
  }

  @Override
  public void initPlateau() {
    // TODO Auto-generated method stub
  }

  @Override
  public void lancerDe() {
    // TODO Auto-generated method stub
  }

  @Override
  public void actualiserCoeurs(Pirate joueur, int nbCoeurs) {
    // TODO Auto-generated method stub
  }

  @Override
  public void afficherNotification(String message) {
    // TODO Auto-generated method stub
  }

  @Override
  public void deplacerPirate(Pirate joueur, int destNum) {
    // TODO Auto-generated method stub
  }
}
