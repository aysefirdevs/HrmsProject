package kodlamaio.HrmsProject.business.abstracts;

import java.util.List;

import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.core.utilities.results.Result;
import kodlamaio.HrmsProject.entities.concretes.Technology;

public interface TechnologyService {
	DataResult<List<Technology>> getAll();
	Result add(Technology technology);
	DataResult<List<Technology>> getByCurriculumVitae_id(int id);
}
