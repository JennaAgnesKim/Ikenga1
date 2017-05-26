package manager;

import java.util.ArrayList;

import vo.Ikenga_Client;
import vo.Ikenga_Product;
import vo.Ikenga_TableList;

public interface Manager {
	
	// 회원등록 인터페이스
	public boolean register(Ikenga_Client c);
	
	// 상품 업로드 인터페이스
	public boolean pUpload(Ikenga_Product p);
	
	// 상품 업데이트 인터페이스
	public boolean pUpdate(Ikenga_Product p);
	
	// 상품 삭제 인터페이스
	public boolean pDelete(int product_id);
	
	// 상품 검색 인터페이스 
	public ArrayList<Ikenga_Product> pSearch(String pname);	

	// 입찰 인터페이스
	public boolean tender(Ikenga_Product target, int client_id, int price);
	
	// 로그인 인터페이스
	public int login(String email, char[] pw);

	// 이메일 중복 확인 검사
	public int checkEmail(String email);
	
	//리프레쉬 인터페이스 - 날짜 검색하여 테이블에서 날짜 지난것 옥션물품을 삭제또는 새로운 테이블로 이동
	public ArrayList<Ikenga_TableList> auctionList();
	
	
}
