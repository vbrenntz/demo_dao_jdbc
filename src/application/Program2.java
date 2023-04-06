package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;



public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		System.out.println("=== TEST 1 find by ID ===");
	    System.out.println("Insert ID: ");
		Department dep = departmentDao.findById(sc.nextInt());
		System.out.println(dep);
		
		

		System.out.println("\n === TEST 2 insert ===");
		System.out.println("Insert desired name: ");
		dep = new Department(null, sc.next());
		sc.nextLine();
		departmentDao.insert(dep);
		System.out.println("Done! New ID: " + dep.getId());
		
		System.out.println("\n === TEST 3 findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		
		}
		
		System.out.println("\n === TEST 4 update ===");
		System.out.println("Inform the ID of the desired department: ");
		Department department = departmentDao.findById(sc.nextInt());
		System.out.println("Inform the desired name: ");
        String name = sc.next();
		sc.nextLine();
        department.setName(name);
		departmentDao.update(department);
		System.out.println("Update completed");
		
		System.out.println("\n === TEST 5 delete ===");
		System.out.println("Enter ID: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete complete");

		sc.close();

	}

}
