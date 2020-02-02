/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oracle
 */
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AlarmApp extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(AlarmApp.class, args);
    }

    @Override
    public void start(Stage stage) {

        Pane topPane = new Pane();
        topPane.setStyle("-fx-background-color: white;");
        topPane.setPadding(new Insets(10, 10, 10, 10));
        topPane.setPrefSize(430, 190);

     
       
        //remaing time
        Pane  rTimePane = new Pane ();
        rTimePane.setStyle("-fx-background-color: white; -fx-border-color: gray; -fx-padding: 4 4;");
        rTimePane.setMinSize(200, 90);
        rTimePane.setPrefSize(200, 90);
        //rTimePane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(1.0), BorderStroke.THICK)));
        Label rTimePaneBorder = new Label("Remaining Time: ");
        rTimePaneBorder.setStyle("-fx-background-color: white; -fx-translate-y: -8; -fx-translate-x: 10;");
        rTimePaneBorder.relocate(15,10) ;
                
        Label rTimeL = new Label("00:00:00");  // Remainig Time Text
        rTimeL.setFont(new Font("System", 40)); // System Font40pt -- if we use 48 , it is exceeding the box 
        rTimeL.setTextFill(Color.web("#008000")); // Green Color
        rTimeL.relocate(12,22) ;

         rTimePane.relocate(10, 10);
        rTimePane.getChildren().addAll(rTimeL);

        //current time
        Pane cTimePane = new Pane();
        cTimePane.setStyle("-fx-background-color: white; -fx-border-color: gray; -fx-padding: 4 4;");
        cTimePane.setPrefSize(200, 40);
        cTimePane.setMaxSize(200, 40);
        
        Label cTimePaneBorder = new Label("Current Time: ");
        cTimePaneBorder.setStyle("-fx-background-color: white; -fx-translate-y: -8; -fx-translate-x: 10;");
        cTimePaneBorder.relocate(225,10) ;
        

        TextField cTimeTF = new TextField("01:54:16 PM");
        cTimeTF.setPrefSize(190, 25);
        
        cTimeTF.relocate(5,8) ;
        cTimeTF.setAlignment(Pos.CENTER_RIGHT);
        cTimePane.relocate(220, 10);
        cTimePane.getChildren().addAll(cTimeTF);

        //alaram time
        Pane aTimePane = new Pane();
        aTimePane.setStyle("-fx-background-color: white; -fx-border-color: gray; -fx-padding: 4 4;");
        aTimePane.setPrefSize(200, 40);
        
        Label aTimePaneBorder = new Label("Alram Time: ");
        aTimePaneBorder.setStyle("-fx-background-color: white; -fx-translate-y: -8; -fx-translate-x: 10;");
        aTimePaneBorder.relocate(225,60) ;
        

        TextField aTimeTF = new TextField("10:30:00 PM");
        aTimeTF.setPrefSize(190, 25);
        aTimeTF.relocate(5,8) ;
        aTimeTF.setAlignment(Pos.CENTER_RIGHT);

        aTimePane.relocate(220, 60);
        aTimePane.getChildren().addAll(aTimeTF);

        ObservableList<String> options
                = FXCollections.observableArrayList(
                        "Weekday",
                        "Saturday",
                        "Sunday"
                );

        ComboBox comboBox = new ComboBox(options);
        comboBox.setPromptText("Select Alarm");
        comboBox.setPrefSize(410, 30);
        comboBox.relocate(10, 110);

        Button newAlarmButton = new Button("New Alam");
        newAlarmButton.setPrefSize(100, 30);
        newAlarmButton.relocate(10, 150);

        Button editButton = new Button("Edit");
        editButton.setPrefSize(80, 30);
        editButton.relocate(120, 150);

        Button deleteButton = new Button("Delete");
        deleteButton.setPrefSize(80, 30);
        deleteButton.relocate(210, 150);

        ToggleGroup radioGrop = new ToggleGroup();

        RadioButton onRB = new RadioButton("ON");
        onRB.setUserData("ON");
        onRB.setPrefSize(50, 30);
        onRB.relocate(310, 150);
        onRB.setToggleGroup(radioGrop);
        onRB.setSelected(true);

        RadioButton offRB = new RadioButton("OFF");
        offRB.setUserData("OFF");
        offRB.setPrefSize(50, 30);
        offRB.relocate(360, 150);
        offRB.setToggleGroup(radioGrop);

        topPane.getChildren().addAll(rTimePane, rTimePaneBorder, cTimePane,cTimePaneBorder, aTimePane,aTimePaneBorder, comboBox, newAlarmButton, editButton, deleteButton, onRB, offRB);

        Scene scene = new Scene(topPane);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Alarm App");
      

        stage.show();

    }

}
