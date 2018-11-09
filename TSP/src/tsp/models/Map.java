package tsp.models;

import java.util.List;

public class Map {
    
    private List<Town> towns;
    private List<Way> ways;
    
    public Map(){}
    
    public List<Town> getTowns(){
        return towns;
    }
    
    public void setTowns(List<Town> towns){
        this.towns = towns;
    }
    
    public List<Way> getWays(){
        return ways;
    }
    
    public void setWays(List<Way> ways){
        this.ways = ways;
    } 
    
}
