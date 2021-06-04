package kodlamaio.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HrmsProject.entities.concretes.CvImage;

public interface CvImageDao extends JpaRepository<CvImage, Integer> {

}
