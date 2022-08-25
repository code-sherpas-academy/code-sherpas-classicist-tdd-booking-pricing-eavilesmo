package travel_price_calculator;

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

    public Double getPrice(String travelId) {

        Integer travelTime = travelTimeCalculator.getTravelTime(travelId);
        Double travelRate = travelRateRepository.getTravelRate(travelId);
//        Integer travelDiscount = (travelDiscountRepository.getTravelDiscount(travelId)) / 100;

//        return (travelTime * travelRate) * (1 - travelDiscount);
        return travelTime * travelRate;
    }
}
