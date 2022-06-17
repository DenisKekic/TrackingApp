import java.util.Collections;

public class TestDriver {
    public static void main(String[] args) {
        Tracker tracker;
        AdvancedTracker advancedTracker = new AdvancedTracker();

        advancedTracker.setPosition(new Position(0.0, 0.0));
        advancedTracker.startTracking();
        try {
            advancedTracker.update(3.0);
        } catch (TrackingNotStartedException e) {
            e.printStackTrace();
        }
        while(advancedTracker.getTrackingLength() < 4000){
            int max = 10;
            int min = 1;
            int range = max - min +1;
            advancedTracker.setPosition(new Position((double)(Math.random() * range) + min, (double)(Math.random() * range) + min));
            try {
                advancedTracker.update(3.0);
            } catch (TrackingNotStartedException e) {
                e.printStackTrace();
            }
        }
        advancedTracker.stopTracking();
        for (Object o : advancedTracker.list) {
            System.out.println(o);
        }
    }
}
