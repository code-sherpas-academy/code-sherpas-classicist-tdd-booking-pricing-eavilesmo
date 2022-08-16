package sample_with_rates;

import java.util.Random;

public class TravelRateRepository {

    public Double getTravelRate() {

        return new Random().nextDouble();
    }
}
