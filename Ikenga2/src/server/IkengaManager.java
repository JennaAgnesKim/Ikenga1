package server;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import manager.Manager;
import vo.Ikenga_Auction;
import vo.Ikenga_Client;
import vo.Ikenga_Product;
import vo.Ikenga_TableList;

public class IkengaManager implements Manager {

	ArrayList<Ikenga_Client> hList;
	ArrayList<Ikenga_Product> pList;
	ArrayList<Ikenga_Auction> aList;
	ArrayList<Ikenga_TableList> categoryList;
	public IkengaManager() {
		hList = new ArrayList<>();
		pList = new ArrayList<>();
		aList = new ArrayList<>();
		categoryList = new ArrayList<>();
		
		boolean result1 = getIHDB();
		if (result1) {
			System.out.println("GET CLIENT DB OK~");
		} else {
			System.out.println("cb fail");
		}
		boolean result2 = getIPDB();
		if (result2) {
			System.out.println("GET PRODUCT DB OK~");
		} else {
			System.out.println("pb fail");
		}

	}

	// getIHDB 메서드는 DB에서 Ikenga_Human를 가지고 오는 메서드
	public boolean getIHDB() {
		boolean result = false;
		Connection conn = ConnectionManager.getConnection();
		String query = "select * from client";
		ResultSet rs = null;

		int client_no = 0;
		String email = null;
		String name = null;
		String pw = null;
		String bank = null;
		String account = null;

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				client_no = rs.getInt(1);
				email = rs.getString(2);
				name = rs.getString(3);
				pw = rs.getString(4);
				bank = rs.getString(5);
				account = rs.getString(6);

				Ikenga_Client ic = new Ikenga_Client();
				hList.add(ic);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// getIPDB DB에 있는 product테이블를 plist에 담는다
	public boolean getIPDB() {
		boolean result = false;
		Connection conn = ConnectionManager.getConnection();
		String query = "select * from product";
		ResultSet rs = null;

		int product_no = 0;
		String pname = null;
		String category = null;
		int min_price = 0;
		int client_no = 0;
		String description = null;

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				product_no = rs.getInt(1);
				pname = rs.getString(2);
				category = rs.getString(3);
				min_price = rs.getInt(4);
				client_no = rs.getInt(5);
				description = rs.getString(6);

				Ikenga_Product ip = new Ikenga_Product(product_no, pname, category, min_price, client_no, description);
				pList.add(ip);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public boolean getIADB() {
		boolean result = false;
		Connection conn = ConnectionManager.getConnection();
		String query = "select * from auction";
		ResultSet rs = null;

		int auction_no = 0;
		int product_no = 0;
		int client_no = 0;
		int min_price = 0;
		String start_date = null;
		String end_date = null;
		int max_price = 0;
		String winner = null;

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				auction_no = rs.getInt(1);
				product_no = rs.getInt(2);
				client_no = rs.getInt(3);
				min_price = rs.getInt(4);
				start_date = rs.getString(5);
				end_date = rs.getString(6);
				max_price = rs.getInt(7);
				winner = rs.getString(8);

				Ikenga_Auction ia = new Ikenga_Auction(auction_no, product_no, client_no, min_price, start_date,
						end_date, max_price, winner);
				aList.add(ia);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean register(Ikenga_Client c) {
		boolean result = false;
		Connection conn = ConnectionManager.getConnection();
		String query = "INSERT INTO client VALUES (client_seq.NEXTVAL, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, c.getEmail().toLowerCase());
			pstmt.setString(2, c.getName().toUpperCase());
			pstmt.setString(3, c.getPw());
			pstmt.setString(4, c.getCategory());
			pstmt.setString(5, c.getBank());
			pstmt.setString(6, c.getAccount());

			int r = pstmt.executeUpdate();
			if (r == 1) {
				result = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean pUpload(Ikenga_Product p) {
		boolean result = false;

		Connection conn = ConnectionManager.getConnection();

		String query = "INSERT INTO product(product_no, pname, category, min_price, client_no, description)VALUES (product_seq.NEXTVAL, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, p.getPname());
			pstmt.setString(2, p.getCategory());
			pstmt.setInt(3, p.getMin_price());
			pstmt.setInt(4, p.getClient_no());
			pstmt.setString(5, p.getDescription());

			if (pstmt.executeUpdate() == 1) {
				Connection conn2 = ConnectionManager.getConnection();
				String query2 = "INSERT INTO auction(auction_no, product_no, client_no, min_price) values (auction_seq.NEXTVAL, ?, ?, ?)";
				PreparedStatement pstmt2 = conn2.prepareStatement(query2);
				pstmt2.setInt(1, p.getProduct_no());
				pstmt2.setInt(2, p.getClient_no());
				pstmt2.setInt(3, p.getMin_price());

				if (1 == pstmt2.executeUpdate()) {
					result = true;
				}
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean pDelete(int product_no) {
		boolean result = false;
		Connection conn = ConnectionManager.getConnection();
		String query = "delete from auction where PRODUCT_ID = '" + product_no + "'";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			if (pstmt.executeUpdate() == 1) {
				Connection conn2 = ConnectionManager.getConnection();
				String query1 = "delete from product where PRODUCT_ID = '" + product_no + "'";
				PreparedStatement pstmt2 = conn2.prepareStatement(query1);
				if (pstmt2.executeUpdate() == 1) {
					result = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public ArrayList<Ikenga_Product> pSearch(String pname) {
		ArrayList<Ikenga_Product> tempList = new ArrayList<>();
		for (Ikenga_Product ip : pList) {
			if (pname.equals(ip.getPname())) {
				tempList.add(ip);
			}
		}
		return tempList;
	}

	@Override
	
	// 재나상 고객이 상품을 올리고나서 잘못올린거 같아서 수정할때 쓰는 메서드입니다.
	public boolean pUpdate(Ikenga_Product p) {
		boolean result = false;
		Connection conn = ConnectionManager.getConnection();
		String query = "UPDATE product SET PNAME = ?, CATEGORY = ?, DESCRIPTION = ? WHERE PRODUCT_ID = ?"; 
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, p.getPname());
			pstmt.setString(2, p.getCategory());
			pstmt.setString(3, p.getDescription());
			if(1 == pstmt.executeUpdate()){
				result = true;
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean tender(Ikenga_Product target, int client_id, int price) {
		boolean result = true;
		ResultSet rs = null;

		int max_price = 0;
		if(target.getMin_price() < price ){
			Connection conn = ConnectionManager.getConnection();
			String query = "Select MAX_PRICE from auction where product_no = '" +target.getProduct_no()+"'";
			try {
				PreparedStatement pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();
				if(rs.next()){
					max_price = rs.getInt(1);
					if(max_price < price){
						Connection conn2 = ConnectionManager.getConnection();
						String query2 = "update auction set MAX_PRICE = ?, WINNER = ? WHERE product_no = '"+target.getProduct_no()+"'";
						PreparedStatement pstmt2 = conn2.prepareStatement(query2);
						pstmt2.setInt(1, price);
						pstmt2.setInt(2, client_id);
						pstmt2.executeQuery();
							
						}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	/* 리턴 값
	 * 
	 * 0 : 이메일이 존재하지 않음.
	 * 1 : 로그인 성공
	 * 2 : 비밀번호가 맞지 않음
	 * */
	public int login(String email, char[] pw) {
		String password = "";
		for(int i = 0 ; i < pw.length ;i++){
			password += pw[i]; 
		}
		int result = 0;
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		
		String getEMail = null;
		String getPw = null;
		String query = "Select email, pw from client where email = '" + email + "'";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()){
				getEMail = rs.getString(1);
				getPw = rs.getString(2);
					if(getEMail.toLowerCase().equalsIgnoreCase(email.toLowerCase()) && getPw.equals(password)){
						result = 1;
						
					}else{
						result = 2;
					}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return result;
	}

	@Override
	/*
	 * 0의 결과값 : 이메일 중복값없음
	 * 1의 결과값 : 이메일 중복값 찾음
	 * 2의 결과값 : 올바르지 않은 이메일
	 * */
	
	public int checkEmail(String email) {
		int result = 0;
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		boolean firstCheck = email.matches(EMAIL_REGEX);
		if(firstCheck){
			Connection conn = ConnectionManager.getConnection();
			String query = "select email from client where email ='" + email + "'";
			ResultSet rs = null;
			String getEmail = null;
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();
				
				if(rs.next()){
					getEmail = rs.getString(1);
					if(getEmail.equalsIgnoreCase(email)){
						result = 1;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			result = 2;
		}
		
		
		
		
		
		return result;
	}

	@Override
	public ArrayList<Ikenga_TableList> auctionList() {
		categoryList = new ArrayList();
		Connection conn = ConnectionManager.getConnection();
		String query = "select auction.start_date, product.pname, product.category, auction.max_price from product, auction where product.product_no=auction.product_no";
		
		ResultSet rs = null;
		String start_date = null;
		String pname = null;
		String category = null;
		int max_price = 0;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()){
				start_date = rs.getString(1);
				pname = rs.getString(2);
				category = rs.getString(3);
				max_price = rs.getInt(4);
				Ikenga_TableList table =  new Ikenga_TableList(start_date, pname, category, max_price);
				categoryList.add(table);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return categoryList; 
		
	}




}
