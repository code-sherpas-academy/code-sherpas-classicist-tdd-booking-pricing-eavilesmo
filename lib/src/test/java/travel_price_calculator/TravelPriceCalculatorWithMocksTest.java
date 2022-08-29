package travel_price_calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.mockito.Mockito.*;

public class TravelPriceCalculatorWithMocksTest {

    private final TravelTimeCalculator travelTimeCalculatorMock = mock(TravelTimeCalculator.class);
    private final TravelRateRepository travelRateRepositoryMock = mock(TravelRateRepository.class);
    private final TravelDiscountRepository travelDiscountRepositoryMock = mock(TravelDiscountRepository.class);
    TravelPriceCalculator travelPriceCalculator = new TravelPriceCalculator(travelTimeCalculatorMock,
            travelRateRepositoryMock,
            travelDiscountRepositoryMock);

    @Test
    void verify_interaction_between_travelTimeCalculatorMock_and_travelRateRepositoryMock_with_getTravelTime_and_getTravelRate() {
        String travelId = "1456";
        int travelTime = 900;
        HashMap<String, Boolean> discount = chooseDiscount(false, false, false);
        travelPriceCalculator.getPrice(travelId, travelTime, discount);
        verify(travelTimeCalculatorMock).getTravelTime(travelId,travelTime);
        verify(travelRateRepositoryMock).getTravelRate(travelId);

    }

    @Test
    void verify_interaction_between_travelDiscountRepositoryMock_with_getTravelDiscount() {
        String travelId = "1456";
        int travelTime = 900;
        boolean discountInTravelTime = true;
        boolean discountInTravelRate = false;
        HashMap<String, Boolean> discount = chooseDiscount(true, false, false);
        travelPriceCalculator.getPrice(travelId, travelTime, discount);
        verify(travelTimeCalculatorMock).getTravelTime(travelId, travelTime);
        verify(travelRateRepositoryMock).getTravelRate(travelId);
        verify(travelDiscountRepositoryMock).getTravelTimeDiscount(travelId);
    }

    @Test
    void calculate_travel_rate_with_travelTimeCalculatorMock_and_travelRateRepositoryMock() {
        String travelId = "1398";
        int travelTime = 900;
        HashMap<String, Boolean> discount = chooseDiscount(false, false, false);
        travelPriceCalculator.getPrice(travelId, travelTime, discount);
        when(travelTimeCalculatorMock.getTravelTime(travelId, travelTime)).thenReturn(7);
        when(travelRateRepositoryMock.getTravelRate(travelId)).thenReturn(1.3);
        Double actualResult = travelTimeCalculatorMock.getTravelTime(travelId, travelTime) * travelRateRepositoryMock.getTravelRate(travelId);
        Double expectedResult = 9.1;
        Assertions.assertThat(actualResult).isEqualTo(expectedResult);

    }
    private HashMap<String, Boolean> chooseDiscount(Boolean travelTimeDiscount, Boolean travelRateDiscount, Boolean ticket) {
        HashMap<String, Boolean> discounts = new HashMap<>();
        discounts.put("travel time discount", travelTimeDiscount);
        discounts.put("travel rate discount", travelRateDiscount);
        discounts.put("ticket", ticket);
        return discounts;
    }
}
