package tsp.controllers;

import java.util.ArrayList;
import java.util.List;
import tsp.Main;
import tsp.models.Graph;
import tsp.models.Permutations;

public class BrutForceController implements SolutionControllerInterface{

    @Override
    public void resolveGraph(Graph graph) {
        int size = graph.getNodes().size();
        double  min =999899999;
        int[] indices;
        ArrayList<String> elements = new ArrayList<>();
        for(int i=0;i<graph.getNodes().size();i++){
            elements.add(Integer.toString(graph.getNodes().get(i).getId()));
            
        }
        for(int i=0;i<graph.getNodes().size();i++){
            
                System.out.println("City "+graph.getNodes().get(i).getId()+": "+graph.getNodes().get(i).getX()+" "+graph.getNodes().get(i).getY());
   
        }
        
        long permutations = Permutations.factorial(elements.size());
        ArrayList optimalPath= new ArrayList();
        List test ;
        System.out.printf("The representation of the TSP :\n\n");
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                System.out.print(Math.floor(Main.matrice[i][j] * 100) / 100+"\t|\t");
            }
            System.out.println("\n");
        }
        System.out.println("###################################################");
        System.out.println("Paths with costs");
        for(int i=0;i<permutations;i++){
            test = Permutations.permutation(i, elements);
            test.add(test.get(0));
            if (min > calculeDistance((ArrayList<String>) test, graph)){
                min = calculeDistance((ArrayList<String>) test, graph);
                optimalPath=(ArrayList<String>) test;
            }
            System.out.println(i + ": " + test+" cost:"+Math.floor(calculeDistance((ArrayList<String>) test, graph)* 100) / 100 );
        }    
        System.out.println("#######################################################################################");
        System.out.println("The minimum cost= "+ Math.floor(min * 100) / 100 +" The optimal path= "+optimalPath);
        
    }

    @Override
    public void resolveTable(Double[][] table) {
        
    }
    
    public static  double calculeDistance(ArrayList<String> list, Graph g){
        int previousElement =Integer.parseInt(list.get(0));
        double sumOfDistance=0;
        double distance;
        
        for(int i=1;i<list.size();i++){
            distance=Main.matrice[Integer.parseInt(list.get(i)) - 1][previousElement - 1];
            sumOfDistance=sumOfDistance+distance;
            previousElement=Integer.parseInt(list.get(i));
           
        }
        return sumOfDistance;
    }
}
