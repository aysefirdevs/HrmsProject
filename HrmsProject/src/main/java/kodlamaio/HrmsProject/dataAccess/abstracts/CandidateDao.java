package kodlamaio.HrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HrmsProject.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	List<Candidate> findByEmailIs(String email);
	List<Candidate> findByIdentificationNumberIs(String identificationNumber);
}
