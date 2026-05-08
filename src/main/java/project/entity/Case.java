<<<<<<< HEAD
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
=======
package project.entity;

public interface Case {
  boolean isSpecial();
>>>>>>> feature/boundary-ihm
}
