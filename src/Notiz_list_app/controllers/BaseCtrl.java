package Notiz_list_app.controllers;

import Notiz_list_app.models.Note;
import Notiz_list_app.uis.FXML_Location;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;


public class BaseCtrl {
    /// Hack: Mockobjekt zum testen
    protected static ObservableList<Note> data = FXCollections.observableArrayList(
            new Note("Mock", "Mack"),
            new Note("iOS", "ist nicht so gut. mehihi")
    );

    protected static Note editNote = null;

    protected void navigateTO(Event event, URL location) {
        Parent root = null;
        try {

            root = FXMLLoader.load(location);
        }catch (IOException ex){
            System.err.println(ex.getMessage());
        }
        Stage appStage = (Stage)
                (
                        (Node)(
                                event.getSource()
                              )
                )
                .getScene()
                .getWindow();

        appStage.hide();

        Scene scene = new Scene(root);
        appStage.setScene(scene);
        appStage.show();

    }
}
