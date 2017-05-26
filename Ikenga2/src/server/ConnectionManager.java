package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {

	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String user = "hr";
	private static String password = "hr";

	private ConnectionManager() {
	}

	static {
		try {
			Class.forName(driver);
			System.out.println("����̹� ���� ����");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("����̺� ���� ����");
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("������ ���̽� ���� ����");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("������ ���̽� ���� ����");
		}
		
		return conn;

	}
}