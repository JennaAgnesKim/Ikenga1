package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.image.BufferedImage;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AuctionPage extends JFrame {

	private JPanel contentPane;
	private BufferedImage image;
	private JTextField tfSearch;
	private ImageIcon itemImage;
	private JTextField tfName;
	private JTextField textField;
	private JTextField tfDescription;

	/**
	 * Launch the application.
	 */
	public static void newAuctionpage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuctionPage frame = new AuctionPage();
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
	public AuctionPage() {
		
		setTitle("Item information");//set title of window
		//shutdown program when close the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//size of window
		setBounds(100, 100, 840, 600);
		//create contentPane
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//label for logo
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\calmtec\\image\\ikenga.png"));
		lblLogo.setBounds(14, 12, 62, 76);
		contentPane.add(lblLogo);
		
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
		btnSignOut.setBounds(333, 49, 92, 24);
		contentPane.add(btnSignOut);
		
		//text field for searching
		tfSearch = new JTextField();
		tfSearch.setText("  search..");
		tfSearch.setColumns(10);
		tfSearch.setBounds(468, 33, 268, 35);
		contentPane.add(tfSearch);
		
		//button for searching
		JButton btnSearch = new JButton("");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\calmtec\\image\\search_m.png"));
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(750, 33, 39, 35);
		contentPane.add(btnSearch);
		
		//Big image of selected item
		//## 이미지를 불러오는 쿼리 필요행
		//예) itemImage = new ImageIcon(getClass().getResource("이미지이름및파일명")) 
		JLabel lblItemImage = new JLabel(itemImage);
		lblItemImage.setBounds(24, 100, 344, 353);
		contentPane.add(lblItemImage);
		JLabel lblHeader = new JLabel("ITEM INFO.");
		lblHeader.setFont(new Font("Arial", Font.BOLD, 45));
		lblHeader.setBounds(78, 12, 251, 76);
		contentPane.add(lblHeader);
		
		//label for name
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Arial", Font.PLAIN, 20));
		lblName.setBounds(382, 100, 51, 18);
		contentPane.add(lblName);
		
		//text field for name
		//## 선택된 아이템의 이름 정보 불러오는 쿼리 필요행
		tfName = new JTextField();
		tfName.setEditable(false);
		tfName.setFont(new Font("Arial", Font.PLAIN, 17));
		tfName.setBounds(447, 100, 342, 24);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		//label for price
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPrice.setBounds(382, 143, 51, 18);
		contentPane.add(lblPrice);
		
		//text field for price
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 17));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(447, 141, 342, 24);
		contentPane.add(textField);
		
		//label for description
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDescription.setBounds(382, 177, 109, 18);
		contentPane.add(lblDescription);
		
		//text field for description
		tfDescription = new JTextField();
		tfDescription.setFont(new Font("Arial", Font.PLAIN, 17));
		tfDescription.setEditable(false);
		tfDescription.setColumns(10);
		tfDescription.setBounds(382, 203, 407, 250);
		contentPane.add(tfDescription);
		
		
		//button for wating page
		JButton btnMain = new JButton("MAIN");
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WaitingPage wp = new WaitingPage();
				wp.NewWaiting();
				setVisible(false);
			}
		});
		btnMain.setForeground(new Color(153, 0, 0));
		btnMain.setFont(new Font("Arial", Font.BOLD, 20));
		btnMain.setBackground(Color.WHITE);
		btnMain.setBounds(686, 465, 103, 42);
		contentPane.add(btnMain);
		
		//button for bid
		JButton btnBidnow = new JButton("BID NOW!");
		btnBidnow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PopupBatting pb = new PopupBatting();
				pb.NewPopupBatting();
			}
		});
		btnBidnow.setForeground(new Color(153, 0, 0));
		btnBidnow.setFont(new Font("Arial", Font.BOLD, 20));
		btnBidnow.setBackground(Color.WHITE);
		btnBidnow.setBounds(106, 465, 164, 42);
		contentPane.add(btnBidnow);
		
		//label for copyright
		JLabel lblCopyright = new JLabel("copyright@\u30AB-\u30E0\u30C6\u30AF");
		lblCopyright.setForeground(new Color(153, 153, 153));
		lblCopyright.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 13));
		lblCopyright.setBounds(654, 519, 154, 24);
		contentPane.add(lblCopyright);
	}
}
