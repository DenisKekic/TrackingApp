import java.util.ArrayList;

public class AdvancedTracker extends Tracker{

    ArrayList list = new ArrayList();

    @Override
    public void update(double deltaTime) throws NumberFormatException, TrackingNotStartedException {
        super.update(deltaTime);
        calculateKilometerData();
    }

    private void calculateKilometerData() {
        if(getTrackingLength() >= 1000){
            list.add("Streckenlänge: " + getTrackingLength());
            list.add("Durchschnittsgeschwindigkeit: " +getAverageSpeed());
            list.add("benötigte Zeit: " +getTrackingTime());
        }
    }
}
