package project.control;

import project.entity.Pirate;

public class ControlJeuPirate {
	// TODO(Iboudary boundary;)
	ControlDeplacement controlDeplacement;
	ControlActiverCase controlActiverCase;
	ControlVerifierFinPartie controlFinPartie;
	LancerDeControler controlLancerDe;

	public ControlJeuPirate(ControlActiverCase controlActiverCase, ControlVerifierFinPartie controlFinPartie,
			ControlDeplacement controlDeplacement, LancerDeControler controlLancerDe) {
		super();
		this.controlActiverCase = controlActiverCase;
		this.controlFinPartie = controlFinPartie;
		this.controlDeplacement = controlDeplacement;
		this.controlLancerDe = controlLancerDe;
	}

	public void deplacer(Pirate pirate, int nbCase) {
		controlDeplacement.deplacer(pirate, nbCase);
	}

	public int lanceerDe() {
		return controlLancerDe.lanceDe();
	}

	public boolean estFinPartie() {
		return controlFinPartie.estFinPartie();
	}
}
