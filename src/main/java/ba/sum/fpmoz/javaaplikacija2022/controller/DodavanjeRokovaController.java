package ba.sum.fpmoz.javaaplikacija2022.controller;

import ba.sum.fpmoz.javaaplikacija2022.Program;
import ba.sum.fpmoz.javaaplikacija2022.model.*;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class DodavanjeRokovaController implements Initializable  {
    @FXML
    protected void nazad (ActionEvent evt){
        Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        Program.swapScene(stage, "prijava-view.fxml", "Dobrodošli na sustav!");
    }
    @FXML
    ChoiceBox nastavnikTxt;
    @FXML
    ChoiceBox predmetTxt;
    @FXML
    TextField datumTxt;
    @FXML
    Korisnik odabraniNastavnik;
    @FXML
    Predmet odabraniPredmet;
    @FXML
    TableColumn tableColumnNastavnik;
    @FXML
    TableColumn tableColumnPredmet;
    @FXML
    TableColumn tableColumnDatum;
    @FXML
    TableView tableViewRokovi;
    @FXML
    Button izbrišiBtn;
    Prikaz odabraniRok;


    @FXML
    protected void odabraniRok (){
        this.odabraniRok = (Prikaz) this.tableViewRokovi.getSelectionModel().getSelectedItem();
        this.izbrišiBtn.setDisable(false);
        this.nastavnikTxt.setId(this.odabraniRok.getNastavnikFk());
        this.predmetTxt.setId(this.odabraniRok.getPredmetFk());
        this.datumTxt.setText(this.odabraniRok.getDatum());
    }

    @FXML
    protected void izbrišiRok () throws Exception {
        if (this.odabraniRok!= null){
            this.odabraniRok.delete();
            this.prikažiRokove();
        }
    }



    @FXML
    protected void kreirajIspitniRok() throws Exception{
        if(this.odabraniRok==null){
            IspitniRok rok = new IspitniRok();
            this.odabraniNastavnik = (Korisnik) this.nastavnikTxt.getSelectionModel().getSelectedItem();
            rok.setNastavnikFk(this.odabraniNastavnik.getID());
            this.odabraniPredmet = (Predmet) this.predmetTxt.getSelectionModel().getSelectedItem();
            rok.setPredmetFk(this.odabraniPredmet.getID());
            rok.setDatum(this.datumTxt.getText());
            rok.save();
    }else{
            this.odabraniRok.setPredmetFk(this.predmetTxt.getId());
            this.odabraniRok.setNastavnikFk(this.nastavnikTxt.getId());
            this.odabraniRok.setDatum(this.datumTxt.getText());
            this.odabraniRok.update();
            this.odabraniRok=null;

        }
        this.izbrišiBtn.setDisable(true);
        this.prikažiRokove();
        this.predmetTxt.setId("");
        this.nastavnikTxt.setId("");
        this.datumTxt.setText("");
    }
    @FXML
    private void nastavnici (){
        try {

            ObservableList<?>  nastavnici = FXCollections.observableArrayList(Table.list(Korisnik.class));
            nastavnikTxt.setItems(nastavnici);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    @FXML
    private void predmeti(){
        try {
            ObservableList<?>  predmeti = FXCollections.observableArrayList(Table.list(Predmet.class));
            predmetTxt.setItems(predmeti);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private void prikažiRokove(){
        try {
            ObservableList<?> rokovi = FXCollections.observableList(Table.list(Prikaz.class));
            this.tableViewRokovi.setItems(rokovi);

        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        this.tableColumnDatum.setCellValueFactory(new PropertyValueFactory<>("datum"));
        this.tableColumnPredmet.setCellValueFactory(new PropertyValueFactory<>("predmetFk"));
        this.tableColumnNastavnik.setCellValueFactory(new PropertyValueFactory<>("nastavnikFk"));
        this.prikažiRokove();
    }




}