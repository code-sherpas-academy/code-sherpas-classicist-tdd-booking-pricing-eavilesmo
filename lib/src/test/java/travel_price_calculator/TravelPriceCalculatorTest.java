package travel_price_calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


class TravelPriceCalculatorTest {
    @Test
    void receive_travel_time_and_price_and_return_total_price_test() {
        String travelId = "1456";
        int travelTime = 900;
        boolean discountInTravelTime = false;
        boolean discountInTravelRate = false;
        TravelTimeCalculator travelTimeCalculator = new TravelTimeCalculator();
        TravelRateRepository travelRateRepository = new TravelRateRepository();
        TravelDiscountRepository travelDiscountRepository = new TravelDiscountRepository();
        TravelPriceCalculator travelPriceCalculator = new TravelPriceCalculator(travelTimeCalculator, travelRateRepository, travelDiscountRepository);
        Double actualTravelPrice = travelPriceCalculator.getPrice(travelId, travelTime, discountInTravelTime, discountInTravelRate);
        Double expectedTravelPrice = 3.0;
        assertThat(actualTravelPrice).isEqualTo(expectedTravelPrice);
    }

    @Test
    void round_travel_time_to_the_next_minute_and_return_total_price_test() {
        String travelId = "1456";
        int travelTime = 121;
        boolean discountInTravelTime = false;
        boolean discountInTravelRate = false;
        TravelDiscountRepository travelDiscountRepository = new TravelDiscountRepository();
        TravelRateRepository travelRateRepository = new TravelRateRepository();
        TravelTimeCalculator travelTimeCalculator = new TravelTimeCalculator();
        TravelPriceCalculator travelPriceCalculator = new TravelPriceCalculator(travelTimeCalculator, travelRateRepository, travelDiscountRepository);
        double actualTravelPrice = travelPriceCalculator.getPrice(travelId, travelTime, discountInTravelTime, discountInTravelRate);
        double expectedTravelPrice = 0.6;
        assertThat(actualTravelPrice).isEqualTo(expectedTravelPrice);
    }

    @Test
    void receive_travel_time_lower_than_a_minute_and_return_travel_is_free() {
        String travelId = "1456";
        int travelTime = 37;
        boolean discountInTravelTime = false;
        boolean discountInTravelRate = false;
        TravelDiscountRepository travelDiscountRepository = new TravelDiscountRepository();
        TravelRateRepository travelRateRepository = new TravelRateRepository();
        TravelTimeCalculator travelTimeCalculator = new TravelTimeCalculator();
        TravelPriceCalculator travelPriceCalculator = new TravelPriceCalculator(travelTimeCalculator, travelRateRepository, travelDiscountRepository);
        double actualTravelPrice = travelPriceCalculator.getPrice(travelId, travelTime, discountInTravelTime, discountInTravelRate);
        double expectedTravelPrice = 0;
        assertThat(actualTravelPrice).isEqualTo(expectedTravelPrice);
    }

    @Test
    void receive_travel_time_and_return_total_price_with_discount_in_travel_time_test() {
        String travelId = "1456";
        int travelTime = 121;
        boolean discountInTravelTime = true;
        boolean discountInTravelRate = false;
        TravelDiscountRepository travelDiscountRepository = new TravelDiscountRepository();
        TravelRateRepository travelRateRepository = new TravelRateRepository();
        TravelTimeCalculator travelTimeCalculator = new TravelTimeCalculator();
        TravelPriceCalculator travelPriceCalculator = new TravelPriceCalculator(travelTimeCalculator, travelRateRepository, travelDiscountRepository);
        double actualTravelPrice = travelPriceCalculator.getPrice(travelId, travelTime, discountInTravelTime, discountInTravelRate);
        double expectedTravelPrice = 0.48;
        assertThat(actualTravelPrice).isEqualTo(expectedTravelPrice);
    }

    @Test
    void receive_travel_time_and_return_total_price_with_discount_in_travel_rate_test() {
        String travelId = "1456";
        int travelTime = 121;
        boolean discountInTravelTime = false;
        boolean discountInTravelRate = true;
        TravelDiscountRepository travelDiscountRepository = new TravelDiscountRepository();
        TravelRateRepository travelRateRepository = new TravelRateRepository();
        TravelTimeCalculator travelTimeCalculator = new TravelTimeCalculator();
        TravelPriceCalculator travelPriceCalculator = new TravelPriceCalculator(travelTimeCalculator, travelRateRepository, travelDiscountRepository);
        double actualTravelPrice = travelPriceCalculator.getPrice(travelId, travelTime, discountInTravelTime, discountInTravelRate);
        double expectedTravelPrice = 0.54;
        assertThat(actualTravelPrice).isEqualTo(expectedTravelPrice);
    }


}