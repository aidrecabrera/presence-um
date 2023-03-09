package presence.scanning;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import presence.attendance.AttendanceFunction;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class QRScanner extends JFrame implements Runnable {

    private static final long serialVersionUID = 1L;
    private final MultiFormatReader reader = new MultiFormatReader();
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private final JPanel panel = new JPanel();
    private final JLabel label = new JLabel();
    private final Webcam webcam;
    private final Dimension size = WebcamResolution.VGA.getSize();

    private String StudentID;

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    public QRScanner() {
        super("UM Presence | Initiate Attendance");

        this.panel.setLayout(new BorderLayout());
        this.panel.add(this.label, BorderLayout.CENTER);

        this.setContentPane(this.panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 960);
        this.setLocationRelativeTo(panel);
        this.setVisible(true);

        List<Webcam> webcams = Webcam.getWebcams();
        String[] options = webcams.stream().map(Webcam::getName).toArray(String[]::new);
        String selectedOption = (String) JOptionPane.showInputDialog(null, "Select a webcam", "Webcam selection", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        this.webcam = webcams.get(Arrays.asList(options).indexOf(selectedOption));

        this.webcam.setViewSize(size);
        this.webcam.open();

        this.reader.setHints(null);
        this.executor.scheduleAtFixedRate(this, 0, 33, TimeUnit.MILLISECONDS);
    }

    @Override
    public void run() {
        BufferedImage image = this.webcam.getImage();

        if (image == null) {
            return;
        }
        Mat mat = new Mat();
        Imgproc.cvtColor(MatUtil.bufferedImageToMat(image), mat, Imgproc.COLOR_BGR2GRAY);
        try {
            BufferedImage bufferedImage = MatUtil.matToBufferedImage(mat);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));
            Result result = this.reader.decode(bitmap);
            if (result != null) {
                if (result.getText() == getStudentID()) {
                    System.out.println("Scanned Already");
                } else {
                    setStudentID(result.getText());
                    JOptionPane.showConfirmDialog(null, "STUDENT ID: " + getStudentID(),
                            "alert", JOptionPane.OK_CANCEL_OPTION);
                }
                System.out.println("STUDENT ID: " + getStudentID());
                System.out.println(result.getText());
                this.label.setText(result.getText());

                int qrCodeX = (int) result.getResultPoints()[0].getX();
                int qrCodeY = (int) result.getResultPoints()[0].getY();
                int qrCodeSize = (int) (result.getResultPoints()[2].getX() - result.getResultPoints()[0].getX());
                int width = (int) (result.getResultPoints()[2].getX() - result.getResultPoints()[0].getX());
                int height = (int) (result.getResultPoints()[2].getY() - result.getResultPoints()[0].getY());
                Graphics2D g2d = bufferedImage.createGraphics();
                g2d.setColor(Color.GREEN);
                g2d.setStroke(new BasicStroke(3));
                g2d.drawRect(qrCodeX, qrCodeY, width, height);
                g2d.dispose();

                g2d.setFont(new Font("Arial", Font.BOLD, 20));
                g2d.setColor(Color.BLACK);
                g2d.drawString(result.getText(), 10, 30);
                g2d.dispose();
                g2d.setColor(Color.GREEN);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawRect(qrCodeX, qrCodeY, qrCodeSize, qrCodeSize);
                g2d.dispose();

                this.label.setText("<html><div style='text-align: center;'>" + result.getText() + "</div></html>");


            }
        } catch (Exception e) {

        }
        BufferedImage outputImage = MatUtil.matToBufferedImage(mat);
        this.label.setIcon(new ImageIcon(outputImage));
    }


    public class MatUtil {

        public static Mat bufferedImageToMat(BufferedImage bi) {
            Mat mat = new Mat(bi.getHeight(), bi.getWidth(), CvType.CV_8UC3);
            byte[] data = ((DataBufferByte) bi.getRaster().getDataBuffer()).getData();
            mat.put(0, 0, data);
            return mat;
        }

        public static BufferedImage matToBufferedImage(Mat mat) {
            int type = BufferedImage.TYPE_BYTE_GRAY;
            if (mat.channels() > 1) {
                type = BufferedImage.TYPE_3BYTE_BGR;
            }
            BufferedImage bi = new BufferedImage(mat.width(), mat.height(), type);
            byte[] data = ((DataBufferByte) bi.getRaster().getDataBuffer()).getData();
            mat.get(0, 0, data);
            return bi;
        }
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new QRScanner());
    }
}
