package kodlamaio.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HrmsProject.entities.concretes.Technology;

public interface TechnologyDao extends JpaRepository<Technology, Integer>{

}
