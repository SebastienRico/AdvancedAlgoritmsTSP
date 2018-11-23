package tsp.models;

import java.util.List;

public class Solution {
    
    private List<Integer> pathsTaken;
    private Double weight;
    
    public Solution(){}
    
    public Solution(List<Integer> pathsTaken,
                    Double weight){
        this.pathsTaken = pathsTaken;
        this.weight = weight;
    }
    
    public List<Integer> getPathsTaken(){
        return pathsTaken;
    }
    
    public void setPathsTaken(List<Integer> pathsTaken){
        this.pathsTaken = pathsTaken;
    }
    
    public Double getWeight(){
        return weight;
    }
    
    public void setWeight(Double weight){
        this.weight = weight;
    }
}
