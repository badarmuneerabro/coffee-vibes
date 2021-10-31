package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckoutFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckoutFrame frame = new CheckoutFrame();
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
	public CheckoutFrame() {
		setTitle("Check Out ");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		CardLayout cl = new CardLayout(0,0);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 757, 378);
		contentPane.add(panel);
		panel.setLayout(cl);
		
		
//		JPanel panel_1 = new JPanel();
//		panel.add(panel_1, "name_173808326601200");
//		
//		JPanel panel_2 = new JPanel();
//		panel.add(panel_2, "name_173825344668600");
		
		
	    
		
		JPanel productsPanel = new JPanel();
		productsPanel.setBounds(5, 5, 747, 368);
		productsPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 727, 117);
		productsPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(183, 139, 220, 20);
		productsPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Product ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(84, 142, 76, 14);
		productsPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Price");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(84, 239, 54, 14);
		productsPanel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setBounds(183, 238, 220, 20);
		productsPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(84, 232, 46, 14);
		productsPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Product Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(84, 192, 88, 14);
		productsPanel.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setBounds(183, 191, 220, 20);
		productsPanel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("In Cart");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(84, 292, 46, 14);
		productsPanel.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_3.setBounds(183, 292, 220, 20);
		productsPanel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    cl.next(panel);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(648, 334, 89, 23);
		productsPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.setFont(new Font("Serif", Font.BOLD, 14));
		btnNewButton_1.setBounds(134, 334, 89, 23);
		productsPanel.add(btnNewButton_1);
		
		JPanel checkoutPanel = new JPanel();
		checkoutPanel.setBounds(-10008, -10031, 747, 368);
		
		
		
		panel.add(productsPanel,"ProductPanel");
		panel.add(checkoutPanel,"CheckoutPanel");
		checkoutPanel.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Previous");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.previous(panel);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(10, 344, 109, 23);
		checkoutPanel.add(btnNewButton_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 737, 137);
		checkoutPanel.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		
		JLabel lblNewLabel_5 = new JLabel("Customer Name");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(73, 172, 99, 14);
		checkoutPanel.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_4.setBounds(199, 166, 190, 20);
		checkoutPanel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Cart Total");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(73, 221, 99, 14);
		checkoutPanel.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_5.setBounds(199, 218, 190, 20);
		checkoutPanel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Discount Voucher");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(73, 272, 117, 14);
		checkoutPanel.add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		textField_6.setBounds(199, 271, 190, 20);
		checkoutPanel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Total Amount $");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(472, 311, 117, 14);
		checkoutPanel.add(lblNewLabel_8);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_7.setBounds(599, 310, 138, 20);
		checkoutPanel.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Pay Amount");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBounds(545, 346, 122, 23);
		checkoutPanel.add(btnNewButton_3);
		
		
		
	}
}
