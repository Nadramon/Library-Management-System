// This is the window to Borrow Materials, It pop ups a search so users can search for books/materials

package library.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class BorrowMaterialsView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnSearch;
	private JComboBox comboBox_BM;
	private JLabel lblBy;
	private JComboBox comboBox_Aut;
	private JLabel lblSearchThe;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//BorrowMaterialsView frame = new BorrowMaterialsView();
				//	frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BorrowMaterialsView(ManageUsers user) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 188);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		btnSearch = new JButton("Search");
		
		comboBox_BM = new JComboBox();
		comboBox_BM.setForeground(Color.BLACK);
		comboBox_BM.setToolTipText("");
		comboBox_BM.setModel(new DefaultComboBoxModel(new String[] {"Books", "Materials"}));
		
		lblBy = new JLabel("by");
		
		comboBox_Aut = new JComboBox();
		comboBox_Aut.setModel(new DefaultComboBoxModel(new String[] {"Author", "Name", "ID"}));
		
		lblSearchThe = new JLabel("Search the");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnSearch))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblSearchThe)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox_BM, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblBy)
							.addGap(18)
							.addComponent(comboBox_Aut, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(121, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSearchThe)
						.addComponent(lblBy)
						.addComponent(comboBox_Aut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_BM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		createEvents(user);
	}

	private void createEvents(ManageUsers user) {
		// The search button searches for the items based on categories of search and name
		// If The item exists in the list then it opens a window with the list
		// If the item doesn't exist  a popup appears
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String typeOfSearch = (String) comboBox_BM.getSelectedItem();
				String typeOfMaterial = (String) comboBox_Aut.getSelectedItem();
				MaterialsItemsDisplay list = new MaterialsItemsDisplay(user.getMaterialList());
				ArrayList<Material> materialList = user.getMaterialList();
				
				if (typeOfSearch == "Books" && typeOfMaterial == "Author") {
					 for (int x = 0; x < user.getMaterialList().size(); x++) {
						 if(materialList.get(x).getType() == "Book"){
							 list.setVisible(true);
						 }
					 }
				}
				else if (typeOfSearch == "Materials" && typeOfMaterial == "Author") {
					JOptionPane.showMessageDialog(contentPane, "That combination is not possible", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if (typeOfSearch == "Books" && typeOfMaterial == "Name") {
					for (int x = 0; x < user.getMaterialList().size(); x++) {
						 if(materialList.get(x).getType() == "Book"){
							 list.setVisible(true);
						 }
					 }
				}
				else if (typeOfSearch == "Books" && typeOfMaterial == "ID") {
					for (int x = 0; x < user.getMaterialList().size(); x++) {
						 if(materialList.get(x).getType() == "Book"){
							 list.setVisible(true);
						 }
					 }
				}
				else if (typeOfSearch == "Materials" && typeOfMaterial == "Name") {
					for (int x = 0; x < user.getMaterialList().size(); x++) {
						 if(materialList.get(x).getType() == "Book"){
							 list.setVisible(true);
						 }
					 }
				}
				else if (typeOfSearch == "Materials" && typeOfMaterial == "ID") {
					for (int x = 0; x < user.getMaterialList().size(); x++) {
						 if(materialList.get(x).getType() == "Book"){
							 list.setVisible(true);
						 }
					 }
				}
				
			}
		});
	}
	
}

