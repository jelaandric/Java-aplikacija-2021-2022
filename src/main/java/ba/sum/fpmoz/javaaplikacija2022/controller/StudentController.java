package ba.sum.fpmoz.javaaplikacija2022.controller;

import ba.sum.fpmoz.javaaplikacija2022.Program;
import ba.sum.fpmoz.javaaplikacija2022.model.IspitniRok;
import ba.sum.fpmoz.javaaplikacija2022.model.Prikaz;
import ba.sum.fpmoz.javaaplikacija2022.model.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    @FXML
    TableColumn tableColumnNastavnik;
    @FXML
    TableColumn tableColumnPredmet;
    @FXML
    TableColumn tableColumnDatum;
    @FXML
    TableView tableViewRokovi;
    @FXML
    protected void natrag (ActionEvent evt){
        Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        Program.swapScene(stage, "prijava-view.fxml", "Administracija");
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
