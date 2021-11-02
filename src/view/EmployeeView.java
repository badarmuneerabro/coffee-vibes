package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.EmployeeHandler;
import controller.PositionHandler;
import controller.ProductHandler;
import model.Employee;
import model.Position;
import model.Product;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class EmployeeView extends JInternalFrame {
	private JTable empTable;
	private JTextField nameTextField;
	private JTextField salaryTextField;
	private JTextField userNameTextField;
	private JTextField nameTextField1;
	private JTextField salaryTextField1;
	private JTextField userNameTextField1;
	private JTextField nameTextField2;
	private JTextField salaryTextField2;
	private JTextField userNameTextField2;
	private JComboBox positionComboBox;
	private JComboBox positionComboBox2;
	private JComboBox idComboBox;
	private JTextField passwordTextField;
	private JComboBox idComboBox2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeView frame = new EmployeeView();
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
	public EmployeeView() {
		setTitle("Human Resource Department");
		setBounds(100, 100, 730, 600);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 666, 152);
		getContentPane().add(scrollPane);
		
		empTable = new JTable();
		scrollPane.setViewportView(empTable);
		empTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		empTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		
		idComboBox2 = new JComboBox();
		idComboBox = new JComboBox();
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 174, 666, 370);
		getContentPane().add(tabbedPane);
		
		JPanel addEmployee = new JPanel();
		tabbedPane.addTab("Add Employee", null, addEmployee, null);
		addEmployee.setLayout(null);
		
		JLabel nameLabel = new JLabel("Employee Name");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameLabel.setBounds(119, 37, 99, 17);
		addEmployee.add(nameLabel);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameTextField.setBounds(295, 37, 165, 23);
		addEmployee.add(nameTextField);
		nameTextField.setColumns(10);
		
		JLabel statusLabel = new JLabel("Employee Status");
		statusLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		statusLabel.setBounds(119, 80, 103, 17);
		addEmployee.add(statusLabel);
		
		positionComboBox = new JComboBox();
		positionComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		positionComboBox.setModel(new DefaultComboBoxModel(new String[] {"Manager"}));
		positionComboBox.setBounds(295, 76, 141, 25);
		addEmployee.add(positionComboBox);
		
		JLabel salaryLabel = new JLabel("Salary");
		salaryLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		salaryLabel.setBounds(119, 119, 37, 17);
		addEmployee.add(salaryLabel);
		
		salaryTextField = new JTextField();
		salaryTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		salaryTextField.setBounds(295, 116, 165, 23);
		addEmployee.add(salaryTextField);
		salaryTextField.setColumns(10);
		
		JLabel userNameLabel = new JLabel("Employee UserName");
		userNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userNameLabel.setBounds(119, 161, 126, 17);
		addEmployee.add(userNameLabel);
		
		userNameTextField = new JTextField();
		userNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userNameTextField.setBounds(295, 158, 165, 23);
		addEmployee.add(userNameTextField);
		userNameTextField.setColumns(10);
		
		JButton addEmployeeButton = new JButton("Insert");
		addEmployeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				EmployeeHandler handler = EmployeeHandler.getInstance();
				
				String empName = nameTextField.getText().trim();
				String position = positionComboBox.getSelectedItem().toString();
				String userName = userNameTextField.getText().trim();
				int salary = Integer.parseInt(salaryTextField.getText().trim());
				String password = generatePassword();
				
				if(handler.insertEmployee(empName, position, salary, userName, password) != null)
				{
					fillTextFields(nameTextField, "", userNameTextField, "", salaryTextField, "");
					fillComboBox(idComboBox);
					fillComboBox(idComboBox2);
					fillTable(empTable);
					JOptionPane.showMessageDialog(null, "Employee Inserted Successfullyy\n" + "UserName: " + userName + "\nPassword: " + password, "Confirmation", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				JOptionPane.showMessageDialog(null, "Insertion failed...", "ERROR", JOptionPane.ERROR_MESSAGE);
				
			}
		});
		addEmployeeButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addEmployeeButton.setBounds(288, 204, 103, 31);
		addEmployee.add(addEmployeeButton);
		
		
		
		//here....
		fillPositionComboBox(positionComboBox);
		
		JPanel updateEmployee = new JPanel();
		tabbedPane.addTab("Update Employee", null, updateEmployee, null);
		updateEmployee.setLayout(null);
		
		JLabel nameLabel1 = new JLabel("Employee Name");
		nameLabel1.setBounds(119, 112, 99, 17);
		nameLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		updateEmployee.add(nameLabel1);
		
		nameTextField1 = new JTextField();
		nameTextField1.setBounds(295, 112, 165, 23);
		nameTextField1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameTextField1.setColumns(10);
		updateEmployee.add(nameTextField1);
		
		JLabel statusLabel1 = new JLabel("Employee Status");
		statusLabel1.setBounds(119, 155, 103, 17);
		statusLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		updateEmployee.add(statusLabel1);
		
		positionComboBox2 = new JComboBox();
		positionComboBox2.setModel(new DefaultComboBoxModel(new String[] {"Manager"}));
		positionComboBox2.setBounds(295, 151, 165, 25);
		positionComboBox2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		updateEmployee.add(positionComboBox2);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(296, 62, 164, 25);
		updateEmployee.add(passwordTextField);
		passwordTextField.setColumns(10);
		
		JLabel salaryLabel1 = new JLabel("Salary");
		salaryLabel1.setBounds(119, 194, 37, 17);
		salaryLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		updateEmployee.add(salaryLabel1);
		
		salaryTextField1 = new JTextField();
		salaryTextField1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		salaryTextField1.setBounds(295, 191, 165, 23);
		salaryTextField1.setColumns(10);
		updateEmployee.add(salaryTextField1);
		
		JLabel userNameLabel1 = new JLabel("Employee UserName");
		userNameLabel1.setBounds(119, 236, 126, 17);
		userNameLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		updateEmployee.add(userNameLabel1);
		
		JButton updateButton = new JButton("Update");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				EmployeeHandler handler = EmployeeHandler.getInstance();
				
				int empID = Integer.parseInt(idComboBox.getSelectedItem().toString());
				String empName = nameTextField1.getText().trim();
				String userName = userNameTextField1.getText().trim();
				String pos = positionComboBox2.getSelectedItem().toString();
				int salary = Integer.parseInt(salaryTextField1.getText().trim());
				String password = passwordTextField.getText().trim();
				Employee emp = handler.updateEmployee(empID, pos, empName, salary, userName, password);
				if(emp != null)
				{
					JOptionPane.showMessageDialog(null, "Updated successfully...");
					fillTextFields(idComboBox);
					fillTable(empTable);
					return;
				}
				
				JOptionPane.showMessageDialog(null, "Can not update...");
				}
		});
		updateButton.setBounds(294, 278, 88, 30);
		updateButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		updateEmployee.add(updateButton);
		
		userNameTextField1 = new JTextField();
		userNameTextField1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userNameTextField1.setBounds(295, 233, 165, 23);
		userNameTextField1.setColumns(10);
		updateEmployee.add(userNameTextField1);
		
		JLabel lblNewLabel = new JLabel("Employee ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(119, 21, 99, 23);
		updateEmployee.add(lblNewLabel);
		
		
		idComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fillTextFields(idComboBox);
			}
		});
		idComboBox.setBounds(295, 21, 117, 30);
		updateEmployee.add(idComboBox);
		fillPositionComboBox(positionComboBox2);
		fillComboBox(idComboBox);
		
		//here..
		fillTextFields(idComboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(119, 62, 99, 25);
		updateEmployee.add(lblNewLabel_1);
		
		
		JPanel deleteEmployee = new JPanel();
		tabbedPane.addTab("Fire Employee", null, deleteEmployee, null);
		deleteEmployee.setLayout(null);
		
		JLabel nameLabel2 = new JLabel("Employee Name");
		nameLabel2.setBounds(119, 73, 99, 17);
		nameLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteEmployee.add(nameLabel2);
		
		nameTextField2 = new JTextField();
		nameTextField2.setBounds(295, 73, 165, 23);
		nameTextField2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameTextField2.setColumns(10);
		deleteEmployee.add(nameTextField2);
		
		JLabel statusLabel2 = new JLabel("Employee Status");
		statusLabel2.setBounds(119, 116, 103, 17);
		statusLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteEmployee.add(statusLabel2);
		
		JComboBox statusComboBox2 = new JComboBox();
		statusComboBox2.setModel(new DefaultComboBoxModel(new String[] {"Manager"}));
		statusComboBox2.setBounds(295, 112, 141, 25);
		statusComboBox2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteEmployee.add(statusComboBox2);
		
		JLabel salaryLabel2 = new JLabel("Salary");
		salaryLabel2.setBounds(119, 155, 37, 17);
		salaryLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteEmployee.add(salaryLabel2);
		
		salaryTextField2 = new JTextField();
		salaryTextField2.setBounds(295, 152, 165, 23);
		salaryTextField2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		salaryTextField2.setColumns(10);
		deleteEmployee.add(salaryTextField2);
		
		JLabel userNameLabel2 = new JLabel("Employee UserName");
		userNameLabel2.setBounds(119, 197, 126, 17);
		userNameLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteEmployee.add(userNameLabel2);
		
		JButton fireButton = new JButton("Fire");
		fireButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure, you want to fire?", "Confirm", JOptionPane.YES_NO_OPTION);
				if(confirm == 1)
					return;
				//event handler for firing an employee...
				EmployeeHandler handler = EmployeeHandler.getInstance();
				int empId = Integer.parseInt(idComboBox2.getSelectedItem().toString());
				
				if(handler.fireEmployee(empId))
				{
					JOptionPane.showMessageDialog(null, "Deleted Successfully...", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
					fillComboBox(idComboBox2);
					fillComboBox(idComboBox);
					fillTextFields2(idComboBox2);
					fillTable(empTable);
					return;
				}
				
				JOptionPane.showMessageDialog(null, "Failed to Delete");
			}
		});
		fireButton.setBounds(270, 240, 103, 32);
		fireButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteEmployee.add(fireButton);
		
		userNameTextField2 = new JTextField();
		userNameTextField2.setBounds(295, 194, 165, 23);
		userNameTextField2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userNameTextField2.setColumns(10);
		deleteEmployee.add(userNameTextField2);
		
		JLabel lblNewLabel_2 = new JLabel("Employee ID: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(119, 24, 99, 25);
		deleteEmployee.add(lblNewLabel_2);
		
		idComboBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				fillTextFields2(idComboBox2);
			}
		});
		idComboBox2.setBounds(295, 24, 114, 28);
		deleteEmployee.add(idComboBox2);
		
		//filling idComboBox2.
		
		fillComboBox(idComboBox2);
		fillTextFields2(idComboBox2);
		fillTable(empTable);
		
		

	}
	
	public void fillPositionComboBox(JComboBox cb)
	{
		List<Position> pos = PositionHandler.getInstance().getAllPositions();
		
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		for(Position p : pos)
			model.addElement(p.getPositionName());
		cb.setModel(model);
	}
	public void fillTextFields(JTextField nameTextField, String name, JTextField userNameTextField, String userName, JTextField salaryTextField, String salary)
	{
		nameTextField.setText(name);
		userNameTextField.setText(userName);
		salaryTextField.setText(salary);
		
	}
	
	public void fillTextFields2(JComboBox cb)
	{
		if(cb.getSelectedItem() == null)
		{
			System.out.println("Excuted...");
			fillTextFields(nameTextField2, "", userNameTextField2, "", salaryTextField2, "");
			return;
		}
		int empId = Integer.parseInt(cb.getSelectedItem().toString());
		Employee emp = new Employee();
		emp.setEmployeeID(empId);
		Employee gotEmployee = emp.getEmployee();
		fillTextFields(nameTextField2, gotEmployee.getName(), userNameTextField2, gotEmployee.getUserName(), salaryTextField2, gotEmployee.getSalary()+"");
		positionComboBox2.setSelectedIndex(gotEmployee.getPositionID()-1);
	}
	
	
	
	public void fillTextFields(JComboBox cb)
	{
		if(cb.getSelectedItem() == null)
		{
			fillTextFields(nameTextField1, "", userNameTextField1, "", salaryTextField1, "");
			return;
		}
		int empId = Integer.parseInt(cb.getSelectedItem().toString());
		Employee emp = new Employee();
		emp.setEmployeeID(empId);
		Employee gotEmployee = emp.getEmployee();
		
		if(cb == idComboBox)
			passwordTextField.setText(gotEmployee.getPassword());
		fillTextFields(nameTextField1, gotEmployee.getName(), userNameTextField1, gotEmployee.getUserName(), salaryTextField1, gotEmployee.getSalary()+"");
		positionComboBox2.setSelectedIndex(gotEmployee.getPositionID()-1);
	}
	public void fillComboBox(JComboBox cb)
	{
		
		List<Employee> emps = EmployeeHandler.getInstance().getAllEmployees();
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		
		for(Employee e: emps)
		{
			if(e.getStatus().equalsIgnoreCase("EMPLOYED"))
			model.addElement(Integer.toString(e.getEmployeeID()));
		}
		cb.setModel(model);
	}
	
	public String generatePassword()
	{
		Random r = new Random();
		Integer res = r.nextInt(99999999-12345678+1)+12345678;
		
		return res.toString();
	}
	
	public void fillTable(JTable table)
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
		
		System.out.println("Size: " + headings.size());
		
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
		
		table.setModel(model);
	}
}
