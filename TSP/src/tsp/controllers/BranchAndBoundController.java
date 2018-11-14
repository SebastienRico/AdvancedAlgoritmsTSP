package tsp.controllers;

import tsp.models.Map;

public class BranchAndBoundController implements SolutionControllerInterface{

    @Override
    public void resolveMap(Map basicMap) {}

    @Override
    public void resolveTable(Double[][] table) {
        // on dit que le maximum optimal est infinit
        Double max = -1d;
        
        // pour la ville où l'on se situe on vérifie le prix du noeud
        // s'il est supérieur au maximum optimal
            // on rejette la branche
        // sinon
            // on sépare en branche suivant les chemins disponibles
            // on prend le premier et on calcule le poids du tableau
            // on réduit le tableau
            // on va à la ville suivante qui n'a pas encore été fait (sauf si c'est pas possible)
            // on ajoute au maximum optimal
    }
    
}
