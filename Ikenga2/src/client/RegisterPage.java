package client;

import java.awt.Checkbox;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vo.Ikenga_Client;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class RegisterPage extends JFrame  {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfEmail;
	private JTextField tfAccount;
	private JPasswordField tfPw1;
	private JPasswordField tfPw2;
	private ClientManager cm;
	private boolean verify;

	/**
	 * Launch the application.
	 */
	public static void NewRegister() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage frame = new RegisterPage();
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
	public RegisterPage() {
		
		//create window
		setTitle("Register"); //set title of window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//shutdown program when close the window
		setBounds(100, 100, 840, 600);//size of window
		
		//create contentPane
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255)); //size of pane
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//label for logo of Ikenga
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\calmtec\\image\\ikenga.png"));
		lblLogo.setBounds(14, 12, 62, 76);
		contentPane.add(lblLogo);
		
		//label for welcome
		JLabel lblHead = new JLabel("REGISTER");
		lblHead.setFont(new Font("Arial", Font.BOLD, 45));
		lblHead.setBounds(84, 12, 239, 76);
		contentPane.add(lblHead);
		
		//label for name
		JLabel lblName = new JLabel("name");
		lblName.setFont(new Font("Arial", Font.PLAIN, 20));
		lblName.setBounds(132, 129, 48, 36);
		contentPane.add(lblName);
		
		//text field for name
		tfName = new JTextField();
		tfName.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		tfName.setBounds(194, 131, 415, 36);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		//label for email
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 20));
		lblEmail.setBounds(127, 177, 53, 36);
		contentPane.add(lblEmail);
		
		//text field for email
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		tfEmail.setColumns(10);
		tfEmail.setBounds(194, 179, 415, 36);
		contentPane.add(tfEmail);
		
		//button for verifying email
		JButton btnVerifyingEmail = new JButton("verify e-mail");
		btnVerifyingEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cm = new ClientManager();
				int result = cm.checkEmail(tfEmail.getText());
				if(result == 0){
					JOptionPane.showMessageDialog(null, "vaild e-mail");
					tfEmail.setEditable(false);
					verify = true;
				}
				else if(result == 1){
					JOptionPane.showMessageDialog(null, "e-mail entered already registered");
				}
				else {
					JOptionPane.showMessageDialog(null, "invaild e-mail");
				}
			}
		});
		btnVerifyingEmail.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		btnVerifyingEmail.setBounds(645, 184, 116, 27);
		contentPane.add(btnVerifyingEmail);
		
		//label for password
		JLabel lblPassword = new JLabel("password");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPassword.setBounds(94, 225, 86, 36);
		contentPane.add(lblPassword);
		
		//text field for password
		tfPw1 = new JPasswordField();
		tfPw1.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		tfPw1.setBounds(193, 227, 416, 34);
		contentPane.add(tfPw1);
		
		//label for confirm password
		JLabel lblConfirmPw = new JLabel("confirm pw");
		lblConfirmPw.setFont(new Font("Arial", Font.PLAIN, 20));
		lblConfirmPw.setBounds(84, 275, 96, 36);
		contentPane.add(lblConfirmPw);
		
		//text field for confirm password
		tfPw2 = new JPasswordField();
		tfPw2.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		tfPw2.setBounds(194, 275, 416, 34);
		contentPane.add(tfPw2);
		
		//label for bank account
		JLabel lblBankAccount = new JLabel("bank account");
		lblBankAccount.setFont(new Font("Arial", Font.PLAIN, 20));
		lblBankAccount.setBounds(64, 323, 116, 36);
		contentPane.add(lblBankAccount);
		
		//text field for bank account
		tfAccount = new JTextField();
		tfAccount.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		tfAccount.setColumns(10);
		tfAccount.setBounds(194, 323, 415, 36);
		contentPane.add(tfAccount);
		
		//label for interest
		JLabel lblInterest = new JLabel("interest");
		lblInterest.setFont(new Font("Arial", Font.PLAIN, 20));
		lblInterest.setBounds(115, 371, 65, 36);
		contentPane.add(lblInterest);
		
		//comboBox for interest
		JComboBox cbBank = new JComboBox();
		cbBank.setForeground(new Color(153, 0, 0));
		cbBank.setBackground(new Color(255, 255, 255));
		cbBank.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		cbBank.setModel(new DefaultComboBoxModel(new String[] {"KB", "KEB", "SHINHAN", "WOORI"})); //bank options
		cbBank.setBounds(623, 329, 104, 24);
		contentPane.add(cbBank);
		
		JCheckBox chckbxArts = new JCheckBox("arts");
		chckbxArts.setFont(new Font("±¼¸²", Font.PLAIN, 17));
		chckbxArts.setBounds(194, 378, 62, 27);
		contentPane.add(chckbxArts);
		
		JCheckBox chckbxAntique = new JCheckBox("antique");
		chckbxAntique.setFont(new Font("±¼¸²", Font.PLAIN, 17));
		chckbxAntique.setBounds(262, 377, 86, 27);
		contentPane.add(chckbxAntique);
		
		JCheckBox chckbxClothe = new JCheckBox("clothe");
		chckbxClothe.setFont(new Font("±¼¸²", Font.PLAIN, 17));
		chckbxClothe.setBounds(354, 377, 78, 27);
		contentPane.add(chckbxClothe);
		
		JCheckBox chckbxInterior = new JCheckBox("interior");
		chckbxInterior.setFont(new Font("±¼¸²", Font.PLAIN, 17));
		chckbxInterior.setBounds(438, 377, 78, 27);
		contentPane.add(chckbxInterior);
		
		JCheckBox chckbxJewelry = new JCheckBox("jewelry");
		chckbxJewelry.setFont(new Font("±¼¸²", Font.PLAIN, 17));
		chckbxJewelry.setBounds(522, 378, 78, 27);
		contentPane.add(chckbxJewelry);
		
		JCheckBox chckbxShoes = new JCheckBox("shoes");
		chckbxShoes.setFont(new Font("±¼¸²", Font.PLAIN, 17));
		chckbxShoes.setBounds(674, 377, 78, 27);
		contentPane.add(chckbxShoes);
		
		JCheckBox chckbxTech = new JCheckBox("tech");
		chckbxTech.setFont(new Font("±¼¸²", Font.PLAIN, 17));
		chckbxTech.setBounds(606, 377, 62, 27);
		contentPane.add(chckbxTech);
		
		
		//button for register
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				String email = tfEmail.getText();
				char[] pw = tfPw1.getPassword();
				char[] checkpw = tfPw2.getPassword();
				String account = tfAccount.getText();
				String bank = (String) cbBank.getSelectedItem();
				String category = null;
				if(chckbxAntique.isSelected()) category += "antique";
				if(chckbxArts.isSelected()) category += "arts";
				if(chckbxClothe.isSelected()) category += "clothe";
				if(chckbxInterior.isSelected()) category += "interior";
				if(chckbxJewelry.isSelected()) category += "jewelry";
				if(chckbxShoes.isSelected()) category += "shoes";
				if(chckbxTech.isSelected()) category += "tech";	
				
				if(verify){	
					if(!pw.equals(checkpw)){
						cm = new ClientManager();
						String password = "";
						
						for(int i = 0 ; i < pw.length ;i++){
							password += pw[i]; 
						}
						
						Ikenga_Client ic = new Ikenga_Client(0, email, name, password, category, bank, account); 
						
						if(cm.register(ic)){
							JOptionPane.showMessageDialog(null, "Registration successful!");
							MainPage.newMain();
							setVisible(false);
						}
					}
					
					else{
						JOptionPane.showMessageDialog(null, "Password is incorrect.");
						tfPw1.setText("");
						tfPw2.setText("");
					}
			}
				
			else{
			JOptionPane.showMessageDialog(null, "e-mail is incorrect.");
			}
				
			}
		});
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Arial", Font.BOLD, 25));
		btnRegister.setBackground(new Color(153, 0, 0));
		btnRegister.setBounds(502, 429, 166, 51);
		contentPane.add(btnRegister);
		
		//button for back to main
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage mp = new MainPage();
				mp.newMain();
				setVisible(false);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Arial", Font.BOLD, 25));
		btnBack.setBackground(new Color(153, 0, 0));
		btnBack.setBounds(194, 429, 141, 51);
		contentPane.add(btnBack);
		
		//label for copyright
		JLabel lblcopyright = new JLabel("copyright@\u30AB-\u30E0\u30C6\u30AF");
		lblcopyright.setForeground(new Color(153, 153, 153));
		lblcopyright.setFont(new Font("±¼¸²", Font.BOLD | Font.ITALIC, 13));
		lblcopyright.setBounds(654, 519, 154, 24);
		contentPane.add(lblcopyright);
		
//		JButton btnVerifyPassword = new JButton("verify password");
//		btnVerifyPassword.setFont(new Font("±¼¸²", Font.PLAIN, 15));
//		btnVerifyPassword.setBounds(636, 275, 141, 27);
//		contentPane.add(btnVerifyPassword);
	}

}
