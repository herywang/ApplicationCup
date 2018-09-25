package com.wangheng.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import org.opencv.highgui.*;
import org.opencv.core.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.wangheng.algorithm.ImageProcess;
import com.wangheng.util.Util;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.opencv.imgcodecs.Imgcodecs;
import javax.swing.border.EtchedBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
public class MainView extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private int IF_HAVE_IMAGE = 0;
	ImageProcess process;
	public MainView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/vk-light.png")));
		setResizable(false);
		setTitle("基于像素水平映射算法文关键字提取系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1007, 810);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("使用说明");
		menuBar.add(menu);
		
		JMenuItem menuItem_3 = new JMenuItem("功能简介");
		menu.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("操作流程");
		menu.add(menuItem_4);
		
		JMenu menu_1 = new JMenu("帮助");
		menuBar.add(menu_1);
		
		JMenuItem menuItem = new JMenuItem("关于我们");
		menu_1.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("版本说明");
		menu_1.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("版权说明");
		menu_1.add(menuItem_2);
		
		JMenu menu_2 = new JMenu("高级功能");
		menuBar.add(menu_2);
		
		JMenuItem mntmexcel = new JMenuItem("批量处理并导出Excel");
		menu_2.add(mntmexcel);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "\u6587\u5B57\u63D0\u53D6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setToolTipText("");
		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 601, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(48, Short.MAX_VALUE))
		);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		final JLabel label_1 = new JLabel();
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label_1, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.SOUTH);
		final JPanel panel_4 = new JPanel();
		panel_4.setForeground(new Color(240, 248, 255));
		panel_4.setBackground(new Color(102, 0, 102));
		panel_4.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new EtchedBorder(EtchedBorder.LOWERED, null, null)));
		panel_3.add(panel_4);
		final JLabel label_2 = new JLabel("图像降噪处理模块");
		label_2.setIcon(new ImageIcon(MainView.class.getResource("/javax/swing/plaf/metal/icons/sortDown.png")));
		label_2.setToolTipText("图像去噪模块处理");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setFont(new Font("幼圆", Font.BOLD, 20));
		label_2.setBackground(Color.LIGHT_GRAY);
		panel_4.add(label_2);
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_4.setBackground(new Color(135, 206, 235));
				label_2.setForeground(new Color(0, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_4.setBackground(new Color(102, 0, 102));
				label_2.setForeground(new Color(255, 255, 255));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(process == null || process.getInputImage().empty()) {
					new DialogText("请打开一幅图片!");
				}else {
					new ModelOne(process.getResizeImage());
				}
			}
		});
		JLabel label_4 = new JLabel("       ");
		panel_3.add(label_4);
		final JPanel panel_5 = new JPanel();
		panel_5.setForeground(new Color(240, 248, 255));
		panel_5.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new EtchedBorder(EtchedBorder.LOWERED, null, null)));
		panel_5.setBackground(new Color(102, 0, 102));
		panel_3.add(panel_5);
		final JLabel label_3 = new JLabel("图像阈值分割模块");
		label_3.setForeground(Color.WHITE);
		label_3.setIcon(new ImageIcon(MainView.class.getResource("/javax/swing/plaf/metal/icons/sortDown.png")));
		label_3.setFont(new Font("幼圆", Font.BOLD, 20));
		label_3.setBackground(Color.LIGHT_GRAY);
		panel_5.add(label_3);
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_5.setBackground(new Color(135, 206, 235));
				label_3.setForeground(new Color(0, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_5.setBackground(new Color(102, 0, 102));
				label_3.setForeground(new Color(255, 255, 255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(process == null || process.getInputImage().empty()) {
					new DialogText("请打开一幅图片!");
				}else {
					new ModelTwo(process.getInputImage());
				}
			}
		});
		JLabel label_5 = new JLabel("       ");
		panel_3.add(label_5);
		final JPanel panel_6 = new JPanel();
		panel_6.setForeground(new Color(240, 248, 255));
		panel_6.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new EtchedBorder(EtchedBorder.LOWERED, null, null)));
		panel_6.setBackground(new Color(102, 0, 102));
		panel_3.add(panel_6);
		final JLabel label_6 = new JLabel("图像连通域确定模块");
		label_6.setForeground(Color.WHITE);
		label_6.setIcon(new ImageIcon(MainView.class.getResource("/javax/swing/plaf/metal/icons/sortDown.png")));
		label_6.setFont(new Font("幼圆", Font.BOLD, 20));
		label_6.setBackground(Color.LIGHT_GRAY);
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_6.setBackground(new Color(135, 206, 235));
				label_6.setForeground(new Color(0, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_6.setBackground(new Color(102, 0, 102));
				label_6.setForeground(new Color(255, 255, 255));
			}
			@Override
			public void mouseClicked(MouseEvent event) {
				if(process == null || process.getInputImage().empty()) {
					new DialogText("请打开一幅图片!");
				}else {
					new ModelThreee(process.getInputImage());
				}
			}
		});
		panel_6.add(label_6);
		JLabel label_8 = new JLabel("       ");
		panel_3.add(label_8);
		final JPanel panel_7 = new JPanel();
		panel_7.setForeground(new Color(240, 248, 255));
		panel_7.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new EtchedBorder(EtchedBorder.LOWERED, null, null)));
		panel_7.setBackground(new Color(102, 0, 102));
		panel_3.add(panel_7);
		final JLabel label_7 = new JLabel("像素映射提取文字");
		label_7.setIcon(new ImageIcon(MainView.class.getResource("/javax/swing/plaf/metal/icons/sortDown.png")));
		label_7.setToolTipText("图像去噪模块处理");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("幼圆", Font.BOLD, 20));
		label_7.setBackground(Color.LIGHT_GRAY);
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_7.setBackground(new Color(135, 206, 235));
				label_7.setForeground(new Color(0, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_7.setBackground(new Color(102, 0, 102));
				label_7.setForeground(new Color(255, 255, 255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(process == null || process.getInputImage().empty()) {
					new DialogText("请打开一幅图片!");
				}else {
					new ModelFour(process.getInputImage());
				}
			}
		});
		panel_7.add(label_7);
		panel_1.setLayout(null);
		textField = new JTextField();
		textField.setBounds(10, 10, 732, 25);
		textField.setEditable(false);
		textField.setBackground(Color.LIGHT_GRAY);
		panel_1.add(textField);
		textField.setColumns(50);
		JButton button = new JButton("打开文件");
		button.setForeground(Color.BLACK);
		button.setBackground(new Color(255, 228, 196));
		button.setBounds(794, 11, 180, 23);
		button.setIcon(new ImageIcon(MainView.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.jpg,*.png,*.gif,*.jpeg,*.bmp",
                        "jpg","png","gif", "jpeg", "bmp");//过滤可以选择的文件
                chooser.setFileFilter(filter);
                chooser.showDialog(new JLabel(), "选择");
                File file = chooser.getSelectedFile();
                if(file != null && file.length()!=0) {
                	textField.setText(file.getAbsoluteFile().toString());
                	process = new ImageProcess(file.getAbsoluteFile().toString());
                	if (process.getInputImage() != null) {
                		process.resizeImage(process.getInputImage(), label_1);
                		Mat inputImage = process.getResizeImage();
                		BufferedImage image = Util.matToBufferedImage(inputImage);
                		label_1.setIcon(new ImageIcon(image));
                		IF_HAVE_IMAGE = 1;
					}
                }
                else {
					new DialogText("您未打开任何文件！");
				}
                
			}
		});
		panel_1.add(button);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel label = new JLabel("基于像素水平映射算法关键文字提取系统");
		label.setFont(new Font("微软雅黑", Font.BOLD, 27));
		panel.add(label);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
}
