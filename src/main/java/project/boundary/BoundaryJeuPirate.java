package project.boundary;

import java.util.Scanner;

import project.control.IControlDeplacement;
import project.control.IControlJeuPirate;
import project.control.IControlLancerDe;

public class BoundaryJeuPirate implements IBoundary {

    public BoundaryJeuPirate() {}

    @Override
    public void afficherCase(int indice, String type) {
        System.out.println("Case : " + indice + ": " + type);
    }

    @Override
    public void afficherJoueur(String nomPirate, int nbCoeur, int equipement) {
        System.out.println(
            "Le pirate : " +
                nomPirate +
                " possède " +
                nbCoeur +
                " et possède " +
                equipement
        );
    }

    @Override
    public void afficherFinJeu(String nomPirateGagnant) {
        System.out.println("Le gagnant est : " + nomPirateGagnant);
    }

    @Override
    public void afficherDeplacementPirate(
        IControlDeplacement controlDeplacement,
        String nomPirate,
        int positionDepart,
        int positionArrive
    ) {
        System.out.println(
            "Le pirate " +
                nomPirate +
                " se déplace de la case " +
                positionDepart +
                " à la case " +
                positionArrive
        );
        controlDeplacement.finDeplacement();
    }

    @Override
    public void afficherLancerDe(
        IControlLancerDe controlLancerDe,
        int de1,
        int de2
    ) {
        Scanner scan = new Scanner(System.in);
        System.out.println(
            "Vous devez lancer les Dé : (appuyer sur une touche)"
        );
        scan.nextLine();
        int de = de1 + de2;
        System.out.println("Le résultat du dé est : " + de);
        // scan.close();
        controlLancerDe.finAfficherLancerDe();
    }

    @Override
    public void afficherNotitification(String message) {
        System.out.println(message);
    }

	@Override
	public void initJoueurs(IControlJeuPirate controlJeuPirate) {
		Scanner scan = new Scanner(System.in);
        System.out.println(
            "Choisir nom joueur1 "
        );
        String nomJoueur1 = scan.nextLine();
        System.out.println(
                "Choisir nom joueur2 "
            );
        String nomJoueur2 = scan.nextLine();
        scan.close();
        controlJeuPirate.finInitJoueurs(nomJoueur1,nomJoueur2);
	}


}
