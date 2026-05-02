package entity;
import java.util.*;

public class Pirate {

    private int pv;
    private Point position;
    private List<Equipement> listEquipements;

    public Pirate() {
        pv = 5;
        position = new Point(0,0);
        listEquipements = new ArrayList<>();
    }

    public Point getPosition() {
        return position;
    }

    public int getPv() {
        return pv;
    }
    
    public List<Equipement> getListEquipements(){
    	    return this.listEquipements;
    }

    public void setPosition(Point position) {
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
