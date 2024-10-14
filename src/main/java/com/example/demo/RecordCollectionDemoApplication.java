package com.example.demo;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeDao;
import com.example.demo.service.Record;
import com.example.demo.service.RecordSequence;

import jakarta.annotation.PostConstruct;

@SpringBootApplication

@Component

public class RecordCollectionDemoApplication {

	@Autowired

	EmployeeDao empDao;

	@PostConstruct
	public void prsistRecord() throws Exception {

		System.out.println("==========Menu=============");
		System.out.println("1. Add");
		System.out.println("2 Remove");
		System.out.println("3 Get by Entity");
		System.out.println("4.GetAll by Entity");
		System.out.println("5. Remove All");
		System.out.println(">5. Exit");
		System.out.println("=======================");

		

		Record record1 = new RecordSequence<>();

		Scanner scanner = new Scanner(System.in);

		System.out.println("Select operation=");
		String i = scanner.nextLine();

		while (i.equals("1") || i.equals("2") || i.equals("3") || i.equals("4") ||

				i.equals("5")) {
			switch (i) {

			case "1": {
				System.out.println("Enter elements with comma separated to addin Record object=");

				scanner = new Scanner(System.in);

				String e = scanner.nextLine();

				String s[] = e.split(",");

				for (int j = 0; j < s.length; j++) {

					record1.add(s[j]);
				}

				System.out.println("Size of record=" + record1.size());
				for (int j = 0; j < record1.size(); j++) {

					System.out.println("Elements in Record=" + record1.getByIndex(j));
				}
				break;
			}

			case "2": {

				System.out.println("Enter element you want to remove=");

				scanner = new Scanner(System.in);
				String e = scanner.nextLine();

				record1.remove(e);

				System.out.println("Size of record=" + record1.size());

				for (int j = 0; j < record1.size(); j++) {

					System.out.println("Elements in Record=" + record1.getByIndex(j));
				}

				break;
			}

			case "3": {

				System.out.println("Enter element you want to see=");

				scanner = new Scanner(System.in);

				String e = scanner.nextLine();

				System.out.println("Elements in Record=" + (String) record1.get(e));
				break;
			}

			case "4": {

				System.out.println("Enter element you want to see all=");

				scanner = new Scanner(System.in);
				String e = scanner.nextLine();

				Record<String> obj = record1.getAll(e);
				for (int j = 0; j < obj.size(); j++) {

					System.out.println(obj.getByIndex(j));
				}

				break;
			}

			case "5": {

				System.out.println("Remove all element");

				record1.removeAll();

				System.out.println("After removal size of record=" + record1.size());

				break;
			}
			}

			System.out.println("=================================");

			scanner = new Scanner(System.in); // Create a Scanner object ");

			System.out.println("Select operation=");

			i = scanner.nextLine();
		}

		RecordSequence<Employee> record = new RecordSequence<Employee>();

		System.out.println("============================");
		System.out.println("1.Add employee");

		System.out.println("2. Remove");

		System.out.println("3.Persist");

		System.out.println("4.show employee from DB");

		scanner = new Scanner(System.in); // Create a Scanner object

		System.out.println("Select operation=");

		i = scanner.nextLine();

		while (i.equals("1") || i.equals("2") || i.equals("3") || i.equals("4")) {

			switch (i) {

			case "1": {
				System.out.println("Enter employee info(id,name, department, salary) [comma separated]");

				scanner = new Scanner(System.in);

				String e = scanner.nextLine();

				String s[] = e.split(",");

				Employee x = new Employee();

				x.setId(Integer.parseInt(s[0]));

				x.setName(s[1]);

				x.setDepartment(s[2]);

				x.setSalary(Integer.parseInt(s[3]));

				record.add(x);

				System.out.println("Size of record=" + record.size());

				for (int j = 0; j < record.size(); j++) {

					System.out.println("Elements in Record=" + record.getByIndex(j));
				}

				break;
			}

			case "3": {

				int noofRowsInserted = empDao.persist(record);

				System.out.println("noOfRowsInserted=" + noofRowsInserted);
				record = new RecordSequence<Employee>();

				break;
			}
			case "4": {

				empDao.showAll();

				break;
			}

			case "2": {

				System.out.println("Enter employee you want to remove=");

				System.out.println("Enter employee you want to remove=");

				scanner = new Scanner(System.in);

				String e = scanner.nextLine();

				String s[] = e.split(",");

				Employee x = new Employee();

				x.setId(Integer.parseInt(s[0]));

				x.setName(s[1]);

				x.setDepartment(s[2]);

				x.setSalary(Integer.parseInt(s[3]));

				record.remove(x);

				System.out.println("Size of record=" + record.size());
				for (int j = 0; j < record.size(); j++) {

					System.out.println("Elements in Record=" + record.getByIndex(j));
				}

				break;
			}
			}

			System.out.println("=================================");

			scanner = new Scanner(System.in); // Create a Scanner object

			System.out.println("Select operation=");

			i = scanner.nextLine();
		}

	}

	public static void main(String[] args) throws Exception {

		SpringApplication.run(RecordCollectionDemoApplication.class, args);
	}
}
