package travel_price_calculator;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


class TravelPriceCalculatorTest {
    @Test
    void receive_travel_time_and_price_and_return_total_price_test() {
        String travelId = "1456";
        int travelTime = 900;
        HashMap<String, Boolean> discount = chooseDiscount(false, false, false);
        Double actualTravelPrice = createTravelPriceCalculator().getPrice(travelId, travelTime, discount);
        Double expectedTravelPrice = 3.0;
        assertThat(actualTravelPrice).isEqualTo(expectedTravelPrice);
    }

    @Test
    void round_travel_time_to_the_next_minute_and_return_total_price_test() {
        String travelId = "1456";
        int travelTime = 121;
        HashMap<String, Boolean> discount = chooseDiscount(false, false, false);
        double actualTravelPrice = createTravelPriceCalculator().getPrice(travelId, travelTime, discount);
        double expectedTravelPrice = 0.6;
        assertThat(actualTravelPrice).isEqualTo(expectedTravelPrice);
    }

    @Test
    void receive_travel_time_lower_than_a_minute_and_return_travel_is_free() {
        String travelId = "1456";
        int travelTime = 37;
        HashMap<String, Boolean> discount = chooseDiscount(false, false, false);
        double actualTravelPrice = createTravelPriceCalculator().getPrice(travelId, travelTime, discount);
        double expectedTravelPrice = 0;
        assertThat(actualTravelPrice).isEqualTo(expectedTravelPrice);
    }

    @Test
    void receive_travel_time_and_return_total_price_with_discount_in_travel_time_test() {
        String travelId = "1456";
        int travelTime = 121;
        HashMap<String, Boolean> discount = chooseDiscount(true, false, false);
        double actualTravelPrice = createTravelPriceCalculator().getPrice(travelId, travelTime, discount);
        double expectedTravelPrice = 0.48;
        assertThat(actualTravelPrice).isEqualTo(expectedTravelPrice);
    }

    @Test
    void receive_travel_time_and_return_total_price_with_discount_in_travel_rate_test() {
        String travelId = "1456";
        int travelTime = 121;
        HashMap<String, Boolean> discount = chooseDiscount(false, true, false);
        double actualTravelPrice = createTravelPriceCalculator().getPrice(travelId, travelTime, discount);
        double expectedTravelPrice = 0.54;
        assertThat(actualTravelPrice).isEqualTo(expectedTravelPrice);
    }

    @Test
    void receive_travel_time_and_return_travel_price_when_a_ticket_is_owned_test() {
        String travelId = "1456";
        int travelTime = 121;
        HashMap<String, Boolean> discount = chooseDiscount(false, false, true);
        double actualTravelPrice = createTravelPriceCalculator().getPrice(travelId, travelTime, discount);
        double expectedTravelPrice = 0.5;
        assertThat(actualTravelPrice).isEqualTo(expectedTravelPrice);
    }

    private TravelPriceCalculator createTravelPriceCalculator() {
        TravelTimeCalculator travelTimeCalculator = new TravelTimeCalculator();
        TravelRateRepository travelRateRepository = new TravelRateRepository();
        TravelDiscountRepository travelDiscountRepository = new TravelDiscountRepository();
        TravelPriceCalculator travelPriceCalculator = new TravelPriceCalculator(travelTimeCalculator, travelRateRepository, travelDiscountRepository);
        return travelPriceCalculator;

    }

    private HashMap<String, Boolean> chooseDiscount(Boolean travelTimeDiscount, Boolean travelRateDiscount, Boolean ticket) {
        HashMap<String, Boolean> discounts = new HashMap<>();
        discounts.put("travel time discount", travelTimeDiscount);
        discounts.put("travel rate discount", travelRateDiscount);
        discounts.put("ticket", ticket);
        return discounts;
    }


}