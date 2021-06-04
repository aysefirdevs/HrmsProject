package kodlamaio.HrmsProject.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="curriculum_vitaes")
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumVitae {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="candidate_id") //tablo adı
	private Candidate candidate;
	
	@Column(name="github")
	private String github;
	
	@Column(name="linkedin")
	private String linkedin;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@Column(name = "profile_photo")
	private String profilePhoto;
	
	
	@OneToMany(mappedBy = "curriculumVitae") //field ismi
	private List<School> schools;
	
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<Experience> experiences;
	
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<ForeignLanguage> foreignLanguages;
	
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<Technology> technologies;
	
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<CvImage> cvImages;
}
