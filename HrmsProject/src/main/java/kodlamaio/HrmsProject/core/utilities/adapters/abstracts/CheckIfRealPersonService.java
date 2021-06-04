package kodlamaio.HrmsProject.core.utilities.adapters.abstracts;

import kodlamaio.HrmsProject.entities.concretes.Candidate;

public interface CheckIfRealPersonService {
	boolean checkIfReal(Candidate candidate);
}
