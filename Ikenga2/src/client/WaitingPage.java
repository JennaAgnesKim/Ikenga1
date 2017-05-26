//2017.05.23 Jenna Kim aka GUInoTenshai
package client;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JList;

import vo.Ikenga_TableList;

public class WaitingPage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tfSearchingArea;
	
	private ClientManager cm;
	
	private DefaultTableModel tableList;
	ArrayList<Ikenga_TableList> list;
	Object[][] obj = null;
	private final Object[] LIST_CATEGORY = {"Start Date", "Product", "Category", "Price"};	
	
	/**
	 * Launch the application.
	 */
	public static void NewWaiting() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WaitingPage frame = new WaitingPage();
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
	public WaitingPage() {
		
		//create window
		setTitle("Main page");//set title of window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//shutdown program when close the window
		setBounds(100, 100, 840, 600);//size of window
		
		//create contentPane
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//scroll and table
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 110, 525, 346);
		contentPane.add(scrollPane);
		
		table = new JTable();
		showList();
		DefaultTableModel tableList = new DefaultTableModel(obj, LIST_CATEGORY);
		table.setModel(tableList);
		System.out.println(tableList.getRowCount());
		
 		scrollPane.setViewportView(table);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(89);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(87);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(86);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(67);
		
		//button for refresh
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setForeground(new Color(255, 255, 255));
		btnRefresh.setBackground(new Color(153, 0, 0));
		btnRefresh.setFont(new Font("Arial", Font.PLAIN, 20));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//"정헌상~ 전체 테이블 출력 쿼리 입력해주세요" -20170523김재나
				//예시: String query = "select * 테이블이름 밸류 나니나니";
				//예시: PreparedStatement pstmt = connection.preparedStatment(query);
				//예시: pstmt.setString(1, 나니나니);
				//예시: pstmt.close();
			}
		});
		btnRefresh.setBounds(36, 490, 105, 27);
		contentPane.add(btnRefresh);
		
		//combo box for categories
		JComboBox cbSorting = new JComboBox();
		cbSorting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//"정헌상~ 고객이 선택한 제품만 불러오는 쿼리 입력해주세요" -20170523김재나
				//"정헌상~ 전체 테이블 출력 쿼리 입력해주세요" -20170523김재나
				//예시: String query = "select * 테이블이름 밸류 나니나니";
				//예시: PreparedStatement pstmt = connection.preparedStatment(query);
				//예시: pstmt.setString(1, (String)comboBoxName.getSelectedItem());
				//예시: ResultSet rs = pstmt.excuteQuery();
				//While(rs.next()){ 
				//
				// }
				//예시: pstmt.close();
			}
		});
		cbSorting.setForeground(new Color(255, 255, 255));
		cbSorting.setBackground(new Color(255, 255, 255));
		cbSorting.setFont(new Font("Arial", Font.PLAIN, 20));
		cbSorting.setModel(new DefaultComboBoxModel(new String[] {"Favorite items", "All items", "Arts", "Antique", "Clothes", "Interior", "Jewelry", "Tech", "Shoes"}));
		cbSorting.setBounds(407, 490, 154, 26);
		contentPane.add(cbSorting);
		
		//label for logo
		JLabel lblLogo = new JLabel("New label");
		lblLogo.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\calmtec\\image\\ikenga.png"));
		lblLogo.setBounds(36, 22, 62, 76);
		contentPane.add(lblLogo);
		
		//label for header
		JLabel lblTodaysDeal = new JLabel("TODAY'S DEAL!");
		lblTodaysDeal.setFont(new Font("Arial", Font.BOLD, 45));
		lblTodaysDeal.setBounds(112, 22, 352, 76);
		contentPane.add(lblTodaysDeal);
		
		//text field for search
		tfSearchingArea = new JTextField();
		tfSearchingArea.setFont(new Font("굴림", Font.PLAIN, 20));
		tfSearchingArea.setText("  search..");
		tfSearchingArea.setBounds(488, 43, 251, 35);
		contentPane.add(tfSearchingArea);
		tfSearchingArea.setColumns(10);
		
		//button for search
		JButton btnScope = new JButton("");
		btnScope.setBackground(Color.WHITE);
		btnScope.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\calmtec\\image\\search_m.png"));
		btnScope.setBounds(753, 43, 39, 35);
		contentPane.add(btnScope);
		
		//button for upload item
		JButton btnUploaditem = new JButton("UPLOAD ITEM");
		btnUploaditem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UploadingPage up = new UploadingPage();
				up.NewUploading();
				setEnabled(false);
			}
		});
		btnUploaditem.setForeground(Color.WHITE);
		btnUploaditem.setFont(new Font("Arial", Font.BOLD, 25));
		btnUploaditem.setBackground(new Color(153, 0, 0));
		btnUploaditem.setBounds(575, 258, 230, 51);
		contentPane.add(btnUploaditem);
		
		//button for mypage
		JButton btnMypage = new JButton("My page");
		btnMypage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyPage mp = new MyPage();
				mp.NewMypage();
				setVisible(false);
			}
		});
		btnMypage.setForeground(Color.WHITE);
		btnMypage.setFont(new Font("Arial", Font.BOLD, 25));
		btnMypage.setBackground(new Color(153, 0, 0));
		btnMypage.setBounds(575, 150, 230, 51);
		contentPane.add(btnMypage);
		
		//button for sign out
		JButton btnSignout = new JButton("SIGN OUT");
		btnSignout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage mp = new MainPage();
				mp.newMain();
				setVisible(false);
			}
		});
		btnSignout.setForeground(Color.WHITE);
		btnSignout.setFont(new Font("Arial", Font.BOLD, 25));
		btnSignout.setBackground(new Color(153, 0, 0));
		btnSignout.setBounds(575, 368, 230, 51);
		contentPane.add(btnSignout);
		
		//label for copyright
		JLabel lblcopyright = new JLabel("copyright@\u30AB-\u30E0\u30C6\u30AF");
		lblcopyright.setForeground(new Color(153, 153, 153));
		lblcopyright.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 13));
		lblcopyright.setBounds(654, 519, 154, 24);
		contentPane.add(lblcopyright);
	}
	
		//set the data on the table
		public void showList() {
			cm = new ClientManager();
			list = new ArrayList<>();
			list = cm.auctionList();
			obj = new Object[list.size()][4];

			for(int i = 0 ; i < list.size() ; i++){
				obj[i][0] = list.get(i).getStart_date();
				obj[i][1] = list.get(i).getPname();
				obj[i][2] = list.get(i).getCategory();
				obj[i][3] = list.get(i).getMax_price();
				
			}
		}
		
}
