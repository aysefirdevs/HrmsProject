package kodlamaio.HrmsProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employers")
public class Employer extends User {
	
	@Column(name="company_name", nullable=false)
	private String companyName;
	
	@Column(name="web_address", nullable=false)
	private String webAddress;

	@Column(name="phone", nullable=false)
	private String phone;
}
