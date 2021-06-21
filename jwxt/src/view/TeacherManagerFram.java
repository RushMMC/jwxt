package view;

import java.awt.CardLayout;
import java.awt.EventQueue;

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
		comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"\u6559\u5E08\u7F16\u53F7,\u6559\u5E08\u540D\u79F0"}));
		comboBox.setBounds(82, 10, 107, 21);
		panel.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(199, 10, 99, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.setBounds(308, 9, 93, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2\u5168\u90E8");
		btnNewButton_1.setBounds(411, 9, 93, 23);
		panel.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(82, 81, 422, 289);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("\u67E5\u8BE2");
		btnNewButton_2.setBounds(147, 406, 93, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("\u67E5\u8BE2\u5168\u90E8");
		btnNewButton_1_1.setBounds(262, 406, 93, 23);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("\u67E5\u8BE2\u5168\u90E8");
		btnNewButton_1_1_1.setBounds(374, 406, 93, 23);
		panel.add(btnNewButton_1_1_1);
	}
}
