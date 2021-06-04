package kodlamaio.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HrmsProject.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer>{

}
