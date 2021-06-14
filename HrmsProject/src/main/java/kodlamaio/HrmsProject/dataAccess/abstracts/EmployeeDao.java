package kodlamaio.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HrmsProject.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
