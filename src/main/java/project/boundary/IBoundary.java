package project.boundary;

public interface IBoundary {
  void afficherCase(int indice,String type);

  void afficherJoueur(String nomPirate, int nbCoeur, int equipement);

  void afficherFinJeu(String nomPirateGagnant);

  void afficherDeplacementPirate(String nomPirate,int positionDepart ,int positionArrive);

  void afficherLancerDe(int de);

  void afficherNotitification(String message);
  
}
