package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.FocusModel;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import jdk.nashorn.internal.runtime.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML public ListView idContacts;
    @FXML public TextField idSendText;
    @FXML public TextArea idTextMessage;

    public void setIdTextMessage(TextArea idTextMessage) {
        this.idTextMessage = idTextMessage;
    }

    private List<String> startList= new ArrayList<>();
    private ObservableList oList = FXCollections.observableArrayList();


    public ListView getIdContacts() {
        return idContacts;
    }

    public void setIdContacts() {
        this.idContacts = idContacts;

        this.startList.add("Lena");
        this.startList.add("Pasha");
        this.startList.add("Katya");

        oList.setAll(startList);
        idContacts.setItems(oList);

    }

    @FXML
    void initialize(){
        setIdContacts();
    }


    public void OnCkicedList(MouseEvent mouseEvent) {

        this.idTextMessage.clear();

    }

    public void onActionMouseSend(ActionEvent actionEvent) {

        if (!idTextMessage.getText().isEmpty()) {
            this.idTextMessage.appendText("\n");
        }


        this.idTextMessage.appendText("("+ this.idContacts.getId() + ")" + idSendText.getText());
        idSendText.clear();

    }

}
