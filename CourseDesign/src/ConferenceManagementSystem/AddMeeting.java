package ConferenceManagementSystem;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

@SuppressWarnings("serial")
public class AddMeeting extends JFrame {

	private JPanel contentPane;
	private JTextField mNameTextField;
	private JTextField mAdressTextField;
	private JTextField mHosterTextField;
	private JTextField mDateextField;
	private JTextField mIdTextField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMeeting addMFrame = new AddMeeting();
					addMFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddMeeting() {
		setTitle("添加会议");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 150, 493, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel mNameLabel = new JLabel("会议名称：");
		mNameLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		mNameLabel.setBounds(63, 93, 83, 27);
		contentPane.add(mNameLabel);
		
		JLabel mAdressLabel = new JLabel("会议地点：");
		mAdressLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		mAdressLabel.setBounds(63, 167, 83, 27);
		contentPane.add(mAdressLabel);
		
		JLabel mHosterLabel = new JLabel("会议主持：");
		mHosterLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		mHosterLabel.setBounds(63, 130, 83, 27);
		contentPane.add(mHosterLabel);
		
		JLabel mDateLabel = new JLabel("会议日期：");
		mDateLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		mDateLabel.setBounds(63, 204, 83, 27);
		contentPane.add(mDateLabel);
		
		JLabel mMemberLabel = new JLabel("会议成员：");
		mMemberLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		mMemberLabel.setBounds(63, 241, 83, 27);
		contentPane.add(mMemberLabel);

		JButton resetButton = new JButton("重置");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddMeeting.this.dispose();
				AddMeeting addMeetingFrame = new AddMeeting();
				addMeetingFrame.setVisible(true);
			}
		});
		resetButton.setFont(new Font("宋体", Font.PLAIN, 16));
		resetButton.setBounds(305, 357,102, 38);
		contentPane.add(resetButton);
		
		mNameTextField = new JTextField();
		mNameTextField.setBounds(149, 93, 249, 27);
		contentPane.add(mNameTextField);
		mNameTextField.setColumns(10);
		
		mAdressTextField = new JTextField();
		mAdressTextField.setBounds(149, 167, 249, 27);
		contentPane.add(mAdressTextField);
		mAdressTextField.setColumns(10);
		
		mHosterTextField = new JTextField();
		mHosterTextField.setBounds(149, 130, 249, 27);
		contentPane.add(mHosterTextField);
		mHosterTextField.setColumns(10);
		
		mDateextField = new JTextField();
		mDateextField.setBounds(149, 204,249, 27);
		contentPane.add(mDateextField);
		mDateextField.setColumns(10);
		
		JTextArea mMemberTextArea = new JTextArea();
		mMemberTextArea.setBounds(149, 243, 249, 84);
		contentPane.add(mMemberTextArea);
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String mId=mIdTextField.getText();
					String mName=mNameTextField.getText();
					String mHoster=mHosterTextField.getText();
					String mAdress=mAdressTextField.getText();
					String mDate=mDateextField.getText();
					String mMember=mMemberTextArea.getText();
					
					if(!mId.isEmpty()&&!mName.isEmpty()&&!mHoster.isEmpty()&&!mAdress.isEmpty()&&!mDate.isEmpty()&&!mMember.isEmpty()) {
						if(DBTool.checkMeeting(mId)) {
							JOptionPane.showMessageDialog(null, "此会议编号存在", "错误提示", JOptionPane.NO_OPTION);
						}else {
							DBTool.insertMeeting(mId,mName, mHoster, mAdress, mDate, mMember);
							JOptionPane.showMessageDialog(null, "已添加", null, JOptionPane.NO_OPTION);
							AddMeeting.this.dispose();
							AQueryMeeting qm=new AQueryMeeting();
							qm.setVisible(true);	
						}
					}else {
						JOptionPane.showMessageDialog(null, "请将会议内容填写完整", "错误提示", JOptionPane.NO_OPTION);
					}
				}
			});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton.setBounds(92, 357, 102, 38);
		contentPane.add(btnNewButton);
		
		JButton backButton = new JButton("返回");
		backButton.setFont(new Font("宋体", Font.PLAIN, 14));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddMeeting.this.dispose();
				AQueryMeeting af = new AQueryMeeting();
				af.setVisible(true);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 2, 2);
		contentPane.add(scrollPane);
		backButton.setBounds(28, 10, 77, 27);
		contentPane.add(backButton);
		
		JLabel idLabel = new JLabel("会议编号：");
		idLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		idLabel.setBounds(63, 59, 83, 27);
		contentPane.add(idLabel);
		
		mIdTextField = new JTextField();
		mIdTextField.setBounds(149, 56, 249, 27);
		contentPane.add(mIdTextField);
		mIdTextField.setColumns(10);

	}
}
