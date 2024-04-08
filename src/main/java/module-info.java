module fr.nassim {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens fr.nassim to javafx.fxml;
    exports fr.nassim;
}
