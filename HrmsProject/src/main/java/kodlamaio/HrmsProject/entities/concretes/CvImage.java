package kodlamaio.HrmsProject.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="cv_images")
@AllArgsConstructor
@NoArgsConstructor
public class CvImage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "image_name")
	private String imageName;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="curriculum_vitae_id")
	private CurriculumVitae curriculumVitae;
}
