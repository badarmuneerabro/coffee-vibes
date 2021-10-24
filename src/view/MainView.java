package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainView {
	private static MainView mainView;
	private JFrame frmCoffeeVibes;
	private LoginInternalFrame loginFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MainView window = new MainView();
					window.frmCoffeeVibes.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCoffeeVibes = new JFrame();
		frmCoffeeVibes.setTitle("Coffee vibes");
		frmCoffeeVibes.setBounds(100, 100, 708, 600);
		frmCoffeeVibes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCoffeeVibes.getContentPane().setLayout(null);
		frmCoffeeVibes.setLocationRelativeTo(null);
		
		loginFrame = new LoginInternalFrame();
		loginFrame.setLocation(111, 115);
		openLoginFrame();
	}
	
	public void restore()
	{
		loginFrame = new LoginInternalFrame();
	}
	public static MainView getInstance()
	{
		System.out.println("Hello, this is getInstance().");
		return (mainView == null) ? mainView = new MainView() : mainView;
	}
	
	public void openLoginFrame()
	{
		frmCoffeeVibes.getContentPane().add(loginFrame);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 51, 22);
		frmCoffeeVibes.getContentPane().add(menuBar);
		
		JMenu acountItem = new JMenu("Acount");
		menuBar.add(acountItem);
		
		JMenuItem msgMenuItem = new JMenuItem("No Log In");
		acountItem.add(msgMenuItem);
		loginFrame.setVisible(true);
	}
}
