package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.glass.events.KeyEvent;

import controller.paymentManager;
import model.Payment;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class PaymentDetails extends JFrame {

	private JPanel contentPane;
	private JTextField textCardNum;
	private JTextField textExpiryDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentDetails frame = new PaymentDetails();
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
	public PaymentDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSignOut = new JButton("SIGN OUT");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage loginPage = new LoginPage();
				loginPage.setVisible(true);
				dispose();
			}
		});
		btnSignOut.setBounds(313, 430, 89, 23);
		contentPane.add(btnSignOut);
		
		JLabel lblPaymentDetails = new JLabel("PAYMENT DETAILS");
		lblPaymentDetails.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPaymentDetails.setBounds(190, 49, 212, 31);
		contentPane.add(lblPaymentDetails);
		
		JLabel lblNewLabel_1 = new JLabel("Card Number");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(226, 177, 87, 19);
		contentPane.add(lblNewLabel_1);
		
		textCardNum = new JTextField();
		textCardNum.setBackground(Color.LIGHT_GRAY);
		textCardNum.setForeground(Color.BLACK);
		textCardNum.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCardNum.setBounds(248, 207, 226, 20);
		contentPane.add(textCardNum);
		textCardNum.setColumns(10);
		
		JLabel lblExpiryDate = new JLabel("Expiry Date");
		lblExpiryDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExpiryDate.setBounds(226, 238, 75, 19);
		contentPane.add(lblExpiryDate);
		
		textExpiryDate = new JTextField();
		textExpiryDate.setBackground(Color.LIGHT_GRAY);
		textExpiryDate.setForeground(new Color(0, 0, 0));
		textExpiryDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textExpiryDate.setBounds(248, 268, 226, 20);
		contentPane.add(textExpiryDate);
		textExpiryDate.setColumns(10);
		
		JButton btnBookNow = new JButton("BOOK NOW!");
		btnBookNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String card = textCardNum.getText();
				String date = textExpiryDate.getText();
				
				Payment payment = new Payment();
				payment.setCreditCardNo(card);;
				payment.setExpiredDate(date);
				
				paymentManager PaymentManager = new paymentManager();
				try {
					int success = PaymentManager.insertPayment(payment);
					if(success>0)
					{
						JOptionPane.showMessageDialog(null,"Successfully book your room!","Add Success",JOptionPane.INFORMATION_MESSAGE);
					}		
				}catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBookNow.setBackground(Color.GRAY);
		btnBookNow.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBookNow.setBounds(248, 385, 226, 27);
		contentPane.add(btnBookNow);
		
		ButtonGroup group = new ButtonGroup();
		
		JLabel lblEnterCreditCard = new JLabel("Enter credit card details");
		lblEnterCreditCard.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterCreditCard.setBounds(226, 126, 152, 19);
		contentPane.add(lblEnterCreditCard);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\shaza\\Documents\\BITP 3113 Object Oriented\\Eclipse\\src\\view\\noname1.png"));
		label.setBounds(0, -12, 720, 743);
		contentPane.add(label);
	}
}
