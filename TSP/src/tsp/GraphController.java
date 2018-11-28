package tsp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.SingleSelectionModel;
import tsp.models.Graph;
import tsp.models.Node;
import tsp.models.Path;

public class GraphController {

    public static Graph createRandomGraph(int nbTowns) {
        Graph graph = new Graph();
        List<Node> nodes = new ArrayList<>();
        List<Path> paths = new ArrayList<>();
        // crée de façon random des villes et les ajoute à la liste de "nodes"
        for(int i = 1; i <= nbTowns; i++){
            Boolean startingNode = false;
            if(i == 1){
                startingNode = true;
            }
            Random r = new Random();
            Integer x = r.nextInt(1000);
            Integer y = r.nextInt(1000);
            Node n = new Node(i, startingNode, x, y);
            nodes.add(n);
        }
        // crée toutes les possibilités de connexion entre les villes et les ajoute à la liste de "paths"
        
        nodes.forEach(n -> {
            for(int j = 0; j < nodes.size(); j++){
                Path p = new Path(n, nodes.get(j));
                if(nodes.indexOf(n) == j){
                    p.setDistance(Double.POSITIVE_INFINITY);
                }
                paths.add(p);
            }
        });
        graph.setNodes(nodes);
        graph.setPaths(paths);
        return graph;
    }

    public static Double[][] transformeGraphToMatrice(Graph graph) throws Exception {
        if(graph != null){
            throw new Exception();
        }
        int size = graph.getNodes().size();
        
        System.out.println("Taille de la matrice : " + size);
        
        Double[][] matrice = new Double[size][size];
        graph.getPaths().forEach(p -> {
            int x = p.getStartingNode().getId()-1;
            int y = p.getArrivalNode().getId()-1;
            matrice[p.getStartingNode().getId()-1][p.getArrivalNode().getId()-1] = p.getDistance();
            
            System.out.println("Matrice [" + x + "][" + y + "] = " + p.getDistance());
        });
        return matrice;
    }

    public static Graph createGraphFromFile(SingleSelectionModel<String> selectionModel) {
        Parseur parseur = new Parseur();
        Graph graph = parseur.graphFromFile(selectionModel.getSelectedItem());
        return graph;
    }
    
}
