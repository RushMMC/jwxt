package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TecherAddFram extends JFrame {

	private static final long serialVersionUID = -3830563008977397844L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TecherAddFram frame = new TecherAddFram();
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
	public TecherAddFram() {
		setTitle("\u8001\u5E08\u6DFB\u52A0fram");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7CFB\u90E8\u7F16\u53F7\uFF1A");
		lblNewLabel.setBounds(169, 64, 90, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(300, 61, 150, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u7CFB\u90E8\u7F16\u53F7\uFF1A");
		lblNewLabel_1.setBounds(169, 111, 90, 15);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(300, 108, 150, 21);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u7CFB\u90E8\u7F16\u53F7\uFF1A");
		lblNewLabel_1_1.setBounds(169, 166, 90, 15);
		contentPane.add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(300, 163, 150, 21);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("\u7CFB\u90E8\u7F16\u53F7\uFF1A");
		lblNewLabel_1_2.setBounds(169, 225, 90, 15);
		contentPane.add(lblNewLabel_1_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(300, 222, 150, 21);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(211, 347, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(339, 347, 93, 23);
		contentPane.add(btnNewButton_1);
	}
}
