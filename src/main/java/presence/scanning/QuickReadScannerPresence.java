package presence.scanning;

import com.github.sarxos.webcam.Webcam;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class QuickReadScannerPresence {
    private static final int FRAME_WIDTH = 640;
    private static final int FRAME_HEIGHT = 480;
    private static final int IMAGE_WIDTH = 320;
    private static final int IMAGE_HEIGHT = 240;

    public static void main(String[] args) {
        JFrame frame = new JFrame("QR Scanner");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));

        JLabel label = new JLabel();
        frame.add(label);

        Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(new Dimension(IMAGE_WIDTH, IMAGE_HEIGHT));
        webcam.open();

        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            while (true) {
                BufferedImage image = webcam.getImage();
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
                try {
                    Result result = new MultiFormatReader().decode(bitmap);
                    if (result != null) {
                        label.setIcon(new ImageIcon(image));
                        System.out.println(result.getText());
                    }
                } catch (Exception e) {
                    // QR code not detected in the image
                }
            }
        });

        frame.setVisible(true);
    }
}

