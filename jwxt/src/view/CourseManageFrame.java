package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.impl.CourseDaoImpl;
import entity.Course;

public class CourseManageFrame extends JFrame {

	private static final long serialVersionUID = -835041426021807229L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

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
		CourseDaoImpl couse=new CourseDaoImpl();	
		
		
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
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"课程编号"}));
		comboBox.setBounds(21, 10, 93, 21);
		contentPane.add(comboBox);
		

		
		JButton btnNewButton_1 = new JButton("查询全部");
		btnNewButton_1.setBounds(338, 9, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 60, 756, 203);
		contentPane.add(panel_1);
		
		
		
		List<Course>courseList=couse.FetchAllCourse();
		Object [][]list=new Object[courseList.size()][9];
		for(int i=0;i<courseList.size();i++) {
//			System.out.println(courseList.get(i).toString());
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
	
		panel_1.setLayout(null);
		
		table_1 = new JTable();
		table_1.setBounds(41, 36, 1, 1);
		panel_1.add(table_1);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
				list,
			new String	[] {
				"\u8BFE\u7A0B\u7F16\u53F7", 
				"\u8BFE\u7A0B\u7C7B\u578B\u7F16\u53F7", 
				"\u8BFE\u7A0B\u540D",
				"\u7EE9\u70B9", 
				"\u5F00\u59CB\u65F6\u95F4", 
				"\u5F00\u8BBE\u5B66\u671F",
				"\u662F\u5426\u5FC5\u4FEE",
				"\u7CFB\u522B\u7F16\u53F7", 
				"\u5907\u6CE8"
			}
		));
		table_2.setBounds(10, 10, 736, 183);
		panel_1.add(table_2);
		panel_1.setLayout(null);
		
		
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(textField.getText());
				Course course=couse.FinCourseByNo(Integer.parseInt(textField.getText()));
				
				Object [][]coure=new Object[1][9];
			
				coure[0][0]=course.getCourNo();
				coure[0][1]=course.getCtyNo();
				coure[0][2]=course.getCourName();
				coure[0][3]=course.getCourCredit();
				coure[0][4]=course.getCourCtime();
				coure[0][5]=course.getCourOpenTeam();
				coure[0][6]=course.getCourIsTequire();
				coure[0][7]=course.getDeptNo();
				coure[0][8]=course.getCourRemark();
				System.out.println(coure[0].toString());
				
				table_2.setModel(new DefaultTableModel(
							coure,
							new String	[] {
									"\u8BFE\u7A0B\u7F16\u53F7", 
									"\u8BFE\u7A0B\u7C7B\u578B\u7F16\u53F7", 
									"\u8BFE\u7A0B\u540D",
									"\u7EE9\u70B9", 
									"\u5F00\u59CB\u65F6\u95F4", 
									"\u5F00\u8BBE\u5B66\u671F",
									"\u662F\u5426\u5FC5\u4FEE",
									"\u7CFB\u522B\u7F16\u53F7", 
									"\u5907\u6CE8"
								}
						));
				
//				table.setModel(new DefaultTableModel(
//						coure,
//						new String[] {
//							"课程编号", "课程类别编号", "课程名", "课程绩点", "开始时间", "开设学期", "是否必修", "系别编号", "备注"
//						}
//					));
			}
		});
		btnNewButton.setBounds(234, 9, 93, 23);
		contentPane.add(btnNewButton);
		
		
		
		
		
		
		
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
