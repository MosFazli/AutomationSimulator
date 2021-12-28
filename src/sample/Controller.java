/*

All of This Project is coded By Danial Bayati And Mostafa Fazli
Shahrood University of Technology
1400/01/29

 */


package sample;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Controller {


    public Button exitBtn;
    private Desktop desktop = Desktop.getDesktop();


    public void chooseFile(ActionEvent actionEvent) {


        final FileChooser fileChooser = new FileChooser();
        Window stage = null;
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            openFile(file);
        }

        assert file != null;
        Path s = Paths.get(file.getAbsolutePath());
        Path d = Paths.get("assets\\detail.txt");

        try {
            Files.copy(s, d, REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

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

        try {

            BufferedReader in = new BufferedReader(new FileReader(file));
            String str;

            while ((str = in.readLine()) != null) {
                System.out.println(str);

                if (str.contains("numberOfAlphabets")) {
                    int charAddres = str.indexOf("numberOfAlphabets") + 18;
                    String temp = "";
                    for (int i = charAddres; i < str.length() - 1; i++) {
                        temp += str.charAt(i);
                    }
                    alphabetNum = Integer.parseInt(temp);
                    //      System.out.println(Integer.parseInt(temp));
                }

                if (str.contains("letter")) {
                    int charAddres = str.indexOf("letter") + 8;
                    String temp = "";
                    for (int i = charAddres; i < str.length() - 3; i++) {
                        temp += str.charAt(i);
                    }
                    alphabet.add(temp);
                }

                if (str.contains("numberOfStates")) {
                    int charAddres = str.indexOf("numberOfStates") + 15;
                    String temp = "";
                    for (int i = charAddres; i < str.length() - 1; i++) {
                        temp += str.charAt(i);
                    }
                    statesNum = Integer.parseInt(temp);
                    //      System.out.println(Integer.parseInt(temp));
                }

                if (str.contains("state")) {
                    int charAddres = str.indexOf("positionX") + 10;
                    String temp = "";
                    for (int i = charAddres; i < str.length() - 1; i++) {
                        if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                            temp += str.charAt(i);
                        } else {
                            break;
                        }
                    }
                    positionx.add(Integer.parseInt(temp));
                    //      System.out.println(Integer.parseInt(temp));
                }

                if (str.contains("state")) {
                    int charAddres = str.indexOf("positionY") + 10;
                    String temp = "";
                    for (int i = charAddres; i < str.length() - 1; i++) {
                        if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                            temp += str.charAt(i);
                        } else {
                            break;
                        }
                    }
                    positiony.add(Integer.parseInt(temp));
                    //      System.out.println(Integer.parseInt(temp));
                }


                if (str.contains("state")) {
                    int charAddres = str.indexOf("name") + 6;
                    String temp = "";
                    for (int i = charAddres; i < str.length() - 1; i++) {
                        if (str.charAt(i) != 34) {
                            temp += str.charAt(i);
                        } else {
                            break;
                        }
                    }
                    states.add(temp);
                    //      System.out.println(Integer.parseInt(temp));
                }


                if (str.contains("initialState")) {
                    int charAddres = str.indexOf("name") + 6;
                    String temp = "";
                    for (int i = charAddres; i < str.length() - 1; i++) {
                        if (str.charAt(i) != 34) {
                            temp += str.charAt(i);
                        } else {
                            break;
                        }
                    }
                    initialState = temp;
                    //      System.out.println(Integer.parseInt(temp));
                }

                if (str.contains("FinalStates") && str.length() > 25) {
                    int charAddres = str.indexOf("numberOfFinalStates") + 20;
                    String temp = "";
                    for (int i = charAddres; i < str.length() - 1; i++) {
                        if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                            temp += str.charAt(i);
                        } else {
                            break;
                        }
                    }
                    finalStatesNum = Integer.parseInt(temp);
                    //      System.out.println(Integer.parseInt(temp));
                }


                if (str.contains("finalState")) {
                    int charAddres = str.indexOf("name") + 6;
                    String temp = "";
                    for (int i = charAddres; i < str.length() - 1; i++) {
                        if (str.charAt(i) != 34) {
                            temp += str.charAt(i);
                        } else {
                            break;
                        }
                    }
                    finalStates.add(temp);
                    //      System.out.println(Integer.parseInt(temp));
                }


                if (str.contains("Transitions") && str.length() > 23) {
                    int charAddres = str.indexOf("numberOfTrans") + 14;
                    String temp = "";
                    for (int i = charAddres; i < str.length() - 1; i++) {
                        if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                            temp += str.charAt(i);
                        } else {
                            break;
                        }
                    }
                    transitionNum = Integer.parseInt(temp);
                    //      System.out.println(Integer.parseInt(temp));
                }


                if (str.contains("transition")) {
                    int charAddres = str.indexOf("label") + 7;
                    String temp = "";
                    for (int i = charAddres; i < str.length() - 1; i++) {
                        if (str.charAt(i) != 34) {
                            temp += str.charAt(i);
                        } else {
                            break;
                        }
                    }
                    transitions.add(temp);

                    charAddres = str.indexOf("source") + 8;
                    temp = "";
                    for (int i = charAddres; i < str.length() - 1; i++) {
                        if (str.charAt(i) != 34) {
                            temp += str.charAt(i);
                        } else {
                            break;
                        }
                    }
                    transitionsSource.add(temp);


                    charAddres = str.indexOf("destination") + 13;
                    temp = "";
                    for (int i = charAddres; i < str.length() - 1; i++) {
                        if (str.charAt(i) != 34) {
                            temp += str.charAt(i);
                        } else {
                            break;
                        }
                    }
                    transitionsDestination.add(temp);

                    //      System.out.println(Integer.parseInt(temp));
                }


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(alphabetNum);
        System.out.println(alphabet);
        System.out.println(statesNum);
        System.out.println(states);
        System.out.println(positionx);
        System.out.println(positiony);
        System.out.println(initialState);
        System.out.println(finalStatesNum);
        System.out.println(finalStates);
        System.out.println(transitionNum);
        System.out.println(transitions);
        System.out.println(transitionsSource);
        System.out.println(transitionsDestination);

        DrawCircle drawCircle = new DrawCircle();
        drawCircle.getInformation(initialState, transitionsSource, transitionsDestination, transitionNum, statesNum, finalStates, states, positionx, positiony, transitions);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Drawing Page");
        try {
            drawCircle.start(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Stage stage1 = (Stage) exitBtn.getScene().getWindow();
        stage1.close();
    }

    public void load(ActionEvent actionEvent) {

        boolean flag = true;
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

        try {

            BufferedReader in = new BufferedReader(new FileReader("assets\\detail.txt"));
            String str;

            if((str = in.readLine()) == null) {
                flag = false;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Previous File");
                alert.setHeaderText("File Not Exist!");
                alert.setContentText("Please close this window and choose a file to show");
                alert.showAndWait();
            }
            while ((str = in.readLine()) != null) {
                System.out.println(str);

                if (str.contains("numberOfAlphabets")) {
                    int charAddres = str.indexOf("numberOfAlphabets") + 18;
                    String temp = "";
                    for (int i = charAddres; i < str.length() - 1; i++) {
                        temp += str.charAt(i);
                    }
                    alphabetNum = Integer.parseInt(temp);
                    //      System.out.println(Integer.parseInt(temp));
                }

                if (str.contains("letter")) {
                    int charAddres = str.indexOf("letter") + 8;
                    String temp = "";
                    for (int i = charAddres; i < str.length() - 3; i++) {
                        temp += str.charAt(i);
                    }
                    alphabet.add(temp);
                }

                if (str.contains("numberOfStates")) {
                    int charAddres = str.indexOf("numberOfStates") + 15;
                    String temp = "";
                    for (int i = charAddres; i < str.length() - 1; i++) {
                        temp += str.charAt(i);
                    }
                    statesNum = Integer.parseInt(temp);
                    //      System.out.println(Integer.parseInt(temp));
                }

                if (str.contains("state")) {
                    int charAddres = str.indexOf("positionX") + 10;
                    String temp = "";
                    for (int i = charAddres; i < str.length() - 1; i++) {
                        if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                            temp += str.charAt(i);
                        } else {
                            break;
                        }
                    }
                    positionx.add(Integer.parseInt(temp));
                    //      System.out.println(Integer.parseInt(temp));
                }

                if (str.contains("state")) {
                    int charAddres = str.indexOf("positionY") + 10;
                    String temp = "";
                    for (int i = charAddres; i < str.length() - 1; i++) {
                        if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                            temp += str.charAt(i);
                        } else {
                            break;
                        }
                    }
                    positiony.add(Integer.parseInt(temp));
                    //      System.out.println(Integer.parseInt(temp));
                }


                if (str.contains("state")) {
                    int charAddres = str.indexOf("name") + 6;
                    String temp = "";
                    for (int i = charAddres; i < str.length() - 1; i++) {
                        if (str.charAt(i) != 34) {
                            temp += str.charAt(i);
                        } else {
                            break;
                        }
                    }
                    states.add(temp);
                    //      System.out.println(Integer.parseInt(temp));
                }


                if (str.contains("initialState")) {
                    int charAddres = str.indexOf("name") + 6;
                    String temp = "";
                    for (int i = charAddres; i < str.length() - 1; i++) {
                        if (str.charAt(i) != 34) {
                            temp += str.charAt(i);
                        } else {
                            break;
                        }
                    }
                    initialState = temp;
                    //      System.out.println(Integer.parseInt(temp));
                }

                if (str.contains("FinalStates") && str.length() > 25) {
                    int charAddres = str.indexOf("numberOfFinalStates") + 20;
                    String temp = "";
                    for (int i = charAddres; i < str.length() - 1; i++) {
                        if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                            temp += str.charAt(i);
                        } else {
                            break;
                        }
                    }
                    finalStatesNum = Integer.parseInt(temp);
                    //      System.out.println(Integer.parseInt(temp));
                }


                if (str.contains("finalState")) {
                    int charAddres = str.indexOf("name") + 6;
                    String temp = "";
                    for (int i = charAddres; i < str.length() - 1; i++) {
                        if (str.charAt(i) != 34) {
                            temp += str.charAt(i);
                        } else {
                            break;
                        }
                    }
                    finalStates.add(temp);
                    //      System.out.println(Integer.parseInt(temp));
                }


                if (str.contains("Transitions") && str.length() > 23) {
                    int charAddres = str.indexOf("numberOfTrans") + 14;
                    String temp = "";
                    for (int i = charAddres; i < str.length() - 1; i++) {
                        if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                            temp += str.charAt(i);
                        } else {
                            break;
                        }
                    }
                    transitionNum = Integer.parseInt(temp);
                    //      System.out.println(Integer.parseInt(temp));
                }


                if (str.contains("transition")) {
                    int charAddres = str.indexOf("label") + 7;
                    String temp = "";
                    for (int i = charAddres; i < str.length() - 1; i++) {
                        if (str.charAt(i) != 34) {
                            temp += str.charAt(i);
                        } else {
                            break;
                        }
                    }
                    transitions.add(temp);

                    charAddres = str.indexOf("source") + 8;
                    temp = "";
                    for (int i = charAddres; i < str.length() - 1; i++) {
                        if (str.charAt(i) != 34) {
                            temp += str.charAt(i);
                        } else {
                            break;
                        }
                    }
                    transitionsSource.add(temp);


                    charAddres = str.indexOf("destination") + 13;
                    temp = "";
                    for (int i = charAddres; i < str.length() - 1; i++) {
                        if (str.charAt(i) != 34) {
                            temp += str.charAt(i);
                        } else {
                            break;
                        }
                    }
                    transitionsDestination.add(temp);

                    //      System.out.println(Integer.parseInt(temp));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(flag) {
            System.out.println(alphabetNum);
            System.out.println(alphabet);
            System.out.println(statesNum);
            System.out.println(states);
            System.out.println(positionx);
            System.out.println(positiony);
            System.out.println(initialState);
            System.out.println(finalStatesNum);
            System.out.println(finalStates);
            System.out.println(transitionNum);
            System.out.println(transitions);
            System.out.println(transitionsSource);
            System.out.println(transitionsDestination);

            DrawCircle drawCircle = new DrawCircle();
            drawCircle.getInformation(initialState, transitionsSource, transitionsDestination, transitionNum, statesNum, finalStates, states, positionx, positiony, transitions);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Drawing Page");
            try {
                drawCircle.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Stage stage = (Stage) exitBtn.getScene().getWindow();
            stage.close();
        }

    }

    public void exit() {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
            stage.close();
    }


    public void aboutbtn(){
        OptionPaneExample optionPaneExample = new OptionPaneExample();
    }

    public class OptionPaneExample {
        JFrame f;

        OptionPaneExample() {
            f = new JFrame();
            JOptionPane.showMessageDialog(f, "You can Restore last file in detail.txt file in assests folder or click on Load previous file button\n" +
                    "or you can Draw new Shape by click on Choose a file Button\n" +
                    "after you choose new file, First of all you should draw States and then draw Translines with Buttons on Top of Window\n" +
                    "All of This Project is coded By Danial Bayati And Mostafa Fazli\n" +
                    "Shahrood University of Technology\n" +
                    "1400/01/29");
        }
    }

        private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                    FileChooserSample.class.getName()).log(
                    Level.SEVERE, null, ex
            );
        }
    }

}
