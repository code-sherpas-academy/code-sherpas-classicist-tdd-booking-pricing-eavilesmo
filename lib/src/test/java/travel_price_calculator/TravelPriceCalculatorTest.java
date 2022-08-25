package travel_price_calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


class TravelPriceCalculatorTest {
    @Test
    void receive_travel_time_and_price_and_return_total_price_test() {
        TravelTimeCalculator travelTimeCalculator = new TravelTimeCalculator();
        TravelRateRepository travelRateRepository = new TravelRateRepository();
        TravelDiscountRepository travelDiscountRepository = new TravelDiscountRepository();
        String travelId = "1456";
        TravelPriceCalculator travelPriceCalculator = new TravelPriceCalculator(travelTimeCalculator, travelRateRepository, travelDiscountRepository);
        Double actualTravelPrice = travelPriceCalculator.getPrice(travelId);
        Double expectedTravelPrice = 3.0;
        assertThat(actualTravelPrice).isEqualTo(expectedTravelPrice);
    }



}