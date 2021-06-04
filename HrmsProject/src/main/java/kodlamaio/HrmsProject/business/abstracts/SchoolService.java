package kodlamaio.HrmsProject.business.abstracts;

import java.util.List;

import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.core.utilities.results.Result;
import kodlamaio.HrmsProject.entities.concretes.School;

public interface SchoolService {
	DataResult<List<School>> getAll();
	Result add(School school);
	DataResult<List<School>> getAllSorted();
}
