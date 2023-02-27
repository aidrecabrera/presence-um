module presence.presenceum {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens presence.presenceum to javafx.fxml;
    exports presence.presenceum;
}