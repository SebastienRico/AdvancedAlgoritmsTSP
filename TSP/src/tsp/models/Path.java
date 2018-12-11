package tsp.models;

public class Path {
    
    private Node startingNode;
    private Node arrivalNode;
    private Double distance;
    private String color;
    
    public Path(){}
    
    public Path(Node startingNode,
               Node arrivalNode){
        this.startingNode = startingNode;
        this.arrivalNode = arrivalNode;
        // distance entre villeA et villeB = racineCarre((Bx - Ax)^2 + (By - Ay)^2)
        this.distance = Math.sqrt(
                Math.pow(2, arrivalNode.getX() - startingNode.getX()) +
                Math.pow(2, arrivalNode.getY() - startingNode.getY()));
        color = "BLACK";
    }
    
    public Node getStartingNode(){
        return startingNode;
    }
    
    public void setStartingNode(Node startingNode){
        this.startingNode = startingNode;
    }
    
    public Node getArrivalNode(){
        return arrivalNode;
    }
    
    public void setArrivalNode(Node arrivalNode){
        this.arrivalNode = arrivalNode;
    }
    
    public Double getDistance(){
        return distance;
    }
    
    public void setDistance(Double distance){
        this.distance = distance;
    }
    
    public String getColor(){
        return color;
    }
    
    public void setColor(String color){
        this.color = color;
    }
}