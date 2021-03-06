package kodlamaio.HrmsProject.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.HrmsProject.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	
	@Query("From JobAdvertisement where isActive = true")
	List<JobAdvertisement> getAllOpenJobAdvertisementList();
	
	@Query("From JobAdvertisement WHERE is_active=true ORDER BY deadline ASC")
	List<JobAdvertisement> getByIsActiveSorted();
	
	List<JobAdvertisement> getByEmployerIdAndIsActive(int id,boolean isActive);
}
