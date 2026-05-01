import java.util.Random;

public interface De {
    static Random random = new Random();

    static int LancerDe() {
        return random.nextInt(1, 7);
    }
}
