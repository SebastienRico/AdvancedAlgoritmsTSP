package tsp.controllers;

import tsp.models.Map;

public interface SolutionControllerInterface {
    
    public void resolveMap(Map basicMap);
    
    public void resolveTable(Double[][] table);
}
