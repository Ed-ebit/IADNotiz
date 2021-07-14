package Notiz_list_app.controllers.ui;


import Notiz_list_app.controllers.BaseCtrl;
import Notiz_list_app.models.Note;
import Notiz_list_app.uis.FXML_Location;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static java.util.Objects.nonNull;

public class EditNotesCtrl extends BaseCtrl implements Initializable {


        @FXML
        private TextField txtTitle;

        @FXML
        private TextArea txaDescription;

        @FXML
        void onCancel(ActionEvent event) {

                super.navigateTO(event, FXML_Location.LIST.getPage());

        }

        @FXML
        void onDelete(ActionEvent event) {

                txaDescription.clear();
                txtTitle.clear();

        }

        @FXML
        void onList(ActionEvent event) {

                super.navigateTO(event, FXML_Location.LIST.getPage());

        }

        @FXML
        void onSave(ActionEvent event) {

                if(nonNull(editNote)) data.remove(editNote);
                if (txtTitle.getText().trim().equals("") || txaDescription.getText().trim().equals(""))
                {
                        //Alert
                        //return
                }
                data.add(new Note(txtTitle.getText(), txaDescription.getText()));

                super.navigateTO(event, FXML_Location.LIST.getPage());

        }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

                /*if(editNote !=null)
                        {
                        txtTitle.setText(editNote.getTitle());
                        txaDescription.setText(editNote.getDescription());
                        saveBtn.setText("Update");
                }*/ //nicht unbedingt nötig, nur für Änderung der Amzeige auf dem Speichernbutton
                    //hierzu muss der Button erst in FXML-Datei angelegt werden

    }


}
