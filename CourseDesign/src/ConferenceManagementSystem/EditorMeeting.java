package ConferenceManagementSystem;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class EditorMeeting extends JFrame {

	private JPanel contentPane;
	private JTextField idTextField;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorMeeting frame = new EditorMeeting();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EditorMeeting() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(475, 175, 572, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("返回");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditorMeeting.this.dispose();
				AQueryMeeting aqm = new AQueryMeeting();
				aqm.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 10, 71, 28);
		contentPane.add(btnNewButton);
		
		JLabel idLabel = new JLabel("请输入想要编辑的编号：");
		idLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		idLabel.setBounds(28, 59, 166, 28);
		contentPane.add(idLabel);
		
		idTextField = new JTextField();
		idTextField.setBounds(226, 53, 220, 42);
		contentPane.add(idTextField);
		idTextField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 151, 536, 308);
		contentPane.add(scrollPane);

		Object a[][]=new Object[DBTool.i][6];
		for(int line=0;line<DBTool.i;line++) {
			for(int column=0;column<6;column++) {
				a[line][column]=DBTool.data[line][column];
			}
		}
		
		JTable table = new JTable(a,new String[] {"会议编号", "会议主题", "会议主持", "会议地点", "会议时间", "会议成员"});
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
					"会议编号", "会议主题", "会议主持", "会议地点", "会议时间", "会议成员"
			}
		));

		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
		
		try {
			String url="jdbc:mysql://localhost:3306/liu7?user=Liu7&password=Liu7";
		    Connection conn=(Connection) DriverManager.getConnection(url);    
		    PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("SELECT * from meetingsql");
			ResultSet result=pstmt.executeQuery();	
		    while(result.next()) {
		    	
		    	String mId=result.getString("MId");
				String mName=result.getString("MName");
				String mHoster=result.getString("MHoster");
				String mAdress=result.getString("MAdress");
				String mDate=result.getString("MDate");
				String mMember=result.getString("MMember");
		    	
				String[] str= {mId,mName,mHoster,mAdress,mDate,mMember};
				((DefaultTableModel)table.getModel()).addRow(str);
				scrollPane.setViewportView(table);
				}
			
			}catch(SQLException se) {
				se.printStackTrace();
			}
		
		
		JButton editorButton = new JButton("编辑会议");
		editorButton.setFont(new Font("宋体", Font.PLAIN, 15));
		editorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=idTextField.getText();
				if(!id.isEmpty()) {
					if(DBTool.checkMeeting(id)) {						
						Editor ed=new Editor(id);
						EditorMeeting.this.dispose();
						ed.setVisible(true);
						EditorMeeting.this.dispose();						
					}else {
						JOptionPane.showMessageDialog(null, "无此编号", null, JOptionPane.NO_OPTION);
					}
					}else {
						JOptionPane.showMessageDialog(null, "请输入编号", null, JOptionPane.NO_OPTION);
					}
				}
			});
		editorButton.setBounds(395, 105, 109, 36);
		contentPane.add(editorButton);
	}
}
