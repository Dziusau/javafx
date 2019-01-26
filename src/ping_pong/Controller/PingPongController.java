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

    int paddleCoordinateIncrement = 3;
    int ballCoordinateIncrement = 2;
    double centerFieldY;
    double allowedPaddleTop;
    double allowedPaddleBottom;

    DoubleProperty currentLeftPaddleY = new SimpleDoubleProperty();
    DoubleProperty currentRightPaddleY = new SimpleDoubleProperty();

    DoubleProperty currentBallX = new SimpleDoubleProperty();
    DoubleProperty currentBallY = new SimpleDoubleProperty();

    Timeline timeline;

    public void initialize (){
        currentLeftPaddleY.set(leftPaddle.getLayoutY());
        leftPaddle.layoutYProperty().bind(currentLeftPaddleY);

        currentRightPaddleY.set(rightPaddle.getLayoutY());
        rightPaddle.layoutYProperty().bind(currentRightPaddleY);

        allowedPaddleTop = paddleCoordinateIncrement;
        allowedPaddleBottom = field.getHeight() - leftPaddle.getHeight() - paddleCoordinateIncrement;

        centerFieldY = field.getHeight() / 2;

        currentBallX.set(ball.getCenterX());
        ball.centerXProperty().bind(currentBallX);
        currentBallY.set(ball.getCenterY());
        ball.centerYProperty().bind(currentBallY);
    }

    public void keyPressedHandler(KeyEvent keyEvent) {
        KeyCode keyCode = keyEvent.getCode();
        System.out.println("pressed key: " + keyCode);
        switch (keyCode) {
            case UP:
                leftPaddleUp();
                break;
            case DOWN:
                leftPaddleDown();
                break;
            case W:
                rightPaddleUp();
                break;
            case S:
                rightPaddleDown();
                break;
            case P:
                moveBall();
                break;
        }
    }
    public void leftPaddleUp(){
        if (currentLeftPaddleY.get() > allowedPaddleTop) {
            currentLeftPaddleY.set(currentLeftPaddleY.get() - paddleCoordinateIncrement);
        }
    }
    public void leftPaddleDown() {
        if (currentLeftPaddleY.get() < allowedPaddleBottom) {
            currentLeftPaddleY.set(currentLeftPaddleY.get() + paddleCoordinateIncrement);
        }
    }
    public void rightPaddleUp() {
        if (currentRightPaddleY.get() > allowedPaddleTop) {
            currentRightPaddleY.set(currentRightPaddleY.get() - paddleCoordinateIncrement);
        }
    }
    public void rightPaddleDown() {
        if (currentRightPaddleY.get() < allowedPaddleBottom) {
            currentRightPaddleY.set(currentRightPaddleY.get() + paddleCoordinateIncrement);
        }
    }
    public void moveBall(){
        KeyFrame keyFrame = new KeyFrame(new Duration(10), event ->{
            currentBallY.set(currentBallY.get() + ballCoordinateIncrement);
            ballBounceTopWall();
            ballBounceTheBottomWall();
        });
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void ballBounceTopWall(){
        if ((currentBallY.get() - ball.getRadius()) < 0){
            currentBallY.set(currentBallY.get() + ballCoordinateIncrement);
        }
    }
    public void ballBounceTheBottomWall(){
        if ((currentBallY.get() + ball.getRadius()) > field.getHeight() / 2){
            currentBallY.set(currentBallY.get() - ballCoordinateIncrement);
        }
    }
}

