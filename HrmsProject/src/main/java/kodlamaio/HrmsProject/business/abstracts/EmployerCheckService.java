package kodlamaio.HrmsProject.business.abstracts;

import java.util.List;

import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.entities.concretes.Employer;

public interface EmployerCheckService {
	boolean checkIfMailExist (Employer employer);
	boolean checkMailActivation();
	boolean checkRegisterActivationByEmployee();
	DataResult<List<Employer>> findByEmailIs(String email);
	boolean checkIfMailDomain(Employer employer);
}
