package kodlamaio.HrmsProject.entities.concretes;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="candidates")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","curriculumVitaes"})
public class Candidate extends User{
	
	@NotEmpty
	@Column(name="first_name")
	private String firstName;
	
	@NotEmpty
	@Column(name="last_name")
	private String lastName;
	
	@NotEmpty
	@Column(name="identification_number")
	private String identificationNumber;
	
	@NotEmpty
	@Column(name="birth_date")
	private int birthDate;
	
	@OneToMany(mappedBy = "candidate")  //bir adayın birden fazla cvsi olabilir.
	private List<CurriculumVitae> curriculumVitaes;
	
}
