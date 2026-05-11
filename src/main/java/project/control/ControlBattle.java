package project.control;

import project.entity.Pirate;

public class ControlBattle implements IControlBattle{ 
	LancerDeControler lancerDeControler = new LancerDeControler();
	@Override
	public void battle(Pirate pirate1, Pirate pirate2) {
		if(pirate1.getPosition() == pirate2.getPosition()) {
			int dePirate1 = lancerDeControler.lanceDe();
			int dePirate2 = lancerDeControler.lanceDe();
			if(dePirate1>dePirate2) {
				pirate2.setPv(pirate2.getPv()-1);
			}
			else if(dePirate1<dePirate2) {
				pirate1.setPv(pirate1.getPv()-1);
			}
		}
	}
	
}
