package ping_pong.Controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
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
    @FXML
    Text rightScore;
    @FXML
    Text leftScore;

    int paddleCoordinateIncrement = 7;
    int ballCoordinateIncrementY = 2;
    int ballCoordinateIncrementX = 2;
    double centerFieldY;
    double centerFieldX;
    double allowedPaddleTop;
    double allowedPaddleBottom;

    DoubleProperty currentLeftPaddleY = new SimpleDoubleProperty();
    DoubleProperty currentRightPaddleY = new SimpleDoubleProperty();

    DoubleProperty currentBallX = new SimpleDoubleProperty();
    DoubleProperty currentBallY = new SimpleDoubleProperty();

    SimpleStringProperty rightScoreboard = new SimpleStringProperty();
    SimpleStringProperty leftScoreboard = new SimpleStringProperty();

    Timeline timeline;

    public void initialize() {
        currentLeftPaddleY.set(leftPaddle.getLayoutY());
        leftPaddle.layoutYProperty().bind(currentLeftPaddleY);

        currentRightPaddleY.set(rightPaddle.getLayoutY());
        rightPaddle.layoutYProperty().bind(currentRightPaddleY);

        allowedPaddleTop = paddleCoordinateIncrement;
        allowedPaddleBottom = field.getHeight() - leftPaddle.getHeight() - paddleCoordinateIncrement;

        centerFieldY = field.getHeight() / 2;
        centerFieldX = field.getWidth() / 2;

        currentBallX.set(ball.getCenterX());
        ball.layoutXProperty().bind(currentBallX);
        currentBallY.set(ball.getCenterY());
        ball.layoutYProperty().bind(currentBallY);

        currentBallX.set(centerFieldX);
        currentBallY.set(centerFieldY);

        rightScore.textProperty().bind(rightScoreboard);
        leftScore.textProperty().bind(leftScoreboard);
    }

    public void keyPressedHandler(KeyEvent keyEvent) {
        KeyCode keyCode = keyEvent.getCode();
        System.out.println("pressed key: " + keyCode);
        switch (keyCode) {
            case W:
                leftPaddleUp();
                break;
            case S:
                leftPaddleDown();
                break;
            case UP:
                rightPaddleUp();
                break;
            case DOWN:
                rightPaddleDown();
                break;
            case ENTER:
                restartGame();
                moveBall();
                break;
        }
    }

    public void leftPaddleUp() {
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

    private void moveBall() {
        KeyFrame keyFrame = new KeyFrame(new Duration(10), event -> {
            currentBallY.set(currentBallY.get() + ballCoordinateIncrementY);
            currentBallX.set(currentBallX.get() + ballCoordinateIncrementX);
            checkTopBottomWalls();
            checkRightLeftWalls();
            checkLeftPaddleTouch();
            checkRightPaddleTouch();
        });
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void checkTopBottomWalls() {
        if ((currentBallY.get() + ball.getRadius()) > field.getHeight()
                || (currentBallY.get() - ball.getRadius()) < 0) {
            ballCoordinateIncrementY = ballCoordinateIncrementY * (-1);
        }
    }

    private void checkRightLeftWalls() {
        if (currentBallX.get() + ball.getRadius() >= field.getWidth()){
            timeline.stop();
            leftScoreboard.set(leftScoreboard.getValue() + 1);
        } else if (currentBallX.get() - ball.getRadius() <= 0){
            timeline.stop();
        }
    }

    private void checkLeftPaddleTouch() {
        if (currentBallY.get() >= currentLeftPaddleY.get()
                && currentBallY.get() <= (currentLeftPaddleY.get() + leftPaddle.getHeight())
                && (currentBallX.get() - ball.getRadius()) < (leftPaddle.getLayoutX() + leftPaddle.getWidth())) {
            ballCoordinateIncrementX = ballCoordinateIncrementX * (-1);
        }
    }

    private void checkRightPaddleTouch() {
        if (currentBallY.get() >= currentRightPaddleY.get()
                && currentBallY.get() <= currentRightPaddleY.get() + rightPaddle.getHeight()
                && (currentBallX.get() + ball.getRadius()) > rightPaddle.getLayoutX()) {
            ballCoordinateIncrementX = ballCoordinateIncrementX * (-1);
        }
    }
     private void restartGame(){
        currentBallX.set(centerFieldX);
        currentBallY.set(centerFieldY);
        currentLeftPaddleY.set(centerFieldY - leftPaddle.getHeight() / 2);
        currentRightPaddleY.set(centerFieldY - rightPaddle.getHeight() / 2);
     }
}