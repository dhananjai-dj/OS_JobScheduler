package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import bean.Process;
import bean.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Lists;


@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		    List<bean.Process> processes = Lists.processList;
	        
	        shortestJobFirst(processes);
	        
	        
	        firstComesFirstSchdeuled(processes);
	        
	        
	        prioritySchdeuling(processes);
	        
	        roundRobinScheduling(processes, processes.size());
	        
	        session.setAttribute("resultList", Lists.resultList);
	        response.sendRedirect("Result.jsp");
	}
	
	public static void shortestJobFirst(List<bean.Process>processes) {
		
		List<bean.Process> copyProcesses1 = new ArrayList<>(processes); 
		copyProcesses1.sort(Comparator.comparingInt(p -> p.getArrivalTime()));
		String progressOrder = "";
		int currentTime = 0;
		int totalWaitingTime = 0;
		int n = copyProcesses1.size();

		boolean[] completed = new boolean[n]; 

		for (int i = 0; i < n; i++) {
		    bean.Process current = null;
		    int minBurst = Integer.MAX_VALUE;
		    int selectedProcess = -1;

		    for (int j = 0; j < n; j++) {
		        if (!completed[j] && copyProcesses1.get(j).getArrivalTime() <= currentTime &&
		                copyProcesses1.get(j).getBurstTime() < minBurst) {
		            minBurst = copyProcesses1.get(j).getBurstTime();
		            selectedProcess = j;
		        }
		    }

		    if (selectedProcess != -1) {
		        current = copyProcesses1.get(selectedProcess);
		        current.setCompletionTime(currentTime + current.getBurstTime());
		        current.setTurnAroundTime(current.getCompletionTime() - current.getArrivalTime());
		        current.setWaitingTime(current.getTurnAroundTime() - current.getBurstTime());
		        currentTime = current.getCompletionTime();
		        totalWaitingTime += current.getWaitingTime();
		        completed[selectedProcess] = true; 
		        progressOrder = progressOrder + current.getProcessName() + "-";
		    }
		}
		List<Process>list = copyProcess(copyProcesses1);
		Result shortestJobFirst = new Result("Shortest Job First", currentTime, totalWaitingTime / n, progressOrder.substring(0, progressOrder.length() - 1),list);
		Lists.resultList.add(shortestJobFirst);
	}
	
	public static void firstComesFirstSchdeuled(List<bean.Process>processes) {
		processes.sort(Comparator.comparingInt(p->p.getArrivalTime()));
		String progressOrder = "";
		int currentTime = 0;
		int totalWaitingTime = 0;
		int n = processes.size();
		for (int i = 0; i < n; i++) {
		    Process current = processes.get(i);
		    if (currentTime < current.getArrivalTime()) {
		        currentTime = current.getArrivalTime();
		    }

		    current.setCompletionTime(currentTime + current.getBurstTime());
		    current.setTurnAroundTime(current.getCompletionTime() - current.getArrivalTime());
		    current.setWaitingTime(current.getTurnAroundTime() - current.getBurstTime());
		    currentTime = current.getCompletionTime();
		    totalWaitingTime += current.getWaitingTime();
		    progressOrder=progressOrder+current.processName+"-";
		}
		List<Process> processList = copyProcess(processes);
		Result firstComesFirstScheduled = new Result("First Comes First Scheduled",currentTime,totalWaitingTime/n,progressOrder.substring(0,progressOrder.length()-1),processList);
		Lists.resultList.add(firstComesFirstScheduled);
	}
	
	public static void prioritySchdeuling(List<bean.Process>processes) {
		processes.sort(Comparator.comparingInt(p->p.getPriority()));
		String progressOrder = "";
		int currentTime = 0;
		int totalWaitingTime = 0;
		int n = processes.size();
		for (int i = 0; i < n; i++) {
		    Process current = processes.get(i);
		    if (currentTime < current.getArrivalTime()) {
		        currentTime = current.getArrivalTime();
		    }

		    current.setCompletionTime(currentTime + current.getBurstTime());
		    current.setTurnAroundTime(current.getCompletionTime() - current.getArrivalTime());
		    current.setWaitingTime(current.getTurnAroundTime() - current.getBurstTime());
		    currentTime = current.getCompletionTime();
		    totalWaitingTime += current.getWaitingTime();
		    progressOrder=progressOrder+current.processName+"-";
		}
		List<Process>processList = copyProcess(processes);
		Result priorityScheduling = new Result("Priority Scheduling",currentTime,totalWaitingTime/n,progressOrder.substring(0,progressOrder.length()-1),processList);
		Lists.resultList.add(priorityScheduling);
	}
	public static void roundRobinScheduling(List<Process> processes, int quantum) {
	    List<Process> copyProcesses = new ArrayList<>(processes);
	    String progressOrder = "";
	    int currentTime = 0;
	    int totalWaitingTime = 0;
	    int n = copyProcesses.size();
	    int[] remainingTime = new int[n];

	    for (int i = 0; i < n; i++) {
	        remainingTime[i] = copyProcesses.get(i).getBurstTime();
	    }

	    while (true) {
	        boolean done = true;

	        for (int i = 0; i < n; i++) {
	            Process current = copyProcesses.get(i);

	            if (remainingTime[i] > 0) {
	                done = false;

	                if (remainingTime[i] > quantum) {
	                    currentTime += quantum;
	                    remainingTime[i] -= quantum;
	                    progressOrder += current.getProcessName() + "-";
	                } else {
	                    currentTime += remainingTime[i];
	                    current.setCompletionTime(currentTime);
	                    current.setTurnAroundTime(current.getCompletionTime() - current.getArrivalTime());
	                    current.setWaitingTime(current.getTurnAroundTime() - current.getBurstTime());
	                    totalWaitingTime += current.getWaitingTime();
	                    remainingTime[i] = 0;
	                    progressOrder += current.getProcessName() + "-";
	                }
	            }
	        }

	        if (done) {
	            break;
	        }
	    }
	    List<Process> processList = copyProcess(processes);
	    Result roundRobinResult = new Result("Round Robin Scheduling", currentTime, totalWaitingTime / n, progressOrder.substring(0, progressOrder.length() - 1),processList);
	    Lists.resultList.add(roundRobinResult);
	}
	public static List<Process> copyProcess(List<Process>list) {
		int len = list.size();
		int i = 0;
		List<Process>processList = new ArrayList<Process>();
		while(i < len) {
			Process temp = list.get(i);
			Process process = new Process(temp.getProcessName(),temp.getArrivalTime(),temp.getBurstTime(),temp.getPriority(),temp.getCompletionTime(),temp.getTurnAroundTime(),temp.getWaitingTime(),temp.getRemainingBurstTime());
			processList.add(process);
			i++;
		}
		
		return processList;
	}
}
