package project.control;

import project.boundary.IBoundary;
import project.entity.Pirate;

public class ControlBattle implements IControlBattle {
	IBoundary boundary;
	IControlJeuPirate controlJeuPirate;
	ControlLancerDe lancerDeControler;
	Pirate pirate1;
	Pirate pirate2;
	int lancerDePirate1;
	int lancerDePirate2;
	String gagnant;

	public ControlBattle(IBoundary boundary, IControlJeuPirate controlJeuPirate, ControlLancerDe lancerDeControler) {
		super();
		this.boundary = boundary;
		this.controlJeuPirate = controlJeuPirate;
		this.lancerDeControler = lancerDeControler;
	}

	@Override
	public void battle(Pirate pirate1, Pirate pirate2) {
		animationBattle();
	}

	private void animationBattle() {
		boundary.afficherAnimationBattle(this);
	}

	private void battleLancerDe() {
		if (pirate1 == null || pirate2 == null) {
			return;
		}
		lancerDeControler.lancerUnDe();
		lancerDePirate1 = lancerDeControler.getValLancerUnDe();

		lancerDeControler.lancerUnDe();
		lancerDePirate2 = lancerDeControler.getValLancerUnDe();

		boundary.battleLancerDe(this, pirate1.getNom(), pirate2.getNom(), lancerDePirate1, lancerDePirate2);
	}

	private void resultBattle() {
		if (lancerDePirate1 > lancerDePirate2) {
			pirate2.setPv(pirate2.getPv() - 1);
			gagnant = pirate1.getNom();
		} else if (lancerDePirate1 < lancerDePirate2) {
			pirate1.setPv(pirate1.getPv() - 1);
			gagnant = pirate2.getNom();
		} else {
			gagnant = "";
		}
		boundary.afficherResultBattle(this, gagnant);
	}

	@Override
	public void finAfficherAnimationBattle() {
		battleLancerDe();

	}

	@Override
	public void finBattleLancerDe() {
		resultBattle();

	}

	@Override
	public void finAfficherResultBattle() {
		controlJeuPirate.finBattle(gagnant);

	}

}
