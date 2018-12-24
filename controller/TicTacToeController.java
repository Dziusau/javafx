package tictactoe.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sun.awt.NullComponentPeer;

import javax.lang.model.type.NullType;

public class TicTacToeController {;
    @FXML
    private Button buttonR0C0;
    @FXML
    private Button buttonR0C1;
    @FXML
    private Button buttonR0C2;
    @FXML
    private Button buttonR1C0;
    @FXML
    private Button buttonR1C1;
    @FXML
    private Button buttonR1C2;
    @FXML
    private Button buttonR2C0;
    @FXML
    private Button buttonR2C1;
    @FXML
    private Button buttonR2C2;

    int i;

    public void checkWin() {
        if (buttonR0C0.getText() == buttonR0C1.getText() || buttonR0C0.getText() == buttonR0C2.getText()) {
            System.out.println("Вы победили");
        } else if (buttonR0C0.getText() == buttonR1C1.getText() || buttonR0C0.getText() == buttonR2C2.getText()) {
            System.out.println("Вы победили");
        } else if (buttonR0C0.getText() == buttonR1C0.getText() || buttonR0C0.getText() == buttonR2C0.getText()) {
            System.out.println("Вы победили");
        } else if (buttonR0C1.getText() == buttonR1C1.getText() || buttonR0C1.getText() == buttonR2C1.getText()) {
            System.out.println("Вы победили");
        } else if (buttonR0C2.getText() == buttonR1C1.getText() || buttonR0C2.getText() == buttonR2C0.getText()) {
            System.out.println("Вы победили");
        } else if (buttonR0C2.getText() == buttonR1C2.getText() || buttonR0C2.getText() == buttonR2C2.getText()) {
            System.out.println("Вы победили");
        } else if (buttonR1C0.getText() == buttonR1C1.getText() || buttonR1C0.getText() == buttonR1C2.getText()) {
            System.out.println("Вы победили");
        } else if (buttonR2C0.getText() == buttonR2C1.getText() || buttonR2C0.getText() == buttonR2C2.getText()) {
            System.out.println("Вы победили");
        }
    }

    public void button1Clicked(javafx.event.ActionEvent actionEvent) {
        System.out.println("Button1 clicked");
        i++;
        if (buttonR0C0.getText() == null){
            if ((i % 2) == 0) {
                buttonR0C0.setText("O");
            } else {
                buttonR0C0.setText("X");
            }
        } else {
            System.out.println("Кнопка заблокирована");
        }
        checkWin();
    }

    public void button2Clicked(javafx.event.ActionEvent actionEvent) {
        System.out.println("Button2 clicked");
        i++;
        if (buttonR0C1.getText() == null){
            if ((i % 2) == 0) {
                buttonR0C1.setText("O");
            } else {
                buttonR0C1.setText("X");
            }
        } else {
                System.out.println("Кнопка заблокирована");
        }
        checkWin();
    }

    public void button3Clicked(javafx.event.ActionEvent actionEvent) {
        System.out.println("Button3 clicked");
        i++;
        if (buttonR0C2.getText() == null){
            if ((i % 2) == 0) {
                buttonR0C2.setText("O");
            } else {
                buttonR0C2.setText("X");
            }
        } else {
            System.out.println("Кнопка заблокирована");
        }
        checkWin();
    }

    public void button4Clicked(javafx.event.ActionEvent actionEvent) {
        System.out.println("Button4 clicked");
        i++;
            if (buttonR1C0.getText() == null){
                if ((i % 2) == 0) {
                buttonR1C0.setText("O");
            } else {
                buttonR1C0.setText("X");
            }
        } else {
            System.out.println("Кнопка заблокирована");
        }
        checkWin();
    }

    public void button5Clicked(javafx.event.ActionEvent actionEvent) {
        System.out.println("Button5 clicked");
        i++;
        if (buttonR1C1.getText() == null){
            if ((i % 2) == 0) {
                buttonR1C1.setText("O");
            } else {
                buttonR1C1.setText("X");
            }
        } else {
            System.out.println("Кнопка заблокирована");
        }
        checkWin();
    }

    public void button6Clicked(javafx.event.ActionEvent actionEvent) {
        System.out.println("Button6 clicked");
        i++;
        if (buttonR1C2.getText() == null){
            if ((i % 2) == 0) {
                buttonR1C2.setText("O");
            } else {
                buttonR1C2.setText("X");
            }
        } else {
            System.out.println("Кнопка заблокирована");
        }
        checkWin();
    }

    public void button7Clicked(javafx.event.ActionEvent actionEvent) {
        System.out.println("Button7 clicked");
        i++;
        if (buttonR2C2.getText() == null){
            if ((i % 2) == 0) {
                buttonR2C0.setText("O");
            } else {
                buttonR2C0.setText("X");
            }
        } else {
            System.out.println("Кнопка заблокирована");
        }
        checkWin();
    }

    public void button8Clicked(javafx.event.ActionEvent actionEvent) {
        System.out.println("Button8 clicked");
        i++;
        if (buttonR2C1.getText() == null){
            if ((i % 2) == 0) {
                buttonR2C1.setText("O");
            } else {
                buttonR2C1.setText("X");
            }
        } else {
            System.out.println("Кнопка заблокирована");
        }
        checkWin();
    }

    public void button9Clicked(javafx.event.ActionEvent actionEvent) {
        System.out.println("Button9 clicked");
        i++;
        if (buttonR0C0.getText() == null){
            if ((i % 2) == 0) {
                buttonR2C2.setText("O");
            } else {
                buttonR2C2.setText("X");
            }
        } else {
            System.out.println("Кнопка заблокирована");
        }
        checkWin();
    }
}
