
public class Case implements iCase {

    boolean activated;
    boolean special;

    public Case() {
        activated = false;
        special = false;
    }

    @Override
    public boolean isSpecial() {
        return this.special;
    }

    @Override
    public boolean isActivated() {
        return this.activated;
    }

    @Override
    public void setActivated(boolean activated) {
        this.activated = activated;
    }
}
