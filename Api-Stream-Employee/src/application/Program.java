package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter full file path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			List<Employee> employees = new ArrayList<>();

			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				System.out.printf("%s- %s %s",fields[0],fields[1],fields[2]);
				System.out.println();
				employees.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
				line = br.readLine();
			}

			System.out.print("Enter salary: ");
			double salary = sc.nextDouble();

			List<String> emailsSortedLex = employees.stream().filter(employee -> employee.getSalary() > salary)
					.map(Employee::getEmail).sorted().collect(Collectors.toList());

//			List<String> emails = list.stream().filter(x -> x.getSalary() > salary).map(x -> x.getEmail()).sorted()
//					.collect(Collectors.toList());

			System.out.println("Email of people whose salary is more than " + String.format("%.2f", salary) + ":");
			emailsSortedLex.forEach(System.out::println);

			double slariesSum = employees.stream().filter(empl -> empl.getName().startsWith("P"))
					.mapToDouble(Employee::getSalary).sum();

//			double sum = list.stream().filter(x -> x.getName().charAt(0) == 'M').map(x -> x.getSalary()).reduce(0.0,
//					(x, y) -> x + y);

			System.out.println(
					"Sum of salary from people whose name starts with 'P': " + String.format("%.2f", slariesSum));

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
	}
}
