package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.MajorDao;
import dao.impl.MajorDaoImpl;
import entity.Major;

public class MajorAddFrame extends JFrame {

	private static final long serialVersionUID = 5937642026887200536L;
	private JPanel contentPane;
	private JTextField deptNo;
	private JLabel lblNewLabel_1;
	private JTextField majNo;
	private JLabel lblNewLabel_2;
	private JTextField majName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MajorAddFrame frame = new MajorAddFrame();
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
	public MajorAddFrame() {
		setTitle("添加专业信息");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("系别编号");
		lblNewLabel.setBounds(59, 24, 54, 15);
		contentPane.add(lblNewLabel);
		
		deptNo = new JTextField();
		deptNo.setBounds(148, 21, 118, 21);
		contentPane.add(deptNo);
		deptNo.setColumns(10);
		
		lblNewLabel_1 = new JLabel("专业编号");
		lblNewLabel_1.setBounds(59, 83, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		majNo = new JTextField();
		majNo.setColumns(10);
		majNo.setBounds(148, 80, 118, 21);
		contentPane.add(majNo);
		
		lblNewLabel_2 = new JLabel("专业名称");
		lblNewLabel_2.setBounds(59, 136, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		majName = new JTextField();
		majName.setColumns(10);
		majName.setBounds(148, 133, 118, 21);
		contentPane.add(majName);
		
		JButton confirm = new JButton("添加");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MajorDao dao = new MajorDaoImpl();
				Major major = new Major();
				major.setDeptNo(deptNo.getText());
				major.setMajNo(majNo.getText());
				major.setMajName(majName.getText());
				dao.addMajor(major);
			}
		});
		confirm.setBounds(173, 194, 93, 23);
		contentPane.add(confirm);
	}
}
