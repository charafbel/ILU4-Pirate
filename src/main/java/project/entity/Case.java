package project.entity;

public class Case {

    private int numero;
    private boolean Speciale;

    public Case(int numero, boolean speciale) {
        this.numero = numero;
        this.Speciale = speciale;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isSpecial() {
        return Speciale;
    }
}
