package travel_price_calculator;

import java.util.*;

public class TravelPriceCalculator {

    private final TravelTimeCalculator travelTimeCalculator;
    private final TravelRateRepository travelRateRepository;
    private final TravelDiscountRepository travelDiscountRepository;

    public TravelPriceCalculator(TravelTimeCalculator travelTimeCalculator,
                                 TravelRateRepository travelRateRepository,
                                 TravelDiscountRepository travelDiscountRepository) {

        this.travelTimeCalculator = travelTimeCalculator;
        this.travelRateRepository = travelRateRepository;
        this.travelDiscountRepository = travelDiscountRepository;
    }

    public double getPrice(String travelId, int travelTimeInput) {

        Integer travelTime = travelTimeCalculator.getTravelTime(travelId, travelTimeInput);
        Double travelRate = travelRateRepository.getTravelRate(travelId);
//        Integer travelDiscount = (travelDiscountRepository.getTravelDiscount(travelId)) / 100;

//        return (travelTime * travelRate) * (1 - travelDiscount);
        double result = travelTime * travelRate;
        result = (double) Math.round(result*100)/100;
        return result;
    }
}
