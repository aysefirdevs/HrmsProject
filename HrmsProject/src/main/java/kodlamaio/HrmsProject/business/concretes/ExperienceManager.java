package kodlamaio.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HrmsProject.business.abstracts.ExperienceService;
import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.core.utilities.results.Result;
import kodlamaio.HrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.HrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.HrmsProject.dataAccess.abstracts.ExperienceDao;
import kodlamaio.HrmsProject.entities.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService{
	
	private ExperienceDao experienceDao;
	
	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		super();
		this.experienceDao = experienceDao;
	}

	@Override
	public DataResult<List<Experience>> getAll() {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.findAll(),"iş deneyimleri listelendi.");
	}

	@Override
	public Result add(Experience experience) {
		this.experienceDao.save(experience);
		return new SuccessResult("iş deneyimi eklendi");
	}

	@Override
	public DataResult<List<Experience>> getByCurriculumVitae_IdOrderByEndDateDesc(int curriculumVitaeId) {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.getByCurriculumVitae_IdOrderByEndDateDesc(curriculumVitaeId),"Deneyimler tarihe göre sıralandı.");
	}

}
