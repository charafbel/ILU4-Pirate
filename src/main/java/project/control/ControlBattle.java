package project.control;

import project.entity.Pirate;

public class ControlBattle implements IControlBattle{ 
	ControlLancerDe lancerDeControler;
		
	
	public ControlBattle(ControlLancerDe lancerDeControler) {
		super();
		this.lancerDeControler = lancerDeControler;
	}


	@Override
	public void battle(Pirate pirate1, Pirate pirate2) {
		if(pirate1.getPosition() == pirate2.getPosition()) {
			lancerDeControler.lancerUnDe();
			int dePirate1 = lancerDeControler.getValLancerUnDe();
			lancerDeControler.lancerUnDe();
			int dePirate2 = lancerDeControler.getValLancerUnDe();
			if(dePirate1>dePirate2) {
				pirate2.setPv(pirate2.getPv()-1);
			}
			else if(dePirate1<dePirate2) {
				pirate1.setPv(pirate1.getPv()-1);
			}
		}
	}
	
}
