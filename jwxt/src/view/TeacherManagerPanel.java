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
	private JTable table;
	private JTextField textField;

	/**
	 * Create the panel.
	 */

	public TeacherManagerPanel() {
//		setTitle("\u6559\u5E08\u4FE1\u606F\u7BA1\u7406\u7A97\u4F53");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<>(new String[] { "请选择系别编号" }));
		panel_1.add(comboBox);

		textField = new JTextField();
		textField.setColumns(10);
		panel_1.add(textField);

		JButton btnNewButton = new JButton("查询");
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("刷新");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initTable();
			}
		});
		panel_1.add(btnNewButton_1);

		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);

		JButton btnNewButton_2 = new JButton("添加");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TecherAddFram addFrame = new TecherAddFram();
				addFrame.setVisible(true);
				initTable();
			}
		});
		panel_2.add(btnNewButton_2);

		JButton btnNewButton_1_1 = new JButton("修改");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TecherUpdataFram updataFrame = new TecherUpdataFram();
				updataFrame.setVisible(true);
				int i = table.getSelectedRow();
				String deptNo = (String) table.getValueAt(i, 0);
				String teaNo = (String) table.getValueAt(i, 2);
				String teaName = (String) table.getValueAt(i, 1);
				String teaProfessional = (String) table.getValueAt(i, 3);

				updataFrame.textField.setText(deptNo);
				updataFrame.textField_1.setText(teaNo);
				updataFrame.textField_2.setText(teaName);
				updataFrame.textField_3.setText(teaProfessional);
			}
		});
		panel_2.add(btnNewButton_1_1);

		JButton btnNewButton_1_1_1 = new JButton("删除");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				String teaNo = (String) table.getValueAt(i, 2);
				TeacherDaoImpl teacherDao = new TeacherDaoImpl();
				int res = teacherDao.deleteTeacher(teaNo);
				if (res > 0) {
					System.out.println("删除成功！");
				} else {
					System.out.println("删除失败！");
				}
				initTable();
			}
		});
		panel_2.add(btnNewButton_1_1_1);

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);

		table = new JTable();

		initTable();
		scrollPane.setViewportView(table);
	}

	private void initTable() {
		List<Teacher> list;
		TeacherDaoImpl teacherDao = new TeacherDaoImpl();
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

		table.setModel(new DefaultTableModel(teacherArr, new String[] { "系别编号", "教师姓名", "教师编号", "教师职称" }));

		table.repaint();

	}
}
