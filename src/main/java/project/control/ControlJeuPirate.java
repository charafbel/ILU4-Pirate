package project.control;

import javax.print.attribute.standard.JobHoldUntil;
import project.boundary.IBoundary;
import project.entity.*;

public class ControlJeuPirate {

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

    public void init_game() {
        Pirate pirate1 = jeu.getPirate1();
        Pirate pirate2 = jeu.getPirate2();
        boundary.afficherJoueur(pirate1.getNom(), pirate1.getPv(), 0);
        boundary.afficherJoueur(pirate2.getNom(), pirate2.getPv(), 0);
        Plateau plateau = jeu.getPlateau();
        for (int i = 0; i < plateau.getNbCases(); i++) {
            boundary.afficherCase(i, plateau.getCase(i).getClass().toString());
        }
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
            boundary.afficherFinJeu(pirate.getNom());
        }
        jeu.changementJoueur();
    }

    public void jeu() {
        Pirate joueurActuel = jeu.getPirate1();
        while (!estFinPartie()) {
            joueurActuel =
                jeu.getJoueurActuel() == 1
                    ? jeu.getPirate1()
                    : jeu.getPirate2();
            tourDeJeu(joueurActuel);
        }
        boundary.afficherFinJeu(joueurActuel.getNom());
    }
}
