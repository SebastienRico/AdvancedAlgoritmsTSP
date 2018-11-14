package tsp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import tsp.controllers.AddingRemovingEdgeController;
import tsp.controllers.BasicTableController;
import tsp.controllers.BranchAndBoundController;
import tsp.controllers.BrutForceController;
import tsp.controllers.GeneticController;
import tsp.controllers.GreedyController;
import tsp.controllers.RandomController;
import tsp.controllers.SpanningTreeController;
import tsp.models.Map;

public class Main extends Application {
    
    public static Map basicMap; 
    public static Double[][] basicTable;
    
    @Override
    public void start(Stage primaryStage) {
        // Création de la vue qui va afficher le graphique et les résultats
        //createView(primaryStage);
        
        // création d'une carte basique (pour plus tard)
        //basicMap = BasicMapController.createBasicMap();
        
        // création d'un tableau basique
        basicTable = BasicTableController.createBasicTable();
        
        // ici vous choisissez la version à exécuter
        int version = 1;
        launchGoodOneVersion(version);
    }
    
    public void createView(Stage primaryStage){
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void launchGoodOneVersion(int version) {
        switch(version){
            case 0:
                BrutForceController brutForce = new BrutForceController();
                brutForce.resolveTable(basicTable);
                break;
            case 1:
                BranchAndBoundController branchAndBound = new BranchAndBoundController();
                branchAndBound.resolveTable(basicTable);
                break;
            case 2:
                AddingRemovingEdgeController addingRemovingEdge = new AddingRemovingEdgeController();
                addingRemovingEdge.resolveTable(basicTable);
                break;
            case 3:
                SpanningTreeController spanningTree = new SpanningTreeController();
                spanningTree.resolveTable(basicTable);
                break;
            case 4:
                GreedyController greedy = new GreedyController();
                greedy.resolveTable(basicTable);
                break;
            case 5:
                RandomController random = new RandomController();
                random.resolveTable(basicTable);
                break;
            default :
                GeneticController genetic = new GeneticController();
                genetic.resolveTable(basicTable);
        }
    }
    
}
