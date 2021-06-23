package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 * 
 * @author RushMMC
 * @date 2021/06/22
 *
 */
public class AdminMainFrame extends JFrame {

	private static final long serialVersionUID = 6428924274821097177L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
					UIManager.setLookAndFeel(lookAndFeel);  
					AdminMainFrame frame = new AdminMainFrame();
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
	public AdminMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(680, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel headerPanel = new JPanel();
		headerPanel.setSize(680, 50);
		contentPane.add(headerPanel, BorderLayout.NORTH);
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("教务系统后台");
		headerPanel.add(lblNewLabel);
		
		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new GridLayout(10, 1, 0, 0));
		
		JButton btnNewButton = new JButton("教师管理");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherManagerPanel frame = new TeacherManagerPanel();
				frame.setVisible(true);
				splitPane.setRightComponent(frame);
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("课程管理");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CourseManagerPanel panel = new CourseManagerPanel();
				splitPane.setRightComponent(panel);
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("专业管理");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel majorPanel = new MajorManagerPanel();
				splitPane.setRightComponent(majorPanel);
			}
		});
		panel.add(btnNewButton_2);
		
		JPanel showPanel = new JPanel();
		splitPane.setRightComponent(showPanel);
		showPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("欢迎使用教务系统");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("华文楷体", Font.BOLD | Font.ITALIC, 45));
		lblNewLabel_1.setBounds(0, 0, 566, 405);
		showPanel.add(lblNewLabel_1);
	}
}
