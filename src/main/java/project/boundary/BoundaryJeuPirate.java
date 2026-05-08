package project.boundary;

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
    }

    @Override
    public void afficherLancerDe(int de) {
        System.out.println("Le résultat du dé est : " + de);
    }

    @Override
    public void afficherNotitification(String message) {
        System.out.println(message);
    }
}
