package bottrust;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SequencePlan {
	
	 private int caseNum = 0;
	 private int pushTotalNum = 0;
	 
	 private List orderList;
	 
	 public SequencePlan(){
		 orderList = new ArrayList<Order>();
	 }
	 
	 public void addOrder(Order order){
		 orderList.add(order);
	 }
	 
	 public int size(){
		 return orderList.size();
	 }
	 
	 public Order getOrder(int index){
		 return (Order) orderList.get(index);
	 }

	public int getPushTotalNum() {
		return pushTotalNum;
	}

	public void setPushTotalNum(int pushTotalNum) {
		this.pushTotalNum = pushTotalNum;
	}

	public int getCaseNum() {
		return caseNum;
	}

	public void setCaseNum(int caseNumber) {
		this.caseNum = caseNumber;
	}
	 
	
}
