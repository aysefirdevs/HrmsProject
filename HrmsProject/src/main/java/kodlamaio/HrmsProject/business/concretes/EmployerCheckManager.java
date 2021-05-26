package kodlamaio.HrmsProject.business.concretes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.HrmsProject.business.abstracts.EmployerCheckService;
import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.HrmsProject.dataAccess.abstracts.EmployerDao;
import kodlamaio.HrmsProject.entities.concretes.Employer;

@Service
public class EmployerCheckManager implements EmployerCheckService {
	
	private EmployerDao employerDao;

	public EmployerCheckManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public boolean checkIfMailExist(Employer employer) {
		if(this.findByEmailIs(employer.getEmail()).getData().size()!=0) {
			return false;
		}
		else {
			return true;
		}
		
	}

	@Override
	public boolean checkMailActivation() {
		return true;
	}

	@Override
	public boolean checkRegisterActivationByEmployee() {
		return true;
	}

	@Override
	public DataResult<List<Employer>> findByEmailIs(String email) {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findByEmailIs(email));
	}

	@Override
	public boolean checkIfMailDomain(Employer employer) {
		String regex = "^[A-Za-z0-9._%+-]+@" + employer.getWebAddress() +"$";
		Pattern pattern= Pattern.compile(regex);
		Matcher matcher=pattern.matcher(employer.getEmail());
		if(matcher.matches()) {
			return true;
		}
		else {
			return false;
		}
		
	}

}
