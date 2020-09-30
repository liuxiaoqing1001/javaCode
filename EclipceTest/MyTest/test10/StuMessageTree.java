package test10;
import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;

@SuppressWarnings("unused")
public class StuMessageTree
{
  public StuMessageTree() {
    try {
      jbInit();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }


  public static void main(String[] args)
   {
      JFrame frame = new SimpleTreeFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      JMenuBar menuBar = new JMenuBar();
      frame.setJMenuBar(menuBar);
      
      JMenu mnNewMenu = new JMenu("\u6587\u4EF6");
      mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
      menuBar.add(mnNewMenu);
      
      JMenuItem mntmNewMenuItem = new JMenuItem("\u6253\u5F00\u65B0\u7A97\u53E3");
      mntmNewMenuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
      mnNewMenu.add(mntmNewMenuItem);
      
      JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u5E2E\u52A9");
      mntmNewMenuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
      mnNewMenu.add(mntmNewMenuItem_1);
      
      JMenu mnNewMenu_1 = new JMenu("\u5171\u4EAB");
      mnNewMenu_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
      menuBar.add(mnNewMenu_1);
      
      JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u53D1\u9001\u7535\u5B50\u90AE\u7BB1");
      mntmNewMenuItem_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
      mnNewMenu_1.add(mntmNewMenuItem_2);
      
      JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u5176\u4ED6\u65B9\u5F0F");
      mntmNewMenuItem_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
      mnNewMenu_1.add(mntmNewMenuItem_3);
      
      JScrollPane scrollPane = new JScrollPane();
      frame.getContentPane().add(scrollPane, BorderLayout.NORTH);
      frame.setVisible(true);
   }

  private void jbInit() throws Exception {
  }
}

@SuppressWarnings("serial")
class SimpleTreeFrame extends JFrame
{
   public SimpleTreeFrame()
   {
      setTitle("StudentMesssageTree");
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
      DefaultMutableTreeNode school = new DefaultMutableTreeNode("天津职业技术师范大学");
      DefaultMutableTreeNode college = new DefaultMutableTreeNode("信息技术工程学院、软件工程学院");
      school.add(college);
      DefaultMutableTreeNode professional = new DefaultMutableTreeNode("软件工程");
      college.add(professional);
      DefaultMutableTreeNode clases = new DefaultMutableTreeNode("软件1702班");
      professional.add(clases);
      DefaultMutableTreeNode dormitory = new  DefaultMutableTreeNode("624");
      clases.add(dormitory);
      DefaultMutableTreeNode roommate = new  DefaultMutableTreeNode("樊");
      dormitory.add(roommate);
      roommate = new  DefaultMutableTreeNode("付");
      dormitory.add(roommate);
      roommate = new  DefaultMutableTreeNode("刘");
      dormitory.add(roommate);
      roommate = new  DefaultMutableTreeNode("马");
      dormitory.add(roommate);
      JTree tree = new JTree(school);
      Container contentPane = getContentPane();
      contentPane.add(new JScrollPane(tree));
   }
   private static final int DEFAULT_WIDTH = 300;
   private static final int DEFAULT_HEIGHT = 200;
}