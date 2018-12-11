package tsp.models;

import java.util.List;

public class Graph {
    
    private List<Node> nodes;
    private List<Path> paths;
    
    public Graph(){}
    
    public List<Node> getNodes(){
        return nodes;
    }
    
    public void setNodes(List<Node> nodes){
        this.nodes = nodes;
    }
    
    public List<Path> getPaths(){
        return paths;
    }
    
    public void setPaths(List<Path> paths){
        this.paths = paths;
    } 
    
}