package com.seven.meetingmanagement.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.Hashtable;

public class QRcode {
    public static void createQrCode(String contents, int width, int height, HttpServletResponse response) {
        Hashtable hints = new Hashtable();
        try {
            OutputStream outputStream  = response.getOutputStream();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            //hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            //hints.put(EncodeHintType.MARGIN, 2);
            BitMatrix bitMatrix = new QRCodeWriter().encode(
                    contents, BarcodeFormat.QR_CODE, width, height, hints);
            // 1、读取文件转换为字节数组
            MatrixToImageWriter.writeToStream(bitMatrix,"png",outputStream);
            //转换成png格式的IO流
            //ImageIO.write(image, "jpg", out);
            outputStream.flush();
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
