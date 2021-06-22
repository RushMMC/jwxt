package view;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.MajorDao;
import dao.impl.MajorDaoImpl;
import entity.Major;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MajorManagerFrame extends JFrame {

	private static final long serialVersionUID = -2192296360817457525L;
	private JPanel contentPane;
	private JTextField textField;
	private MajorDao majorDao = new MajorDaoImpl();
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MajorManagerFrame frame = new MajorManagerFrame();
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
	public MajorManagerFrame() {
		setTitle("专业信息管理");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 450, 345);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"专业编号"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(30, 23, 95, 23);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.setBounds(214, 23, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("查询全部");
		btnNewButton_1.setBounds(317, 23, 93, 23);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(138, 24, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		List<Major> allMajor = majorDao.queryAllMajor();
		Object[][] data=new Object[allMajor.size()][3];
		int i=0;
		for (Major major: allMajor) {
			data[i][0]=major.getDeptNo();
			data[i][1]=major.getMajNo();
			data[i][2]=major.getMajName();
			i++;
		}
		
		JButton btnNewButton_2 = new JButton("添加");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				MajorAddDialog dialog = new MajorAddDialog();
//				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//				dialog.setVisible(true);
				MajorAddFrame frame = new MajorAddFrame();
				frame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(66, 261, 93, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("修改");
		btnNewButton_2_1.setBounds(185, 261, 93, 23);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("删除");
		btnNewButton_2_2.setBounds(303, 261, 93, 23);
		contentPane.add(btnNewButton_2_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 56, 379, 191);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			data,
			new String[] {
				"\u4E13\u4E1A\u7F16\u53F7", "\u7CFB\u522B\u7F16\u53F7", "\u4E13\u4E1A\u540D\u79F0"
			}
		));
		scrollPane.setViewportView(table);
	}
}
