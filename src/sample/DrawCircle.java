package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;

public class DrawCircle extends Application {

    int alphabetNum = 0, statesNum = 0, finalStatesNum = 0, transitionNum = 0;
    String initialState = "";
    ArrayList<String> alphabet = new ArrayList<>();
    ArrayList<String> states = new ArrayList<>();
    ArrayList<String> finalStates = new ArrayList<>();
    ArrayList<Integer> positionx = new ArrayList<>();
    ArrayList<Integer> positiony = new ArrayList<>();
    ArrayList<String> transitions = new ArrayList<>();
    ArrayList<String> transitionsSource = new ArrayList<>();
    ArrayList<String> transitionsDestination = new ArrayList<>();
    Group group = new Group();

    public void getInformation(String InitialState, ArrayList<String> TransitionsSource,
                               ArrayList<String> TransitionsDestination, int TransitionNum,
                               int StatesNum, ArrayList<String> FinalStates,
                               ArrayList<String> States, ArrayList<Integer> PositionX,
                               ArrayList<Integer> PositionY, ArrayList<String> Transitions) {
        statesNum = StatesNum;
        states = States;
        positionx = PositionX;
        positiony = PositionY;
        finalStates = FinalStates;
        transitionNum = TransitionNum;
        transitionsSource = TransitionsSource;
        transitionsDestination = TransitionsDestination;
        initialState = InitialState;
        transitions = Transitions;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        paint(primaryStage);
    }

    ///////////////







    /////////

    private void paint(Stage primaryStage) throws FileNotFoundException {


        DCircle[] dCircles = new DCircle[statesNum];

        // drawing states
        Button drawState = new Button();
        drawState.setText("Click to Draw States");
        drawState.setLayoutX(5);
        drawState.setLayoutY(5);
        drawState.setOnAction(value -> {
            for (int i = 0; i < statesNum; i++) {
                if (!finalStates.contains(states.get(i))) {
                    dCircles[i] = new DCircle(positionx.get(i) * 10, positiony.get(i) * 10, false, states.get(i), group);
                } else {
                    dCircles[i] = new DCircle(positionx.get(i) * 10, positiony.get(i) * 10, true, states.get(i), group);
                }
            }
        });


// drawing transition
        Button drawTrans = new Button();
        drawTrans.setText("Click to Draw TransLines");
        drawTrans.setLayoutX(5);
        drawTrans.setLayoutY(50);
        drawTrans.setOnAction(value -> {
            for (int i = 0; i < transitionNum; i++) {
                if (transitionsSource.get(i).equals(transitionsDestination.get(i))) {
                    for (int j = 0; j < statesNum; j++) {
                        if (transitionsSource.get(i).equals(dCircles[j].getName())) {
                            Image image = null;
                            try {
                                image = new Image(new FileInputStream("assets\\CycleArrow.png"));
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            ImageView imageView = new ImageView(image);
                            imageView.setX(dCircles[j].x - 40);
                            imageView.setY(dCircles[j].y + 28);
                            Label label = new Label(transitions.get(i));
                            label.setLayoutX(imageView.getX() + 15);
                            label.setLayoutY(imageView.getY() + 10);
                            label.setFont(Font.font("Serif", FontWeight.BOLD, 30));
                            label.setTextFill(Color.DODGERBLUE);
                            group.getChildren().addAll(imageView, label);
                            break;
                        }
                    }
                } else {
                    int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
                    for (int j = 0; j < statesNum; j++) {

                        if (transitionsSource.get(i).equals(dCircles[j].getName())) {
                            x1 = dCircles[j].x;
                            y1 = dCircles[j].y;
                        }
                        if (transitionsDestination.get(i).equals(dCircles[j].getName())) {
                            x2 = dCircles[j].x;
                            y2 = dCircles[j].y;
                        }
                    }
                    new TransLine(x1, y1, x2, y2, transitions.get(i), false, group);
                }
            }
            // drawing transitionLine of initState
            for (int i = 0; i < statesNum; i++) {
                if (initialState.equals(states.get(i))) {
                    new TransLine(positionx.get(i) * 10 - 100, positiony.get(i) * 10, positionx.get(i) * 10 - 35,
                            positiony.get(i) * 10, initialState, true, group);
                }
            }
        });

   /////////////////////










////////////////////

        group.getChildren().addAll(drawState, drawTrans);
        Scene scene = new Scene(group, 800, 600);
        scene.setFill(Color.LIGHTGOLDENRODYELLOW);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //////////






/////////////
    public static void main(String[] args) {
        launch(args);
    }
}
