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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView {
	private static MainView mainView;
	private static int count = 1;
	private JFrame frmCoffeeVibes;
	private LoginInternalFrame loginFrame;
	private ProductInternalView productFrame;
	private ManagerInternalView managerFrame;
	private BaristaInternalView baristaFrame;
	private EmployeeView empFrame;
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
		msgMenuItem.setEnabled(false);
		acountItem.add(msgMenuItem);
		
		JMenuItem logOutMenuItem = new JMenuItem("Log Out");
		logOutMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				restore();
				openLoginFrame();
			}
		});
		acountItem.add(logOutMenuItem);
		productFrame = new ProductInternalView();
		//productFrame.setLocation(10, 47);
		loginFrame = new LoginInternalFrame();
		loginFrame.setBounds(238, 168, 448, 299);
		managerFrame = new ManagerInternalView();
		managerFrame.setSize(746, 589);
		empFrame = new EmployeeView();
		baristaFrame = new BaristaInternalView();
		baristaFrame.setLocation(10, 33);
		addFrames();
		openLoginFrame();
	}
	
	public void restore()
	{
		loginFrame.setVisible(false);
		productFrame.setVisible(false);
		managerFrame.setVisible(false);
		empFrame.setVisible(false);
		baristaFrame.setVisible(false);
		
		
		frmCoffeeVibes.remove(loginFrame);
		frmCoffeeVibes.remove(productFrame);
		frmCoffeeVibes.remove(managerFrame);
		frmCoffeeVibes.remove(empFrame);
		frmCoffeeVibes.remove(baristaFrame);
		
		
		loginFrame = new LoginInternalFrame();
		productFrame = new ProductInternalView();
		managerFrame = new ManagerInternalView();
		empFrame = new EmployeeView();
		baristaFrame = new BaristaInternalView();
		
		addFrames();
	}
	public void addFrames()
	{
		this.frmCoffeeVibes.getContentPane().add(productFrame);
		this.frmCoffeeVibes.getContentPane().add(loginFrame);
		this.frmCoffeeVibes.getContentPane().add(managerFrame);
		this.frmCoffeeVibes.getContentPane().add(empFrame);
		this.frmCoffeeVibes.getContentPane().add(baristaFrame);
	}
	public static MainView getInstance()
	{
		return (mainView == null) ? mainView = new MainView() : mainView;
	}
	public void openInternalFrame(JInternalFrame frame)
	{
		System.out.println("Step 3");
		Dimension jInternalFrameSize = frame.getSize();
		int width = (900 - jInternalFrameSize.width) / 2;
		int height = (785 - jInternalFrameSize.height) / 2;
		if(frame == baristaFrame)
		{
			frame.setLocation(10, 33);
			frame.setVisible(true);
			return;
		}
		
		frame.setLocation(width, height);
		frame.setVisible(true);
	}
	public void openLoginFrame()
	{
		openInternalFrame(loginFrame);
	}
	public void openManagerInternalView()
	{
		openInternalFrame(managerFrame);
	}
	
	public void setText(String text)
	{
		this.msgMenuItem.setText("Hello, " + text);
	}
	public void openProductInternalVeiw()
	{
		openInternalFrame(productFrame);
	}
	public void openEmployeeInternalView()
	{
		openInternalFrame(empFrame);
	}
	public void setVisible()
	{
		frmCoffeeVibes.setVisible(true);
	}
	public void openBaristaInternalView()
	{
		System.out.println("Step 2");
		openInternalFrame(baristaFrame);
	}
}
