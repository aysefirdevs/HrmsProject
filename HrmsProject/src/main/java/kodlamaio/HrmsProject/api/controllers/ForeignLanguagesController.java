package kodlamaio.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HrmsProject.business.abstracts.ForeignLanguageService;
import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.core.utilities.results.Result;
import kodlamaio.HrmsProject.entities.concretes.ForeignLanguage;

@RestController
@RequestMapping("/api/foreignlanguages")
public class ForeignLanguagesController {
	private ForeignLanguageService foreignLanguageService;
	
	@Autowired
	public ForeignLanguagesController(ForeignLanguageService foreignLanguageService) {
		super();
		this.foreignLanguageService = foreignLanguageService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<ForeignLanguage>> getAll(){
		return this.foreignLanguageService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ForeignLanguage foreignLanguage) {
		return this.foreignLanguageService.add(foreignLanguage);
	}
}
