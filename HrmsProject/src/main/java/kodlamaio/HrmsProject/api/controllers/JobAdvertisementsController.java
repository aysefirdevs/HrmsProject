package kodlamaio.HrmsProject.api.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HrmsProject.business.abstracts.JobAdvertisementService;
import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.core.utilities.results.Result;
import kodlamaio.HrmsProject.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobAdvertisements")
@CrossOrigin
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@PostMapping("/update")
	public Result update(int id) {
		return this.jobAdvertisementService.update(id);
	}
	
	@GetMapping("/getAllOpenJobAdvertisementList")
	public DataResult<List<JobAdvertisement>> getAllOpenJobAdvertisementList(){
		return this.jobAdvertisementService.getAllOpenJobAdvertisementList();
	}
	
	@GetMapping("/getByEmployerIdAndIsActive")
	public DataResult<List<JobAdvertisement>> getByEmployerIdAndIsActive(@RequestParam int id, @RequestParam boolean result){
		return this.jobAdvertisementService.getByEmployerIdAndIsActive(id,result);
	}
	
	@GetMapping("/getByIsActiveSorted")
	public DataResult<List<JobAdvertisement>> getByIsActiveSorted(){
		return this.jobAdvertisementService.getByIsActiveSorted();
	}

}
