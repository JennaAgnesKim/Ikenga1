package vo;

import java.io.Serializable;

public class Ikenga_TableList implements Serializable {
	String start_date = null;
	String pname = null;
	String category = null;
	int max_price = 0;
	
	public Ikenga_TableList(String start_date, String pname, String category, int max_price) {
		super();
		this.start_date = start_date;
		this.pname = pname;
		this.category = category;
		this.max_price = max_price;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
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

	public void setProduct(String category) {
		this.category = category;
	}

	public int getMax_price() {
		return max_price;
	}

	public void setMax_price(int max_price) {
		this.max_price = max_price;
	}


	public String print() {
		return "Ikenga_TableList [start_date=" + start_date + ", pname=" + pname + ", category=" + category
				+ ", max_price=" + max_price + "]";
	}
	
	
}
