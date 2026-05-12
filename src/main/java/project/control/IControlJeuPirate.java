package project.control;

import project.entity.Jeu;
import project.entity.Pirate;

public interface IControlJeuPirate {
  public void debutJeu();
  public void deroulementJeu(Pirate pirate);
  public void finAffichageDeplacement();
}
