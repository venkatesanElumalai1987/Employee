package com.Tech.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Tech.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query(value="select * from employees_details where age>=?",nativeQuery=true)
	public List<Employee> getByAAge(int age);
	@Query(value="select * from employees_details where name like ?",nativeQuery=true)
	public List<Employee> getByNames(String name);
	@Query(value="select * from employees_details where gender like ?",nativeQuery=true)
	public List<Employee> getByGender(String gender);
	@Query(value="select * from employees_details where salary>= ? and salary<=? ",nativeQuery=true)
	public List<Employee> getByAllSalary(Integer salary1,Integer salary2);
	@Query(value="Select name from employees_details where id=(Select min(id) from employees_details)",nativeQuery=true)
	public String getSeniorEmployee();
	@Query(value="Select id from employees_details where id=(Select max(id) from employees_details)",nativeQuery=true)
	public Integer getJuniorEmployee();
	

}
