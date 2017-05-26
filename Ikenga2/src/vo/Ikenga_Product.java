package vo;

import java.io.Serializable;
//5¿ù 23ÀÏ ±èÁ¤Çå
public class Ikenga_Product implements Serializable{
	private int product_no;
	private String pname;
	private String category;
	private int min_price;
	private int client_no;
	private String description;
	
	
	public Ikenga_Product(){}
	public Ikenga_Product(int product_no, String pname, String category, int min_price, int client_no,
			String description) {
		super();
		this.product_no = product_no;
		this.pname = pname;
		this.category = category;
		this.min_price = min_price;
		this.client_no = client_no;
		this.description = description;
	}
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getMin_price() {
		return min_price;
	}
	public void setMin_price(int min_price) {
		this.min_price = min_price;
	}
	public int getClient_no() {
		return client_no;
	}
	public void setClient_no(int client_no) {
		this.client_no = client_no;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String print() {
		return "Ikenga_Product [product_no=" + product_no + ", pname=" + pname + ", category=" + category
				+ ", min_price=" + min_price + ", client_no=" + client_no + ", description=" + description + "]";
	}
	
	
	
}
