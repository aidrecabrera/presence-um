package presence.scanning;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

public class QuickReadPresence {
    private static String QR_Retrieved_ID;
    public static String QR_Read(String paramQR_IMAGE_PATH) {
        try {
            String QR_PATH = paramQR_IMAGE_PATH;
            BufferedImage QR_IMAGE_BF = ImageIO.read(new FileInputStream(QR_PATH));
            BinaryBitmap QR_BITMAP = new BinaryBitmap(new HybridBinarizer(
                    new BufferedImageLuminanceSource(QR_IMAGE_BF)
            ));
            Result QR_TEXT_RETRIEVAL = new MultiFormatReader().decode(QR_BITMAP);
            QR_Retrieved_ID = QR_TEXT_RETRIEVAL.getText();
            System.out.println("Scanned Student ID: " + QR_TEXT_RETRIEVAL.getText());
        } catch (Exception e) {

        }
        return QR_Retrieved_ID;
    }
}
