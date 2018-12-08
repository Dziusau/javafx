package controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.xml.soap.Text;
import java.awt.*;

public class CalculatorController {
    @FXML
    private TextField display;

    SimpleStringProperty calculatorDisplay = new SimpleStringProperty();

    @FXML
    public void initialize() {
        display.textProperty().bind(calculatorDisplay);
    }

    @FXML
    private TextField currentState;

    public void button0Clicked (javafx.event.ActionEvent actionEvent){
        System.out.println("button 0 is clicked");
        currentState = display;
        calculatorDisplay.set(currentState + "0");
    }

    public void button1Clicked (javafx.event.ActionEvent actionEvent){
        System.out.println("button 1 is clicked");
        currentState = display;
        calculatorDisplay.set(currentState + "1");
    }

    public void button2Clicked (javafx.event.ActionEvent actionEvent){
        System.out.println("button 2 is clicked");
        currentState = display;
        calculatorDisplay.set(currentState + "2");
    }

    public void button3Clicked (javafx.event.ActionEvent actionEvent){
        System.out.println("button 3 is clicked");
        currentState = display;
        calculatorDisplay.set(currentState + "3");
    }

    public void button4Clicked (javafx.event.ActionEvent actionEvent){
        System.out.println("button 4 is clicked");
        currentState = display;
        calculatorDisplay.set(currentState + "4");
    }

    public void button5Clicked (javafx.event.ActionEvent actionEvent){
        System.out.println("button 5 is clicked");
        currentState = display;
        calculatorDisplay.set(currentState + "5");
    }

    public void button6Clicked (javafx.event.ActionEvent actionEvent){
        System.out.println("button 6 is clicked");
        currentState = display;
        calculatorDisplay.set(currentState + "6");
    }

    public void button7Clicked (javafx.event.ActionEvent actionEvent){
        System.out.println("button 7 is clicked");
        currentState = display;
        calculatorDisplay.set(currentState + "7");
    }

    public void button8Clicked (javafx.event.ActionEvent actionEvent){
        System.out.println("button 8 is clicked");
        currentState = display;
        calculatorDisplay.set(currentState + "8");
    }

    public void button9Clicked (javafx.event.ActionEvent actionEvent){
        System.out.println("button 9 is clicked");
        currentState = display;
        calculatorDisplay.set(currentState + "9");
    }

    public void buttonCleanClicked (javafx.event.ActionEvent actionEvent){
        System.out.println("button Clean is clicked");
        currentState = display;
        calculatorDisplay.set("");
    }

    public void buttonSumClicked (javafx.event.ActionEvent actionEvent){
        System.out.println("button + is clicked");
        currentState = display;
        calculatorDisplay.set(currentState + "+");
    }

    public void buttonDifClicked (javafx.event.ActionEvent actionEvent){
        System.out.println("button - is clicked");
        currentState = display;
        calculatorDisplay.set(currentState + "-");
    }

    public void buttonOpClicked (javafx.event.ActionEvent actionEvent){
        System.out.println("button * is clicked");
        currentState = display;
        calculatorDisplay.set(currentState + "*");
    }

    public void buttonDivClicked (javafx.event.ActionEvent actionEvent){
        System.out.println("button / is clicked");
        currentState = display;
        calculatorDisplay.set(currentState + "/");
    }

    public void buttonPtClicked (javafx.event.ActionEvent actionEvent){
        System.out.println("button . is clicked");
        currentState = display;
        calculatorDisplay.set(currentState + ".");
    }

    public void buttonParClicked (javafx.event.ActionEvent actionEvent){
        System.out.println("button = is clicked");
        findingSing();
    }

    public void findingSing () {
        currentState = display;
        int position = currentState.indexOf("+");
        double numberBefore = currentState.substring(0, position - 1);
        double numberAfter = currentState.substring(position + 1, currentState.getLength());
        double sum = numberBefore + numberAfter;

    }
}
