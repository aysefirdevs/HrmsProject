package kodlamaio.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.HrmsProject.business.abstracts.CandidateCheckService;
import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.HrmsProject.dataAccess.abstracts.CandidateDao;
import kodlamaio.HrmsProject.entities.concretes.Candidate;

@Service
public class CandidateCheckManager implements CandidateCheckService{
	
	private CandidateDao candidateDao;
	
	public CandidateCheckManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public boolean checkIfMailExist(Candidate candidate) {
		if(findByEmailIs(candidate.getEmail()).getData().size()!=0) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean checkIfIdentityExist(Candidate candidate) {
		if(findByIdentityNumberIs(candidate.getIdentificationNumber()).getData().size()!=0) {
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
	public DataResult<List<Candidate>> findByEmailIs(String email) {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findByEmailIs(email));
	}

	@Override
	public DataResult<List<Candidate>> findByIdentityNumberIs(String identificationNumber) {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findByIdentificationNumberIs(identificationNumber));
	}

}
