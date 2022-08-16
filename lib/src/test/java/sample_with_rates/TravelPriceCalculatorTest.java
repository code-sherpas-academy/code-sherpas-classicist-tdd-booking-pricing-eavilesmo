package sample_with_rates;

import org.junit.jupiter.api.Test;
import sample.TravelDiscountRepository;
import sample.TravelPriceCalculator;
import sample.TravelRateRepository;
import sample.TravelTimeCalculator;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class TravelPriceCalculatorTest {
    private final sample.TravelTimeCalculator travelTimeCalculatorMock = mock(TravelTimeCalculator.class);
    private final sample.TravelRateRepository travelRateRepositoryMock = mock(TravelRateRepository.class);
    private final sample.TravelDiscountRepository travelDiscountRepositoryMock = mock(TravelDiscountRepository.class);
    sample.TravelPriceCalculator travelPriceCalculator = new TravelPriceCalculator(travelTimeCalculatorMock,
                                                                                travelRateRepositoryMock,
                                                                                travelDiscountRepositoryMock);

    @Test
    void receive_random_travel_time_and_rate_and_return_price_test() {
        travelPriceCalculator.getPrice(travelId);
        verify(travelTimeCalculatorMock).getTravelTime();
        verify(travelRateRepositoryMock).getTravelRate();

    }
    @Test
    void receive_random_travel_time_and_rate_and_return_price_with_discount_test() {
        travelPriceCalculator.getPrice(travelId);
        verify(travelTimeCalculatorMock).getTravelTime();
        verify(travelRateRepositoryMock).getTravelRate();
        verify(travelDiscountRepositoryMock).getTravelDiscount();


    }

}