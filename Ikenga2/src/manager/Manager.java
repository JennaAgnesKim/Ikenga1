package manager;

import java.util.ArrayList;

import vo.Ikenga_Client;
import vo.Ikenga_Product;
import vo.Ikenga_TableList;

public interface Manager {
	
	// ȸ����� �������̽�
	public boolean register(Ikenga_Client c);
	
	// ��ǰ ���ε� �������̽�
	public boolean pUpload(Ikenga_Product p);
	
	// ��ǰ ������Ʈ �������̽�
	public boolean pUpdate(Ikenga_Product p);
	
	// ��ǰ ���� �������̽�
	public boolean pDelete(int product_id);
	
	// ��ǰ �˻� �������̽� 
	public ArrayList<Ikenga_Product> pSearch(String pname);	

	// ���� �������̽�
	public boolean tender(Ikenga_Product target, int client_id, int price);
	
	// �α��� �������̽�
	public int login(String email, char[] pw);

	// �̸��� �ߺ� Ȯ�� �˻�
	public int checkEmail(String email);
	
	//�������� �������̽� - ��¥ �˻��Ͽ� ���̺��� ��¥ ������ ���ǹ�ǰ�� �����Ǵ� ���ο� ���̺�� �̵�
	public ArrayList<Ikenga_TableList> auctionList();
	
	
}
