package project.control;
import project.entity.Jeu;
import project.entity.Pirate;

public interface IControlJeuPirate {
	public Jeu debutJeu();
	public Pirate deroulementJeu(Jeu jeu);
}
