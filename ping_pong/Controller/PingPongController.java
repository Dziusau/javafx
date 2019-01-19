package ping_pong.Controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class PingPongController {
    @FXML
    Circle ball;
    @FXML
    Rectangle field;
    @FXML
    Rectangle rightPaddle;
    @FXML
    Rectangle leftPaddle;

    int PaddleCoordinateIncrement = 3;
    double centerFieldY;

    DoubleProperty currentLeftPaddleY = new SimpleDoubleProperty();
    DoubleProperty currentRightPaddleY = new SimpleDoubleProperty();

    Timeline timeline;

    public void initialize (){
        currentLeftPaddleY.set(leftPaddle.getLayoutY());
        leftPaddle.layoutYProperty().bind(currentLeftPaddleY);
        currentRightPaddleY.set(rightPaddle.getLayoutY());
        rightPaddle.layoutYProperty().bind(currentRightPaddleY);
    }

    public void keyPressedHandler(KeyEvent keyEvent) {
        KeyCode keyCode = keyEvent.getCode();
        System.out.println("pressed key: " + keyCode);
        switch (keyCode) {
            case UP:
                leftPaddleUp();
            case DOWN:
                leftPaddleDown();
            case W:
                rightPaddleUp();
            case S:
                rightPaddleDown();
        }
    }
    public void leftPaddleUp(){
        currentLeftPaddleY.set(currentLeftPaddleY.get() - PaddleCoordinateIncrement);
    }
    public void leftPaddleDown(){
        currentLeftPaddleY.set(currentLeftPaddleY.get() + PaddleCoordinateIncrement);
    }
    public void rightPaddleUp(){
        currentRightPaddleY.set(currentRightPaddleY.get() - PaddleCoordinateIncrement);
    }
    public void rightPaddleDown(){
        currentRightPaddleY.set(currentRightPaddleY.get() + PaddleCoordinateIncrement);
    }

}

