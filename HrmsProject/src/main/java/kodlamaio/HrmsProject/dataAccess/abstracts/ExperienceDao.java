package kodlamaio.HrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HrmsProject.entities.concretes.Experience;

public interface ExperienceDao extends JpaRepository<Experience, Integer>{
	List<Experience> getByCurriculumVitae_IdOrderByEndDateDesc(int curriculumVitaeId);
}
