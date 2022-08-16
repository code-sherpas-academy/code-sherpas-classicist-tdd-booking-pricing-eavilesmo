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
    void verify_interaction_between_travelTimeCalculatorMock_and_travelRateRepositoryMock_with_getTravelTime_and_getTravelRate() {
        String travelId = "1398";
        travelPriceCalculator.getPrice(travelId);
        verify(travelTimeCalculatorMock).getTravelTime();
        verify(travelRateRepositoryMock).getTravelRate();

    }
    @Test
    void verify_interaction_between_travelDiscountRepositoryMock_with_getTravelDiscount() {
        String travelId = "1398";
        travelPriceCalculator.getPrice(travelId);
        verify(travelTimeCalculatorMock).getTravelTime();
        verify(travelRateRepositoryMock).getTravelRate();
        verify(travelDiscountRepositoryMock).getTravelDiscount();


    }

}