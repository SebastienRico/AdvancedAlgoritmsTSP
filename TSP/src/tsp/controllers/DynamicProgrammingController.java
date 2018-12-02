package tsp.controllers;

import java.util.ArrayList;
import tsp.models.Graph;

public class DynamicProgrammingController implements SolutionControllerInterface {


    @Override
    public void resolveGraph(Graph basicGraph) {

    }

    @Override
    public void resolveTable(Double[][] table) {
        int vertex;
        Double weight;
        ArrayList<String> remainingVertices = new ArrayList<>();
        ArrayList<String> path = new ArrayList();
        for (int i = 0; i < table.length; i++) {
            remainingVertices.add(i + "");
        }
        vertex = Integer.parseInt(remainingVertices.get(0));
        remainingVertices.remove(0);
        path.add(vertex + "");
        weight = g(vertex, remainingVertices, table, 0d, path);
        path.add(vertex + "");
        System.out.println("Path: " + path + ", Weight : " + weight);
    }

    public Double g(int vertex, ArrayList<String> remainingVertices, Double[][] table, Double actualWeight, ArrayList<String> path) {
        Double tmpWeight;
        boolean alreadyChosen = false;
        int length = path.size();
        Double minimumWeight = Double.MAX_VALUE;
        ArrayList<String> tmpRemainingVertices = new ArrayList<>();
        ArrayList<String> temporaryPath;
        tmpRemainingVertices.addAll(remainingVertices);
        if (remainingVertices.isEmpty()) {
            return (table[vertex][0] + actualWeight);
        } else {
            for (int i = 0; i < remainingVertices.size(); i++) {
                temporaryPath = new ArrayList<>();
                temporaryPath.add(remainingVertices.get(i));
                tmpRemainingVertices.remove(remainingVertices.get(i));
                tmpWeight = g(Integer.parseInt(remainingVertices.get(i)), tmpRemainingVertices, table, actualWeight + table[vertex][Integer.parseInt(remainingVertices.get(i))], temporaryPath);
                tmpRemainingVertices.add(remainingVertices.get(i));
                if (tmpWeight < minimumWeight) {
                    if(alreadyChosen){
                        path.subList(length, path.size()).clear();
                    }
                    path.addAll(temporaryPath);
                    minimumWeight = tmpWeight;
                    alreadyChosen = true;
                }
            }
            return minimumWeight;
        }
    }

}
