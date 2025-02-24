module com.example.hbv4d {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hbv4d to javafx.fxml;
    exports com.example.hbv4d.vidmot;
    opens com.example.hbv4d.vidmot to javafx.fxml;
    exports com.example.hbv4d.vinnsla;
    opens com.example.hbv4d.vinnsla to javafx.fxml;
}
