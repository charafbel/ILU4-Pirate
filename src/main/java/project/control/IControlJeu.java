package project.control;

import project.entity.Pirate;
import project.entity.Plateau;

public interface IControlJeu {
    Pirate pirate1();
    Pirate pirate2();
    int joueurActuel();
    Plateau plateau();
    void changerJoueur();
}
