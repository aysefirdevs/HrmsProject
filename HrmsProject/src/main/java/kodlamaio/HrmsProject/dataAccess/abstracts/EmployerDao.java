package kodlamaio.HrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HrmsProject.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	List<Employer> findByEmailIs(String email);
}
