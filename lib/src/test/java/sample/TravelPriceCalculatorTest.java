package sample;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class TravelPriceCalculatorTest {
    private final TravelTimeCalculator travelTimeCalculatorMock = mock(TravelTimeCalculator.class);
    private final TravelRateRepository travelRateRepositoryMock = mock(TravelRateRepository.class);
    private final TravelDiscountRepository travelDiscountRepositoryMock = mock(TravelDiscountRepository.class);
    TravelPriceCalculator travelPriceCalculator = new TravelPriceCalculator(travelTimeCalculatorMock,
                                                                                travelRateRepositoryMock,
                                                                                travelDiscountRepositoryMock);

    @Test
    void receive_random_travel_time_and_rate_and_return_price_test() {
        travelPriceCalculator.getPrice();
        verify(travelTimeCalculatorMock).getTravelTime();
        verify(travelRateRepositoryMock).getTravelRate();

    }

}