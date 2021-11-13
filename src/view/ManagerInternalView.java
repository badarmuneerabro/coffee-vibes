package view;

import java.awt.EventQueue;

import javax.swing.table.DefaultTableModel;

import controller.EmployeeHandler;
import controller.PositionHandler;
import controller.TransactionHandler;
import model.Connect;
import model.Employee;
import model.Position;
import model.Transaction;
import model.TransactionItem;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ManagerInternalView extends JInternalFrame {
	private JTable transactionTable;
	private JTable employeeManagementTable;
	private JPanel updatePanel;
	private JPanel firePanel;
	private JTabbedPane managerScreenTabbedPane;
	private TransactionHandler transactionHandler = TransactionHandler.getInstance();
	private List<Transaction> transactionList ;
	private DefaultTableModel transactionTableModel ;
	private Connect connection;
	private JComboBox<String> idComboBox1;
	private JComboBox<String> idComboBox2;
	private JEditorPane nameTextField1;
	private JEditorPane nameTextField2;
	private JEditorPane salaryTextField1;
	private JEditorPane salaryTextField2;
	private JEditorPane userNameTextField1;
	private JEditorPane userNameTextField2;
	private JComboBox<String> positionComboBox1;
	private JComboBox<String> positionComboBox2;
	private DefaultTableModel employeeManagementTableModel;
	private JTabbedPane updateAndFireTabbedPane;
	private int transactionID;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerInternalView frame = new ManagerInternalView();
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
	public ManagerInternalView() {
		setBounds(100, 100, 759, 600);
		getContentPane().setLayout(null);
		
		managerScreenTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		managerScreenTabbedPane.setBounds(0, 0, 743, 570);
		getContentPane().add(managerScreenTabbedPane);
		
		JPanel panel = new JPanel();
		managerScreenTabbedPane.addTab("Transaction Details", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane transactionScrollPane = new JScrollPane();
		transactionScrollPane.setBounds(10, 11, 718, 314);
		panel.add(transactionScrollPane);
		
		transactionTable = new JTable();
		transactionTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Transaction ID", "Purchase Date", "Voucher Code", "Total Price", "Employee ID", "Transaction Item"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		transactionTable.getColumnModel().getColumn(0).setResizable(false);
		transactionTable.getColumnModel().getColumn(0).setPreferredWidth(100);
		transactionTable.getColumnModel().getColumn(0).setMinWidth(18);
		transactionTable.getColumnModel().getColumn(1).setResizable(false);
		transactionTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		transactionTable.getColumnModel().getColumn(1).setMinWidth(18);
		transactionTable.getColumnModel().getColumn(2).setResizable(false);
		transactionTable.getColumnModel().getColumn(2).setPreferredWidth(100);
		transactionTable.getColumnModel().getColumn(2).setMinWidth(18);
		transactionTable.getColumnModel().getColumn(3).setResizable(false);
		transactionTable.getColumnModel().getColumn(3).setPreferredWidth(100);
		transactionTable.getColumnModel().getColumn(3).setMinWidth(18);
		transactionTable.getColumnModel().getColumn(4).setResizable(false);
		transactionTable.getColumnModel().getColumn(4).setPreferredWidth(100);
		transactionTable.getColumnModel().getColumn(4).setMinWidth(18);
		transactionScrollPane.setViewportView(transactionTable);
		
		JScrollPane transactionDetailTableScrollPane = new JScrollPane();
		transactionDetailTableScrollPane.setBounds(10, 336, 718, 195);
		panel.add(transactionDetailTableScrollPane);
		
		transactionDetailTable = new JTable();
		transactionDetailTableScrollPane.setViewportView(transactionDetailTable);
		transactionDetailTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Transaction ID", "Product ID", "Quantity"
			}
		));
		transactionDetailTable.getColumnModel().getColumn(0).setPreferredWidth(150);
		transactionDetailTable.getColumnModel().getColumn(0).setMinWidth(18);
		transactionDetailTable.getColumnModel().getColumn(1).setPreferredWidth(150);
		transactionDetailTable.getColumnModel().getColumn(1).setMinWidth(18);
		transactionDetailTable.getColumnModel().getColumn(2).setPreferredWidth(150);
		transactionDetailTable.getColumnModel().getColumn(2).setMinWidth(18);
		
		JPanel panel_1 = new JPanel();
		managerScreenTabbedPane.addTab("Employee Management", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 718, 161);
		panel_1.add(scrollPane);
		
		employeeManagementTable = new JTable();
		employeeManagementTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Employee ID", "Employee Position ID", "Employee Name", "Employee Status", "Employee Salary"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		employeeManagementTable.getColumnModel().getColumn(0).setPreferredWidth(120);
		employeeManagementTable.getColumnModel().getColumn(0).setMinWidth(18);
		employeeManagementTable.getColumnModel().getColumn(1).setPreferredWidth(120);
		employeeManagementTable.getColumnModel().getColumn(1).setMinWidth(18);
		employeeManagementTable.getColumnModel().getColumn(2).setPreferredWidth(120);
		employeeManagementTable.getColumnModel().getColumn(2).setMinWidth(18);
		employeeManagementTable.getColumnModel().getColumn(3).setPreferredWidth(120);
		employeeManagementTable.getColumnModel().getColumn(3).setMinWidth(18);
		employeeManagementTable.getColumnModel().getColumn(4).setPreferredWidth(120);
		employeeManagementTable.getColumnModel().getColumn(4).setMinWidth(18);
		scrollPane.setViewportView(employeeManagementTable);
		
		updateAndFireTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		updateAndFireTabbedPane.setBounds(10, 183, 718, 348);
		panel_1.add(updateAndFireTabbedPane);
		 
		
		updatePanel = new JPanel();
		updatePanel.setToolTipText("Update Employee ");
		updateAndFireTabbedPane.addTab("Update Employee", null, updatePanel, null);
		updatePanel.setLayout(null);
		
		JLabel nameLabel1 = new JLabel("Employee Name");
		nameLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameLabel1.setBounds(98, 78, 99, 20);
		updatePanel.add(nameLabel1);
		
		nameTextField1 = new JEditorPane();
		nameTextField1.setBounds(207, 78, 170, 20);
		updatePanel.add(nameTextField1);
		
		JLabel salaryLabel1 = new JLabel("Employee Salary");
		salaryLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		salaryLabel1.setBounds(92, 171, 101, 20);
		updatePanel.add(salaryLabel1);
		
		salaryTextField1 = new JEditorPane();
		salaryTextField1.setBounds(203, 171, 170, 20);
		updatePanel.add(salaryTextField1);
		
		JLabel positionLabel1 = new JLabel("Position Name");
		positionLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		positionLabel1.setBounds(111, 140, 86, 20);
		updatePanel.add(positionLabel1);
		
		positionComboBox1 = new JComboBox<String>();
		positionComboBox1.setModel(new DefaultComboBoxModel<String>());
		positionComboBox1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		positionComboBox1.setBounds(207, 140, 170, 22);
		updatePanel.add(positionComboBox1);
		
		JLabel idLabel1 = new JLabel("Employee ID");
		idLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idLabel1.setBounds(119, 47, 78, 20);
		updatePanel.add(idLabel1);
		
		idComboBox1 = new JComboBox<String>();		
		idComboBox1.setBounds(207, 45, 170, 22);
		updatePanel.add(idComboBox1);

		
		JLabel userNameLabel1 = new JLabel("Employee UserName");
		userNameLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userNameLabel1.setBounds(71, 109, 126, 20);
		updatePanel.add(userNameLabel1);
		
		userNameTextField1 = new JEditorPane();
		userNameTextField1.setBounds(207, 109, 170, 20);
		updatePanel.add(userNameTextField1);
		
		JButton updateEmployeeButton1 = new JButton("Update Employee Data");
		updateEmployeeButton1.setBounds(207, 215, 143, 23);
		updatePanel.add(updateEmployeeButton1);
		
		firePanel = new JPanel();
		firePanel.setToolTipText("Fire Employee");
		firePanel.setLayout(null);
		updateAndFireTabbedPane.addTab("Fire Employee", null, firePanel, null);
		
		JLabel nameLabel2 = new JLabel("Employee Name");
		nameLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameLabel2.setBounds(98, 78, 99, 20);
		firePanel.add(nameLabel2);
		
		nameTextField2 = new JEditorPane();
		nameTextField2.setEditable(false);
		nameTextField2.setBounds(207, 78, 170, 20);
		firePanel.add(nameTextField2);
		
		JLabel salaryLabel2 = new JLabel("Employee Salary");
		salaryLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		salaryLabel2.setBounds(92, 171, 101, 20);
		firePanel.add(salaryLabel2);
		
		salaryTextField2 = new JEditorPane();
		salaryTextField2.setEditable(false);
		salaryTextField2.setBounds(203, 171, 170, 20);
		firePanel.add(salaryTextField2);
		
		JLabel positionLabel2 = new JLabel("Employee Position ");
		positionLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		positionLabel2.setBounds(82, 140, 115, 20);
		firePanel.add(positionLabel2);
		
		positionComboBox2 = new JComboBox<String>();
		positionComboBox2.setModel(new DefaultComboBoxModel<String>());
		positionComboBox2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		positionComboBox2.setBounds(207, 140, 170, 22);
		firePanel.add(positionComboBox2);
		
		JLabel idLabel2 = new JLabel("Employee ID");
		idLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idLabel2.setBounds(119, 47, 78, 20);
		firePanel.add(idLabel2);
		
		idComboBox2 = new JComboBox<String>();
		idComboBox2.setBounds(207, 45, 170, 22);
		firePanel.add(idComboBox2);
		
		JLabel userNameLabel2 = new JLabel("Employee UserName");
		userNameLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userNameLabel2.setBounds(71, 109, 126, 20);
		firePanel.add(userNameLabel2);
		
		userNameTextField2 = new JEditorPane();
		userNameTextField2.setEditable(false);
		userNameTextField2.setBounds(207, 109, 170, 20);
		firePanel.add(userNameTextField2);
		
		JButton fireEmployeeButton = new JButton("Fire Employee");
		fireEmployeeButton.setBounds(207, 215, 143, 23);
		firePanel.add(fireEmployeeButton);
		
		fillTransactionTable();
		managerScreenTabbedPane.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if(managerScreenTabbedPane.getSelectedIndex() == 0) {
					fillTransactionTable();
				}else{
					fillEmployeeTable();
				}
				
			}
		});
		
		
		//here...
		fillIDComboBox(idComboBox1);
		fillIDComboBox(idComboBox2);
		fillPositionComboBox(positionComboBox1);
		fillPositionComboBox(positionComboBox2);
		fillUpdateEmployeeForm();
		fillFireEmployeeForm();
		
		idComboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillUpdateEmployeeForm();
			}
		});
		
		idComboBox2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				fillFireEmployeeForm();
				
			}
		});
		
		
		updateEmployeeButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(updateEmployee() != null)
					JOptionPane.showMessageDialog(null, "Updated Successfully...");
				fillEmployeeTable();
			}
		});
		
		
		fireEmployeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure, you want to fire?", "Confirm", JOptionPane.YES_NO_OPTION);
				if(confirm == 1)
					return;
				if(fireEmployee())
					JOptionPane.showMessageDialog(null, "Employee Fired...");
				fillIDComboBox(idComboBox2);
				fillEmployeeTable();
				
			}
		});
		
		ListSelectionModel selectionModel = transactionTable.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(e.getValueIsAdjusting()) {
					index = (Integer) selectionModel.getAnchorSelectionIndex();
					transactionID = Integer.parseInt(transactionTable.getValueAt(index, 0).toString());
					fillTransactionDetailTable(transactionID);
				}
			}
		});		
}
		
	
	//Transaction Table codding
	int index;
	private JTable transactionDetailTable;
	public void fillTransactionTable() {
		
		transactionTableModel= (DefaultTableModel)transactionTable.getModel();
		transactionTableModel.setRowCount(0);
		transactionList = transactionHandler.getAllTransactions();
		for(Transaction item : transactionList) {
			Object[] array = {item.getTransactionID(),item.getPurchaseDate(),item.getVoucherID(),item.getTotalPrice(),
										item.getEmployeeID(),item.getTransactionListItemNumber()};
			transactionTableModel.addRow(array);
		}
		
	}
	
	public void fillTransactionDetailTable(int transactionID) {
		DefaultTableModel transactionDetailTableModel = (DefaultTableModel) transactionDetailTable.getModel();
		transactionDetailTableModel.setRowCount(0);
		transactionList = transactionHandler.getAllTransactions();
		List<TransactionItem> list = TransactionItem.getAllTransactionItems(transactionID);
		for(TransactionItem item : list) {
			if(item != null) {
				Object[] transactionDetailArray = new Object[]{item.getTranscationID(),item.getProductID(),item.getQuantity()};
				transactionDetailTableModel.addRow(transactionDetailArray);
			}		
		}
	}
	
	
	
	
	public Employee updateEmployee() {
		int employeeID = Integer.parseInt(idComboBox1.getSelectedItem().toString());
		EmployeeHandler employeeHandler = EmployeeHandler.getInstance();
		String name = nameTextField1.getText();
		String userName = userNameTextField1.getText();
		int salary = Integer.parseInt(salaryTextField1.getText());
		String position = positionComboBox1.getSelectedItem().toString();
		Employee e = employeeHandler.getEmployee(employeeID);
		return employeeHandler.updateEmployee(employeeID, position, name, salary, userName, e.getPassword());
	}
	
	
	public boolean fireEmployee() {
		int employeeID = Integer.parseInt(idComboBox2.getSelectedItem().toString());
		EmployeeHandler employeeHandler = EmployeeHandler.getInstance();
		return employeeHandler.fireEmployee(employeeID);
		
	}
	
	public void fillIDComboBox(JComboBox comboBox) {
		Employee employee = new Employee();
		List<Employee> employeeList = employee.getAllEmployees();
		DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) comboBox.getModel();
		for(Employee emp : employeeList) {
			if(emp.getStatus().equalsIgnoreCase("Employed"))
				comboBoxModel.addElement(emp.getEmployeeID());
		}
	}
	
	public void fillPositionComboBox(JComboBox comboBox) {
		PositionHandler positionHandle = PositionHandler.getInstance();
		List<Position> positionList = positionHandle.getAllPositions();
		DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) comboBox.getModel();
		for(int i = 0 ; i < positionList.size() ; i++) {
			comboBoxModel.addElement(positionList.get(i).getPositionName());
		}
	}	
	
	public void fillEmployeeTable()
	{
		
		EmployeeHandler handler = EmployeeHandler.getInstance();
		List<Employee> allEmployees = handler.getAllEmployees();
		
		Vector<String> headings = new Vector<>();
		headings.add("ID");
		headings.add("Name");
		headings.add("Username");
		headings.add("Salary");
		headings.add("Position");
		headings.add("Status");
		
		DefaultTableModel model = new DefaultTableModel(headings, 0)
				{
					public boolean isCellEditable(int row, int column)
					{
						return false;
					}
				};
				
				
		for(Employee e: allEmployees)
		{
			Vector<Object> v = new Vector<>();
			v.add(e.getEmployeeID());
			v.add(e.getName());
			v.add(e.getUserName());
			v.add(e.getSalary());
			PositionHandler positionHandler = PositionHandler.getInstance();
			Position p = positionHandler.getPosition(e.getPositionID());
			v.add(p.getPositionName());
			v.add(e.getStatus());
			model.addRow(v);
		}
		
		employeeManagementTable.setModel(model);
	}
	
	public void fillUpdateEmployeeForm() {
		if(idComboBox1.getSelectedItem() == null) {
			fillFields("","","");
			return;
		}
		int employeeID = Integer.parseInt(idComboBox1.getSelectedItem().toString());
		EmployeeHandler employeeHandler = EmployeeHandler.getInstance();
		Employee employee = employeeHandler.getEmployee(employeeID);
		positionComboBox1.setSelectedIndex(employee.getPositionID()-1);
		fillFields(employee.getName(),employee.getUserName(),employee.getSalary()+"");
	}
	
	public void fillFireEmployeeForm() {
		if(idComboBox2.getSelectedItem() == null) {
			fillFields2("","","");
			return;
		}
		int employeeID = Integer.parseInt(idComboBox2.getSelectedItem().toString());
		EmployeeHandler employeeHandler = EmployeeHandler.getInstance();
		Employee employee = employeeHandler.getEmployee(employeeID);
		positionComboBox2.setSelectedIndex(employee.getPositionID()-1);
		fillFields2(employee.getName(),employee.getUserName(),employee.getSalary()+"");
	}
	
	public void fillFields(String name,String userName,String salary) {
		nameTextField1.setText(name);
		userNameTextField1.setText(userName);
		salaryTextField1.setText(salary);
	}
	
	public void fillFields2(String name,String userName,String salary) {
		nameTextField2.setText(name);
		userNameTextField2.setText(userName);
		salaryTextField2.setText(salary);
	}
}