import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.print.*;


public class Schedule extends JFrame implements ActionListener {

	public JFrame frmScheduleManager;
	
	public static String passcode;
	public String Initials;
	public static String studentID;
	public static String Monday;
	public static String Tuesday;
	public static String Wednesday;
	public static String Thursday;
	public static String Friday;
	
	public JTextField textStudentInitialsField;
	public JTextField textStudentIdField;
	public static JTextField M1;
	public static JTextField T1;
	public static JTextField W1;
	public static JTextField TH1;
	public static JTextField F1;
	public static JTextField M2;
	public static JTextField M3;
	public static JTextField M4;
	public static JTextField T2;
	public static JTextField T3;
	public static JTextField T4;
	public static JTextField W2;
	public static JTextField W3;
	public static JTextField W4;
	public static JTextField TH2;
	public static JTextField TH3;
	public static JTextField TH4;
	public static JTextField F2;
	public static JTextField F3;
	public static JTextField F4;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Schedule window = new Schedule();
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
	public Schedule() {
		StudentSchedule();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void StudentSchedule() {
		frmScheduleManager = new JFrame();
		frmScheduleManager.setFont(new Font("Dialog", Font.PLAIN, 18));
		frmScheduleManager.setTitle("                                                                                            Schedule Manager");
		frmScheduleManager.setBounds(100, 100, 850, 354);
		frmScheduleManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmScheduleManager.setResizable(false);
		frmScheduleManager.setLocationRelativeTo(null);
		frmScheduleManager.getContentPane().setLayout(null);
		
		textStudentInitialsField = new JTextField();
		textStudentInitialsField.setBounds(122, 26, 129, 20);
		textStudentInitialsField.setColumns(10);
		textStudentInitialsField.setBorder(null);
		frmScheduleManager.getContentPane().add(textStudentInitialsField);
		
		textStudentIdField = new JTextField();
		textStudentIdField.setBounds(333, 26, 129, 20);
		textStudentIdField.setColumns(10);
		textStudentIdField.setBorder(null);
		frmScheduleManager.getContentPane().add(textStudentIdField);
		
		JLabel lblStudentInitials = new JLabel("Student Initials:");
		lblStudentInitials.setBounds(23, 28, 107, 17);
		lblStudentInitials.setBorder(null);
		lblStudentInitials.setFocusable(false);
		lblStudentInitials.getPreferredSize();
		frmScheduleManager.getContentPane().add(lblStudentInitials);
		
		JLabel lblStudentid = new JLabel("Student ID:");
		lblStudentid.setBounds(261, 28, 90, 17);
		lblStudentid.setBorder(null);
		lblStudentid.setFocusable(false);
		lblStudentid.getPreferredSize();
		frmScheduleManager.getContentPane().add(lblStudentid);
		
		JButton btnCreateButton = new JButton("Create");
		btnCreateButton.setBounds(689, 110, 100, 23);
		btnCreateButton.setFocusable(false);
		frmScheduleManager.getContentPane().add(btnCreateButton);
		
		JButton btnClearButton = new JButton("Clear");
		btnClearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 M1.setText("");
				 M2.setText("");
				 M3.setText("");
				 M4.setText("");
				 T1.setText("");
				 T2.setText("");
				 T3.setText("");
				 T4.setText("");
				 W1.setText("");
				 W2.setText("");
				 W3.setText("");
				 W4.setText("");
				 TH1.setText("");
				 TH2.setText("");
				 TH3.setText("");
				 TH4.setText("");
				 F1.setText("");
				 F2.setText("");
				 F3.setText("");
				 F4.setText("");
			}
		});
		
		btnClearButton.setBounds(689, 155, 100, 23);
		btnClearButton.setFocusable(false);
		frmScheduleManager.getContentPane().add(btnClearButton);
		
		JButton btnModifyButton = new JButton("Modify");
		btnModifyButton.setBounds(689, 198, 100, 23);
		btnModifyButton.setFocusable(false);
		frmScheduleManager.getContentPane().add(btnModifyButton);
		
		JButton btnDeleteButton = new JButton("Delete");
		btnDeleteButton.setBounds(689, 240, 100, 23);
		btnDeleteButton.setFocusable(false);
		frmScheduleManager.getContentPane().add(btnDeleteButton);
		
		JButton btnListButton = new JButton("List");
		btnListButton.addActionListener(this);
		btnListButton.setBounds(689, 283, 100, 23);
		btnListButton.setFocusable(false);
		frmScheduleManager.getContentPane().add(btnListButton);
		
		
		
		JLabel lblTime = new JLabel("8:00 - 10:00");
		lblTime.setBounds(10, 105, 73, 32);
		frmScheduleManager.getContentPane().add(lblTime);
		
		JLabel lblTime1 = new JLabel("10:00 - 12:00");
		lblTime1.setBounds(10, 156, 73, 32);
		frmScheduleManager.getContentPane().add(lblTime1);
		
		JLabel lblTime2 = new JLabel("12:00 - 2:00");
		lblTime2.setBounds(10, 210, 73, 32);
		frmScheduleManager.getContentPane().add(lblTime2);
		
		JLabel lblTime3 = new JLabel("2:00 - 4:00");
		lblTime3.setBounds(10, 264, 73, 32);
		frmScheduleManager.getContentPane().add(lblTime3);
		
		M1 = new JTextField();
		M1.setBounds(92, 111, 96, 20);
		M1.setBorder(null);
		frmScheduleManager.getContentPane().add(M1);
		M1.setColumns(10);
		
		T1 = new JTextField();
		T1.setColumns(10);
		T1.setBorder(null);
		T1.setBounds(204, 111, 96, 20);
		frmScheduleManager.getContentPane().add(T1);
		
		W1 = new JTextField();
		W1.setColumns(10);
		W1.setBorder(null);
		W1.setBounds(323, 111, 96, 20);
		frmScheduleManager.getContentPane().add(W1);
		
		TH1 = new JTextField();
		TH1.setColumns(10);
		TH1.setBorder(null);
		TH1.setBounds(440, 111, 96, 20);
		frmScheduleManager.getContentPane().add(TH1);
		
		F1 = new JTextField();
		F1.setColumns(10);
		F1.setBorder(null);
		F1.setBounds(556, 111, 96, 20);
		frmScheduleManager.getContentPane().add(F1);
		
		M2 = new JTextField();
		M2.setColumns(10);
		M2.setBorder(null);
		M2.setBounds(92, 162, 96, 20);
		frmScheduleManager.getContentPane().add(M2);
		
		M3 = new JTextField();
		M3.setColumns(10);
		M3.setBorder(null);
		M3.setBounds(92, 216, 96, 20);
		frmScheduleManager.getContentPane().add(M3);
		
		M4 = new JTextField();
		M4.setColumns(10);
		M4.setBorder(null);
		M4.setBounds(93, 270, 96, 20);
		frmScheduleManager.getContentPane().add(M4);
		
		T2 = new JTextField();
		T2.setColumns(10);
		T2.setBorder(null);
		T2.setBounds(204, 162, 96, 20);
		frmScheduleManager.getContentPane().add(T2);
		
		T3 = new JTextField();
		T3.setColumns(10);
		T3.setBorder(null);
		T3.setBounds(204, 216, 96, 20);
		frmScheduleManager.getContentPane().add(T3);
		
		T4 = new JTextField();
		T4.setColumns(10);
		T4.setBorder(null);
		T4.setBounds(204, 270, 96, 20);
		frmScheduleManager.getContentPane().add(T4);
		
		W2 = new JTextField();
		W2.setColumns(10);
		W2.setBorder(null);
		W2.setBounds(323, 162, 96, 20);
		frmScheduleManager.getContentPane().add(W2);
		
		W3 = new JTextField();
		W3.setColumns(10);
		W3.setBorder(null);
		W3.setBounds(323, 216, 96, 20);
		frmScheduleManager.getContentPane().add(W3);
		
		W4 = new JTextField();
		W4.setColumns(10);
		W4.setBorder(null);
		W4.setBounds(323, 270, 96, 20);
		frmScheduleManager.getContentPane().add(W4);
		
		TH2 = new JTextField();
		TH2.setColumns(10);
		TH2.setBorder(null);
		TH2.setBounds(440, 162, 96, 20);
		frmScheduleManager.getContentPane().add(TH2);
		
		TH3 = new JTextField();
		TH3.setColumns(10);
		TH3.setBorder(null);
		TH3.setBounds(440, 216, 96, 20);
		frmScheduleManager.getContentPane().add(TH3);
		
		TH4 = new JTextField();
		TH4.setColumns(10);
		TH4.setBorder(null);
		TH4.setBounds(440, 270, 96, 20);
		frmScheduleManager.getContentPane().add(TH4);
		
		F2 = new JTextField();
		F2.setColumns(10);
		F2.setBorder(null);
		F2.setBounds(556, 162, 96, 20);
		frmScheduleManager.getContentPane().add(F2);
		
		F3 = new JTextField();
		F3.setColumns(10);
		F3.setBorder(null);
		F3.setBounds(556, 216, 96, 20);
		frmScheduleManager.getContentPane().add(F3);
		
		F4 = new JTextField();
		F4.setColumns(10);
		F4.setBorder(null);
		F4.setBounds(556, 270, 96, 20);
		frmScheduleManager.getContentPane().add(F4);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 307, 665, 2);
		frmScheduleManager.getContentPane().add(separator);
		
		JLabel lblMonday = new JLabel("Monday");
		lblMonday.setBounds(116, 86, 49, 14);
		lblMonday.setBorder(null);
		lblMonday.setFocusable(false);
		frmScheduleManager.getContentPane().add(lblMonday);
		
		JLabel lblTuesday = new JLabel("Tuesday");
		lblTuesday.setBounds(229, 86, 59, 14);
		lblTuesday.setBorder(null);
		lblTuesday.setFocusable(false);
		frmScheduleManager.getContentPane().add(lblTuesday);
		
		JLabel lblWednesday = new JLabel("Wednesday");
		lblWednesday.setBounds(348, 86, 81, 14);
		lblWednesday.setBorder(null);
		lblWednesday.setFocusable(false);
		frmScheduleManager.getContentPane().add(lblWednesday);
		
		JLabel lblThursday = new JLabel("Thursday");
		lblThursday.setBounds(463, 86, 73, 14);
		lblThursday.setBorder(null);
		lblThursday.setFocusable(false);
		frmScheduleManager.getContentPane().add(lblThursday);
		
		JLabel lblFriday = new JLabel("Friday");
		lblFriday.setBounds(582, 86, 49, 14);
		lblFriday.setBorder(null);
		lblFriday.setFocusable(false);
		frmScheduleManager.getContentPane().add(lblFriday);
	}
	
public void actionPerformed(ActionEvent e) {
	try {
		Class.forName("org.sqlite.JDBC");
		 Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\DB Browser for SQLite\\Bynum School Schedule.db");
		
		 Statement statement = connection.createStatement();
		 
		 Monday = M1.getText();
		 Monday = M2.getText();
		 Monday = M3.getText();
		 Monday = M4.getText();
		 Tuesday = T1.getText();
		 Tuesday = T2.getText();
		 Tuesday = T3.getText();
		 Tuesday = T4.getText();
		 Wednesday = W1.getText();
		 Wednesday = W2.getText();
		 Wednesday = W3.getText();
		 Wednesday = W4.getText();
		 Thursday = TH1.getText();
		 Thursday = TH2.getText();
		 Thursday = TH3.getText();
		 Thursday = TH4.getText();
		 Friday = F1.getText();
		 Friday = F2.getText();
		 Friday = F3.getText();
		 Friday = F4.getText();
		 
		 ResultSet rs = statement.executeQuery("SELECT Initials FROM Students where Passcode = '"+passcode+"'");
		 if(rs.next()) 
			{
				M1.setText(rs.getString("Monday"));
				M2.setText(rs.getString("Monday"));
				M3.setText(rs.getString("Monday"));
				M4.setText(rs.getString("Monday"));
				T1.setText(rs.getString("Tuesday"));
				T2.setText(rs.getString("Tuesday"));
				T3.setText(rs.getString("Tuesday"));
				T4.setText(rs.getString("Tuesday"));
				W1.setText(rs.getString("Wednesday"));
				W2.setText(rs.getString("Wednesday"));
				W3.setText(rs.getString("Wednesday"));
				W4.setText(rs.getString("Wednesday"));
				TH1.setText(rs.getString("Thursday"));
				TH2.setText(rs.getString("Thursday"));
				TH3.setText(rs.getString("Thursday"));
				TH4.setText(rs.getString("Thursday"));
				F1.setText(rs.getString("Friday"));
				F2.setText(rs.getString("Friday"));
				F3.setText(rs.getString("Friday"));
				F4.setText(rs.getString("Friday"));
				 
			}else {
				JOptionPane.showMessageDialog(null, "Information not found.");
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
}
