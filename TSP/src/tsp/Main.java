package tsp;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tsp.controllers.AddingRemovingEdgeController;
import tsp.controllers.BranchAndBoundController;
import tsp.controllers.BrutForceController;
import tsp.controllers.DynamicProgrammingController;
import tsp.controllers.GeneticController;
import tsp.controllers.GreedyController;
import tsp.controllers.RandomController;
import tsp.controllers.SpanningTreeController;
import tsp.models.Graph;

public class Main extends Application {
    
    private Parent root;
    
    public static Double[][] matrice;
    public static Graph graph;
    
    public static long timeForResoltion;
    public static String path;
    
    @Override
    public void start(Stage primaryStage) {
        try {
            // Création de la vue qui va afficher le graphique et les résultats
            createView(primaryStage);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Une erreur est survenue avec l'affichage", ex);
        }
        
        // création d'un tableau basique
        matrice = MatriceController.createBasicMatrice();
        
        // ici vous choisissez la version à exécuter
        //int version = 1;
        //launchGoodOneVersion(version);
    }
    
    public void createView(Stage stage) throws IOException{
        // Création du visuel
        root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void launchGoodOneVersion(int version) {
        long begining;
        StringBuilder s = new StringBuilder();
        System.out.println("");
        switch(version){
            case 0:
                System.out.println("BRUT FORCE");
                BrutForceController brutForce = new BrutForceController();
                begining = Date.from(Instant.now()).getTime();
                //brutForce.resolveTable(matrice);
                brutForce.resolveGraph(graph);
                timeForResoltion = Date.from(Instant.now()).getTime() - begining;
                brutForce.optimalPath.forEach(n -> {
                    s.append(n.toString());
                });
                path = s.toString();
                System.out.println("TIME : " + timeForResoltion + " millisecondes");
                System.out.println(path);
                System.out.println("COST : " + brutForce.min);
                break;
            case 1:
                System.out.println("BRANCH AND BOUND");
                BranchAndBoundController branchAndBound = new BranchAndBoundController();
                begining = Date.from(Instant.now()).getTime();
                branchAndBound.resolveTable(matrice);
                //branchAndBound.resolveGraph(graph);
                timeForResoltion = Date.from(Instant.now()).getTime() - begining;
                s.append("PATH : ");
                branchAndBound.nodesVisited.forEach(n -> {
                    s.append(n.getIdVertex());
                });
                path = s.toString();
                System.out.println("TIME : " + timeForResoltion + " millisecondes");
                System.out.println(path);
                break;
            case 2:
                AddingRemovingEdgeController addingRemovingEdge = new AddingRemovingEdgeController();
                begining = Date.from(Instant.now()).getTime();
                addingRemovingEdge.resolveTable(matrice);
                //addingRemovingEdge.resolveGraph(graph);
                timeForResoltion = Date.from(Instant.now()).getTime() - begining;
                break;
            case 3:
                SpanningTreeController spanningTree = new SpanningTreeController();
                begining = Date.from(Instant.now()).getTime();
                spanningTree.resolveTable(matrice);
                //spanningTree.resolveGraph(graph);
                timeForResoltion = Date.from(Instant.now()).getTime() - begining;
                break;
            case 4:
                System.out.println("GREEDY");
                GreedyController greedy = new GreedyController();
                begining = Date.from(Instant.now()).getTime();
                greedy.resolveTable(matrice);
                //greedy.resolveGraph(graph);
                timeForResoltion = Date.from(Instant.now()).getTime() - begining;
                path = greedy.getPath();
                System.out.println("TIME : " + timeForResoltion + " millisecondes");
                System.out.println("PATH : " + path);
                System.out.println("COST : " + greedy.total_cost);
                break;
            case 5:
                System.out.println("RANDOM");
                RandomController random = new RandomController();
                begining = Date.from(Instant.now()).getTime();
                random.resolveTable(matrice);
                //random.resolveGraph(graph);
                timeForResoltion = Date.from(Instant.now()).getTime() - begining;
                System.out.println("TIME : " + timeForResoltion + " millisecondes");
                path = random.path.toString();
                System.out.println("PATH : " + path);
                System.out.println("COST : " + random.weight);
                break;
            case 6 :
                System.out.println("DYNAMIC");
                DynamicProgrammingController dynamic = new DynamicProgrammingController();
                begining = Date.from(Instant.now()).getTime();
                dynamic.resolveTable(matrice);
                timeForResoltion = Date.from(Instant.now()).getTime() - begining;
                System.out.println("TIME : " + timeForResoltion + " millisecondes");
                path = dynamic.path.toString();
                System.out.println("PATH : " + path);
                System.out.println("COST : " + dynamic.weight);
                break;
            default :
                GeneticController genetic = new GeneticController();
                begining = Date.from(Instant.now()).getTime();
                genetic.resolveTable(matrice);
                //genetic.resolveGraph(graph);
                timeForResoltion = Date.from(Instant.now()).getTime() - begining;
        }
    }
    
}
