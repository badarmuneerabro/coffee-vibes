package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainView {
	private static MainView mainView;
	private static int count = 1;
	private JFrame frmCoffeeVibes;
	private LoginInternalFrame loginFrame;
	private ProductInternalView productFrame;
	private JMenuItem msgMenuItem;

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
		frmCoffeeVibes.setBounds(100, 100, 850,795);
		frmCoffeeVibes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCoffeeVibes.getContentPane().setLayout(null);
		frmCoffeeVibes.setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 101, 22);
		frmCoffeeVibes.getContentPane().add(menuBar);
		
		JMenu acountItem = new JMenu("Acount");
		menuBar.add(acountItem);
		
		msgMenuItem = new JMenuItem("No Log In");
		acountItem.add(msgMenuItem);
		productFrame = new ProductInternalView();
		productFrame.setLocation(10, 47);
		loginFrame = new LoginInternalFrame();
		loginFrame.setBounds(238, 168, 448, 299);
		addFrames();
		openLoginFrame();
	}
	
	public void restore()
	{
		loginFrame = new LoginInternalFrame();
	}
	public void addFrames()
	{
		this.frmCoffeeVibes.getContentPane().add(productFrame);
		this.frmCoffeeVibes.getContentPane().add(loginFrame);
	}
	public static MainView getInstance()
	{
		System.out.println("Step 2");
		return (mainView == null) ? mainView = new MainView() : mainView;
	}
	public void openInternalFrame(JInternalFrame frame)
	{
		System.out.println("Hello, this is openInternalFrame().");
		Dimension jInternalFrameSize = frame.getSize();
		int width = (900 - jInternalFrameSize.width) / 2;
		int height = (785 - jInternalFrameSize.height) / 2;
		frame.setVisible(true);
	}
	public void openLoginFrame()
	{
		System.out.println("Step 3");
		openInternalFrame(loginFrame);
	}
	
	public void setText(String text)
	{
		this.msgMenuItem.setText("Hello, " + text);
	}
	public void openProductInternalVeiw()
	{
		openInternalFrame(productFrame);
	}
	public void setVisible()
	{
		frmCoffeeVibes.setVisible(true);
	}
}
