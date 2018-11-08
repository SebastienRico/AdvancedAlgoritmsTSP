package tsp;

public class Way {
    
    private Town startingTown;
    private Town arrivalTown;
    private Float weight;
    
    public Way(){}
    
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
    
    public Float getWeight(){
        return weight;
    }
    
    public void setWeight(Float weight){
        this.weight = weight;
    }
}
