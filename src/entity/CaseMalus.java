package entity;

public class CaseMalus extends Case{
	private Piege typeMalus;
	public CaseMalus(Point position,Piege piege) {
		super(position);
		this.typeMalus = piege;
	}
	public Piege getTypeMalus() {
		return this.typeMalus;
	}
}
