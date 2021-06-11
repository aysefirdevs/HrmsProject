package kodlamaio.HrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HrmsProject.entities.concretes.Technology;

public interface TechnologyDao extends JpaRepository<Technology, Integer>{
	List<Technology> getByCurriculumVitae_id(int id);
}
