package com.example.OneToManyToManyLab;

import com.example.OneToManyToManyLab.models.department.Department;
import com.example.OneToManyToManyLab.models.employee.Employee;
import com.example.OneToManyToManyLab.models.project.Project;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.OneToManyToManyLab.repositories.DepartmentRepository;
import com.example.OneToManyToManyLab.repositories.EmployeeRepository;
import com.example.OneToManyToManyLab.repositories.ProjectRepository;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase
@SpringBootTest
class OneToManyToManyLabApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	void contextLoads() {
	}

//	@Test
//	public void canConnectEmployeeAndDepartment(){
//
//	}

//	@Test
//	public void canConnectEmployeeAndProject(){
//
//
//	}

	@Test
	public void testStuff(){
		Department dept1 = new Department("HR");
		departmentRepository.save(dept1);
		Employee employee1 = new Employee("Boring", "Bob", 32, dept1);
		employeeRepository.save(employee1);
		Project project1 = new Project("Phoenix", 7);
		projectRepository.save(project1);
		dept1.addEmployee(employee1);
		departmentRepository.save(dept1);
		Project project2 = new Project("SuperSecret", 14);
		project1.addEmployee(employee1);
		project2.addEmployee(employee1);
		projectRepository.save(project1);
		projectRepository.save(project2);
	}
}


