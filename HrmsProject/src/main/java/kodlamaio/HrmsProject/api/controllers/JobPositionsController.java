package kodlamaio.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HrmsProject.business.abstracts.JobPositionService;
import kodlamaio.HrmsProject.entities.concretes.JobPosition;

@RestController
@RequestMapping(path="/api/job-positions")
public class JobPositionsController {
	
	private JobPositionService jobPositionService;
	
	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}

	@GetMapping("/getall")
	public List<JobPosition> getAll(){
		return this.jobPositionService.findAll();
	}
}
