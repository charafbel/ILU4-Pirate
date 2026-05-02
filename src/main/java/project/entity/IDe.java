package project.entity;

import java.util.Random;

public interface IDe {
    int LancerDe();

    static IDe ILancerDe = () -> new Random().nextInt(6) + 1;
}
