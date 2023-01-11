package com.example.mycalculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class MyCalculator<T extends Event> extends Application implements EventHandler<T> {

    private String currOp;
    private StringBuilder nextNum;

    private int maxHBox;
    private int maxRowElem;
    private int i;
    private int flag;

    private Double res;
    private String virgule;

    private Label label;
    private VBox layout;

    private ArrayList<HBox> listHBox;

    private ArrayList<String> firstRowElem; // own the contents of the buttons of the first row
    private ArrayList<String> secondRowElem; // own the contents of the buttons of the second row
    private ArrayList<String> thirdRowElem; // own the contents of the buttons of the third row
    private ArrayList<String> fourthRowElem; // own the contents of the buttons of the fourth row
    private ArrayList<String> fifthRowElem; // own the contents of the buttons of the fifth row

    private ArrayList<Button> firstRow; // own the buttons of the first row
    private ArrayList<Button> secondRow; // own the buttons of the second row
    private ArrayList<Button> thirdRow; // own the buttons of the third row
    private ArrayList<Button> fourthRow; // own the buttons of the fourth row
    private ArrayList<Button> fifthRow; // own the buttons of the fifth row

///////////////////////////////////////////////////////////

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        maxHBox = 5;
        maxRowElem = 4;
        flag = 0;
        res = 0.0;
        virgule = "";

        listHBox = new ArrayList<>();

        firstRowElem = new ArrayList<>();
        secondRowElem = new ArrayList<>();
        thirdRowElem = new ArrayList<>();
        fourthRowElem = new ArrayList<>();
        fifthRowElem = new ArrayList<>();
        firstRow = new ArrayList<>();
        secondRow = new ArrayList<>();
        thirdRow = new ArrayList<>();
        fourthRow = new ArrayList<>();
        fifthRow = new ArrayList<>();

        label = new Label();

        setHBoxes();
        setLayout();

        Scene scene = new Scene(layout, 200, 300);

        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.sizeToScene();
        stage.show();

    }

////////////////////////////////////////////////////////////

    public void setLayout() {

        layout = new VBox();

        for(i = 0; i <= maxHBox; i++) {
            layout.getChildren().add(listHBox.get(i));
        }

    }

///////////////////////////////////////////////////////

    public void setHBoxes() {

        for(int index = 0; index <= maxHBox; index++) {

            listHBox.add(new HBox());
            listHBox.get(index).setPrefWidth(50);
            listHBox.get(index).setPrefHeight(50);

            switch(index) {

                case 0:

                    listHBox.get(index).getChildren().add(label);
                    listHBox.get(index).setAlignment(Pos.CENTER);

                    break;

                case 1:

                    firstRow();
                    setHBoxesChildren(index, firstRow);

                    break;

                case 2:

                    secondRow();
                    setHBoxesChildren(index, secondRow);

                    break;

                case 3:

                    thirdRow();
                    setHBoxesChildren(index, thirdRow);

                    break;

                case 4:

                    fourthRow();
                    setHBoxesChildren(index, fourthRow);

                    break;

                case 5:

                    fifthRow();
                    setHBoxesChildren(index, fifthRow);

                    break;

                default:

                    break;
            }

        }

    }

////////////////////////////////////////////////////////////////////////////////////////////

    public void populateFirstRow() {

        for(i = 0; i < maxRowElem; i++) {

            switch(i) {

                case 0:
                    firstRowElem.add(i, "C");

                    break;

                case 1:
                    firstRowElem.add(i, "<-");

                    break;

                case 2:
                    firstRowElem.add(i, "%");

                    break;

                case 3:
                    firstRowElem.add(i, "/");

                    break;

                default:

                    break;
            }

        }

    }

    public void populateSecondRow() {

        for(i = 0; i < maxRowElem; i++) {

            switch(i) {

                case 0:
                    secondRowElem.add(i, "7");

                    break;

                case 1:
                    secondRowElem.add(i, "8");

                    break;

                case 2:
                    secondRowElem.add(i, "9");

                    break;

                case 3:
                    secondRowElem.add(i, "x");

                    break;

                default:

                    break;
            }

        }

    }

    public void populateThirdRow() {

        for(i = 0; i < maxRowElem; i++) {

            switch(i) {

                case 0:
                    thirdRowElem.add(i, "4");

                    break;

                case 1:
                    thirdRowElem.add(i, "5");

                    break;

                case 2:
                    thirdRowElem.add(i, "6");

                    break;

                case 3:
                    thirdRowElem.add(i, "-");

                    break;

                default:

                    break;
            }

        }

    }

    public void populateFourthRow() {

        for(i = 0; i < maxRowElem; i++) {

            switch(i) {

                case 0:
                    fourthRowElem.add(i, "1");

                    break;

                case 1:
                    fourthRowElem.add(i, "2");

                    break;

                case 2:
                    fourthRowElem.add(i, "3");

                    break;

                case 3:
                    fourthRowElem.add(i, "+");

                    break;

                default:

                    break;
            }

        }

    }

    public void populateFifthRow() {

        for(i = 0; i < maxRowElem - 1; i++) {

            switch(i) {

                case 0:
                    fifthRowElem.add(i, "0");

                    break;

                case 1:
                    fifthRowElem.add(i, ",");

                    break;

                case 2:
                    fifthRowElem.add(i, "=");

                    break;

                default:

                    break;
            }

        }

    }

///////////////////////////////////////////////////////////

    @SuppressWarnings("unchecked")
    public void firstRow() {

        populateFirstRow();
        for(i = 0; i < maxRowElem; i++) {
            firstRow.add(new Button(firstRowElem.get(i)));
            firstRow.get(i).setOnAction((EventHandler<ActionEvent>) this);
            if(i != 0) firstRow.get(i).setDisable(true);
        }

    }

    public void secondRow() {

        populateSecondRow();
        populate(secondRow, secondRowElem);

    }

    public void thirdRow() {

        populateThirdRow();
        populate(thirdRow, thirdRowElem);

    }

    public void fourthRow() {

        populateFourthRow();
        populate(fourthRow, fourthRowElem);

    }

    @SuppressWarnings("unchecked")
    private void populate(ArrayList<Button> row, ArrayList<String> rowElem) {
        for(i = 0; i < maxRowElem; i++) {
            row.add(new Button(rowElem.get(i)));
            row.get(i).setOnAction((EventHandler<ActionEvent>) this);
            if(i == maxRowElem - 1) row.get(i).setDisable(true);
        }
    }

    @SuppressWarnings("unchecked")
    public void fifthRow() {

        populateFifthRow();
        for(i = 0; i < maxRowElem - 1; i++) {
            fifthRow.add(new Button(fifthRowElem.get(i)));
            fifthRow.get(i).setOnAction((EventHandler<ActionEvent>) this);
            if(i == maxRowElem - 2 || i == maxRowElem - 3) fifthRow.get(i).setDisable(true);
        }

    }

/////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void handle(T event) {

        if(res != 0.0) {
            label.setText("");
            res = 0.0;
        }

        Button button = (Button)event.getSource();
        if(firstRow.contains(button)) {
            setFirstRowEvent(event);
        }else {
            if(secondRow.contains(button)) {
                setEvent(secondRow, "x", event);
            }else if(thirdRow.contains(button)) {
                setEvent(thirdRow, "-", event);
            }else if(fourthRow.contains(button)) {
                setEvent(fourthRow, "+", event);
            }else if(fifthRow.contains(button)) {
                setLastRowEvent(event);
            }

        }

    }

/////////////////////////////////////////////////////////////////////////////////////////////////////

    public void enableDisabledButtons() {
        enableFirstRow();
        enableSecondRow();
        enableThirdRow();
        enableFourthRow();
        enableFifthRow();
    }

    public void enableFirstRow() {
        for(i = 1; i < firstRow.size(); i++) {
            firstRow.get(i).setDisable(false);
        }
    }

    public void enableSecondRow() {
        secondRow.get(secondRow.size() - 1).setDisable(false);
    }

    public void enableThirdRow() {
        thirdRow.get(thirdRow.size() - 1).setDisable(false);
    }

    public void enableFourthRow() {
        fourthRow.get(fourthRow.size() - 1).setDisable(false);
    }

    public void enableFifthRow() {
        for(i = 1; i < fifthRow.size(); i++) {
            fifthRow.get(i).setDisable(false);
        }
    }

////////////////////////////////////////////////////////////////

    public void disableEnabledButtons() {
        disableFirstRow();
        disableSecondRow();
        disableThirdRow();
        disableFourthRow();
        disableFifthRow();
    }

    public void disableFirstRow() {
        for(i = 2; i < firstRow.size(); i++) {
            firstRow.get(i).setDisable(true);
        }
    }

    public void disableSecondRow() {
        secondRow.get(secondRow.size() - 1).setDisable(true);
    }

    public void disableThirdRow() {
        thirdRow.get(thirdRow.size() - 1).setDisable(true);
    }

    public void disableFourthRow() {
        fourthRow.get(fourthRow.size() - 1).setDisable(true);
    }

    public void disableFifthRow() {
        for(i = 1; i < fifthRow.size(); i++) {
            fifthRow.get(i).setDisable(true);
        }
    }

/////////////////////////////////////////////////////////////////////

    public void calcExpr() {

        StringBuilder prevNum = new StringBuilder();

        currOp = "";
        nextNum = new StringBuilder();

        for(i = 0; i < label.getText().length(); i++) {

            if(label.getText().charAt(i) == '+') {

                analyzeOp('+', i);

            }else if(label.getText().charAt(i) == '-') {

                analyzeOp('-', i);

            }else if(label.getText().charAt(i) == 'x') {

                analyzeOp('x', i);

            }else if(label.getText().charAt(i) == '/') {

                analyzeOp('/', i);

            }else {
                if(currOp.equals("")) {
                    prevNum.append(label.getText().charAt(i));
                }else {
                    if(res == 0.0) {
                        res = Double.parseDouble(prevNum.toString());
                        prevNum = new StringBuilder();
                    }
                    nextNum.append(label.getText().charAt(i));
                }
            }

        }
        lastOpStep();
        disableEnabledButtons();
    }

/////////////////////////////////////////////////////////////////////

    public void verifyPercent() {

        String singleNum = "";
        double perNum;

        StringBuilder str = new StringBuilder();

        for(i = label.getText().length() - 1; i >= 0;i--) {
            if(label.getText().charAt(i) == '+' || label.getText().charAt(i) == '-' || label.getText().charAt(i) == '/' || label.getText().charAt(i) == 'x') {
                singleNum = "";
                break;
            }
            else {
                str.append(label.getText().charAt(i));
                singleNum = str.toString();
            }
        }
        if(!singleNum.equals("")) {
            perNum = Double.parseDouble(new StringBuffer(singleNum).reverse().toString());
            perNum /= 100;
            res = perNum;
            label.setText(String.valueOf(res));
            virgule = "";
            disableEnabledButtons();
        }

    }

    public void removeLastNum() {

        if(label.getText().length() > 0) {

            label.setText(new StringBuffer(label.getText())
                    .deleteCharAt(label.getText().length() - 1)
                    .toString());

        }

        if(label.getText().length() > 0) {

            if(label.getText().charAt(label.getText().length() - 1) == '+' || label.getText().charAt(label.getText().length() - 1) == '-' || label.getText().charAt(label.getText().length() - 1) == '/' || label.getText().charAt(label.getText().length() - 1) == 'x' || label.getText().charAt(label.getText().length() - 1) == '.') {
                disableEnabledButtons();
            }else {
                enableDisabledButtons();
            }

        }

        if(label.getText().equals("")) {
            disableEnabledButtons();
        }

        virgule = "";

    }

/////////////////////////////////////////////////////////////////////

    public void setHBoxesChildren(int index, List<Button> selectedRow) {

        int j;

        for(j = 0; j < selectedRow.size(); j++) {

            if(selectedRow == fifthRow && j == 0) {

                selectedRow.get(j).setMinWidth(2*listHBox.get(index).getPrefWidth());

            }else {

                selectedRow.get(j).setMinWidth(listHBox.get(index).getPrefWidth());

            }
            selectedRow.get(j).setMinHeight(listHBox.get(index).getPrefHeight());
            listHBox.get(index).getChildren().add(selectedRow.get(j));
        }
    }

//////////////////////////////////////////////////////////////////////////////////////

    public void setEvent(List<Button> selectedRow, String op, Event event) {

        for (Button button : selectedRow) {
            if (button.equals(event.getSource())) {
                label.setText(label.getText() + button.getText());
                if (button.getText().equals(op)) {
                    virgule = "";
                    disableEnabledButtons();
                } else {
                    enableDisabledButtons();
                    if (virgule.equals(",")) fifthRow.get(fifthRow.size() - 2).setDisable(true);
                }
            }
        }

    }

/////////////////////////////////////////////////////////////////////////////////////////////////////

    public void setFirstRowEvent(Event event) {

        for (Button button : firstRow) {
            if (button.equals(event.getSource())) {
                if (button.getText().equals("C")) {
                    label.setText("");
                    virgule = "";
                    disableEnabledButtons();
                } else if (button.getText().equals("/")) {
                    label.setText(label.getText() + button.getText());
                    virgule = "";
                    disableEnabledButtons();
                } else if (button.getText().equals("%")) {
                    verifyPercent();
                } else {
                    removeLastNum();
                }
            }
        }

    }

///////////////////////////////////////////////////////////////////////////////////////////

    public void setLastRowEvent(Event event) {

        for (Button button : fifthRow) {
            if (button.equals(event.getSource())) {
                if (button.getText().equals(",") && virgule.equals("")) {
                    label.setText(label.getText() + ".");
                    virgule = ",";
                    disableEnabledButtons();
                } else {
                    if (button.getText().equals("0")) {
                        label.setText(label.getText() + button.getText());
                        enableDisabledButtons();
                    } else {
                        calcExpr();
                        verifyFlag();
                    }
                }
            }
        }

    }

////////////////////////////////////////////////////////////////////////////////////////////

    public void analyzeOp(char op, int i) {

        if(currOp.equals("")) {
            currOp = String.valueOf(label.getText().charAt(i));
        }else {
            switch (currOp) {
                case "+":
                    res += Double.parseDouble(String.valueOf(nextNum));
                    nextNum = new StringBuilder();
                    currOp = String.valueOf(op);
                    break;
                case "-":
                    res -= Double.parseDouble(String.valueOf(nextNum));
                    nextNum = new StringBuilder();
                    currOp = String.valueOf(op);
                    break;
                case "x":
                    res *= Double.parseDouble(String.valueOf(nextNum));
                    nextNum = new StringBuilder();
                    currOp = String.valueOf(op);
                    break;
                default:
                    res /= Double.parseDouble(String.valueOf(nextNum));
                    nextNum = new StringBuilder();
                    currOp = String.valueOf(op);
                    break;
            }
        }

    }

////////////////////////////////////////////////////////////////

    public void lastOpStep() {

        if(currOp.equals("+")) {
            res += Double.parseDouble(String.valueOf(nextNum));
        }else {
            switch (currOp) {
                case "-":
                    res -= Double.parseDouble(String.valueOf(nextNum));
                    break;
                case "x":
                    res *= Double.parseDouble(String.valueOf(nextNum));
                    break;
                case "/":
                    res /= Double.parseDouble(String.valueOf(nextNum));
                    break;
                default:
                    flag++;
                    break;
            }
        }

    }

/////////////////////////////////////////////////////////

    public void verifyFlag() {

        if(flag == 0) {
            label.setText(String.valueOf(res));
        }else {
            label.setText("");
            flag--;
        }

    }

}

