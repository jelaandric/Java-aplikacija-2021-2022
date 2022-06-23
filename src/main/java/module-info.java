module ba.sum.fpmoz.javaaplikacija2022 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens ba.sum.fpmoz.javaaplikacija2022 to javafx.fxml;
    exports ba.sum.fpmoz.javaaplikacija2022;
    exports ba.sum.fpmoz.javaaplikacija2022.controller;
    opens ba.sum.fpmoz.javaaplikacija2022.controller to javafx.fxml;
    opens ba.sum.fpmoz.javaaplikacija2022.model to javafx.fxml;
    exports ba.sum.fpmoz.javaaplikacija2022.model;
}