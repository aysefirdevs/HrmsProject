package kodlamaio.HrmsProject.api.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HrmsProject.business.abstracts.CurriculumVitaeService;
import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.core.utilities.results.Result;
import kodlamaio.HrmsProject.entities.concretes.CurriculumVitae;

@RestController
@RequestMapping("/api/curriculumVitaes")
@CrossOrigin
public class CurriculumVitaesController {
	
	private CurriculumVitaeService curriculumVitaeService;
	
	@Autowired
	public CurriculumVitaesController(CurriculumVitaeService curriculumVitaeService) {
		super();
		this.curriculumVitaeService = curriculumVitaeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CurriculumVitae>> getAll(){
		return this.curriculumVitaeService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CurriculumVitae curriculumVitae) {
		return this.curriculumVitaeService.add(curriculumVitae);
	}
	
	@GetMapping("/getByCandidate_id")
	public DataResult<CurriculumVitae> getByCandidate_id(int candidateId){
		return this.curriculumVitaeService.getByCandidate_id(candidateId);
	}
	
	@PostMapping("/imageUpload")
	public ResponseEntity<?> imageUpload(@RequestParam int curriculumVitaeId, @RequestParam MultipartFile multipartFile) throws IOException{
		return new ResponseEntity<>(this.curriculumVitaeService.imageUpload(curriculumVitaeId, multipartFile),HttpStatus.OK);
	}
}
