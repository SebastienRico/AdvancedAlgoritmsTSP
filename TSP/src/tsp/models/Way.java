package tsp.models;

public class Way {
    
    private Town startingTown;
    private Town arrivalTown;
    private Double distance;
    
    public Way(){}
    
    public Way(Town startingTown,
               Town arrivalTown){
        this.startingTown = startingTown;
        this.arrivalTown = arrivalTown;
        // distance entre villeA et villeB = racineCarre((Bx - Ax)^2 + (By - Ay)^2)
        this.distance = Math.sqrt(
                Math.pow(2, arrivalTown.getLatitude() - startingTown.getLatitude()) +
                Math.pow(2, arrivalTown.getLongitude() - startingTown.getLongitude()));
    }
    
    public Town getStartingTown(){
        return startingTown;
    }
    
    public void setStartingTown(Town startingTown){
        this.startingTown = startingTown;
    }
    
    public Town getArrivalTown(){
        return arrivalTown;
    }
    
    public void setArrivalTown(Town arrivalTown){
        this.arrivalTown = arrivalTown;
    }
    
    public Double getDistance(){
        return distance;
    }
    
    public void setDistance(Double distance){
        this.distance = distance;
    }
}
