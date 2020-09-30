package ConferenceManagementSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.mysql.jdbc.Connection;



@SuppressWarnings("serial")
public class Editor extends JFrame {

	public JPanel contentPane;
	public JTextField mIdTextField;
	
	static Connection conn;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Editor frame = new Editor(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Editor(String id) {
		setTitle("编辑会议");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 150, 493, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
			
		JLabel mNameLblel = new JLabel("会议名称：");
		mNameLblel.setFont(new Font("宋体", Font.PLAIN, 15));
		mNameLblel.setBounds(63, 65, 83, 27);
		contentPane.add(mNameLblel);
		
		JLabel mAdressLabel = new JLabel("会议地点：");
		mAdressLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		mAdressLabel.setBounds(63, 102, 83, 27);
		contentPane.add(mAdressLabel);
		
		JLabel mHosterLabel = new JLabel("会议主持：");
		mHosterLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		mHosterLabel.setBounds(63, 139, 83, 27);
		contentPane.add(mHosterLabel);
		
		JLabel mDateLabel = new JLabel("会议日期：");
		mDateLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		mDateLabel.setBounds(63, 176, 83, 27);
		contentPane.add(mDateLabel);
		
		JLabel mMemberLabel = new JLabel("会议成员：");
		mMemberLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		mMemberLabel.setBounds(63, 213, 83, 27);
		contentPane.add(mMemberLabel);
		
		JTextField mNameTextField = new JTextField();
		mNameTextField.setBounds(149, 65, 249, 27);
		contentPane.add(mNameTextField);
		mNameTextField.setColumns(10);
		
		JTextField mHosterTextField = new JTextField();
		mHosterTextField.setBounds(149, 102, 249, 27);
		contentPane.add(mHosterTextField);
		mHosterTextField.setColumns(10);
		
		JTextField mAdressTextField = new JTextField();
		mAdressTextField.setBounds(149, 139, 249, 27);
		contentPane.add(mAdressTextField);
		mAdressTextField.setColumns(10);
		
		JTextField mDateTextField = new JTextField();
		mDateTextField.setBounds(149, 176,249, 27);
		contentPane.add(mDateTextField);
		mDateTextField.setColumns(10);
		
		JTextArea mMemberTextArea = new JTextArea();
		mMemberTextArea.setBounds(149, 215, 249, 99);
		contentPane.add(mMemberTextArea);
		
		JLabel mIdLabel = new JLabel("会议编号：");
		mIdLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		mIdLabel.setBounds(63, 28, 83, 27);
		contentPane.add(mIdLabel);
		
		
		JLabel label = new JLabel();
		label.setBounds(149, 28, 126, 27);
		contentPane.add(label);
		label.setText(id);

		ResultSet result;
		if((result=DBTool.QueryMeeting(label.getText()))!=null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			}catch(ClassNotFoundException ce) {
				ce.printStackTrace();
			}
			
			try {
				while(result.next()) {
					mNameTextField.setText(result.getString("MName"));	
					mHosterTextField.setText(result.getString("MHoster"));
					mAdressTextField.setText(result.getString("MAdress"));
					mDateTextField.setText(result.getString("MDate"));
					mMemberTextArea.setText(result.getString("MMember"));
				}
			    	 
			}catch(SQLException se) {
				se.printStackTrace();
			}
			
		}
		
	
		JButton btnNewButton = new JButton("修改");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					String mId=label.getText();
					String mName=mNameTextField.getText();
					String mHoster=mHosterTextField.getText();
					String mAdress=mAdressTextField.getText();
					String mDate=mDateTextField.getText();
					String mMember=mMemberTextArea.getText();

					if(!mId.isEmpty()&&!mName.isEmpty()&&!mHoster.isEmpty()&&!mAdress.isEmpty()&&!mDate.isEmpty()&&!mMember.isEmpty()) {
						DBTool.changeMeeting(mId, mName, mHoster, mAdress, mDate, mMember);
						JOptionPane.showMessageDialog(null, "已修改", null, JOptionPane.NO_OPTION);
						Editor.this.dispose();
						AQueryMeeting af = new AQueryMeeting();
						af.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null, "请将会议内容填写完整", "错误提示", JOptionPane.NO_OPTION);
						}
					}
				});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton.setBounds(325, 341, 102, 38);
		contentPane.add(btnNewButton);
		
		JButton backButton = new JButton("返回");
		backButton.setFont(new Font("宋体", Font.PLAIN, 16));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Editor.this.dispose();
				EditorMeeting af = new EditorMeeting();
				af.setVisible(true);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 2, 2);
		contentPane.add(scrollPane);
		backButton.setBounds(80, 343, 102, 34);
		contentPane.add(backButton);
		
		

	}
}
