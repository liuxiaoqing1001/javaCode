package Map;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MinT extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MinT frame = new MinT();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MinT() {		
		Map map=new Map();
		
		setTitle("校园导航");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,150, 823, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon picture = new ImageIcon("E:\\map.png");
		JLabel pictureLabel=new JLabel(picture);
		pictureLabel.setBounds(414, 0,396,505);
		contentPane.add(pictureLabel);
		
		JScrollPane minTreeScrollPane = new JScrollPane();
		minTreeScrollPane.setBounds(20, 99, 376, 282);
		contentPane.add(minTreeScrollPane);
		JTextArea minTreeTextArea = new JTextArea();
		minTreeTextArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		minTreeScrollPane.setViewportView(minTreeTextArea);
		
		JLabel inLabel = new JLabel("瞅一瞅有惊喜-->");
		inLabel.setFont(new Font("楷体", Font.PLAIN, 19));
		inLabel.setBounds(20, 10, 150, 44);
		contentPane.add(inLabel);
		
		JRadioButton mainDoor = new JRadioButton("瞅瞅");
		buttonGroup.add(mainDoor);
		mainDoor.setFont(new Font("楷体", Font.PLAIN, 17));
		mainDoor.setBounds(176, 22, 67, 23);
		contentPane.add(mainDoor);
		
		JRadioButton southDoor = new JRadioButton("就不点");
		buttonGroup.add(southDoor);
		southDoor.setFont(new Font("楷体", Font.PLAIN, 17));
		southDoor.setBounds(262, 22, 84, 23);
		contentPane.add(southDoor);
		
		JLabel ErrorLabel = new JLabel();
		ErrorLabel.setFont(new Font("楷体", Font.PLAIN, 17));
		ErrorLabel.setForeground(Color.green);
		ErrorLabel.setBounds(65, 51, 203, 33);
		contentPane.add(ErrorLabel);
		
		JButton btnNewButton = new JButton("退出");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MinT.this.dispose();
			}
		});
		btnNewButton.setBounds(335, 406, 60, 38);
		contentPane.add(btnNewButton);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu backMenu = new JMenu("返回");
		backMenu.setFont(new Font("宋体", Font.PLAIN, 15));
		menuBar.add(backMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("返回上一级");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MinT.this.dispose();
				MainFrame r=new MainFrame();
				r.setVisible(true);
			}
		});
		backMenu.add(mntmNewMenuItem);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(20, 418, 283, 26);
		contentPane.add(lblNewLabel);
		
		JButton inButton = new JButton("确定");
		inButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mainDoor.isSelected()) {
					minTreeTextArea.setText(map.Prim());
					ErrorLabel.setText("得嘞！不枉来一遭！！！");
					lblNewLabel.setText("注：(北京,天津)->表示北京到天津的路径");
				}else if(southDoor.isSelected()){
					ErrorLabel.setText("又调皮！！！");
					minTreeTextArea.setText("宝宝不高兴！！！");
				}else {
					ErrorLabel.setText("好歹选一个嘛！！！");
				}
			}
		});
		inButton.setFont(new Font("楷体", Font.PLAIN, 20));
		inButton.setBounds(317, 51, 78, 38);
		contentPane.add(inButton);
	}
}