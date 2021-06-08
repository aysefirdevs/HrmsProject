package kodlamaio.HrmsProject.business.concretes;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HrmsProject.business.abstracts.CurriculumVitaeService;
import kodlamaio.HrmsProject.core.utilities.adapters.abstracts.CvImageCloudinaryService;
import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.core.utilities.results.Result;
import kodlamaio.HrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.HrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.HrmsProject.dataAccess.abstracts.CurriculumVitaeDao;
import kodlamaio.HrmsProject.entities.concretes.CurriculumVitae;
import lombok.var;



@Service
public class CurriculumVitaeManager implements CurriculumVitaeService{

	private CurriculumVitaeDao curriculumVitaeDao;
	private CvImageCloudinaryService cvImageCloudinaryService;
	
	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao,CvImageCloudinaryService cvImageCloudinaryService) {
		super();
		this.curriculumVitaeDao = curriculumVitaeDao;
		this.cvImageCloudinaryService=cvImageCloudinaryService;
	}

	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findAll(),"cv listelendi.");
	}

	@Override
	public Result add(CurriculumVitae curriculumVitae) {
		this.curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult("cv eklendi.");
	}

	@Override
	public DataResult<CurriculumVitae> getByCandidate_id(int candidateId) {
		return new SuccessDataResult<CurriculumVitae>(this.curriculumVitaeDao.getByCandidate_id(candidateId),"Adaya ait cv listelendi.");
	}

	@Override
	public DataResult<CurriculumVitae> imageUpload(int curriculumVitaeId, MultipartFile multipartFile)
			throws IOException {
		CurriculumVitae curriculumVitae = this.curriculumVitaeDao.findById(curriculumVitaeId).get();
		var result= this.cvImageCloudinaryService.CVImageUpload(multipartFile);
		curriculumVitae.setProfilePhoto(result.getData().get("url").toString());
		this.curriculumVitaeDao.save(curriculumVitae);
		return new SuccessDataResult<>("Fotograf basariyla kaydedildi.");
	}

}
