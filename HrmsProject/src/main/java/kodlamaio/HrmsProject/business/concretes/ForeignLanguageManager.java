package kodlamaio.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HrmsProject.business.abstracts.ForeignLanguageService;
import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.core.utilities.results.Result;
import kodlamaio.HrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.HrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.HrmsProject.dataAccess.abstracts.ForeignLanguageDao;
import kodlamaio.HrmsProject.entities.concretes.ForeignLanguage;

@Service
public class ForeignLanguageManager implements ForeignLanguageService{
	
	private ForeignLanguageDao foreignLanguageDao;
	
	@Autowired
	public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao) {
		super();
		this.foreignLanguageDao = foreignLanguageDao;
	}

	@Override
	public DataResult<List<ForeignLanguage>> getAll() {
		return new SuccessDataResult<List<ForeignLanguage>>(this.foreignLanguageDao.findAll(),"yabancı diller listelendi.");
	}

	@Override
	public Result add(ForeignLanguage foreignLanguage) {
		this.foreignLanguageDao.save(foreignLanguage);
		return new SuccessResult("yabancı dil eklendi.");
	}

}
