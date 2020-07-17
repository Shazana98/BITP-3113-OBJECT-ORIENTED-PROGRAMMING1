package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.userManager;
import model.userBean;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class RegisterPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage frame = new RegisterPage();
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
	public RegisterPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage loginPage = new LoginPage();
				loginPage.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(323, 429, 89, 23);
		contentPane.add(btnBack);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(167, 284, 386, 20);
		passwordField.setForeground(Color.BLACK);
		passwordField.setBackground(Color.GRAY);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(167, 257, 63, 16);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(167, 214, 386, 20);
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.GRAY);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnShowPassword = new JRadioButton("Show Password");
		rdbtnShowPassword.setBounds(167, 311, 117, 25);
		rdbtnShowPassword.setBackground(Color.GRAY);
		rdbtnShowPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnShowPassword.setForeground(Color.BLACK);
		contentPane.add(rdbtnShowPassword);
		
		JLabel lblNewLabel = new JLabel("Email Address");
		lblNewLabel.setBounds(167, 187, 90, 16);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel);
		
		JLabel lblSignUpWith = new JLabel("Sign up with your email");
		lblSignUpWith.setBounds(244, 135, 128, 15);
		lblSignUpWith.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblSignUpWith);
		
		JLabel lblCreateAnAccount = new JLabel("Create an Account");
		lblCreateAnAccount.setBounds(244, 93, 228, 31);
		lblCreateAnAccount.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(lblCreateAnAccount);
		
		JButton btnRegister = new JButton("Sign Up");
		btnRegister.setBounds(167, 395, 386, 23);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = textField.getText();
				String password = passwordField.getText();
				
				userBean UserBean = new userBean();
				UserBean.setUsername(username);
				UserBean.setPassword(password);
				
				userManager UserManager = new userManager();
				try {
					int success = UserManager.insertUser(UserBean);
					if(success > 0)
					{
						JOptionPane.showMessageDialog(null,"Successfully create your account!.","Add Success",JOptionPane.INFORMATION_MESSAGE);
						LoginPage loginPage = new LoginPage();
						loginPage.setVisible(true);
						dispose();
					}
					else if(username.equals(" "))
					{
						JOptionPane.showMessageDialog(null,"Please insert your email.","Add Fail",JOptionPane.ERROR_MESSAGE);
					}
					else if(password.equals(" "))
					{
						JOptionPane.showMessageDialog(null,"Please insert your password","Add Fail",JOptionPane.ERROR_MESSAGE);
					}
				}catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRegister.setBackground(new Color(51, 0, 102));
		btnRegister.setForeground(new Color(0, 0, 0));
		contentPane.add(btnRegister);
		
		JLabel label = new JLabel("");
		label.setBounds(0, -62, 701, 624);
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBackground(new Color(25, 25, 112));
		label.setIcon(new ImageIcon("C:\\Users\\shaza\\Documents\\BITP 3113 Object Oriented\\Eclipse\\src\\view\\noname.png"));
		contentPane.add(label);
	}
}
