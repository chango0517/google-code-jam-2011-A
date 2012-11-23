package bottrust;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class SequenceParser {
	
	public static String DELIM = " ";
	
	public SequenceParser(){
		
	}
	
	public SequencePlan parse(int caseNum, String input){
		SequencePlan plan = new SequencePlan();
		plan.setCaseNum(caseNum);
		StringTokenizer tokenizer = new StringTokenizer(input, DELIM);
		int tokenCnt = 0;
		int orderCnt = 0;
		Order order = null;
		while (tokenizer.hasMoreTokens()) {
			String token = (String) tokenizer.nextToken();
			//一番最初の処理
			if(tokenCnt==0){
				//先頭トークンから押さなければならない総ボタン数を取得
				plan.setPushTotalNum(Integer.parseInt(token));
			}else if(tokenCnt % 2 == 1){
				order = new Order();
				orderCnt++;
				//先頭以降の奇数トークンからどちらのロボットへのオーダーか取得
				order.setSymbol(token);
				//そのオーダーが全体で何番目かも同時にorderにつめる
				order.setOrderSeq(orderCnt);
			}else if(tokenCnt % 2 == 0){
				//先頭以降の偶数トークンから押さなければならないボタンの番号を取得
				order.setPushNum(Integer.parseInt(token));
				plan.addOrder(order);
			}
			tokenCnt++;
		}
		
		
		return plan;
	}
	
	public List parse(List inputs){
		
		return new ArrayList<SequencePlan>();
	}
	
	public SequencePlan[] parse(String[] inputs){
		
		return new SequencePlan[inputs.length];
	}
	
	

}
