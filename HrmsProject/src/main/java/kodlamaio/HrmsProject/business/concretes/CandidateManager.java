package kodlamaio.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HrmsProject.business.abstracts.CandidateCheckService;
import kodlamaio.HrmsProject.business.abstracts.CandidateService;
import kodlamaio.HrmsProject.core.utilities.adapters.abstracts.CheckIfRealPersonService;
import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.HrmsProject.core.utilities.results.Result;
import kodlamaio.HrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.HrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.HrmsProject.dataAccess.abstracts.CandidateDao;
import kodlamaio.HrmsProject.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{
	
	private CandidateDao candidateDao;	
	private CheckIfRealPersonService checkIfRealPersonService;
	private CandidateCheckService candidateCheckService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,CheckIfRealPersonService checkIfRealPersonService,CandidateCheckService candidateCheckService) {
		super();
		this.candidateDao=candidateDao;
		this.checkIfRealPersonService=checkIfRealPersonService;
		this.candidateCheckService=candidateCheckService;
	}
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>
		(this.candidateDao.findAll(),"iş arayanlar listelendi.");
	}

	@Override
	public Result add(Candidate candidate) {
		if(!this.checkIfRealPersonService.checkIfReal(candidate)) {
			return new ErrorResult("Gerçek biri değil.");
		}
		else if(!this.candidateCheckService.checkIfMailExist(candidate) ) {
			return new ErrorResult("Bu email zaten var.");	
		}
		else if(!this.candidateCheckService.checkMailActivation()) {
			return new ErrorResult("Email doğrulanmamış, lütfen e-postanızı kontrol edin.");
		}
		else {
			this.candidateDao.save(candidate);
			return new SuccessResult(candidate.getFirstName()+" kaydedildi.");
		}
	}

}
