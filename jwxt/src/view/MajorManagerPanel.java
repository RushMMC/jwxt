package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.DepartmentDao;
import dao.MajorDao;
import dao.impl.DepartmentDaoImpl;
import dao.impl.MajorDaoImpl;
import entity.Department;
import entity.Major;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MajorManagerPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel tableModel;
	private MajorDao majorDao = new MajorDaoImpl();
	private DepartmentDao deptDao = new DepartmentDaoImpl();
	private JTextField majName;
	private JTextField majNo;
	private String[] tableHeader= {"\u4E13\u4E1A\u7F16\u53F7", "\u7CFB\u522B\u7F16\u53F7", "\u4E13\u4E1A\u540D\u79F0"};
	

	
	/**
	 * Create the panel.
	 */
	public MajorManagerPanel() {
		setLayout(new BorderLayout(0, 0));
		tableModel = new DefaultTableModel();
		tableModel.setDataVector(null, tableHeader);
		
		JPanel panel = new JPanel();
		panel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.setMinimumSize(new Dimension(20, 10));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JComboBox<String> comboBox = new JComboBox<String>();
		
		List<Department> queryAllDept = deptDao.queryAllDept();
		String[] depts = new String[queryAllDept.size()+1];
		depts[0]="请选择系别";
		for (int i = 0; i < queryAllDept.size(); i++) {
			depts[i+1]=queryAllDept.get(i).getDeptName();
		}
		comboBox.setModel(new DefaultComboBoxModel<>(depts));
		comboBox.setToolTipText("");
		panel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("专业名");
		panel.add(lblNewLabel);
		
		majName = new JTextField();
		majName.setToolTipText("");
		majName.setColumns(10);
		panel.add(majName);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int itemIndex = comboBox.getSelectedIndex();
				Major major = new Major();
				if(itemIndex>0) {
					Department department = queryAllDept.get(itemIndex-1);
					major.setDeptNo(department.getDeptNo());
				}
				if(!"".equals(majNo.getText())){
					major.setMajNo(majNo.getText());
				}
				if(!"".equals(majName.getText())) {
					major.setMajName(majName.getText());
				}
				if(major.getDeptNo()!=null||major.getMajName()!=null||major.getMajNo()!=null) {
					loadData(majorDao.queryMajorLikeMajor(major));
				}
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("专业编号");
		panel.add(lblNewLabel_1);
		
		majNo = new JTextField();
		panel.add(majNo);
		majNo.setColumns(5);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("查询全部");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadData(majorDao.queryAllMajor());
			}
		});
		panel.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		table = new JTable();
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton_2 = new JButton("添加");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("修改");
		panel_1.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("删除");
		panel_1.add(btnNewButton_2_2);

	}
	private void loadData(List<Major> majors) {
		Object[][] data=new Object[majors.size()][3];
		int i=0;
		for (Major maj: majors) {
			data[i][0]=maj.getMajNo();
			data[i][1]=maj.getDeptNo();
			data[i][2]=maj.getMajName();
			i++;
		}
		tableModel.setDataVector(data, tableHeader);
	}
}
