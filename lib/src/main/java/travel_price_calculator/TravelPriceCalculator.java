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

    public double getPrice(String travelId, int travelTimeInput, boolean discountInTravelTime, boolean discountInTravelRate) {

        int travelTime = travelTimeCalculator.getTravelTime(travelId, travelTimeInput);
        double travelRate = travelRateRepository.getTravelRate(travelId);
        if (discountInTravelTime) {
            double travelTimeDiscount = (travelDiscountRepository.getTravelTimeDiscount(travelId));
            double travelDiscountRate = (100 - travelTimeDiscount) / 100;
            double result = travelTime * travelRate;
            result = (double) Math.round(result*100)/100;
            return result * travelDiscountRate;
        }
        else if (discountInTravelRate) {
            double travelRateDiscount = (travelDiscountRepository.getTravelRateDiscount(travelId));
            double travelDiscountRate = (100 - travelRateDiscount) / 100;
            double result = travelTime * (travelRate * travelDiscountRate);
            result = (double) Math.round(result*100)/100;
            return result;
        }
        else {
            double result = travelTime * travelRate;
            result = (double) Math.round(result*100)/100;
            return result;
        }
    }
}
