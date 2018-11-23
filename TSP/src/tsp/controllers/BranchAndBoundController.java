package tsp.controllers;

import java.util.ArrayList;
import java.util.List;
import tsp.models.Graph;
import tsp.models.Node;

public class BranchAndBoundController implements SolutionControllerInterface{
    
    private static Boolean begining = true;

    @Override
    public void resolveGraph(Graph basicGraph) {}
    
    // créer un noeud
    // calculer le poids du noeud (méthode bound)
    // chercher les possibilités suivantes (méthode branch)
    // pour chaque possibilité
        // ajouter la liste des chemins
        // appeler la méthode précédente

    @Override
    public void resolveTable(Double[][] table) {
        /*if(begining){
            // on dit que le maximum optimal est infinit
            Double minForAlgo = -1d;
            int sizeOfTable = table.length;
            Double[][] reducedTable = table;
            List<Node> path = new ArrayList<>();
            Node currentNode;

            // on part du principe qu'on commence par la ville 0
            // on crée le premier node
            Node initialNode = new Node();
            initialNode.node = 0;
            initialNode.originTable = table;
            initialNode.sizeOfTable = sizeOfTable;
            initialNode.path.add(0);
            
            begining = false;
        }
        
        // on calcule le poids du noeud
        bound(currentNode, minForAlgo);
        
        path.add(initialNode);
        currentNode = initialNode;

        while(path.size()<sizeOfTable){
            branch(currentNode);
        }*/
    }

    /*private void branch(NodeForBranchAndBound currentNode) {
        // lister les branches possibles
        List<Integer> possibleNextNodes = new ArrayList<>();
        for(int i = 0; i < currentNode.originTable.length; i++){
            NodeForBranchAndBound node = new NodeForBranchAndBound();
            node.node = i;
            node.originTable = currentNode.reducedTable;
            node.path.add(node.node);
            node.cost = currentNode.originTable[currentNode.node][i] + currentNode.cost;
        }
        // pour chaque branche créer un neoud
            // calculer le poids
            // réduire la matrice
            // vérifier quel poids
        // retourner le noeud choisi
    }
    
    private void bound(Node currentNode, Double minForAlgo){
        Double weightOfTable = 0d;
        // on cherche le minimunm de la ligne qu'on retranche à la ligne et qu'on ajoute au poids total du tableau
        for(int i = 0; i < currentNode.sizeOfTable; i++){
            Double minOfLine = currentNode.originTable[i][0];
            for(int j = 0; j < currentNode.sizeOfTable; j++){
                if(currentNode.originTable[i][j] < minOfLine){
                    minOfLine = currentNode.originTable[i][j];
                }
            }
            for(int j = 0; j < currentNode.sizeOfTable; j++){
                currentNode.reducedTable[i][j] = currentNode.originTable[i][j] - minOfLine;
            }
            weightOfTable = weightOfTable + minOfLine;
        }
        // on cherche le minimum de la colonne qu'on retranche à la colonne et qu'on ajoute au poids total du tableau
        for(int i = 0; i < currentNode.sizeOfTable; i++){
            Double minOfColumn = currentNode.originTable[0][i];
            for(int j = 0; j < currentNode.sizeOfTable; j++){
                if(currentNode.originTable[j][i] < minOfColumn){
                    minOfColumn = currentNode.originTable[j][i];
                }
            }
            for(int j = 0; j < currentNode.sizeOfTable; j++){
                currentNode.reducedTable[j][i] = currentNode.originTable[j][i] - minOfColumn;
            }
            weightOfTable = weightOfTable + minOfColumn;
        }
        // si on a parcouru un premier chemin
        if(minForAlgo == -1 && currentNode.path.size() == 1){
            minForAlgo = weightOfTable;
        }
    }*/
}
