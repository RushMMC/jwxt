package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.impl.CourseDaoImpl;
import entity.Course;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;

public class CourseManagerPanel extends JPanel {

	private static final long serialVersionUID = 9048414670403498189L;
	private JTextField textField;
	private JTable table;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public CourseManagerPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"请选择课程类别"}));
		panel.add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		panel.add(textField);
		
		JButton btnNewButton = new JButton("查询");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("查询全部");
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		CourseDaoImpl couse=new CourseDaoImpl();	
		List<Course>courseList=couse.FetchAllCourse();
		Object [][]list=new Object[courseList.size()][9];
		for(int i=0;i<courseList.size();i++) {
				list[i][0]=courseList.get(i).getCourNo();
				list[i][1]=courseList.get(i).getCtyNo();
				list[i][2]=courseList.get(i).getCourName();
				list[i][3]=courseList.get(i).getCourCredit();
				list[i][4]=courseList.get(i).getCourCtime();
				list[i][5]=courseList.get(i).getCourOpenTeam();
				list[i][6]=courseList.get(i).getCourIsTequire();
				list[i][7]=courseList.get(i).getDeptNo();
				list[i][8]=courseList.get(i).getCourRemark();
		}
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			list,
			new String[] {
				"课程编号", "课程类别编号", "课程名", "课程绩点", "开始时间", "开设学期", "是否必修", "系别编号", "备注"
			}
		));
		
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton_2 = new JButton("添加");
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("修改");
		panel_2.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("删除");
		panel_2.add(btnNewButton_2_1_1);

	}

}
