package tsp;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import tsp.models.Graph;

public class MainViewController implements Initializable {
    
    private final String MAIN_TITLE = "Traveling Selleman Problem";
    private final String AUTORS = "Directed by Léo GAUTHERON and Amaury HABRARD; Carried out by Samia BOUKENNA, Céline BUFFAT, Maleine PATURAL and Sébastien RICO";
    private final String MAPS_TITLE = "MAPS";
    private final String APPROCHES_TITLE = "RESOLVING APPROCHES";
    private final String DESCRIPTION_TITLE = "Description of the approche";
    private final String TIME_TITLE = "Time to resolve the problem";
    
    private final String EXISTING_MAP = "Existing map";
    private final String NEW_MAP = "New map";
    private final String CHOOSE_YOUR_MAP = "Choose your map";
    private final String NUMBER_OF_TOWNS = "Number of towns";
    
    private final String BRUT_FORCE = "Brut force";
    private final String BRANCH_BOUND = "Branch and bound";
    private final String ADDING_REMOVING = "Adding and removing edges";
    private final String SPANNING_TREE = "Spanning tree";
    private final String GREEDY = "Greedy";
    private final String RANDOM = "Random";
    private final String DYNAMIC = "Dynamic";
    private final String GENETIC = "Genetic";
    
    private final String RESOLVE = "Resolve";
    private final String RESOLVE_ALL = "Try all";
    
    private final String DESCRIPTION_BRUT_FORCE = "Description Brut force";
    private final String DESCRIPTION_BRANCH_BOUND = "Description Branch and bound";
    private final String DESCRIPTION_ADDING_REMOVING = "Description Adding and removing edges";
    private final String DESCRIPTION_SPANNING_TREE = "Description Spanning tree";
    private final String DESCRIPTION_GREEDY = "Description Greedy";
    private final String DESCRIPTION_RANDOM = "Description Random";
    private final String DESCRIPTION_DYNAMIC = "Description Dynamic";
    private final String DESCRIPTION_GENETIC = "Description Genetic";
    
    private final int BRUT_FORCE_APPROCHE = 0;
    private final int BRANCH_BOUND_APPROCHE = 1;
    private final int ADDING_REMOVING_EDGES_APPROCHE = 2;
    private final int SPANNING_TREE_APPROCHE = 3;
    private final int GREEDY_APPROCHE = 4;
    private final int RANDOM_APPROCHE = 5;
    private final int DYNAMIC_APPROCHE = 6;
    private final int GENETIC_APPROCHE = 7;
    
    @FXML
    private Label mainTitle;
    @FXML
    private Label autors;
    @FXML
    private Label mapsTitle;
    @FXML
    private Label approchesTitle;
    @FXML
    private Label descriptionTitle;
    @FXML
    private Label timeTitle;
    @FXML
    private ComboBox<String> mapsCombobox;
    @FXML
    private RadioButton typeOfMapsExistingMap;
    @FXML
    private RadioButton typeOfMapsNewMap;
    @FXML
    private TextField nbTownsToGenerate;
    @FXML
    private RadioButton approchesChoicesBrutForce;
    @FXML
    private RadioButton approchesChoicesBranchBound;
    @FXML
    private RadioButton approchesChoicesAddingRemoving;
    @FXML
    private RadioButton approchesChoicesSpanningTree;
    @FXML
    private RadioButton approchesChoicesGreedy;
    @FXML
    private RadioButton approchesChoicesDynamic;
    @FXML
    private RadioButton approchesChoicesRandom;
    @FXML
    private RadioButton approchesChoicesGenetic;
    @FXML
    private Button solverBtn;
    @FXML
    private ToggleGroup typeOfMaps;
    @FXML
    private ToggleGroup approchesChoices;
    @FXML
    private TextArea description;
    @FXML
    private Button solverAllBtn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        mainTitle.setText(MAIN_TITLE);
        autors.setText(AUTORS);
        mapsTitle.setText(MAPS_TITLE);
        approchesTitle.setText(APPROCHES_TITLE);
        descriptionTitle.setText(DESCRIPTION_TITLE);
        timeTitle.setText(TIME_TITLE);
        
        typeOfMapsExistingMap.setText(EXISTING_MAP);
        typeOfMapsExistingMap.setToggleGroup(typeOfMaps);
        typeOfMapsNewMap.setText(NEW_MAP);
        typeOfMapsNewMap.setToggleGroup(typeOfMaps);
        
        mapsCombobox.setPromptText(CHOOSE_YOUR_MAP);
        List<String> files = FileController.getAllFileNames();
        ObservableList<String> mapsComboboxOptions = FXCollections.observableArrayList(files);
        mapsCombobox.setItems(mapsComboboxOptions);
        
        nbTownsToGenerate.setPromptText(NUMBER_OF_TOWNS);
        
        approchesChoicesBrutForce.setText(BRUT_FORCE);
        approchesChoicesBrutForce.setToggleGroup(approchesChoices);
        approchesChoicesBranchBound.setText(BRANCH_BOUND);
        approchesChoicesBranchBound.setToggleGroup(approchesChoices);
        approchesChoicesAddingRemoving.setText(ADDING_REMOVING);
        approchesChoicesAddingRemoving.setToggleGroup(approchesChoices);
        approchesChoicesSpanningTree.setText(SPANNING_TREE);
        approchesChoicesSpanningTree.setToggleGroup(approchesChoices);
        approchesChoicesGreedy.setText(GREEDY);
        approchesChoicesGreedy.setToggleGroup(approchesChoices);
        approchesChoicesDynamic.setText(DYNAMIC);
        approchesChoicesDynamic.setToggleGroup(approchesChoices);
        approchesChoicesRandom.setText(RANDOM);
        approchesChoicesRandom.setToggleGroup(approchesChoices);
        approchesChoicesGenetic.setText(GENETIC);
        approchesChoicesGenetic.setToggleGroup(approchesChoices);
        
        solverBtn.setText(RESOLVE);
        solverAllBtn.setText(RESOLVE_ALL);
        
        typeOfMaps.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle arg2) {
                if(typeOfMapsExistingMap.isSelected()){
                    nbTownsToGenerate.setDisable(true);
                }else{
                    nbTownsToGenerate.setDisable(false);
                }
                if(typeOfMapsNewMap.isSelected()){
                    mapsCombobox.setDisable(true);
                }else{
                    mapsCombobox.setDisable(false);
                }
            }
        });
        
        approchesChoices.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(
                    ObservableValue<? extends Toggle> arg0,
                    Toggle arg1, Toggle arg2) {
                if(approchesChoicesBrutForce.isSelected()){
                    description.setText(DESCRIPTION_BRUT_FORCE);
                    solverBtn.setDisable(false);
                }else if(approchesChoicesBranchBound.isSelected()){
                    description.setText(DESCRIPTION_BRANCH_BOUND);
                    solverBtn.setDisable(false);
                }else if(approchesChoicesAddingRemoving.isSelected()){
                    description.setText(DESCRIPTION_ADDING_REMOVING);
                    solverBtn.setDisable(false);
                }else if(approchesChoicesSpanningTree.isSelected()){
                    description.setText(DESCRIPTION_SPANNING_TREE);
                    solverBtn.setDisable(false);
                }else if(approchesChoicesGreedy.isSelected()){
                    description.setText(DESCRIPTION_GREEDY);
                    solverBtn.setDisable(false);
                }else if(approchesChoicesDynamic.isSelected()){
                    description.setText(DESCRIPTION_DYNAMIC);
                    solverBtn.setDisable(false);
                }else if(approchesChoicesRandom.isSelected()){
                    description.setText(DESCRIPTION_RANDOM);
                    solverBtn.setDisable(false);
                }else if(approchesChoicesGenetic.isSelected()){
                    description.setText(DESCRIPTION_GENETIC);
                    solverBtn.setDisable(false);
                }else{
                    description.setText("");
                    solverBtn.setDisable(true);
                }
            }
        });
        
        solverBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Graph graph = getGraph();
                if(approchesChoicesBrutForce.isSelected()){
                    resolveProblem(BRUT_FORCE_APPROCHE, graph);
                }else if(approchesChoicesBranchBound.isSelected()){
                    resolveProblem(BRANCH_BOUND_APPROCHE, graph);
                }else if(approchesChoicesAddingRemoving.isSelected()){
                    resolveProblem(ADDING_REMOVING_EDGES_APPROCHE, graph);
                }else if(approchesChoicesSpanningTree.isSelected()){
                    resolveProblem(SPANNING_TREE_APPROCHE, graph);
                }else if(approchesChoicesGreedy.isSelected()){
                    resolveProblem(GREEDY_APPROCHE, graph);
                }else if(approchesChoicesDynamic.isSelected()){
                    resolveProblem(DYNAMIC_APPROCHE, graph);
                }else if(approchesChoicesRandom.isSelected()){
                    resolveProblem(RANDOM_APPROCHE, graph);
                }else if(approchesChoicesGenetic.isSelected()){
                    resolveProblem(GENETIC_APPROCHE, graph);
                }
            }

            private Graph getGraph() {
                Graph graph = new Graph();
                if(typeOfMapsExistingMap.isSelected()){
                    graph = GraphController.createGraphFromFile(mapsCombobox.getSelectionModel());
                }else /* typeOfMapsNewMap.isSelected() */{
                    int nbTowns = Integer.getInteger(nbTownsToGenerate.getText());
                    graph = GraphController.createRandomGraph(nbTowns);
                }
                return graph;
            }

            private void resolveProblem(int APPROCHE, Graph graph) {
                Main.graph = graph;
                Main.matrice = GraphController.transformeGraphToMatrice(graph);
                Main.launchGoodOneVersion(APPROCHE);
            }
        });
        
        solverAllBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Graph graph = getGraph();
                resolveProblem(BRUT_FORCE_APPROCHE, graph);
                resolveProblem(BRANCH_BOUND_APPROCHE, graph);
                resolveProblem(ADDING_REMOVING_EDGES_APPROCHE, graph);
                resolveProblem(SPANNING_TREE_APPROCHE, graph);
                resolveProblem(GREEDY_APPROCHE, graph);
                resolveProblem(DYNAMIC_APPROCHE, graph);
                resolveProblem(RANDOM_APPROCHE, graph);
                resolveProblem(GENETIC_APPROCHE, graph);
                // plotComparingGraph();
            }

            private Graph getGraph() {
                Graph graph = new Graph();
                if(typeOfMapsExistingMap.isSelected()){
                    graph = GraphController.createGraphFromFile(mapsCombobox.getSelectionModel());
                }else /* typeOfMapsNewMap.isSelected() */{
                    int nbTowns = Integer.getInteger(nbTownsToGenerate.getText());
                    graph = GraphController.createRandomGraph(nbTowns);
                }
                return graph;
            }

            private void resolveProblem(int APPROCHE, Graph graph) {
                Main.graph = graph;
                Main.matrice = GraphController.transformeGraphToMatrice(graph);
                Main.launchGoodOneVersion(APPROCHE);
            }
        });
    }

}
