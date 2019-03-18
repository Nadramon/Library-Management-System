package library.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class WeakPasswordView extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			WeakPasswordView dialog = new WeakPasswordView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public WeakPasswordView() {
		setBounds(100, 100, 367, 154);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("WeakPassword");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		JLabel lblMustContainAt = new JLabel("Must contain at least 8 characters");
		
		JLabel lblAndAtleastOne = new JLabel("Include Capital letters, Special characters, and numbers");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMustContainAt)
					.addContainerGap(51, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(69, Short.MAX_VALUE)
					.addComponent(lblAndAtleastOne)
					.addGap(23))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(124, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(91))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMustContainAt)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAndAtleastOne)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
	}
}
