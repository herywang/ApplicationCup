package com.wangheng.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import com.wangheng.algorithm.AlgorithmOne;
import com.wangheng.algorithm.ImageProcess;
import com.wangheng.util.Util;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionEvent;

/**
*@author  wangheng
*@E-Mail  673602165@qq.com
*@version 创建时间：2018年9月12日 下午6:40:22
*@类说明：
*/
public class ModelThreee extends JFrame {

	private JPanel contentPane;
	private Mat inputimage = new Mat();
	private Mat resizedImg = null;
	private Mat outputImg = null;
	public ModelThreee(Mat image) {
		this.inputimage = image.clone();
		setResizable(false);
		setTitle("图像文字信息确定连通域");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModelThreee.class.getResource("/com/sun/javafx/scene/web/skin/Strikethrough_16x16_JFX.png")));
		setBackground(new Color(255, 240, 245));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1140, 583);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 240, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 1114, 369);
		contentPane.add(panel);
		panel.setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u539F\u59CB\u56FE\u50CF", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 10, 530, 351);
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label_3 = new JLabel();
		showInputImage(inputimage, label_3);
		panel_1.add(label_3);
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\u5904\u7406\u7ED3\u679C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(574, 10, 530, 351);
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		final JLabel label_4 = new JLabel();
		panel_2.add(label_4);
		setVisible(true);
		setContentPane(contentPane);
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 389, 1114, 152);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "\u8FDE\u901A\u57DF\u8C03\u6574", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 10, 1094, 91);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		JLabel lblX = new JLabel("X:");
		lblX.setHorizontalAlignment(SwingConstants.RIGHT);
		lblX.setBounds(10, 27, 54, 15);
		panel_4.add(lblX);
		JLabel lblY = new JLabel("Y:");
		lblY.setHorizontalAlignment(SwingConstants.RIGHT);
		lblY.setBounds(10, 52, 54, 15);
		panel_4.add(lblY);
		final JSlider slider = new JSlider();
		slider.setMinimum(1);
		slider.setValue(10);
		slider.setBounds(96, 16, 865, 26);
		panel_4.add(slider);
		final JSlider slider_1 = new JSlider();
		slider_1.setMinimum(1);
		slider_1.setValue(10);
		slider_1.setBounds(96, 55, 865, 26);
		panel_4.add(slider_1);
		final JLabel label_1 = new JLabel();
		label_1.setFont(new Font("宋体", Font.BOLD, 14));
		label_1.setBounds(1005, 16, 44, 26);
		panel_4.add(label_1);
		final JLabel label_2 = new JLabel();
		label_2.setFont(new Font("宋体", Font.BOLD, 14));
		label_2.setBounds(1005, 52, 44, 26);
		panel_4.add(label_2);
		JLabel label = new JLabel("阈值类型：");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(10, 111, 76, 15);
		panel_3.add(label);
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"THRESH_BINARY", "THRESH_BINARY_INV"}));
		comboBox.setBounds(112, 111, 206, 21);
		panel_3.add(comboBox);
		JButton button = new JButton("保存结果图像");
		button.setIcon(new ImageIcon(ModelThreee.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		button.setBounds(962, 107, 142, 23);
		panel_3.add(button);
		
		showDstImg(inputimage, label_4, slider.getValue(), slider_1.getValue(), comboBox, label_1, label_2);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				showDstImg(inputimage, label_4, slider.getValue(), slider_1.getValue(), comboBox, label_1, label_2);
			}
		});
		slider_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				showDstImg(inputimage, label_4, slider.getValue(), slider_1.getValue(), comboBox, label_1, label_2);
			}
		});
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showDstImg(inputimage, label_4, slider.getValue(), slider_1.getValue(), comboBox, label_1, label_2);
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveImageFile(outputImg);
			}
		});
	}
	private void showInputImage(Mat inputImg, JLabel label) {
		Mat dist = Util.resizeImage(inputImg, 520, 280);
		this.resizedImg = dist;
		BufferedImage bufferedImage = Util.matToBufferedImage(resizedImg);
		label.setIcon(new ImageIcon(bufferedImage));
	}
	private void showDstImg(Mat inputImg, JLabel label, int size_x, int size_y, JComboBox<Object> thresh_type, JLabel vl1, JLabel vl2) {
		int type = thresh_type.getSelectedIndex();
		if(thresh_type.getSelectedIndex() == 0) {
			type = Imgproc.THRESH_BINARY;
		}else{
			type = Imgproc.THRESH_BINARY;
		}
		AlgorithmOne aOne = new AlgorithmOne(inputImg);
		Mat dst1 = aOne.preprocess(inputImg, size_x, size_y, type);
		Mat dist = Util.resizeImage(dst1, 520, 280);
		this.outputImg = dist;
		BufferedImage bImage = Util.matToBufferedImage(dist);
		label.setIcon(new ImageIcon(bImage));
		vl1.setText(size_x+"");
		vl2.setText(size_y+"");
	}
	private void saveImageFile(Mat image) {
		FileNameExtensionFilter filter=new FileNameExtensionFilter("*.png","png");
		JFileChooser fc=new JFileChooser();
		fc.setFileFilter(filter);
		fc.setMultiSelectionEnabled(false);
		int result=fc.showSaveDialog(null);
		if (result==JFileChooser.APPROVE_OPTION) {
			File file=fc.getSelectedFile();
			if (!file.getPath().endsWith(".png")) {
				file=new File(file.getPath()+".png");
			}
			String filepath = file.getPath();
			if(!image.empty()) {
				Imgcodecs.imwrite(filepath, image);
			}
			else {
				new DialogText("文件保存失败!");
			}
		}
	}
}
