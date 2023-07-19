package com.Tech.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Tech.employee.entity.Employee;
import com.Tech.employee.repository.EmployeeRepository;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository empRepo;
	public String addEmployee(Employee e)
	{
		empRepo.save(e);
		return "Successfully Saved";
	}
	public String addAllEmployees(List<Employee>c)
	{
		empRepo.saveAll(c);
		return "Successfully saved the List of Employee";
	}
	public Employee findEmployeeId( Integer empid)
	{
		return empRepo.findById(empid).get();
	}
	public List<Employee> findAllEmployeeId( )
	{
		return empRepo.findAll();
	}
	public String deleteEmployeeId(Integer empid)
	{
		empRepo.deleteById(empid);
		return "Employee Id is Removed from Database";
	}
	public String updateEmployeeId(Employee empid)
	{
		empRepo.save(empid);
		return "The Data Updated Successfully";
	}
	public String addEligibleEmployee(Employee e)
	{
		empRepo.save(e);
		return "Hi!Welcome to OneSoftTechnologies";
	}
	public List<Employee> getByNames(String name)
	{
		return empRepo.getByNames(name);
	}
	public List<Employee> getByGender(String gender)
	{
		return empRepo.getByGender(gender);
	}
	public List<Employee> getByAllSalary(Integer salary1,Integer salary2)
	{
		return empRepo.getByAllSalary(salary1,salary2);
	}
	public String getSeniorEmployee()
	{
		return empRepo.getSeniorEmployee();
	}
	public Integer getJuniorEmployee()
	{
		return empRepo.getJuniorEmployee();
	}
	public String caseSensitive(Employee emp)
	{
		empRepo.save(emp);
		return "Succesfully Saved";
	}

	
	
	
	
}
