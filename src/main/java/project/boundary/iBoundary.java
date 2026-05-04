package project.boundary;

import java.util.List;
import javax.swing.JComponent;
import project.entity.Pirate;

public interface iBoundary {
    void initPlateau();

    void actualiserCoeurs(Pirate joueur, int nbCoeurs);

    int lancerDe();

    void deplacerPirate(Pirate joueur, int destNum);

    void afficherNotification(String message);

    void fermerNotification();
}
