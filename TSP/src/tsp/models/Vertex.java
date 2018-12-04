package tsp.models;

public class Vertex {
    
    private Integer idVertex; // corespond to the idNode of node
    private Double weight;
    
    public Vertex(){
        this.weight = 0d;
    }
    
    public Vertex(Integer idVertex){
        this.idVertex = idVertex;
        this.weight = 0d;
    }
    
    public Integer getIdVertex(){
        return idVertex;
    }
    
    public void setIdVertex(Integer idVertex){
        this.idVertex = idVertex;
    }
    
    public Double getWeight(){
        return weight;
    }
    
    public void setWeight(Double weight){
        this.weight = weight;
    }
}
