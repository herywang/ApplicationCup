package com.wangheng.algorithm;

import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

import com.wangheng.util.Util;
import com.wangheng.view.DialogText;

/**
*@author  wangheng
*@E-Mail  673602165@qq.com
*@version 创建时间：2018年9月12日 下午12:01:09
*@类说明：
*/
public class ImageProcess {
	private Mat inputImage = null;
	private static Mat resizeImage = null;
	public ImageProcess(String filename) {
		// TODO Auto-generated constructor stub
		Mat image = Imgcodecs.imread(filename);
		if(image.channels()==3) {
			int a[] = {255,255,255};
			if(!image.empty()) {
				for(int i = 0;i<image.height();i++) {
					for (int j = 0;j<image.width();j++) {
						if(image.get(i, j)[0] == 0 && image.get(i, j)[1] == 0 && image.get(i, j)[2] == 0) {
							image.put(i, j, 255.0, 255.0, 255.0);
						}
					}
				}
				this.inputImage = image;
			}
			else {
				this.inputImage = null;
			}
		}else {
			this.inputImage = image;
		}
		
	}
	public Mat getInputImage() {
		return inputImage;
	}
	public void setInputImage(Mat inputImage) {
		this.inputImage = inputImage;
	}
	public void resizeImage(Mat image, JLabel label) {
		Mat resizeImg = Util.resizeImage(image,  label);
		this.resizeImage = resizeImg;
	}
	public Mat getResizeImage() {
		return resizeImage;
	}
	public void setResizeImage(Mat resizeImage) {
		this.resizeImage = resizeImage;
	}
	//降噪处理
	public static Mat getModelOneImage(Mat image_1) {
		if(image_1 != null) {
			Mat sobel = new Mat();
			Mat binary = new Mat();
			Mat element2 = new Mat();
			Mat dilation = new Mat();
			Imgproc.Sobel(image_1, sobel, CvType.CV_8U, 1, 0);
			Imgproc.cvtColor(sobel, sobel, Imgproc.COLOR_BGR2GRAY);
			Imgproc.threshold(sobel, binary, 0, 255, Imgproc.THRESH_OTSU);
			return binary;
//			return sobel;
		}else {
			new DialogText("未知错误");
			return null;
		}
	}
	
	
}
