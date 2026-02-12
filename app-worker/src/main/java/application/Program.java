package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {
	public static void main(String[] args) throws ParseException {
	Locale.setDefault(Locale.US);
	Scanner scan = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
	
	
	System.out.println("Enter department's name:");
	String departmentName = scan.nextLine();
	
	System.out.println("Enter the worker data:");
	System.out.print("Name: ");
	String workerName = scan.nextLine();
	System.out.println("Options of WorkerLevel: ");
	for(WorkerLevel wl : WorkerLevel.values()){
	    System.out.println("\t" + wl);
	}
	System.out.print("Level: ");
	String workerLevel = scan.nextLine();
	System.out.print("Base Salary: ");
	double workerBaseSalary = scan.nextDouble();
	
	Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerBaseSalary, new Department(departmentName));
	
	System.out.println("How many contracts to this worker?");
	int n = scan.nextInt();
	scan.nextLine(); // consume 
	for (int i =  1; i <= n; i++){
		System.out.println("Enter the contract #" + i + " data:");
		System.out.println("Date (DD/MM/YYYY): ");
		Date contractDate = sdf.parse(scan.next());
		System.out.println("Value per hour: ");
		double valuePerHour = scan.nextDouble();
		System.out.println("Duration (hours): ");
		int hours = scan.nextInt();
		
		worker.addContract(new HourContract(contractDate, valuePerHour, hours));					
	}
	
	System.out.println();
	System.out.println("Enter month and year to calcate income (MM/YYYY): ");
	String monthAndYear = scan.next();
	int month = Integer.parseInt(monthAndYear.substring(0, 2));
	int year = Integer.parseInt(monthAndYear.substring(3));
	System.out.println("Name: " + worker.getName());
	System.out.println("Department: " + worker.getDepartment().getName());
	System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(month, year)));
				
	scan.close();	
	}
}