package vo;
//5¿ù 23ÀÏ ±èÁ¤Çå
public class Ikenga_Auction {
	private int auction_no;
	private int product_no;
	private int client_no;
	private int min_price;
	private String start_date;
	private String end_date;
	private int max_price;
	private String winner;
	
	public Ikenga_Auction(){}
	public Ikenga_Auction(int auction_no, int product_no, int client_no, int min_price, String start_date,
			String end_date, int max_price, String winner) {
		super();
		this.auction_no = auction_no;
		this.product_no = product_no;
		this.client_no = client_no;
		this.min_price = min_price;
		this.start_date = start_date;
		this.end_date = end_date;
		this.max_price = max_price;
		this.winner = winner;
	}
	public int getAuction_no() {
		return auction_no;
	}
	public void setAuction_no(int auction_no) {
		this.auction_no = auction_no;
	}
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public int getClient_no() {
		return client_no;
	}
	public void setClient_no(int client_no) {
		this.client_no = client_no;
	}
	public int getMin_price() {
		return min_price;
	}
	public void setMin_price(int min_price) {
		this.min_price = min_price;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public int getMax_price() {
		return max_price;
	}
	public void setMax_price(int max_price) {
		this.max_price = max_price;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}

	public String print() {
		return "Ikenga_Auction [auction_no=" + auction_no + ", product_no=" + product_no + ", client_no=" + client_no
				+ ", min_price=" + min_price + ", start_date=" + start_date + ", end_date=" + end_date + ", max_price="
				+ max_price + ", winner=" + winner + "]";
	}
	
	

}
