package kodlamaio.HrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HrmsProject.entities.concretes.ForeignLanguage;


public interface ForeignLanguageDao extends JpaRepository<ForeignLanguage, Integer>{
	List<ForeignLanguage> getByCurriculumVitae_id(int id);
}
