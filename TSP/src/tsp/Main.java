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
import tsp.controllers.GeneticController;
import tsp.controllers.GreedyController;
import tsp.controllers.RandomController;
import tsp.controllers.SpanningTreeController;
import tsp.models.Graph;
import tsp.models.Vertex;

public class Main extends Application {
    
    public static Double[][] basicMatrice;
    public static Graph basicGraph;
    public static Vertex basicTree;
    
    public static long timeForResoltion;
    
    @Override
    public void start(Stage primaryStage) {
        try {
            // Création de la vue qui va afficher le graphique et les résultats
            createView(primaryStage);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Une erreur est survenue avec l'affichage", ex);
        }
        
        // création d'un tableau basique
        
        // ici vous choisissez la version à exécuter
        //int version = 4;
        //launchGoodOneVersion(version);
    }
    
    public void createView(Stage stage) throws IOException{
        // Création du visuel
        Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void launchGoodOneVersion(int version, Graph graph) {
        long begining;
        switch(version){
            case 0:
                BrutForceController brutForce = new BrutForceController();
                begining = Date.from(Instant.now()).getTime();
                // appeler la méthode avec le graph ou la map
                brutForce.resolveTable(basicMatrice);
                timeForResoltion = Date.from(Instant.now()).getTime() - begining;
                break;
            case 1:
                BranchAndBoundController branchAndBound = new BranchAndBoundController();
                begining = Date.from(Instant.now()).getTime();
                // appeler la méthode avec le graph ou la map
                branchAndBound.resolveTable(basicMatrice);
                timeForResoltion = Date.from(Instant.now()).getTime() - begining;
                break;
            case 2:
                AddingRemovingEdgeController addingRemovingEdge = new AddingRemovingEdgeController();
                begining = Date.from(Instant.now()).getTime();
                addingRemovingEdge.resolveTable(basicMatrice);
                timeForResoltion = Date.from(Instant.now()).getTime() - begining;
                break;
            case 3:
                SpanningTreeController spanningTree = new SpanningTreeController();
                begining = Date.from(Instant.now()).getTime();
                spanningTree.resolveTable(basicMatrice);
                timeForResoltion = Date.from(Instant.now()).getTime() - begining;
                break;
            case 4:
                GreedyController greedy = new GreedyController();
                begining = Date.from(Instant.now()).getTime();
                greedy.resolveTable(basicMatrice);
                timeForResoltion = Date.from(Instant.now()).getTime() - begining;
                break;
            case 5:
                RandomController random = new RandomController();
                begining = Date.from(Instant.now()).getTime();
                random.resolveTable(basicMatrice);
                timeForResoltion = Date.from(Instant.now()).getTime() - begining;
                break;
            default :
                GeneticController genetic = new GeneticController();
                begining = Date.from(Instant.now()).getTime();
                genetic.resolveTable(basicMatrice);
                timeForResoltion = Date.from(Instant.now()).getTime() - begining;
        }
    }
    
}
