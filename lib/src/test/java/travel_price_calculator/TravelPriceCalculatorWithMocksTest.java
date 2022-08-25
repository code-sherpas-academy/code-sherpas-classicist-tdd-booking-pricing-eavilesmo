package travel_price_calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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
        travelPriceCalculator.getPrice(travelId);
        verify(travelTimeCalculatorMock).getTravelTime(travelId);
        verify(travelRateRepositoryMock).getTravelRate(travelId);

    }

    @Test
    void verify_interaction_between_travelDiscountRepositoryMock_with_getTravelDiscount() {
        String travelId = "1456";
        travelPriceCalculator.getPrice(travelId);
        verify(travelTimeCalculatorMock).getTravelTime(travelId);
        verify(travelRateRepositoryMock).getTravelRate(travelId);
        verify(travelDiscountRepositoryMock).getTravelDiscount(travelId);
    }

    @Test
    void calculate_travel_rate_with_travelTimeCalculatorMock_and_travelRateRepositoryMock() {
        String travelId = "1398";
        travelPriceCalculator.getPrice(travelId);
        when(travelTimeCalculatorMock.getTravelTime(travelId)).thenReturn(7);
        when(travelRateRepositoryMock.getTravelRate(travelId)).thenReturn(1.3);
        Double actualResult = travelTimeCalculatorMock.getTravelTime(travelId) * travelRateRepositoryMock.getTravelRate(travelId);
        Double expectedResult = 9.1;
        Assertions.assertThat(actualResult).isEqualTo(expectedResult);

    }
}
