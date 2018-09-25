package com.wangheng.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
*@author  wangheng
*@E-Mail  673602165@qq.com
*@version 创建时间：2018年9月12日 下午1:38:14
*@类说明：
*/
public class DialogText extends JDialog {

	private final JPanel contentPanel = new JPanel();
	/**
	 * Create the dialog.
	 */
	public DialogText(String message) {
		setTitle("警告");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DialogText.class.getResource("/javax/swing/plaf/metal/icons/Warn.gif")));
		setBounds(100, 100, 440, 208);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel label = new JLabel(message);
			label.setIcon(new ImageIcon(DialogText.class.getResource("/javax/swing/plaf/metal/icons/ocean/warning.png")));
			label.setForeground(Color.RED);
			label.setFont(new Font("幼圆", Font.BOLD, 21));
			contentPanel.add(label);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		setVisible(true);
	}

}
