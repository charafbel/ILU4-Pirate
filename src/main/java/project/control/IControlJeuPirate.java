package project.control;


public interface IControlJeuPirate {
    public void debutJeu();
    // public void deroulementJeu(Pirate pirate);
    public void deroulementJeu();
    public void lancementBombe(int offset);
    public void finAffichageDeplacement();
    public void FinLancerDe(int lancerDe);
    void finInitJoueurs(String nomJoueur1, String nomJoueur2);
    void finBattle(String nomPiarteGagnant);
}
