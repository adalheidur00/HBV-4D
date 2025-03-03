module com.example.hbv4d {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.example.hbv4d.vidmot to javafx.fxml;
    exports com.example.hbv4d.vidmot;
    exports com.example.hbv4d.vinnsla;
    opens com.example.hbv4d.vinnsla to javafx.fxml;
}
