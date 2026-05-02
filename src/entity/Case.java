package entity;

public abstract class Case {
	private Point position; 
	public Case(Point position) {
		this.position = position;
	}
	public Point getPosition() {
		return this.position;
	}
}
