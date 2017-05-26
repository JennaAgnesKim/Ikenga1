package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Color;

public class CongratPage extends JFrame {

	private JPanel contentPane;
	private JTextField tfItem;
	private JTextField tfFinalPrice;
	private JTextField tfAccountNo;

	/**
	 * Launch the application.
	 */
	public static void NewPopupBatting() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CongratPage frame = new CongratPage();
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
	public CongratPage() {
		//create window
		setTitle("Congratulation!!");//set title of window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//shutdown program when close the window
		setBounds(100, 100, 680, 470);//size of window
		
		//create pane
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//label for medal
		JLabel lblMedal = new JLabel();
		lblMedal.setIcon(new ImageIcon("D:\\jdbc\\Ikenga\\gui_icon\\medal (9).png"));
		lblMedal.setBounds(14, 0, 128, 128);
		contentPane.add(lblMedal);
		
		//label for congratulation
		JLabel lblCongratulation = new JLabel("Congraturation!!");
		lblCongratulation.setFont(new Font("Cambria", Font.BOLD, 60));
		lblCongratulation.setBounds(142, 12, 482, 90);
		contentPane.add(lblCongratulation);
		
		//label for item photo
		JLabel lblItem = new JLabel("            <preview image>");
		lblItem.setBounds(24, 140, 234, 262);
		Border border = BorderFactory.createLineBorder(Color.black);
		lblItem.setBorder(border);
		contentPane.add(lblItem);
		
		//label for item name
		JLabel lblItemname = new JLabel("Item");
		lblItemname.setFont(new Font("Arial", Font.BOLD, 20));
		lblItemname.setBounds(272, 149, 40, 24);
		contentPane.add(lblItemname);
		
		//text field for item name
		tfItem = new JTextField();
		tfItem.setBounds(326, 140, 288, 46);
		contentPane.add(tfItem);
		tfItem.setColumns(10);
		
		//label for final price
		JLabel lblFinalPrice = new JLabel("Final price");
		lblFinalPrice.setFont(new Font("Arial", Font.BOLD, 20));
		lblFinalPrice.setBounds(273, 223, 98, 24);
		contentPane.add(lblFinalPrice);
		
		//text field final price
		tfFinalPrice = new JTextField();
		tfFinalPrice.setColumns(10);
		tfFinalPrice.setBounds(385, 214, 229, 46);
		contentPane.add(tfFinalPrice);
		
		//label for account number
		JLabel lblAccountNo = new JLabel("Account No.");
		lblAccountNo.setFont(new Font("Arial", Font.BOLD, 20));
		lblAccountNo.setBounds(273, 301, 135, 24);
		contentPane.add(lblAccountNo);
		
		//text field for account number
		tfAccountNo = new JTextField();
		tfAccountNo.setColumns(10);
		tfAccountNo.setBounds(412, 292, 202, 46);
		contentPane.add(tfAccountNo);
		
		//button for close
		JButton btnClose = new JButton("CLOSE");
		btnClose.setForeground(new Color(153, 0, 0));
		btnClose.setFont(new Font("Arial", Font.BOLD, 20));
		btnClose.setBackground(Color.WHITE);
		btnClose.setBounds(271, 360, 116, 42);
		contentPane.add(btnClose);
	}
}
