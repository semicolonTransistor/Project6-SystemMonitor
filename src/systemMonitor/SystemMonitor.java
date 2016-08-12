package systemMonitor;

import java.util.Timer;

import mjson.*;

public class SystemMonitor{
	Json systemInfo;
	Timer queryTimer;
	
	public SystemMonitor(){
		queryTimer = new Timer("SystemMontorQuery");
		queryTimer.schedule(new QueryTask(), 0, 1000);
	}
}
