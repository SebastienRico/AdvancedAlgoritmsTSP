package tsp.controllers;


import java.util.ArrayList;

import tsp.models.Graph;

public class RandomController implements SolutionControllerInterface {
    
    public ArrayList<Integer> path = new ArrayList<>();
    public Double weight = 0.0;

    @Override
    public void resolveGraph(Graph basicGraph) {
        
    }

    @Override
    public void resolveTable(Double[][] table) {
        boolean inPath;
        int length = table[0].length;
        int firstVertex;
        int random1;
        int random2=0;
        random1 = (int) ((Math.random() * 1000 * length) % length);
        firstVertex=random1;
        path.add(random1);
        for (int i = 1; i < length; i++) {

            inPath = true;
            while (inPath) {
                inPath = false;
                random2 = (int) ((Math.random() * 1000 * length) % length);
                if (path.contains(random2)) {
                    inPath = true;
                }
            }

            path.add(random2);
            weight += table[random1][random2];
            random1 = random2;

        }
        path.add(firstVertex);
        weight+= table[random2][firstVertex];
    }

}
