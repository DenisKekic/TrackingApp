import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestTracker {
    Tracker tracker1;
    Tracker tracker2;
    Tracker tracker3;

    @Before
    public void setup(){
        tracker1 = new Tracker();
        tracker2 = new Tracker();
        tracker3 = new Tracker();
    }

    @Test
    public void testDistance(){
        Position p1 = new Position(0.0, 0.0);
        Position p2 = new Position(0.0, 0.0);
        assertEquals(0.0, tracker1.getDistance(p1, p2), 1E-10);

        Position p3 = new Position(0.0, 0.0);
        Position p4 = new Position(5.0, 0.0);
        assertEquals(5.0, tracker1.getDistance(p3, p4), 1E-10);

        Position p5 = new Position(10.0, 0.0);
        Position p6 = new Position(0.0, 0.0);
        assertEquals(10.0, tracker1.getDistance(p5, p6), 1E-10);
    }

    @Test
    public void testAverageSpeed(){
        // Test1
        tracker1.startTracking();
        tracker1.setPosition(new Position(0, 5));

        try {
            tracker1.update(1.0);
        } catch (TrackingNotStartedException e) {
            e.printStackTrace();
        }

        assertEquals(5, tracker1.getAverageSpeed(), 1E-10);

        // Test2
        tracker2.startTracking();
        tracker2.stopTracking();
        assertEquals(0, tracker2.getAverageSpeed(), 1E-10);

        // Test3
        assertEquals(0, tracker3.getAverageSpeed(),1E-10);
    }

}
