package com.wangheng.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

import com.wangheng.algorithm.ImageProcess;
import com.wangheng.util.Util;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
*@author  wangheng
*@E-Mail  673602165@qq.com
*@version 创建时间：2018年9月12日 下午1:45:45
*@类说明：
*/
import org.opencv.highgui.ImageWindow;
import org.opencv.imgcodecs.Imgcodecs;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Font;
import javax.swing.SwingConstants;

public class ModelOne extends JFrame {
	private JPanel contentPane;
	private Mat image = null;
	JLabel label;
	private JTextField textField;
	private JSlider slider;
	JSlider slider_1;
	JLabel w;
	JLabel h;
	private Mat result = null;
	
	public ModelOne(Mat img) {
		this.image = img;
		setResizable(false); 
		setTitle("图像去水印");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModelOne.class.getResource("/com/sun/java/swing/plaf/motif/icons/DesktopIcon.gif")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1103, 663);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 1091, 32);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("自动处理结果");
		panel.add(lblNewLabel, BorderLayout.NORTH);
		lblNewLabel.setEnabled(false);
		lblNewLabel.setIcon(new ImageIcon(ModelOne.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlayDisabled.png")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 47, 1091, 435);
		contentPane.add(panel_1);
		label = new JLabel();
		
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_1.add(label);
		
		JButton button = new JButton("保存图像");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(result != null) {
					saveImageFile(result);
					new Sucess("保存成功！");
				}else {
					new DialogText("图像保存异常");
				}
			}
		});
		button.setBounds(952, 601, 138, 23);
		contentPane.add(button);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\u56FE\u50CF\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(5, 487, 856, 137);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		slider = new JSlider();
		slider.setMaximum(1700);
		slider.setMinimum(0);
		slider.setForeground(new Color(255, 0, 0));
		slider.setBackground(new Color(250, 240, 230));
		slider.setEnabled(false);
		slider.setBounds(138, 23, 557, 26);
		panel_2.add(slider);
		slider_1 = new JSlider();
		slider_1.setMaximum(1700);
		slider_1.setMinimum(0);
		slider_1.setForeground(new Color(255, 0, 0));
		slider_1.setBackground(new Color(250, 240, 230));
		slider_1.setEnabled(false);
		slider_1.setBounds(139, 61, 557, 26);
		panel_2.add(slider_1);
		JLabel label_1 = new JLabel("图像高度：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 15));
		label_1.setBounds(11, 23, 77, 22);
		panel_2.add(label_1);
		JLabel label_2 = new JLabel("图像宽度：");
		label_2.setFont(new Font("宋体", Font.PLAIN, 15));
		label_2.setBounds(11, 65, 77, 22);
		panel_2.add(label_2);
		JLabel label_3 = new JLabel("通道数：");
		label_3.setFont(new Font("宋体", Font.PLAIN, 15));
		label_3.setBounds(26, 100, 77, 22);
		panel_2.add(label_3);
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(139, 98, 66, 21);
		panel_2.add(textField);
		textField.setColumns(10);
		w = new JLabel();
		w.setFont(new Font("宋体", Font.PLAIN, 15));
		w.setBounds(700, 23, 50, 26);
		panel_2.add(w);
		h = new JLabel();
		h.setFont(new Font("宋体", Font.PLAIN, 15));
		h.setBounds(700, 60, 50, 26);
		panel_2.add(h);
		JButton button_1 = new JButton("文字连通域确定");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				new ModelThree();
			}
		});
		button_1.setBounds(952, 575, 137, 23);
		contentPane.add(button_1);
		if(!this.image.empty()) {
			showImageInLabel(slider, slider_1, textField, label, image, w, h);
		}
		setVisible(true);
	}
	private void showImageInLabel(JSlider slider, JSlider slider_1, JTextField textField, 
			JLabel label, Mat matrix, 
			JLabel w, JLabel h) {
		Mat result = ImageProcess.getModelOneImage(matrix);
		this.result = result;
		BufferedImage image = Util.matToBufferedImage(result);
		label.setIcon(new ImageIcon(image));
		slider.setValue(result.width());
		slider_1.setValue(result.height());
		textField.setText(result.channels()+"");
		w.setText(slider.getValue()+"");
		h.setText(slider_1.getValue()+"");
		
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
