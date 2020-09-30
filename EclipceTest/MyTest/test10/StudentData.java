package test10;
import javax.swing.*;
import java.awt.*;


public class StudentData {

	private JFrame frmStudentdatas;
	private JTextField textField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentData window = new StudentData();
					window.frmStudentdatas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public StudentData() {
		initialize();
	}

	
	private void initialize() {
		frmStudentdatas = new JFrame();
		frmStudentdatas.setTitle("StudentDatas");
		frmStudentdatas.setForeground(Color.CYAN);
		frmStudentdatas.setBounds(100, 100, 559, 549);
		frmStudentdatas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmStudentdatas.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 16));
		textField.setBounds(97, 54, 127, 32);
		frmStudentdatas.getContentPane().add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(399, 54, 127, 32);
		frmStudentdatas.getContentPane().add(comboBox);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Reading");
		chckbxNewCheckBox.setFont(new Font("宋体", Font.PLAIN, 16));
		chckbxNewCheckBox.setBounds(381, 117, 127, 51);
		frmStudentdatas.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Singing");
		chckbxNewCheckBox_1.setFont(new Font("宋体", Font.PLAIN, 16));
		chckbxNewCheckBox_1.setBounds(381, 172, 127, 51);
		frmStudentdatas.getContentPane().add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Dancing");
		chckbxNewCheckBox_2.setFont(new Font("宋体", Font.PLAIN, 16));
		chckbxNewCheckBox_2.setBounds(381, 225, 127, 51);
		frmStudentdatas.getContentPane().add(chckbxNewCheckBox_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(97, 117, 127, 106);
		frmStudentdatas.getContentPane().add(textArea);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setFont(new Font("宋体", Font.PLAIN, 16));
		rdbtnNewRadioButton.setBounds(97, 275, 127, 37);
		frmStudentdatas.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.setFont(new Font("宋体", Font.PLAIN, 16));
		rdbtnNewRadioButton_1.setBounds(97, 314, 127, 37);
		frmStudentdatas.getContentPane().add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("Variable");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 17));
		btnNewButton.setBounds(97, 403, 127, 38);
		frmStudentdatas.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 17));
		btnNewButton_1.setBounds(310, 403, 127, 38);
		frmStudentdatas.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel.setBounds(20, 55, 67, 29);
		frmStudentdatas.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Address");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(20, 113, 67, 29);
		frmStudentdatas.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Qualification");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(265, 54, 133, 29);
		frmStudentdatas.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Hobby");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(265, 128, 67, 29);
		frmStudentdatas.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sex");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(20, 278, 67, 29);
		frmStudentdatas.getContentPane().add(lblNewLabel_4);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 544, 29);
		frmStudentdatas.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u6587\u4EF6");
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u6253\u5F00");
		mntmNewMenuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u4FDD\u5B58");
		mntmNewMenuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u9000\u51FA");
		mntmNewMenuItem_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("\u5173\u4E8E");
		mnNewMenu_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u4F5C\u8005");
		mntmNewMenuItem_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		mnNewMenu_1.add(mntmNewMenuItem_3);
	}
}
