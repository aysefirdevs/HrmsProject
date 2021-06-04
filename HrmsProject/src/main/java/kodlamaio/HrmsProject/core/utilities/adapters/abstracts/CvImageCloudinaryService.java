package kodlamaio.HrmsProject.core.utilities.adapters.abstracts;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HrmsProject.core.utilities.results.DataResult;


public interface CvImageCloudinaryService {
	DataResult<Map> CVImageUpload(MultipartFile multipartFile) throws IOException;
	
}
