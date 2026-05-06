package project.boundary;

import java.util.List;
import javax.swing.JComponent;
import project.entity.Pirate;

public interface IBoundary {
  void afficherPlateau();

  void afficherJoueur(Pirate pirate);

  void afficherFinJeu(Pirate pirate);

  void afficherDeplacementPirate(Pirate pirate);

  void afficherLancerDe(int de);

  void afficherNotitification(String message);
  
}
