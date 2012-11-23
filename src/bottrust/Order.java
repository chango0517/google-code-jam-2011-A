package bottrust;

public class Order {
	
	public int getOrderSeq() {
		return orderSeq;
	}
	public void setOrderSeq(int orderSeq) {
		this.orderSeq = orderSeq;
	}
	public int getPushNum() {
		return pushNum;
	}
	public void setPushNum(int pushNum) {
		this.pushNum = pushNum;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	private int orderSeq;
	private int pushNum;
	private String symbol;

}
