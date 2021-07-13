package Notiz_list_app.uis;

import java.net.URL;

public enum FXML_Location {

    LIST("../Notiz_list_app/uis/ListNotesUI.fxml"),
    EDIT("../Notiz_list_app/uis/EditNotesUI.fxml");

    private final String location;
        FXML_Location(String location){
            this.location=location;

        }
        public URL getPage(){
            return getClass().getResource(this.location);
        }

}
