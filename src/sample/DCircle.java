/*

All of This Project is coded By Danial Bayati And Mostafa Fazli
Shahrood University of Technology
1400/01/29

 */

package sample;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DCircle {
    int r = 35;
    int x;
    int y;
    private String name;
    boolean isFinal;
    public DCircle(int x, int y, boolean isFinal, String name, Group group) {
        this.x = x;
        this.y = y;
        this.isFinal = isFinal;
        this.name = name;
        drawC(group);
    }

    public void drawC(Group group) {
        Circle circle = new Circle(x, y, r);
        circle.setFill(Color.GOLD);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(3);
        group.getChildren().add(circle);
        if(isFinal) {
            Circle circle1 = new Circle(x, y, r-10);
            circle1.setFill(Color.GOLD);
            circle1.setStroke(Color.BLACK);
            circle1.setStrokeWidth(3);
            group.getChildren().add(circle1);
        }
        Label label = new Label(getName());
        label.setLayoutX(x-16);
        label.setLayoutY(y-20);
        label.setFont(Font.font("Serif", FontWeight.BOLD, 30));
        label.setTextFill(Color.DARKOLIVEGREEN);
        group.getChildren().add(label);
    }

    public String getName() {
        return name;
    }
}
