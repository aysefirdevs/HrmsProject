package kodlamaio.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HrmsProject.business.abstracts.EmployerCheckService;
import kodlamaio.HrmsProject.business.abstracts.EmployerService;
import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.HrmsProject.core.utilities.results.Result;
import kodlamaio.HrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.HrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.HrmsProject.dataAccess.abstracts.EmployerDao;
import kodlamaio.HrmsProject.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
	
	private EmployerDao employerDao;
	private EmployerCheckService employerCheckService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,EmployerCheckService employerCheckService) {
		super();
		this.employerDao=employerDao;
		this.employerCheckService=employerCheckService;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>
		(this.employerDao.findAll(),"İş verenler listelendi.");
	}

	@Override
	public Result add(Employer employer) {
		if(!this.employerCheckService.checkIfMailExist(employer)) {
			return new ErrorResult("Email zaten var.");
		}
		else if(!this.employerCheckService.checkMailActivation()) {
			return new ErrorResult("Email aktive edilmemis. Lutfen e-postanızı kontrol edin.");
		}
		else if(!this.employerCheckService.checkIfMailDomain(employer)) {
			return new ErrorResult("web sitesi ile aynı domaine sahip e-posta girin.");
		}
		else if(!this.employerCheckService.checkRegisterActivationByEmployee()) {
			return new ErrorResult("Kayıt etkinleştirilmemis.Lutfen bekleyin.");
		}
		else {
			this.employerDao.save(employer);
			return new SuccessResult(employer.getCompanyName()+ " İş veren eklendi.");
		}
		
	}

}
