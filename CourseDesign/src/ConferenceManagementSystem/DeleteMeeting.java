package ConferenceManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

@SuppressWarnings("serial")
public class DeleteMeeting extends JFrame {

	private JPanel contentPane;
	private JTextField idTextField;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteMeeting delectFrame = new DeleteMeeting();
					delectFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DeleteMeeting() {
		setTitle("ɾ������");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(475, 175, 572, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton back = new JButton("����");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteMeeting.this.dispose();
				AQueryMeeting af = new AQueryMeeting();
				af.setVisible(true);
			}
		});
		back.setBounds(10, 10, 71, 28);
		contentPane.add(back);
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 151, 536, 308);
		contentPane.add(scrollPane);
	
		Object a[][]=new Object[DBTool.i][6];
		for(int line=0;line<DBTool.i;line++) {
			for(int column=0;column<6;column++) {
				a[line][column]=DBTool.data[line][column];
			}
		}
		
		table = new JTable(a,new String[] {"������", "��������", "��������", "����ص�", "����ʱ��", "�����Ա"});
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
					"������", "��������", "��������", "����ص�", "����ʱ��", "�����Ա"
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
		    PreparedStatement pstat = (PreparedStatement) conn.prepareStatement("SELECT * from meetingsql");
			ResultSet result=pstat.executeQuery();	
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

		JButton delectButton = new JButton("ɾ������");
		delectButton.setFont(new Font("����", Font.PLAIN, 15));
		delectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=idTextField.getText();
				if(!id.isEmpty()) {
					if(DBTool.checkMeeting(id)) {
						DBTool.deleteMeeting(id);
						JOptionPane.showMessageDialog(null, "��ɾ��", null, JOptionPane.NO_OPTION);
						DeleteMeeting.this.dispose();
						DeleteMeeting af=new DeleteMeeting();
						af.setVisible(true);	
					}else {
						JOptionPane.showMessageDialog(null, "�˻����Ų�����", null, JOptionPane.NO_OPTION);
					}
					}else {
						JOptionPane.showMessageDialog(null, "��������", null, JOptionPane.NO_OPTION);
						}
				}
			});
		delectButton.setBounds(395, 105, 109, 36);
		contentPane.add(delectButton);
		
		JLabel delectLabel = new JLabel("��������Ҫɾ���ı�ţ�");
		delectLabel.setFont(new Font("����", Font.PLAIN, 14));
		delectLabel.setBounds(28, 59, 166, 28);
		contentPane.add(delectLabel);
		
		idTextField = new JTextField();
		idTextField.setBounds(226, 53, 220, 42);
		contentPane.add(idTextField);
		idTextField.setColumns(10);
	}
}
