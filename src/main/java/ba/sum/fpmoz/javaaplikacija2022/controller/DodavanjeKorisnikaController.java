package ba.sum.fpmoz.javaaplikacija2022.controller;

import ba.sum.fpmoz.javaaplikacija2022.Program;
import ba.sum.fpmoz.javaaplikacija2022.model.Korisnik;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DodavanjeKorisnikaController {
    @FXML
    TextField ImeTxt;
    @FXML
    TextField PrezimeTxt;
    @FXML
    TextField EmailTxt;
    @FXML
    TextField LozinkaTxt;
    @FXML
    TextField UlogaTxt;
    @FXML
    protected void nazad (ActionEvent evt){
        Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        Program.swapScene(stage, "prijava-view.fxml", "Dobrodošli na sustav!");
    }
    @FXML
    protected void dodajKorisnika () throws Exception {
        Korisnik korisnik = new Korisnik();
        korisnik.setIme(this.ImeTxt.getText());
        korisnik.setPrezime(this.PrezimeTxt.getText());
        korisnik.setEmail(this.EmailTxt.getText());
        korisnik.setLozinka(this.LozinkaTxt.getText());
        korisnik.setUloga(this.UlogaTxt.getText());
        korisnik.save();

        this.ImeTxt.setText("");
        this.PrezimeTxt.setText("");
        this.EmailTxt.setText("");
        this.LozinkaTxt.setText("");
        this.UlogaTxt.setText("");
    }
}
