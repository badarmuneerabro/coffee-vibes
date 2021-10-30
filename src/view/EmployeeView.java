package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class EmployeeView extends JInternalFrame {
	private JTable table;
	private JTextField nameTextField;
	private JTextField salaryTextField;
	private JTextField userNameTextField;
	private JTextField nameTextField1;
	private JTextField salaryTextField1;
	private JTextField userNameTextField1;
	private JTextField nameTextField2;
	private JTextField salaryComboBox2;
	private JTextField userNameTextField2;

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
		setBounds(100, 100, 702, 506);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 666, 152);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 174, 666, 302);
		getContentPane().add(tabbedPane);
		
		JPanel addEmployee = new JPanel();
		tabbedPane.addTab("Add Employee", null, addEmployee, null);
		addEmployee.setLayout(null);
		
		JLabel nameLabel = new JLabel("Employee Name");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameLabel.setBounds(119, 19, 99, 17);
		addEmployee.add(nameLabel);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameTextField.setBounds(295, 19, 165, 23);
		addEmployee.add(nameTextField);
		nameTextField.setColumns(10);
		
		JLabel statusLabel = new JLabel("Employee Status");
		statusLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		statusLabel.setBounds(119, 62, 103, 17);
		addEmployee.add(statusLabel);
		
		JComboBox statusComboBox = new JComboBox();
		statusComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		statusComboBox.setModel(new DefaultComboBoxModel(new String[] {"Manager"}));
		statusComboBox.setBounds(295, 58, 141, 25);
		addEmployee.add(statusComboBox);
		
		JLabel salaryLabel = new JLabel("Salary");
		salaryLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		salaryLabel.setBounds(119, 101, 37, 17);
		addEmployee.add(salaryLabel);
		
		salaryTextField = new JTextField();
		salaryTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		salaryTextField.setBounds(295, 98, 165, 23);
		addEmployee.add(salaryTextField);
		salaryTextField.setColumns(10);
		
		JLabel userNameLabel = new JLabel("Employee UserName");
		userNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userNameLabel.setBounds(119, 143, 126, 17);
		addEmployee.add(userNameLabel);
		
		userNameTextField = new JTextField();
		userNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userNameTextField.setBounds(295, 140, 165, 23);
		addEmployee.add(userNameTextField);
		userNameTextField.setColumns(10);
		
		JButton addEmployeeButton = new JButton("Add New Employee");
		addEmployeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addEmployeeButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addEmployeeButton.setBounds(232, 186, 159, 23);
		addEmployee.add(addEmployeeButton);
		
		JPanel updateEmployee = new JPanel();
		tabbedPane.addTab("Update Employee", null, updateEmployee, null);
		updateEmployee.setLayout(null);
		
		JLabel nameLabel1 = new JLabel("Employee Name");
		nameLabel1.setBounds(119, 19, 99, 17);
		nameLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		updateEmployee.add(nameLabel1);
		
		nameTextField1 = new JTextField();
		nameTextField1.setBounds(295, 19, 165, 23);
		nameTextField1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameTextField1.setColumns(10);
		updateEmployee.add(nameTextField1);
		
		JLabel statusLabel1 = new JLabel("Employee Status");
		statusLabel1.setBounds(119, 62, 103, 17);
		statusLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		updateEmployee.add(statusLabel1);
		
		JComboBox statusComboBox1 = new JComboBox();
		statusComboBox1.setModel(new DefaultComboBoxModel(new String[] {"Manager"}));
		statusComboBox1.setBounds(295, 58, 141, 25);
		statusComboBox1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		updateEmployee.add(statusComboBox1);
		
		JLabel salaryLabel1 = new JLabel("Salary");
		salaryLabel1.setBounds(119, 101, 37, 17);
		salaryLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		updateEmployee.add(salaryLabel1);
		
		salaryTextField1 = new JTextField();
		salaryTextField1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		salaryTextField1.setBounds(295, 98, 165, 23);
		salaryTextField1.setColumns(10);
		updateEmployee.add(salaryTextField1);
		
		JLabel userNameLabel1 = new JLabel("Employee UserName");
		userNameLabel1.setBounds(119, 143, 126, 17);
		userNameLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		updateEmployee.add(userNameLabel1);
		
		JButton btnUpdateEmployee = new JButton("Update Employee");
		btnUpdateEmployee.setBounds(232, 186, 151, 25);
		btnUpdateEmployee.setFont(new Font("Tahoma", Font.PLAIN, 14));
		updateEmployee.add(btnUpdateEmployee);
		
		userNameTextField1 = new JTextField();
		userNameTextField1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userNameTextField1.setBounds(295, 140, 165, 23);
		userNameTextField1.setColumns(10);
		updateEmployee.add(userNameTextField1);
		
		JPanel deleteEmployee = new JPanel();
		tabbedPane.addTab("Fire Employee", null, deleteEmployee, null);
		deleteEmployee.setLayout(null);
		
		JLabel nameLabel2 = new JLabel("Employee Name");
		nameLabel2.setBounds(119, 19, 99, 17);
		nameLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteEmployee.add(nameLabel2);
		
		nameTextField2 = new JTextField();
		nameTextField2.setBounds(295, 19, 165, 23);
		nameTextField2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameTextField2.setColumns(10);
		deleteEmployee.add(nameTextField2);
		
		JLabel statusLabel2 = new JLabel("Employee Status");
		statusLabel2.setBounds(119, 62, 103, 17);
		statusLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteEmployee.add(statusLabel2);
		
		JComboBox statusComboBox2 = new JComboBox();
		statusComboBox2.setModel(new DefaultComboBoxModel(new String[] {"Manager"}));
		statusComboBox2.setBounds(295, 58, 141, 25);
		statusComboBox2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteEmployee.add(statusComboBox2);
		
		JLabel salaryLabel2 = new JLabel("Salary");
		salaryLabel2.setBounds(119, 101, 37, 17);
		salaryLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteEmployee.add(salaryLabel2);
		
		salaryComboBox2 = new JTextField();
		salaryComboBox2.setBounds(295, 98, 165, 23);
		salaryComboBox2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		salaryComboBox2.setColumns(10);
		deleteEmployee.add(salaryComboBox2);
		
		JLabel userNameLabel2 = new JLabel("Employee UserName");
		userNameLabel2.setBounds(119, 143, 126, 17);
		userNameLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteEmployee.add(userNameLabel2);
		
		JButton btnFireEmployee = new JButton("Fire Employee");
		btnFireEmployee.setBounds(232, 186, 141, 25);
		btnFireEmployee.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteEmployee.add(btnFireEmployee);
		
		userNameTextField2 = new JTextField();
		userNameTextField2.setBounds(295, 140, 165, 23);
		userNameTextField2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userNameTextField2.setColumns(10);
		deleteEmployee.add(userNameTextField2);

	}
}
