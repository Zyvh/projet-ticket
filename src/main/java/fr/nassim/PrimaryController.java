package fr.nassim;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private TextField intitule;

    @FXML
    private TextArea descriptionA;

    @FXML
    private ComboBox<String> criticiteBox;

    @FXML
    protected void initialize() {
        criticiteBox.getItems().addAll("Faible", "Moyenne", "Élevée");
    }

    @FXML
    protected void envoyerButton(ActionEvent event) {
        String libelle = intitule.getText();
        String description = descriptionA.getText();
        String criticite = criticiteBox.getValue();

        AccesBdd.saveTicket(libelle, description, criticite);

        intitule.clear();
        descriptionA.clear();
    }
}
