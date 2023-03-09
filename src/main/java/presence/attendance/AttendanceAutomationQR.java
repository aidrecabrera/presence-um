package presence.attendance;

import presence.scanning.QRScanner;

public class AttendanceAutomationQR {
    QRScanner apiQRScanner = new QRScanner();

    public void apiQQ() {
        apiQRScanner.run();
    }
}
