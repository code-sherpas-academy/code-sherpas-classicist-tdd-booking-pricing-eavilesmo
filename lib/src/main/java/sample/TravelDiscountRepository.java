package sample;

import java.util.Random;

public class TravelDiscountRepository {

    public Integer getTravelDiscount() {

        return new Random().nextInt(30);
    }
}
