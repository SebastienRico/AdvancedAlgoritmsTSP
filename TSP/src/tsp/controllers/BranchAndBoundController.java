package tsp.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tsp.models.Graph;
import tsp.models.Vertex;

public class BranchAndBoundController implements SolutionControllerInterface{
    
    private List<Vertex> pathToFollow = new ArrayList<>();
    
    @Override
    public void resolveGraph(Graph basicGraph) {}

    @Override
    public void resolveTable(Double[][] matrice) {
        
        int size = matrice.length;
        
        Map<Vertex, Double[][]> reducedMatrixForEachNode = new HashMap();
        List<Vertex> nodesToVisit = getAllNodesToVisit(matrice);
        
        
        // si aucune ville n'a encore été visitée ou si toutes les villes ont été visitées
        if(nodesToVisit.isEmpty()){
            System.out.println("Toutes les villes sont visitées");
            return;
        } else {
            pathToFollow.add(nodesToVisit.get(0));
            nodesToVisit.remove(nodesToVisit.get(0));
        }
        
        
        // pour les prochaines villes
        nodesToVisit.forEach(prochaineVille -> {
            Double[][] reducedMatrix = new Double[size][size];//matrice;
            
            for(int i =0; i<size; i++){
                for(int j =0; j<size; j++){
                    reducedMatrix[i][j] = matrice[i][j];
                }
            }
            
            // on cherche le minimum de la ligne de la matrice et on le soustrait à la ligne
            for(int i = 0; i < size; i++){
                Double minOfLine = Double.POSITIVE_INFINITY;
                for(int j = 0; j < size; j++){
                    if(reducedMatrix[i][j] < minOfLine && reducedMatrix[i][j] != Double.POSITIVE_INFINITY){
                        minOfLine = reducedMatrix[i][j];
                    }
                }
                for(int j = 0; j < size; j++){
                    if(reducedMatrix[i][j] != Double.POSITIVE_INFINITY){
                        reducedMatrix[i][j] = reducedMatrix[i][j] - minOfLine;
                    }
                }
                prochaineVille.setWeight(prochaineVille.getWeight() + minOfLine);
            }
            
            // on cherche le minimum de la colonne de la matrice et on le soustrait à la colonne
            for(int i = 0; i < size; i++){
                Double minOfColumn = Double.POSITIVE_INFINITY;
                for(int j = 0; j < size; j++){
                    if(reducedMatrix[j][i] < minOfColumn && reducedMatrix[j][i] != Double.POSITIVE_INFINITY){
                        minOfColumn = reducedMatrix[j][i];
                    }
                }
                for(int j = 0; j < size; j++){
                    if(reducedMatrix[j][i] != Double.POSITIVE_INFINITY){
                        reducedMatrix[j][i] = reducedMatrix[j][i] - minOfColumn;
                    }
                }
                prochaineVille.setWeight(prochaineVille.getWeight() + minOfColumn);
            }
            
            // on nettoie le reste de la matrice
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    if(iAndJInFinalPath(i,j)){
                        reducedMatrix[i][j] = Double.POSITIVE_INFINITY;
                    }
                    if(j == pathToFollow.get(0).getIdVertex() - 1){
                        reducedMatrix[i][j] = Double.POSITIVE_INFINITY;
                    }
                    if(j == prochaineVille.getIdVertex() -1){
                        reducedMatrix[j][i] = Double.POSITIVE_INFINITY;
                    }
                }
            }
            
            // on ajoute à la map de villes associées à leur matrice
            reducedMatrixForEachNode.put(prochaineVille, reducedMatrix);
        });
        
        // on cherche le ou les poids le ou les plus petit dans la map
        Map<Vertex, Double[][]> smallerVerteces = getNextNodes(reducedMatrixForEachNode);
        
        // ici boucler mais si jamais le poids devient trop important il laisser tomber et revenir sur un moins gros
        smallerVerteces.forEach((k,v) -> {
            //getFirst ?
            System.out.println("On boucle : " + k.getIdVertex());
        });
        
    }

    private boolean iAndJInFinalPath(int i, int j) {
        List<Integer> villesVisitees = new ArrayList<>();
        pathToFollow.forEach(v -> {
            villesVisitees.add(v.getIdVertex());
        });
        if(villesVisitees.contains(i) && villesVisitees.contains(j)){
            return true;
        }
        return false;
    }
    
    private List<Vertex> getAllNodesToVisit(Double[][] matrice){
        int size = matrice.length;
        List<Vertex> nodesToVisit = new ArrayList<>();
        
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(matrice[i][j] != Double.POSITIVE_INFINITY){
                    Vertex v = new Vertex(i + 1);
                    nodesToVisit.add(v);
                    if(i + 1 < size){
                        i++;
                    } else {
                        break;
                    }
                    j=-1;
                }
            }
        }
        return nodesToVisit;
    }
    
    private Map<Vertex, Double[][]> getNextNodes(Map<Vertex, Double[][]> reducedMatrixForEachNode){
        // on cherche le ou les poids le ou les plus petit dans la map
        Double minForChild = Double.POSITIVE_INFINITY;
        for(Map.Entry<Vertex, Double[][]> entry : reducedMatrixForEachNode.entrySet()){
            if(entry.getKey().getWeight() <= minForChild){
                minForChild = entry.getKey().getWeight();
            }
        }
        Map<Vertex, Double[][]> smallerVerteces = new HashMap<>();
        for(Map.Entry<Vertex, Double[][]> entry : reducedMatrixForEachNode.entrySet()){
            Boolean t = entry.getKey().getWeight() == minForChild;
            if(entry.getKey().getWeight().equals(minForChild)){
                smallerVerteces.put(entry.getKey(), entry.getValue());
            }
        }
        return smallerVerteces;
    }

}
