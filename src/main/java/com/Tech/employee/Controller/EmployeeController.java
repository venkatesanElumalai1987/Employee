package com.Tech.employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Tech.employee.Services.EmployeeServices;
import com.Tech.employee.entity.Employee;
import com.Tech.employee.exception.AgeNotEligibleException;
import com.Tech.employee.exception.NameNotCaseSensitiveException;
import com.Tech.employee.exception.NameNotPresentException;

@RestController
public class EmployeeController {
@Autowired
EmployeeServices empscr;
@Autowired
RestTemplate rt;
@GetMapping(value="/gethi")
public String getString()
{
	String url="http://localhost:8080/hi";
	ResponseEntity<String>s=rt.exchange(url,HttpMethod.GET,null,String.class );
	String x=s.getBody();
	return x.toUpperCase();
}
@PostMapping(value="/insertEmployee")
public String addEmployee(@RequestBody Employee e)
{
	return empscr.addEmployee(e);
}
@PostMapping(value="/insertAllEmployees")
public String addAllEmployees(@RequestBody List<Employee>c)
{
	return empscr.addAllEmployees(c);
}
@GetMapping(value="/findEmpId/{empid}")
public Employee findEmployeeId(@PathVariable Integer empid)
{
	return empscr.findEmployeeId(empid);
}

@GetMapping(value="/findallEmpId")
public List<Employee> findAllEmployeeId()
{
	return empscr.findAllEmployeeId();
}
@DeleteMapping(value="/deleteEmpId/{empid}")
public String deleteEmployeeId(@PathVariable Integer empid)
{
	return empscr.deleteEmployeeId(empid);
}
@PutMapping(value="/updateEmpId/{empid}")
public String updateEmployeeId(@RequestBody Employee empid)//request body passes the object as parameter
{
	return empscr.updateEmployeeId(empid);
}
@GetMapping(value="/highsalariedEmpName")
public Employee getHighSalariedEmployee()
{
	return empscr.getHighSalariedEmployee();
}
@GetMapping(value="/getname/{name}")
public List<Employee> getEmployeeName(@PathVariable String name) throws NameNotPresentException,Exception
{
	return empscr.getEmployeeName(name);
}
@PostMapping(value="/insert18Above")
public String addEligibleEmployee(@RequestBody Employee e) throws AgeNotEligibleException,Exception
{
return empscr.addEligibleEmployee(e);
}
@GetMapping(value="/getbetween")
public List<Employee> getBetweenRange(@RequestParam Integer salary1,@RequestParam Integer salary2)
{
	return empscr.getBetweenRange(salary1, salary2);
}
@GetMapping(value="/minimumSalary")
public Employee getMinimumSalaried()
{
	return empscr.getMinimumSalaried();
}
@GetMapping(value="/getbyAge")
public Employee getByAge(@RequestParam Integer age)
{
	return empscr.getByAge(age);
}
@GetMapping(value="/getbyAage")
public List<Employee> getByAAge(@RequestParam Integer age)
{
 return empscr.getByAAge(age);
}
@GetMapping(value="/getbyNames/{name}")
public List<Employee> getByNames(@PathVariable String name)
{
	return empscr.getByNames(name);
}
@GetMapping(value="/getbygender")
public List<Employee> getByGender(@RequestParam String gender)
{
	return empscr.getByGender(gender);
}
@GetMapping(value="/getbyAllSalary")
public List<Employee> getByAllSalary(@RequestParam Integer salary1,Integer salary2)
{
	return empscr.getByAllSalary(salary1, salary2);
}
@GetMapping(value="/getSenior")
public String getSeniorEmployee()
{
	return empscr.getSeniorEmployee();
}
@GetMapping(value="/getJunior")
public Integer getJuniorEmployee()
{
	return empscr.getJuniorEmployee();
}
@PostMapping(value="/capitalLetter")
public String caseSensitive(@RequestBody Employee emp) throws NameNotCaseSensitiveException,Exception
{
	return empscr.caseSensitive(emp);
}




}
