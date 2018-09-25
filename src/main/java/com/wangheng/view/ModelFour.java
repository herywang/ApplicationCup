package com.wangheng.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import org.opencv.core.Mat;

import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

/**
*@author  wangheng
*@E-Mail  673602165@qq.com
*@version 创建时间：2018年9月13日 下午3:30:51
*@类说明：
*/
public class ModelFour extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Mat originalImg;

	public ModelFour(Mat image) {
		setResizable(false);
		this.originalImg = image.clone();
		setTitle("关键文字信息提取");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModelFour.class.getResource("/com/sun/javafx/scene/control/skin/caspian/pattern-transparent.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1011, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setVisible(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(248, 248, 255));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u53EF\u89C6\u5316\u5904\u7406\u8FC7\u7A0B", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 250, 250)));
		panel.setBackground(new Color(105, 105, 105));
		panel.setBounds(10, 10, 983, 573);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "1.\u539F\u59CB\u56FE\u50CF", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 26, 441, 245);
		panel.add(panel_1);
		
		JLabel label_2 = new JLabel("");
		panel_1.add(label_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "2.\u964D\u566A\u5904\u7406", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(532, 26, 441, 245);
		panel.add(panel_2);
		
		JLabel label_3 = new JLabel("");
		panel_2.add(label_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "4.\u5B9A\u4F4D\u63D0\u53D6", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(10, 318, 441, 245);
		panel.add(panel_3);
		
		JLabel label_4 = new JLabel("");
		panel_3.add(label_4);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "3.\u8FDE\u901A\u57DF\u786E\u5B9A", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(532, 318, 441, 245);
		panel.add(panel_4);
		
		JLabel label_5 = new JLabel("");
		panel_4.add(label_5);
		
		JLabel label = new JLabel("企业注册号：");
		label.setForeground(new Color(245, 255, 250));
		label.setBounds(10, 605, 78, 22);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(89, 603, 304, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("企业名称：");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setForeground(new Color(245, 255, 250));
		label_1.setBounds(3, 643, 78, 22);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(89, 645, 304, 23);
		contentPane.add(textField_1);
		
		JButton btnexcel = new JButton("保存至excel");
		btnexcel.setBounds(862, 603, 123, 23);
		contentPane.add(btnexcel);
		
		JButton button = new JButton("退出程序");
		button.setBounds(862, 643, 123, 23);
		contentPane.add(button);
	}
}
