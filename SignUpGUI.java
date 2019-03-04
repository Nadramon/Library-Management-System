import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.SystemColor;

public class SignUpGUI {

	private JFrame frame;
	private JTextField txtFldUCID;
	private JTextField txtFldFName;
	private JTextField txtFldLName;
	private JTextField txtFldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpGUI window = new SignUpGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUpGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("55px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("367px"),},
			new RowSpec[] {
				RowSpec.decode("56px"),
				RowSpec.decode("14px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				RowSpec.decode("103px"),
				RowSpec.decode("6px"),
				RowSpec.decode("23px"),}));
		
		JLabel lblUcid = new JLabel("UCID:");
		frame.getContentPane().add(lblUcid, "2, 2, right, top");
		
		txtFldUCID = new JTextField();
		frame.getContentPane().add(txtFldUCID, "4, 2, fill, fill");
		txtFldUCID.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name:");
		frame.getContentPane().add(lblFirstName, "2, 4, right, top");
		
		txtFldFName = new JTextField();
		frame.getContentPane().add(txtFldFName, "4, 4, fill, fill");
		txtFldFName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		frame.getContentPane().add(lblLastName, "2, 6, right, top");
		
		txtFldLName = new JTextField();
		frame.getContentPane().add(txtFldLName, "4, 6, fill, fill");
		txtFldLName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		frame.getContentPane().add(lblPassword, "2, 8, right, top");
		
		txtFldPassword = new JTextField();
		frame.getContentPane().add(txtFldPassword, "4, 8, fill, fill");
		txtFldPassword.setColumns(10);
		
		JTextArea txtrPasswordsMustContain = new JTextArea();
		txtrPasswordsMustContain.setBackground(SystemColor.menu);
		txtrPasswordsMustContain.setWrapStyleWord(true);
		txtrPasswordsMustContain.setLineWrap(true);
		txtrPasswordsMustContain.setFont(new Font("Arial", Font.PLAIN, 12));
		txtrPasswordsMustContain.setEnabled(false);
		txtrPasswordsMustContain.setEditable(false);
		txtrPasswordsMustContain.setText("Passwords must contain at least 8 characters including upper- and lowercase letters, numbers, and symbols.");
		frame.getContentPane().add(txtrPasswordsMustContain, "4, 9, fill, top");
		
		JButton btnSubmit = new JButton("Submit");
		frame.getContentPane().add(btnSubmit, "4, 11, center, top");
	}

}
