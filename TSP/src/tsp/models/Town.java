package tsp.models;

public class Town {
    
    private String name;
    private Boolean startingTown;
    private Integer latitude;
    private Integer longitude;
    
    public Town(){}
    
    public Town(String name,
                Boolean startingTown,
                Integer latitude,
                Integer longitude){
        this.name = name;
        this.startingTown = startingTown;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public Boolean getStartingTown(){
        return startingTown;
    }
    
    public void setStartingTown(Boolean startingTown){
        this.startingTown = startingTown;
    }
    
    public Integer getLatitude(){
        return latitude;
    }
    
    public void setLatitude(Integer latitude){
        this.latitude = latitude;
    }
    
    public Integer getLongitude(){
        return longitude;
    }
    
    public void setLongitude(Integer longitude){
        this.longitude = longitude;
    }
}
