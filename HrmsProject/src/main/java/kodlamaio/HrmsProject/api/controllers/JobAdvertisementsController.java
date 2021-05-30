package kodlamaio.HrmsProject.api.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/getByIsOpenAndReleaseDate")
	public DataResult<List<JobAdvertisement>> getByIsOpenAndReleaseDate(@RequestParam LocalDate releaseDate){
		return this.jobAdvertisementService.getByIsOpenAndReleaseDate(releaseDate);
	}

}
