package project.control;

import project.entity.Pirate;

public class ControlPirate implements IControlPirate {

  @Override
  public String nomPirate(Pirate pirate) {
    return pirate.getNom();
  }

  @Override
  public int positionPirate(Pirate pirate) {
    return pirate.getPosition();
  }

  @Override
  public int pvPirate(Pirate pirate) {
    return pirate.getPv();
  }
}
