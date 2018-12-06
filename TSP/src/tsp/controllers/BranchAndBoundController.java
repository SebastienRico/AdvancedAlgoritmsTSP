package tsp.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tsp.models.Graph;
import tsp.models.Vertex;

public class BranchAndBoundController implements SolutionControllerInterface{
    
    public List<Vertex> noeudDejaVisite = new ArrayList<>();
    
    @Override
    public void resolveGraph(Graph basicGraph) {}

    @Override
    public void resolveTable(Double[][] matrice) {
        
        int size = matrice.length;
        
        Map<Vertex, Double[][]> reducedMatrixForEachNode = new HashMap();
        if(noeudDejaVisite.isEmpty()){
            noeudDejaVisite.add(new Vertex(1));
        }
        List<Vertex> nodesToVisit = getAllNodesToVisit(matrice);

        // si aucune ville n'a encore été visitée ou si toutes les villes ont été visitées
        if(nodesToVisit.isEmpty()){
            System.out.println("Toutes les villes sont visitées");
            return;
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
                    if(reducedMatrix[i][j] != Double.POSITIVE_INFINITY && reducedMatrix[i][j]!=0){
                        reducedMatrix[i][j] = reducedMatrix[i][j] - minOfLine;
                    }
                }
                if(!minOfLine.equals(Double.POSITIVE_INFINITY)){
                    prochaineVille.setWeight(prochaineVille.getWeight() + minOfLine);
                }
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
                    if(reducedMatrix[j][i] != Double.POSITIVE_INFINITY && reducedMatrix[j][i]!=0){
                        reducedMatrix[j][i] = reducedMatrix[j][i] - minOfColumn;
                    }
                }
                if(!minOfColumn.equals(Double.POSITIVE_INFINITY)){
                    prochaineVille.setWeight(prochaineVille.getWeight() + minOfColumn);
                }
            }
            
            int x = noeudDejaVisite.get(noeudDejaVisite.size()-1).getIdVertex()-1;
            int y = prochaineVille.getIdVertex()-1;
            if(x != y ){
                prochaineVille.setWeight(prochaineVille.getWeight() + matrice[x][y]);
            }
            
            for(int i = 0; i < size; i++){
                Double minOfColumn = Double.POSITIVE_INFINITY;
            }
            
            // on ajoute à la map de villes associées à leur matrice
            reducedMatrixForEachNode.put(prochaineVille, reducedMatrix);
        });
        
        // on cherche le ou les poids le ou les plus petit dans la map
        Map<Vertex, Double[][]> smallerVerteces = getNextNodes(reducedMatrixForEachNode);
        
        if(smallerVerteces.entrySet().iterator().hasNext()){
            Map.Entry<Vertex, Double[][]> e = smallerVerteces.entrySet().iterator().next();
            
            for(int j = 0; j < size; j++){
                e.getValue()[noeudDejaVisite.get(noeudDejaVisite.size()-1).getIdVertex()-1][j] = Double.POSITIVE_INFINITY;
            }
            noeudDejaVisite.add(e.getKey());
            // on nettoie le reste de la matrice
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    if(iAndJInFinalPath(i,j)){
                        e.getValue()[i][j] = Double.POSITIVE_INFINITY;
                    }
                }
                if(i == e.getKey().getIdVertex() -1){
                    for(int j=0; j<size; j++){
                        e.getValue()[j][i] = Double.POSITIVE_INFINITY;
                    }
                }
            }
            resolveTable(e.getValue());
        }
    }

    private boolean iAndJInFinalPath(int i, int j) {
        List<Integer> villesVisitees = new ArrayList<>();
        noeudDejaVisite.forEach(v -> {
            villesVisitees.add(v.getIdVertex());
        });
        if(villesVisitees.contains(i+1) && villesVisitees.contains(j+1)){
            return true;
        }
        return false;
    }
    
    private List<Vertex> getAllNodesToVisit(Double[][] matrice){
        int size = matrice.length;
        List<Vertex> nodesToVisit = new ArrayList<>();
        
        for(int i = 0; i < size; i++){
            Boolean t = false;
            for(int j = 0; j < size; j++){
                if(!t){
                    t = matrice[i][j] != Double.POSITIVE_INFINITY;
                }
            }
            if(t){
                Vertex v = new Vertex(i + 1);
                Boolean nodeInList = false;
                for(int k=0; k< noeudDejaVisite.size(); k++){
                    if(noeudDejaVisite.get(k).getIdVertex().equals(v.getIdVertex())){
                        nodeInList = true;
                        break;
                    }
                }
                if(!nodeInList){
                    nodesToVisit.add(v);
                }
            }
        }
        return nodesToVisit;
    }
    
    private Map<Vertex, Double[][]> getNextNodes(Map<Vertex, Double[][]> reducedMatrixForEachNode){
        // on cherche le ou les poids le ou les plus petit dans la map
        Double minForChild = Double.POSITIVE_INFINITY;
        Map<Vertex, Double[][]> smallerVerteces = new HashMap<>();
        for(Map.Entry<Vertex, Double[][]> entry : reducedMatrixForEachNode.entrySet()){
            if(entry.getKey().getWeight() <= minForChild){
                minForChild = entry.getKey().getWeight();
            }
        }
        for(Map.Entry<Vertex, Double[][]> entry : reducedMatrixForEachNode.entrySet()){
            if(entry.getKey().getWeight().equals(minForChild)){
                smallerVerteces.put(entry.getKey(), entry.getValue());
            }
        }
        return smallerVerteces;
    }

}
