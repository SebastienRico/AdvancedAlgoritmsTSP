package tsp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import tsp.models.Graph;
import tsp.models.Node;
import tsp.models.Path;

public class Parseur {

    Graph graphFromFile(String selectedItem) {
        Graph graph = new Graph();
        try {
            File file = FileController.getFileWithName(selectedItem);
            Scanner scanner = new Scanner(file);
            List<Node> nodes = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineSplited = line.split(" ");
                List<Integer> node = new ArrayList<>();
                for(int i = 0; i < lineSplited.length; i++){
                    if(!lineSplited[i].isEmpty()){
                        try {
                            node.add(Integer.parseInt(lineSplited[i]));
                        } catch(NumberFormatException ex){
                            break;
                        }
                    }
                }
                if(node.size() == 3){
                    Node n = new Node();
                    n.setName(node.get(0));
                    n.setX(node.get(1));
                    n.setY(node.get(2));
                    nodes.add(n);
                }
            }
            nodes.get(0).setStartingNode(true);
            List<Path> paths = new ArrayList<>();
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
            scanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Parseur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return graph;
    }
    
}
