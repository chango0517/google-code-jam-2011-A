package bottrust;

public class TraceLogger {
	
	public static final int LEVEL_SILENCE = 0;
	public static final int LEVEL_NORMAL = 1;
	public static final int LEVEL_DEBUG = 2;
	
	private int level = LEVEL_NORMAL;
	
	private static TraceLogger instance = null;
	
	public static TraceLogger getInstance(){
		if (instance == null){
			synchronized(TraceLogger.class) {
				if (instance == null){
					instance = new TraceLogger();
				}
			}
		}
		return instance;
	}
	
	public void setLogLevel(int level){
		if(LEVEL_SILENCE <= level && level <= LEVEL_DEBUG){
			this.level = level;
		}
	}
	
	public void writeNormal(String log){
		if(this.level >= LEVEL_NORMAL){
			System.out.println(log);
		}
	}
	
	public void writeDebug(String log){
		if(this.level >= LEVEL_DEBUG){
			System.out.println(log);
		}
	}
	
	public void writeErr(String log){
		System.err.println(log);
	}

}
