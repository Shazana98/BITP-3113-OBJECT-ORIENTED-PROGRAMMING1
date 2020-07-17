package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.customerManager;
import model.Customer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CustomerDetails extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textAddress;
	private JTextField textPhoneNum;
	private JTextField textEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerDetails frame = new CustomerDetails();
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
	public CustomerDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustomerDetails = new JLabel("CUSTOMER DETAILS");
		lblCustomerDetails.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblCustomerDetails.setBounds(177, 24, 321, 38);
		contentPane.add(lblCustomerDetails);
		
		JLabel lblFirstAndLast = new JLabel("First and last name");
		lblFirstAndLast.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFirstAndLast.setBounds(177, 86, 125, 19);
		contentPane.add(lblFirstAndLast);
		
		textName = new JTextField();
		textName.setBackground(Color.LIGHT_GRAY);
		textName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textName.setBounds(177, 116, 362, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddress.setBounds(177, 158, 52, 19);
		contentPane.add(lblAddress);
		
		textAddress = new JTextField();
		textAddress.setBackground(Color.LIGHT_GRAY);
		textAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textAddress.setBounds(177, 188, 362, 20);
		contentPane.add(textAddress);
		textAddress.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Phone number");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(177, 229, 95, 19);
		contentPane.add(lblNewLabel);
		
		textPhoneNum = new JTextField();
		textPhoneNum.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPhoneNum.setBackground(Color.LIGHT_GRAY);
		textPhoneNum.setBounds(177, 254, 109, 20);
		contentPane.add(textPhoneNum);
		textPhoneNum.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(177, 300, 33, 19);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBackground(Color.LIGHT_GRAY);
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textEmail.setBounds(177, 330, 362, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JButton btnContinue = new JButton("CONTINUE");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textName.getText();
				String address = textAddress.getText();
				String phone = textPhoneNum.getText();
				String email = textEmail.getText();
				
				Customer customer = new Customer();
				customer.setName(name);
				customer.setAddress(address);
				customer.setPhone(phone);
				customer.setEmail(email);
				
				customerManager CustomerManager = new customerManager();
				try {
					
					int success = CustomerManager.insertCustomer(customer);
					if(success > 0)
					{
						JOptionPane.showMessageDialog(null,"Successfully add data.","Add Success",JOptionPane.INFORMATION_MESSAGE);
						
						RoomDetails roomDetails = new RoomDetails();
						roomDetails.setVisible(true);
						dispose();
					}
				}catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnContinue.setBackground(SystemColor.textHighlight);
		btnContinue.setForeground(SystemColor.text);
		btnContinue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnContinue.setBounds(291, 401, 160, 27);
		contentPane.add(btnContinue);
		
		JLabel mainBackground = new JLabel("");
		mainBackground.setFont(new Font("Tahoma", Font.PLAIN, 11));
		mainBackground.setIcon(new ImageIcon("C:\\Users\\shaza\\Documents\\BITP 3113 Object Oriented\\Eclipse\\src\\view\\noname1.png"));
		mainBackground.setBounds(0, -12, 730, 743);
		contentPane.add(mainBackground);
	}

}
