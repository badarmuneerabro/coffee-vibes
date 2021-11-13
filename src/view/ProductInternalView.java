package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.ProductHandler;
import controller.VoucherHandler;
import model.Product;
import model.Voucher;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

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
	private JTable voucherTable;
	private JTextField discTextField;
	private JTextField voucherDiscountTextField;
	private JTextField voucherStatusTextField;
	private JTextField voucherCodeTextField;

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
		
		JComboBox idComboBox = new JComboBox();
		idComboBox.setBounds(157, 11, 142, 35);
		updatePanel.add(idComboBox);
		
		
		JPanel deletePanel = new JPanel();
		innerTabbedPane.addTab("Delete", null, deletePanel, null);
		deletePanel.setLayout(null);
		
		JTextArea descriptionTextArea3 = new JTextArea();
		descriptionTextArea3.setEditable(false);
		descriptionTextArea3.setFont(new Font("Monospaced", Font.PLAIN, 14));
		descriptionTextArea3.setBounds(158, 100, 231, 70);
		deletePanel.add(descriptionTextArea3);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(157, 99, 233, 72);
		updatePanel.add(scrollPane_1);
		
		JTextArea descriptionTextArea2 = new JTextArea();
		scrollPane_1.setViewportView(descriptionTextArea2);
		descriptionTextArea2.setFont(new Font("Monospaced", Font.PLAIN, 14));
		
		JComboBox idComboBox2 = new JComboBox();
		idComboBox2.setBounds(158, 12, 142, 35);
		deletePanel.add(idComboBox2);
		
		JButton insertButton = new JButton("Insert");
		insertButton.addActionListener(new ActionListener() {
			
			//inserting new product in the database.
			public void actionPerformed(ActionEvent e) 
			{
				ProductHandler handler = ProductHandler.getInstance();
				Product p = handler.insertProdcut(nameTextField.getText().trim(), descriptionTextArea.getText().trim(), Integer.parseInt(priceTextField.getText().trim()), Integer.parseInt(stockTextField.getText().trim()));
				if(p == null)
				{
					JOptionPane.showMessageDialog(null,  "Inserting faild, please insert data correctly.", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				JOptionPane.showMessageDialog(null,  "Inserted Successfully...", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
				nameTextField.setText("");
				descriptionTextArea.setText("");
				priceTextField.setText("");
				stockTextField.setText("");
				fillComboBox(idComboBox);
				fillComboBox(idComboBox2);
				fillTable(productTable);
				//fillTextFields(idComboBox, nameTextField, descriptionTextArea, priceTextField, stockTextField);
				fillTextFields(idComboBox2, nameTextField2, descriptionTextArea2, priceTextField2, stockTextField2);
				fillTextFields(idComboBox2, nameTextField3, descriptionTextArea3, priceTextField3, stockTextField3);
			}
		});
		insertButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		insertButton.setBounds(612, 240, 102, 30);
		insertPanel.add(insertButton);
		
		
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
		
		JLabel idLabel = new JLabel("Product ID:");
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idLabel.setBounds(10, 11, 106, 32);
		updatePanel.add(idLabel);
		
		
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
		updateButton.addActionListener(new ActionListener() {
			
			//updating product.
			public void actionPerformed(ActionEvent e) {
				
				ProductHandler handler = ProductHandler.getInstance();
				int productID = Integer.parseInt(idComboBox.getSelectedItem().toString());
				String name = nameTextField2.getText().trim();
				String description = descriptionTextArea2.getText().trim();
				int price = Integer.parseInt(priceTextField2.getText().trim());
				int stock = Integer.parseInt(stockTextField2.getText().trim());
				
				Product p = handler.updateProduct(productID, name, description, price, stock);
				if(p == null)
				{
					JOptionPane.showMessageDialog(null, "Update failed, insert data correctly", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Updated Successfully...", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
					nameTextField2.setText("");
					descriptionTextArea2.setText("");
					priceTextField2.setText("");
					stockTextField2.setText("");
					fillComboBox(idComboBox);
					fillComboBox(idComboBox2);
					fillTable(productTable);
					//fillTextFields(idComboBox, nameTextField, descriptionTextArea, priceTextField, stockTextField);
					fillTextFields(idComboBox2, nameTextField2, descriptionTextArea2, priceTextField2, stockTextField2);
					fillTextFields(idComboBox2, nameTextField3, descriptionTextArea3, priceTextField3, stockTextField3);
				}
			}
		});
		updateButton.setBounds(615, 239, 99, 31);
		updatePanel.add(updateButton);
		
		JLabel idLabel2 = new JLabel("Employee ID: ");
		idLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idLabel2.setBounds(10, 11, 106, 32);
		deletePanel.add(idLabel2);
		
		
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
				int productID = Integer.parseInt(idComboBox2.getSelectedItem().toString());
				ProductHandler handler = ProductHandler.getInstance();
				Product p = handler.deleteProduct(productID);
				if(p==null)
					{
					JOptionPane.showMessageDialog(null, "Delete Failed.", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
					}
				else
					JOptionPane.showMessageDialog(null, "Product Deleted Successfully...", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
				nameTextField3.setText("");
				descriptionTextArea3.setText("");
				priceTextField3.setText("");
				stockTextField3.setText("");
				fillComboBox(idComboBox);
				fillComboBox(idComboBox2);
				fillTable(productTable);
				//fillTextFields(idComboBox, nameTextField, descriptionTextArea, priceTextField, stockTextField);
				fillTextFields(idComboBox2, nameTextField2, descriptionTextArea2, priceTextField2, stockTextField2);
				fillTextFields(idComboBox2, nameTextField3, descriptionTextArea3, priceTextField3, stockTextField3);
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
		
		voucherTable = new JTable();
		voucherTable.setModel(new DefaultTableModel(
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
		scrollPane_2.setViewportView(voucherTable);
		
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
		
		discTextField = new JTextField();
		discTextField.setBounds(145, 29, 98, 26);
		panel_1.add(discTextField);
		discTextField.setColumns(10);
		
		voucherCodeTextField = new JTextField();
		voucherCodeTextField.setEditable(false);
		
		
		JComboBox voucherIDComboBox = new JComboBox();
		voucherIDComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fillFields(voucherIDComboBox, voucherDiscountTextField, voucherStatusTextField);
				
			}
		});
		
		
		JButton generateButton = new JButton("Generate");
		generateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VoucherHandler handler = VoucherHandler.getInstance();
				int discount = Integer.parseInt(discTextField.getText().trim());
				Voucher v = handler.insertVoucher(discount);
				
				if(v == null)
				{
					JOptionPane.showMessageDialog(null, "Error occured.", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				JOptionPane.showMessageDialog(null, "Voucher generated successfully.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
				discTextField.setText("");
				fillVoucherComboBox(voucherIDComboBox);
				fillVoucherTable(voucherTable);
				fillFields(voucherIDComboBox, voucherDiscountTextField, voucherStatusTextField);
				
			}
		});
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
		
		voucherIDComboBox.setBounds(114, 30, 146, 36);
		panel_2.add(voucherIDComboBox);
		
		JLabel discountLabel = new JLabel("Discount:");
		discountLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		discountLabel.setBounds(10, 89, 94, 31);
		panel_2.add(discountLabel);
		
		voucherDiscountTextField = new JTextField();
		voucherDiscountTextField.setEditable(false);
		voucherDiscountTextField.setBounds(114, 91, 86, 31);
		panel_2.add(voucherDiscountTextField);
		voucherDiscountTextField.setColumns(10);
		
		JLabel statusLabel = new JLabel("Status: ");
		statusLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		statusLabel.setBounds(10, 155, 76, 31);
		panel_2.add(statusLabel);
		
		voucherStatusTextField = new JTextField();
		voucherStatusTextField.setEditable(false);
		voucherStatusTextField.setBounds(114, 155, 86, 31);
		panel_2.add(voucherStatusTextField);
		voucherStatusTextField.setColumns(10);
		
		JButton voucherDeleteButton = new JButton("Delete");
		voucherDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure, you want to delete?", "Confirm", JOptionPane.YES_NO_OPTION);
				if(confirm == 1)
					return;
				
				VoucherHandler handler = VoucherHandler.getInstance();
				int voucherID = Integer.parseInt((voucherIDComboBox.getSelectedItem().toString()));
				if(handler.deleteVoucher(voucherID))
				{
					JOptionPane.showMessageDialog(null, "Deleted Successfully..", "Confirmation", JOptionPane.ERROR_MESSAGE);
					voucherDiscountTextField.setText("");
					voucherStatusTextField.setText("");
					fillVoucherComboBox(voucherIDComboBox);
					fillVoucherTable(voucherTable);
					fillFields(voucherIDComboBox, voucherDiscountTextField, voucherStatusTextField);
					return;
				}
				
				JOptionPane.showMessageDialog(null, "Failed to delete.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		});
		voucherDeleteButton.setBounds(252, 247, 89, 31);
		panel_2.add(voucherDeleteButton);
		
		
		idComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				int id = Integer.parseInt(idComboBox.getSelectedItem().toString());
				fillTextFields(idComboBox, nameTextField2, descriptionTextArea2, priceTextField2, stockTextField2);
			}
		});
		
		
		
		idComboBox2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				int id = Integer.parseInt(idComboBox.getSelectedItem().toString());
				fillTextFields(idComboBox2, nameTextField3, descriptionTextArea3, priceTextField3, stockTextField3);
			}
		});
		fillComboBox(idComboBox);
		fillComboBox(idComboBox2);
		fillTable(productTable);
		//fillTextFields(idComboBox, nameTextField, descriptionTextArea, priceTextField, stockTextField);
		fillTextFields(idComboBox2, nameTextField2, descriptionTextArea2, priceTextField2, stockTextField2);
		fillTextFields(idComboBox2, nameTextField3, descriptionTextArea3, priceTextField3, stockTextField3);
		
		fillVoucherComboBox(voucherIDComboBox);
		fillVoucherTable(voucherTable);
		fillFields(voucherIDComboBox, voucherDiscountTextField, voucherStatusTextField);
		
		JLabel codeLabel = new JLabel("Code:");
		codeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		codeLabel.setBounds(10, 215, 76, 22);
		panel_2.add(codeLabel);
		
		voucherCodeTextField.setBounds(114, 215, 101, 23);
		panel_2.add(voucherCodeTextField);
		voucherCodeTextField.setColumns(10);

	}
	
	public void fillComboBox(JComboBox cb)
	{
		List<Product> items = ProductHandler.getInstance().getAllProducts();
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		
		for(Product p: items)
			model.addElement(Integer.toString(p.getProductID()));
		cb.setModel(model);
	}
	
	public void fillTable(JTable table)
	{
		ProductHandler handler = ProductHandler.getInstance();
		List<Product> productItems = handler.getAllProducts();
		
		Vector<String> headings = new Vector<>();
		headings.add("ID");
		headings.add("Name");
		headings.add("Description");
		headings.add("Price");
		headings.add("Stock");
		
		System.out.println("Size: " + headings.size());
		
		DefaultTableModel model = new DefaultTableModel(headings, 0)
				{
					public boolean isCellEditable(int row, int column)
					{
						return false;
					}
				};
				
				
		for(Product p: productItems)
		{
			Vector<Object> v = new Vector<>();
			v.add(p.getProductID());
			v.add(p.getName());
			v.add(p.getDescription());
			v.add(p.getPrice());
			v.add(p.getStock());
			model.addRow(v);
		}
		
		table.setModel(model);
	}
	
	public void fillTextFields(JComboBox box, JTextField nameTextField, JTextArea textArea, JTextField priceTextField, JTextField stockTextField)
	{
		if(box.getSelectedItem() == null) return;
		int productID = Integer.parseInt(box.getSelectedItem().toString());
		Product p = new Product();
		Product p2 = p.getProduct(productID);
		nameTextField.setText(p2.getName());
		textArea.setText(p2.getDescription());
		priceTextField.setText(p2.getPrice() + "");
		stockTextField.setText(p2.getStock() + "");
		
	}
	
	public void fillVoucherComboBox(JComboBox box)
	{
		List<Voucher> items = VoucherHandler.getInstance().getAllVouchers();
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		
		for(Voucher p: items)
			model.addElement(Integer.toString(p.getVoucherID()));
		box.setModel(model);
	}
	
	public void fillVoucherTable(JTable table)
	{
		VoucherHandler handler = VoucherHandler.getInstance();
		List<Voucher> voucherItems = handler.getAllVouchers();
		
		Vector<String> headings = new Vector<>();
		headings.add("ID");
		headings.add("Code");
		headings.add("Discount");
		headings.add("Status");
		
		System.out.println("Size: " + headings.size());
		
		DefaultTableModel model = new DefaultTableModel(headings, 0)
				{
					public boolean isCellEditable(int row, int column)
					{
						return false;
					}
				};
				
				
		for(Voucher voucher: voucherItems)
		{
			Vector<Object> v = new Vector<>();
			v.add(voucher.getVoucherID());
			v.add(voucher.getCode());
			v.add(voucher.getDiscount() + "%");
			v.add(voucher.getStatus());
			model.addRow(v);
		}
		
		table.setModel(model);
	}
	public void fillFields(JComboBox box, JTextField discTextField, JTextField statusTextField)
	{
		if(box.getSelectedItem() == null) return;
		int voucherID = Integer.parseInt(box.getSelectedItem().toString());
		Voucher voucher = VoucherHandler.getInstance().getVoucher(voucherID);
		
		discTextField.setText(voucher.getDiscount() + "%");
		statusTextField.setText(voucher.getStatus() + "");
		voucherCodeTextField.setText(voucher.getCode());
	}
}
