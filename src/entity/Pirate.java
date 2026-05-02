package entity;
import java.util.*;

public class Pirate {
	private String nomPirate;
    private int pv;
    private int position;
    private List<Equipement> listEquipements;

    public Pirate(String nomPirate) {
    	    this.nomPirate = nomPirate;
        pv = 5;
        position = 0;
        listEquipements = new ArrayList<>();
    }
    
    public String getNomPirate() {
    	    return this.nomPirate;
    }

    public int getPosition() {
        return position;
    }

    public int getPv() {
        return pv;
    }
    
    public List<Equipement> getListEquipements(){
    	    return this.listEquipements;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }
    
    public void addEquipement(Equipement equipement) {
    	    this.listEquipements.add(equipement);
    }
    
    public void removeEquipement(Equipement equipement) {
    	    this.listEquipements.remove(equipement);
    }
    
    public boolean hasEquipement() {
    	    return !this.listEquipements.isEmpty();
    }
}
