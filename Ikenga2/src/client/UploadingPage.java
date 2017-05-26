//2017.05.23 Jenna Kim
package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UploadingPage extends JFrame {

	private JPanel contentPane;
	private JTextField txfName;
	private JTextField tfPrice;
	private JTextField tefDescription;
	private JTextField tfSearch;
	BufferedImage img = null;

	/**
	 * Launch the application.
	 */
	public static void NewUploading() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UploadingPage frame = new UploadingPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UploadingPage() {
		//Setting window
		setTitle("Please upload your item!");//set title of window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//shutdown program when close the window
		setBounds(100, 100, 840, 600);//size of window
		
		//panel
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//label for logo
		JLabel lblLogo = new JLabel("New label");
		lblLogo.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\calmtec\\image\\ikenga.png"));
		lblLogo.setBounds(14, 12, 62, 76);
		contentPane.add(lblLogo);
		
		//label for header
		JLabel lblUpload = new JLabel("UPLOAD");
		lblUpload.setFont(new Font("Arial", Font.BOLD, 45));
		lblUpload.setBounds(78, 12, 188, 76);
		contentPane.add(lblUpload);
		
		//button for sign out
		JButton btnSignOut = new JButton("Sign out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage mp = new MainPage();
				mp.newMain();
				setVisible(false);
			}
		});
		btnSignOut.setForeground(Color.BLACK);
		btnSignOut.setFont(new Font("Arial", Font.PLAIN, 15));
		btnSignOut.setBackground(Color.WHITE);
		btnSignOut.setBounds(280, 48, 92, 24);
		contentPane.add(btnSignOut);
		
		//text field for searching all items
		tfSearch = new JTextField();
		tfSearch.setText("  search..");
		tfSearch.setColumns(10);
		tfSearch.setBounds(468, 33, 268, 35);
		contentPane.add(tfSearch);
		
		//button for searching items
		JButton btnSearch = new JButton("");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setIcon(null);
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(750, 33, 39, 35);
		contentPane.add(btnSearch);
		
		//combo box for category
		JComboBox cbCategory = new JComboBox();
		cbCategory.setModel(new DefaultComboBoxModel(new String[] {"Select category", "Arts", "Antique", "Clothes", "Interior", "Jewelry", "Tech", "Shoes"}));
		cbCategory.setForeground(new Color(153, 0, 0));
		cbCategory.setFont(new Font("Arial", Font.PLAIN, 15));
		cbCategory.setBackground(new Color(255, 255, 255));
		cbCategory.setBounds(25, 114, 154, 26);
		contentPane.add(cbCategory);
		
		//button for uploading all upload information
		JButton btnSave = new JButton("SAVE");
		btnSave.setForeground(new Color(153, 0, 0));
		btnSave.setFont(new Font("Arial", Font.BOLD, 15));
		btnSave.setBackground(Color.WHITE);
		btnSave.setBounds(355, 122, 81, 24);
		contentPane.add(btnSave);
		
		//label for name
		JLabel lblName = new JLabel("name");
		lblName.setFont(new Font("Arial", Font.PLAIN, 20));
		lblName.setBounds(27, 152, 48, 36);
		contentPane.add(lblName);
		
		//text field for name
		txfName = new JTextField();
		txfName.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		txfName.setColumns(10);
		txfName.setBounds(89, 154, 349, 36);
		contentPane.add(txfName);
		
		//label for setting price
		JLabel lblMinPrice = new JLabel("price");
		lblMinPrice.setFont(new Font("Arial", Font.PLAIN, 20));
		lblMinPrice.setBounds(27, 200, 48, 36);
		contentPane.add(lblMinPrice);
		
		//text field for setting price
		tfPrice = new JTextField();
		tfPrice.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		tfPrice.setColumns(10);
		tfPrice.setBounds(89, 202, 349, 36);
		contentPane.add(tfPrice);
		
		//label for description
		JLabel lblDescription = new JLabel("description");
		lblDescription.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDescription.setBounds(28, 248, 103, 36);
		contentPane.add(lblDescription);
		
		//text field for description
		tefDescription = new JTextField();
		tefDescription.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		tefDescription.setColumns(10);
		tefDescription.setBounds(27, 296, 411, 221);
		contentPane.add(tefDescription);
	
		//#label for preview image
		JLabel preView1 = new JLabel("PreView");
		preView1.setBackground(Color.WHITE);
		preView1.setBounds(468, 125, 321, 338);
		Border border = BorderFactory.createLineBorder(Color.black);
		preView1.setBorder(border);
		contentPane.add(preView1);

		//button for uploading photo
		JButton btnPhoto = new JButton("Photo");
		btnPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setBounds(0, 0, 610, 365);
				int openvalue = fileChooser.showOpenDialog(null); 
				if(openvalue == JFileChooser.APPROVE_OPTION){ //click open button
					String imagepath = fileChooser.getSelectedFile().toString();
					System.out.println(imagepath);
					try {
						img = ImageIO.read(new File(imagepath));
						preView1.setIcon(new ImageIcon(img));
					} catch (IOException e) {

					}
					
				}
				else if (openvalue == JFileChooser.CANCEL_OPTION) { //click cancel button
					
				}
			}
		});
		btnPhoto.setBackground(new Color(255, 255, 255));
		btnPhoto.setForeground(new Color(153, 0, 0));
		btnPhoto.setBounds(333, 255, 105, 27);
		contentPane.add(btnPhoto);
		

		//buttons for calling main page
		JButton btnMain = new JButton("MAIN");
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WaitingPage wp = new WaitingPage();
				wp.NewWaiting();
				setVisible(false);
			}
		});
		
		//button for main
		btnMain.setForeground(new Color(153, 0, 0));
		btnMain.setFont(new Font("Arial", Font.BOLD, 20));
		btnMain.setBackground(Color.WHITE);
		btnMain.setBounds(493, 475, 103, 42);
		contentPane.add(btnMain);
		
		//button for page back
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyPage mp = new MyPage();
				mp.NewMypage();
				setVisible(false);
			}
		});
		btnBack.setForeground(new Color(153, 0, 0));
		btnBack.setFont(new Font("Arial", Font.BOLD, 20));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(654, 475, 116, 42);
		contentPane.add(btnBack);
		
		//label for copyright
		JLabel label = new JLabel("copyright@\u30AB-\u30E0\u30C6\u30AF");
		label.setForeground(new Color(153, 153, 153));
		label.setFont(new Font("±¼¸²", Font.BOLD | Font.ITALIC, 13));
		label.setBounds(654, 519, 154, 24);
		contentPane.add(label);
		
	}
	
}
