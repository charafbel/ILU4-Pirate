package project.control;

import project.entity.*;

public class ControlJeuPirate {

  // TODO(Iboudary boundary;)
  ControlDeplacement controlDeplacement;
  ControlActiverCase controlActiverCase;
  ControlVerifierFinPartie controlFinPartie;
  LancerDeControler controlLancerDe;
  Jeu jeu;

  public ControlJeuPirate(
    ControlActiverCase controlActiverCase,
    ControlVerifierFinPartie controlFinPartie,
    ControlDeplacement controlDeplacement,
    LancerDeControler controlLancerDe,
    Jeu jeu
  ) {
    super();
    this.controlActiverCase = controlActiverCase;
    this.controlFinPartie = controlFinPartie;
    this.controlDeplacement = controlDeplacement;
    this.controlLancerDe = controlLancerDe;
    this.jeu = jeu;
  }

  public void deplacer(Pirate pirate, int nbCase) {
    controlDeplacement.deplacer(pirate, nbCase);
  }

  public void lanceerDe() {
    De de = jeu.getDe();
    de.setDe1(controlLancerDe.lanceDe());
    de.setDe2(controlLancerDe.lanceDe());
  }

  public boolean estFinPartie() {
    return controlFinPartie.estFinPartie(
      jeu.getPirate1(),
      jeu.getPirate2(),
      jeu.getPlateau().getNbCases()
    );
  }

  public void tourDeJeu(Pirate pirate) {
    lanceerDe();
    De de = jeu.getDe();
    int nbDeplacement = de.getDe1() + de.getDe2();
    if (!estFinPartie()) {
      controlDeplacement.deplacer(pirate, nbDeplacement);
      Plateau plateau = jeu.getPlateau();
      iCase caseCible = plateau.getCase(pirate.getPosition());
      controlActiverCase.activerCase(pirate, caseCible);
    } else {
      // Afficher notification
    }

    deplacer(pirate, nbDeplacement);
  }
}
