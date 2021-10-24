package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class ManagerView {

	private JFrame frame;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerView window = new ManagerView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManagerView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Manager");
		frame.setBounds(100, 100, 760, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 744, 501);
		frame.getContentPane().add(tabbedPane);
		
		JPanel reportPanel = new JPanel();
		tabbedPane.addTab("Transictions Details", null, reportPanel, null);
		reportPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Transications Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 37, 719, 396);
		reportPanel.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 21, 699, 364);
		panel.add(table);
		
		JPanel employeeManagementPanel = new JPanel();
		tabbedPane.addTab("Employee Management", null, employeeManagementPanel, null);
		employeeManagementPanel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 719, 451);
		employeeManagementPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 699, 140);
		panel_1.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 162, 699, 289);
		panel_1.add(tabbedPane_1);
		
		JPanel updateEmployeePanel = new JPanel();
		tabbedPane_1.addTab("Update Employee", null, updateEmployeePanel, null);
		
		JPanel fireEmployeePanel = new JPanel();
		tabbedPane_1.addTab("Fire Employee", null, fireEmployeePanel, null);
	}
}
