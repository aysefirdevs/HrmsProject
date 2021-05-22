package kodlamaio.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HrmsProject.business.abstracts.JobPositionService;
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
	public List<JobPosition> findAll() {
		return this.jobPositionDao.findAll();
	}

	@Override
	public void save(JobPosition jobPosition) {
		this.jobPositionDao.save(jobPosition);
		
	}

}
