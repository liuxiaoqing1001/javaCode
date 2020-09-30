package Map;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import java.awt.ScrollPane;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import java.awt.SystemColor;

@SuppressWarnings({ "unused", "serial" })
public class Frame extends JFrame {

	private JPanel contentPane;
	static int selectstart=-1;
	static int selectend=-1;
	static int selectThrough=-1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Frame() {
		setBackground(SystemColor.activeCaption);
		
		Map map=new Map();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu backMenu = new JMenu("返回");
		backMenu.setFont(new Font("宋体", Font.PLAIN, 15));
		menuBar.add(backMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("返回上一级");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.this.dispose();
				MainFrame r=new MainFrame();
				r.setVisible(true);
			}
		});
		mntmNewMenuItem.setFont(new Font("宋体", Font.PLAIN, 14));
		backMenu.add(mntmNewMenuItem);
		
		setTitle("校园导航");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,150, 937, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon picture = new ImageIcon("E:\\map.png");
		JLabel pictureLabel=new JLabel(picture);
		pictureLabel.setBounds(510, 10,396,505);
		contentPane.add(pictureLabel);
		
		JComboBox start = new JComboBox();
		for(int i=0;i<map.placeName.length;i++){
			start.addItem(map.placeName[i]);
		}
		start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evevt){
				selectstart=start.getSelectedIndex();
			}
		});
		start.setBounds(76, 76, 104, 23);
		contentPane.add(start);
		
		JComboBox end = new JComboBox();
		for(int i=0;i<map.placeName.length;i++){
			end.addItem(map.placeName[i]);
		}
		end.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evevt){
				selectend=end.getSelectedIndex();
			}
		});
		end.setBounds(321, 76, 104, 23);
		contentPane.add(end);
		
		JComboBox comboBox = new JComboBox();
		for(int i=0;i<map.placeName.length;i++){
			comboBox.addItem(map.placeName[i]);
		}
		comboBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evevt){
				selectThrough=comboBox.getSelectedIndex();
			}
		});
		comboBox.setBounds(119, 132, 104, 23);
		contentPane.add(comboBox);
		
		JLabel startLabel = new JLabel("起点：");
		startLabel.setFont(new Font("楷体", Font.PLAIN, 20));
		startLabel.setBounds(10, 67, 60, 36);
		contentPane.add(startLabel);
		
		JLabel endLabel = new JLabel("终点：");
		endLabel.setFont(new Font("楷体", Font.PLAIN, 20));
		endLabel.setBounds(251, 70, 60, 31);
		contentPane.add(endLabel);
		
		JLabel titleLabel = new JLabel("“天津职业技术师范大学”校园导航");
		titleLabel.setFont(new Font("楷体", Font.PLAIN, 25));
		titleLabel.setBounds(44, 10, 405, 36);
		contentPane.add(titleLabel);
		
		JLabel shortestPathLabel = new JLabel("最短路径：");
		shortestPathLabel.setFont(new Font("楷体", Font.PLAIN, 18));
		shortestPathLabel.setBounds(10, 224, 99, 25);
		contentPane.add(shortestPathLabel);
		
		JLabel inLabel = new JLabel("经过点:");
		inLabel.setFont(new Font("楷体", Font.PLAIN, 19));
		inLabel.setBounds(34, 123, 75, 36);
		contentPane.add(inLabel);

		JLabel errorLabel = new JLabel();
		errorLabel.setFont(new Font("楷体", Font.PLAIN, 17));
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(44, 169, 356, 31);
		contentPane.add(errorLabel);	
	
		JScrollPane SortScrollPane = new JScrollPane();
		SortScrollPane.setBounds(20, 259, 462, 190);
		contentPane.add(SortScrollPane);
		JTextArea SortTextArea = new JTextArea();
		SortTextArea.setFont(new Font("楷体", Font.PLAIN, 15));
		SortScrollPane.setViewportView(SortTextArea);
		
		JButton btnNewButton = new JButton("退出");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.this.dispose();
			}
		});
		btnNewButton.setBounds(399, 459, 60, 38);
		contentPane.add(btnNewButton);
		
		JButton queryButton = new JButton("查询");
		queryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						if(selectstart==-1||selectend==-1||selectstart==0||selectend==0){
							errorLabel.setText("ERROR:请选择起点和终点!!!");
							SortTextArea.setText("");
						}else if(selectstart==selectend){
							errorLabel.setText("ERROR:选择的起点和终点相同,请重新选择!!!");
							SortTextArea.setText("");
						}else{
							errorLabel.setText("");
							SortTextArea.setText(map.Floyd(selectstart, selectend,selectThrough));
						}
					if(selectstart==-1||selectend==-1||selectstart==0||selectend==0){
						errorLabel.setText("ERROR:请选择起点和终点!!!");
						SortTextArea.setText("");
					}else if(selectstart==selectend){
						errorLabel.setText("ERROR:选择的起点和终点相同,请重新选择!!!");
						SortTextArea.setText("");
					}else{
						errorLabel.setText("");
						SortTextArea.setText(map.Floyd(selectstart, selectend,selectThrough));
					}
				}
		});
		queryButton.setFont(new Font("楷体", Font.PLAIN, 20));
		queryButton.setBounds(355, 121, 75, 41);
		contentPane.add(queryButton);
		
		JLabel lblNewLabel_1 = new JLabel("必选");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(190, 80, 41, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("必选");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(435, 80, 41, 15);
		contentPane.add(lblNewLabel_2);

	}
}