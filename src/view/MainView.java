package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import java.awt.BorderLayout;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainView {
	private static MainView mainView;
	private JFrame frmCoffeeVibes;
	private LoginInternalFrame loginFrame;
	private ProductInternalView productFrame;

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
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 101, 22);
		frmCoffeeVibes.getContentPane().add(menuBar);
		
		JMenu acountItem = new JMenu("Acount");
		menuBar.add(acountItem);
		
		JMenuItem msgMenuItem = new JMenuItem("No Log In");
		acountItem.add(msgMenuItem);
		loginFrame = new LoginInternalFrame();
		productFrame = new ProductInternalView();
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
	public void openInternalFrame(JInternalFrame frame)
	{
		frmCoffeeVibes.add(frame);
		frame.setVisible(true);
	}
	public void openLoginFrame()
	{
		openInternalFrame(loginFrame);
	}
	
	public void openProductInternalVeiw()
	{
		openInternalFrame(productFrame);
	}
}
