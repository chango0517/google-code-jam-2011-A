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
			//��ԍŏ��̏���
			if(tokenCnt==0){
				//�擪�g�[�N�����牟���Ȃ���΂Ȃ�Ȃ����{�^�������擾
				plan.setPushTotalNum(Integer.parseInt(token));
			}else if(tokenCnt % 2 == 1){
				order = new Order();
				orderCnt++;
				//�擪�ȍ~�̊�g�[�N������ǂ���̃��{�b�g�ւ̃I�[�_�[���擾
				order.setSymbol(token);
				//���̃I�[�_�[���S�̂ŉ��Ԗڂ���������order�ɂ߂�
				order.setOrderSeq(orderCnt);
			}else if(tokenCnt % 2 == 0){
				//�擪�ȍ~�̋����g�[�N�����牟���Ȃ���΂Ȃ�Ȃ��{�^���̔ԍ����擾
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
