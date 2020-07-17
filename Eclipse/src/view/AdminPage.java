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

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AdminPage extends JFrame {

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
					AdminPage frame = new AdminPage();
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
	public AdminPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(190, 211, 135, 33);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(190, 279, 135, 33);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(343, 219, 135, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(343, 287, 135, 20);
		contentPane.add(passwordField);
		
		JLabel lblAdminPage = new JLabel("ADMIN PAGE");
		lblAdminPage.setFont(new Font("Tahoma", Font.BOLD, 80));
		lblAdminPage.setBounds(88, 25, 528, 117);
		contentPane.add(lblAdminPage);
		
		JButton btnLogIn = new JButton("LOG IN");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
		        String password = passwordField.getText();
		        
		        if (password.contains("P@ssw0rd") && username.contains("administrator"))
		        {
		        	textField.setText(null);
		            passwordField.setText(null);
		            
		            Table table = new Table();
		            table.setVisible(true);
		            dispose();
		        }
		        
		        else
		        {
		            JOptionPane.showMessageDialog(null,"You enter the wrong password!", "Login Error",JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
		btnLogIn.setBounds(317, 387, 89, 23);
		contentPane.add(btnLogIn);
	}
}
