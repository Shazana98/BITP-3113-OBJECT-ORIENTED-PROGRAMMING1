package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.customerManager;
import controller.userManager;
import model.Customer;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Table extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String[] column_cust = {"ID","NAME","ADDRESS","PHONE", "EMAIL"};
	private String[][] row_cust = new String[0][4];
	private JTextField textID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Table frame = new Table();
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
	public Table() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int id = Integer.parseInt(textID.getText());
			
			Customer cust = new Customer();
			cust.setId(id);
			
			customerManager CustomerManager = new customerManager();
			try {
					int success = CustomerManager.deleteCustomer(cust);
					if(success>0)
					{
						JOptionPane.showMessageDialog(null,"Successfully delete data into database.","Delete Success",JOptionPane.INFORMATION_MESSAGE);
						Table table = new Table();
						table.setVisible(true);
						dispose();
					}
				}catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();	
				}
		}
	});
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage adminPage = new AdminPage();
				adminPage.setVisible(true);
				dispose();
			}
			
		});
		btnBack.setBounds(248, 44, 89, 23);
		contentPane.add(btnBack);
		
		textID = new JTextField();
		textID.setBounds(402, 45, 86, 20);
		contentPane.add(textID);
		textID.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(373, 44, 28, 18);
		contentPane.add(lblId);
				
		btnDelete.setBounds(509, 44, 102, 23);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(94, 78, 530, 396);
		contentPane.add(scrollPane);
		
		try {
			showTableUser();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table = new JTable(row_cust, column_cust);
		scrollPane.setViewportView(table);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\shaza\\Documents\\BITP 3113 Object Oriented\\Eclipse\\src\\view\\noname1.png"));
		label_1.setBounds(0, 0, 704, 627);
		contentPane.add(label_1);
		
		
	}

	public void showTableUser() throws ClassNotFoundException, SQLException {
		customerManager CustomerManager = new customerManager();
		ArrayList<Customer> alCust = CustomerManager.selectAllCustomer();
		row_cust = new String[alCust.size()][5];
		
		for(int index = 0; index<alCust.size(); index++)
		{
			row_cust[index][0] = String.valueOf(alCust.get(index).getId());
			row_cust[index][1] = alCust.get(index).getName();
			row_cust[index][2] = alCust.get(index).getAddress();
			row_cust[index][3] = alCust.get(index).getPhone();
			row_cust[index][3] = alCust.get(index).getEmail();
		}
		
	}
}
