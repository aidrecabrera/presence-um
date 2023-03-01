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
import java.util.List;
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

        List<Webcam> webcams = Webcam.getWebcams();
        if (webcams.isEmpty()) {
            System.out.println("No webcams found");
            return;
        }

        System.out.println("Available webcams:");
        for (int i = 0; i < webcams.size(); i++) {
            System.out.println((i + 1) + ". " + webcams.get(i).getName());
        }

        int selectedWebcamIndex = 0; // Change this to select a different webcam
        if (selectedWebcamIndex < 0 || selectedWebcamIndex >= webcams.size()) {
            System.out.println("Invalid webcam index");
            return;
        }

        Webcam selectedWebcam = webcams.get(selectedWebcamIndex);
        selectedWebcam.setViewSize(new Dimension(IMAGE_WIDTH, IMAGE_HEIGHT));
        selectedWebcam.open();

        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            while (true) {
                BufferedImage image = selectedWebcam.getImage();
                try {
                    Result result = new MultiFormatReader().decode(new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image))));
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


