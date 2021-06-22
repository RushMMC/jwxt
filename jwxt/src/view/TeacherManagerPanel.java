package view;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.impl.TeacherDaoImpl;
import entity.Teacher;
import java.awt.BorderLayout;

public class TeacherManagerPanel extends JPanel {
	private static final long serialVersionUID = 764910992591794299L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	
	/**
	 * Create the panel.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherManagerPanel frame = new TeacherManagerPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public TeacherManagerPanel() {
//		setTitle("\u6559\u5E08\u4FE1\u606F\u7BA1\u7406\u7A97\u4F53");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		panel_1.add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		panel_1.add(textField);
		
		JButton btnNewButton = new JButton("查询");
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("刷新");
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton_2 = new JButton("添加");
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("修改");
		panel_2.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("删除");
		panel_2.add(btnNewButton_1_1_1);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		table = new JTable();
		

		initTable();
		scrollPane.setViewportView(table);
	}
	private  void  initTable()
	{
		List<Teacher> list;
		TeacherDaoImpl teacherDao=new TeacherDaoImpl();
		list = teacherDao.queryAllTeacher();
		Object[][] teacherArr = new Object[list.size()][4];
		Iterator<Teacher> it = list.iterator();
		int i = 0;
		while (it.hasNext()) {
			Teacher tea = it.next();
			
			teacherArr[i][0] = tea.getDeptNo();
			teacherArr[i][1] = tea.getTeacherName();
			teacherArr[i][2] = tea.getTeacherNo();
			teacherArr[i][3] = tea.getTeacherProfessional();
			i++;
		} 
		 
		 table.setModel(new DefaultTableModel(
					teacherArr,
					new String[] {
						"系别编号", "教师姓名", "教师编号", "教师职称"
					}
				));
		
		table.repaint();

	}
}
