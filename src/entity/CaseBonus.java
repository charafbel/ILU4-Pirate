package entity;

public class CaseBonus extends Case{
	private Equipement typeBonus;
	public CaseBonus(int position,Equipement equipement) {
		super(position);
		this.typeBonus = equipement;
	}
	public Equipement getTypeBonus() {
		return this.typeBonus;
	}
}
