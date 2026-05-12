package project.control;

import java.util.*;
import project.boundary.IBoundary;
import project.entity.*;

public class LancerDeControler {

  private IBoundary boundary;

  public LancerDeControler(IBoundary boundary) {
    this.boundary = boundary;
  }

  public int lanceDe() {
    IDe de = () -> {
      Random random = new Random();
      int result = random.nextInt(1, 7);
      return result;
    };
    int valeur = de.LancerDe();
    return valeur;
  }
}
