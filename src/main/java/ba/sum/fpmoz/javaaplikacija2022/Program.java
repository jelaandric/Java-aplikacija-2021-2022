package ba.sum.fpmoz.javaaplikacija2022;

import ba.sum.fpmoz.javaaplikacija2022.model.IspitniRok;
import ba.sum.fpmoz.javaaplikacija2022.model.Korisnik;
import ba.sum.fpmoz.javaaplikacija2022.model.Prikaz;
import ba.sum.fpmoz.javaaplikacija2022.model.Table;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Program extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource("prijava-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Dobrodošli na sustav!");
        stage.setScene(scene);
        stage.show();
    }

    public static void swapScene(Stage stage, String viewName, String title){

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource(viewName));
            Scene scene= new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
           System.out.println("nastala je greška" + e.getMessage());
        }


    }

    public static void main(String[] args) {
        launch();
    }
}