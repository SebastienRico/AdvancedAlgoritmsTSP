package tsp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
        for(int i = 0; i < nbTowns; i++){
            Boolean startingNode = false;
            if(i == 0){
                startingNode = true;
            }
            Random r = new Random();
            int x = r.nextInt(1000);
            int y = r.nextInt(1000);
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

    public static Double[][] transformeGraphToMatrice(Graph graph) {
        Double[][] matrice = null;
        graph.getPaths().forEach(p -> {
            matrice[p.getStartingNode().getId()][p.getArrivalNode().getId()] = p.getDistance();
        });
        return matrice;
    }

    public static Graph createGraphFromFile(SingleSelectionModel<String> selectionModel) {
        Graph graph = new Graph();
        // parser le fichier passé en paramètre et le convertir en graph
        return graph;
    }
    
}