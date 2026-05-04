package project.control;

import java.util.*;
import project.entity.*;

public class LancerDeControler {

  public int lanceDe() {
    IDe de = () -> {
      Random random = new Random();
      int result = random.nextInt(1, 7);
      return result;
    };
    return de.LancerDe();
  }
}
