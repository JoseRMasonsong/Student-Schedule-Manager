import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.print.*;


public class ScheduleLogin extends JFrame implements ActionListener{
	
	public JFrame frmScheduleManager;
	public static JPasswordField textPasscode;
	public String passcode;
	public String FirstName;
	public String Initials;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScheduleLogin Application = new ScheduleLogin();
					Application.frmScheduleManager.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ScheduleLogin() {
		Login();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void Login() {
		frmScheduleManager = new JFrame();
		frmScheduleManager.setTitle("                                                    Schedule Manager");
		frmScheduleManager.setBounds(200, 200, 500, 300);
		frmScheduleManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmScheduleManager.setResizable(false);
		frmScheduleManager.getContentPane().setLayout(null);
		frmScheduleManager.setLocationRelativeTo(null);
		frmScheduleManager.setVisible(true);
		
		JLabel lblLoginSystem = new JLabel("Login Menu");
		lblLoginSystem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLoginSystem.setBorder(null);
		lblLoginSystem.setFocusable(false);
		lblLoginSystem.setBounds(220, 59, 79, 20);
		frmScheduleManager.getContentPane().add(lblLoginSystem);
		
		JLabel lblPasscode = new JLabel("Passcode:");
		lblPasscode.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPasscode.setBounds(68, 119, 49, 14);
		frmScheduleManager.getContentPane().add(lblPasscode);
		
		textPasscode = new JPasswordField();
		textPasscode.setBorder(null);
		textPasscode.setBounds(171, 116, 175, 20);
		frmScheduleManager.getContentPane().add(textPasscode);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(this);
		btnLogin.setBounds(76, 208, 89, 23);
		btnLogin.setFocusable(false);
		frmScheduleManager.getContentPane().add(btnLogin);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(this);
		btnClear.setBounds(209, 208, 89, 23);
		btnClear.setFocusable(false);
		frmScheduleManager.getContentPane().add(btnClear);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(this);
		btnExit.setBounds(337, 208, 89, 23);
		btnExit.setFocusable(false);
		frmScheduleManager.getContentPane().add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(37, 193, 416, 4);
		frmScheduleManager.getContentPane().add(separator);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(10, 6, 177, 102);
		ImageIcon icon = new ImageIcon("D:\\Pictures\\bynum school logo.png");
		Image image = icon.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH);
		lblLogo.setIcon(new ImageIcon(image));
		frmScheduleManager.getContentPane().add(lblLogo);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Login"))
		{
		ArrayList<String> options = new ArrayList<>();
		try {
		Class.forName("org.sqlite.JDBC");
		 Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\DB Browser for SQLite\\Bynum School Schedule.db");
		
		 Statement statement = connection.createStatement();
		 
		 passcode = textPasscode.getText();
			
		 ResultSet rs = statement.executeQuery("SELECT FirstName from Teacher where Passcode = '"+passcode+"'");
		 
		 if(rs.next()) {
			 FirstName = rs.getString("FirstName");
			 JOptionPane.showMessageDialog(frmScheduleManager, "Hello " + FirstName + " Welcome!", "Successful Login", JOptionPane.INFORMATION_MESSAGE );
			 ResultSet ps = statement.executeQuery("SELECT Initials FROM Students where Passcode = '"+passcode+"'");
			 while (ps.next()) {
			        options.add(rs.getString("initials"));
			    }
			 String[] optionsArray = options.toArray(new String[options.size()]);
			 String selectedInitials = (String) JOptionPane.showInputDialog(null, "Select a student:", "Student Selection", JOptionPane.QUESTION_MESSAGE, null, optionsArray, optionsArray[0]);
			 if (selectedInitials != null) {
				    Schedule.main(optionsArray);
			 }
		 else {
			 JOptionPane.showMessageDialog(null, "Incorrect Login Information", "Login Error", JOptionPane.ERROR_MESSAGE);
				textPasscode.setText(null);

		 }
		}
		}
		catch ( SQLException sqlException ) {
	         JOptionPane.showMessageDialog( null,
	            sqlException.getMessage(), "Database Error",
	            JOptionPane.ERROR_MESSAGE );
	         System.exit( 1 );
	      }
		catch(ClassNotFoundException cnfex) {
	          System.out.println("Problem in loading or "
	                  + "registering MS Access JDBC driver");
	          cnfex.printStackTrace();
	      }
		}
		else if(e.getActionCommand().equals("Clear"))
		{
			textPasscode.setText(null);
		}
		else if(e.getActionCommand().equals("Exit"))
		{
		frmScheduleManager = new JFrame("Exit");
		if(JOptionPane.showConfirmDialog(frmScheduleManager,  "Do you want to exit?", "Confirmation",
		JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
			System.exit(0);
			}
		}
		
	
}
}
