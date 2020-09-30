package ConferenceManagementSystem;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField tUserNameTextField;
	private JTextField tUserIdTextField;
	private JPasswordField tUserPasswordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register registerFrame = new Register();
					registerFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Register() {
		setTitle("教师注册");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(575, 275, 387, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel registerName = new JLabel("用户名：");
		registerName.setFont(new Font("宋体", Font.PLAIN, 15));
		registerName.setBounds(55, 71, 70, 35);
		contentPane.add(registerName);
		
		JLabel registerPassword = new JLabel("密码：");
		registerPassword.setFont(new Font("宋体", Font.PLAIN, 15));
		registerPassword.setBounds(55, 116, 70, 37);
		contentPane.add(registerPassword);
		
		tUserNameTextField = new JTextField();
		tUserNameTextField.setBounds(135, 75, 159, 28);
		contentPane.add(tUserNameTextField);
		tUserNameTextField.setColumns(10);
		
		JButton loginButton = new JButton("登录");
		loginButton.setFont(new Font("宋体", Font.PLAIN, 16));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register.this.dispose();
				LoginFrame lf=new LoginFrame();
				lf.setVisible(true);
			}
		});
		loginButton.setBounds(55, 197, 97, 35);
		contentPane.add(loginButton);
		
		JButton registerButton = new JButton("注册");
		registerButton.setFont(new Font("宋体", Font.PLAIN, 16));
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				String tId=tUserIdTextField.getText();
				String tName=tUserNameTextField.getText();
				char[] p=tUserPasswordField.getPassword();
				String tPassword=new String(p);
				
				if(!tId.isEmpty()&&!tName.isEmpty()&&!tPassword.isEmpty()) {
					if(DBTool.checkTeacherI(tId)) {
						JOptionPane.showMessageDialog(null, "此用户编号已存在", null, JOptionPane.NO_OPTION);
					}else {
						DBTool.interTeacher(tId, tName, tPassword);
						Register.this.dispose();
						LoginFrame lf=new LoginFrame();
						lf.setVisible(true);
						JOptionPane.showMessageDialog(null, "已注册", null, JOptionPane.NO_OPTION);
					}		
				}else {
					JOptionPane.showMessageDialog(null, "请将ID，用户名和密码填写完整", "错误提示", JOptionPane.NO_OPTION);
				}
				
				
			}
		});
		registerButton.setBounds(229, 197, 97, 35);
		contentPane.add(registerButton);
		
		JLabel promtLabel = new JLabel("提示：若已有教师用户名，请点击登录");
		promtLabel.setFont(new Font("宋体", Font.PLAIN, 13));
		promtLabel.setForeground(Color.RED);
		promtLabel.setBounds(39, 163, 227, 15);
		contentPane.add(promtLabel);
		
		JLabel IdLabel = new JLabel("ID:");
		IdLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		IdLabel.setBounds(55, 26, 70, 35);
		contentPane.add(IdLabel);
		
		tUserIdTextField = new JTextField();
		tUserIdTextField.setBounds(135, 30, 159, 28);
		contentPane.add(tUserIdTextField);
		tUserIdTextField.setColumns(10);
		
		tUserPasswordField = new JPasswordField();
		tUserPasswordField.setBounds(135, 120, 159, 29);
		contentPane.add(tUserPasswordField);
		
	}
}
