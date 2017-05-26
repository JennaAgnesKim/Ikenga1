package client;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;

public class AttachingFile extends JFrame {

	private JPanel contentPane;
	private String imagepath;


	/**
	 * Create the frame.
	 */
	public AttachingFile() {
		//Setting window
		setTitle("Please select the image of your item");//set title of window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set title of window
		setBounds(100, 100, 631, 410);//size of window
		
		//panel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setBounds(0, 0, 610, 365);
		int openvalue = fileChooser.showOpenDialog(null); //open
		if(openvalue == JFileChooser.APPROVE_OPTION){ //click open button
			imagepath = fileChooser.getSelectedFile().toString();
		}
		else if(openvalue == JFileChooser.CANCEL_OPTION){ //click cancel button
			
		}
		contentPane.add(fileChooser);
	}
	
	public String getimage(){
		AttachingFile af = new AttachingFile();
		
		return imagepath;
	}
}
