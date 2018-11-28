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
            Boolean startOfTheGraph = false;
            while (scanner.hasNextLine() && !scanner.nextLine().equalsIgnoreCase("EOF")) {
                String line = scanner.nextLine();
                if (startOfTheGraph) {
                    System.out.println("Line : " + line);

                    String[] lineSplited = line.split(" ");
                    List<Integer> node = new ArrayList<>();
                    for (int i = 0; i < lineSplited.length; i++) {
                        System.out.println("lineSplited[" + i + "] : " + lineSplited[i]);
                        if (lineSplited[i] != "' '") {
                            try {
                                node.add(Integer.parseInt(lineSplited[i]));
                            } catch (NumberFormatException ex) {
                                break;
                            }
                        }
                    }

                    System.out.println("Liste de node : " + node.toString());

                    if (node.size() == 3) {
                        Node n = new Node();
                        n.setName(Integer.parseInt(node.get(0).toString()));
                        n.setX(node.get(1));
                        n.setY(node.get(2));

                        System.out.println("Node : " + node.get(0) + " x : " + node.get(1) + " y : " + node.get(2));

                        nodes.add(n);
                    }
                }
                if (line.equals("NODE_COORD_SECTION")) {
                    startOfTheGraph = true;
                }
            }

            System.out.println("Liste de nodes : " + nodes.toString());

            nodes.get(0).setStartingNode(true);
            List<Path> paths = new ArrayList<>();
            nodes.forEach(n -> {
                for (int j = 0; j < nodes.size(); j++) {
                    Path p = new Path(n, nodes.get(j));
                    if (nodes.indexOf(n) == j) {
                        p.setDistance(Double.POSITIVE_INFINITY);
                    }

                    System.out.println("Path de " + p.getStartingNode().getId() + " a " + p.getArrivalNode().getId() + " : " + p.getDistance());

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
