package Map;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MainFrame() {
		setTitle("У԰����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(525, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("�����ְҵ����ʦ����ѧ��У԰����");
		titleLabel.setFont(new Font("����", Font.PLAIN, 25));
		titleLabel.setBounds(10, 10, 416, 36);
		contentPane.add(titleLabel);
		
		JButton btnNewButton = new JButton("·����ѯ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.this.dispose();
				Frame frame=new Frame();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(145, 90, 110, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton1 = new JButton("�˳�");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.this.dispose();
			}
		});
		btnNewButton1.setBounds(145,189, 110, 29);
		contentPane.add(btnNewButton1);
		
		JButton btnNewButton_1 = new JButton("��С������");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.this.dispose();
				MinT minT=new MinT();
				minT.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(145, 140, 110, 29);
		contentPane.add(btnNewButton_1);
	}
}
