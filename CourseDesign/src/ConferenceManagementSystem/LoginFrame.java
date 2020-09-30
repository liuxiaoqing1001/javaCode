package ConferenceManagementSystem;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame {
	
	private JPanel contentPane;
	private JTextField nameTextField;
	private JPasswordField passwordTextField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame loginF = new LoginFrame();
					loginF.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginFrame() {
		setTitle("��¼");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(575, 275, 374, 272);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu backMenu = new JMenu("����");
		backMenu.setFont(new Font("����", Font.PLAIN, 15));
		menuBar.add(backMenu);
		
		JMenuItem registTeacherMenuItem = new JMenuItem("ע���ʦ");
		registTeacherMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame.this.dispose();
				Register r=new Register();
				r.setVisible(true);
			}
		});
		registTeacherMenuItem.setFont(new Font("����", Font.PLAIN, 14));
		backMenu.add(registTeacherMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel loginName = new JLabel("�û�����");
		loginName.setFont(new Font("����", Font.PLAIN, 15));
		loginName.setBounds(55, 22, 70, 35);
		contentPane.add(loginName);
		
		JLabel loginPassword = new JLabel("���룺");
		loginPassword.setFont(new Font("����", Font.PLAIN, 15));
		loginPassword.setBounds(55, 69, 70, 37);
		contentPane.add(loginPassword);
		
		JLabel loginId = new JLabel("��ݣ�");
		loginId.setFont(new Font("����", Font.PLAIN, 15));
		loginId.setBounds(55, 116, 58, 33);
		contentPane.add(loginId);
		
		JRadioButton adminButton = new JRadioButton("����Ա");
		buttonGroup.add(adminButton);
		adminButton.setFont(new Font("����", Font.PLAIN, 14));
		adminButton.setBounds(119, 121, 70, 23);
		contentPane.add(adminButton);
		
		JRadioButton teacherButton = new JRadioButton("��ʦ");
		buttonGroup.add(teacherButton);
		teacherButton.setFont(new Font("����", Font.PLAIN, 14));
		teacherButton.setBounds(224, 121, 70, 23);
		contentPane.add(teacherButton);
		
		JButton loginButton = new JButton("��¼");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(nameTextField!=null||passwordTextField!=null) {
						if(adminButton.isSelected()) {
							String aName=nameTextField.getText();
							char[] p=passwordTextField.getPassword();
							String aPwd=new String(p);
							if(DBTool.queryAdmin(aName, aPwd)) {
								LoginFrame.this.dispose();
								AQueryMeeting af=new AQueryMeeting();
								af.setVisible(true);
								JOptionPane.showMessageDialog(null, "��½�ɹ�", null, JOptionPane.NO_OPTION);
								}else {
									JOptionPane.showMessageDialog(null, "�û������������", "������ʾ", JOptionPane.NO_OPTION);
									}
							}else if(teacherButton.isSelected()) {
								String tName=nameTextField.getText();
								char[] tp=passwordTextField.getPassword();
								String tPwd=new String(tp);
								if(DBTool.queryTeacher(tName, tPwd)) {
									LoginFrame.this.dispose();
									TQueryMeeting af=new TQueryMeeting();
									af.setVisible(true);
									JOptionPane.showMessageDialog(null, "��½�ɹ�", null, JOptionPane.NO_OPTION);
									}else {
										JOptionPane.showMessageDialog(null, "�û������������", "������ʾ", JOptionPane.NO_OPTION);
										}
							}else {
								JOptionPane.showMessageDialog(null, "δȷ�����","������ʾ", JOptionPane.NO_OPTION);
								}
					}else {
						JOptionPane.showMessageDialog(null, "�������û���������", "������ʾ", JOptionPane.NO_OPTION);
						}
				}catch(Exception ex) {
					ex.printStackTrace();
					}
			}
		});
		loginButton.setFont(new Font("����", Font.PLAIN, 16));
		loginButton.setBounds(41, 172, 97, 23);
		contentPane.add(loginButton);
		
		JButton resetButton = new JButton("����");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame.this.dispose();
				LoginFrame frame = new LoginFrame();
				frame.setVisible(true);
			}
		});
		resetButton.setFont(new Font("����", Font.PLAIN, 16));
		resetButton.setBounds(224, 172, 97, 23);
		contentPane.add(resetButton);
	
		nameTextField = new JTextField();
		nameTextField.setBounds(125, 25, 180, 29);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(125, 73, 180, 29);
		contentPane.add(passwordTextField);
	}
}							
						
