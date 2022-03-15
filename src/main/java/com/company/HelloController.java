package com.company;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HelloController {

    String city;

    @FXML
    private Button abfragenBTN;

    @FXML
    private HBox hbox;

    @FXML
    private TextField textField;

    @FXML
    void onAbfragenButtonPressed(ActionEvent event) {
        city = textField.getText();

        VBox vBox = new VBox();
        hbox.getChildren().add(vBox);
        VBox vBox1 = new VBox();
        hbox.getChildren().add(vBox1);
        VBox vBox2 = new VBox();
        hbox.getChildren().add(vBox2);
    }




}