package project.control;

import project.boundary.IBoundary;
import project.entity.*;

public class ControlJeuPirate implements IControlJeuPirate {

  IBoundary boundary;
  ControlDeplacement controlDeplacement;
  ControlActiverCase controlActiverCase;
  ControlVerifierFinPartie controlFinPartie;
  LancerDeControler controlLancerDe;
  Jeu jeu;

  public ControlJeuPirate(
    IBoundary boundary,
    ControlActiverCase controlActiverCase,
    ControlVerifierFinPartie controlFinPartie,
    ControlDeplacement controlDeplacement,
    LancerDeControler controlLancerDe,
    Jeu jeu
  ) {
    super();
    this.boundary = boundary;
    this.controlActiverCase = controlActiverCase;
    this.controlFinPartie = controlFinPartie;
    this.controlDeplacement = controlDeplacement;
    this.controlLancerDe = controlLancerDe;
    this.jeu = jeu;
  }

  public void lanceerDe() {
    // lance les 2 de et les sauvegardes
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

  @Override
  public void debutJeu() {
    // affiche les 2 joueurs avec leur paramètre
    Pirate pirate1 = jeu.getPirate1();
    Pirate pirate2 = jeu.getPirate2();
    boundary.afficherJoueur(pirate1.getNom(), pirate1.getPv(), 0);
    boundary.afficherJoueur(pirate2.getNom(), pirate2.getPv(), 0);
  }

  public void FinDePartieAffichage() {}

  @Override
  public void deroulementJeu(Pirate pirate) {
    // lance les de et ajoute les sauvegardes
    lanceerDe();
    De de = jeu.getDe();
    boundary.afficherLancerDe(de.getDe1(), de.getDe2());
    int nbDeplacement = de.getDe1() + de.getDe2();

    deplacer(pirate, nbDeplacement);
    Plateau plateau = jeu.getPlateau();
    iCase caseCible = plateau.getCase(pirate.getPosition());
    // active la case
    controlActiverCase.activerCase(pirate, caseCible);
    // affiche la case qui est active
    boundary.afficherCase(pirate.getPosition() + 1, caseCible.toString());

    jeu.changementJoueur();
  }

  public void jeu() {
    // initialise le joueur actuel
    Pirate joueurActuel = null;
    while (!estFinPartie()) {
      joueurActuel =
        jeu.getJoueurActuel() == 1 ? jeu.getPirate1() : jeu.getPirate2();
      deroulementJeu(joueurActuel);
    }
    // affiche le vainqueur
    boundary.afficherFinJeu(joueurActuel.getNom());
  }

  public void deplacer(Pirate pirate, int nbDeplacement) {
    // deplace le pirate
    controlDeplacement.deplacer(pirate, nbDeplacement);
  }

  public void finAffichageDeplacement() {
    //lance la fonction qui permet d'activer la case
    // Pour tester je fais un syso
    System.out.println("Test fin affichage Deplacement");
  }
}
