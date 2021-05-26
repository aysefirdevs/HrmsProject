package kodlamaio.HrmsProject.business.abstracts;

import java.util.List;


import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.core.utilities.results.Result;
import kodlamaio.HrmsProject.entities.concretes.Employer;


public interface EmployerService {
	DataResult<List<Employer>> getAll();
	Result add(Employer employer);
}
