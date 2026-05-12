package project.control;

import project.boundary.BoundaryJeuPirate;
import project.entity.Jeu;

public class Main {

  public static void main(String[] args) {
    Jeu jeu = new Jeu("Pirate1", "Pirate2");
    BoundaryJeuPirate boundary = new BoundaryJeuPirate();
    ControlActiverCase controlActiverCase = new ControlActiverCase(boundary);
    ControlDeplacement controlDeplacement = new ControlDeplacement(
      boundary,
      jeu
    );

    ControlVerifierFinPartie controlVerifierFinPartie =
      new ControlVerifierFinPartie(boundary, jeu);
    LancerDeControler lancerDeControler = new LancerDeControler(boundary);
    ControlJeuPirate controlJeuPirate = new ControlJeuPirate(
      boundary,
      controlActiverCase,
      controlVerifierFinPartie,
      controlDeplacement,
      lancerDeControler,
      jeu
    );
    controlDeplacement.setControlJeuPirate(controlJeuPirate);

    controlJeuPirate.debutJeu();
    controlJeuPirate.jeu();
  }
}
