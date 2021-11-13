package view;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import controller.CartHandler;
import controller.ProductHandler;
import controller.TransactionHandler;
import controller.VoucherHandler;
import model.CartItem;
import model.Connect;
import model.Employee;
import model.Product;
import model.Transaction;
import model.TransactionItem;
import model.Voucher;

import javax.swing.JComboBox;

public class BaristaInternalView extends JInternalFrame {


	private JPanel contentPane;
	private JTable productTable;
	private JTextField priceTextField;
	private JTextField nameTextField;
	private JTextField quantityTextField;
	private JTable cartProductsTable;
	private JTextField cartTotalTextField;
	private JTextField voucherCodeTextField;
	private JTextField totalAmountTextField;
	private JScrollPane scrollPane;
	private JComboBox idComboBox;
	private TransactionHandler transactionHandler = TransactionHandler.getInstance();
	private JTable cartTable;
	private JComboBox idComboBox2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaristaInternalView frame = new BaristaInternalView();
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
	public BaristaInternalView() {
		setTitle("Check Out ");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		CardLayout cl = new CardLayout(0,0);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 757, 592);
		contentPane.add(panel);
		panel.setLayout(cl);
		
		
		JPanel checkoutPanel = new JPanel();
		checkoutPanel.setBounds(-10008, -10031, 747, 368);
		
		voucherCodeTextField = new JTextField();
		voucherCodeTextField.setBounds(199, 260, 190, 20);
		checkoutPanel.add(voucherCodeTextField);
		voucherCodeTextField.setColumns(10);
		
		
	    
		idComboBox = new JComboBox();
		idComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//filling text fields according to the change made.
				fillTextFields(nameTextField, priceTextField);
			}
		});
		JPanel productsPanel = new JPanel();
		productsPanel.setBounds(5, 5, 747, 368);
		productsPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 727, 117);
		productsPanel.add(scrollPane);
		
		productTable = new JTable();
		scrollPane.setViewportView(productTable);
		productTable.setModel(new DefaultTableModel(
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
		
		JLabel lblNewLabel = new JLabel("Product ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(84, 142, 76, 14);
		productsPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Price");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(418, 192, 54, 14);
		productsPanel.add(lblNewLabel_1);
		
		priceTextField = new JTextField();
		priceTextField.setEditable(false);
		priceTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		priceTextField.setBounds(517, 191, 220, 20);
		productsPanel.add(priceTextField);
		priceTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(84, 232, 46, 14);
		productsPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Product Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(84, 192, 88, 14);
		productsPanel.add(lblNewLabel_3);
		
		nameTextField = new JTextField();
		nameTextField.setEditable(false);
		nameTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameTextField.setBounds(183, 191, 220, 20);
		productsPanel.add(nameTextField);
		nameTextField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("In Cart");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(84, 232, 46, 14);
		productsPanel.add(lblNewLabel_4);
		cartProductsTable = new JTable();
		
		
		/*
		 * inserted CartTable here.....
		 */
		cartTable = new JTable();
		
		quantityTextField = new JTextField();
		quantityTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		quantityTextField.setBounds(183, 232, 220, 20);
		productsPanel.add(quantityTextField);
		quantityTextField.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure, you want to continue?", "Confirm", JOptionPane.YES_NO_OPTION);
				if(confirm == 1)
					return;
			    cl.next(panel);
			    
			    //here...
			    CartHandler handler = CartHandler.getInstance();
			    
			    int totalAmount = 0;
			    List<CartItem> items = handler.getList();
			    
			    for(CartItem i: items)
			    {
			    	totalAmount  = totalAmount +  (i.getProduct().getPrice() * i.getQuantity());
			    }
			    cartTotalTextField.setText(totalAmount + "");
			    totalAmountTextField.setText(totalAmount + "");
			    fillCartTable(cartProductsTable);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(599, 536, 110, 33);
		productsPanel.add(btnNewButton);
		
		JButton addToCartButton = new JButton("Add to cart");
		addToCartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(quantityTextField.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Quantity can not be empty.");
					return;
				}
				
				CartHandler handler = CartHandler.getInstance();
				int productID = Integer.parseInt(idComboBox.getSelectedItem().toString());
				int quantity = Integer.parseInt(quantityTextField.getText().trim());
				
				Product p = ProductHandler.getInstance().getProduct(productID);
				if(quantity > p.getStock())
				{
					JOptionPane.showMessageDialog(null, "Quantity is greater than stock");
					return;
				}
				if(handler.addToCart(productID, quantity) != null)
				{
					/*
					 * Adding items in the cart table.
					 */
					fillCartTable(cartTable);
					JOptionPane.showMessageDialog(null, "Added to Cart Successfully..");
					nameTextField.setText("");
					priceTextField.setText("");
					quantityTextField.setText("");
				}
				
			}
		});
		addToCartButton.setFont(new Font("Serif", Font.BOLD, 14));
		addToCartButton.setBounds(10, 536, 110, 33);
		productsPanel.add(addToCartButton);
		
		
		
		
		panel.add(productsPanel,"ProductPanel");
		panel.add(checkoutPanel,"CheckoutPanel");
		checkoutPanel.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Previous");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.previous(panel);
				fillTable(productTable);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(10, 344, 109, 23);
		checkoutPanel.add(btnNewButton_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 737, 137);
		checkoutPanel.add(scrollPane_1);
		
		scrollPane_1.setViewportView(cartProductsTable);
		cartProductsTable.setModel(new DefaultTableModel(
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
		
		JLabel lblNewLabel_6 = new JLabel("Cart Total");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(73, 210, 99, 14);
		checkoutPanel.add(lblNewLabel_6);
		
		cartTotalTextField = new JTextField();
		cartTotalTextField.setEditable(false);
		cartTotalTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cartTotalTextField.setBounds(199, 207, 190, 20);
		checkoutPanel.add(cartTotalTextField);
		cartTotalTextField.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Discount Voucher");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(73, 261, 117, 14);
		checkoutPanel.add(lblNewLabel_7);
		
		
		JLabel lblNewLabel_8 = new JLabel("Total Amount $");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(472, 311, 117, 14);
		checkoutPanel.add(lblNewLabel_8);
		
		totalAmountTextField = new JTextField();
		totalAmountTextField.setEditable(false);
		totalAmountTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		totalAmountTextField.setBounds(599, 310, 138, 20);
		checkoutPanel.add(totalAmountTextField);
		totalAmountTextField.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Check Out");
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent e) {
				update();
				voucherCodeTextField.setText("");
				fillCartTable(cartTable);
				fillTable(productTable);
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBounds(545, 346, 122, 23);
		checkoutPanel.add(btnNewButton_3);
		
		JButton applyVoucherButton = new JButton("Apply Voucher");
		applyVoucherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(voucherCodeTextField.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please enter VoucherID");
					return;
				}
				String voucherCode = voucherCodeTextField.getText();
				VoucherHandler handler = VoucherHandler.getInstance();
				List<Voucher> list = handler.getAllVouchers();
				
				int voucherID = 0;
				for(Voucher v: list)
				{
					if(v.getCode().equalsIgnoreCase(voucherCode))
					{
						if(v.getStatus().equalsIgnoreCase("unused"))
						{
							voucherID = v.getVoucherID();
							int totalAmount = Integer.parseInt(totalAmountTextField.getText());
							int disc = v.getDiscount();
							
							int newAmount = disc*totalAmount/100;
							totalAmountTextField.setText(newAmount + "");
							handler.updateVoucher(voucherID);
							JOptionPane.showMessageDialog(null, "Voucher Applied successfully..");
							return;
						}
					}
				}
				
				JOptionPane.showMessageDialog(null, "Can't apply voucher, check your voucher code.");
				
			}
		});
		applyVoucherButton.setBounds(442, 250, 122, 30);
		checkoutPanel.add(applyVoucherButton);
		
		
		//filling the table.
		fillTable(productTable);
		
		idComboBox.setBounds(183, 139, 131, 31);
		productsPanel.add(idComboBox);
		
		//filling idComboBox.
		fillComboBox(idComboBox);
		
		//filling textFields.
		fillTextFields(nameTextField, priceTextField);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 282, 727, 135);
		productsPanel.add(scrollPane_2);
		
		cartTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Description", "Price", "Quantity"
			}
		));
		scrollPane_2.setViewportView(cartTable);
		
		JButton removeButton = new JButton("Remove");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int productID = Integer.parseInt(idComboBox2.getSelectedItem().toString());
				
				List<CartItem> items = CartHandler.getInstance().getList();
				
				for(int i = 0; i<items.size(); i++)
				{
					if(items.get(i).getProduct().getProductID() == productID)
					{
						items.remove(i);
						fillCartTable(cartTable);
						JOptionPane.showMessageDialog(null, "Removed Successfully...");
						return;
					}
				}
			}
		});
		removeButton.setBounds(351, 448, 89, 26);
		productsPanel.add(removeButton);
		
		idComboBox2 = new JComboBox();
		idComboBox2.setBounds(215, 444, 99, 30);
		productsPanel.add(idComboBox2);
		
		JLabel lblNewLabel_5 = new JLabel("Remove Product: ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(89, 446, 117, 20);
		productsPanel.add(lblNewLabel_5);
	}
	
	public void update() {
		
		System.out.println("Hello from update().");
		CartHandler cartHandler = CartHandler.getInstance();
		List<CartItem> cartItems = cartHandler.getList();
		Employee employee = LoginInternalFrame.getLoggedInEmployee();
		
		TransactionHandler transactionHandler = null;
		String voucherCode = voucherCodeTextField.getText().trim();
		/*
		 * 
		 * Inserting voucher id.
		 */
//		int voucherID = 0;
//		List<Voucher> list = VoucherHandler.getInstance().getAllVouchers();
//		for(Voucher v: list)
//		{
//			if(v.getCode().equalsIgnoreCase(voucherCode))
//			{
//				voucherID = v.getVoucherID();
//				break;
//			}
//		}
		int price = 0 ;
		for(CartItem cartItem : cartItems) {
			cartHandler.updateProductStock(cartItem.getProduct().getProductID(),cartItem.getQuantity());
			price = Integer.parseInt(totalAmountTextField.getText());
		}
		
		/*
		 * Inserted the changes here....
		 */
		transactionHandler = TransactionHandler.getInstance();
		Transaction t = transactionHandler.insertTransaction(voucherCode,employee.getEmployeeID(),price,getTotalQuantity());
		List<Transaction> transactionList = transactionHandler.getAllTransactions();
		Transaction transaction = transactionList.get(transactionList.size()-1);
		insertTransactionDetails(transaction.getTransactionID());
			if(t != null)
			{
				JOptionPane.showMessageDialog(null,"Successfully Order is Palced."); 
			}
			cartHandler.clearCart();
	}
	
	public int getTotalQuantity() {
		int totalQuantity = 0;
		CartHandler cartHandler = CartHandler.getInstance();
		List<CartItem> cartItems = cartHandler.getList();
		for(CartItem cartItem : cartItems) {
			totalQuantity += cartItem.getQuantity();
		}
		return totalQuantity;
	}
	
	public void insertTransactionDetails(int transactionID) {
		CartHandler cartHandler = CartHandler.getInstance();
		List<CartItem> cartItems = cartHandler.getList();
		for(CartItem cartItem : cartItems) {
			TransactionItem transactionItem= new TransactionItem(transactionID,cartItem.getProduct().getProductID(),cartItem.getQuantity());
			transactionItem.insertIntoTransactionDetails();
		}
	}
	public void insertTransactionDetails() {
		DefaultTableModel cartTableModel = (DefaultTableModel) cartProductsTable.getModel();
		for(int i = 0; i < cartTableModel.getRowCount() ; i++) {
			Employee employee = LoginInternalFrame.getLoggedInEmployee();
			transactionHandler.insertTransaction(voucherCodeTextField.getText(), 
									employee.getEmployeeID(), Integer.parseInt(priceTextField.getText()));
		}
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
	
	public void fillCartTable(JTable table)
	{
		//here we are filling the cart table.
		CartHandler handler = CartHandler.getInstance();
		List<CartItem> items = handler.getList();
		if(items == null)
			return;
		Vector<String> headings = new Vector<>();
		headings.add("ID");
		headings.add("Name");
		headings.add("Description");
		headings.add("Price");
		headings.add("Quantity");
		
		
		DefaultTableModel model = new DefaultTableModel(headings, 0)
				{
					public boolean isCellEditable(int row, int column)
					{
						return false;
					}
				};
				
				
		for(CartItem i: items)
		{
			Vector<Object> v = new Vector<>();
			v.add(i.getProduct().getProductID());
			v.add(i.getProduct().getName());
			v.add(i.getProduct().getDescription());
			v.add(i.getProduct().getPrice());
			v.add(i.getQuantity());
			model.addRow(v);
		}
		
		table.setModel(model);
		
		DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>();
		
		for(CartItem i: items)
			comboModel.addElement(Integer.toString(i.getProduct().getProductID()));
		idComboBox2.setModel(comboModel);
		
	}
	public void fillComboBox(JComboBox cb)
	{
		List<Product> items = ProductHandler.getInstance().getAllProducts();
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		
		for(Product p: items)
			model.addElement(Integer.toString(p.getProductID()));
		cb.setModel(model);
	}
	
	public void fillTextFields(JTextField nameTextField, JTextField priceTextField)
	{
		if(idComboBox.getSelectedItem() == null) return;
		int productID = Integer.parseInt(idComboBox.getSelectedItem().toString());
		Product p = new Product();
		Product p2 = p.getProduct(productID);
		nameTextField.setText(p2.getName());
		priceTextField.setText(p2.getPrice() + "");
	}
}
