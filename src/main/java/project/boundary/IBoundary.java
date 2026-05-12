package project.boundary;

import project.control.IControlDeplacement;

public interface IBoundary {
  void afficherCase(int indice, String type);

  void afficherJoueur(String nomPirate, int nbCoeur, int equipement);

  void afficherFinJeu(String nomPirateGagnant);

  void afficherDeplacementPirate(
    IControlDeplacement controlDeplacement,
    String nomPirate,
    int positionDepart,
    int positionArrive
  );

  void afficherLancerDe(int de1, int de2);

  void afficherNotitification(String message);
}
