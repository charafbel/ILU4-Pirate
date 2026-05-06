package project.control;

import project.entity.*;

public class ControlJeuPirate {
	// TODO(Iboudary boundary;)
	ControlDeplacement controlDeplacement;
	ControlActiverCase controlActiverCase;
	ControlVerifierFinPartie controlFinPartie;
	LancerDeControler controlLancerDe;
	Jeu jeu;

	public ControlJeuPirate(ControlActiverCase controlActiverCase, ControlVerifierFinPartie controlFinPartie,
			ControlDeplacement controlDeplacement, LancerDeControler controlLancerDe, Jeu jeu) {
		super();
		this.controlActiverCase = controlActiverCase;
		this.controlFinPartie = controlFinPartie;
		this.controlDeplacement = controlDeplacement;
		this.controlLancerDe = controlLancerDe;
		this.jeu = jeu;
	}

	public void deplacer(Pirate pirate, int nbCase) {
		controlDeplacement.deplacer(pirate, nbCase);
	}

	public int lanceerDe() {
		return controlLancerDe.lanceDe();
	}

	public boolean estFinPartie(int nbDeplacement) {
		return controlFinPartie.estFinPartie(jeu.getPirate1(), jeu.getPirate2(),
				jeu.getPlateau().getNbCases() + nbDeplacement);
	}

	public void tourDeJeu(Pirate pirate) {
		int nbDeplacement = lanceerDe();
		if (!estFinPartie(nbDeplacement)) {
			controlDeplacement.deplacer(pirate,nbDeplacement);
			Plateau plateau = jeu.getPlateau();
			iCase caseCible = plateau.getCase(pirate.getPosition());
			controlActiverCase.activerCase(pirate,caseCible);
		} else {
			// Afficher notification
		}

		deplacer(pirate, nbDeplacement);
	}
}
