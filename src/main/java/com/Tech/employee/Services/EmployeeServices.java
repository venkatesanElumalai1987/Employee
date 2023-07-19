package com.Tech.employee.Services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Tech.employee.dao.EmployeeDao;
import com.Tech.employee.entity.Employee;
import com.Tech.employee.exception.AgeNotEligibleException;
import com.Tech.employee.exception.EmployeeGlobalExceptionHandler;
import com.Tech.employee.exception.NameNotCaseSensitiveException;
import com.Tech.employee.exception.NameNotPresentException;

@Service
public class EmployeeServices {
	
@Autowired
EmployeeDao empDao;
public String addEmployee(Employee e)
{
	return empDao.addEmployee(e);
}
public String addAllEmployees(List<Employee>c)
{
	return empDao.addAllEmployees(c);
}
public Employee findEmployeeId( Integer empid)
{
	return empDao.findEmployeeId(empid);
}
public List<Employee> findAllEmployeeId( )
{
	return empDao.findAllEmployeeId();
}
public String deleteEmployeeId(Integer empid)
{
	return empDao.deleteEmployeeId(empid);
}
public String updateEmployeeId( Employee empid)
{
	return empDao.updateEmployeeId(empid);
}
public Employee getHighSalariedEmployee()
{
	List<Employee> allEmp=empDao.findAllEmployeeId();//intha object we call the findAllEmployee it will return value
	Employee max=allEmp.stream().max(Comparator.comparing(Employee::getSalary)).get();
	return max;
}
public List<Employee> getEmployeeName(String name) throws NameNotPresentException,Exception
{
	/*return empDao.findAllEmployeeId().stream().filter(x->x.getName().equals(name)).collect(Collectors.toList());*/
	
	
		List<Employee>allemp=empDao.findAllEmployeeId().stream().filter(x->x.getName().equals(name)).collect(Collectors.toList());
	if(allemp.isEmpty())
	{
		throw new NameNotPresentException("Given name is Not in the Company Database");
			}
	else {
		return allemp;
	}
	}
	/*catch (Exception em) {
		return em.*/
	

public String addEligibleEmployee(Employee e) throws AgeNotEligibleException,Exception
{
	/*if(e.getAge()>=18)
	{
		return empDao.addEligibleEmployee(e);
	} 
	else
	{
		return "Come after attaining the Age of 18";
	}*/try
	{
	if(e.getAge()<18)
	{
		throw new AgeNotEligibleException("Please Enter Valid Age");
	}
	else {
		return empDao.addEligibleEmployee(e);
	}
	}
	catch(Exception ex)
	{
		return ex.getMessage();
	}
	
}
public List<Employee> getBetweenRange(Integer salary1,Integer salary2)
{


		return empDao.findAllEmployeeId().stream().filter(x->x.getSalary()>salary1&&x.getSalary()<salary2).collect(Collectors.toList());

}

public Employee getMinimumSalaried()
{
	List<Employee>x=empDao.findAllEmployeeId();
	/*Employee min=*/
	return x.stream().min(Comparator.comparing(Employee::getSalary)).get();
	/*return min;*/
}
public Employee getByAge(Integer age)
{
	return empDao.findAllEmployeeId().stream().filter(x->x.getAge()>=age).collect(Collectors.toList()).get(0);
}
public List<Employee> getByAAge(Integer age)
{
	return empDao.findAllEmployeeId().stream().filter(x->x.getAge()>=age).collect(Collectors.toList());
}
public List<Employee> getByNames(String name)
{
	return empDao.getByNames(name);
}
public List<Employee> getByGender(String gender)
{
	return empDao.getByGender(gender);
}
public List<Employee> getByAllSalary(Integer salary1, Integer salary2)
{
	return empDao.getByAllSalary(salary1,salary2);
}
public String getSeniorEmployee()
{
	return empDao.getSeniorEmployee();
}
public Integer getJuniorEmployee()
{
	return empDao.getJuniorEmployee();
}
public String caseSensitive(Employee emp)throws NameNotCaseSensitiveException,Exception
{
	if((emp.getName().charAt(0)>='A')&&(emp.getName().charAt(0)<='Z'))
	{
		return empDao.caseSensitive(emp);
	}
	else
	{
		throw new NameNotCaseSensitiveException("Name is Starts with Capital Letter");
	}}



}
