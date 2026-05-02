package project.entity;

public class CaseBonus implements Case {

    private Equipement typeBonus;

    public CaseBonus(Equipement equipement) {
        super();
        this.typeBonus = equipement;
    }

    public Equipement getTypeBonus() {
        return this.typeBonus;
    }

    public boolean isSpecial() {
        return true;
    }
}
