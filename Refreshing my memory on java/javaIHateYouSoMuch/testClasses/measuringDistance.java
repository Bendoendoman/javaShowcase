package testClasses;

public class measuringDistance{
    double this_distanceInMiles;
    double this_speedInMph;
    double time;

    public measuringDistance(double  distanceInMiles, double speedInMph){
        this_distanceInMiles = distanceInMiles;
        this_speedInMph = speedInMph;
        time = this_distanceInMiles * this_speedInMph;

    }
    public double getTime(double currentTime){

        return time-currentTime;

    }
    public double getTime(int currentTime){
        
        currentTime += .0;

        return time-currentTime;

    }
    public double getTime(){
        return time;
    }
    

}
