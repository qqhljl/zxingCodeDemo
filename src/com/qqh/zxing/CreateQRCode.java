package com.qqh.zxing;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 二维码生成类
 * @ClassName: CreateQRCode 
 * @Description:  
 * @author qinqh
 * @date 2017年5月25日 上午11:49:26 
 *
 */
public class CreateQRCode {
public static void main(String[] args) {
	int width = 300;
	int height = 300;
	String format = "png";
	String content  = "覃庆华";
	
	//定义二维码的参数
	HashMap hints = new HashMap<>();
	hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
	hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
	hints.put(EncodeHintType.MARGIN, 2);
	
	//生成二维码
	try {
		System.out.println("开始生成二维码");
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height);
		Path file = new File("E:/huaao/慕课网/java生成二维码/code/img.png").toPath();
		MatrixToImageWriter.writeToPath(bitMatrix, format, file);
		System.out.println("生成二维码成功，保存在："+ file+",此二维码的内容是"+content);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
