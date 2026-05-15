package project.control;

import project.boundary.IBoundary;
import project.entity.De;

public class ControlLancerDe implements IControlLancerDe {

    private IBoundary boundary;
    private IControlJeuPirate controlJeuPirate;
    private De de1;
    private De de2;

    public ControlLancerDe(IBoundary boundary) {
        this.boundary = boundary;
        de1 = new De();
        de2 = new De();
    }

    @Override
    public void lancerUnDe() {
        de1.lanceDe();
    }

    @Override
    public void lancer2De() {
        de1.lanceDe();
        de2.lanceDe();
        int value1 = de1.getValue();
        int value2 = de2.getValue();
        boundary.afficherLancerDe(this, value1, value2);
    }

    @Override
    public void finAfficherLancerDe() {
        controlJeuPirate.FinLancerDe(de1.getValue() + de2.getValue());
    }

    @Override
    public void setControlJeuPirate(IControlJeuPirate controlJeuPirate) {
        this.controlJeuPirate = controlJeuPirate;
    }
}
