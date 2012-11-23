package bottrust;

public class Bot {
	
	private String botName;
	private int nowPosition = 1;
	private Order nowOrder = null;
	private boolean isPriority = false;
	private boolean isCompleted = false;

	public Bot(String name){
		this.botName = name;
	}
	
	public Order getNowOrder() {
		return nowOrder;
	}
	
	public String getRobotName() {
		return botName;
	}
	
	public int getNowPosition() {
		return nowPosition;
	}
	
	public void setNowPosition(int nowPosition) {
		this.nowPosition = nowPosition;
	}

	public void setNowOrder(Order nowOrder) {
		this.nowOrder = nowOrder;
	}
	
	public boolean isPriority() {
		return isPriority;
	}
	
	public void setPriority(boolean isPriority) {
		this.isPriority = isPriority;
	}
	
	public void actOneSecond(){
		//���ݎ��s���ׂ����߂�������Αҋ@�I�I
		if(isCompleted()){
			TraceLogger.getInstance().writeDebug(this.botName + ":" + "Stay button " + this.nowPosition);
		}else if(getNowOrder().getPushNum()==nowPosition){
			//�ړI�n�ɓ��������ꍇ�́A�{�^���������Ă����̂������҂̂��ōs�����ς��
			if(isPriority()){
				setNowOrder(null);
				TraceLogger.getInstance().writeDebug(this.botName + ":" + "Push button " + nowPosition);
			}else{
				TraceLogger.getInstance().writeDebug(this.botName + ":" + "Stay button " + this.nowPosition);
			}
		}else{
			setNowPosition((int) (nowPosition + Math.signum(nowOrder.getPushNum() - nowPosition)));
			TraceLogger.getInstance().writeDebug(this.botName + ":" + "Move to button " + nowPosition);
		}
	}
	
	public int getNowOrderSeq(){
		return nowOrder != null ? nowOrder.getOrderSeq() : -1;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

}
