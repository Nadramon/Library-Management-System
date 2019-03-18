package library.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class Register extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnConfirm;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField iD;
	private ManageUsers students;
	private JTextField userName;
	private JTextField passWord;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Register dialog = new Register();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Register() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		btnConfirm = new JButton("Confirm");
		
		firstName = new JTextField();
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		
		iD = new JTextField();
		iD.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		
		JLabel lblLastName = new JLabel("Last Name");
		
		JLabel lblUcid = new JLabel("UCID");
		
		userName = new JTextField();
	
		userName.setColumns(10);
		
		passWord = new JTextField();
		passWord.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		
		JLabel lblPassword = new JLabel("Password");
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(311, Short.MAX_VALUE)
					.addComponent(btnConfirm)
					.addGap(44))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblUcid)
							.addComponent(lblLastName))
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblUsername)
							.addComponent(lblFirstName)
							.addComponent(lblPassword)))
					.addGap(54)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(passWord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(userName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(iD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(firstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(199, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(userName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(passWord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(firstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFirstName))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLastName))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(iD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUcid))
					.addGap(17)
					.addComponent(btnConfirm)
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
		createEvents();
	}

	private void createEvents() {
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				students = new ManageUsers();
				ArrayList<Student> stu = students.getActiveList();
				String uName = userName.getText();
				String pWord = passWord.getText();
				String fName = firstName.getText();
				String lName = lastName.getText();	
				String uc = iD.getText();
				int ucid = Integer.parseInt(uc);
<<<<<<< HEAD
				if (isStrong(pWord) == true) {
					Student ins = new Student(fName, lName, ucid, 0, true, uName, pWord, false);
					stu.add(ins);	
					dispose();
				}else {
					WeakPasswordView lol = new WeakPasswordView();
					lol.setVisible(true);
					
				}
=======
				Student ins = new Student(fName, lName, ucid, 0, true, false);
				stu.add(ins);	
				dispose();
>>>>>>> origin/nadhif
			}
		});
		
	}
	
	public static boolean isStrong(String pWord) {
        boolean strongPword = false;
        if (pWord.length() >= 8) {
            if (pWord.matches(".*\\d+.*")){
                if (pWord.matches(".*[a-z]+.*")) {
                    if (pWord.matches(".*[A-Z]+.*")) {
                        if (!pWord.contains("\\s")) {
                            strongPword = true;
                        }
                    }
                }
            }
        }
        return strongPword;
    }
}
