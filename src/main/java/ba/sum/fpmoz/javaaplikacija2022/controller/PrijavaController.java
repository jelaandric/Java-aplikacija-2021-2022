package ba.sum.fpmoz.javaaplikacija2022.controller;

import ba.sum.fpmoz.javaaplikacija2022.Program;
import ba.sum.fpmoz.javaaplikacija2022.model.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PrijavaController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick(ActionEvent evt) {
        welcomeText.setText("Welcome to JavaFX Application!");

    }
    @FXML
    TextField EmailTxt;
    @FXML
    TextField LozinkaTxt;
    @FXML
    RadioButton NastavnikRB;
    @FXML
    RadioButton StudentRB;
    @FXML
    Button PrijavaBtn;
    @FXML
    Label GreškaLbl;

    @FXML
    public void prijava (ActionEvent evt) {
        String korisnickoIme = EmailTxt.getText();
        String lozinka = LozinkaTxt.getText();
        RadioButton rb1 = NastavnikRB;
        RadioButton rb2 = StudentRB;
        ToggleGroup toggleGroup = new ToggleGroup();

        rb1.setToggleGroup(toggleGroup);
        rb1.setSelected(true);
        rb2.setToggleGroup(toggleGroup);

        RadioButton selectedRadioButton =
                (RadioButton) toggleGroup.getSelectedToggle();
        try {
            PreparedStatement upit = Database.CONNECTION.prepareStatement("SELECT * FROM Korisnik WHERE email=? AND lozinka=?");
            upit.setString(1, korisnickoIme);
            upit.setString(2, lozinka);
            ResultSet rezultat = upit.executeQuery();

            if (rezultat.next()) {

                if (selectedRadioButton==NastavnikRB) {
                    Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
                    Program.swapScene(stage, "nastavnik-view.fxml", "Administracija");

                }else{

                    Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
                    Program.swapScene(stage, "student-view.fxml", "Pregled ispitnih rokova");
                }


            } else {
                GreškaLbl.setText("Korisnički podaci nisu ispravni!");
            }
        } catch (Exception ex) {
            System.out.println("Nastala je greška: " + ex.getMessage());
            ex.printStackTrace();
        }


    }


}