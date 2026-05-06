package project.control;

import project.entity.*;

public class ControlActiverCase {
    public void activerCase(Pirate pirate, iCase caseCible) {
        if (caseCible.isSpecial() && !caseCible.isActivated()) {
            if (caseCible instanceof CaseBonus) {
                CaseBonus caseBonus = (CaseBonus) caseCible;
                pirate.addEquipement(caseBonus.getBonus());

            } else if (caseCible instanceof CaseMalus) {
                CaseMalus caseMalus = (CaseMalus) caseCible;
                if (caseMalus.getTypeMalus() == Piege.RESSORT) {
                    if (pirate.hasEquipement() && pirate.getListEquipements().contains(Equipement.BOUCLIER_RESSORT)) {
                        pirate.removeEquipement(Equipement.BOUCLIER_RESSORT);
                    } else {
                        pirate.setPv(pirate.getPv() - 1);
                    }
                }
            }
            caseCible.setActivated(true);
        }
    }
}
