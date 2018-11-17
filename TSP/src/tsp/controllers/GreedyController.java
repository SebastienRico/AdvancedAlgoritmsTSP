package tsp.controllers;

import java.util.ArrayList;
import java.util.List;
import tsp.models.Graph;

public class GreedyController implements SolutionControllerInterface {

    List<Integer> visited = new ArrayList<>();
    double total_cost = 0;

    //PLus besoin de cette map.
    @Override
    public void resolveGraph(Graph basicGraph) {
        
    }

    @Override
    public void resolveTable(Double[][] table) {

        Double[][] tsptable = table;

        double min_cost = Double.POSITIVE_INFINITY;
        int startcity = 0;
        int nextCity = 0;
        int currentCity = startcity;
        
        while (visited.size() < tsptable.length) {
            for (int i = 0; i < tsptable.length; i++) {
                if (i == currentCity) {
                    visited.add(currentCity);
                    for (int j = 0; j < tsptable.length; j++) {
                        if (!visited.contains(j)) {
                            double temp_min_cost = tsptable[i][j];
                            if (temp_min_cost < min_cost) {
                                min_cost = temp_min_cost;
                                nextCity = j;
                            }
                        }
                        if (visited.size() == tsptable.length && j == startcity) {
                            double temp_min_cost = tsptable[i][j];
                            if (temp_min_cost < min_cost) {
                                min_cost = temp_min_cost;
                                total_cost += min_cost;
                            }
                        }
                    }
                    currentCity = nextCity;
                    total_cost += min_cost;
                    min_cost = Double.POSITIVE_INFINITY;
                    System.out.println(getPath());
                }
            }
        }

    }

    public String getPath() {
        return "Path: " + visited.toString() + "Cost: " + total_cost;
    }

}
