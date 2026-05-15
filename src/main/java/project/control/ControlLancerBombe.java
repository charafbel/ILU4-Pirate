package project.control;

import project.entity.Pirate;

public class ControlLancerBombe implements IControlLancerBombe {

	@Override
	public void lancerBombe(Pirate pirateLanceur, Pirate pirateCible, int caseCible) {
		if(caseCible<0|| caseCible>30) { //potentiel modification si on a une portée max
			return; // mauvaise saisie de l'utilisateur 
		}
		if(caseCible == pirateCible.getPosition()) {
			pirateCible.setPv(pirateCible.getPv() -1);
		}
	}
	
}
