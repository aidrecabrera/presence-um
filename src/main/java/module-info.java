module presence.presenceum {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;


    opens presence to javafx.fxml;
    exports presence;
}