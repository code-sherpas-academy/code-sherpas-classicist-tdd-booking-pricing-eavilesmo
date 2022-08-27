package travel_price_calculator;

import java.util.ArrayList;

public class TravelDiscountRepository {

    public int getTravelTimeDiscount(String travelId) {
        int travelTimeDiscount = 20;
        return travelTimeDiscount;
    }

    public int getTravelRateDiscount(String travelId) {
        int travelRateDiscount = 10;
        return travelRateDiscount;
    }

    public ArrayList<Double> getTicketDiscount(String travelId) {
        ArrayList<Double> ticketDiscount = new ArrayList<Double>();
        ticketDiscount.add(0.16);
        ticketDiscount.add(0.18);
        return ticketDiscount;
    }


}
