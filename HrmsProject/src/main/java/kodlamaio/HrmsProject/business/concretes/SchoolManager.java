package kodlamaio.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.HrmsProject.business.abstracts.SchoolService;
import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.core.utilities.results.Result;
import kodlamaio.HrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.HrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.HrmsProject.dataAccess.abstracts.SchoolDao;
import kodlamaio.HrmsProject.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService{
	
	private SchoolDao schoolDao;
	
	@Autowired 
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public DataResult<List<School>> getAll() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll(),"okullar listelendi.");
	}

	@Override
	public Result add(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("okul eklendi.");
	}

	@Override
	public DataResult<List<School>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"finishDate");
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll(sort));
	}
	
}
