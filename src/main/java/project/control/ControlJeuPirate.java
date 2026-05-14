package project.control;

import project.boundary.IBoundary;
import project.entity.Case;
import project.entity.Pirate;
import java.util.function.BiPredicate;

public class ControlJeuPirate implements IControlJeuPirate {

    IBoundary boundary;
    ControlDeplacement controlDeplacement;
    ControlActiverCase controlActiverCase;
    ControlVerifierFinPartie controlFinPartie;
    ControlLancerDe controlLancerDe;
    IControlJeu controlJeu;

    public ControlJeuPirate(
        IBoundary boundary,
        ControlActiverCase controlActiverCase,
        ControlVerifierFinPartie controlFinPartie,
        ControlDeplacement controlDeplacement,
        ControlLancerDe controlLancerDe,
        IControlJeu controlJeu
    ) {
        super();
        this.boundary = boundary;
        this.controlActiverCase = controlActiverCase;
        this.controlFinPartie = controlFinPartie;
        this.controlDeplacement = controlDeplacement;
        this.controlLancerDe = controlLancerDe;
        this.controlJeu = controlJeu;
        this.controlDeplacement.setControlJeuPirate(this);
        this.controlLancerDe.setControlJeuPirate(this);
    }

    public void lancerDe() {
        // lance les 2 de et les sauvegardes
        controlLancerDe.lancer2De();
    }

    public boolean estFinPartie() {
        return controlFinPartie.estFinPartie(
            controlJeu.pirate1(),
            controlJeu.pirate2(),
            controlJeu.plateau().getNbCases()
        );
    }
    
    public void activerCase(Pirate joueurActuel, Case c) {
    	    controlActiverCase.activerCase(joueurActuel, c);
    }
    @Override
    public void debutJeu() {
        // affiche les 2 joueurs avec leur paramètre
        Pirate pirate1 = controlJeu.pirate1();
        Pirate pirate2 = controlJeu.pirate2();
        boundary.afficherJoueur(pirate1.getNom(), pirate1.getPv(), 0);
        boundary.afficherJoueur(pirate2.getNom(), pirate2.getPv(), 0);
        lancerDe();
    }

    public void FinDePartieAffichage() {
    	    int nb_cases = controlJeu.plateau().getNbCases();
    	    BiPredicate<Pirate,Pirate> testVainqueur = (p1,p2)->{
    	    	    return p1.getPosition()==nb_cases || (p1.getPv()>0&&p2.getPv()<=0);
    	    };
    	    Pirate j1 = controlJeu.pirate1();
    	    Pirate j2 = controlJeu.pirate2();
    	    String vainqueur = testVainqueur.test(j1, j2)?j1.getNom():j2.getNom();
    	    boundary.afficherNotitification("Le vainqueur de cette partie est "+vainqueur);
    }

    @Override
    public void deroulementJeu() {
        lancerDe();

        // // lance les de et ajoute les sauvegardes
        // lanceerDe();
        // int nbDeplacement = de.getDe1() + de.getDe2();
        // deplacer(pirate, nbDeplacement);
        // Plateau plateau = jeu.getPlateau();
        // iCase caseCible = plateau.getCase(pirate.getPosition());
        // // active la case
        // controlActiverCase.activerCase(pirate, caseCible);
        // // affiche la case qui est active
        // boundary.afficherCase(pirate.getPosition() + 1, caseCible.toString());
        // jeu.changementJoueur();
    }

    // public void jeu() {
    //     // initialise le joueur actuel
    //     Pirate joueurActuel = null;
    //     while (!estFinPartie()) {
    //         joueurActuel =
    //             jeu.getJoueurActuel() == 1
    //                 ? jeu.getPirate1()
    //                 : jeu.getPirate2();
    //         deroulementJeu(joueurActuel);
    //     }
    //     // affiche le vainqueur
    //     boundary.afficherFinJeu(joueurActuel.getNom());
    // }

    public void deplacer(Pirate pirate, int nbDeplacement) {
        // deplace le pirate
        controlDeplacement.deplacer(pirate, nbDeplacement);
    }

    public void FinLancerDe(int lancerDe) {
        Pirate joueurActuel =
            controlJeu.joueurActuel() == 1
                ? controlJeu.pirate1()
                : controlJeu.pirate2();
        deplacer(joueurActuel, lancerDe);
    }

    public void finAffichageDeplacement() {
        //lance la fonction qui permet d'activer la case

        // TEST SIMPLE DEPLACEMENT
        if (!estFinPartie()) {
            // a remplacer par l'activation de case
        	    Pirate joueur = controlJeu.joueurActuel()==1?controlJeu.pirate1():controlJeu.pirate2();
        	    Case c = controlJeu.plateau().getCase(joueur.getPosition());
        	    activerCase(joueur, c);
            controlJeu.changerJoueur();
            lancerDe();
        }else {
        	    boundary.afficherNotitification("La partie est terminée");
        	    FinDePartieAffichage();
        }
    }
}
