package tsp.controllers;

import java.util.ArrayList;
import tsp.models.Map;

public class RandomController implements SolutionControllerInterface {

    @Override
    public void resolveMap(Map basicMap) {

    }

    @Override
    public void resolveTable(Double[][] table) {
        boolean inPath;
        Double weight = 0.0;
        int length = table[0].length;
        ArrayList<Integer> path = new ArrayList<>();
        int random1;
        int random2;

        random1 = (int) (Math.random() % length);
        path.add(random1);
        for (int i = 1; i < length; i++) {
            inPath = true;
            while (inPath) {
                inPath = false;
                random2 = (int) (Math.random() % length);
                if(path.contains(random2))
                    inPath = true;
                path.add(random2);
                weight+= table[random1][random2];
                random1 = random2;
            }

        }
        

    }

}
