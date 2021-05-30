package kodlamaio.HrmsProject.business.abstracts;


import java.time.LocalDate;
import java.util.List;

import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.core.utilities.results.Result;
import kodlamaio.HrmsProject.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	DataResult<List<JobAdvertisement>> getAll();
	
	Result add(JobAdvertisement jobAdvertisement);
	
	Result update(int id);
	
	DataResult<JobAdvertisement> getById(int id);
	
	DataResult<List<JobAdvertisement>> getAllOpenJobAdvertisementList();
	
	
	DataResult<List<JobAdvertisement>> getByEmployerIdAndIsActive(int id,boolean isActive);
	
	DataResult<List<JobAdvertisement>> getByIsActiveSorted();
	
}
