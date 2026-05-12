package project.control;

import project.boundary.IBoundary;
import project.entity.Jeu;
import project.entity.Pirate;
import project.entity.Plateau;

public class ControlDeplacement implements IControlDeplacement {

  private Jeu jeu;
  private IBoundary boundary;
  private IControlJeuPirate controlJeuPirate;

  public ControlDeplacement(IBoundary boundary, Jeu jeu) {
    super();
    this.jeu = jeu;
    this.boundary = boundary;
  }

  public void setControlJeuPirate(IControlJeuPirate control) {
    controlJeuPirate = control;
  }

  @Override
  public void deplacer(Pirate pirate, int offset) {
    int position = pirate.getPosition();
    Plateau plateau = jeu.getPlateau();
    int positionMax = plateau.getNbCases() - 1;
    int nouvellePosition = position + offset;
    if (nouvellePosition <= 0) {
      pirate.setPosition(0);
      return;
    }
    if (nouvellePosition > positionMax) {
      int depassement = nouvellePosition - positionMax;
      nouvellePosition = positionMax - depassement;
    }
    pirate.setPosition(nouvellePosition);
    boundary.afficherDeplacementPirate(
      this,
      pirate.getNom(),
      position + 1,
      pirate.getPosition() + 1
    );
  }

  @Override
  public void finDeplacement() {
    System.out.println("TEST ");
    controlJeuPirate.finAffichageDeplacement();
  }
}
