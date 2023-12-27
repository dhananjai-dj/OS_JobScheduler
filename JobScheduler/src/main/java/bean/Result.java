package bean;

import java.util.ArrayList;
import java.util.List;

public class Result {
	
	
	String algorithm;
	public String getAlgorithm() {
		return algorithm;
	}
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}
	public int getCompletionTime() {
		return completionTime;
	}
	public void setCompletionTime(int completionTime) {
		this.completionTime = completionTime;
	}
	public int getAverageWaitingTime() {
		return averageWaitingTime;
	}
	public void setAverageWaitingTime(int averageWaitingTime) {
		this.averageWaitingTime = averageWaitingTime;
	}
	public String getProcessOrder() {
		return processOrder;
	}
	public void setProcessOrder(String processOrder) {
		this.processOrder = processOrder;
	}
	int completionTime;
	int averageWaitingTime;
	String processOrder;
	public List<Process> getProcessList() {
		return processList;
	}
	public void setProcessList(List<Process> processList) {
		this.processList = processList;
	}
	List<Process> processList = new ArrayList<Process>();
	
	public Result(String algorithm, int completionTime, int averageWaitingTime, String processOrder,
			List<Process> processList) {
		super();
		this.algorithm = algorithm;
		this.completionTime = completionTime;
		this.averageWaitingTime = averageWaitingTime;
		this.processOrder = processOrder;
		this.processList = processList;
	}
	@Override
	public String toString() {
		return "Result [algorithm=" + algorithm + ", completionTime=" + completionTime + ", averageWaitingTime="
				+ averageWaitingTime + ", processOrder=" + processOrder + "]";
	}
	
}
