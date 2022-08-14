package sample;

import java.util.Random;

public class TravelRateRepository {

    public Double getTravelRate() {

        return new Random().nextDouble();
    }
}
