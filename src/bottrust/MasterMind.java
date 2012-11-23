package bottrust;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MasterMind {
	
	private Iterator<Order> orangeIterator;
	private Iterator<Order> blueIterator;
	private Bot orangeBot;
	private Bot blueBot;
	
	public MasterMind(){
		init();
	}
	
	public void init(){
		
	}
	
	public void execute(SequencePlan plan){
		long tmpSecond = 0;
		//�󂯎�����菇�����獡��̃I�����W�{�b�g�ƃu���[�{�b�g�̍s���\����쐬
		List<Order> orangeOrderList = new ArrayList<Order>();
		List<Order> blueOrderList = new ArrayList<Order>();
		for (int i = 0; i < plan.size(); i++) {
			Order order = plan.getOrder(i);
			if(BotCommon.SYMBOL_ORABGE.equals(order.getSymbol())){
				orangeOrderList.add(order);
			}else if(BotCommon.SYMBOL_BLUE.equals(order.getSymbol())){
				blueOrderList.add(order);
			}
		}
		orangeIterator = orangeOrderList.iterator();
		blueIterator = blueOrderList.iterator();
		//�{�b�g���̂𐶐�
		orangeBot = new Bot("Orange");
		blueBot = new Bot("Blue");
		//����̖��߃Z�b�g
		setOrder();
		
		//�I�����W�A�u���[�����Ƃ��s�������ɂȂ�܂ŏ����𑱍s
		while(!(orangeBot.isCompleted() && blueBot.isCompleted())){
			tmpSecond++;
			TraceLogger.getInstance().writeDebug("-----" + tmpSecond + "�b��-----");
			actOneSecond();
		}
		if(tmpSecond > 0){
			TraceLogger.getInstance().writeNormal("Case #" + plan.getCaseNum() + ": " + tmpSecond);
		}
	}
	
	private void setOrder(){
		if(orangeBot.getNowOrder() == null){
			if(orangeIterator.hasNext()){
				orangeBot.setNowOrder((Order)orangeIterator.next());
			}else{
				orangeBot.setCompleted(true);
			}
		}
		if(blueBot.getNowOrder() == null){
			if(blueIterator.hasNext()){
				blueBot.setNowOrder((Order)blueIterator.next());
			}else{
				blueBot.setCompleted(true);
			}
		}
	}
	
	/**
	 * ��b�P�ʂ̓���
	 */
	private void actOneSecond(){
		checkPriority();		
		orangeBot.actOneSecond();
		blueBot.actOneSecond();
		setOrder();
	}
	
	/**
	 * �D�揇�ʂ̃`�F�b�N
	 */
	private void checkPriority(){
		orangeBot.setPriority(false);
		blueBot.setPriority(false);
		if(blueBot.isCompleted() || (!orangeBot.isCompleted() && orangeBot.getNowOrderSeq() < blueBot.getNowOrderSeq())){
			orangeBot.setPriority(true);
		}else if(orangeBot.isCompleted() || (!blueBot.isCompleted() && blueBot.getNowOrderSeq() < orangeBot.getNowOrderSeq())){
			blueBot.setPriority(true);
		}
	}

}
