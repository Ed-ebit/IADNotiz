package Notiz_list_app.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ListNoteCtrl implements Initializable {

    @FXML
    private TextField txtSearchNote;

    @FXML
    private Label lblCountNotes;

    @FXML
    private TableColumn<?, ?> tbvNotes;

    @FXML
    void onDeletNote(ActionEvent event) {

    }

    @FXML
    void onEditNote(ActionEvent event) {

    }

    @FXML
    void onNeueNotiz(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }
}