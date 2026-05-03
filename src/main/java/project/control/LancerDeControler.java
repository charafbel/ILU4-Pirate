package project.control;
import project.entity.*;
import java.util.*;

public class LancerDeControler {

	public LancerDeControler() {
	}
	public int lanceDe() {
		IDe de = ()->{
			Random random = new Random();
			int result = random.nextInt(1,7);
			return result;
		};
		return de.LancerDe();
	}
}
