package com.supermarket.project.supermarketproject;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.File;
import java.io.IOException;
public class GenreateQR {
    public static void generateQRCode(String text, String name, String ID)  {
        try {
            String charset = "UTF-8";
            String path = name + ID + ".png";
            BitMatrix matrix = new MultiFormatWriter().encode(
                    new String(text.getBytes(charset), charset),
                    BarcodeFormat.QR_CODE, 200, 200);

            MatrixToImageWriter.writeToFile(
                    matrix,
                    path.substring(path.lastIndexOf('.') + 1),
                    new File(path));
        } catch (IOException | WriterException e) {
            throw new RuntimeException(e);
        }
    }
}
