package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;

public class ManagerInternalView extends JInternalFrame {
	private JTable table;
	private JTable table_1;

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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 743, 570);
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Transaction Details", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 718, 520);
		panel.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		table.getColumnModel().getColumn(0).setMinWidth(18);
		scrollPane_1.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Employee Management", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 718, 161);
		panel_1.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table_1);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 183, 718, 348);
		panel_1.add(tabbedPane_1);
		 
		
		JPanel updatePanel = new JPanel();
		tabbedPane_1.addTab("Update Employee", null, updatePanel, null);
		updatePanel.setLayout(null);
		
		JLabel nameLabel1 = new JLabel("Employee Name");
		nameLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameLabel1.setBounds(98, 78, 99, 20);
		updatePanel.add(nameLabel1);
		
		JEditorPane nameTextField1 = new JEditorPane();
		nameTextField1.setBounds(207, 78, 170, 20);
		updatePanel.add(nameTextField1);
		
		JLabel salaryLabel1 = new JLabel("Employee Salary");
		salaryLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		salaryLabel1.setBounds(92, 171, 101, 20);
		updatePanel.add(salaryLabel1);
		
		JEditorPane salaryTextField1 = new JEditorPane();
		salaryTextField1.setBounds(203, 171, 170, 20);
		updatePanel.add(salaryTextField1);
		
		JLabel positionLabel1 = new JLabel("Employee Position ");
		positionLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		positionLabel1.setBounds(82, 140, 115, 20);
		updatePanel.add(positionLabel1);
		JComboBox<String> positionComboBox1 = new JComboBox<String>();
		positionComboBox1.setModel(new DefaultComboBoxModel<String>(new String[] {"Human Resource", "Manager", "Storage Management", "Promo Management", "Cashier"}));
		positionComboBox1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		positionComboBox1.setBounds(207, 140, 170, 22);
		updatePanel.add(positionComboBox1);
		
		JLabel idLabel1 = new JLabel("Employee ID");
		idLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idLabel1.setBounds(119, 47, 78, 20);
		updatePanel.add(idLabel1);
		
		JComboBox<String> idComboBox1 = new JComboBox<String>();
		idComboBox1.setBounds(207, 45, 170, 22);
		updatePanel.add(idComboBox1);
		
		JLabel userNameLabel1 = new JLabel("Employee UserName");
		userNameLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userNameLabel1.setBounds(71, 109, 126, 20);
		updatePanel.add(userNameLabel1);
		
		JEditorPane userNameTextField1 = new JEditorPane();
		userNameTextField1.setBounds(207, 109, 170, 20);
		updatePanel.add(userNameTextField1);
		
		JButton updateEmployeeButton1 = new JButton("Update Employee Data");
		updateEmployeeButton1.setBounds(207, 215, 143, 23);
		updatePanel.add(updateEmployeeButton1);
		
		JPanel firePanel = new JPanel();
		firePanel.setLayout(null);
		tabbedPane_1.addTab("New tab", null, firePanel, null);
		
		JLabel nameLabel2 = new JLabel("Employee Name");
		nameLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameLabel2.setBounds(98, 78, 99, 20);
		firePanel.add(nameLabel2);
		
		JEditorPane nameTextField2 = new JEditorPane();
		nameTextField2.setBounds(207, 78, 170, 20);
		firePanel.add(nameTextField2);
		
		JLabel salaryLabel2 = new JLabel("Employee Salary");
		salaryLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		salaryLabel2.setBounds(92, 171, 101, 20);
		firePanel.add(salaryLabel2);
		
		JEditorPane salaryTextField2 = new JEditorPane();
		salaryTextField2.setBounds(203, 171, 170, 20);
		firePanel.add(salaryTextField2);
		
		JLabel positionLabel2 = new JLabel("Employee Position ");
		positionLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		positionLabel2.setBounds(82, 140, 115, 20);
		firePanel.add(positionLabel2);
		
		JComboBox<String> positionComboBox2 = new JComboBox<String>();
		positionComboBox2.setModel(new DefaultComboBoxModel<String>(new String[] {"Human Resource", "Manager", "Storage Management", "Promo Management", "Cashier"}));
		positionComboBox2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		positionComboBox2.setBounds(207, 140, 170, 22);
		firePanel.add(positionComboBox2);
		
		JLabel idLabel2 = new JLabel("Employee ID");
		idLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idLabel2.setBounds(119, 47, 78, 20);
		firePanel.add(idLabel2);
		
		JComboBox<String> idCmboBox2 = new JComboBox<String>();
		idCmboBox2.setBounds(207, 45, 170, 22);
		firePanel.add(idCmboBox2);
		
		JLabel userNameLabel2 = new JLabel("Employee UserName");
		userNameLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userNameLabel2.setBounds(71, 109, 126, 20);
		firePanel.add(userNameLabel2);
		
		JEditorPane userNameTextFiel2 = new JEditorPane();
		userNameTextFiel2.setBounds(207, 109, 170, 20);
		firePanel.add(userNameTextFiel2);
		
		JButton fireEmployeeButton = new JButton("Fire Employee");
		fireEmployeeButton.setBounds(207, 215, 143, 23);
		firePanel.add(fireEmployeeButton);
		
		
		

	}
}
