package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Product;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductInternalView extends JInternalFrame {
	private JTable productTable;
	private JTextField nameTextField;
	private JTextField priceTextField;
	private JTextField stockTextField;
	private JTextField nameTextField2;
	private JTextField priceTextField2;
	private JTextField stockTextField2;
	private JTextField nameTextField3;
	private JTextField priceTextField3;
	private JTextField stockTextField3;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductInternalView frame = new ProductInternalView();
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
	public ProductInternalView() {
		setTitle("Product Admin");
		setBounds(100, 100, 790, 650);
		getContentPane().setLayout(null);
		
		JTabbedPane outerTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		outerTabbedPane.setBounds(10, 11, 754, 598);
		getContentPane().add(outerTabbedPane);
		
		JPanel productPanel = new JPanel();
		outerTabbedPane.addTab("Product", null, productPanel, null);
		productPanel.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 11, 708, 204);
		productPanel.add(scrollPane_3);
		
		productTable = new JTable();
		scrollPane_3.setViewportView(productTable);
		productTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Product ID", "New column", "New column", "New column", "New column"
			}
		));
		
		JTabbedPane innerTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		innerTabbedPane.setBounds(10, 250, 729, 309);
		productPanel.add(innerTabbedPane);
		
		JPanel insertPanel = new JPanel();
		innerTabbedPane.addTab("Insert", null, insertPanel, null);
		insertPanel.setLayout(null);
		
		JLabel productNameLabel = new JLabel("Product Name:");
		productNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		productNameLabel.setBounds(10, 29, 110, 25);
		insertPanel.add(productNameLabel);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameTextField.setBounds(153, 29, 154, 25);
		insertPanel.add(nameTextField);
		nameTextField.setColumns(10);
		
		JLabel descriptionLabel = new JLabel("Product Description:");
		descriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		descriptionLabel.setBounds(10, 78, 133, 25);
		insertPanel.add(descriptionLabel);
		
		JLabel priceLabel = new JLabel("Product Price: ");
		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		priceLabel.setBounds(10, 167, 110, 25);
		insertPanel.add(priceLabel);
		
		priceTextField = new JTextField();
		priceTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		priceTextField.setBounds(153, 167, 78, 30);
		insertPanel.add(priceTextField);
		priceTextField.setColumns(10);
		
		JLabel stockLabel = new JLabel("Product Stock: ");
		stockLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		stockLabel.setBounds(10, 220, 110, 25);
		insertPanel.add(stockLabel);
		
		stockTextField = new JTextField();
		stockTextField.setBounds(153, 217, 78, 30);
		insertPanel.add(stockTextField);
		stockTextField.setColumns(10);
		
		JButton insertButton = new JButton("Insert");
		insertButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		insertButton.setBounds(612, 240, 102, 30);
		insertPanel.add(insertButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(153, 67, 200, 72);
		insertPanel.add(scrollPane);
		
		JTextArea descriptionTextArea = new JTextArea();
		scrollPane.setViewportView(descriptionTextArea);
		descriptionTextArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		descriptionTextArea.setLineWrap(true);
		

		JPanel updatePanel = new JPanel();
		innerTabbedPane.addTab("Update", null, updatePanel, null);
		updatePanel.setLayout(null);
		
		JLabel nameLabel = new JLabel("Product Name: ");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameLabel.setBounds(10, 54, 106, 33);
		updatePanel.add(nameLabel);
		
		nameTextField2 = new JTextField();
		nameTextField2.setBounds(157, 57, 158, 31);
		updatePanel.add(nameTextField2);
		nameTextField2.setColumns(10);
		
		JLabel descriptionLabel2 = new JLabel("Product Description: ");
		descriptionLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		descriptionLabel2.setBounds(10, 98, 137, 25);
		updatePanel.add(descriptionLabel2);
		
		JLabel idLabel = new JLabel("Employee ID: ");
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idLabel.setBounds(10, 11, 106, 32);
		updatePanel.add(idLabel);
		
		JComboBox idComboBox = new JComboBox();
		idComboBox.setBounds(157, 11, 142, 35);
		updatePanel.add(idComboBox);
		
		JLabel priceLabel2 = new JLabel("Product Price: ");
		priceLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		priceLabel2.setBounds(10, 190, 106, 25);
		updatePanel.add(priceLabel2);
		
		priceTextField2 = new JTextField();
		priceTextField2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		priceTextField2.setBounds(157, 187, 86, 32);
		updatePanel.add(priceTextField2);
		priceTextField2.setColumns(10);
		
		JLabel stockLabel2 = new JLabel("Product Stock: ");
		stockLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		stockLabel2.setBounds(10, 226, 106, 31);
		updatePanel.add(stockLabel2);
		
		stockTextField2 = new JTextField();
		stockTextField2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		stockTextField2.setBounds(157, 230, 86, 31);
		updatePanel.add(stockTextField2);
		stockTextField2.setColumns(10);
		
		JButton updateButton = new JButton("Update");
		updateButton.setBounds(615, 239, 99, 31);
		updatePanel.add(updateButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(157, 99, 233, 72);
		updatePanel.add(scrollPane_1);
		
		JTextArea descriptionTextArea2 = new JTextArea();
		scrollPane_1.setViewportView(descriptionTextArea2);
		descriptionTextArea2.setFont(new Font("Monospaced", Font.PLAIN, 14));
		
		JPanel deletePanel = new JPanel();
		innerTabbedPane.addTab("Delete", null, deletePanel, null);
		deletePanel.setLayout(null);
		
		JLabel idLabel2 = new JLabel("Employee ID: ");
		idLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idLabel2.setBounds(10, 11, 106, 32);
		deletePanel.add(idLabel2);
		
		JComboBox idComboBox2 = new JComboBox();
		idComboBox2.setBounds(158, 12, 142, 35);
		deletePanel.add(idComboBox2);
		
		nameTextField3 = new JTextField();
		nameTextField3.setEditable(false);
		nameTextField3.setColumns(10);
		nameTextField3.setBounds(158, 58, 158, 31);
		deletePanel.add(nameTextField3);
		
		JLabel nameLabel3 = new JLabel("Product Name: ");
		nameLabel3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameLabel3.setBounds(10, 54, 106, 33);
		deletePanel.add(nameLabel3);
		
		JLabel descriptionLabel3 = new JLabel("Product Description: ");
		descriptionLabel3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		descriptionLabel3.setBounds(10, 98, 137, 25);
		deletePanel.add(descriptionLabel3);
		
		JTextArea descriptionTextArea3 = new JTextArea();
		descriptionTextArea3.setEditable(false);
		descriptionTextArea3.setFont(new Font("Monospaced", Font.PLAIN, 14));
		descriptionTextArea3.setBounds(158, 100, 231, 70);
		deletePanel.add(descriptionTextArea3);
		
		priceTextField3 = new JTextField();
		priceTextField3.setEditable(false);
		priceTextField3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		priceTextField3.setColumns(10);
		priceTextField3.setBounds(158, 181, 86, 32);
		deletePanel.add(priceTextField3);
		
		JLabel priceLabel3 = new JLabel("Product Price: ");
		priceLabel3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		priceLabel3.setBounds(10, 190, 106, 25);
		deletePanel.add(priceLabel3);
		
		JLabel stockLabel2_1 = new JLabel("Product Stock: ");
		stockLabel2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		stockLabel2_1.setBounds(10, 226, 106, 31);
		deletePanel.add(stockLabel2_1);
		
		stockTextField3 = new JTextField();
		stockTextField3.setEditable(false);
		stockTextField3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		stockTextField3.setColumns(10);
		stockTextField3.setBounds(158, 224, 86, 31);
		deletePanel.add(stockTextField3);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure, you want to delete?", "Confirm", JOptionPane.YES_NO_OPTION);
				if(confirm == 1)
					return;
				int productID = 
				Product p = new Product();
				p.setProductID();
			}
		});
		deleteButton.setBounds(615, 239, 99, 31);
		deletePanel.add(deleteButton);
		
		JPanel voucherPanel = new JPanel();
		outerTabbedPane.addTab("Voucher", null, voucherPanel, null);
		voucherPanel.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 729, 210);
		voucherPanel.add(scrollPane_2);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		scrollPane_2.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 248, 729, 311);
		voucherPanel.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Generate Voucher", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 11, 277, 289);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel voucherLabel = new JLabel("Voucher Discount: ");
		voucherLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		voucherLabel.setBounds(10, 27, 125, 26);
		panel_1.add(voucherLabel);
		
		textField = new JTextField();
		textField.setBounds(145, 29, 98, 26);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton generateButton = new JButton("Generate");
		generateButton.setBounds(10, 79, 98, 32);
		panel_1.add(generateButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Delete Voucher", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(357, 11, 351, 289);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel voucherId = new JLabel("Voucher ID: ");
		voucherId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		voucherId.setBounds(10, 31, 94, 31);
		panel_2.add(voucherId);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(114, 30, 146, 36);
		panel_2.add(comboBox);
		
		JLabel discountLabel = new JLabel("Discount:");
		discountLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		discountLabel.setBounds(10, 89, 94, 31);
		panel_2.add(discountLabel);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(114, 91, 86, 31);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel statusLabel = new JLabel("Status: ");
		statusLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		statusLabel.setBounds(10, 155, 76, 31);
		panel_2.add(statusLabel);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(114, 155, 86, 31);
		panel_2.add(textField_2);
		textField_2.setColumns(10);

	}
}
