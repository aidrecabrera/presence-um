module presence.presenceum {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.desktop;
    requires com.google.zxing;
    requires com.google.zxing.javase;
    requires opencv;
    requires webcam.capture;
    requires jdk.hotspot.agent;

    opens presence to javafx.fxml;
    exports presence;
    exports presence.scanning;
    opens presence.scanning to javafx.fxml;
    exports presence.backend;
    opens presence.backend to javafx.fxml;
    exports presence.dashboard;
    opens presence.dashboard to javafx.fxml;
    opens presence.attendance to javafx.fxml;
    exports presence.attendance;
}