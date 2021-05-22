package kodlamaio.HrmsProject.business.abstracts;

import java.util.List;

import kodlamaio.HrmsProject.entities.concretes.JobPosition;

public interface JobPositionService {
	List<JobPosition> findAll();
	void save(JobPosition jobPosition);
}
