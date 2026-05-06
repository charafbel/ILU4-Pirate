package project.control;

import project.entity.Case;
import project.entity.CaseBonus;
import project.entity.CaseMalus;
import project.entity.Equipement;
import project.entity.Jeu;
import project.entity.Piege;
import project.entity.Pirate;
import project.entity.Plateau;
import project.entity.iCase;

public class ControlActiverCase {
    private Jeu jeu;

    public ControlActiverCase(Jeu jeu) {
        this.jeu = jeu;
    }

    public void activerCase(Pirate pirate, int nbDeplacement) {
        Plateau plateau = jeu.getPlateau();
        int targetPosition = pirate.getPosition() + nbDeplacement;

        if (targetPosition > plateau.getNbCases()) {
            int overshoot = targetPosition - plateau.getNbCases();
            targetPosition = plateau.getNbCases() - overshoot;
        }

        if (targetPosition == plateau.getNbCases()) {
            return;
        }

        iCase caseCible = plateau.getCase(targetPosition);

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
