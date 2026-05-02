package project.entity;

public class CaseMalus implements Case {

    private Piege typeMalus;

    public CaseMalus(Piege piege) {
        super();
        this.typeMalus = piege;
    }

    public Piege getTypeMalus() {
        return this.typeMalus;
    }

    public boolean isSpecial() {
        return true;
    }
}
