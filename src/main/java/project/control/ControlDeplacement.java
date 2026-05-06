package project.control;

import project.entity.Jeu;
import project.entity.Pirate;
import project.entity.Plateau;

public class ControlDeplacement {
	private Jeu jeu;

	public ControlDeplacement(Jeu jeu) {
		super();
		this.jeu = jeu;
	}

	public void deplacer(Pirate pirate, int offset) {
		int position = pirate.getPosition();
		Plateau plateau = jeu.getPlateau();
		int positionMax = plateau.getNbCases() -1;
		int nouvellePosition = position + offset;
		if(nouvellePosition <= 0) {
			pirate.setPosition(0);
			return;
		}
		if(nouvellePosition > positionMax) {
			int depassement = nouvellePosition - positionMax;
			nouvellePosition = positionMax - depassement;
		}
		pirate.setPosition(nouvellePosition);
		
	}
}
