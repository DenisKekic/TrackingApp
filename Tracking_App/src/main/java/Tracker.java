public class Tracker {
    Position actposition;
    Position oldposition;
    private double trackingTime;
    private double trackingLength;
    private boolean aufzeichnungGestartet;

    public void setPosition(Position p){
        this.actposition = p;
    }

    public double getDistance(Position p1, Position p2){
        return Math.sqrt((p2.getX()-p1.getX())*(p2.getX()-p1.getX())+(p2.getY()-p1.getY())*(p2.getY()-p1.getY()));

    }

    public double getTrackingTime() {
        return trackingTime;
    }

    public double getTrackingLength() {
        return trackingLength;
    }

    public void startTracking(){
        this.trackingLength = 0.0;
        this.trackingTime = 0.0;
        this.aufzeichnungGestartet = true;
        this.oldposition = new Position(0.0, 0.0);
        this.actposition = new Position(0.0, 0.0);
    }

    public void stopTracking(){
        this.aufzeichnungGestartet = false;
    }

    public void update(double deltaTime) throws NumberFormatException, TrackingNotStartedException{
        if(aufzeichnungGestartet && deltaTime > 0){
            this.trackingLength = getTrackingLength() + getDistance(oldposition, actposition);
            this.trackingTime = getTrackingTime() + deltaTime;
            oldposition = actposition;
        }
        else if(deltaTime < 0){
            throw new NumberFormatException();
        }
        else if(!aufzeichnungGestartet){
            throw new TrackingNotStartedException();
        }
    }

    public double getAverageSpeed(){
        if(aufzeichnungGestartet){
            return this.trackingLength/this.trackingTime;
        }
        return 0.0;
    }
}
