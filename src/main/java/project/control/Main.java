package project.control;

import project.boundary.BoundaryJeuPirate;
import project.entity.Jeu;

public class Main {

    public static void main(String[] args) {
        Jeu jeu = new Jeu("Pirate1", "Pirate2");
        ControlJeu controlJeu = new ControlJeu(jeu);
        BoundaryJeuPirate boundary = new BoundaryJeuPirate();
        ControlActiverCase controlActiverCase = new ControlActiverCase(
            boundary
        );
        ControlDeplacement controlDeplacement = new ControlDeplacement(
            boundary,
            jeu
        );

        ControlVerifierFinPartie controlVerifierFinPartie =
            new ControlVerifierFinPartie(boundary, jeu);
        ControlLancerDe lancerDeControler = new ControlLancerDe(boundary);
        ControlLancerBombe lancerBombe = new ControlLancerBombe();
        ControlJeuPirate controlJeuPirate = new ControlJeuPirate(
            boundary,
            controlActiverCase,
            controlVerifierFinPartie,
            controlDeplacement,
            lancerDeControler,
            controlJeu,
            lancerBombe
        );

        controlJeuPirate.initJoueurs();
        //controlJeuPirate.deroulementJeu();
    }
}
