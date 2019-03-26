package library.views;

import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;

public class ReturnMaterial {

	public JFrame getFrame() {
		return frame;
	}

	private JFrame frame;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	private static ArrayList<String> material;
	
	private static Date borrowDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				Student stuTest = new Student("James", "Lorenzo", 300112, 2, true, false);
				

				
				material = new ArrayList<String>();
				material.add("1");
				material.add("Harry Poller");
				material.add("300112");
				
				try {
					borrowDate = sdf.parse("2019-01-10");
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//material.add("3-10-2019");
				
				//Material: id, name, id of borrower, date
				
				try {
					ReturnMaterial window = new ReturnMaterial();
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
	public ReturnMaterial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel titleLabel = new JLabel("Return Material");
		frame.getContentPane().add(titleLabel, BorderLayout.CENTER);
		
		
		String idS = JOptionPane.showInputDialog(frame, "Enter the Material ID to return:", null);
		boolean success = false;
		try {
			int id = Integer.parseInt(idS);
			
			//for loop to iterate to check if exists or not
			success = true;
			
			if(success) {
				
				Date currentDate = new Date();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(borrowDate);
				calendar.add(Calendar.DATE, 14);
				Date deadline = sdf.parse(sdf.format(calendar.getTime()));
				
				
				
				//getting rid of it from student
				
				String text2 = material.get(1) + " has been returned!";
				
				JOptionPane.showMessageDialog(frame, text2, "Error", JOptionPane.WARNING_MESSAGE);
				
				//success message
				
				if(currentDate.after(deadline)) {
					String text = "The material was overdue.\nCurrent Date: " + currentDate.toString() + "\nDue Date: " + deadline.toString();
					JOptionPane.showMessageDialog(frame, text, "Error", JOptionPane.WARNING_MESSAGE);
				}
			}
			
			else {
				//if overdue
				
				JOptionPane.showMessageDialog(frame, "That material is not being borrowed right now!", "Error", JOptionPane.WARNING_MESSAGE);
				
				
				
			}
			
			
			
		}
		catch (Exception exception) {
			JOptionPane.showMessageDialog(frame, "Please input a number", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
		
		
		
		
	}

}
