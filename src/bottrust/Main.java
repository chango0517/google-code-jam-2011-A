package bottrust;
import java.util.ArrayList;
import java.util.List;


public class Main {
	
	private static int INDEX_TEST_NUM = 0; //テスト数が格納されているindex

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> inputList = new ArrayList<String>();
		inputList.add("3");
		inputList.add("4 O 2 B 1 B 2 O 4");
		inputList.add("3 O 5 O 8 B 100");
		inputList.add("2 B 2 B 1");
		
		TraceLogger.getInstance().setLogLevel(TraceLogger.LEVEL_NORMAL);
		
		//入力値のサイズチェック
		if(inputList ==null || inputList.size() == 0){
			TraceLogger.getInstance().writeErr("---- no input err ----");
			return;
		}
		
		//リストの先頭行チェック
		int testNum = 0;
		try{
			testNum = Integer.valueOf(inputList.get(INDEX_TEST_NUM));
		}catch(NumberFormatException e){
			TraceLogger.getInstance().writeErr("---- illegal input err -----");
		}
		
		SequenceParser parser = new SequenceParser();
		MasterMind masterMind = new MasterMind();
		
		for (int cnt = 1; cnt < testNum + 1; cnt++) {
			SequencePlan plan = parser.parse(cnt, inputList.get(cnt));
			masterMind.execute(plan);
		}
	}

}
