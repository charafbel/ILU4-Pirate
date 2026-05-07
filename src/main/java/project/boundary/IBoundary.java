package project.boundary;

import java.util.List;
import javax.swing.JComponent;
import project.entity.Pirate;

public interface IBoundary {
  void afficherPlateau();

  void afficherJoueur(String nomPirate, int nbCoeur, String equipement);

  void afficherFinJeu(String nomPirateGagnant);

  void afficherDeplacementPirate(String nomPirate,int positionDepart ,int positionArrive);

  void afficherLancerDe(int de);

  void afficherNotitification(String message);
  
}
