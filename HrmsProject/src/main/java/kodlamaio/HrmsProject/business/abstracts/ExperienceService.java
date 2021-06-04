package kodlamaio.HrmsProject.business.abstracts;

import java.util.List;

import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.core.utilities.results.Result;

import kodlamaio.HrmsProject.entities.concretes.Experience;

public interface ExperienceService {
	DataResult<List<Experience>> getAll();
	Result add(Experience experience);
	DataResult<List<Experience>> getByCurriculumVitae_IdOrderByEndDateDesc(int curriculumVitaeId);
}
