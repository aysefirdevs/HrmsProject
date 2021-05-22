package kodlamaio.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HrmsProject.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{
	
}
