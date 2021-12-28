/*

All of This Project is coded By Danial Bayati And Mostafa Fazli
Shahrood University of Technology
1400/01/29

 */

package sample;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.QuadCurve;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.transform.Rotate;

public class TransLine {
    int startX;
    int startY;
    int endX;
    int endY;
    int midX, midY;
    int direction;
    boolean isInit;
    String name;

    public TransLine(int startX, int startY, int endX, int endY, String name, boolean isInit, Group group) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.name = name;
        this.isInit = isInit;
        drawTransLine(group);
    }
    public void drawTransLine(Group group) {
        if(isInit) {
            Line line = new Line(startX, startY, endX, endY);
            line.setFill(Color.BLACK);
            line.setStroke(Color.BLACK);
            line.setStrokeWidth(3);

            Polygon arrowHead = new Polygon();
            arrowHead.getPoints().addAll(0.0, 0.0, -10.0, 8.0, -10.0, -8.0);
            arrowHead.setFill(Color.BLACK);
            arrowHead.layoutXProperty().bind(line.endXProperty().add(line.translateXProperty()));
            arrowHead.layoutYProperty().bind(line.endYProperty().add(line.translateYProperty()));
            group.getChildren().addAll(line, arrowHead);
        } else {

            if (endX - startX < 0) {
                direction = 1;
                startY += 35;
                endY += 35;
                midX = (startX + endX) / 2;
                midY = endY + (startX - endX) / 4;
            } else if (endX - startX == 0) {
                if (endY - startY < 0) {
                    direction = 2;
                    startX -= 35;
                    endX -= 35;
                    midY = (startY + endY) / 2;
                    midX = endX - (startY - endY) / 4;
                } else {
                    direction = 3;
                    startX += 35;
                    endX += 35;
                    midY = (startY + endY) / 2;
                    midX = endX + (endY - startY) / 4;
                }
            } else {
                direction = 4;
                startY -= 35;
                endY -= 35;
                midX = (startX + endX) / 2;
                midY = endY - (endX - startX) / 4;
            }

            QuadCurve quadCurve = new QuadCurve(startX, startY, midX, midY, endX, endY);
            quadCurve.setStroke(Color.BLACK);
            quadCurve.setFill(null);
            quadCurve.setStrokeWidth(2);
            Polygon arrowHead = new Polygon();
            arrowHead.setScaleX(1.1);
            arrowHead.setScaleY(1.1);
            arrowHead.setScaleZ(1.1);

            if(startX - endX > 0){
                arrowHead.getTransforms().add(new Rotate(200,0,0,0));
                arrowHead.getPoints().addAll(0.0, 0.0, -10.0, 8.0, -10.0, -8.0);
                arrowHead.setFill(Color.BLACK);
            }

            if(endX - startX > 0){
                arrowHead.getTransforms().add(new Rotate(30,0,0,0));
                arrowHead.getPoints().addAll(0.0, 0.0, -10.0, 8.0, -10.0, -8.0);
                arrowHead.setFill(Color.BLACK);
            }

            if(startY - endY > 0){
                arrowHead.getTransforms().add(new Rotate(295,0,0,0));
                arrowHead.getPoints().addAll(0.0, 0.0, -10.0, 8.0, -10.0, -8.0);
                arrowHead.setFill(Color.BLACK);
            }

            if(endY - startY > 0){
                arrowHead.getTransforms().add(new Rotate(120,0,0,0));
                arrowHead.getPoints().addAll(0.0, 0.0, -10.0, 8.0, -10.0, -8.0);
                arrowHead.setFill(Color.BLACK);
            }

            arrowHead.layoutXProperty().bind(quadCurve.endXProperty().add(quadCurve.translateXProperty()));
            arrowHead.layoutYProperty().bind(quadCurve.endYProperty().add(quadCurve.translateYProperty()));

            Label label = new Label(name);
            switch (direction) {
                case 1:
                    midY = endY + (startX - endX)/8 -35; break;
                case 2:
                    midX = endX - (startY - endY)/8 +5; break;
                case 3:
                    midX = endX + (endY - startY)/8 - 20; break;
                case 4:
                    midY = endY - (endX - startX)/8; break;
            }
            label.setLayoutX(midX);
            label.setLayoutY(midY);
            label.setFont(Font.font("Serif", FontWeight.BOLD, 30));
            label.setTextFill(Color.DODGERBLUE);
            group.getChildren().addAll(quadCurve, arrowHead, label);
        }
    }
}
