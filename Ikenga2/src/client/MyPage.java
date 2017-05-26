//2017.05.23 Jenna Kim
package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyPage extends JFrame {

	private JPanel contentPane;
	private JTextField txSearchTotal;
	private JTextField tfName;
	private JTextField tfEmail;
	private JPasswordField tfPassword;
	private JTextField tfBankaccount;
	private JTable table;
	private JTextField txtSearchMy;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void NewMypage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPage frame = new MyPage();
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
	public MyPage() {
		//Setting window
		setTitle("My page");//set title of window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//shutdown program when close the window
		setBounds(100, 100, 840, 600);//size of window
		
		//create contentPane
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//label for logo
		JLabel lbLogo = new JLabel("New label");
		lbLogo.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\calmtec\\image\\ikenga.png"));
		lbLogo.setBounds(14, 12, 62, 76);
		contentPane.add(lbLogo);
		
		//label for header
		JLabel lblMyPage = new JLabel("MY PAGE");
		lblMyPage.setFont(new Font("Arial", Font.BOLD, 45));
		lblMyPage.setBounds(78, 12, 206, 76);
		contentPane.add(lblMyPage);
		
		//button for sign out
		JButton btnSignout = new JButton("Sign out");
		btnSignout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage mp = new MainPage(); 
				mp.newMain();
				setVisible(false);
			}
		});
		btnSignout.setForeground(new Color(0, 0, 0));
		btnSignout.setFont(new Font("Arial", Font.PLAIN, 15));
		btnSignout.setBackground(new Color(255, 255, 255));
		btnSignout.setBounds(298, 49, 92, 24);
		contentPane.add(btnSignout);
		
		//textfield for searching
		txSearchTotal = new JTextField();
		txSearchTotal.setFont(new Font("굴림", Font.PLAIN, 20));
		txSearchTotal.setText("  search..");
		txSearchTotal.setColumns(10);
		txSearchTotal.setBounds(468, 33, 268, 35);
		contentPane.add(txSearchTotal);
		
		//button for searching
		JButton btnSearchTotal = new JButton("");
		btnSearchTotal.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\calmtec\\image\\search_m.png"));
		btnSearchTotal.setBackground(Color.WHITE);
		btnSearchTotal.setBounds(750, 33, 39, 35);
		contentPane.add(btnSearchTotal);
		
		//label for name
		JLabel lblName = new JLabel("name");
		lblName.setFont(new Font("Arial", Font.PLAIN, 20));
		lblName.setBounds(83, 119, 48, 36);
		contentPane.add(lblName);
		
		//text field for name
		tfName = new JTextField(); //## 사용자 이름 뿌려줘야 함
		tfName.setFont(new Font("굴림", Font.PLAIN, 20));
		tfName.setEditable(false);
		tfName.setColumns(10);
		tfName.setBounds(145, 121, 435, 36);
		contentPane.add(tfName);
		
		//label for user number
		JLabel lblUserNo = new JLabel("User No.");
		lblUserNo.setFont(new Font("Arial", Font.PLAIN, 15));
		lblUserNo.setBounds(594, 111, 92, 36);
		contentPane.add(lblUserNo);
		
		//text field for user number
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(594, 138, 211, 24);
		contentPane.add(textField);
		
		//laber for email
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 20));
		lblEmail.setBounds(78, 167, 53, 36);
		contentPane.add(lblEmail);
		
		//text field for email
		tfEmail = new JTextField(); //## 사용자 이메일 뿌려줘야 함
		tfEmail.setFont(new Font("굴림", Font.PLAIN, 20));
		tfEmail.setEditable(false);
		tfEmail.setColumns(10);
		tfEmail.setBounds(145, 169, 435, 36);
		contentPane.add(tfEmail);
		
		//label for password
		JLabel lblPassword = new JLabel("password");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPassword.setBounds(44, 214, 86, 36);
		contentPane.add(lblPassword);
		
		//password field for password
		tfPassword = new JPasswordField(); //##사용자가 입력했다면 새로운 정보 디비에 저장행야 함
		tfPassword.setFont(new Font("굴림", Font.PLAIN, 20));
		tfPassword.setBounds(145, 217, 435, 34);
		contentPane.add(tfPassword);
		
		//label for bank account
		JLabel lblBankaccount = new JLabel("bank account");
		lblBankaccount.setFont(new Font("Arial", Font.PLAIN, 20));
		lblBankaccount.setBounds(14, 263, 116, 36);
		contentPane.add(lblBankaccount);
		
		//text field for account
		tfBankaccount = new JTextField(); //##사용자가 입력했다면 새로운 정보 디비에 저장해야함
		tfBankaccount.setFont(new Font("굴림", Font.PLAIN, 20));
		tfBankaccount.setColumns(10);
		tfBankaccount.setBounds(145, 263, 317, 36);
		contentPane.add(tfBankaccount);
		
		//combo box for bank
		JComboBox comboBox = new JComboBox(); //## 사용자가 입력한대로 새로운 은행정보 저장
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"KB", "KEB", "SHINHAN", "WOORI"}));
		comboBox.setFont(new Font("굴림", Font.PLAIN, 18));
		comboBox.setBounds(476, 269, 104, 24);
		contentPane.add(comboBox);
		
		//check box for interest
		JCheckBox cbxArts = new JCheckBox("arts");
		cbxArts.setFont(new Font("굴림", Font.PLAIN, 17));
		cbxArts.setBounds(24, 308, 62, 27);
		contentPane.add(cbxArts);
		JCheckBox cbxAntique = new JCheckBox("antique");
		cbxAntique.setFont(new Font("굴림", Font.PLAIN, 17));
		cbxAntique.setBounds(92, 307, 86, 27);
		contentPane.add(cbxAntique);
		JCheckBox cbxClothe = new JCheckBox("clothe");
		cbxClothe.setFont(new Font("굴림", Font.PLAIN, 17));
		cbxClothe.setBounds(184, 307, 78, 27);
		contentPane.add(cbxClothe);
		JCheckBox cbxInterior = new JCheckBox("interior");
		cbxInterior.setFont(new Font("굴림", Font.PLAIN, 17));
		cbxInterior.setBounds(268, 307, 78, 27);
		contentPane.add(cbxInterior);
		JCheckBox cbxJewelry = new JCheckBox("jewelry");
		cbxJewelry.setFont(new Font("굴림", Font.PLAIN, 17));
		cbxJewelry.setBounds(352, 308, 78, 27);
		contentPane.add(cbxJewelry);
		JCheckBox cbxTech = new JCheckBox("tech");
		cbxTech.setFont(new Font("굴림", Font.PLAIN, 17));
		cbxTech.setBounds(436, 307, 62, 27);
		contentPane.add(cbxTech);
		JCheckBox cbxShoes = new JCheckBox("shoes");
		cbxShoes.setFont(new Font("굴림", Font.PLAIN, 17));
		cbxShoes.setBounds(504, 307, 78, 27);
		contentPane.add(cbxShoes);
		
		//label for history
		JLabel lblMyhistory = new JLabel("My history");
		lblMyhistory.setFont(new Font("Arial", Font.PLAIN, 20));
		lblMyhistory.setBounds(16, 346, 116, 36);
		contentPane.add(lblMyhistory);
		
		//combo box for option
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Favorite items", "All items", "Arts", "Antique", "Clothes", "Interior", "Jewelry", "Tech", "Shoes"}));
		comboBox_1.setForeground(Color.DARK_GRAY);
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(115, 353, 116, 26);
		contentPane.add(comboBox_1);
		
		//button for searching my history
		JButton btnSeachMy = new JButton("");
		btnSeachMy.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\calmtec\\image\\search.png"));
		btnSeachMy.setBackground(Color.WHITE);
		btnSeachMy.setBounds(260, 353, 26, 24);
		contentPane.add(btnSeachMy);
		
		//text field for searching my history
		txtSearchMy = new JTextField();
		txtSearchMy.setText("  search..");
		txtSearchMy.setColumns(10);
		txtSearchMy.setBounds(295, 353, 257, 24);
		contentPane.add(txtSearchMy);
		
		//table surrounded with scroll for history list
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 384, 538, 159);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Start Date", "End Date", "Product", "Cattegory", "Price", "Condition"
			}
		));
		scrollPane.setViewportView(table);
		
		//button for going to WaitingPage
		JButton btnBacktomain = new JButton("BACK TO MAIN");
		btnBacktomain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WaitingPage wp = new WaitingPage();
				wp.NewWaiting();
				setVisible(false);
			}
		});
		btnBacktomain.setForeground(new Color(153, 0, 0));
		btnBacktomain.setFont(new Font("Arial", Font.BOLD, 20));
		btnBacktomain.setBackground(Color.WHITE);
		btnBacktomain.setBounds(602, 191, 206, 43);
		contentPane.add(btnBacktomain);
		
		//button for editing my item
		JButton btnEditItem = new JButton("EDIT MY ITEM");
		btnEditItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		btnEditItem.setForeground(new Color(153, 0, 0));
		btnEditItem.setFont(new Font("Arial", Font.BOLD, 20));
		btnEditItem.setBackground(Color.WHITE);
		btnEditItem.setBounds(602, 453, 180, 43);
		contentPane.add(btnEditItem);
		
		JButton btnUploaditem = new JButton("UPLOAD ITEM");
		btnUploaditem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UploadingPage up = new UploadingPage();
				up.NewUploading();
				setVisible(false);
			}
		});
		btnUploaditem.setForeground(new Color(153, 0, 0));
		btnUploaditem.setFont(new Font("Arial", Font.BOLD, 20));
		btnUploaditem.setBackground(new Color(255, 255, 255));
		btnUploaditem.setBounds(602, 388, 180, 42);
		contentPane.add(btnUploaditem);
		
		//button for save information
		JButton btnSavemyinfo = new JButton("SAVE MY INFO");
		btnSavemyinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//##변경된 비번, 어카운트, 은행, 흥미정보를 디비에 다시 저장
			}
		});
		btnSavemyinfo.setForeground(new Color(153, 0, 0));
		btnSavemyinfo.setFont(new Font("Arial", Font.BOLD, 20));
		btnSavemyinfo.setBackground(Color.WHITE);
		btnSavemyinfo.setBounds(602, 269, 206, 43);
		contentPane.add(btnSavemyinfo);
		
		//label copyright
		JLabel copyright = new JLabel("copyright@\u30AB-\u30E0\u30C6\u30AF");
		copyright.setForeground(new Color(153, 153, 153));
		copyright.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 13));
		copyright.setBounds(654, 519, 154, 24);
		contentPane.add(copyright);
		
	}
}

