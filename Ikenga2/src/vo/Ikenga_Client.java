package vo;

import java.io.Serializable;
//5¿ù 23ÀÏ ±èÁ¤Çå
public class Ikenga_Client implements Serializable {
	private int client_no;
	private String email;
	private String name;
	private String pw;
	private String category;
	private String bank;
	private String account;
	
	public Ikenga_Client() {
	}

	public Ikenga_Client(int client_no, String email, String name, String pw, String category, String bank,
			String account) {
		super();
		this.client_no = client_no;
		this.email = email;
		this.name = name;
		this.pw = pw;
		this.category = category;
		this.bank = bank;
		this.account = account;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getClient_no() {
		return client_no;
	}

	public void setClient_no(int client_no) {
		this.client_no = client_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}


	public String print() {
		return "Ikenga_Client [client_no=" + client_no + ", email=" + email + ", name=" + name + ", pw=" + pw
				+ ", bank=" + bank + ", account=" + account + "]";
	}

}
