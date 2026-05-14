package project.entity;

import java.util.Random;

public class De {

    private int value;

    public int getValue() {
        return value;
    }

    public int lanceDe() {
        IDe de = () -> {
            Random random = new Random();
            int result = random.nextInt(1, 7);
            return result;
        };
        value = de.LancerDe();

        return value;
    }
}
