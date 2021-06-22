package view;

import java.awt.CardLayout;
import java.awt.EventQueue;
import entity.Teacher;
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

import dao.TeacherDao;
import dao.impl.TeacherDaoImpl;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;

public class TeacherManagerFram extends JFrame {

	private static final long serialVersionUID = 764910992591794299L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherManagerFram frame = new TeacherManagerFram();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TeacherManagerFram() {
		setTitle("\u6559\u5E08\u4FE1\u606F\u7BA1\u7406\u7A97\u4F53");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "name_25808716617982");
		panel.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"教师编号"}));
		comboBox.setBounds(82, 10, 107, 21);
		panel.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(199, 10, 99, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String teaNo = textField.getText();
				TecherInfoFram infoFrame = new TecherInfoFram();
				infoFrame.setVisible(true);
				TeacherDaoImpl teacherDao=new TeacherDaoImpl();
				Teacher tea = teacherDao.queryTeacherByTeaNo(teaNo);
				String deptNo =  tea.getDeptNo();
				String teano = tea.getTeacherNo();
				String teaName = tea.getTeacherName();
				String teaProfessional = tea.getTeacherProfessional();
			
				infoFrame.textField.setText(deptNo);
				infoFrame.textField_1.setText(teano);
				infoFrame.textField_2.setText(teaName);
				infoFrame.textField_3.setText(teaProfessional);
			}
		});
		btnNewButton.setBounds(308, 9, 93, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("刷新");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initTable();
			}
		});
		btnNewButton_1.setBounds(411, 9, 93, 23);
		panel.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(82, 81, 422, 289);
		panel.add(scrollPane);
		
		table = new JTable();
		

		initTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("添加");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TecherAddFram addFrame = new TecherAddFram();
				addFrame.setVisible(true);
//				TeacherManagerFram.this
			}
		});
		btnNewButton_2.setBounds(147, 406, 93, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("修改");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TecherUpdataFram updataFrame = new TecherUpdataFram();
				updataFrame.setVisible(true);
				int i=table.getSelectedRow();
				String deptNo =  (String) table.getValueAt(i, 0);
				String teaNo =  (String) table.getValueAt(i, 2);
				String teaName =  (String) table.getValueAt(i, 1);
				String teaProfessional =  (String) table.getValueAt(i, 3);
			
				updataFrame.textField.setText(deptNo);
				updataFrame.textField_1.setText(teaNo);
				updataFrame.textField_2.setText(teaName);
				updataFrame.textField_3.setText(teaProfessional);
				
			}
		});
		btnNewButton_1_1.setBounds(262, 406, 93, 23);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("删除");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i=table.getSelectedRow();
				String teaNo =  (String) table.getValueAt(i, 2);
				TeacherDaoImpl teacherDao=new TeacherDaoImpl();
				int res = teacherDao.deleteTeacher(teaNo);
				if (res>0) {
					System.out.println("删除成功！");
				} else {
					System.out.println("删除失败！");
				}
			}
		});
		btnNewButton_1_1_1.setBounds(374, 406, 93, 23);
		panel.add(btnNewButton_1_1_1);
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
