package kodlamaio.HrmsProject.business.abstracts;

import java.util.List;

import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.core.utilities.results.Result;
import kodlamaio.HrmsProject.entities.concretes.ForeignLanguage;

public interface ForeignLanguageService {
	DataResult<List<ForeignLanguage>> getAll();
	Result add(ForeignLanguage foreignLanguage);
}
