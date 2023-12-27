package bean;

public class Process  {
	public String processName;
	public int arrivalTime;
	public int burstTime;
	public int priority;
	public int completionTime;
	public int getCompletionTime() {
		return completionTime;
	}
	public void setCompletionTime(int completionTime) {
		this.completionTime = completionTime;
	}
	public int getTurnAroundTime() {
		return turnAroundTime;
	}
	public void setTurnAroundTime(int turnAroundTime) {
		this.turnAroundTime = turnAroundTime;
	}
	public int getWaitingTime() {
		return waitingTime;
	}
	public void setWaitingTime(int waitingTime) {
		this.waitingTime = waitingTime;
	}
	public int turnAroundTime;
	public int waitingTime;
	public int remainingBurstTime;
	
	public int getRemainingBurstTime() {
		return remainingBurstTime;
	}
	public void setRemainingBurstTime(int remainingBurstTime) {
		this.remainingBurstTime = remainingBurstTime;
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public int getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getBurstTime() {
		return burstTime;
	}
	public void setBurstTime(int burstTime) {
		this.burstTime = burstTime;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public Process(String processName, int arrivalTime, int burstTime, int priority) {
		super();
		this.processName = processName;
		this.arrivalTime = arrivalTime;
		this.burstTime = burstTime;
		this.priority = priority;
	}
	public Process() {
	}
	
	public Process(String processName, int arrivalTime, int burstTime, int priority, int completionTime,
			int turnAroundTime, int waitingTime, int remainingBurstTime) {
		super();
		this.processName = processName;
		this.arrivalTime = arrivalTime;
		this.burstTime = burstTime;
		this.priority = priority;
		this.completionTime = completionTime;
		this.turnAroundTime = turnAroundTime;
		this.waitingTime = waitingTime;
		this.remainingBurstTime = remainingBurstTime;
	}
	@Override
	public String toString() {
		return "Process [processName=" + processName + ", arrivalTime=" + arrivalTime + ", burstTime=" + burstTime
				+ ", priority=" + priority + ", completionTime=" + completionTime + ", turnAroundTime=" + turnAroundTime
				+ ", waitingTime=" + waitingTime + "]";
	}
	
	

}
