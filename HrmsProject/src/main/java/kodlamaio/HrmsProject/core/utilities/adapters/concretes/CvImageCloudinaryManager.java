package kodlamaio.HrmsProject.core.utilities.adapters.concretes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HrmsProject.core.utilities.adapters.abstracts.CvImageCloudinaryService;
import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.core.utilities.results.SuccessDataResult;

@Service
public class CvImageCloudinaryManager implements CvImageCloudinaryService{
	
	Cloudinary cloudinary;
	private Map<String,String> valuesMap= new HashMap<>();
	
	@Autowired
	public CvImageCloudinaryManager() {
		valuesMap.put("cloud_name", "dv1m8kclv");
		valuesMap.put("api_key", "457665496493666");
		valuesMap.put("api_secret", "N_SFs54CKZpaMbRxKb8Mc30Vy_A");
		cloudinary = new Cloudinary(valuesMap);
	}
	
	private File fileConvert(MultipartFile multipartFile) throws IOException{
		File file= new File(multipartFile.getOriginalFilename());
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		fileOutputStream.write(multipartFile.getBytes());
		fileOutputStream.close();
		return file;
	}
	
	@Override
	public DataResult<Map> CVImageUpload(MultipartFile multipartFile) throws IOException {
		File file= fileConvert(multipartFile);
		Map resultMap=cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		file.delete();
		return new SuccessDataResult<>(resultMap);
	}

}
