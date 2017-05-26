//2017.05.22 Jenna Kim
package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class MainPage extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField tfEmail;
	private JPasswordField tfPw;
	private ClientManager cm;

	/**
	 * Launch the application.
	 */
	public static void newMain() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		//set title of window
		setTitle("Welcome to Ikenga");
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
		
		//label for logo of Ikenga
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\calmtec\\image\\ikenga.png"));
		lblLogo.setBounds(98, 63, 62, 76);
		contentPane.add(lblLogo);
		
		//label for welcome text
		JLabel lblHead = new JLabel("WELCOME TO IKENGA");
		lblHead.setFont(new Font("Arial", Font.BOLD, 45));
		lblHead.setBounds(174, 63, 533, 76);
		contentPane.add(lblHead);
		
		//label for email
		JLabel jlEmail = new JLabel("e-mail");
		jlEmail.setFont(new Font("Arial", Font.BOLD, 25));
		jlEmail.setBounds(137, 201, 71, 36);
		contentPane.add(jlEmail);
		
		//textfield for email
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Arial", Font.BOLD, 25));
		tfEmail.setColumns(10);
		tfEmail.setBounds(224, 198, 458, 51);
		contentPane.add(tfEmail);
		
		//label for password
		JLabel jlPw = new JLabel("password");
		jlPw.setFont(new Font("Arial", Font.BOLD, 25));
		jlPw.setBounds(90, 295, 116, 37);
		contentPane.add(jlPw);
		
		//password field for password
		tfPw = new JPasswordField();
		tfPw.setFont(new Font("Arial", Font.BOLD, 25));
		tfPw.setColumns(10);
		tfPw.setBounds(223, 292, 458, 51);
		contentPane.add(tfPw);
		
		//button for register
		JButton jbtRegi = new JButton("REGISTER");
		jbtRegi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegisterPage rp = new RegisterPage();
				rp.NewRegister(); //Move to RegisterPage
				setVisible(false);
				
			}
		});
		jbtRegi.setForeground(Color.WHITE);
		jbtRegi.setFont(new Font("Arial", Font.BOLD, 25));
		jbtRegi.setBackground(new Color(153, 0, 0));
		jbtRegi.setBounds(240, 411, 166, 51);
		contentPane.add(jbtRegi); 
		
		//button for sing in
		JButton jbtSignin = new JButton("SING IN");
		jbtSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cm = new ClientManager();
				String email = tfEmail.getText();
				char[] pw = tfPw.getPassword();
				
				int result = cm.login(email, pw);
				System.out.println(result);
				
				if(result == 0){
					System.out.println("There's no matching ID");
					JOptionPane.showMessageDialog(null, "There's no matching ID");
				}
				else if (result == 1) {
					WaitingPage wp = new WaitingPage();
					wp.NewWaiting();
					setVisible(false);
				}
				else {
					System.out.println("Unsuccessful login");
					JOptionPane.showMessageDialog(null, "Unsuccesfull login since wrong password");
				}
			}
		});
		jbtSignin.setForeground(Color.WHITE);
		jbtSignin.setFont(new Font("Arial", Font.BOLD, 25));
		jbtSignin.setBackground(new Color(153, 0, 0));
		jbtSignin.setBounds(456, 411, 166, 51);
		contentPane.add(jbtSignin);
		
		//label for copyright
		JLabel copyright = new JLabel("copyright@\u30AB-\u30E0\u30C6\u30AF");
		copyright.setForeground(new Color(153, 153, 153));
		copyright.setFont(new Font("±¼¸²", Font.BOLD | Font.ITALIC, 13));
		copyright.setBounds(654, 519, 154, 24);
		contentPane.add(copyright);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
