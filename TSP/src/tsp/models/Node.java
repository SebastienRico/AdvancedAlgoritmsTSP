package tsp.models;

public class Node {
    
    private Integer id;
    private Boolean startingNode;
    private Integer x;
    private Integer y;
    private String color;
    
    public Node(){}
    
    public Node(Integer id,
                Boolean startingNode,
                Integer x,
                Integer y){
        this.id = id;
        this.startingNode = startingNode;
        this.x = x;
        this.y = y;
        this.color = "BLACK";
    }
    
    public Integer getId(){
        return id;
    }
    
    public void setName(Integer id){
        this.id = id;
    }
    
    public Boolean getStartingNode(){
        return startingNode;
    }
    
    public void setStartingNode(Boolean startingNode){
        this.startingNode = startingNode;
    }
    
    public Integer getX(){
        return x;
    }
    
    public void setX(Integer x){
        this.x = x;
    }
    
    public Integer getY(){
        return y;
    }
    
    public void setY(Integer y){
        this.y = y;
    }
    
    public String getColor(){
        return color;
    }
    
    public void setColor(String color){
        this.color = color;
    }
}
