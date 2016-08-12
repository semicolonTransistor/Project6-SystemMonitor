package systemMonitor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TimerTask;
import mjson.Json;
import util.*;

public class QueryTask extends TimerTask {
	
	static final String cpuInfoFilePath = "/proc/stat";

	@Override
	public void run() {
		getCpuTime();
	}
	
	Json getCpuTime(){
		Json result = Json.array();
		BufferedReader reader = null;
		try{
			System.out.println("query");
			reader = new BufferedReader(new FileReader(new File(cpuInfoFilePath)));
			String buf = "";
			String thisLine = null;
			
			while((thisLine = reader.readLine()) != null){
				buf += (thisLine + "\n");
			}
			String[] cpuInfos = buf.split("\n");
			
			for(int index = 0;index < cpuInfos.length;++index){
				if(cpuInfos[index].startsWith("cpu")){
					Json cpu = Json.object();
					String[] cpuInfo = cpuInfos[index].split(" ");
					String cpuNumStr = cpuInfo[0].substring(3);
					if(cpuNumStr.isEmpty()){
						cpu.set("cpu_num", -1);
					}else{
						cpu.set("cpu_num", Integer.parseUnsignedInt(cpuNumStr));
					}
					result.add(cpu);
					
				}else{
					break;
				}
			}
			System.out.println(result);
		}catch(Exception e){
			result = null;
			e.printStackTrace();
		}finally{
			if(reader != null){
				try{
					reader.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}
