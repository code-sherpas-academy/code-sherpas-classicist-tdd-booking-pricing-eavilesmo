package travel_price_calculator;

import java.util.ArrayList;
import java.util.HashMap;

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

    public double getPrice(String travelId, int travelTimeInput, HashMap<String, Boolean> discount) {

        int travelTime = travelTimeCalculator.getTravelTime(travelId, travelTimeInput);
        double travelRate = travelRateRepository.getTravelRate(travelId);
        if (discount.get("travel time discount")) {
            double travelTimeDiscount = (travelDiscountRepository.getTravelTimeDiscount(travelId));
            double travelDiscountRate = (100 - travelTimeDiscount) / 100;
            double result = travelTime * travelRate;
            result = (double) Math.round(result*100)/100;
            return result * travelDiscountRate;
        }
        else if (discount.get("travel rate discount")) {
            double travelRateDiscount = (travelDiscountRepository.getTravelRateDiscount(travelId));
            double travelDiscountRate = (100 - travelRateDiscount) / 100;
            double result = travelTime * (travelRate * travelDiscountRate);
            result = (double) Math.round(result*100)/100;
            return result;
        }

        else if (discount.get("ticket")) {
            ArrayList<Double> ticketDiscount = (travelDiscountRepository.getTicketDiscount(travelId));
            if (travelTime <= 2) {
                double result = travelTime * ticketDiscount.get(0);
                return result;
            }

            else {
                double result = 2 * ticketDiscount.get(0) + (travelTime - 2) * ticketDiscount.get(1);
                return result;
            }
        }
        else {
            double result = travelTime * travelRate;
            result = (double) Math.round(result*100)/100;
            return result;
        }
    }
}
