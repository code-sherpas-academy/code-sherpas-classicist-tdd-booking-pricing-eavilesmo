package travel_price_calculator;

public class TravelTimeCalculator {

    public int getTravelTime (String travelId, int travelTime) {
        if ((travelTime % 60) != 0) {
            travelTime /= 60;
            travelTime += 1;
            return travelTime;
        }
        else {
            return travelTime / 60;
        }
    }
}
