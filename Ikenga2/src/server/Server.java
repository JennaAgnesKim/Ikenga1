package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket ssocket = new ServerSocket(8888);
			System.out.println("���� ���� ����");
			while(true){
				Socket socket = ssocket.accept();
				System.out.println("���� �����");
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				ServerThread thread = new ServerThread(oos, ois);
				Thread t = new Thread(thread);
				t.start();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
