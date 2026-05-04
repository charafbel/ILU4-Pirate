package project.control;
import project.entity.*;

public class ControlActiverCase {
	public void caseEffect(Pirate joueur,Plateau plateau) {
		int indice = joueur.getPosition();
		Case cases = plateau.getCase(indice);
		if(cases.isSpecial()) {
			if(cases instanceof CaseBonus) {
				Equipement equipement = ((CaseBonus) cases).getTypeBonus();
				joueur.addEquipement(equipement);
			}else {
				if(!joueur.hasEquipement()) joueur.setPv(joueur.getPv()-1);
				else {
					joueur.removeEquipement(Equipement.BOUCLIER_RESSORT);
				}
			}
		}
	}
}
