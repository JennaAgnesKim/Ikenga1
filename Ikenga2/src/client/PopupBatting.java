package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PopupBatting extends JFrame {

	private JPanel contentPane;
	private JTextField tfCurrentPrice;
	private JTextField tfStartingprice;
	private JTextField tfYouroffer;
	private JButton btnCancel;
	private JButton btnSave;

	/**
	 * Launch the application.
	 */
	public static void NewPopupBatting() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopupBatting frame = new PopupBatting();
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
	public PopupBatting() {
		//create window
		setTitle("Good luck!!");//set title of window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//shutdown program when close the window
		setBounds(100, 100, 450, 300);//size of window
		
		//create pane
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//label for starting price
		JLabel lblStartingPrice = new JLabel("starting price");
		lblStartingPrice.setFont(new Font("Arial", Font.BOLD, 20));
		lblStartingPrice.setBounds(33, 45, 129, 24);
		contentPane.add(lblStartingPrice);
		
		//text field for starting price
		tfStartingprice = new JTextField();
		tfStartingprice.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		tfStartingprice.setEditable(false);
		tfStartingprice.setColumns(10);
		tfStartingprice.setBounds(176, 38, 203, 38);
		contentPane.add(tfStartingprice);
		
		//label for current price
		JLabel lblCurrentPrice = new JLabel("current price");
		lblCurrentPrice.setFont(new Font("Arial", Font.BOLD, 20));
		lblCurrentPrice.setBounds(33, 96, 122, 18);
		contentPane.add(lblCurrentPrice);
		
		//text field for current price
		tfCurrentPrice = new JTextField();
		tfCurrentPrice.setEditable(false);
		tfCurrentPrice.setBounds(176, 88, 203, 38);
		contentPane.add(tfCurrentPrice);
		tfCurrentPrice.setColumns(10);
		
		//label for offering price
		JLabel lblYourOffer = new JLabel("your offer");
		lblYourOffer.setFont(new Font("Arial", Font.BOLD, 20));
		lblYourOffer.setBounds(61, 145, 94, 18);
		contentPane.add(lblYourOffer);
		
		//text field for offer price
		tfYouroffer = new JTextField();
		tfYouroffer.setColumns(10);
		tfYouroffer.setBounds(176, 138, 203, 36);
		contentPane.add(tfYouroffer);
		
		//button for cancel
		btnCancel = new JButton("cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancel.setBounds(71, 198, 105, 27);
		contentPane.add(btnCancel);
		
		//button for save
		btnSave = new JButton("save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave.setBounds(234, 198, 105, 27);
		contentPane.add(btnSave);
	}

}
