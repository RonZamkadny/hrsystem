package hr;

import com.ronx.hr.controller.EmployeeController;
import com.ronx.hr.model.Employee;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;

public class TestSpringRestExample {

	public static final String SERVER_URI = "http://localhost:8080/employee";
	
	public static void main(String args[]) throws ParseException {
		
		System.out.println("*****");
		testCreateEmployee();
		System.out.println("*****");
		testGetEmployee();
		System.out.println("*****");
		testGetAllEmployee();
	}

	private static void testGetAllEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		//we can't get List<Employee> because JSON convertor doesn't know the type of
		//object in the list and hence convert it to default JSON object type LinkedHashMap
		List<LinkedHashMap> emps = restTemplate.getForObject(SERVER_URI + EmployeeController.GET_ALL_EMP, List.class);
		System.out.println(emps.size());
		for(LinkedHashMap map : emps){
			System.out.println("ID="+map.get("id")+",Name="+map.get("name")+",CreatedDate="+map.get("createdDate"));;
		}
	}

	private static void testCreateEmployee() throws ParseException {
		RestTemplate restTemplate = new RestTemplate();
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy, MM, dd");
		Employee employee;
		{
			employee = new Employee();
			employee.setId(1L);
			employee.setLastName("Zamkadny");
			employee.setFirstName("Ron");
			employee.setDateOfBirth(sdf.parse("1987, 07, 23"));
			employee.setDateOfHire(sdf.parse("2015, 05, 25"));
			employee.setSalary(new BigDecimal("3000"));
		}

		restTemplate.postForObject(SERVER_URI + EmployeeController.CREATE_EMP, employee, Void.class);
	}

	private static void testGetEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		Employee employee = restTemplate.getForObject(SERVER_URI + "/get/" + 1, Employee.class);
		System.out.println(employee);
	}

}
