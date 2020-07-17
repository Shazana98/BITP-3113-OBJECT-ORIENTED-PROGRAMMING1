package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.bookingManager;
import model.Booking;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class BookingPage extends JFrame {

	private JPanel contentPane;
	private JTextField textCheckIn;
	private JTextField textCheckOut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingPage frame = new BookingPage();
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
	public BookingPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textCheckOut = new JTextField();
		textCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textCheckOut.setColumns(10);
		textCheckOut.setBounds(391, 150, 106, 25);
		contentPane.add(textCheckOut);
		
		JLabel lblNewLabel = new JLabel("Check In");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(249, 114, 77, 25);
		contentPane.add(lblNewLabel);
		
		textCheckIn = new JTextField();
		textCheckIn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textCheckIn.setBounds(235, 150, 106, 25);
		contentPane.add(textCheckIn);
		textCheckIn.setColumns(10);
		
		JLabel lblCheckOut = new JLabel("Check Out");
		lblCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCheckOut.setBounds(395, 114, 91, 25);
		contentPane.add(lblCheckOut);
		
		JLabel lblNoRoom = new JLabel("No of room :");
		lblNoRoom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNoRoom.setBounds(287, 255, 85, 19);
		contentPane.add(lblNoRoom);
		
		JSpinner noRoom = new JSpinner();
		noRoom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		noRoom.setBounds(384, 252, 60, 26);
		contentPane.add(noRoom);
		
		JLabel lblAdults = new JLabel("Adults :");
		lblAdults.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdults.setBounds(323, 296, 49, 19);
		contentPane.add(lblAdults);
		
		JLabel lblChildren = new JLabel("Children :");
		lblChildren.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblChildren.setBounds(312, 326, 60, 19);
		contentPane.add(lblChildren);
		
		JSpinner adults = new JSpinner();
		adults.setFont(new Font("Tahoma", Font.PLAIN, 15));
		adults.setBounds(384, 289, 60, 26);
		contentPane.add(adults);
		
		JSpinner children = new JSpinner();
		children.setFont(new Font("Tahoma", Font.PLAIN, 15));
		children.setBounds(384, 326, 60, 26);
		contentPane.add(children);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String CheckIn_Date = textCheckIn.getText();
				String CheckOut_Date = textCheckOut.getText();
				int Total_room = (int) noRoom.getValue();
				int Adults = (int) adults.getValue();
				int Children = (int) children.getValue();
				
				Booking booking = new Booking();
				booking.setCheckIn_Date(CheckIn_Date);
				booking.setCheckOut_Date(CheckOut_Date);
				booking.setTotal_room(Total_room);
				booking.setAdults(Adults);
				booking.setChildren(Children);
				
				bookingManager BookingManager = new bookingManager();
				try {
					int success = BookingManager.insertBooking(booking);
					if(success>0)
					{
						JOptionPane.showMessageDialog(null,"Successfully add your booking!","Add Success",JOptionPane.INFORMATION_MESSAGE);
						
						CustomerDetails customerDetails = new CustomerDetails();
						customerDetails.setVisible(true);
						dispose();
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNext.setBounds(450, 411, 89, 23);
		contentPane.add(btnNext);
		
		JLabel mainBackground = new JLabel("");
		mainBackground.setBackground(Color.GRAY);
		mainBackground.setIcon(new ImageIcon("C:\\Users\\shaza\\Documents\\BITP 3113 Object Oriented\\Eclipse\\src\\view\\noname1.png"));
		mainBackground.setBounds(0, -14, 730, 745);
		contentPane.add(mainBackground);
	}
}
