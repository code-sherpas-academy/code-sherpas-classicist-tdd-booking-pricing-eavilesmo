package travel_price_calculator;

public class TravelDiscountRepository {

    public int getTravelTimeDiscount(String travelId) {
        int travelTimeDiscount = 20;
        return travelTimeDiscount;
    }

    public int getTravelRateDiscount(String travelId) {
        int travelRateDiscount = 10;
        return travelRateDiscount;
    }

    public int getTicketDiscount(String travelId) {
        int ticket = 20;
        return ticket;
    }
}
