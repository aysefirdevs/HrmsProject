package kodlamaio.HrmsProject.business.concretes;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HrmsProject.business.abstracts.JobAdvertisementService;
import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.core.utilities.results.Result;
import kodlamaio.HrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.HrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.HrmsProject.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.HrmsProject.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	
	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findAll(),"Tüm iş ilanları listelendi.");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("iş ilanı eklendi.");
	}
	
	@Override
	public Result update(int id) {
		JobAdvertisement jobAdvertisement = getById(id).getData();
		jobAdvertisement.setActive(false);
		add(jobAdvertisement);
		return new SuccessResult("İş ilanı güncellendi");
	}

	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		return new SuccessDataResult<JobAdvertisement>
		(this.jobAdvertisementDao.getOne(id));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllOpenJobAdvertisementList() {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.getAllOpenJobAdvertisementList());
	}


	@Override
	public DataResult<List<JobAdvertisement>> getByEmployerIdAndIsActive(int id,boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.getByEmployerIdAndIsActive(id, isActive),
				"firmaya ait tüm aktif iş ilanları listlendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveSorted() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveSorted());
	}


	

	
	
	

}
