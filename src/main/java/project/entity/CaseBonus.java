package project.entity;

public class CaseBonus extends Case {
  private Equipement equipement;

  public CaseBonus(Equipement equipement) {
    super();
    this.equipement = equipement;
    this.special = true;
  }

  public Equipement getBonus() {
    return equipement;
  }
}
