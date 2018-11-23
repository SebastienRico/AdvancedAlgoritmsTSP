package tsp.controllers;

import tsp.models.Graph;

public interface SolutionControllerInterface {
    
    public void resolveGraph(Graph basicGraph);
    
    public void resolveTable(Double[][] table);
}
