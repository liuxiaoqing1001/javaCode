package ConferenceManagementSystem;

import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import java.awt.*;

@SuppressWarnings("serial")
public class TQueryMeeting extends JFrame {

	JPanel contentPane;
	JTextField tNTextField;
	JTable table;
	JScrollPane scrollPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TQueryMeeting tQueryFrame = new TQueryMeeting();
					tQueryFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TQueryMeeting() {	
		
		setTitle("查询会议");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(475, 175, 523, 510);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
		
		JMenu mnNewMenu = new JMenu("注销");
		mnNewMenu.setFont(new Font("宋体", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem = new JMenuItem("切换账号");
		menuItem.setFont(new Font("宋体", Font.PLAIN, 14));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TQueryMeeting.this.dispose();
				LoginFrame lf=new LoginFrame();
				lf.setVisible(true);
			}
		});
		mnNewMenu.add(menuItem);
		
				
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 129, 488, 344);
		contentPane.add(scrollPane);
				
		Object a[][]=new Object[DBTool.i][6];
		for(int line=0;line<DBTool.i;line++) {
			for(int column=0;column<6;column++) {
				a[line][column]=DBTool.data[line][column];
			}
		}
		
		JButton confirmButton = new JButton("确认");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 15));
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String tName=tNTextField.getText();
				if(!tName.isEmpty()) {
					
					table = new JTable(a,new String[] {"会议编号", "会议主题", "会议主持", "会议地点", "会议时间", "会议成员"});
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
					    PreparedStatement pstat = (PreparedStatement) conn.prepareStatement("SELECT * from meetingsql where MHoster like'%"+tName+"%' or MMember like '%"+tName+"%'");
						ResultSet result=(ResultSet) pstat.executeQuery();
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
					    result.beforeFirst();
					    if(!result.next()) {
					    	JOptionPane.showMessageDialog(null, "无有关您的会议", null, JOptionPane.NO_OPTION);
					    }
					    }catch(SQLException se) {
							se.printStackTrace();
						}
					
					}else {
						JOptionPane.showMessageDialog(null, "请输入名字", null, JOptionPane.NO_OPTION);
					}
			
				}
			});
		confirmButton.setBounds(373, 89, 88, 31);
		contentPane.add(confirmButton);
		
		tNTextField = new JTextField();
		tNTextField.setBounds(73, 44, 344, 31);
		contentPane.add(tNTextField);
		tNTextField.setColumns(10);
		
		JLabel NLabel = new JLabel("请输入您的名字：");
		NLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		NLabel.setBounds(10, 10, 129, 31);
		contentPane.add(NLabel);JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(0, 0, 2, 2);
		contentPane.add(scrollPane1);
	}
}
