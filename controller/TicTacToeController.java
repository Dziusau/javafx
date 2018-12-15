package tictactoe.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TicTacToeController {
    @FXML
    private Button buttonR0C0;
    @FXML
    private Button sign2;
    @FXML
    private Button sign3;
    @FXML
    private Button sign4;
    @FXML
    private Button sign5;
    @FXML
    private Button sign6;
    @FXML
    private Button sign7;
    @FXML
    private Button sign8;
    @FXML
    private Button sign9;

    public void button1Clicked(javafx.event.ActionEvent actionEvent) {
        System.out.println("Button1 clicked");
        buttonR0C0.setText("X");
    }

    public void button2Clicked(javafx.event.ActionEvent actionEvent) {
        System.out.println("Button2 clicked");
        ticTac2.set("O");
    }

    public void button3Clicked(javafx.event.ActionEvent actionEvent) {
        System.out.println("Button3 clicked");
        ticTac3.set("X");
    }

    public void button4Clicked(javafx.event.ActionEvent actionEvent) {
        System.out.println("Button4 clicked");
        ticTac4.set("X");
    }

    public void button5Clicked(javafx.event.ActionEvent actionEvent) {
        System.out.println("Button5 clicked");
        ticTac5.set("O");
    }

    public void button6Clicked(javafx.event.ActionEvent actionEvent) {
        System.out.println("Button6 clicked");
        ticTac6.set("X");
    }

    public void button7Clicked(javafx.event.ActionEvent actionEvent) {
        System.out.println("Button7 clicked");
        ticTac7.set("X");
    }

    public void button8Clicked(javafx.event.ActionEvent actionEvent) {
        System.out.println("Button8 clicked");
        ticTac8.set("O");
    }
    public void button9Clicked(javafx.event.ActionEvent actionEvent) {
        System.out.println("Button9 clicked");
        ticTac9.set("O");
    }
}
