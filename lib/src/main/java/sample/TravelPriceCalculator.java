package sample;

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

    public Double getPrice() {

        Integer travelTime = travelTimeCalculator.getTravelTime();
        Double travelRate = travelRateRepository.getTravelRate();
        Integer travelDiscount = (travelDiscountRepository.getTravelDiscount()) / 100;

        return (travelTime * travelRate) * (1 - travelDiscount);
    }
}
