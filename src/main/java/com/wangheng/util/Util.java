package com.wangheng.util;

import java.awt.image.BufferedImage;

import javax.swing.JLabel;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class Util {
public static BufferedImage matToBufferedImage(Mat matrix) {
		int cols=matrix.cols();
		int rows=matrix.rows();
		int elemSize=(int)matrix.elemSize();
		byte[] data=new byte[cols*rows*elemSize];
		int type;
		matrix.get(0 ,0,data);
		switch(matrix.channels()){
		case 1:
			type=BufferedImage.TYPE_BYTE_GRAY;
			break;
		case 3:
			type=BufferedImage.TYPE_3BYTE_BGR;
			byte b;
			for(int i=0;i<data.length;i=i+3){
				b=data[i];
				data[i]=data[i+2];
				data[i+2]=b;
			}
			break;
			default:
				return null;
				
		}
		BufferedImage image2=new BufferedImage(cols,rows,type);
		image2.getRaster().setDataElements(0, 0,cols,rows,data);
		return image2;
	}
	public static Mat resizeImage(Mat image, JLabel label) {
		Mat resizeImg = new Mat();
		int w = image.width();
		int h = image.height();
		int l_w = label.getWidth();
		int l_h = label.getHeight();
		if (w>h) {
			int new_h = w/l_w * h;
			Size size = new Size(w, new_h);
			size = new Size(900, 400);
			Imgproc.resize(image, resizeImg, size);
			return resizeImg;
		}else {
			int new_w = h/l_h * w;
			Size size = new Size(new_w, h);
			size = new Size(900, 400);
			Imgproc.resize(image,  resizeImg, size);
			return resizeImg;
		}
	}
	public static Mat resizeImage(Mat image, int w, int h) {
		Mat resizeImg = new Mat();
			Imgproc.resize(image, resizeImg, new Size(w, h));
			return resizeImg;
	}

}
