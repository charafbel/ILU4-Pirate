package project.entity;

import java.util.Random;

public interface IDe {
    int ILancerDe();

    static IDe LancerDe = () -> new Random().nextInt(6) + 1;
}
