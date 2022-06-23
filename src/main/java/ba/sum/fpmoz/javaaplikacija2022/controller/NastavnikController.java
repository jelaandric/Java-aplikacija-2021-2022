package ba.sum.fpmoz.javaaplikacija2022.controller;

import ba.sum.fpmoz.javaaplikacija2022.Program;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class NastavnikController {
    @FXML
    protected void korisnici (ActionEvent evt){
        Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        Program.swapScene(stage, "dodavanjeKorisnika-view.fxml", "Korisnici");
    }
    @FXML
    protected void rokovi (ActionEvent evt){
        Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        Program.swapScene(stage, "dodavanjeRokova-view.fxml", "Ispitni rokovi");
    }
}
