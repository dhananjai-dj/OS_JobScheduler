# Process Scheduler Web Application

This web application is designed to simulate and visualize various operating system job scheduling algorithms. The project utilizes Java Servlets for server-side processing and Bootstrap for front-end design. The implemented algorithms include Shortest Job First (SJF), First Come First Serve (FCFS), Priority Scheduling, and Round Robin Scheduling.

## Project Structure

- Web Content
  - css
    - `styles.css`: Custom styles for the web pages.
  - images: Contains images used in the project.
  - META-INF: Contains the context.xml file for configuring the application's context.
  - WEB-INF
    - classes
      - `bean.Result`: JavaBean representing the result of a scheduling algorithm.
      - `bean.Process`: JavaBean representing details of a process.
    - lib: External JAR files.
  - `AlgorithmDetails.jsp`: Displays details of each process after scheduling.
  - `HomePage.jsp`: Home page where users input process details.
  - `ResultPage.jsp`: Displays the results of different scheduling algorithms.

- Java Resources
  - `Servlet1.java`: Handles the submission of process details from the home page.
  - `Servlet2.java`: Processes the submitted data and performs scheduling algorithms.
  - `Servlet3.java`: Displays detailed information about the scheduled processes.

## Running the Application

1. Clone the repository.
2. Import the project into your preferred Java IDE.
3. Configure the project to use a servlet container (e.g., Apache Tomcat).
4. Run the application on the configured servlet container.

## Usage

1. Open the application in a web browser.
2. On the home page (`HomePage.jsp`), enter the details of the processes, such as Process Name, Arrival Time, Burst Time, and Priority.
3. Click the "Add Process" button to add a process.
4. After adding all processes, click the "Schedule" button to execute the scheduling algorithms.
5. The results are displayed on the `ResultPage.jsp`, showing details for each scheduling algorithm.
6. Click the "Go" button to view detailed information about each process after scheduling on the `AlgorithmDetails.jsp` page.

## Scheduling Algorithms

- Shortest Job First (SJF):
  - Displays the process execution order, average waiting time, and total process completion time.

- First Come First Serve (FCFS):
  - Shows the process execution order, average waiting time, and total process completion time.

- Priority Scheduling:
  - Provides details on the process execution order, average waiting time, and total process completion time.

- Round Robin Scheduling:
  - Presents information about the process execution order, average waiting time, and total process completion time.

## Additional Notes

- The project uses Bootstrap for a responsive and visually appealing design.
- The background images enhance the overall aesthetic of the application.
- Process details and results are presented in a tabular format for clarity.



https://github.com/dhananjai-dj/OS_JobScheduler/assets/119773597/4e4423a8-b96b-43cd-990f-a5b38b136572

