package library.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtSuccessfulLogin;
	private JButton btnManageUsers;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					Login frame = new Login();
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login(ManageUsers stu) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtSuccessfulLogin = new JTextField();
		txtSuccessfulLogin.setText("SUCCESSFUL LOGIN");
		txtSuccessfulLogin.setColumns(10);
		
		btnManageUsers = new JButton("Manage Users");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(txtSuccessfulLogin, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(145)
					.addComponent(btnManageUsers))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(txtSuccessfulLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
					.addComponent(btnManageUsers)
					.addGap(75))
		);
		contentPane.setLayout(gl_contentPane);
		createEvents(stu);
	}

	private void createEvents(ManageUsers ss) {
		btnManageUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ArrayList<Student> archiveList = ss.getArchiveList();
			ArrayList<Student> activeList = ss.getActiveList();
			ManageUsersGUI obama = new ManageUsersGUI(activeList, archiveList);
			}
		});
	}
}
