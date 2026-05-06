package project.control;

public interface INoyauFonctionnel {
  // info joueur 1
  int getPvJ1();
  int getPositionJ1();
  String getNomJ1();

  // info joueur 2
  int getPvJ2();
  int getPositionJ2();
  String getNomJ2();

  // info partie
  String getJoueurActuel();
}
