// A pop up that appears when a login has failed

package library.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FailLogin extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FailLogin dialog = new FailLogin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FailLogin() {
		setBounds(100, 100, 250, 155);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Login Failed");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblWrongUsernameOr = new JLabel("Wrong Username or Password");
		lblWrongUsernameOr.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblPleaseTryAgain = new JLabel("Please try again");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(65)
					.addComponent(lblNewLabel)
					.addContainerGap(74, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addGap(32)
					.addComponent(lblWrongUsernameOr, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
					.addGap(25))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(67)
					.addComponent(lblPleaseTryAgain)
					.addContainerGap(80, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblWrongUsernameOr)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPleaseTryAgain)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
	}
}
