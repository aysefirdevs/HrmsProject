package kodlamaio.HrmsProject.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.core.utilities.results.Result;
import kodlamaio.HrmsProject.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeService {
	DataResult<List<CurriculumVitae>> getAll();
	Result add(CurriculumVitae curriculumVitae);
	DataResult<CurriculumVitae> getByCandidate_id(int candidateId);
	
	DataResult<CurriculumVitae> imageUpload(int curriculumVitaeId, MultipartFile multipartFile) throws IOException;
}
