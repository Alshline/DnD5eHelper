package QRCodeGenerator;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Date;

public class QRCodeGenerator {

    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png";

    //Png generator
    public static void generateQRCodeImage(String text)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 50, 50);
        Date date = new Date();
        String pngName = date + ".png";
        String pathToPNG = QR_CODE_IMAGE_PATH + pngName;

        Path path = FileSystems.getDefault().getPath(pathToPNG);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

    //ByteArray code
    public static byte[] getQRCodeImage(String text) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 50, 50);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        byte[] pngData = pngOutputStream.toByteArray();
        return pngData;
    }

}
