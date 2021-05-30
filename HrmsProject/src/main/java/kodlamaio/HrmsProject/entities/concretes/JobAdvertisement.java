package kodlamaio.HrmsProject.entities.concretes;

import java.time.LocalDate;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		
		@ManyToOne()
		@JoinColumn(name="employer_id")
		private Employer employer;
		
		@ManyToOne()
		@JoinColumn(name="job_position_id")
		private JobPosition jobPosition;
		
		@Column(name="job_description")
		private String jobDescription;
		
		@Column(name="city")
		private String city;
		
		@Column(name="min_salary")
		private String minSalary;
		
		@Column(name="max_salary")
		private String maxSalary;
		
		@Column(name="open_position")
		private int openPosition;
		

		@Column(name="deadline")
		private LocalDate deadline;
		
	
		@Column(name="release_date")
		private LocalDate releaseDate;
		
		@Column(name="is_active")
		private boolean isActive;

}
