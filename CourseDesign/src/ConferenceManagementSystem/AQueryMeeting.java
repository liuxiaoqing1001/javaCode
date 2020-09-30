package ConferenceManagementSystem;

import javax.swing.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

@SuppressWarnings("serial")
public class AQueryMeeting extends JFrame {
	
	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AQueryMeeting queryMeetingFrame = new AQueryMeeting();
					queryMeetingFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AQueryMeeting() {
		setTitle("��ѯ����");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(475, 175, 704, 456);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu editorMenu = new JMenu("�༭����");
		editorMenu.setFont(new Font("����", Font.PLAIN, 15));
		menuBar.add(editorMenu);
		
		JMenuItem addMenuItem = new JMenuItem("��ӻ���");
		addMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AQueryMeeting.this.dispose();
				AddMeeting am=new AddMeeting();
				am.setVisible(true);
			}
		});
		addMenuItem.setFont(new Font("����", Font.PLAIN, 14));
		editorMenu.add(addMenuItem);
		
		JMenuItem editorMenuItem = new JMenuItem("�޸Ļ���");
		editorMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AQueryMeeting.this.dispose();
				EditorMeeting em=new EditorMeeting();
				em.setVisible(true);
			}
		});
		editorMenuItem.setFont(new Font("����", Font.PLAIN, 14));
		editorMenu.add(editorMenuItem);
		
		JMenuItem delectMenuItem = new JMenuItem("ɾ������");
		delectMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AQueryMeeting.this.dispose();
				DeleteMeeting dm=new DeleteMeeting();
				dm.setVisible(true);
			}
		});
		delectMenuItem.setFont(new Font("����", Font.PLAIN, 14));
		editorMenu.add(delectMenuItem);
		
		JMenu mnNewMenu = new JMenu("ע��");
		mnNewMenu.setFont(new Font("����", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem = new JMenuItem("�л��˺�");
		menuItem.setFont(new Font("����", Font.PLAIN, 14));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AQueryMeeting.this.dispose();
				LoginFrame lf=new LoginFrame();
				lf.setVisible(true);
			}
		});
		mnNewMenu.add(menuItem);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 668, 363);
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
	}
}
