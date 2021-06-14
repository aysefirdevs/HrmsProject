package kodlamaio.HrmsProject.business.abstracts;

import kodlamaio.HrmsProject.core.utilities.results.Result;
import kodlamaio.HrmsProject.entities.concretes.Employee;

public interface EmployeeService {
	Result add(Employee employee);
}
