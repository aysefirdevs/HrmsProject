package kodlamaio.HrmsProject.business.abstracts;

import java.util.List;

import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.entities.concretes.Candidate;

public interface CandidateCheckService {
	boolean checkIfMailExist(Candidate candidate);
	boolean checkIfIdentityExist(Candidate candidate);
	boolean checkMailActivation();
	DataResult<List<Candidate>> findByEmailIs(String email);
	DataResult<List<Candidate>> findByIdentityNumberIs(String identificationNumber);
}
