public class Pirate {

    private int pv;
    private Point position;

    public Pirate() {
        pv = 5;
        position = new Point(0, 0);
    }

    public Point getPosition() {
        return position;
    }

    public int getPv() {
        return pv;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }
}
