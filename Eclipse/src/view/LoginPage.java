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
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textUsername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSignUp = new JButton("SIGN UP");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterPage registerPage = new RegisterPage();
				registerPage.setVisible(true);
				dispose();
			}
		});
		
		JButton btnAdmin = new JButton("Administrator");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage adminPage = new AdminPage();
			    adminPage.setVisible(true);
			    dispose();
			}
		});
		btnAdmin.setBounds(519, 23, 140, 23);
		contentPane.add(btnAdmin);
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSignUp.setBounds(370, 380, 120, 23);
		contentPane.add(btnSignUp);
		
		JLabel lblBookingSystem = new JLabel("BOOKING SYSTEM");
		lblBookingSystem.setFont(new Font("Ink Free", Font.BOLD, 40));
		lblBookingSystem.setForeground(Color.WHITE);
		lblBookingSystem.setBounds(166, 162, 390, 54);
		contentPane.add(lblBookingSystem);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = textUsername.getText();
				String password = passwordField.getText();
				
				userBean ub = new userBean();
				ub.setUsername(username);
				ub.setPassword(password);
				
				userManager um = new userManager();
				try {
					boolean success = um.loginUser(ub);
					if(success)
					{
						BookingPage bookingPage = new BookingPage();
						bookingPage.setVisible(true);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Please insert correct username and password.","Login Error",JOptionPane.ERROR_MESSAGE);
					}
				}catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(245, 380, 100, 23);
		contentPane.add(btnLogin);
		
		textUsername = new JTextField();
		textUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textUsername.setBounds(317, 283, 182, 20);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(318, 314, 181, 20);
		contentPane.add(passwordField);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(237, 317, 71, 14);
		contentPane.add(lblPassword);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(230, 286, 77, 14);
		contentPane.add(lblUsername);
		
		JLabel labelTitle = new JLabel("   WAOW RESORT \r");
		labelTitle.setForeground(Color.WHITE);
		labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitle.setFont(new Font("Ink Free", Font.BOLD, 40));
		labelTitle.setBounds(166, 103, 381, 70);
		contentPane.add(labelTitle);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\shaza\\Documents\\BITP 3113 Object Oriented\\Eclipse\\src\\view\\Tamarind_Tree-1000x675.jpg"));
		label.setBounds(-10, -55, 714, 619);
		contentPane.add(label);
	}
}
