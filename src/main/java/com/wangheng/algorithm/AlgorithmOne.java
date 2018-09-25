package com.wangheng.algorithm;
/**
*@author  wangheng
*@E-Mail  673602165@qq.com
*@version 创建时间：2018年9月13日 下午2:24:53
*@类说明：
*/

import java.util.List;
import java.util.ArrayList;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Scalar;

public class AlgorithmOne {
	private Mat input;
	
	public AlgorithmOne(Mat input) {
		this.input = input;
	}
	
	//连通域确定图像
	public Mat preprocess(Mat image, int x, int y, int type) {
		if(image.channels() != 1) {
			Imgproc.cvtColor(image, image, Imgproc.COLOR_BGR2GRAY);
		}
		if(type == 0) {
			type = Imgproc.THRESH_BINARY;
		}else {
			type = Imgproc.THRESH_BINARY_INV;
		}
		Mat sobel = new Mat(), binary = new Mat();
		Mat element2 = new Mat(), dilation = new Mat();
		Imgproc.Sobel(image, sobel, CvType.CV_8U, 1, 0);
		Imgproc.threshold(sobel, binary, 0, 255, Imgproc.THRESH_OTSU + type);
		element2 = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(x, y));
		Imgproc.dilate(binary, dilation, element2);
		return dilation;
	}
	//定位
	public Mat getROIImg(Mat originalImg, Mat preImg) {
		Mat drawImage = originalImg.clone();
		List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
		Mat hierarchy = new Mat();
		Imgproc.findContours(preImg, contours, hierarchy, Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_SIMPLE);
		Mat image32s = new Mat();
		Mat contourImg = new Mat(preImg.size(), preImg.type());
		for (int i = 0;i<contours.size();i++) {
			Imgproc.drawContours(contourImg, contours, i, new Scalar(255, 0, 0), -1);
		}
		return contourImg;
	}

}
