package project.entity;

public class CaseMalus extends Case {

  private Piege typeMalus;

  public CaseMalus(Piege piege) {
    super();
    this.typeMalus = piege;
    this.special = true;
  }

  public Piege getTypeMalus() {
    return this.typeMalus;
  }

}
