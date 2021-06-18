package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.Impl.CourseDaoImpl;
import entity.Course;

public class CourseManageFrame extends JFrame {

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
					CourseManageFrame frame = new CourseManageFrame();
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
	public CourseManageFrame() {
		setTitle("课程信息管理");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(69, 37, -62, -30);
		contentPane.add(panel);
		
		textField = new JTextField();
		textField.setBounds(124, 10, 100, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"课程编号"}));
		comboBox.setBounds(21, 10, 93, 21);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(234, 9, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("查询全部");
		btnNewButton_1.setBounds(338, 9, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 60, 756, 203);
		contentPane.add(panel_1);
		
		
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
		panel_1.add(table);
		
		JButton btnNewButton_2 = new JButton("添加");
		btnNewButton_2.setBounds(63, 301, 93, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("修改");
		btnNewButton_2_1.setBounds(192, 301, 93, 23);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("删除");
		btnNewButton_2_1_1.setBounds(317, 301, 93, 23);
		contentPane.add(btnNewButton_2_1_1);
	}
}
