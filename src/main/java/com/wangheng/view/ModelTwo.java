package com.wangheng.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Label;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.border.TitledBorder;
import javax.swing.text.Document;
import javax.swing.text.NumberFormatter;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import com.wangheng.algorithm.ImageProcess;
import com.wangheng.util.Util;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSlider;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.event.ChangeEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class ModelTwo extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private Mat resizedImage;
	public ModelTwo(final Mat image) {
		setTitle("图像阈值分割提取");
		resizedImage = Util.resizeImage(image, 510, 280);
		BufferedImage bufferedImage = Util.matToBufferedImage(resizedImage);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModelTwo.class.getResource("/com/sun/javafx/scene/web/skin/IncreaseIndent_16x16_JFX.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1105, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u539F\u59CB\u56FE\u50CF", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 530, 324);
		contentPane.add(panel);
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon(bufferedImage));
		panel.add(label);
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u5904\u7406\u7ED3\u679C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(550, 10, 530, 324);
		contentPane.add(panel_1);
		final JLabel lblNewLabel = new JLabel();
		panel_1.add(lblNewLabel);
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 344, 1070, 147);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		JLabel lblNewLabel_1 = new JLabel("选择分类器：");
		lblNewLabel_1.setBounds(30, 10, 79, 15);
		panel_2.add(lblNewLabel_1);
		final JRadioButton radioButton = new JRadioButton("高斯分类器");
		
		radioButton.setBounds(125, 6, 107, 23);
		panel_2.add(radioButton);
		final JRadioButton radioButton_1 = new JRadioButton("均值分类器");
		
		radioButton_1.setBounds(299, 6, 133, 23);
		ButtonGroup group = new ButtonGroup();
		group.add(radioButton);
		group.add(radioButton_1);
		radioButton.setSelected(true);
		radioButton_1.setSelected(true);
		panel_2.add(radioButton_1);
		JLabel lblNewLabel_2 = new JLabel("选择阈值类型：");
		lblNewLabel_2.setBounds(18, 38, 91, 15);
		panel_2.add(lblNewLabel_2);
		final JComboBox<Object> comboBox = new JComboBox<Object>();
		
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"THRESH_BINARY", "THRESH_BINARY_INV"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(125, 35, 195, 21);
		panel_2.add(comboBox);
		JLabel label_1 = new JLabel("设置邻域大小：");
		label_1.setBounds(18, 77, 91, 15);
		panel_2.add(label_1);
		final JSlider slider = new JSlider();
		slider.setMinimum(2);
		
		slider.setBackground(new Color(128, 128, 128));
		slider.setForeground(Color.BLUE);
		slider.setValue(70);
		slider.setMaximum(900);
		slider.setBounds(125, 66, 406, 26);
		panel_2.add(slider);
		JLabel label_2 = new JLabel("设置偏置值：");
		label_2.setBounds(30, 102, 79, 15);
		panel_2.add(label_2);
		textField = new JTextField();
		textField.setText("0");
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(125, 102, 66, 21);
		panel_2.add(textField);
		textField.setColumns(10);
		JButton button = new JButton("保存结果图像");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveImageFile(image);
			}
		});
		button.setIcon(new ImageIcon(ModelTwo.class.getResource("/javax/swing/plaf/metal/icons/ocean/minimize-pressed.gif")));
		button.setBounds(927, 102, 133, 23);
		panel_2.add(button);
		final JLabel label_3 = new JLabel();
		label_3.setText(slider.getValue()+"");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(477, 41, 54, 15);
		panel_2.add(label_3);
		showImage(image, radioButton, radioButton_1, comboBox, slider.getValue(),
				textField.getText(), lblNewLabel, label_3);
		
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showImage(image, radioButton, radioButton_1, comboBox, slider.getValue(),
						textField.getText(), lblNewLabel, label_3);
			}
		});
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showImage(image, radioButton, radioButton_1, comboBox, slider.getValue(),
						textField.getText(), lblNewLabel, label_3);
			}
		});
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showImage(image, radioButton, radioButton_1, comboBox, slider.getValue(),
						textField.getText(), lblNewLabel, label_3);
			}
		});
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				showImage(image, radioButton, radioButton_1, comboBox, slider.getValue(),
						textField.getText(), lblNewLabel, label_3);
			}
		});
		Document dtDocument = textField.getDocument();
		dtDocument.addDocumentListener(new DocumentListener() {
			
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				showImage(image, radioButton, radioButton_1, comboBox, slider.getValue(),
						textField.getText(), lblNewLabel, label_3);
			}
		});
		
	}
	private void showImage(final Mat image, JRadioButton jb1, JRadioButton jb2,
			JComboBox<Object> cb, int size, String C, JLabel imageShowLabel, 
			JLabel slideValueLabel) {
		Mat dst = new Mat();
		int adaptiveMethod;
		if(jb2.isSelected()) {
			adaptiveMethod = Imgproc.ADAPTIVE_THRESH_MEAN_C;
		}else {
			adaptiveMethod = Imgproc.ADAPTIVE_THRESH_GAUSSIAN_C;
		}
		int thresholdType;
		if(cb.getSelectedIndex() == 0) {
			thresholdType = Imgproc.THRESH_BINARY;
		}else {
			thresholdType = Imgproc.THRESH_BINARY_INV;
		}
		int blockSize = size;
		if(blockSize%2 == 0) {
			blockSize = blockSize + 1;
			slideValueLabel.setText(blockSize+"");
		}
		int c = 0;
		try {
			c = Integer.parseInt(C);
		} catch (Exception e) {
			// TODO: handle exception
			new DialogText("请输入正确数字！");
		}
		Mat image1 = new Mat();
		Imgproc.cvtColor(image, image1, Imgproc.COLOR_BGR2GRAY);
		Imgproc.adaptiveThreshold(image1, dst, 255, adaptiveMethod, thresholdType, blockSize, c);
		Mat dst1 = Util.resizeImage(dst, 510, 280);
		BufferedImage image2 = Util.matToBufferedImage(dst1);
		imageShowLabel.setIcon(new ImageIcon(image2));
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
