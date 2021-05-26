package kodlamaio.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HrmsProject.business.abstracts.JobPositionService;
import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.HrmsProject.core.utilities.results.Result;
import kodlamaio.HrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.HrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.HrmsProject.dataAccess.abstracts.JobPositionDao;
import kodlamaio.HrmsProject.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll(){
		return new SuccessDataResult<List<JobPosition>>
		(this.jobPositionDao.findAll(), "İş pozisyonları listelendi.");
				
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if(check(jobPosition)) {
			this.jobPositionDao.save(jobPosition);
			return new SuccessResult("Pozisyon eklendi.");
		}
		return new ErrorResult("Eklenemedi. Lütfen daha önceden girilmeyen bir pozisyon girin.");
	}
	
	private boolean check(JobPosition job) {
		List<JobPosition> result=jobPositionDao.findAll();
		for(JobPosition jobPosition : result) {
			if(jobPosition.getTitle().equals(job.getTitle())) {
				return false;
			}
		}
		return true;
	}
	



}
