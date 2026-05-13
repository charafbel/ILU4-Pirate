package project.control;

public class AdaptateurNoyauFonctionnel implements INoyauFonctionnel {

    IControlPirate controlPirate;
    IControlJeu controlJeu;

    // IControlJeuPirate controlJeuPirate;

    public AdaptateurNoyauFonctionnel(
        IControlPirate controlPirate,
        IControlJeu controlJeu
        // IControlJeuPirate controlJeuPirate
    ) {
        this.controlPirate = controlPirate;
        this.controlJeu = controlJeu;
        // this.contolJeuPirate = controlJeuPirate;
    }

    @Override
    public int getPvJ1() {
        return controlJeu.pirate1().getPv();
    }

    @Override
    public int getPvJ2() {
        return controlJeu.pirate2().getPv();
    }

    @Override
    public int getPositionJ1() {
        return controlJeu.pirate1().getPosition();
    }

    @Override
    public int getPositionJ2() {
        return controlJeu.pirate2().getPosition();
    }

    @Override
    public String getNomJ1() {
        return controlJeu.pirate1().getNom();
    }

    @Override
    public String getNomJ2() {
        return controlJeu.pirate2().getNom();
    }

    @Override
    public String getJoueurActuel() {
        int joueur = controlJeu.joueurActuel();
        if (joueur == 1) {
            return getNomJ1();
        }
        return getNomJ2();
    }

    @Override
    public void afficherLancerDe(
        IControlLancerDe controlLancerDe,
        int de1,
        int de2
    ) {
        // TODO Auto-generated method stub
    }

    @Override
    public void afficherFinJeu(String nomPirateGagnant) {
        // TODO Auto-generated method stub
    }

    @Override
    public void afficherNotitification(String message) {
        // TODO Auto-generated method stub
    }

    @Override
    public void afficherCase(int indice, String type) {
        // TODO Auto-generated method stub
    }

    @Override
    public void afficherDeplacementPirate(
        IControlDeplacement controlDeplacement,
        String nomPirate,
        int positionDepart,
        int positionArrive
    ) {
        // TODO Auto-generated method stub
    }

    @Override
    public void afficherJoueur(String nomPirate, int nbCoeur, int equipement) {
        // TODO Auto-generated method stub
    }
}
