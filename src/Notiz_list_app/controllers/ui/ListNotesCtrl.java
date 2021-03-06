package Notiz_list_app.controllers.ui;

import Notiz_list_app.controllers.BaseCtrl;
import Notiz_list_app.models.Note;
import Notiz_list_app.uis.FXML_Location;
import javafx.beans.binding.Bindings;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListNotesCtrl extends BaseCtrl implements Initializable {

    private SelectionModel<Note> selectionModel;

    @FXML
    private MenuBar mnbListView;

    @FXML
    private TextField txtSearchNote;

    @FXML
    private Label lblCountNotes;

    @FXML
    private Button btnDeleteNote;

    @FXML
    private Button btnEditNote;

    @FXML
    private TableView<Note> tbvNote;

    @FXML
    private TableColumn tbvTitle;

    @FXML
    private TableColumn<?, ?> tbvDescription;

    @FXML
    void onEditAndNew(ActionEvent event) throws IOException {

        Parent root= FXMLLoader.load(FXML_Location.EDIT.getPage());
        Stage stage = (Stage) ((Node)mnbListView).getScene().getWindow();
        stage.hide();
        stage.setScene(new Scene(root));
        stage.show();

        //navigateTO(event, FXML_Location.EDIT.getPage()); doesnt work

    }

    @FXML
    void onDeletNote(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        var result = alert.showAndWait();
        //mit extra erstellter Methode getNoteItem:
        if(getNoteItem()!=null && result.isPresent() && result.get() == ButtonType.OK){

            data.remove((getNoteItem()));
            selectionModel.clearSelection();
        }
/*        if(tbvNote.getSelectionModel().getSelectedItems().size()>0){
            //System.out.println
            data.remove(tbvNote.getSelectionModel().getSelectedItem());
        }*/

   //     var res = tbvNote.getSelectionModel();

    }


    @FXML
    void onEditNote(ActionEvent event) {
        if(getNoteItem()!=null){
            editNote = getNoteItem();

        }
        try {
            super.navigateTO(event, FXML_Location.EDIT.getPage());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    @FXML
    void onNeueNotiz(ActionEvent event) {
        try {

            super.navigateTO(event, FXML_Location.EDIT.getPage());
        }catch (Exception ex) {
            System.err.println(ex.getMessage());

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectionModel = tbvNote.getSelectionModel();
        tbvTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        tbvDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        //tbvNote.setItems(BaseCtrl.data);
        FilteredList<Note> filteredData = new FilteredList<>(data);
        txtSearchNote.setOnKeyReleased(k ->{filteredData.setPredicate((n->{return n.getTitle().toUpperCase().contains(txtSearchNote.getText().toUpperCase())
                || n.getDescription().contains(txtSearchNote.getText());}));});

        tbvNote.setItems(filteredData);


        lblCountNotes.textProperty().bind(Bindings.createStringBinding(() ->data.size()+(data.size()==1? " Notiz":" Notizen")));

        btnDeleteNote.disableProperty().bind(selectionModel.selectedItemProperty().isNull());
        btnEditNote.disableProperty().bind(selectionModel.selectedItemProperty().isNull());



    }
    private Note getNoteItem(){
        return tbvNote.getSelectionModel().getSelectedItem(); // Neu
        //return Note.class.cast(tbvNote.getSelectionModel().getSelectedItem()); Alt
    }
}
