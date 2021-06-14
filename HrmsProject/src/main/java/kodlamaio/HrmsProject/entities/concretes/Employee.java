package kodlamaio.HrmsProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name="employees")
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends User{
	
	@NotEmpty
	@Column(name="first_name")
	private String firstName;
	
	@NotEmpty
	@Column(name="last_name")
	private String lastName;
}
