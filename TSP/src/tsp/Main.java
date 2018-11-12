package tsp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import tsp.controllers.AddingRemovingEdgeController;
import tsp.controllers.BasicMapController;
import tsp.controllers.BranchAndBoundController;
import tsp.controllers.BrutForceController;
import tsp.controllers.GeneticController;
import tsp.controllers.GreedyController;
import tsp.controllers.RandomController;
import tsp.controllers.SpanningTreeController;
import tsp.models.Map;

public class Main extends Application {
    
    public static Map basicMap; 
    
    @Override
    public void start(Stage primaryStage) {
        //createView(primaryStage);
        
        basicMap = BasicMapController.createBasicMap();
        
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
                brutForce.resolveMap(basicMap);
                break;
            case 1:
                BranchAndBoundController branchAndBound = new BranchAndBoundController();
                branchAndBound.resolveMap(basicMap);
                break;
            case 2:
                AddingRemovingEdgeController addingRemovingEdge = new AddingRemovingEdgeController();
                addingRemovingEdge.resolveMap(basicMap);
                break;
            case 3:
                SpanningTreeController spanningTree = new SpanningTreeController();
                spanningTree.resolveMap(basicMap);
                break;
            case 4:
                GreedyController greedy = new GreedyController();
                greedy.resolveMap(basicMap);
                break;
            case 5:
                RandomController random = new RandomController();
                random.resolveMap(basicMap);
                break;
            default :
                GeneticController genetic = new GeneticController();
                genetic.resolveMap(basicMap);
        }
    }
    
}
