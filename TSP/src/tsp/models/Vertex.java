package tsp.models;

import java.util.List;

public class Vertex {
    
    private Integer idVertex;
    private Integer idNode;
    private List<Vertex> previousVertex;
    private List<Vertex> nextVertex;
    private Double weight;
    
    public Vertex(){}
    
    public Integer getIdVertex(){
        return idVertex;
    }
    
    public void setIdVertex(Integer idVertex){
        this.idVertex = idVertex;
    }
    
    public Integer getIdNode(){
        return idNode;
    }
    
    public void setIdNode(Integer idNode){
        this.idNode = idNode;
    }
    
    public List<Vertex> getPreviousVertex(){
        return previousVertex;
    }
    
    public void setPreviousVertex(List<Vertex> previousVertex){
        this.previousVertex = previousVertex;
    }
    
    public List<Vertex> getNextVertex(){
        return nextVertex;
    }
    
    public void setNextVertex(List<Vertex> nextVertex){
        this.nextVertex = nextVertex;
    }
    
    public Double getWeight(){
        return weight;
    }
    
    public void setWeight(Double weight){
        this.weight = weight;
    }
}
