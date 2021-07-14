package Notiz_list_app.uis;

import java.net.URL;

public enum FXML_Location {

    LIST("ListNotesUI.fxml"),
    EDIT("EditNotesUI.fxml");

    private final String location;

    //FXML_Location(String location)
    //{
    //   this.location = location;
//
    //}

    FXML_Location(String location) {
        this.location = location;
    }

    public URL getPage() {
        return getClass().getResource(this.location);
    }

}
