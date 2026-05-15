package project.control;

import project.entity.Pirate;

public interface IControlLancerBombe {
	public boolean lancerBombe(Pirate lanceur, Pirate receveur , int caseVise); //potentiel boolean de retour pour verifier que la bombe s'est lancer
}
