package tsp.controllers;

import java.util.ArrayList;
import tsp.models.Graph;

public class DynamicProgrammingController implements SolutionControllerInterface{

    @Override
    public void resolveGraph(Graph basicGraph) {
        
    }

    @Override
    public void resolveTable(Double[][] table) {
        int vertex;
        Double weight;
        ArrayList<Integer> remainingVertices = new ArrayList<>();
        for(int i =0; i < table.length; i++){
            remainingVertices.add(i);
        }
        vertex = remainingVertices.get(0);
        remainingVertices.remove(vertex);
        System.out.print("Path : " + vertex);
        weight = g(vertex, remainingVertices, table, 0d);
        System.out.println(", Weight : " + weight);
    }
    
    public Double g(int vertex, ArrayList<Integer> remainingVertices, Double[][] table, Double actualWeight){
        Double minimumWeight= Double.MAX_VALUE;
        Double tmpWeight;
        int vertexChosen=vertex;
        if(remainingVertices.isEmpty()){
            return 0d;
        }
        else{
            for(int i:remainingVertices){
                remainingVertices.remove(i);
                tmpWeight = g(i, remainingVertices, table, actualWeight + table[vertex][i]);
                remainingVertices.add(i);
                if(tmpWeight < minimumWeight){
                    minimumWeight = tmpWeight;
                    vertexChosen = i;
                }
            }
            System.out.print(", " + vertexChosen);
            return minimumWeight;
        }
    }

    
}
