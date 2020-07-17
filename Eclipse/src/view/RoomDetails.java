package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.roomManager;
import model.Room;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class RoomDetails extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomDetails frame = new RoomDetails();
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
	public RoomDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel (new String[] {" ", "Single Room - RM 80/night", "Double Room = RM 120/night", "Queen Room - RM 200/night", "King Room = RM 350/night"}));
		comboBox.setBounds(218, 157, 306, 31);
		contentPane.add(comboBox);
		
		JSpinner rate = new JSpinner();
		rate.setBackground(SystemColor.activeCaptionBorder);
		rate.setForeground(new Color(240, 240, 240));
		rate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rate.setBounds(279, 262, 154, 26);
		contentPane.add(rate);
		
		JLabel lblNewLabel = new JLabel("ROOM DETAILS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(191, 49, 175, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnContinue = new JButton("CONTINUE");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String typePrice = (String) comboBox.getSelectedItem();
				int rates = (int) rate.getValue();
				
				Room room = new Room();
				room.setRoomType(typePrice);
				room.setRate(rates);
				
				roomManager RoomManager = new roomManager();
				try {
					int success = RoomManager.insertRoom(room);
					if(success > 0)
					{
						PaymentDetails paymentDetails = new PaymentDetails();
						paymentDetails.setVisible(true);
						dispose();
					}
				}catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnContinue.setForeground(SystemColor.text);
		btnContinue.setBackground(SystemColor.textHighlight);
		btnContinue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnContinue.setBounds(279, 394, 154, 27);
		contentPane.add(btnContinue);
		
		JLabel lblNewLabel_1 = new JLabel("Room Type and Price");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(218, 127, 188, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblRate = new JLabel("Rate");
		lblRate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRate.setBounds(336, 227, 30, 19);
		contentPane.add(lblRate);
		
		JLabel mainBackground = new JLabel("");
		mainBackground.setIcon(new ImageIcon("C:\\Users\\shaza\\Documents\\BITP 3113 Object Oriented\\Eclipse\\src\\view\\noname1.png"));
		mainBackground.setBounds(0, -11, 751, 742);
		contentPane.add(mainBackground);
	}
}
