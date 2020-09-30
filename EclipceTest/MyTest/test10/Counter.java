package test10;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Font;

public class Counter {

	private JFrame frmCounter;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Counter window = new Counter();
					window.frmCounter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Counter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCounter = new JFrame();
		frmCounter.setTitle("Counter");
		frmCounter.setBounds(100, 100, 232, 377);
		frmCounter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCounter.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(4, 96, 207, 240);
		frmCounter.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton = new JButton("0");
		btnNewButton.setBounds(5, 198, 96, 37);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("1");
		btnNewButton_1.setBounds(5, 57, 44, 37);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("2");
		btnNewButton_2.setBounds(57, 58, 44, 37);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("3");
		btnNewButton_3.setBounds(108, 57, 44, 37);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("4");
		btnNewButton_4.setBounds(5, 105, 44, 37);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("5");
		btnNewButton_5.setBounds(57, 105, 44, 37);
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("6");
		btnNewButton_6.setBounds(108, 104, 44, 37);
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("7");
		btnNewButton_7.setBounds(5, 151, 44, 37);
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("8");
		btnNewButton_8.setBounds(57, 151, 44, 37);
		panel_1.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("9");
		btnNewButton_9.setBounds(108, 151, 44, 37);
		panel_1.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("D");
		btnNewButton_10.setBounds(108, 10, 44, 37);
		panel_1.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("*");
		btnNewButton_11.setBounds(157, 57, 44, 37);
		panel_1.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("C");
		btnNewButton_12.setBounds(5, 10, 44, 37);
		panel_1.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("+/-");
		btnNewButton_13.setBounds(53, 10, 51, 37);
		panel_1.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("+");
		btnNewButton_14.setBounds(157, 105, 44, 37);
		panel_1.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("-");
		btnNewButton_15.setBounds(157, 151, 44, 37);
		panel_1.add(btnNewButton_15);
		
		JButton btnNewButton_16 = new JButton("\\");
		btnNewButton_16.setBounds(157, 10, 44, 37);
		panel_1.add(btnNewButton_16);
		
		JButton btnNewButton_17 = new JButton(".");
		btnNewButton_17.setBounds(108, 198, 44, 37);
		panel_1.add(btnNewButton_17);
		
		JButton btnNewButton_18 = new JButton("=");
		btnNewButton_18.setBounds(157, 198, 44, 37);
		panel_1.add(btnNewButton_18);
		
		textField = new JTextField();
		textField.setFont(new Font("ËÎÌו", Font.PLAIN, 14));
		textField.setBounds(4, 10, 207, 76);
		frmCounter.getContentPane().add(textField,BorderLayout.NORTH);
		textField.setColumns(10);

	}
}
