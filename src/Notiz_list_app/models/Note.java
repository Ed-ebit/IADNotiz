package Notiz_list_app.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Note {

    private StringProperty title = new SimpleStringProperty();
    private StringProperty description = new SimpleStringProperty();


    public Note(String title, String description) {// 2 Möglichkeiten der Erzeugung:
        this.title.setValue(title);
        this.description = new SimpleStringProperty(description);
    }

    // Getter und Setter?

    public String getTitle(){
        return this.title.get();
    }
    public String getDescription(){
        return this.description.get();
    }

}
