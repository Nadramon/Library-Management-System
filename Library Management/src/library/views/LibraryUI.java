package library.views;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import java.awt.Button;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import java.awt.Font;

public class LibraryUI {

	private JFrame frame;
	private JButton btnLogin;
	private JPasswordField password;
	private JTextField username;
	private JButton btnNewUser;
	public ManageUsers students;
	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryUI window = new LibraryUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Create the application.
	 */
	public LibraryUI() {
		initialize();
		createEvents();
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 507, 315);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnNewUser = new JButton("New User");
		btnLogin = new JButton("Login");
		
		username = new JTextField();
		username.setColumns(10);
		password = new JPasswordField();
		password.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		JLabel lblPassword = new JLabel("Password");
		
		JLabel lblLibraryManagementSystem = new JLabel("Library Management System");
		lblLibraryManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnLogin)
									.addGap(58)
									.addComponent(btnNewUser)
									.addGap(8))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblUsername)
										.addComponent(lblPassword))
									.addGap(55)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(username)
										.addComponent(password, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(68)
							.addComponent(lblLibraryManagementSystem)))
					.addContainerGap(68, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(lblLibraryManagementSystem)
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogin)
						.addComponent(btnNewUser))
					.addGap(92))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	private void createEvents() {
		// TODO Auto-generated method stub
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				students = new ManageUsers();
				ArrayList<Student> stu = students.getActiveList();
				String user = username.getText();
				String pass = password.getText();
				boolean loggy = false ;
				for(int x = 0; x < stu.size(); x++) {
					if (stu.get(x).getFirstName().compareTo(user) == 0) {
						if(stu.get(x).getLastName().compareTo(pass) == 0) {
							Login log = new Login(students);
							log.setVisible(true);
							loggy = true;
							frame.dispose();
						}
					}
				}
				if (loggy == false) {
					FailLogin fail = new FailLogin();
					fail.setVisible(true);
				}
			}

		
		});
		
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register reg = new Register();
				reg.setVisible(true);
			}
		});
		
	}
}