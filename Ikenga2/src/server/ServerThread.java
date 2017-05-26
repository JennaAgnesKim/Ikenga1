package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.SocketException;

import vo.Ikenga_Client;
import vo.Ikenga_Product;

public class ServerThread implements Runnable {
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private IkengaManager im;
	private boolean exit = false;

	public ServerThread(ObjectOutputStream oos, ObjectInputStream ois) {
		im = new IkengaManager();
		this.oos = oos;
		this.ois = ois;
	}

	@Override
	public void run() {
		while (!exit) {
			try {
				Object[] obj = null;
				try {
					obj = (Object[]) ois.readObject();
				} catch (SocketException se) {
					System.out.println("클라이언트에서 접속 종료...");
					break;
				}
				String key = (String) obj[0];
				Object send = null;
				switch (key) {
				case "register":
					send = im.register((Ikenga_Client) obj[1]);
					break;
				case "pUpload":
					send = im.pUpload((Ikenga_Product) obj[1]);
					break;
				case "pUpdate":
					send = im.pUpdate((Ikenga_Product) obj[1]);
					break;
				case "pDelete":
					send = im.pDelete((int) obj[1]);
					break;
				case "pSearch":
					send = im.pSearch((String) obj[1]);
					break;
				case "tender":
					send = im.tender((Ikenga_Product) obj[1], (int) obj[2], (int) obj[3]);
					break;
				case "login":
					send = im.login((String)obj[1], (char[])obj[2]);
					break;
				case "check":
					send = im.checkEmail((String)obj[1]);
					break;
				case "auction":
					send = im.auctionList();
				default:
					break;
				}
				oos.writeObject(send);
				oos.reset();
				oos.close();
				ois.close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				exit = true;
			} catch (IOException e) {
				e.printStackTrace();
				exit = true;
			}
		}

	}

}
