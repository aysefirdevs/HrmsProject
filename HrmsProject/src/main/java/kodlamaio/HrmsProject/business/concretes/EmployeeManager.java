package kodlamaio.HrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HrmsProject.business.abstracts.EmployeeService;
import kodlamaio.HrmsProject.core.utilities.results.Result;
import kodlamaio.HrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.HrmsProject.dataAccess.abstracts.EmployeeDao;
import kodlamaio.HrmsProject.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{
	
	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}


	@Override
	public Result add(Employee employee) {
		this.employeeDao.save(employee);
		return new SuccessResult("hrms personeli eklendi.");
	}

}
