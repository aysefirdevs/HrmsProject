package kodlamaio.HrmsProject.core.utilities.adapters;

import kodlamaio.HrmsProject.entities.concretes.Candidate;

public interface CheckIfRealPersonService {
	boolean checkIfReal(Candidate candidate);
}
