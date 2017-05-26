package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Locale.Category;

import manager.Manager;
import vo.Ikenga_Auction;
import vo.Ikenga_Client;
import vo.Ikenga_Product;
import vo.Ikenga_TableList;
// 5¿ù 24ÀÏ --- ±èÁ¤Çå
public class ClientManager implements Manager{
	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private ArrayList<Ikenga_Client> cList;
	private ArrayList<Ikenga_Product> pList;
	private ArrayList<Ikenga_Auction> aList;
	private ArrayList<Ikenga_TableList> categroyList;
	
	public ClientManager(){
		cList = new ArrayList<>();
		pList = new ArrayList<>();
		aList = new ArrayList<>();
		
		try {
			socket = new Socket("localhost", 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public Object sendRequest(Object[] request){
		Object receive = null;
		
		try {
			oos.writeObject(request);
			receive = ois.readObject();
			ois.close();
			oos.close();
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return receive;
	}


	@Override
	public boolean register(Ikenga_Client c) {
		Object[] request = {"register", c};
		boolean result = (boolean) sendRequest(request);
		return result;
	}


	@Override
	public boolean pUpload(Ikenga_Product p) {
		Object[] request = {"pUpload", p};
		boolean result = (boolean) sendRequest(request);
		return result;
	}


	@Override
	public boolean pUpdate(Ikenga_Product p) {
		Object[] request = {"pUpdate", p};
		boolean result = (boolean) sendRequest(request);
		return result;
	}


	@Override
	public boolean pDelete(int product_id) {
		Object[] request = {"pDelete",product_id};
		boolean result = (boolean) sendRequest(request);
		return result;
	}


	@Override
	public ArrayList<Ikenga_Product> pSearch(String pname) {
		Object[] request = {"pSearch", pname};
		pList = (ArrayList<Ikenga_Product>)sendRequest(request);
		return pList;
	}


	@Override
	public boolean tender(Ikenga_Product target, int client_id, int price) {
		Object[] request = {"tender", target, client_id, price};
		boolean result = (boolean) sendRequest(request);
		return result;
	}


	@Override
	public int login(String email, char[] pw) {
		Object[] request = {"login", email, pw};
		int result = (int) sendRequest(request);
		return result;
	}


	@Override
	public int checkEmail(String email) {
		Object[] request = {"check", email};
		int result = (int)sendRequest(request);
		return result;
	}


	@Override
	public ArrayList<Ikenga_TableList> auctionList() {
		Object[] request = {"auction"};
		categroyList = (ArrayList<Ikenga_TableList>) sendRequest(request);
		return categroyList;
	}


	
}
