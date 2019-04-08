// This view is when a student logs in, They get to see the functionality that a student would be able to use

package library.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class StudentView extends JFrame {

	private JPanel contentPane;
	private JTextField welcomeTxt;
	private JButton btnBack;
	private JButton btnReturnBook;
	private JButton btnSearchForBook;
	private JButton btnOrderMaterials;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//	StudentView frame = new StudentView();
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
	public StudentView(Student s, ManageUsers users) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnSearchForBook = new JButton("Search for Book/Material");
		
		JButton btnBorrowBook = new JButton("Borrow Book");
		
		welcomeTxt = new JTextField();
		welcomeTxt.setColumns(10);
		welcomeTxt.setText("Logged in as: " + s.getFirstName() + " " + s.getLastName() + ", current books: " + s.getCurrentBorrowing());
		
		btnBack = new JButton("Back");
		
		btnReturnBook = new JButton("Return Book");
		
		btnOrderMaterials = new JButton("Order Materials");

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(welcomeTxt, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(133, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(348, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addGap(21))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(246)
					.addComponent(btnBorrowBook, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(246)
					.addComponent(btnSearchForBook, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(246)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnOrderMaterials, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
						.addComponent(btnReturnBook, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(welcomeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(btnSearchForBook)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBorrowBook)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnReturnBook)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnOrderMaterials)
					.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		createEvents();
	}

	private void createEvents() {
		// This button goes back to the previous menu
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibraryUI lib = new LibraryUI();
				lib.getFrame().setVisible(true);
				dispose();
			}
		});
		// This button lets the user return materials
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnMaterial retMat = new ReturnMaterial();
				retMat.getFrame().setVisible(true);
				dispose();
				}
		});
		/*
		 * This button lets you go to the search window to search for an item.
		 */
		btnSearchForBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorrowMaterialsView search = new BorrowMaterialsView();
				search.setVisible(true);
			}
		});
		/*
		 * This button switches to the order material form in order to place an order.
		 */
		btnOrderMaterials.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				OrderMaterialsView order = new OrderMaterialsView();
//				order.setVisible(true);
				ArrayList<Material> materialList = new ArrayList<Material>();

				MaterialsItemsDisplay list = new MaterialsItemsDisplay(materialList);
				list.setVisible(true);
			}
		});
	}
}
