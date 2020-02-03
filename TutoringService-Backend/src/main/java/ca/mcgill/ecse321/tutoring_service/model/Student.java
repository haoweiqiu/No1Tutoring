package ca.mcgill.ecse321.tutoring_service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.Id;

@Entity
public class Student {
	private School school;

	@ManyToOne(optional = true)
	public School getSchool() {
		return this.school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	private int year;

	public void setYear(int value) {
		this.year = value;
	}

	public int getYear() {
		return this.year;
	}

	private Set<Registration> registration;

	@OneToMany(mappedBy = "student")
	public Set<Registration> getRegistration() {
		return this.registration;
	}

	public void setRegistration(Set<Registration> registrations) {
		this.registration = registrations;
	}

	private String name;

	public void setName(String value) {
		this.name = value;
	}

	public String getName() {
		return this.name;
	}

	private String email;

	public void setEmail(String value) {
		this.email = value;
	}

	public String getEmail() {
		return this.email;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int id;

	private String password;

	public void setPassword(String value) {
		this.password = value;
	}

	public String getPassword() {
		return this.password;
	}
}
