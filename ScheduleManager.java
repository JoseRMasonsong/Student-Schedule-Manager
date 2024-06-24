import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Image;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.ImageIcon;

public class ScheduleManager {
	
	public JFrame frmScheduleManager;
	public static JPasswordField textPasscode;
	public String passcode;
	public String FirstName;
	public String SInitials;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScheduleManager window = new ScheduleManager();
					window.frmScheduleManager.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ScheduleManager() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Class.forName("org.sqlite.JDBC");
				 Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\DB Browser for SQLite\\Bynum School Schedule.db");
				 Statement statement = connection.createStatement();
				 
				 passcode = textPasscode.getText();
				
				 ResultSet rs = statement.executeQuery("SELECT FirstName from Teacher where Passcode = '"+passcode+"'");
				 
				 
				 if(rs.next()) {
					 FirstName = rs.getString("FirstName");
					 JOptionPane.showMessageDialog(frmScheduleManager, "Hello " + FirstName + " Welcome!", "Successfull Login", JOptionPane.INFORMATION_MESSAGE );
					 ResultSet ps = statement.executeQuery("SELECT SInitials from Students where Passcode = '"+passcode+"'");
					 List<String> values = new ArrayList<>();
					 while(ps.next()) {
						 values.add(ps.getString(SInitials));
					 }
					 String[] choices = new String[values.size()];
					 values.toArray(choices);
					 JOptionPane.showInputDialog(null, "Choose a Student", "Student Selection", JOptionPane.PLAIN_MESSAGE, null, choices, choices[0]);
						textPasscode.setText(null);
					}
				 else {
					 JOptionPane.showMessageDialog(null, "Incorrect Login Information", "Login Error", JOptionPane.ERROR_MESSAGE);
						textPasscode.setText(null);

				 }
				
				

				
				
				 
				 
				
				}catch ( SQLException sqlException ) {
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
			
		});
		btnLogin.setBounds(76, 208, 89, 23);
		btnLogin.setFocusable(false);
		frmScheduleManager.getContentPane().add(btnLogin);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textPasscode.setText(null);
			}
		});
		btnClear.setBounds(209, 208, 89, 23);
		btnClear.setFocusable(false);
		frmScheduleManager.getContentPane().add(btnClear);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmScheduleManager = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmScheduleManager,  "Do you want to exit?", "Confirmation",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(337, 208, 89, 23);
		btnExit.setFocusable(false);
		frmScheduleManager.getContentPane().add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(37, 193, 416, 4);
		frmScheduleManager.getContentPane().add(separator);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(16, 9, 123, 70);
		ImageIcon icon = new ImageIcon("D:\\Pictures\\logomidlandclassical.jpg");
		Image image = icon.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH);
		lblLogo.setIcon(new ImageIcon(image));
		frmScheduleManager.getContentPane().add(lblLogo);
	}
}
